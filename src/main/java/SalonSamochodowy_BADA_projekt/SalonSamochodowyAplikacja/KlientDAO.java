package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlientDAO {

    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT * FROM \"Klienci\"";

        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return listKlient;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
    }

    /* Read – odczytywanie danych z bazy */
    public Klient get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Klient klient) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
