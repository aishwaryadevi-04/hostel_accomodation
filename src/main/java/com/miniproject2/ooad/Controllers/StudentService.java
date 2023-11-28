package com.miniproject2.ooad.Controllers;

import com.miniproject2.ooad.models.Student;
import com.miniproject2.ooad.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.MongoTemplate;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public StudentService(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        this.studentRepository = studentRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void updateAdStatus(int regno, String newAdStatus) {
        Query query = new Query(Criteria.where("regno").is(regno));
        Update update = new Update().set("ad_status", newAdStatus);

        mongoTemplate.updateFirst(query, update, Student.class);
    }
    public void updatePayStatus(int regno, String newpayStatus) {
        Query query = new Query(Criteria.where("regno").is(regno));
        Update update = new Update().set("pay_status", newpayStatus);

        mongoTemplate.updateFirst(query, update, Student.class);
    }
}
