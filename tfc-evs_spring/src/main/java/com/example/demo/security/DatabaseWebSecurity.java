package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT nombreusuario, contrasena, activo FROM usuarios WHERE nombreusuario = ?")
                .authoritiesByUsernameQuery("SELECT u.nombreusuario , r.nombrerol FROM usuariosxrol ur" +
                        " JOIN usuarios u ON u.id = ur.idusuario" +
                        " JOIN rol r ON r.id = ur.idrol" +
                        " WHERE u.nombreusuario = ? and r.nombrerol = 'ADMINISTRADOR'");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
        		.antMatchers("/store/**").permitAll()
                .antMatchers("/pedidos/**").hasAnyAuthority("ADMINISTRADOR")
                .antMatchers("/productos/**").hasAnyAuthority("ADMINISTRADOR")
                .antMatchers("/users/**").hasAnyAuthority("ADMINISTRADOR")

            // LOGIN
            .and().formLogin().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}