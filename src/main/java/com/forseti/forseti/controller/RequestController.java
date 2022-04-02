package com.forseti.forseti.controller;

import com.forseti.forseti.model.Request;
import com.forseti.forseti.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @PostMapping(path = "/api/requests", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> addRequest(@RequestBody Request request) {
        var newRequest = requestService.addRequest(request);
        if (newRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
        }
    }
}
