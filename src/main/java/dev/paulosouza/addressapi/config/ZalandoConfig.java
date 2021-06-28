package dev.paulosouza.addressapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.zalando.problem.ProblemModule;

@Configuration
@Slf4j
public class ZalandoConfig {

    @Bean({"problem"})
    public ProblemModule problemModule() {
        return new ProblemModule();
    }

    @Bean
    @DependsOn({"problem"})
    public ObjectMapper objectMapper() {
        return  new ObjectMapper()
                .registerModule(new ProblemModule());
    }

}
