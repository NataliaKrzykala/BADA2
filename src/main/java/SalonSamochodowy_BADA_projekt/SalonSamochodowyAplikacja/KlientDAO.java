package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlientDAO {

    private final JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT k.*, a.*, p.* " +
                "FROM \"Klienci\" k " +
                "JOIN \"Adresy\" a ON p.\"id_adres\" = a.\"id_adres\" " +
                "JOIN \"Poczty\" po ON a.\"id_poczta\" = po.\"id_poczta\"";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Klient klient = new Klient();
            klient.setId_klient(rs.getInt("id_klient"));
            klient.setImie(rs.getString("imie"));
            klient.setNazwisko(rs.getString("nazwisko"));
            klient.setNr_telefonu(rs.getString("nr_telefonu"));
            klient.setEmail(rs.getString("email"));
            klient.setId_adres(rs.getInt("id_adres"));

            Adres adres = new Adres();
            adres.setId_adres(rs.getInt("id_adres"));
            adres.setMiejscowosc(rs.getString("miejscowosc"));
            adres.setUlica(rs.getString("ulica"));
            adres.setNr_lokalu(rs.getString("nr_lokalu"));
            adres.setKod_poczty(rs.getString("kod_poczty"));
            adres.setPoczta(rs.getString("poczta"));

            klient.setAdres(adres);

            return klient;
        });
        /*String sql = "SELECT * FROM \"Klienci\"";

        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return listKlient;*/
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
    }

    /* Read – odczytywanie danych z bazy */
    public Klient get(int id_klient) {
        String sql = "SELECT k.*, a.*, p.* " +
                "FROM \"Klienci\" k " +
                "JOIN \"Adresy\" a ON k.\"id_adres\" = a.\"id_adres\" " +
                "JOIN \"Poczty\" p ON a.\"id_poczta\" = p.\"id_poczta\" " +
                "WHERE \"id_klient\" = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id_klient}, (rs, rowNum) -> {
            Klient klient = new Klient();
            klient.setId_klient(rs.getInt("id_klient"));
            klient.setImie(rs.getString("imie"));
            klient.setNazwisko(rs.getString("nazwisko"));
            klient.setNr_telefonu(rs.getString("nr_telefonu"));
            klient.setEmail(rs.getString("email"));
            klient.setId_adres(rs.getInt("id_adres"));

            Adres adres = new Adres();
            adres.setId_adres(rs.getInt("id_adres"));
            adres.setMiejscowosc(rs.getString("miejscowosc"));
            adres.setUlica(rs.getString("ulica"));
            adres.setNr_lokalu(rs.getString("nr_lokalu"));
            adres.setKod_poczty(rs.getString("kod_poczty"));
            adres.setPoczta(rs.getString("poczta"));

            klient.setAdres(adres);

            return klient;
        });
    }

    /* Update – aktualizacja danych */
    public void update(Klient klient) {
        String sql = "UPDATE \"Klienci\" SET " +
                "\"imie\" = ?, " +
                "\"nazwisko\" = ?, " +
                "\"nr_telefonu\" = ?, " +
                "\"email\" = ? " +
                "WHERE \"id_klient\" = ?";

        jdbcTemplate.update(sql,
                klient.getImie(),
                klient.getNazwisko(),
                klient.getNr_telefonu(),
                klient.getEmail(),
                klient.getId_klient());
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
