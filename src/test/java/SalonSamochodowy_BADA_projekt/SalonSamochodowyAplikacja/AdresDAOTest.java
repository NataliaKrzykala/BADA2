package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdresDAOTest {

    private AdresDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("NKRZYKAL0");
        dataSource.setPassword("NKRZYKAL0");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Adres> listAdres = dao.list();
        assertFalse(listAdres.isEmpty());
        for (Adres adres : listAdres) {
            System.out.println(adres.toString());
        }
    }

    @Test
    void save() {
        Adres adres = new Adres(30, "SomeOwner", "lala", "10b", 1);
        dao.save(adres);
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
        fail("Not yet implemented");
    }

}
