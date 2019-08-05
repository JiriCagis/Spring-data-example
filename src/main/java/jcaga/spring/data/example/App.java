package jcaga.spring.data.example;

import jcaga.spring.data.example.service.ExamplesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    ExamplesService examplesService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Startup application...");
        examplesService.manyToOneRelationExample();
        examplesService.oneToManyRelationExample();
        examplesService.oneToOneRelationExample();
        examplesService.manyToManyRelationExample();
    }

}
