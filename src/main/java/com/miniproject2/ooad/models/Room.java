//package com.miniproject2.ooad.models;
//
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document("Room")
//public class Room {
//
//
//    public int r_id;
//
//    private int floor;
//
//    private String block;
//
//    public int year;
//
//    private String[] roommates;
//
//    public Room() {
//    }
//
//    public Room(int r_id, int floor, String block, int year, String[] roommates) {
//        this.r_id = r_id;
//        this.floor = floor;
//        this.block = block;
//        this.year = year;
//        this.roommates = roommates;
//    }
//
//    public int getR_id() {
//        return r_id;
//    }
//
//    public void setR_id(int r_id) {
//        this.r_id = r_id;
//    }
//
//    public int getFloor() {
//        return floor;
//    }
//
//    public void setFloor(int floor) {
//        this.floor = floor;
//    }
//
//    public String getBlock() {
//        return block;
//    }
//
//    public void setBlock(String block) {
//        this.block = block;
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
//    public String[] getRoommates() {
//        return roommates;
//    }
//
//    public void setRoommates(String[] roommates) {
//        this.roommates = roommates;
//    }
//}
package com.miniproject2.ooad.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Room")
public class Room {

    @Id
    public String r_id;

    private int roomno;


    private int floor;

    private String block;

    public int year;

    private String[] roommates;

    public Room() {
    }

    public Room(String r_id, int floor, String block, int year, String[] roommates) {
        this.r_id = r_id;
        this.floor = floor;
        this.block = block;
        this.year = year;
        this.roommates = roommates;
    }
    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String[] getRoommates() {
        return roommates;
    }

    public void setRoommates(String[] roommates) {
        this.roommates = roommates;
    }
}