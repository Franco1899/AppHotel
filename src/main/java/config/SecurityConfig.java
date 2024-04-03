package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.UsuarioService;
import org.springframework.security.core.userdetails.UserDetailsService; // Importa la interfaz UserDetailsService

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/registro", "/principal").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/principal")
                .defaultSuccessUrl("/inicio")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura el AuthenticationManagerBuilder con el UsuarioService y el PasswordEncoder
        auth.userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder);
    }
}


