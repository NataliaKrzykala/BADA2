package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfertaDAO {
    private JdbcTemplate jdbcTemplate;

    public OfertaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oferta> listOfertaKupno(){
        String sql = "SELECT * FROM \"Oferty\" WHERE \"typ_nabycia\" = 'kupno'";

        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));

        return listOferta;
    }

    public List<Oferta> listOfertaWypozyczenie(){
        String sql = "SELECT * FROM \"Oferty\" WHERE \"typ_nabycia\" = 'wypozyczenie'";

        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));

        return listOferta;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Oferta oferta) {
    }

    /* Read – odczytywanie danych z bazy */
    public Oferta get(int id) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Oferta oferta) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
