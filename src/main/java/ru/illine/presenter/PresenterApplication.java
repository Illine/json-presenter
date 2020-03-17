package ru.illine.presenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.illine.presenter.property.PresenterProperties;

@EnableConfigurationProperties(PresenterProperties.class)
@SpringBootApplication
public class PresenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresenterApplication.class, args);
    }

}
