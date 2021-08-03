-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 09, 2021 at 06:01 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vlprs`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Email` varchar(256) NOT NULL,
  `Password` varchar(256) NOT NULL,
  `UserID` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Email`, `Password`, `UserID`) VALUES
('Administrator@vlprs.com', '25d55ad283aa400af464c76d713c07ad', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `owner_info`
--

CREATE TABLE `owner_info` (
  `FirstName` varchar(256) NOT NULL,
  `LastName` varchar(256) NOT NULL,
  `OwnerID` varchar(256) NOT NULL,
  `DoB` date NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `RegArea` varchar(256) NOT NULL,
  `Phone` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `owner_info`
--

INSERT INTO `owner_info` (`FirstName`, `LastName`, `OwnerID`, `DoB`, `Sex`, `RegArea`, `Phone`) VALUES
('Test', 'Person2', 'Kayowak1625732724912', '2000-06-14', 'male', 'Addis Abeba', '0987654321');

-- --------------------------------------------------------

--
-- Table structure for table `plate`
--

CREATE TABLE `plate` (
  `Type` varchar(256) NOT NULL,
  `Code` int(11) NOT NULL,
  `Last` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plate`
--

INSERT INTO `plate` (`Type`, `Code`, `Last`) VALUES
('Taxi', 1, 0),
('Individual', 2, 0),
('Trade', 3, 4),
('Admin', 4, 0),
('Support', 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `UserID` varchar(256) NOT NULL,
  `Title` varchar(256) NOT NULL,
  `Content` varchar(1024) NOT NULL,
  `Date` date NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`UserID`, `Title`, `Content`, `Date`, `ID`) VALUES
('hfgsdfhgs', 'Yo bro! Josh Here!', 'I got My Chevrolet Camaro SS parked at the AC. need the Plate ASAP. Yo I will do anything. Just take care of it!', '2021-07-08', 1),
('hfgsdfhgs', 'sjkdhfjksdhfks', 'sdjfn,sdmgndfkfjghsdfkjsndfkjnsdfkjnsfgkjnsffkgjfs', '2021-07-08', 2),
('hfgsdfhgs', 'jdkfhjkfhskj', 'alfhjhnwiucnvwekjfh8347ytfjwfkjwrkwrhkjhwekj', '2021-07-08', 3),
('Kayowak1625732724912', 'jvkljvlkjdkljdlkfjgldf', 'lkdjflksdjflksdjflksdjflksdjlfksdjlfkjsdlksjdkvsdjlvksdjlgkwjflkwrjlwehjjqklhgekrjghkewfjfghweriuwerlkjhgwerlhgfigluerhlvjkflwerjvndl\'kvnerelrkvjhqeori;vkjlneqroviervneru', '2021-07-08', 4),
('hfgsdfhgs', 'ldkjhfkjdsghkdfj', 'djfhlkaljsdfhkjsdfhkjdshfkjsdhfkjsdhfkjlhfkjhsdkljfsha', '2021-07-08', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Email` varchar(256) NOT NULL,
  `Password` varchar(256) NOT NULL,
  `UserID` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Email`, `Password`, `UserID`) VALUES
('KayowakMelese@gmail.com', '25d55ad283aa400af464c76d713c07ad', 'Kayowak1625732724912');

-- --------------------------------------------------------

--
-- Table structure for table `user_session`
--

