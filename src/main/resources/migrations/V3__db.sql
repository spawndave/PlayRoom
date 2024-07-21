CREATE TABLE play_room.room_toy
(
    room_id INT NOT NULL,
    toy_id INT NOT NULL,
    FOREIGN KEY (toy_id) REFERENCES play_room.room(id),
    FOREIGN KEY (toy_id) REFERENCES play_room.toy(id)
);