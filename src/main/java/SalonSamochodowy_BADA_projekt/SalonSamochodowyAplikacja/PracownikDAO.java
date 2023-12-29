package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownikDAO {

    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list(){
        String sql = "SELECT * FROM \"Pracownicy\"";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return listPracownik;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
    }

    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
