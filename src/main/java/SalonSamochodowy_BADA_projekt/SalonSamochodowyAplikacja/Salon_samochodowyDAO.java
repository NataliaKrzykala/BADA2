package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Salony_samochodowe\"")
                .usingColumns("\"wlasciciel\"", "\"data_zalozenia\"", "\"nazwa\"", "\"id_adres\"");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("\"wlasciciel\"", salon_samochodowy.getWlasciciel());
        parameters.put("\"data_zalozenia\"", salon_samochodowy.getData_zalozenia());
        parameters.put("\"nazwa\"", salon_samochodowy.getNazwa());
        parameters.put("\"id_adres\"", salon_samochodowy.getId_adres());

        simpleJdbcInsert.execute(parameters);
    }

    public Salon_samochodowy get(int id) {
        // Implementacja pobierania pojedynczego salonu (możesz dodać, gdy jest taka potrzeba)
        return null;
    }

    public void update(Salon_samochodowy salon_samochodowy) {
        // Implementacja aktualizacji danych salonu (możesz dodać, gdy jest taka potrzeba)
    }

    public void delete(int id) {
        // Implementacja usuwania salonu (możesz dodać, gdy jest taka potrzeba)
    }
}
