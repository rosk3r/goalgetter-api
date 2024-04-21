package ru.rosk3r.goalgetterapi.auth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.rosk3r.goalgetterapi.auth.util.encoder.BCryptPasswordEncoder

@Configuration
class BeanConfig {

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder(4)

}