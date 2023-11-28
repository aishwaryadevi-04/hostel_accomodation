//package com.miniproject2.ooad.Controllers;
//
//import com.miniproject2.ooad.models.Student;
//import com.miniproject2.ooad.repository.StudentRepository;
//import com.miniproject2.ooad.resource.StudentRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//@RestController
//public class StudentController {
//
//    private final StudentRepository studentRepository;
//    private final StudentService studentService;
//
//    @Autowired
//    public StudentController(StudentRepository studentRepository, StudentService studentService) {
//        this.studentRepository = studentRepository;
//        this.studentService = studentService;
//    }
//
//    @GetMapping("/Student")
//    public ResponseEntity<List<Student>> getAllStudents() {
//        return ResponseEntity.ok(this.studentRepository.findAll());
//    }
//
//    @PostMapping("/Student")
//    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest){
//        Student student = new Student();
//        student.setS_id(studentRequest.getS_id());
//        student.setA_id(studentRequest.getA_id());
//        student.setS_name(studentRequest.getS_name());
//        student.setRegno(studentRequest.getRegno());
//        student.setPassword(studentRequest.getPassword());
//        student.setYear(studentRequest.getYear());
//        student.setDept(studentRequest.getDept());
//        student.setAd_status(studentRequest.getAd_status());
//        student.setPay_status(studentRequest.getPay_status());
//        student.setR_id(studentRequest.getR_id());
//
//        return ResponseEntity.status(201).body(this.studentRepository.save(student));
//    }
//    @GetMapping("/Student/{_id}")
//    public ResponseEntity getAllStudentsById(@PathVariable String _id) {
//        Optional<Student> student = this.studentRepository.findById(_id);
//
//        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        } else {
//            return ResponseEntity.ok("The Student with id" + _id + "was not found");
//        }
//    }
//    @PatchMapping("/Student/{regno}")
//    public ResponseEntity<String> updateAdmissionStatus(
//            @PathVariable int regno,
//            @RequestParam String ad_status) {
//
//        try {
//            studentService.updateAdStatus(regno, ad_status);
//            return ResponseEntity.ok("Admission status updated successfully.");
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
//        } catch (Exception e) {
//            // Log the exception details
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating admission status.");
//        }
//    }
//
//}
package com.miniproject2.ooad.Controllers;

import com.miniproject2.ooad.models.Student;
import com.miniproject2.ooad.repository.StudentRepository;
import com.miniproject2.ooad.resource.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping("/Student")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @PostMapping("/Student")
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest){
        Student student = new Student();
        student.setS_name(studentRequest.getS_name());
        student.setRegno(studentRequest.getRegno());
        student.setPassword(studentRequest.getPassword());
        student.setYear(studentRequest.getYear());
        student.setDept(studentRequest.getDept());
        student.setAd_status(studentRequest.getAd_status());
        student.setPay_status(studentRequest.getPay_status());
        student.setRoomno(studentRequest.getRoomno());
        student.setAno(studentRequest.getAno());
        return ResponseEntity.status(201).body(this.studentRepository.save(student));
    }
    @PostMapping("/Student/login")
    public ResponseEntity<Object> login(@RequestBody StudentRequest loginRequest) {
        Integer regno = loginRequest.getRegno();
        String password = loginRequest.getPassword();

        // Find the student by registration number
        Optional<Student> optionalStudent = studentRepository.findByRegno(regno);

        if (optionalStudent.isPresent()) {

            Student student = optionalStudent.get();
            if (password.equals(student.getPassword())) {

                return ResponseEntity.ok(student);
            } else {

                String errorMessage = "Incorrect password. Please try again.";
                return ResponseEntity.status(401).body(errorMessage);
            }
        } else {

            String errorMessage = "Student not found for registration number: " + regno;
            return ResponseEntity.status(401).body(errorMessage);
        }
    }
    @GetMapping("/Student/{s_id}")
    public ResponseEntity getAllStudentsById(@PathVariable String s_id) {
        Optional<Student> student = this.studentRepository.findById(s_id);

        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        } else{
            return ResponseEntity.ok("The Student with id" + s_id + "was not found");
        }

    }
    @PatchMapping("/Student/{s_id}/selectRoom")
    public ResponseEntity<String> selectRoom(
            @PathVariable("s_id") String s_id,
            @RequestParam("roomno") int roomno) {

        Optional<Student> optionalStudent = this.studentRepository.findById(s_id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setRoomno(roomno);  // Assuming r_id is a String, update it accordingly

            this.studentRepository.save(student);

            return ResponseEntity.status(201).body("Room allocated successfully");
        } else {
            return ResponseEntity.ok("The Student with id" + s_id + "was not found");
        }
    }
    @PatchMapping("/Student/adStatus/{regno}")
    public ResponseEntity<String> updateAdmissionStatus(
            @PathVariable int regno,
            @RequestParam String ad_status) {

        try {
            studentService.updateAdStatus(regno, ad_status);
            return ResponseEntity.ok("Admission status updated successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating admission status.");
        }
    }
    @PatchMapping("/Student/payStatus/{regno}")
    public ResponseEntity<String> updatePaymentStatus(
            @PathVariable int regno,
            @RequestParam String pay_status) {

        try {
            studentService.updatePayStatus(regno, pay_status);
            return ResponseEntity.ok("Payment status updated successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating payment status.");
        }
    }

}