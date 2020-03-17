package ru.illine.presenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.illine.presenter.exception.PresenterException;
import ru.illine.presenter.service.FileReader;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j(topic = "CONTROLLER")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonController {

    private final FileReader<String> jsonReader;

    @Autowired
    JsonController(FileReader<String> jsonReader) {
        this.jsonReader = jsonReader;
    }

    @GetMapping("**")
    public ResponseEntity<String> getJson() {
        return ResponseEntity.ok(jsonReader.read());
    }

    @RestControllerAdvice
    @Slf4j(topic = "EXCEPTION-HANDLER")
    public static class PresenterExceptionHandler {

        @ExceptionHandler(PresenterException.class)
        ResponseEntity<String> presenterException(PresenterException e) {
            LOGGER.error("Error read a json", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        @ExceptionHandler(Exception.class)
        ResponseEntity<String> exception(Exception e) {
            LOGGER.error("Unknown error occurs!", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

}