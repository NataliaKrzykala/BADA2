package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztaDAO {

    private JdbcTemplate jdbcTemplate;

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list(){
        String sql = "SELECT * FROM \"Poczty\"";

        List<Poczta> listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));

        return listPoczta;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Poczta poczta) {
    }

    /* Read – odczytywanie danych z bazy */
    public Poczta get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Poczta poczta) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
