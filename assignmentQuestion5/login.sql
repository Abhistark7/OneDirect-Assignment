-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2019 at 06:21 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(17),
(17);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) VALUES
(1, 1, 'abhistark7@gmail.com', 'Sahu', 'Abhishek', '$2a$10$hweVPj9iZciJs9C2OF38i.o3eNXEvXLJR5pw0Da4gl3DdOUUaanK2'),
(2, 1, 'abhi9122305911@gmail.com', 'Sahu', 'Abhishek', '$2a$10$OFAoGgro14JzT.vXg5RRhOEQ2tASEDJpcyCX23vp5Y4bxsNJoeHbS'),
(3, 1, 'surkha@gmail.com', 'Agarwal', 'Surkha', '$2a$10$oAU2jkKMHjgcEu1lAYfkmutUPZCAplHFRVcO3aIPGwEteK01LKwQa'),
(4, 1, 'rishab@gmail.com', 'Kumar', 'Rishab', '$2a$10$rVHPuVx4e1wgUs5issqwj.bSSSvORG6.FPfCd0cFiQulOJt/FQkmm'),
(5, 1, 'rishab@gmail.com', 'Kumar', 'Rishab', '$2a$10$vXE8Mq0wJs.QAaRE4DEH3uA9aZQtNyrdcp2B41ya04zjzTujglgZa'),
(6, 1, 'ajay@devgn.com', 'Devgn', 'Ajay', '$2a$10$muj7knmkBGdP70giFD.efuh2VZfjC6V8S6kRGp4Bfz0Wr3GQFg0l6'),
(7, 1, 'egr@rg.com', 'regrrggge', 'gegeg', '$2a$10$yhd3AkI8Xf4CZPDO0WQRBeTmM1auK/kvN853cxqG4ZqncSDPCTT7u'),
(8, 1, 'kumar@yadav.com', 'Yadav', 'Kumar', '$2a$10$OvZXpdGMsv0I9Ca7miMI2eMp2DS3D9dv.GfoSsGQhRofp.o2WyFWy'),
(9, 1, 'kumar@yadav1.com', 'Yadav', 'Kumar', '$2a$10$WJoswYneS4HMu0n0dYtXwOg99J5Hj32hO010IZwyzI4SS4iziG3wu'),
(10, 1, 'kumar@yadav12.com', 'Yadav', 'Kumar', '$2a$10$4K2E0U96sYHVeXsqWTOkceOZZxtHvF1j2.Npk2kBfMV0HrzirJ.5G'),
(11, 1, 'sunita@williams.com', 'Williams', 'Sunita', '$2a$10$/EYkp0KW7LmvygXLIvRpHu.7DdBwyqzppgGUm.hw8IXk4HO/w1mKC'),
(12, 1, 'sam@jack.com', 'Jackson', 'Sam', '$2a$10$.qZil20IrF.XauM5LhbLcORuQx5WtUCq8QF09KasPGYPpbB2bHu8i'),
(14, 1, 'jack@black.com', 'Black', 'Jack', '$2a$10$7mSdJz79nB1atDLkzfdhP.xUmm8EpfECeAWjzUV8V1czHyrLHPubq'),
(15, 1, 'prashant@gmail.com', 'Thakare', 'Prashant', '$2a$10$hJeYREfQLCpCI41lyIe3nOT4wdOCHmeDZmdV42eZKLyIVY5X0uoIG'),
(16, 1, 'sumit@gmail.com', 'Mishra', 'Sumit', '$2a$10$4ZrPsCPxbIbHoccBBnG4v.1fFnnoYLGcgEq1FSrxV5Vr9xWX6DGee');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 0),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 0),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
