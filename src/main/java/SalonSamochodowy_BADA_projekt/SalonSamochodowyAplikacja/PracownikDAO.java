package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PracownikDAO {

    private final JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list(){
        String sql = "SELECT p.*, s.*, ss.*, po.*, a.* " +
                "FROM \"Pracownicy\" p " +
                "JOIN \"Stanowiska\" s ON p.\"id_stanowiska\" = s.\"id_stanowiska\" " +
                "JOIN \"Adresy\" a ON p.\"id_adres\" = a.\"id_adres\" " +
                "JOIN \"Salony_samochodowe\" ss ON p.\"id_salon_samochodowy\" = ss.\"id_salon_samochodowy\" " +
                "JOIN \"Poczty\" po ON a.\"id_poczta\" = po.\"id_poczta\"";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Pracownik pracownik = new Pracownik();
            pracownik.setId_pracownik(rs.getInt("id_pracownik"));
            pracownik.setImie(rs.getString("imie"));
            pracownik.setNazwisko(rs.getString("nazwisko"));
            pracownik.setPesel(rs.getString("pesel"));
            pracownik.setWynagrodzenie(rs.getFloat("wynagrodzenie"));
            pracownik.setNumer_telefonu(rs.getString("numer_telefonu"));
            pracownik.setData_zatrudnienia(rs.getDate("data_zatrudnienia").toLocalDate());
            pracownik.setData_zwolnienia(rs.getDate("data_zwolnienia").toLocalDate());
            pracownik.setEmail(rs.getString("email"));
            pracownik.setId_salon_samochodowy(rs.getInt("id_salon_samochodowy"));
            pracownik.setId_stanowiska(rs.getInt("id_stanowiska"));
            pracownik.setId_adres(rs.getInt("id_adres"));

            Stanowisko stanowisko = new Stanowisko();
            stanowisko.setId_stanowiska(rs.getInt("id_stanowiska"));
            stanowisko.setNazwa_stanowiska(rs.getString("nazwa_stanowiska"));

            Salon_samochodowy salon = new Salon_samochodowy();
            salon.setNazwa(rs.getString("nazwa"));

            Adres adres = new Adres();
            adres.setId_adres(rs.getInt("id_adres"));
            adres.setMiejscowosc(rs.getString("miejscowosc"));
            adres.setUlica(rs.getString("ulica"));
            adres.setNr_lokalu(rs.getString("nr_lokalu"));
            adres.setKod_poczty(rs.getString("kod_poczty"));
            adres.setPoczta(rs.getString("poczta"));

            pracownik.setSalon_samochodowy(salon);
            pracownik.setStanowisko(stanowisko);
            pracownik.setAdres(adres);

            return pracownik;
        });

        /*String sql = "SELECT * FROM \"Pracownicy\"";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return listPracownik;*/
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
        // Step 1: Insert Adres and retrieve generated key
        SimpleJdbcInsert insertAdres = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Adresy\"")
                .usingColumns("\"miejscowosc\"", "\"ulica\"", "\"nr_lokalu\"", "\"id_poczta\"")
                .usingGeneratedKeyColumns("\"id_adres\"");

        // Create parameters map for Adres
        Map<String, Object> adresParameters = new HashMap<>();
        adresParameters.put("\"miejscowosc\"", pracownik.getAdres().getMiejscowosc());
        adresParameters.put("\"ulica\"", pracownik.getAdres().getUlica());
        adresParameters.put("\"nr_lokalu\"", pracownik.getAdres().getNr_lokalu());
        adresParameters.put("\"id_poczta\"", pracownik.getAdres().getId_poczta());

        Number idAdres = insertAdres.executeAndReturnKey(adresParameters);

        // Set the generated key back to the Adres object
        pracownik.getAdres().setId_adres(idAdres.intValue());

        // Step 2: Insert Pracownik using the generated Adres key
        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Pracownicy\"")
                .usingColumns("\"imie\"", "\"nazwisko\"", "\"pesel\"", "\"wynagrodzenie\"", "\"numer_telefonu\"", "\"data_zatrudnienia\"", "\"data_zwolnienia\"", "\"email\"", "\"id_salon_samochodowy\"", "\"id_stanowiska\"", "\"id_adres\"");

        // Create parameters map for Pracownik
        Map<String, Object> pracownikParameters = new HashMap<>();
        pracownikParameters.put("\"imie\"", pracownik.getImie());
        pracownikParameters.put("\"nazwisko\"", pracownik.getNazwisko());
        pracownikParameters.put("\"pesel\"", pracownik.getPesel());
        pracownikParameters.put("\"wynagrodzenie\"", pracownik.getWynagrodzenie());
        pracownikParameters.put("\"numer_telefonu\"", pracownik.getNumer_telefonu());
        pracownikParameters.put("\"data_zatrudnienia\"", pracownik.getData_zatrudnienia());
        pracownikParameters.put("\"data_zwolnienia\"", pracownik.getData_zwolnienia());
        pracownikParameters.put("\"email\"", pracownik.getEmail());
        pracownikParameters.put("\"id_salon_samochodowy\"", pracownik.getId_salon_samochodowy());
        pracownikParameters.put("\"id_stanowiska\"", pracownik.getId_stanowiska());
        pracownikParameters.put("\"id_adres\"", idAdres);

        insertSalon.execute(pracownikParameters);

    }

    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
