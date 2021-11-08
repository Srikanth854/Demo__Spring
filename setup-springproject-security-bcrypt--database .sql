-- DROP DATABASE  IF EXISTS `springproject_security_demo_bcrypt`;

-- CREATE DATABASE  IF NOT EXISTS `springproject_security_demo_bcrypt`;
USE `springproject`;

--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://passwordhashing.com/BCrypt?plainText=password
--
-- Default passwords here are: password
--

INSERT INTO `users` 
VALUES 
('ravi','{bcrypt}$2b$10$zOVHOJLBxRTb2J/TCo02P.Egdt8OMt4iMzjKIB1OHjnUnWx8MTIHW',1),
('ramana','{bcrypt}$2b$10$zOVHOJLBxRTb2J/TCo02P.Egdt8OMt4iMzjKIB1OHjnUnWx8MTIHW',1),
('raju','{bcrypt}$2b$10$zOVHOJLBxRTb2J/TCo02P.Egdt8OMt4iMzjKIB1OHjnUnWx8MTIHW',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('ravi','ROLE_INCHARGE'),
('ramana','ROLE_INCHARGE'),
('ramana','ROLE_ADMIN'),
('raju','ROLE_INCHARGE'),
('raju','ROLE_ADMIN');


