package ru.illine.presenter.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "presenter")
public class PresenterProperties {

    @NotBlank
    private String jsonDir;

    @NotBlank
    private String jsonPath;

    public Path getJsonDir() {
        return Paths.get(jsonDir);
    }

    public Path getJsonPath() {
        return Paths.get(jsonPath);
    }
}