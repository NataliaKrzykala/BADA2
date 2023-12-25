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
    }

    //@Controller
    public class DashboardController {
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
                return "redirect:/index";
            }
        }
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
    @RequestMapping(value ={"/index", "/"})
    public String viewHomePage(Model model){
        List<Salon_samochodowy> listSalon_samochodowy = dao.list();
        model.addAttribute("listSalon_samochodowy", listSalon_samochodowy);
        return "index";
    }

    /*@Autowired
    private OfertaDAO daoOferta;
    @RequestMapping(value ={"/main"})
    public String viewOfertaPage(Model model){
        List<Oferta> listOferta = daoOferta.list();
        model.addAttribute("listOferta", listOferta);
        return "main";
    }*/
}
