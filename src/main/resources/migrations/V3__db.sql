CREATE TABLE play_room_2.room_toy
(
    room_id INT NOT NULL,
    toy_id INT NOT NULL,
    FOREIGN KEY (toy_id) REFERENCES play_room_2.room(id),
    FOREIGN KEY (toy_id) REFERENCES play_room_2.toy(id)
);