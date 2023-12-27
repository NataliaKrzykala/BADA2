package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PojazdDAO {

    private JdbcTemplate jdbcTemplate;

    public PojazdDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pojazd> list(){
        String sql = "SELECT * FROM \"Pojazdy\"";

        List<Pojazd> listPojazd = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pojazd.class));

        return listPojazd;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pojazd pojazd) {
    }

    /* Read – odczytywanie danych z bazy */
    public Pojazd get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Pojazd pojazd) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
