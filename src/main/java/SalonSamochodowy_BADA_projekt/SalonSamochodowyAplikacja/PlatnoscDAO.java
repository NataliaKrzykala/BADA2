package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatnoscDAO {

    private JdbcTemplate jdbcTemplate;

    public PlatnoscDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Platnosc> list(){
        String sql = "SELECT * FROM \"Platnosci\"";

        List<Platnosc> listPlatnosc = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Platnosc.class));

        return listPlatnosc;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Platnosc platnosc) {
    }

    /* Read – odczytywanie danych z bazy */
    public Platnosc get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Platnosc platnosc) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
