package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Typ_platnosciDAO {

    private JdbcTemplate jdbcTemplate;

    public Typ_platnosciDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Typ_platnosci> list(){
        String sql = "SELECT * FROM \"Typy_platnosci\"";

        List<Typ_platnosci> listTyp_platnosci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Typ_platnosci.class));

        return listTyp_platnosci;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Typ_platnosci typPlatnosci) {
    }

    /* Read – odczytywanie danych z bazy */
    public Typ_platnosci get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Typ_platnosci typPlatnosci) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
