//package com.miniproject2.ooad.models;
//
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document("Admission")
//public class Admission {
//
//
//    public int a_id;
//
//    public String s_name;
//
//    public int regno;
//
//    public String dept;
//    public int year;
//    private String[] certificates;
//
//    public Admission() {
//    }
//
//    public Admission(int a_id, String s_name, int regno, String dept, int year, String[] certificates) {
//        this.a_id = a_id;
//        this.s_name = s_name;
//        this.regno = regno;
//        this.dept = dept;
//        this.year = year;
//        this.certificates = certificates;
//    }
//
//    public String getS_name() {
//        return s_name;
//    }
//
//    public void setS_name(String s_name) {
//        this.s_name = s_name;
//    }
//
//    public int getRegno() {
//        return regno;
//    }
//
//    public void setRegno(int regno) {
//        this.regno = regno;
//    }
//
//    public String getDept() {
//        return dept;
//    }
//
//    public void setDept(String dept) {
//        this.dept = dept;
//    }
//
//    public int getA_id() {
//        return a_id;
//    }
//
//    public void setA_id(int a_id) {
//        this.a_id = a_id;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//
//    public String[] getCertificates() {
//        return certificates;
//    }
//
//    public void setCertificates(String[] certificates) {
//        this.certificates = certificates;
//    }
//}
package com.miniproject2.ooad.models;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Admission")
public class Admission {

    @Id
    public String a_id;

    public int ano;
    public String s_name;

    public int regno;

    public String dept;
    public int year;
    private String[] certificates;

    public Admission() {
    }



    public Admission(String a_id, int ano, String s_name, int regno, String dept, int year, String[] certificates) {
        this.a_id = a_id;
        this.ano = ano;
        this.s_name = s_name;
        this.regno = regno;
        this.dept = dept;
        this.year = year;
        this.certificates = certificates;
    }

    public String getA_id() {
        return a_id;
    }
    public void setA_id(String a_id) {
        this.a_id = a_id;
    }


    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String[] getCertificates() {
        return certificates;
    }

    public void setCertificates(String[] certificates) {
        this.certificates = certificates;
    }
}