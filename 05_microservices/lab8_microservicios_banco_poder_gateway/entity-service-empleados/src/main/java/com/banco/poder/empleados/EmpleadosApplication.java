package com.banco.poder.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import zipkin.Span;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.Encoding;
import zipkin.reporter.okhttp3.OkHttpSender;



@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
public class EmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApplication.class, args);
	}
	
	@Bean
	  public io.opentracing.Tracer zipkinTracer(@Value("${zipkin.endpoint:http://localhost:9411}") String zipkinEndpoint, @Value("${spring.application.name}") String serviceName) {
	    OkHttpSender okHttpSender = OkHttpSender.builder()
	      .encoding(Encoding.JSON)
	      .endpoint(zipkinEndpoint + "/api/v1/spans")
	      .build();
	    AsyncReporter<Span> reporter = AsyncReporter.builder(okHttpSender).build();
	    Tracing braveTracer = Tracing.newBuilder()
	      .localServiceName(serviceName)
	      .reporter(reporter)
	      .traceId128Bit(true)
	      .sampler(Sampler.ALWAYS_SAMPLE)
	      .build();
	    return BraveTracer.create(braveTracer);
	  }

}
