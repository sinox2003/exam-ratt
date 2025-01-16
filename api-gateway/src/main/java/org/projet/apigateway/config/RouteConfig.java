package org.projet.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/annonces/**")
                        .uri("lb://annonces-service"))
                .route(r -> r.path("/api/geo/**")
                        .uri("lb://geolocation-service"))
                .route(r -> r.path("/api/messages/**")
                        .uri("lb://messagerie-service"))
                .route(r -> r.path("/api/notifications/**")
                        .uri("lb://notification-service"))
                .route(r -> r.path("/api/users/**")
                        .uri("lb://user-security-service"))
                .route(r -> r.path("/auth/**")
                        .uri("lb://user-security-service"))
                .build();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://anotherdomain.com")); // Specific origins
//        configuration.addAllowedMethod("*"); // Allow all HTTP methods
//        configuration.addAllowedHeader("*"); // Allow all headers
//        configuration.setAllowCredentials(true); // Allow credentials (cookies, etc.)
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration); // Apply the configuration to all paths
//
//        return source;
//    }
}
