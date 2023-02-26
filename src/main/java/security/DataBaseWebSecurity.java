package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class DataBaseWebSecurity {

    @Autowired
    private DataSource dataSource;


    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select NIF, pw, Activo from usuario where NIF=?");
        users.setAuthoritiesByUsernameQuery("SELECT NIF, ROL FROM roles WHERE NIF=?");
        return users;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                // Recursos estáticos que no requieren autentificación.
                .requestMatchers("/css/**").permitAll()
                // No se requiere autenticación para acceso a la raiz y al login
                .requestMatchers("/", "/login", "/signup").permitAll()
                // Solo puede acceder a la vista clientes el usuario con rol SUPERUSUARIO
                .requestMatchers("/admin").hasAuthority("ADMINISTRADOR")
                // Solo puede acceder a la vista productos el usuario con rol USUARIO
                .requestMatchers("/user").hasAnyAuthority("USUARIO", "ADMINISTRADOR")
                // Se requiere autenticación para el resto de reutas.
                .anyRequest().authenticated()
                // Se permite iniciar y cerrar sesión.
                .and().formLogin().loginPage("/login").permitAll().and().logout().permitAll()
                // Error permiso denegado
                .and().exceptionHandling().accessDeniedPage("/denegado");
        return http.build();
    }

}
