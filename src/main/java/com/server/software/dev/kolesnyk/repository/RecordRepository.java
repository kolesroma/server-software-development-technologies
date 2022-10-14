package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RecordRepository {
    private final Map<Integer, Record> records = new HashMap<>();

    public void create(Record record) {
        records.put(record.getId(), record);
    }

    public Record getById(int id) {
        return records.get(id);
    }

    public Collection<Record> getAll() {
        return records.values();
    }

    public Collection<Record> getByUserId(int userId) {
        return records.values().stream()
                .filter(record -> record.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public Collection<Record> getByCategoryId(int categoryId) {
        return records.values().stream()
                .filter(record -> record.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    public void update(Record record, int id) {
        records.put(id, record);
    }

    public void delete(int id) {
        records.remove(id);
    }
}
