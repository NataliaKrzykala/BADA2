package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Salon_samochodowyDAO {
    @Autowired
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
