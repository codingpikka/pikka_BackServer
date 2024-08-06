package com.ohgiraffers.pikka_backserver.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @PostMapping
    public ResponseEntity<Data> saveData(@RequestBody Data newData) {
        Data savedData = dataRepository.save(newData);
        return ResponseEntity.ok(savedData);
    }
}
