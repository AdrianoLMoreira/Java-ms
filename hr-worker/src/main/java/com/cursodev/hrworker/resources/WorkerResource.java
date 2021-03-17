package com.cursodev.hrworker.resources;

import com.cursodev.hrworker.entities.Worker;
import com.cursodev.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workRepo;

    @RequestMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workRepo.findAll();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workRepo.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
