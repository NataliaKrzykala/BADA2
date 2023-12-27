package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UmowaDAO {

    private JdbcTemplate jdbcTemplate;

    public UmowaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Umowa> list(){
        String sql = "SELECT * FROM \"Umowy\"";

        List<Umowa> listUmowa = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Umowa.class));

        return listUmowa;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Umowa umowa) {
    }

    /* Read – odczytywanie danych z bazy */
    public Umowa get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Umowa umowa) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
