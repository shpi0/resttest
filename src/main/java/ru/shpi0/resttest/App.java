package ru.shpi0.resttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.shpi0.resttest.config.DataInitializer;

@SpringBootApplication
public class App {

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

    @Bean(initMethod = "init")
    public DataInitializer initializer() {
        return new DataInitializer();
    }

}
