SELECT * FROM `resort-management`.resort;-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema resort-management
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema resort-management
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `resort-management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `resort-management` ;

-- -----------------------------------------------------
-- Table `resort-management`.`resort`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resort-management`.`resort` (
  `resort_id` INT NOT NULL AUTO_INCREMENT,
  `resort_name` VARCHAR(45) NULL DEFAULT NULL,
  `resort_address` VARCHAR(45) NULL DEFAULT NULL,
  `resort_rating` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`resort_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `resort-management`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resort-management`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `resort_resort_id` INT NOT NULL,
  INDEX `fk_customer_resort1_idx` (`resort_resort_id` ASC) VISIBLE,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_customer_resort1`
    FOREIGN KEY (`resort_resort_id`)
    REFERENCES `resort-management`.`resort` (`resort_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `resort-management`.`villa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `resort-management`.`villa` (
  `villa_id` INT NOT NULL AUTO_INCREMENT,
  `street_no` INT NULL DEFAULT NULL,
  `resort_resort_id` INT NOT NULL,
  `villa_no` INT NULL,
  INDEX `fk_villa_resort1_idx` (`resort_resort_id` ASC) VISIBLE,
  PRIMARY KEY (`villa_id`),
  CONSTRAINT `fk_villa_resort1`
    FOREIGN KEY (`resort_resort_id`)
    REFERENCES `resort-management`.`resort` (`resort_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
