package init.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import init.converter.ConversorJWT;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Value("${db.security.driver}")
	private String driver;
	@Value("${db.security.url}")
	private String url;
	@Value("${db.security.user}")
	private String user;
	@Value("${db.security.password}")
	private String pass;
	
	@Autowired
	ConversorJWT conversorJwt;
	
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		http.csrf(c->c.disable())
		.authorizeHttpRequests(
				aut->aut.requestMatchers(HttpMethod.GET, "/alumnos","/alumnos/por-curso").authenticated()
				.requestMatchers(HttpMethod.POST, "/alumnos").hasRole("ADMINS")
				.requestMatchers(HttpMethod.DELETE, "/alumnos").hasAnyRole("ADMINS","OPERATORS")
				.anyRequest().permitAll()
				)
		.oauth2ResourceServer(oauth2ResourceServer-> oauth2ResourceServer
				.jwt(jwt->jwt .jwtAuthenticationConverter(conversorJwt))) 
        .sessionManagement(sessionManagement-> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
		
	}
}
