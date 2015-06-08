-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 12, 2015 at 09:47 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `datalizer`
--
CREATE DATABASE IF NOT EXISTS `datalizer` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `datalizer`;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `login`, `password`) VALUES
(1, 'jhomlala', '$2a$10$pHHPyiI.fomy/TGd1hEHJuVLVx.bECmn60osUyHpVwCtfQxF3phdW');

-- --------------------------------------------------------

--
-- Table structure for table `person_roles`
--

CREATE TABLE IF NOT EXISTS `person_roles` (
  `personRoleID` int(12) NOT NULL AUTO_INCREMENT,
  `personID` int(12) NOT NULL,
  `role` varchar(60) NOT NULL,
  PRIMARY KEY (`personRoleID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `person_roles`
--

INSERT INTO `person_roles` (`personRoleID`, `personID`, `role`) VALUES
(1, 1, 'ROLE_USER');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
