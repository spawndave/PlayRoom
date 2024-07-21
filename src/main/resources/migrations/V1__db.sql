CREATE TABLE `play_room_2`.`room` (
                                    `id` INT NOT NULL AUTO_INCREMENT,
                                    `age_group_id` INT NOT NULL,
                                    `total_sum` DECIMAL(6,2) NOT NULL,
                                    `description` VARCHAR(256),
                                    PRIMARY KEY (`id`));
