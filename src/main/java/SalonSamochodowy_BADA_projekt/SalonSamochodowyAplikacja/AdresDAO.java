package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
        // Check if miejscowosc is not null before attempting to insert
        if (adres.getMiejscowosc() != null) {
            SimpleJdbcInsert insertAdres = new SimpleJdbcInsert(jdbcTemplate)
                    .withTableName("Adresy")
                    .usingGeneratedKeyColumns("id_adres");
            insertAdres.usingColumns("miejscowosc", "ulica", "nr_lokalu", "id_poczta");

            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
            insertAdres.execute(param);
        } else {
            // Handle the case where miejscowosc is null, throw an exception or log a message
            throw new IllegalArgumentException("miejscowosc cannot be null");
        }
    }


    /* Read – odczytywanie danych z bazy */
    public Adres get(int id) {
        String sql = "SELECT * FROM \"Adresy\" WHERE \"id_adres\" = ?";
        Adres adres = jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    /* Update – aktualizacja danych */
    public void update(Adres adres) {
        // Implementacja aktualizacji adresu
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        // Implementacja usuwania adresu
    }
}
