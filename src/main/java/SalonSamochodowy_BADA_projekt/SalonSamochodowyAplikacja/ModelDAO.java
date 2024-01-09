package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Modele\"")
                .usingColumns("\"nazwa_modelu\"", "\"liczba_drzwi\"", "\"moc_silnika\"", "\"spalanie_paliwa\"", "\"pojemnosc_bagaznika\"");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("\"nazwa_modelu\"", model.getNazwa_modelu());
        parameters.put("\"liczba_drzwi\"", model.getLiczba_drzwi());
        parameters.put("\"moc_silnika\"", model.getMoc_silnika());
        parameters.put("\"spalanie_paliwa\"", model.getSpalanie_paliwa());
        parameters.put("\"pojemnosc_bagaznika\"", model.getPojemnosc_bagaznika());

        simpleJdbcInsert.execute(parameters);
    }

    /* Read – odczytywanie danych z bazy */
    public Model get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Model model) {
    }

    public boolean delete(int id) {
        // Check if there are any vehicles associated with the specified model
        String checkIfVehiclesSql = "SELECT COUNT(*) FROM \"Pojazdy\" WHERE \"id_model\" = ?";
        int vehicleCount = jdbcTemplate.queryForObject(checkIfVehiclesSql, Integer.class, id);

        if (vehicleCount > 0) {
            // Display a message indicating that the model cannot be deleted
            System.out.println("Cannot delete the model because there are associated vehicles.");
            return false;
        } else {
            // If no associated vehicles, proceed with model deletion
            String deleteModelSql = "DELETE FROM \"Modele\" WHERE  \"id_model\" = ?";
            jdbcTemplate.update(deleteModelSql, id);
            System.out.println("Model deleted successfully.");
            return true;
        }
    }

}
