package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Salon_samochodowyDAO {
    //@Autowired
    private JdbcTemplate jdbcTemplate;

    public Salon_samochodowyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Salon_samochodowy> list(){
        String sql = "SELECT * FROM \"Salony_samochodowe\"";

        List<Salon_samochodowy> listSalon_samochodowy = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Salon_samochodowy.class));

        return listSalon_samochodowy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
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

    /* Read – odczytywanie danych z bazy */
    public Salon_samochodowy get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Salon_samochodowy salon_samochodowy) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
