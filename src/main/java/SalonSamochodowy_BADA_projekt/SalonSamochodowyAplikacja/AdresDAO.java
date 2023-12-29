package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresDAO {

    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM \"Adresy\"";

        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));

        return listAdres;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
    }

    /* Read – odczytywanie danych z bazy */
    public Adres get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Adres adres) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
