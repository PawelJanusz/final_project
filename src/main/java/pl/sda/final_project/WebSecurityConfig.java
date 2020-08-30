package pl.sda.final_project;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/register")  // /register/* wchodzi w jedno zagnieżdżenie dalej lub /register/** wpuszcza ile się da
                    .permitAll()
                    .antMatchers("/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated()  // wszystkie pozostałe requesty, musi być zalogowany
                    .and()
                    .csrf().disable()  // jesli mamy join session id to ktośobcy może wejść
                    //.cors().disable() // robi się osobną konfigurację; żeby nie możnabyło korzystać z requestów z innej domeny
                    //mówimy w jaki sposób ma działać strona logowania
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("login-process")  // URL na który będzie wysłany login i hasło - dane logowania
                    .failureUrl("/login?error=1")
                    .defaultSuccessUrl("/")
                    .and()
                    .logout()
                    .logoutUrl("/logout")  // jesli wyslemy request na ten url zostaniemy wylogowani
                    .logoutSuccessUrl("/logout"); //na ten url zostaniemy przekierowani po wylogowaniu
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }
}
