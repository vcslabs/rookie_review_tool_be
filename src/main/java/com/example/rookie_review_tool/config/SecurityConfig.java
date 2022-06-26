package com.example.rookie_review_tool.config;

import com.example.rookie_review_tool.security.AuthSuccessHandler;
import com.example.rookie_review_tool.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /**
     *　静的リソースに対してセキュリティを無効に設定
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers( "/css/**"
                        , "/img/**"
                        , "/js/**"
                        , "/fonts/**");
    }

    /**
     * csrf, 認証認可, ログアウトについての設定
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable().authorizeRequests()
                .antMatchers("/login", "/v1/**").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .successHandler(new AuthSuccessHandler());

        http
                .logout() // ログアウトに関する設定
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウトさせる際に遷移させるパス
                .logoutSuccessUrl("/login") // ログアウト後に遷移させるパス(ここではログイン画面を設定)
                .deleteCookies("JSESSIONID") // ログアウト後、Cookieに保存されているセッションIDを削除
                .invalidateHttpSession(true); // true:ログアウト後、セッションを無効にする false:セッションを無効にしない
    }

    @Autowired
    void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

