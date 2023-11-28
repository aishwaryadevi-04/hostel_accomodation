package com.miniproject2.ooad.Controllers;



import com.miniproject2.ooad.models.Room;
import com.miniproject2.ooad.models.Student;
import com.miniproject2.ooad.repository.RoomRepository;
import com.miniproject2.ooad.resource.RoomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/Room")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(this.roomRepository.findAll());
    }

    @PostMapping("/Room")
    public ResponseEntity<Room> createRoom(@RequestBody RoomRequest roomRequest) {
        Room room = new Room();
        room.setRoomno(roomRequest.getRoomno());
        room.setFloor(roomRequest.getFloor());
        room.setBlock(roomRequest.getBlock());
        room.setYear(roomRequest.getYear());
        room.setRoommates(roomRequest.getRoommates());

        return ResponseEntity.status(200).body(this.roomRepository.save(room));
    }


    @PatchMapping("/Room/{r_id}/addStudent")
    public ResponseEntity<String> addStudentToRoommates(
            @PathVariable("r_id") String r_id,
            @RequestParam String studentId) {
        Optional<Room> optionalRoom  = this.roomRepository.findById(r_id);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();

            if (room.getRoommates().length < 3) {
                String[] updatedRoommates = new String[room.getRoommates().length + 1];
                System.arraycopy(room.getRoommates(), 0, updatedRoommates, 0, room.getRoommates().length);
                updatedRoommates[room.getRoommates().length] = studentId;
                room.setRoommates(updatedRoommates);
                this.roomRepository.save(room);
                return ResponseEntity.ok("Student added to roommates list successfully.");
            }
            else{
                return ResponseEntity.ok("Room capacity reached");
            }
        }
        return ResponseEntity.badRequest().body("Room not found or maximum roommates reached.");
    }


}