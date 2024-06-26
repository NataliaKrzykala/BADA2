package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/", "/index", "/ofertaKupno").permitAll()
                    .antMatchers("/resources/static.js/**").permitAll()
                    .antMatchers("/main").authenticated()
                    .antMatchers("/main_admin", "/index_admin", "/salony_admin", "/ofertaKupno_admin", "/ofertaKupno_add", "/ofertaWypozyczenie_admin", "/ofertaWypozyczenie_add", "/modele_admin", "/modele_add", "/kontakt_admin", "/salony_add", "/pracownicy", "/pracownicy_add", "/pojazdy_add", "/pojazdy").access("hasRole('ADMIN')")
                    .antMatchers("/main_user", "/index_user", "/salony_user", "/ofertaKupno_user", "/ofertaWypozyczenie_user", "/modele_user", "/kontakt_user").access("hasRole('USER')")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/index")
                    .logoutSuccessUrl("/index")
                    .permitAll();
    }
}
