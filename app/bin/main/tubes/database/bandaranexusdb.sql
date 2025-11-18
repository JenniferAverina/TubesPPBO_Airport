-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2025 at 06:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bandaranexusdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `userID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `departure`
--

CREATE TABLE `departure` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `kodeBandaraTujuan` varchar(3) NOT NULL,
  `kodeBandaraAsal` varchar(3) NOT NULL,
  `statusArival` enum('ARRIVED','ONBOARD','DELAYED') DEFAULT NULL,
  `ticketID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `imigrationarea`
--

CREATE TABLE `imigrationarea` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `passangerID` char(36) NOT NULL,
  `staffID` char(36) NOT NULL,
  `itemID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `namaBarang` text NOT NULL,
  `reason` enum('CHEMISTRY','EXPLOSIVE','SHARP_OBJECT','GUNS','FLAMEABLE','VALUABLE_ITEMS','DRUGS') DEFAULT NULL,
  `ammount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `parkingarea`
--

CREATE TABLE `parkingarea` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `width` double NOT NULL,
  `length` double NOT NULL,
  `terminalID` char(36) NOT NULL,
  `staffID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `passanger`
--

CREATE TABLE `passanger` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `specialNeeds` enum('NONE','PRM_PREGNANT','PRM_INJURED','PRM_ELDERLY','PRM_MEDICAL_ASSITANCE') DEFAULT NULL,
  `passportID` char(36) NOT NULL,
  `userID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `passport`
--

CREATE TABLE `passport` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `nationality` text NOT NULL,
  `ticketID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `zone` enum('PARKING','BOARDING','DROP_OFF','IMIGRATION','MEDICAL_CENTER','TERMINAL_1','TERMINAL_2','TICKET_COUNTER','ATC','APRON','POLICE_STATION') DEFAULT NULL,
  `userID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `terminal`
--

CREATE TABLE `terminal` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `namaTerminal` text NOT NULL,
  `isInternational` tinyint(1) NOT NULL,
  `staffID` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `destination` text NOT NULL,
  `origin` text NOT NULL,
  `flightNumber` varchar(12) NOT NULL,
  `seatNumber` char(3) NOT NULL,
  `maskapai` text NOT NULL,
  `price` double NOT NULL,
  `category` enum('REGULAR','BUSINESS','FIRST_CLASS') DEFAULT NULL,
  `dateTimeOrigin` datetime NOT NULL,
  `dateTimeDestination` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` char(36) NOT NULL DEFAULT uuid(),
  `nik` varchar(7) NOT NULL,
  `nama` text NOT NULL,
  `tempatLahir` text NOT NULL,
  `tanggalLahir` date NOT NULL,
  `passwords` char(8) NOT NULL,
  `jenisKelamin` enum('PRIA','WANITA') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_userID_admin` (`userID`);

--
-- Indexes for table `departure`
--
ALTER TABLE `departure`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ticketID_dept` (`ticketID`);

--
-- Indexes for table `imigrationarea`
--
ALTER TABLE `imigrationarea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_staffID_imi` (`staffID`),
  ADD KEY `FK_passangerID_imi` (`passangerID`),
  ADD KEY `FK_itemID_imi` (`itemID`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parkingarea`
--
ALTER TABLE `parkingarea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_staffID_PA` (`staffID`),
  ADD KEY `FK_terminalID_PA` (`terminalID`);

--
-- Indexes for table `passanger`
--
ALTER TABLE `passanger`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_userID_passanger` (`userID`),
  ADD KEY `FK_passportID_passanger` (`passportID`);

--
-- Indexes for table `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ticketID_pass` (`ticketID`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userID` (`userID`);

--
-- Indexes for table `terminal`
--
ALTER TABLE `terminal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_staffID_terminal` (`staffID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_userID_admin` FOREIGN KEY (`userID`) REFERENCES `users` (`id`);

--
-- Constraints for table `departure`
--
ALTER TABLE `departure`
  ADD CONSTRAINT `FK_ticketID_dept` FOREIGN KEY (`ticketID`) REFERENCES `ticket` (`id`);

--
-- Constraints for table `imigrationarea`
--
ALTER TABLE `imigrationarea`
  ADD CONSTRAINT `FK_itemID_imi` FOREIGN KEY (`itemID`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `FK_passangerID_imi` FOREIGN KEY (`passangerID`) REFERENCES `passanger` (`id`),
  ADD CONSTRAINT `FK_staffID_imi` FOREIGN KEY (`staffID`) REFERENCES `staff` (`id`);

--
-- Constraints for table `parkingarea`
--
ALTER TABLE `parkingarea`
  ADD CONSTRAINT `FK_staffID_PA` FOREIGN KEY (`staffID`) REFERENCES `staff` (`id`),
  ADD CONSTRAINT `FK_terminalID_PA` FOREIGN KEY (`terminalID`) REFERENCES `terminal` (`id`);

--
-- Constraints for table `passanger`
--
ALTER TABLE `passanger`
  ADD CONSTRAINT `FK_passportID_passanger` FOREIGN KEY (`passportID`) REFERENCES `passport` (`id`),
  ADD CONSTRAINT `FK_userID_passanger` FOREIGN KEY (`userID`) REFERENCES `users` (`id`);

--
-- Constraints for table `passport`
--
ALTER TABLE `passport`
  ADD CONSTRAINT `FK_ticketID_pass` FOREIGN KEY (`ticketID`) REFERENCES `ticket` (`id`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `fk_userID` FOREIGN KEY (`userID`) REFERENCES `users` (`id`);

--
-- Constraints for table `terminal`
--
ALTER TABLE `terminal`
  ADD CONSTRAINT `FK_staffID_terminal` FOREIGN KEY (`staffID`) REFERENCES `staff` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
