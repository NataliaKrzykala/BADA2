package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModelDAO {

    private JdbcTemplate jdbcTemplate;

    public ModelDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Model> list(){
        String sql = "SELECT * FROM \"Modele\"";

        List<Model> listModel = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Model.class));

        return listModel;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Model model) {
    }

    /* Read – odczytywanie danych z bazy */
    public Model get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Model model) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
