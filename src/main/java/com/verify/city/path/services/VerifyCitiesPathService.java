package com.verify.city.path.services;

import com.verify.city.path.config.ReadCitiesPathFromFile;
import com.verify.city.path.util.Search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyCitiesPathService {

    private final Logger log = LoggerFactory.getLogger(Search.class);

    @Autowired
    private Search search;

    public VerifyCitiesPathService(){}

    public VerifyCitiesPathService(Search search) {
        this.search = search;
    }

    public String findCitiesPath(String origin, String destination){
        log.info("inside FindCitiesPathService.class - findCitiesPath metho()) ");

        search.setSTART(origin);
        search.setEND(destination);

        return search.searchPath(ReadCitiesPathFromFile.map.get("graph"));
    }
}
