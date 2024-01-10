package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/kontakt").setViewName("kontakt");
        registry.addViewController("/salony").setViewName("salony");
        registry.addViewController("/kupno").setViewName("ofertaKupno");
        registry.addViewController("/wypozyczenie").setViewName("ofertaWypozyczenie");
        registry.addViewController("/modele").setViewName("modele");
        registry.addViewController("/kontakt_user").setViewName("kontakt_user");
        registry.addViewController("/salony_user").setViewName("salony_user");
        registry.addViewController("/kupno_user").setViewName("ofertaKupno_user");
        registry.addViewController("/wypozyczenie_user").setViewName("ofertaWypozyczenie_user");
        registry.addViewController("/modele_user").setViewName("modele_user");
        registry.addViewController("/index_user").setViewName("index_user");
        registry.addViewController("/kontakt_admin").setViewName("kontakt_admin");
        registry.addViewController("/salony_admin").setViewName("salony_admin");
        registry.addViewController("/kupno_admin").setViewName("ofertaKupno_admin");
        registry.addViewController("/wypozyczenie_admin").setViewName("ofertaWypozyczenie_admin");
        registry.addViewController("/modele_admin").setViewName("modele_admin");
        registry.addViewController("/index_admin").setViewName("index_admin");
        registry.addViewController("/salony_add").setViewName("salony_add");
        registry.addViewController("/modele_add").setViewName("modele_add");
        registry.addViewController("/ofertaWypozyczenie_add").setViewName("ofertaWypozyczenie_add");
        registry.addViewController("/ofertaKupno_add").setViewName("ofertaKupno_add");
        registry.addViewController("/pracownicy").setViewName("pracownicy");
        registry.addViewController("/pracownicy_add").setViewName("pracownicy_add");
        registry.addViewController("/pojazdy").setViewName("pojazdy");
        registry.addViewController("/pojazdy_add").setViewName("pojazdy_add");
    }


   /* @Controller
    public class DashboardController {*/
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/main";
            }
        }
    //}

    @RequestMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }


    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        // Add code to retrieve dashboard information
        int vehicleCount = dao.countVehicles();
        int carModelCount = dao.countCarModels();
        int purchaseOfferCount = dao.countPurchaseOffers();
        int rentalOfferCount = dao.countRentalOffers();


        // Create a Map to hold dashboard information
        Map<String, Integer> dashboard = new HashMap<>();
        dashboard.put("vehicleCount", vehicleCount);
        dashboard.put("carModelCount", carModelCount);
        dashboard.put("purchaseOfferCount", purchaseOfferCount);
        dashboard.put("rentalOfferCount", rentalOfferCount);

        // Add the dashboard map to the model
        model.addAttribute("dashboard", dashboard);

        return "admin/main_admin";
    }


    @RequestMapping(value = "/index_admin")
    public String showIndexAdminPage() {
        return "admin/index_admin";
    }

    @RequestMapping(value = "/kontakt_admin")
    public String showKontaktAdminPage() {
        return "admin/kontakt_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @Autowired
    private KlientDAO daoKlient;

    // Add a new mapping to display details of a single Klient in main_user.html
    @GetMapping("/main_user") //"/updateKlient"
    public String showUpdateKlientForm(Model model) {
        int id = 2;
        Klient klient = daoKlient.get(id);

        if (klient != null) {
            model.addAttribute("klient", klient);
            return "user/main_user";
        } else {
            // Handle the case where the Klient with the given ID is not found
            return "redirect:/login";
        }
    }

    @PostMapping("/updateKlient/{id}")
    public String updateKlient(@PathVariable int id, @RequestParam String updateNr_telefonu, @RequestParam String updateEmail) {
        // Retrieve the Klient from the DAO
        Klient klient = daoKlient.get(id);

        if (klient != null) {
            klient.setNr_telefonu(updateNr_telefonu);
            klient.setEmail(updateEmail);

            daoKlient.update(klient);

            return "redirect:/main_user";
        } else {
            // Handle the case where the Klient with the given ID is not found
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/index_user")
    public String showIndexUserPage() {
        return "user/index_user";
    }

    @RequestMapping(value = "/kontakt_user")
    public String showKontaktUserPage() {
        return "user/kontakt_user";
    }

    @Autowired
    private Salon_samochodowyDAO dao;
    @RequestMapping(value ={"/salony"})
    public String viewSalonyPage(Model model){
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        model.addAttribute("listSalon_samochodowy", listSalon_samochodowy);
        return "salony";
    }
    @RequestMapping(value ={"/salony_user"})
    public String viewSalonyUserPage(Model model){
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        model.addAttribute("listSalon_samochodowy", listSalon_samochodowy);
        return "user/salony_user";
    }
    @RequestMapping(value ={"/salony_admin"})
    public String viewSalonyAdminPage(Model model){
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        model.addAttribute("listSalon_samochodowy", listSalon_samochodowy);
        return "admin/salony_admin";
    }

    @Autowired
    private OfertaDAO daoOfertaKupno;
    @RequestMapping(value ={"/ofertaKupno"})
    public String viewOfertaKupnoPage(Model model){
        List<Oferta> listOfertaKupno = daoOfertaKupno.listOfertaKupno();
        model.addAttribute("listOfertaKupno", listOfertaKupno);
        return "ofertaKupno";
    }
    @RequestMapping(value ={"/ofertaKupno_user"})
    public String viewOfertaKupnoUserPage(Model model){
        List<Oferta> listOfertaKupno = daoOfertaKupno.listOfertaKupno();
        model.addAttribute("listOfertaKupno", listOfertaKupno);
        return "user/ofertaKupno_user";
    }
    @RequestMapping(value ={"/ofertaKupno_admin"})
    public String viewOfertaKupnoAdminPage(Model model){
        List<Oferta> listOfertaKupno = daoOfertaKupno.listOfertaKupno();
        model.addAttribute("listOfertaKupno", listOfertaKupno);
        return "admin/ofertaKupno_admin";
    }

    @Autowired
    private PojazdDAO pojazdDAO;

    @RequestMapping(value ={"/ofertaKupno_add"})
    public String viewOfertaKupnoAddPage(Model model){
        Oferta oferta = new Oferta();
        model.addAttribute("ofertaKupno", oferta);

        List<Salon_samochodowy> salony = dao.list();
        model.addAttribute("salony", salony);

        List<Pojazd> pojazdy = pojazdDAO.list();
        model.addAttribute("pojazdy", pojazdy);

        return "admin/ofertaKupno_add";
    }

    @PostMapping("/saveOfertaKupno")
    public String saveOfertaKupno(@ModelAttribute Oferta oferta) {
        daoOfertaKupno.saveOfertaKupno(oferta);
        return "redirect:/ofertaKupno_admin";  // Przekierowanie na strone z lista ofert kupna admina
    }

    @Autowired
    private OfertaDAO daoOfertaWypozyczenie;
    @RequestMapping(value ={"/ofertaWypozyczenie"})
    public String viewOfertaWypozyczeniePage(Model model){
        List<Oferta> listOfertaWypozyczenie = daoOfertaWypozyczenie.listOfertaWypozyczenie();
        model.addAttribute("listOfertaWypozyczenie", listOfertaWypozyczenie);
        return "ofertaWypozyczenie";
    }
    @RequestMapping(value ={"/ofertaWypozyczenie_user"})
    public String viewOfertaWypozyczenieUserPage(Model model){
        List<Oferta> listOfertaWypozyczenie = daoOfertaWypozyczenie.listOfertaWypozyczenie();
        model.addAttribute("listOfertaWypozyczenie", listOfertaWypozyczenie);
        return "user/ofertaWypozyczenie_user";
    }
    @RequestMapping(value ={"/ofertaWypozyczenie_admin"})
    public String viewOfertaWypozyczenieAdminPage(Model model){
        List<Oferta> listOfertaWypozyczenie = daoOfertaWypozyczenie.listOfertaWypozyczenie();
        model.addAttribute("listOfertaWypozyczenie", listOfertaWypozyczenie);
        return "admin/ofertaWypozyczenie_admin";
    }

    @RequestMapping(value ={"/ofertaWypozyczenie_add"})
    public String viewOfertaWypozyczenieAddPage(Model model){
        Oferta oferta = new Oferta();
        model.addAttribute("ofertaWypozyczenie", oferta);

        List<Salon_samochodowy> salony = dao.list();
        model.addAttribute("salony", salony);

        List<Pojazd> pojazdy = pojazdDAO.list();
        model.addAttribute("pojazdy", pojazdy);

        return "admin/ofertaWypozyczenie_add";
    }

    @PostMapping("/saveOfertaWypozyczenie")
    public String saveOfertaWypozyczenie(@ModelAttribute Oferta oferta) {
        daoOfertaWypozyczenie.saveOfertaWypozyczenie(oferta);
        return "redirect:/ofertaWypozyczenie_admin";  // Przekierowanie na strone z lista ofert wypozyczenia admina
    }

    @Autowired
    private ModelDAO daoModel;
    @RequestMapping(value ={"/modele"})
    public String viewModelePage(Model model){
        List<SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model> listModel = daoModel.list();
        model.addAttribute("listModel", listModel);
        return "modele";
    }
    @RequestMapping(value ={"/modele_user"})
    public String viewModeleUserPage(Model model){
        List<SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model> listModel = daoModel.list();
        model.addAttribute("listModel", listModel);
        return "user/modele_user";
    }
    @RequestMapping(value ={"/modele_admin"})
    public String viewModeleAdminPage(Model model){
        List<SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model> listModel = daoModel.list();
        model.addAttribute("listModel", listModel);
        return "admin/modele_admin";
    }

    @RequestMapping(value ={"/modele_add"})
    public String viewModeleAddPage(Model model){
        SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model model1 = new SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model();
        model.addAttribute("model1", model1);
        return "admin/modele_add";
    }

    @PostMapping("/saveModel")
    public String saveModel(@ModelAttribute SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model model1) {
        daoModel.save(model1);
        return "redirect:/modele_admin";  // Przekierowanie na strone z lista modeli admina
    }

    @RequestMapping(value ={"/salony_add"})
    public String viewSalonyAddPage(Model model){
        Salon_samochodowy salon_samochodowy = new Salon_samochodowy();
        model.addAttribute("salon_samochodowy", salon_samochodowy);
        return "admin/salony_add";
    }

    @PostMapping("/save")
    public String saveSalon(@ModelAttribute Salon_samochodowy salon_samochodowy) {
        dao.save(salon_samochodowy);
        return "redirect:/salony_admin";  // Przekierowanie na strone z lista salonów
    }

    @Autowired
    private PracownikDAO daoPracownik;
    @RequestMapping(value ={"/pracownicy"})
    public String viewPracownicyPage(Model model){
        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);
        return "admin/pracownicy";
    }

    @Autowired
    private StanowiskoDAO stanowiskoDAO;
    @RequestMapping(value ={"/pracownicy_add"})
    public String viewPracownicyAddPage(Model model){
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);

        List<Stanowisko> stanowiska = stanowiskoDAO.list();
        model.addAttribute("stanowiska", stanowiska);

        List<Salon_samochodowy> salony = dao.list();
        model.addAttribute("salony", salony);

        return "admin/pracownicy_add";
    }

    @PostMapping("/savePracownik")
    public String savePracownik(@ModelAttribute Pracownik pracownik) {
        daoPracownik.save(pracownik);
        return "redirect:/pracownicy";  // Przekierowanie na strone z lista pracowników
    }

    @RequestMapping(value ={"/pojazdy"})
    public String viewPojazdyPage(Model model){
        List<Pojazd> listPojazd = pojazdDAO.list();
        model.addAttribute("listPojazd", listPojazd);
        return "admin/pojazdy";
    }

    @RequestMapping(value ={"/pojazdy_add"})
    public String viewPojazdAddPage(Model model){
        Pojazd pojazd = new Pojazd();
        model.addAttribute("pojazd", pojazd);

        List<SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model> modele = daoModel.list();
        model.addAttribute("modele", modele);

        return "admin/pojazdy_add";
    }

    @PostMapping("/savePojazd")
    public String savePojazd(@ModelAttribute Pojazd pojazd) {
        pojazdDAO.save(pojazd);
        return "redirect:/pojazdy";  // Przekierowanie na strone z lista pojazdow admina
    }
    @RequestMapping(value = "/deleteSalon/{id}")
    public String deleteSalon(@PathVariable int id, RedirectAttributes redirectAttributes) {
        int deletionSuccesfull = dao.delete(id);
        if(deletionSuccesfull == 1){
            List<String> listConflictingOffers = daoOfertaWypozyczenie.listOffersOfShop(id);
            redirectAttributes.addAttribute("deletionError", listConflictingOffers);

        } else if (deletionSuccesfull == 2){
            List<String> listConflictingEmployees = daoPracownik.listCarsOfEmployees(id);
            redirectAttributes.addAttribute("deletionError", listConflictingEmployees);
        }
        return "redirect:/salony_admin";
    }
    @RequestMapping(value = "/deleteModel/{id}")
    public String deleteModel(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean deletionSuccessful = daoModel.delete(id);

        if(!deletionSuccessful){
            List<String> listPojazdyVINs = pojazdDAO.listCarsOfModel(id);
            redirectAttributes.addAttribute("deletionError", listPojazdyVINs);
        }
        return "redirect:/modele_admin";
    }
    @RequestMapping(value = "/deletePracownik/{id}")
    public String deletePracownik(@PathVariable int id) {
        daoPracownik.delete(id);
        return "redirect:/pracownicy";
    }

    @RequestMapping(value = "/deletePojazd/{id}")
    public String deletePojazd(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean deletionSuccessful = pojazdDAO.delete(id);
        if(!deletionSuccessful){
            List<String> listConflictingOffers = daoOfertaWypozyczenie.listOffersOfCar(id);
            redirectAttributes.addAttribute("deletionError", listConflictingOffers);
        }
        return "redirect:/pojazdy";
    }

    @RequestMapping(value = "/deleteOfertaKupno/{id}")
    public String deleteOfertaKupno(@PathVariable int id) {
        daoOfertaKupno.delete(id);
        return "redirect:/ofertaKupno_admin";
    }

    @RequestMapping(value = "/deleteOfertaWypozyczenie/{id}")
    public String deleteOfertaWypozyczenie(@PathVariable int id) {
        daoOfertaWypozyczenie.delete(id);
        return "redirect:/ofertaWypozyczenie_admin";
    }

    @GetMapping("/searchSalony")
    public String searchSalony(@RequestParam String query, Model model) {
        List<Salon_samochodowy> searchResults = dao.searchSalony(query);
        model.addAttribute("listSalon_samochodowy", searchResults);
        return "salony";
    }


}
