package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Salon_samochodowyDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Salon_samochodowyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Salon_samochodowy> list() {
        String sql = "SELECT ss.*, a.*, p.* " +
                "FROM \"Salony_samochodowe\" ss " +
                "JOIN \"Adresy\" a ON ss.\"id_adres\" = a.\"id_adres\" " +
                "JOIN \"Poczty\" p ON a.\"id_poczta\" = p.\"id_poczta\"";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Salon_samochodowy salon = new Salon_samochodowy();
            salon.setId_salon_samochodowy(rs.getInt("id_salon_samochodowy"));
            salon.setWlasciciel(rs.getString("wlasciciel"));
            salon.setData_zalozenia(rs.getDate("data_zalozenia").toLocalDate());
            salon.setNazwa(rs.getString("nazwa"));

            Adres adres = new Adres();
            adres.setId_adres(rs.getInt("id_adres"));
            adres.setMiejscowosc(rs.getString("miejscowosc"));
            adres.setUlica(rs.getString("ulica"));
            adres.setNr_lokalu(rs.getString("nr_lokalu"));
            adres.setKod_poczty(rs.getString("kod_poczty"));
            adres.setPoczta(rs.getString("poczta"));

            salon.setAdres(adres);

            return salon;
        });
    }

    public void save(Salon_samochodowy salon_samochodowy) {
        // Step 1: Insert Adres and retrieve generated key
        SimpleJdbcInsert insertAdres = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Adresy\"")
                .usingColumns("\"miejscowosc\"", "\"ulica\"", "\"nr_lokalu\"", "\"id_poczta\"")
                .usingGeneratedKeyColumns("\"id_adres\"");

        // Create parameters map for Adres
        Map<String, Object> adresParameters = new HashMap<>();
        adresParameters.put("\"miejscowosc\"", salon_samochodowy.getAdres().getMiejscowosc());
        adresParameters.put("\"ulica\"", salon_samochodowy.getAdres().getUlica());
        adresParameters.put("\"nr_lokalu\"", salon_samochodowy.getAdres().getNr_lokalu());
        adresParameters.put("\"id_poczta\"", salon_samochodowy.getAdres().getId_poczta());

        Number idAdres = insertAdres.executeAndReturnKey(adresParameters);

        // Set the generated key back to the Adres object
        salon_samochodowy.getAdres().setId_adres(idAdres.intValue());

        // Step 2: Insert Salon_samochodowy using the generated Adres key
        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Salony_samochodowe\"")
                .usingColumns("\"wlasciciel\"", "\"data_zalozenia\"", "\"nazwa\"", "\"id_adres\"");

        // Create parameters map for Salon_samochodowy
        Map<String, Object> salonParameters = new HashMap<>();
        salonParameters.put("\"wlasciciel\"", salon_samochodowy.getWlasciciel());
        salonParameters.put("\"data_zalozenia\"", salon_samochodowy.getData_zalozenia());
        salonParameters.put("\"nazwa\"", salon_samochodowy.getNazwa());
        salonParameters.put("\"id_adres\"", idAdres);

        insertSalon.execute(salonParameters);
    }

    public Salon_samochodowy get(int id) {
        // Implementacja pobierania pojedynczego salonu (możesz dodać, gdy jest taka potrzeba)
        return null;
    }

    public void update(Salon_samochodowy salon_samochodowy) {
        // Implementacja aktualizacji danych salonu (możesz dodać, gdy jest taka potrzeba)
    }

    public void delete(int id) {
        String deleteSalonSql = "DELETE FROM \"Salony_samochodowe\" WHERE \"id_salon_samochodowy\" = ?";
        jdbcTemplate.update(deleteSalonSql, id);
    }
    public void delete2(int id) {
        String sql = "DELETE FROM \"Modele\" WHERE  \"id_model\" = ?";
        jdbcTemplate.update(sql, id);
    }
}
