package com.hotel.project.hotelproject.security.config;

//import com.example.demo.appuser.AppUserService;
import com.hotel.project.hotelproject.user.UserService;

import lombok.AllArgsConstructor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.crypto.password.PasswordEncoder;
@CrossOrigin(origins = "*")
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private  BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
	 
	 public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	 
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:8080",
                "http://localhost:19006"
                
                )
        );
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(
                Arrays.asList(
                        "Access-Control-Allow-Headers",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Origin", "Cache-Control",
                        "Content-Type",
                        "Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        .cors().configurationSource(corsConfigurationSource());
	
        http 
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/1.0/login","/api/1.0/user","/api/1.0/confirm")
                .permitAll()
            .anyRequest()
            .authenticated()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http
        //.cors().configurationSource(corsConfigurationSource());
       // http.csrf().disable().cors().and().headers().frameOptions().disable();
	
        http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
    }
	

	
 
    
    /*
        private  UserService userService;
	 
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
	private JWTTokenHelper jWTTokenHelper;



	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	 
	 @Autowired
    public WebSecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	 
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//This is old code
        http 
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/registration/**")
                .permitAll()
            .anyRequest()
            .authenticated().and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/", true)
            .permitAll(); 
	
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint).and()
		.authorizeRequests((request) -> request.antMatchers("/registration/**", "/login").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated());

        http.csrf().disable().cors().and().headers().frameOptions().disable();
        
		 http 
         .csrf().disable();
          //
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint).and()
		.authorizeRequests((request) -> request.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER","ADMIN")
				.antMatchers("/api/1.0/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated());
		
		//.addFilterBefore(new JWTAuthenticationFilter(userService),
				//UsernamePasswordAuthenticationFilter.class);
		http.cors();

        http.csrf().disable().cors().and().headers().frameOptions().disable(); 
       
        
    }
	

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    
   // This is old code
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("test1@gmail.com").password("hello")
				.authorities("USER", "ADMIN");

		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}//

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
     
     
     */
}