package com.verify.city.path.controller;


import com.verify.city.path.services.VerifyCitiesPathService;
import com.verify.city.path.util.Search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyCitiesPathController {

    private final Logger log = LoggerFactory.getLogger(Search.class);

    @Autowired
    VerifyCitiesPathService service;

    @GetMapping("/connected")
    public ResponseEntity<String> findCitiesPath(@RequestParam @NonNull String origin, @RequestParam @NonNull String destination){

        log.info("Service call : /connect");

        return new ResponseEntity<>(service.findCitiesPath(origin, destination), HttpStatus.OK);
    }


}
