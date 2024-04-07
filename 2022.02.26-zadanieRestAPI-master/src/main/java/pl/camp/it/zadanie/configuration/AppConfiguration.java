package pl.camp.it.zadanie.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.it.zadanie.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@ComponentScan("pl.camp.it.zadanie")
public class AppConfiguration {

    @Bean
    public Map<String, Item> database() {
        return new HashMap<>();
    }

    @Bean
    public ExecutorService executor() {
        return Executors.newFixedThreadPool(4);
    }
}
