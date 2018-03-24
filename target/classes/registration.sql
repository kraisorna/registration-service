-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.1-MariaDB-10.3.1+maria~stretch - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for registration
DROP DATABASE IF EXISTS `registration`;
CREATE DATABASE IF NOT EXISTS `registration` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `registration`;

-- Dumping structure for table registration.member_type
DROP TABLE IF EXISTS `member_type`;
CREATE TABLE IF NOT EXISTS `member_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `description` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table registration.member_type: ~3 rows (approximately)
DELETE FROM `member_type`;
/*!40000 ALTER TABLE `member_type` DISABLE KEYS */;
INSERT INTO `member_type` (`id`, `name`, `description`) VALUES
	(1, 'Platinum', 'salary > 50,000 baht'),
	(2, 'Gold', 'salary between 30,000 to 50,000'),
	(3, 'Silver', 'salary < 30,000');
/*!40000 ALTER TABLE `member_type` ENABLE KEYS */;

-- Dumping structure for table registration.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(255) NOT NULL DEFAULT '0',
  `address` varchar(255) NOT NULL DEFAULT '0',
  `phone` varchar(50) NOT NULL DEFAULT '0',
  `reference_code` varchar(12) NOT NULL DEFAULT '0',
  `member_type_id` int(11) NOT NULL DEFAULT 0,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
