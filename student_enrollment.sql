-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 07, 2022 at 04:19 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_enrollment`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` enum('MALE','FEMALE') NOT NULL,
  `birth_date` date NOT NULL,
  `identification_number` varchar(100) DEFAULT NULL,
  `department_of_birth` varchar(100) DEFAULT NULL,
  `municipality_of_birth` varchar(100) DEFAULT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `age`, `gender`, `birth_date`, `identification_number`, `department_of_birth`, `municipality_of_birth`, `status`) VALUES
(1, 'Fernanda', 17, 'FEMALE', '2003-03-19', '1097045675', 'Caqueta', 'florencia', 0),
(2, 'Natalia', 17, 'FEMALE', '2003-04-19', '1097045679', 'Quindio', 'Armenia', 1),
(3, 'Laura', 17, 'FEMALE', '2003-04-19', '1097045677', 'Quindio', 'Armenia', 1),
(4, 'Fredy', 12, 'MALE', '2003-04-19', '1097045676', 'Quindio', 'Armenia', 1),
(5, 'Luis Diaz', 18, 'MALE', '2005-12-05', '1097045678', 'Bolivar', 'Cartagena', 1),
(6, 'Sotano uno', 17, 'MALE', '2004-10-03', '11111', 'Santander', 'Bucaramanga', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
