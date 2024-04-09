package ru.rosk3r.goalgetterapi.auth.config

import io.shapito.tasks.auth.util.encoder.BCryptPasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder(4)

}