package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Salon_samochodowyDAOTest {
    private Salon_samochodowyDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("NKRZYKAL0");
        dataSource.setPassword("NKRZYKAL0");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new Salon_samochodowyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        assertFalse(listSalon_samochodowy.isEmpty());
        for (Salon_samochodowy salon : listSalon_samochodowy) {
            System.out.println(salon.toString());
        }
    }
//
//    @Test
//    void save() {
//        Salon_samochodowy salon_samochodowy = new Salon_samochodowy(30, "SomeOwner", "10.10.23", "WAuto", 41);
//        dao.save(salon_samochodowy);
//    }

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