package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value ={"/salony_add"})
    public String viewSalonyAddPage(Model model){
        Salon_samochodowy salon_samochodowy = new Salon_samochodowy();
        model.addAttribute("salon_samochodowy", salon_samochodowy);
        return "admin/salony_add";
    }
}
