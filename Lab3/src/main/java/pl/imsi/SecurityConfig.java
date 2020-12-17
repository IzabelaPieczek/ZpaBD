package pl.imsi;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService(){
		
		UserDetails guest = User.withDefaultPasswordEncoder()
				.username("quest")
				.password("guestPass")
				.roles("GUEST")
				.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("userPass")
				.roles("USER")
				.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("adminPass")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(guest, user, admin);
		
	}
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/employees/all").permitAll()
		.antMatchers(HttpMethod.GET, "/api/employees/id").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/employees/add").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/employees/delete").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/department/all").permitAll()
		.antMatchers(HttpMethod.GET, "/api/department/id").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/api/department/add").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/department/delete").hasRole("ADMIN")
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.csrf().disable();	
		
	
	}
}
