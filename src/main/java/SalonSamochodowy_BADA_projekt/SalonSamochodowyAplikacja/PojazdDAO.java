package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PojazdDAO {

    private final JdbcTemplate jdbcTemplate;

    public PojazdDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pojazd> list(){

        String sql = "SELECT p.*, m.* " +
                "FROM \"Pojazdy\" p " +
                "JOIN \"Modele\" m ON p.\"id_model\" = m.\"id_model\"";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    Pojazd pojazd = new Pojazd();
                    pojazd.setId_pojazd(rs.getInt("id_pojazd"));
                    pojazd.setVIN(rs.getString("VIN"));
                    pojazd.setNumer_rejestracyjny(rs.getString("numer_rejestracyjny"));
                    pojazd.setStan(rs.getString("stan"));
                    pojazd.setData_przegladu(rs.getDate("data_przegladu").toLocalDate());
                    pojazd.setPrzebieg(rs.getInt("przebieg"));
                    pojazd.setTyp_paliwa(rs.getString("typ_paliwa"));
                    pojazd.setKolor(rs.getString("kolor"));
                    pojazd.setId_model(rs.getInt("id_model"));

                    Model model = new Model();
                    model.setId_model(rs.getInt("id_model"));
                    model.setNazwa_modelu(rs.getString("nazwa_modelu"));
                    model.setLiczba_drzwi(rs.getInt("liczba_drzwi"));
                    model.setMoc_silnika(rs.getInt("moc_silnika"));
                    model.setSpalanie_paliwa(rs.getInt("spalanie_paliwa"));
                    model.setPojemnosc_bagaznika(rs.getInt("pojemnosc_bagaznika"));

                    pojazd.setModel(model);
                    return pojazd;
        });

        /*String sql = "SELECT * FROM \"Pojazdy\"";

        List<Pojazd> listPojazd = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pojazd.class));

        return listPojazd;*/
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pojazd pojazd) {

        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Pojazdy\"")
                .usingColumns("\"VIN\"", "\"numer_rejestracyjny\"", "\"stan\"", "\"data_przegladu\"", "\"przebieg\"", "\"typ_paliwa\"", "\"kolor\"", "\"id_model\"" );

        // Create parameters map for Pojazd
        Map<String, Object> pojazdParameters = new HashMap<>();
        pojazdParameters.put("\"VIN\"", pojazd.getVIN());
        pojazdParameters.put("\"numer_rejestracyjny\"", pojazd.getNumer_rejestracyjny());
        pojazdParameters.put("\"stan\"", pojazd.getStan());
        pojazdParameters.put("\"data_przegladu\"", pojazd.getData_przegladu());
        pojazdParameters.put("\"przebieg\"", pojazd.getPrzebieg());
        pojazdParameters.put("\"typ_paliwa\"", pojazd.getTyp_paliwa());
        pojazdParameters.put("\"kolor\"", pojazd.getKolor());
        pojazdParameters.put("\"id_model\"", pojazd.getId_model());

        insertSalon.execute(pojazdParameters);

    }

    /* Read – odczytywanie danych z bazy */
    public Pojazd get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Pojazd pojazd) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
