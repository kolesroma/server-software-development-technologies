package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.dto.RecordDto;
import com.server.software.dev.kolesnyk.entity.RecordEntity;
import com.server.software.dev.kolesnyk.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public void createRecord(@RequestBody @Valid RecordDto recordDto) {
        recordService.createRecord(recordDto);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<RecordEntity> getRecord(@PathVariable Integer recordId) {
        return ResponseEntity.of(recordService.getRecord(recordId));
    }

    @GetMapping
    public Collection<RecordEntity> getAllRecords(@RequestParam Integer page, @RequestParam Integer size) {
        return recordService.getAllRecords(page, size);
    }

    @PutMapping("/{recordId}")
    public void updateRecord(@RequestBody @Valid RecordDto recordDto, @PathVariable Integer recordId) {
        recordService.updateRecord(recordDto, recordId);
    }

    @DeleteMapping("/{recordId}")
    public void deleteRecord(@PathVariable Integer recordId) {
        recordService.deleteRecord(recordId);
    }
}
