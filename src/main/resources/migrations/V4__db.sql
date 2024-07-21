CREATE TABLE play_room.size ( `id` INT NOT NULL AUTO_INCREMENT,
                                `size` VARCHAR(127) NOT NULL,
                                `description` VARCHAR(256) NOT NULL,
                                 PRIMARY KEY (`id`));

INSERT INTO play_room.user (`name`, `age`) VALUES ('Mike', '3');
INSERT INTO play_room.user (`name`, `age`) VALUES ('Jane', '5');
INSERT INTO play_room.user (`name`, `age`) VALUES ('Nick', '9');

INSERT INTO play_room.agegroup (`id`, `age`, `description`) VALUES ('1', '6', 'Small');
INSERT INTO play_room.agegroup (`id`, `age`, `description`) VALUES ('2', '12', 'Medium');
INSERT INTO play_room.agegroup (`id`, `age`, `description`) VALUES ('3', '70', 'Big');

INSERT INTO play_room.size (`id`, `size`, `description`) VALUES ('1', 'S', 'Small');
INSERT INTO play_room.size (`id`, `size`, `description`) VALUES ('2', 'M', 'Medium');
INSERT INTO play_room.size (`id`, `size`, `description`) VALUES ('3', 'L', 'Large');

INSERT INTO play_room.toy (`price`, `age_group_id`, `size_id`, `description`) VALUES ('22', '1', '3', 'Bear');
INSERT INTO play_room.toy (`price`, `age_group_id`, `size_id`, `description`) VALUES ('2.5', '1', '1', 'Bear');
INSERT INTO play_room.toy (`price`, `age_group_id`, `size_id`, `description`) VALUES ('15', '2', '3', 'Star');
INSERT INTO play_room.toy (`price`, `age_group_id`, `size_id`, `description`) VALUES ('12', '2', '2', 'Star');

