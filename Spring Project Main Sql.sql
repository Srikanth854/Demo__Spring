DROP TABLE IF EXISTS `springproject`.`student`;
DROP TABLE IF EXISTS `springproject`.`department`;


CREATE TABLE IF NOT EXISTS `springproject`.`department` (
  `deptid` INT NOT NULL AUTO_INCREMENT,
  `deptname` VARCHAR(45) NOT NULL,
  `deptcode` VARCHAR(45) NOT NULL,
  `deptmail` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`deptid`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;



INSERT INTO `springproject`.`department` VALUES 
	(1,'ComputerScienceEngineering','CSE','cse@jntuh.ac.in'),
    (2,'ElectricalandCommunicationEngineering','ECE','ece@jntuh.ac.in'),
    (3,'ElectricalandElectronicsEngineering','EEE','eee@jntuh.ac.in'),
    (4,'MechanicalEngineering','Mech','mech@jntuh.ac.in'),
    (5,'CivilEngineering','CIVL','civl@jntuh.ac.in');

-- -----------------------------------------------------
-- Table `springproject`.`student`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `springproject`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `department_deptid` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_department_idx` (`department_deptid` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`department_deptid`)
    REFERENCES `springproject`.`department` (`deptid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- SET SQL_MODE=@OLD_SQL_MODE;
 SET FOREIGN_KEY_CHECKS=0;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `student` VALUES 
	(1,'Leslie','Andrews','leslie@gmail.com',1),
	(2,'Emma','Baumgarten','emma@gmail.com',2),
	(3,'Avani','Gupta','avani@gmail.com',3),
	(4,'Yuri','Petrov','yuri@gmail.com',4),
	(5,'Juan','Vega','juan@gmail.com',5);

