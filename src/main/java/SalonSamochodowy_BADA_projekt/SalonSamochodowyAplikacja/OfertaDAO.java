package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OfertaDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OfertaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oferta> listOfertaKupno(){
        String sql = "SELECT o.*, p.*, ss.\"nazwa\", m.* " +
                "FROM \"Oferty\" o " +
                "JOIN \"Pojazdy\" p ON o.\"id_pojazd\" = p.\"id_pojazd\" " +
                "JOIN \"Salony_samochodowe\" ss ON o.\"id_salon_samochodowy\" = ss.\"id_salon_samochodowy\" " +
                "JOIN \"Modele\" m ON p.\"id_model\" = m.\"id_model\" " +
                "WHERE o.\"typ_nabycia\" = 'kupno'";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Oferta oferta = new Oferta();
            oferta.setId_oferta(rs.getInt("id_oferta"));
            oferta.setData_utworzenia(rs.getDate("data_utworzenia").toLocalDate());
            oferta.setTyp_nabycia(rs.getString("typ_nabycia"));
            oferta.setCena(rs.getInt("cena"));
            oferta.setId_salon_samochodowy(rs.getInt("id_salon_samochodowy"));
            oferta.setId_pojazd(rs.getInt("id_pojazd"));

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

            Salon_samochodowy salon = new Salon_samochodowy();
            salon.setNazwa(rs.getString("nazwa"));

            Model model = new Model();
            model.setId_model(rs.getInt("id_model"));
            model.setNazwa_modelu(rs.getString("nazwa_modelu"));
            model.setLiczba_drzwi(rs.getInt("liczba_drzwi"));
            model.setMoc_silnika(rs.getInt("moc_silnika"));
            model.setSpalanie_paliwa(rs.getInt("spalanie_paliwa"));
            model.setPojemnosc_bagaznika(rs.getInt("pojemnosc_bagaznika"));

            oferta.setPojazd(pojazd);
            oferta.setSalon(salon);
            oferta.setModel(model);
            return oferta;

        });

        /*String sql = "SELECT * FROM \"Oferty\" WHERE \"typ_nabycia\" = 'kupno'";

        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));

        return listOferta;*/
    }

    public List<Oferta> listOfertaWypozyczenie(){
        String sql = "SELECT o.*, p.*, ss.\"nazwa\", m.* " +
                "FROM \"Oferty\" o " +
                "JOIN \"Pojazdy\" p ON o.\"id_pojazd\" = p.\"id_pojazd\" " +
                "JOIN \"Salony_samochodowe\" ss ON o.\"id_salon_samochodowy\" = ss.\"id_salon_samochodowy\" " +
                "JOIN \"Modele\" m ON p.\"id_model\" = m.\"id_model\" " +
                "WHERE o.\"typ_nabycia\" = 'wypozyczenie'";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    Oferta oferta = new Oferta();
                    oferta.setId_oferta(rs.getInt("id_oferta"));
                    oferta.setData_utworzenia(rs.getDate("data_utworzenia").toLocalDate());
                    oferta.setTyp_nabycia(rs.getString("typ_nabycia"));
                    oferta.setCena(rs.getInt("cena"));
                    oferta.setId_salon_samochodowy(rs.getInt("id_salon_samochodowy"));
                    oferta.setId_pojazd(rs.getInt("id_pojazd"));

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

                    Salon_samochodowy salon = new Salon_samochodowy();
                    salon.setNazwa(rs.getString("nazwa"));

                    Model model = new Model();
                    model.setId_model(rs.getInt("id_model"));
                    model.setNazwa_modelu(rs.getString("nazwa_modelu"));
                    model.setLiczba_drzwi(rs.getInt("liczba_drzwi"));
                    model.setMoc_silnika(rs.getInt("moc_silnika"));
                    model.setSpalanie_paliwa(rs.getInt("spalanie_paliwa"));
                    model.setPojemnosc_bagaznika(rs.getInt("pojemnosc_bagaznika"));

                    oferta.setPojazd(pojazd);
                    oferta.setSalon(salon);
                    oferta.setModel(model);
                    return oferta;

        });

        /*String sql = "SELECT * FROM \"Oferty\" WHERE \"typ_nabycia\" = 'wypozyczenie'";

        List<Oferta> listOferta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));

        return listOferta;*/
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void saveOfertaWypozyczenie(Oferta oferta) {

        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Oferty\"")
                .usingColumns("\"data_utworzenia\"", "\"typ_nabycia\"", "\"cena\"", "\"id_salon_samochodowy\"", "\"id_pojazd\"");

        // Set typ_nabycia to 'wypozyczenie'
        String typNabycia = "wypozyczenie";
        // Get today's date
        LocalDate today = LocalDate.now();

        // Create parameters map for OfertaWYpozyczenie
        Map<String, Object> ofertaWypozyczenieParameters = new HashMap<>();
        ofertaWypozyczenieParameters.put("\"data_utworzenia\"", today);
        ofertaWypozyczenieParameters.put("\"typ_nabycia\"", typNabycia);
        ofertaWypozyczenieParameters.put("\"cena\"", oferta.getCena());
        ofertaWypozyczenieParameters.put("\"id_salon_samochodowy\"", oferta.getId_salon_samochodowy());
        ofertaWypozyczenieParameters.put("\"id_pojazd\"", oferta.getId_pojazd());

        insertSalon.execute(ofertaWypozyczenieParameters);

    }

    public void saveOfertaKupno(Oferta oferta) {

        SimpleJdbcInsert insertSalon = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("\"Oferty\"")
                .usingColumns("\"data_utworzenia\"", "\"typ_nabycia\"", "\"cena\"", "\"id_salon_samochodowy\"", "\"id_pojazd\"");

        // Set typ_nabycia to 'kupno'
        String typNabycia = "kupno";
        // Get today's date
        LocalDate today = LocalDate.now();

        // Create parameters map for OfertaKupno
        Map<String, Object> ofertaWypozyczenieParameters = new HashMap<>();
        ofertaWypozyczenieParameters.put("\"data_utworzenia\"", today);
        ofertaWypozyczenieParameters.put("\"typ_nabycia\"", typNabycia);
        ofertaWypozyczenieParameters.put("\"cena\"", oferta.getCena());
        ofertaWypozyczenieParameters.put("\"id_salon_samochodowy\"", oferta.getId_salon_samochodowy());
        ofertaWypozyczenieParameters.put("\"id_pojazd\"", oferta.getId_pojazd());

        insertSalon.execute(ofertaWypozyczenieParameters);

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
        String sql = "DELETE FROM \"Oferty\" WHERE  \"id_oferta\" = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<String> listOffersOfCar(int id)
    {
        String sql = "SELECT s.\"nazwa\" FROM \"Oferty\" o JOIN \"Salony_samochodowe\" s ON o.\"id_salon_samochodowy\" = s.\"id_salon_samochodowy\" WHERE o.\"id_pojazd\" = ?";
        /*"SELECT \"id_model\" FROM \"Oferty\" JOIN \"Pojazdy\" ON \"id_pojazd\" WHERE \"id_pojazd\" = ?";*/

        List<String> listOffersModels = jdbcTemplate.queryForList(sql, String.class, id);

        return listOffersModels;
    }

    public List<String> listOffersOfShop(int id)
    {
        String sql = "SELECT \"typ_nabycia\" FROM \"Oferty\" WHERE \"id_salon_samochodowy\" = ?";
        List<String> listTypeOfPurchase = jdbcTemplate.queryForList(sql, String.class, id);

        return listTypeOfPurchase;
    }
}
