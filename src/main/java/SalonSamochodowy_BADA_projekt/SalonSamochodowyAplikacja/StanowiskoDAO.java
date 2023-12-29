package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StanowiskoDAO {

    private JdbcTemplate jdbcTemplate;

    public StanowiskoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Stanowisko> list(){
        String sql = "SELECT * FROM \"Stanowiska\"";

        List<Stanowisko> listStanowisko = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Stanowisko.class));

        return listStanowisko;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Stanowisko stanowisko) {
    }

    /* Read – odczytywanie danych z bazy */
    public Stanowisko get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Stanowisko stanowisko) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
