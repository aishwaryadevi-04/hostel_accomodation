package com.miniproject2.ooad.repository;

import com.miniproject2.ooad.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findByRegno(int regno);

    @Query("{'regno': ?0}")
    void updatePayStatusByRegno(int regno, String newPayStatus);
    @Query("{'regno': ?0}")
    void updateAdStatusByRegno(int regno, String newAdStatus);
}

