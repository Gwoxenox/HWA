drop schema hwa;

CREATE SCHEMA IF NOT EXISTS `hwa`;

USE `hwa` ;

CREATE TABLE IF NOT EXISTS `hwa`.`series` (
    `series_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    `car` VARCHAR(40) NOT NULL,
    PRIMARY KEY (`series_id`)
);

CREATE TABLE IF NOT EXISTS `hwa`.`races` (
	`race_id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_series_id` INT(11) NOT NULL,
    `race_no` INT(11) NOT NULL,
    `circuit` VARCHAR(40)  NOT NULL,
    `no_of_laps` INT(11) NOT NULL,
	FOREIGN KEY (`fk_series_id`) REFERENCES `series`(`series_id`),
    PRIMARY KEY (`race_id`)
);