package com.cursodev.hrworker.resources;

import com.cursodev.hrworker.entities.Worker;
import com.cursodev.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository workRepo;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workRepo.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = " +environment.getProperty("local.server.port"));
        Optional<Worker> worker = workRepo.findById(id);
        if (worker.isPresent())
            return ResponseEntity.ok(worker.get());
        else
            return ResponseEntity.noContent().build();
    }
}
