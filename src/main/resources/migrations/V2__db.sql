
CREATE TABLE `play_room`.`visitor` (
                                       `user_id` INT NOT NULL,
                                       `room_id` INT NOT NULL,
                                       UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC));

CREATE TABLE `play_room`.`agegroup` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `age` INT NOT NULL,
                                        `description` VARCHAR(256) NULL,
                                        PRIMARY KEY (`id`));

CREATE TABLE `play_room`.`user` (
                                    `id` INT NOT NULL AUTO_INCREMENT,
                                    `name` VARCHAR(256) NOT NULL,
                                    `age` INT NOT NULL,
                                    PRIMARY KEY (`id`));

CREATE TABLE `play_room`.`toy` (
                                   `id` INT NOT NULL AUTO_INCREMENT,
                                   `price` DECIMAL(5,2) NOT NULL,
                                   `age_group_id` INT NOT NULL,
                                   `size_id` INT NOT NULL,
                                   `description` VARCHAR(256) NULL,
                                   PRIMARY KEY (`id`));

