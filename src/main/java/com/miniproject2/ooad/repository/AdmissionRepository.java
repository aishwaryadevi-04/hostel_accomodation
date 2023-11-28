package com.miniproject2.ooad.repository;

import com.miniproject2.ooad.models.Admission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionRepository extends MongoRepository<Admission, String> {
        List<Admission> findByYear(int year);
        Admission findByano(int ano);
}
