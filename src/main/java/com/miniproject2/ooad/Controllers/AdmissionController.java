//package com.miniproject2.ooad.Controllers;
//
//import com.miniproject2.ooad.models.Admission;
//
//
//import com.miniproject2.ooad.repository.AdmissionRepository;
//import com.miniproject2.ooad.resource.AdmissionRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class AdmissionController {
//
//    private final AdmissionRepository admissionRepository;
//
//    public AdmissionController(AdmissionRepository admissionRepository) {
//        this.admissionRepository = admissionRepository;
//    }
//
//
//    @GetMapping("/Admission")
//    public ResponseEntity<List<Admission>> getAllAdmissions() {
//        return ResponseEntity.ok(this.admissionRepository.findAll());
//
//    }
//
//@GetMapping("/Admission/{year}")
//public ResponseEntity<List<Admission>> getAdmissionsByYear(@PathVariable int year) {
//    List<Admission> admissions = admissionRepository.findByYear(year);
//
//    if (!admissions.isEmpty()) {
//        return ResponseEntity.ok(admissions);
//    } else {
//        return ResponseEntity.notFound().build();
//    }
//}
//
//    @GetMapping("/Admission/{year}/{a_id}")
//    public ResponseEntity<Admission> getAdmissionByYearAndId(@PathVariable int year, @PathVariable int a_id) {
//        List<Admission> admissions = admissionRepository.findByYear(year);
//
//        Optional<Admission> matchingAdmission = admissions.stream()
//                .filter(admission -> admission.getA_id() == a_id)
//                .findFirst();
//
//        return matchingAdmission.map(admission -> ResponseEntity.ok(admission))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//
//    @PostMapping("/Admission")
//    public ResponseEntity<Admission> createAdmission(@RequestBody AdmissionRequest admissionRequest) {
//        Admission admission = new Admission();
//        admission.setA_id(admissionRequest.getA_id());
//        admission.setS_name(admissionRequest.getS_name());
//        admission.setYear(admissionRequest.getYear());
//        admission.setRegno(admissionRequest.getRegno());
//        admission.setDept(admissionRequest.getDept());
//        admission.setCertificates(admissionRequest.getCertificates());
//
//
//        return ResponseEntity.status(200).body(this.admissionRepository.save(admission));
//    }
//
//
//}
package com.miniproject2.ooad.Controllers;

import com.miniproject2.ooad.models.Admission;


import com.miniproject2.ooad.repository.AdmissionRepository;
import com.miniproject2.ooad.resource.AdmissionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class AdmissionController {

    private final AdmissionRepository admissionRepository;

    public AdmissionController(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }


    @GetMapping("/Admission")
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        return ResponseEntity.ok(this.admissionRepository.findAll());

    }


    @PostMapping("/Admission/apply")
    public ResponseEntity<Admission> createAdmission(@RequestBody AdmissionRequest admissionRequest) {
        Admission admission = new Admission();
        admission.setS_name(admissionRequest.getS_name());
        admission.setYear(admissionRequest.getYear());
        admission.setRegno(admissionRequest.getRegno());
        admission.setDept(admissionRequest.getDept());
        admission.setCertificates(admissionRequest.getCertificates());
        String uniqueA_no = generateUniqueANo();
        admission.setAno(Integer.parseInt(uniqueA_no));
        return ResponseEntity.status(200).body(this.admissionRepository.save(admission));
    }
    private String generateUniqueANo() {
        Random random = new Random();

        while (true) {
            int randomNumber = 10000 + random.nextInt(90000);
            if (!isANoExists(String.valueOf(randomNumber))) {
                return String.valueOf(randomNumber);
            }
        }
    }

    private boolean isANoExists(String aNo) {
        Admission existingAdmission = admissionRepository.findByano(Integer.parseInt(aNo));
        return existingAdmission != null;
    }

    @GetMapping("/Admission/{year}")
    public ResponseEntity<List<Admission>> getAdmissionsByYear(@PathVariable int year) {
        List<Admission> admissions = admissionRepository.findByYear(year);

        if (!admissions.isEmpty()) {
            return ResponseEntity.ok(admissions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/Admission/{year}/{ano}")
        public ResponseEntity<Admission> getAdmissionByYearAndId(@PathVariable int year, @PathVariable int ano) {
            List<Admission> admissions = admissionRepository.findByYear(year);

            Optional<Admission> matchingAdmission = admissions.stream()
                    .filter(admission -> admission.getAno() == ano)
                    .findFirst();

            return matchingAdmission.map(admission -> ResponseEntity.ok(admission))
                    .orElse(ResponseEntity.notFound().build());
        }
}