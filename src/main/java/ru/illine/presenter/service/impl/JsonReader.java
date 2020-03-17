package ru.illine.presenter.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.illine.presenter.exception.PresenterException;
import ru.illine.presenter.property.PresenterProperties;
import ru.illine.presenter.service.FileReader;

import java.io.IOException;
import java.nio.file.Files;

@Service
@Slf4j(topic = "SERVICE")
public class JsonReader implements FileReader<String> {

    private final PresenterProperties properties;

    @Autowired
    JsonReader(PresenterProperties properties) {
        this.properties = properties;
    }

    @Override
    public String read() {
        try {
            LOGGER.debug("A json is read by a path: {}", properties.getJsonPath());
            return Files.readString(properties.getJsonPath());
        } catch (IOException e) {
            throw new PresenterException(e);
        }
    }
}