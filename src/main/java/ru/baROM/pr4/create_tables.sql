CREATE SCHEMA `theater`;
USE `theater`;


CREATE TABLE `films` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `duration` time NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `schedule` (
  `seance` int(11) NOT NULL,
  `films_id` int(11) DEFAULT NULL,
  `start` datetime NOT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`seance`),
  CONSTRAINT `films_id` FOREIGN KEY (`films_id`) REFERENCES `films` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `tickets` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `seance_id` int(11) NOT NULL,
  PRIMARY KEY (`number`),
  CONSTRAINT `seance_id` FOREIGN KEY (`seance_id`) REFERENCES `schedule` (`seance`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO `films` VALUES 
 (1,'Transformers','02:00:00'),
 (2,'Transformers: Revenge of the Fallen','02:00:00'),
 (3,'Transformers: Dark of the Moon','01:30:00'),
 (7,'Bumblebee','00:55:00');

INSERT INTO `schedule` VALUES 
 (100,1,'2022-05-13 09:00:00',150),
 (101,1,'2022-05-13 21:00:00',120),
 (102,2,'2022-05-13 12:00:00',90),
 (103,2,'2022-05-13 18:00:00',200),
 (104,3,'2022-05-13 18:30:00',200),
 (105,7,'2022-05-13 14:00:00',100),
 (106,7,'2022-05-13 19:00:00',110),
 (107,3,'2022-05-13 09:30:00',150);

INSERT INTO `tickets` VALUES 
 (1,100),
 (2,100),
 (11,100),
 (9,101),
 (10,101),
 (7,102),
 (8,102),
 (12,102),
 (13,102),
 (6,103),
 (14,103),
 (15,104),
 (5,105),
 (16,105),
 (4,106),
 (17,106),
 (3,107),
 (18,107);

