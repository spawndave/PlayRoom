package com.academy;

import com.academy.model.entity.Room;
import com.academy.model.service.RoomService;

public class Main {
    public static void main(String[] args) {
        RoomService service = new RoomService();
        Room room = service.prepareRoom(75, service.getAgeGroup(6));
        System.out.println(service.findToysInRoomByPrice(room, 100));
    }
}
