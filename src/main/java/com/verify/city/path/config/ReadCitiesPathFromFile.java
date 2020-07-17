package com.verify.city.path.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.verify.city.path.util.Graph;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*
* This class helps reading the text file and passes each city to Graph class.
*
* */
@Configuration
public class ReadCitiesPathFromFile {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResourceLoader resourceLoader;


   public static Map<String, Graph> map = new HashMap<>();



    @Bean
    public void readTextfile() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:cities.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        //InputStream inputStream = resource.getInputStream();
        String line;//, node1, node2;
        Graph graph = new Graph();
        log.info("----Start reading Cities from text file---");
        while((line = reader.readLine()) != null){
            String[] cities = line.split(",");

            graph.addEdge(cities[0].trim(), cities[1].trim());
            graph.addEdge(cities[1].trim(), cities[0].trim());
            log.info(cities[1] +"," + cities[0]);

        }
        log.info("----End of reading Cities from text file---");
        map.put("graph" , graph);

    }
}
