package com.rbiedrawa.prometheus;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> apiRoute() {
		return RouterFunctions.route(GET("hello"), helloWorldFunction());
	}

	private HandlerFunction<ServerResponse> helloWorldFunction() {
		return request -> ServerResponse.ok().body(Mono.just("Hello World!"), String.class);
	}
}
