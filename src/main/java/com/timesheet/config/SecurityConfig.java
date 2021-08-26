package com.timesheet.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(jsr250Enabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserDetailsService userDetailsService;
    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((authorize) -> authorize
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // 靜態資源，比如 css,js 無需登錄鑒權
                .anyRequest()
                .authenticated())
                .formLogin((formLogin) -> formLogin  // 自定義登錄頁面
                        .loginPage("/login") // 登錄頁
                        .failureUrl("/login?error") // 登錄錯誤
                        .loginProcessingUrl("/doLogin") // 自定義登錄請求地址
                        .defaultSuccessUrl("/record_working")
                        .permitAll()//
                ).logout(LogoutConfigurer::permitAll) // 登出頁面
                .httpBasic()
                .and().csrf().disable()
                .rememberMe(rememberMe -> rememberMe
                        .rememberMeParameter("remember-me")
                        .rememberMeCookieName("timesheet_login") // 自定義記住我 cookie 名
                        .tokenValiditySeconds(3600 * 12));; // 記住我，本地生成 cookie 包含用戶資訊
    }
        //TODO 權限設定
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/data").hasAuthority("add")
//                .antMatchers(HttpMethod.GET, "/api/data").hasAuthority("query")
//                .antMatchers("/home").hasAuthority("base");

    /**
     * 使用自定義用戶服務校驗登錄資訊
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        // 用戶登錄資訊校驗使用自定義 userService
        // 還需要注意密碼加密與驗證需要使用同一種方式
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/static/**/**");
    }
}
