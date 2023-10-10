-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2019 at 06:37 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appscabbooking`
--

-- --------------------------------------------------------

--
-- Table structure for table `area_name`
--

CREATE TABLE `area_name` (
  `aid` int(3) NOT NULL,
  `cname` varchar(25) NOT NULL,
  `aname` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cabbooking`
--

CREATE TABLE `cabbooking` (
  `bid` int(3) NOT NULL,
  `cid` varchar(3) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `cno` varchar(10) NOT NULL,
  `cemail` varchar(50) NOT NULL,
  `cityname` varchar(50) NOT NULL,
  `cabtype` varchar(50) NOT NULL,
  `mcharge` varchar(10) NOT NULL,
  `fkm` varchar(10) NOT NULL,
  `wcharge` varchar(10) NOT NULL,
  `echarge` varchar(10) NOT NULL,
  `did` varchar(3) NOT NULL,
  `dname` varchar(50) NOT NULL,
  `dcno` varchar(10) NOT NULL,
  `demail` varchar(50) NOT NULL,
  `parea` varchar(50) NOT NULL,
  `darea` varchar(50) NOT NULL,
  `pdate` varchar(50) NOT NULL,
  `ptime` varchar(50) NOT NULL,
  `tkm` varchar(10) NOT NULL,
  `twcharge` varchar(10) NOT NULL,
  `tamount` varchar(10) NOT NULL,
  `bdate` varchar(20) NOT NULL,
  `btime` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `plat` varchar(20) NOT NULL,
  `plong` varchar(20) NOT NULL,
  `dlat` varchar(20) NOT NULL,
  `dlong` varchar(20) NOT NULL,
  `ddate` varchar(20) NOT NULL,
  `dtime` varchar(20) NOT NULL,
  `ccmt` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cabdriver`
--

CREATE TABLE `cabdriver` (
  `cabdid` int(3) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `cartype` varchar(50) NOT NULL,
  `did` varchar(3) NOT NULL,
  `dname` varchar(50) NOT NULL,
  `lno` varchar(50) NOT NULL,
  `cno` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cabtype`
--

CREATE TABLE `cabtype` (
  `cabid` int(3) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `cartype` varchar(50) NOT NULL,
  `mcharge` varchar(25) NOT NULL,
  `fkm` varchar(25) NOT NULL,
  `wcharge` varchar(25) NOT NULL,
  `echarge` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cab_server`
--

CREATE TABLE `cab_server` (
  `sid` int(3) NOT NULL,
  `lid` varchar(25) NOT NULL,
  `lpass` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cab_server`
--

INSERT INTO `cab_server` (`sid`, `lid`, `lpass`) VALUES
(1, 'server', 'server');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `carid` int(3) NOT NULL,
  `cartype` varchar(25) NOT NULL,
  `carname` varchar(25) NOT NULL,
  `carno` varchar(25) NOT NULL,
  `carimage` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city_name`
--

CREATE TABLE `city_name` (
  `cid` int(3) NOT NULL,
  `cname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(3) NOT NULL,
  `name` varchar(25) NOT NULL,
  `gender` varchar(25) NOT NULL,
  `cno` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `city` varchar(25) NOT NULL,
  `state` varchar(25) NOT NULL,
  `address` varchar(500) NOT NULL,
  `pcode` varchar(6) NOT NULL,
  `skey` varchar(25) NOT NULL,
  `rdate` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `driver_id` int(3) NOT NULL,
  `name` varchar(25) NOT NULL,
  `gender` varchar(25) NOT NULL,
  `dob` varchar(25) NOT NULL,
  `age` varchar(3) NOT NULL,
  `lno` varchar(25) NOT NULL,
  `cno` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  `state` varchar(25) NOT NULL,
  `address` varchar(500) NOT NULL,
  `pcode` varchar(25) NOT NULL,
  `skey` varchar(25) NOT NULL,
  `rdate` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area_name`
--
ALTER TABLE `area_name`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `cabbooking`
--
ALTER TABLE `cabbooking`
  ADD PRIMARY KEY (`bid`);

--
-- Indexes for table `cabdriver`
--
ALTER TABLE `cabdriver`
  ADD PRIMARY KEY (`cabdid`);

--
-- Indexes for table `cabtype`
--
ALTER TABLE `cabtype`
  ADD PRIMARY KEY (`cabid`);

--
-- Indexes for table `cab_server`
--
ALTER TABLE `cab_server`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`carid`);

--
-- Indexes for table `city_name`
--
ALTER TABLE `city_name`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`driver_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area_name`
--
ALTER TABLE `area_name`
  MODIFY `aid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cabbooking`
--
ALTER TABLE `cabbooking`
  MODIFY `bid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cabdriver`
--
ALTER TABLE `cabdriver`
  MODIFY `cabdid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cabtype`
--
ALTER TABLE `cabtype`
  MODIFY `cabid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cab_server`
--
ALTER TABLE `cab_server`
  MODIFY `sid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `carid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `city_name`
--
ALTER TABLE `city_name`
  MODIFY `cid` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `driver_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