CREATE TABLE `user_session` (
  `UserID` varchar(256) NOT NULL,
  `Last_Date` date NOT NULL,
  `Session_Code` varchar(256) NOT NULL,
  `index` int(11) NOT NULL,
  `Active` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_session`
--

INSERT INTO `user_session` (`UserID`, `Last_Date`, `Session_Code`, `index`, `Active`) VALUES
('Kayowak1625732724912', '2021-07-08', '60c1b90e575f449f1c32938aa486875e', 24, 0),
('Kayowak1625732724912', '2021-07-08', '6e7ff4be602e3cc76242feb35e0928eb', 25, 0),
('hfgsdfhgs', '2021-07-08', 'd8664eb5dcd0a055efd66babf67baea3', 26, 0),
('admin123', '2021-07-08', 'c39426d915484dd897abc88e223841b3', 27, 1),
('admin123', '2021-07-08', 'ce94c812a03fa8912038b48ad6d61943', 28, 1),
('Test1625763047439', '2021-07-08', '6ae2b61b57a9914f3ff5245e93b15319', 29, 0),
('admin123', '2021-07-08', '8aa3a28cacc97ab16ebd9caa0f32887a', 30, 0),
('hfgsdfhgs', '2021-07-08', 'b1673b0cfaa551b2fc9b1d5a85e15c76', 31, 0),
('hfgsdfhgs', '2021-07-09', '576886b67312bea3346944cedfba0b7b', 32, 0),
('hfgsdfhgs', '2021-07-09', 'ed66fe701e8b191f5075048de2ada948', 33, 0),
('admin123', '2021-07-09', '4f5b8b7eec510484b2fa261297f775ae', 34, 1),
('admin123', '2021-07-09', 'ac8140425bd80ea00ef4eeba4a2e26eb', 35, 0),
('hfgsdfhgs', '2021-07-09', '650d98905d71f2f7d4653c4cbfbb17cc', 36, 1),
('Kayowak1625732724912', '2021-07-09', '2405f0f7a0b580ae2a6f2a0cc27492a6', 37, 0),
('admin123', '2021-07-09', '33764d9b08fd38d54aa2a45cdbf67e7b', 38, 0),
('hfgsdfhgs', '2021-07-09', 'e2087ac7e71bb1a6b58f514db66a1eff', 39, 0),
('admin123', '2021-07-09', '53f42c1f3e9b56df11091a998819a534', 40, 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_info`
--

CREATE TABLE `vehicle_info` (
  `ChasisNo` varchar(256) NOT NULL,
  `MotorNo` varchar(256) NOT NULL,
  `OwnerID` varchar(256) NOT NULL,
  `Brand` varchar(256) NOT NULL,
  `Model` varchar(256) NOT NULL,
  `ProdYear` date NOT NULL,
  `Seats` int(11) NOT NULL,
  `FuelType` varchar(256) NOT NULL,
  `MotorSize` int(11) NOT NULL,
  `HorsePower` int(11) NOT NULL,
  `InspectionYear` date NOT NULL,
  `Region` varchar(256) NOT NULL,
  `City` varchar(256) NOT NULL,
  `Code` int(11) NOT NULL,
  `Plate` varchar(256) NOT NULL DEFAULT '',
  `Status` int(11) NOT NULL DEFAULT -1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle_info`
--

INSERT INTO `vehicle_info` (`ChasisNo`, `MotorNo`, `OwnerID`, `Brand`, `Model`, `ProdYear`, `Seats`, `FuelType`, `MotorSize`, `HorsePower`, `InspectionYear`, `Region`, `City`, `Code`, `Plate`, `Status`) VALUES
('HGF87346R8347FTG478YF', '984658324658234', 'Kayowak1625732724912', 'Toyota', 'Corola', '2020-01-08', 4, 'Kerosene', 7, 60, '2020-10-14', 'Dire Dawa', 'Addis Abeba', 3, 'AA00001', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `owner_info`
--
ALTER TABLE `owner_info`
  ADD UNIQUE KEY `Phone` (`Phone`);

--
-- Indexes for table `plate`
--
ALTER TABLE `plate`
  ADD PRIMARY KEY (`Code`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Email`),
  ADD UNIQUE KEY `UserID` (`UserID`);

--
-- Indexes for table `user_session`
--
ALTER TABLE `user_session`
  ADD PRIMARY KEY (`index`);

--
-- Indexes for table `vehicle_info`
--
ALTER TABLE `vehicle_info`
  ADD UNIQUE KEY `ChasisNo` (`ChasisNo`),
  ADD UNIQUE KEY `MotorNo` (`MotorNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_session`
--
ALTER TABLE `user_session`
  MODIFY `index` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
