//package com.miniproject2.ooad.resource;
//
//public class RoomRequest {
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
//    public RoomRequest() {
//    }
//
//    public RoomRequest(int r_id, int floor, String block, int year, String[] roommates) {
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
package com.miniproject2.ooad.resource;

public class RoomRequest {


    private int roomno;
    private int floor;

    private String block;

    public int year;

    private String[] roommates;

    public RoomRequest() {
    }

    public RoomRequest( int roomno, int floor, String block, int year, String[] roommates) {
        this.roomno=roomno;
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