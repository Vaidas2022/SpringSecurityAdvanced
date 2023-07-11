package lt.codeacademy.learn.securitydb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static lt.codeacademy.learn.securitydb.utils.Roles.*;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		.antMatchers("/admin/**").hasRole(ADMIN)
//		.antMatchers("/user/**").hasAnyRole(USER,ADMIN)
		.antMatchers(HttpMethod.POST,"/registration").permitAll()
		.antMatchers("/error").permitAll()
		.antMatchers("/**").permitAll().anyRequest().anonymous()
		.and()
		.formLogin();
		
		return http.build();
	}
	
	@Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }
}
