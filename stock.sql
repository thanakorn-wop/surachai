-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 10, 2021 at 08:04 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id_devices` int(20) NOT NULL,
  `name_device` varchar(30) NOT NULL,
  `amount` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `bordate` varchar(30) NOT NULL,
  `bortime` varchar(20) DEFAULT NULL,
  `rebordate` varchar(30) DEFAULT NULL,
  `rebortime` varchar(11) DEFAULT NULL,
  `id_member` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id_devices`, `name_device`, `amount`, `status`, `bordate`, `bortime`, `rebordate`, `rebortime`, `id_member`) VALUES
(45, '20', '30', 'คืนแล้ว', '25/9/2021', '17:05:42', '2/10/2021', '22:02', 9),
(46, 'ลูกบอล', '20', 'คืนแล้ว', '1/10/2021', '15:08', '2/10/2021', '12:42', 3),
(47, 'หนัง', '1', 'คืนแล้ว', '27/9/2021', '14:08', '2/10/2021', '07:27', 1),
(48, 'น็อค', '3', 'คืนแล้ว', '27/9/2021', '15:11', '2/10/2021', '19:02', 1),
(49, 'ไม้', '200', 'กำลังยืม', '13/9/2021', '17:44', '2/10/2021', '12:42', 3),
(50, 'น็อค', '1000', 'คืนแล้ว', '10/10/2021', '04:44', '2/11/2021', '16:59', 3),
(51, 'qwweeq', 'qwe', 'กำลังยืม', '2/10/2021', '21:13', NULL, NULL, 1),
(52, 'aaa', 'aaa', 'คืนแล้ว', '2/10/2021', '17:10', '15/10/2021', '14:22', 1),
(53, 'aaa', 'aa', 'กำลังยืม', '2/10/2021', '22:15', NULL, NULL, 3),
(54, 'ssd', 'ss', 'กำลังยืม', '2/10/2021', NULL, NULL, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id_member` int(30) NOT NULL,
  `name` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `position` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id_member`, `name`, `lastname`, `nickname`, `phone`, `position`) VALUES
(1, 'jace', 'วรพงศ์ธนเดช', 'หนึ่ง', '0612364400', 'software'),
(3, 'thanakorn', 'woraphongtanadet', 'nueng', '0612364400', 'dev'),
(9, 'qwe', 'wqe', 'qwe', 'qwe', 'qwe'),
(10, 'data ', 'test', 'test', '1111', '222'),
(11, 'ธนากร', '11111', '111', '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, '123', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id_devices`),
  ADD KEY `id_member` (`id_member`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id_devices` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id_member` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `devices`
--
ALTER TABLE `devices`
  ADD CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `member` (`id_member`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
