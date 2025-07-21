package com.shanuka.ecom;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("customer-service",
                        r -> r.path("/api/v1/customer/**")
                                .uri("lb:http://CUSTOMER-SERVICE")
                        )
                .route("order-service",
                        r -> r.path("/api/v1/orders/**")
                                .uri("lb:http://ORDER-SERVICE")
                        )
                .route("product-service",
                        r -> r.path("/api/v1/products/**")
                                .uri("lb:http://PRODUCT-SERVICE")
                )
                .route("order-reference-service",
                    r -> r.path("/api/v1/order-reference/**")
                            .uri("lb:http://ORDER-SERVICE")
                )
                .route("payment-service",
                        r -> r.path("/api/v1/payments")
                                .uri("lb:http://PAYMENT-SERVICE")
                        )
                .build();
    }

}
