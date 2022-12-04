DROP TABLE IF EXISTS `footballers`;
DROP TABLE IF EXISTS `clubs`;
CREATE TABLE `clubs` (
                         `id` int NOT NULL,
                         `ballance` int NOT NULL,
                         `comission` int NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
);
CREATE TABLE `footballers` (
                               `id` int NOT NULL,
                               `age` int NOT NULL,
                               `experience` int NOT NULL,
                               `name` varchar(255) DEFAULT NULL,
                               `club_id` int NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `FK1oanletoac1okauy509ovodm5` (`club_id`),
                               CONSTRAINT `FK1oanletoac1okauy509ovodm5` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`)
);