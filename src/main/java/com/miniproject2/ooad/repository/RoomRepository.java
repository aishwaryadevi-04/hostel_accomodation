package com.miniproject2.ooad.repository;

import com.miniproject2.ooad.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
