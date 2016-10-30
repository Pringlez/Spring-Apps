-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 30, 2016 at 09:06 PM
-- Server version: 5.5.52
-- PHP Version: 5.4.4-14+deb7u12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `spring_webapps`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cars`
--

CREATE TABLE IF NOT EXISTS `Cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `make` tinytext NOT NULL,
  `model` tinytext NOT NULL,
  `color` tinytext NOT NULL,
  `mileage` int(11) NOT NULL,
  `year` smallint(6) NOT NULL,
  `engine_size` mediumint(9) NOT NULL,
  `fuel_type` tinytext NOT NULL,
  `description` text NOT NULL,
  `price` int(11) NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4;

--
-- Dumping data for table `Cars`
--

INSERT INTO `Cars` (`id`, `make`, `model`, `color`, `mileage`, `year`, `engine_size`, `fuel_type`, `description`, `price`, `created_at`) VALUES
(1, 'Honda', 'Accord 2.0i 16V (150 HP)', 'Blue', 67230, 1997, 2000, 'Petrol', '4-door 5-seater sedan (saloon), petrol (gasoline) 4-cylinder 16-valve straight (inline) engine, SOHC (single overhead camshaft), 121.8 cu in, 147.5 hp @ 6100 rpm, 137.2 lb·ft @ 5000 rpm', 3500, '2016-10-23 12:38:17'),
(2, 'Mazda', 'Atenza Sport 2.0i 16V', 'Silver', 78123, 2002, 2000, 'Petrol', '5-door 5-seater hatchback (liftback) sedan, petrol (gasoline) 4-cylinder 16-valve straight (inline) engine, DOHC (double overhead camshafts, twin cam), 121.9 cu in, 142.1 hp @ 6500 rpm, 138.7 lb·ft @ 5000 rpm', 5500, '2016-10-23 12:47:23'),
(3, 'Renault', 'Megane II Coupe Cabriolet 1.9 dCi', 'Silver', 113563, 2003, 1900, 'Diesel', '2-door 4-seater convertible (cabriolet), 4-cylinder 16-valve straight (inline) engine, 114.0 cu in, 112.6 hp @ 4000 rpm, 221.3 lb·ft @ 2000 rpm, manual 6-speed transmission, front wheel drive, 120 mph top speed, consumption 51.4 mpg', 6000, '2016-10-23 12:47:23');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
