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

    /*@RequestMapping(value = "/main")
    public String showMainPage() {
        return "main";
    }*/

    @RequestMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }



    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }

    @Autowired
    private Salon_samochodowyDAO dao;
    @RequestMapping(value ={"/salony"})
    public String viewHomePage(Model model){
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        model.addAttribute("listSalon_samochodowy", listSalon_samochodowy);
        return "salony";
    }

    @Autowired
    private OfertaDAO daoOfertaKupno;
    @RequestMapping(value ={"/ofertaKupno"})
    public String viewOfertaKupnoPage(Model model){
        List<Oferta> listOfertaKupno = daoOfertaKupno.listOfertaKupno();
        model.addAttribute("listOfertaKupno", listOfertaKupno);
        return "ofertaKupno";
    }

    @Autowired
    private OfertaDAO daoOfertaWypozyczenie;
    @RequestMapping(value ={"/ofertaWypozyczenie"})
    public String viewOfertaWypozyczeniePage(Model model){
        List<Oferta> listOfertaWypozyczenie = daoOfertaWypozyczenie.listOfertaWypozyczenie();
        model.addAttribute("listOfertaWypozyczenie", listOfertaWypozyczenie);
        return "ofertaWypozyczenie";
    }

    @Autowired
    private ModelDAO daoModel;
    @RequestMapping(value ={"/modele"})
    public String viewModelePage(Model model){
        List<SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja.Model> listModel = daoModel.list();
        model.addAttribute("listModel", listModel);
        return "modele";
    }
}
