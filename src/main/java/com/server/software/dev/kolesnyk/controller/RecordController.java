package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.entity.Record;
import com.server.software.dev.kolesnyk.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/home/v1/records")
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/{recordId}")
    public Record getRecordById(@PathVariable int recordId) {
        return recordRepository.getById(recordId);
    }

    @GetMapping
    public Collection<Record> getAllRecords() {
        return recordRepository.getAll();
    }

    @GetMapping("/user/{userId}")
    public Collection<Record> getRecordsByUserId(@PathVariable int userId) {
        return recordRepository.getByUserId(userId);
    }

    @GetMapping("/category/{categoryId}")
    public Collection<Record> getRecordsByCategoryId(@PathVariable int categoryId) {
        return recordRepository.getByCategoryId(categoryId);
    }

    @PostMapping
    public void createRecord(@RequestBody Record record) {
        recordRepository.create(record);
    }

    @PutMapping("/{recordId}")
    public void updateRecord(@RequestBody Record record, @PathVariable int recordId) {
        recordRepository.update(record, recordId);
    }

    @DeleteMapping("{recordId}")
    public void deleteRecord(@PathVariable int recordId) {
        recordRepository.delete(recordId);
    }
}
