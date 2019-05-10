-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 10, 2019 at 01:27 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `restodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zipcode` varchar(10) NOT NULL,
  `country` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `street`, `city`, `state`, `zipcode`, `country`) VALUES
(1, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(2, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(3, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(4, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(5, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(6, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(7, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(8, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(9, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(10, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(11, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(12, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(13, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(14, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(15, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(16, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(17, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(18, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(19, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(20, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(21, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(22, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(23, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(24, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(25, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(26, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(27, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(28, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe'),
(29, '', '', '', '', ''),
(30, 'f', 'f', 'f', '37300', 'france'),
(31, '49 avenue de bordeaux', 'tours', 'indre et loire', '37300', 'France'),
(32, 'f', 'f', 'f', '3867', 'france'),
(33, 'f', 'f', 'f', '3867', 'france');

-- --------------------------------------------------------

--
-- Table structure for table `openinghours`
--

CREATE TABLE `openinghours` (
  `id` int(11) NOT NULL,
  `idstore` int(11) NOT NULL,
  `day` varchar(30) NOT NULL,
  `from` time NOT NULL,
  `to` time NOT NULL,
  `close` tinyint(1) NOT NULL,
  `24h` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `promotions`
--

CREATE TABLE `promotions` (
  `id` int(11) NOT NULL,
  `mykey` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `shortdescription` text NOT NULL,
  `longdescription` text NOT NULL,
  `position` int(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `imageurl` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotions`
--

INSERT INTO `promotions` (`id`, `mykey`, `title`, `shortdescription`, `longdescription`, `position`, `disabled`, `startdate`, `enddate`, `imageurl`) VALUES
(2, 'promo', 'promo-1', 'promo ', 'promo promo', 0, 0, NULL, NULL, 'https://img.argentdubeurre.com/content/4857/mcdo-big-mac-2-euros-1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `stores`
--

CREATE TABLE `stores` (
  `id` int(11) NOT NULL,
  `mykey` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lattitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `lastmodifieddate` date DEFAULT NULL,
  `lastmodifiedby` int(11) DEFAULT NULL,
  `idaddress` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stores`
--

INSERT INTO `stores` (`id`, `mykey`, `name`, `phonenumber`, `email`, `lattitude`, `longitude`, `lastmodifieddate`, `lastmodifiedby`, `idaddress`) VALUES
(1, 'store-2', 'second store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 28),
(3, 'f', 'f', 'f', 'f', 1, 1, '2019-05-01', 1, 1),
(4, 'f', 'f', 'f', 'f', 1, 1, '2019-05-01', 1, 1),
(5, 'f', 'f', 'f', 'f', 1, 1, '2019-05-01', 1, 1),
(6, 'f', 'f', 'f', 'f', 1, 1, '2019-05-06', 1, 1),
(7, 'f', 'f', 'f', 'f', 1, 1, '2019-05-06', 1, 1),
(8, 'store-1', 'premier store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 19),
(9, 'oui', 'damien maestracci', '676718162', 'damien.maestracci@gmail.com', 0, 0, '2019-05-09', NULL, 20),
(10, 'store-1', 'second store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 21),
(11, 'store-1', 'premier store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 22);

-- --------------------------------------------------------

--
-- Table structure for table `typeuser`
--

CREATE TABLE `typeuser` (
  `id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeuser`
--

INSERT INTO `typeuser` (`id`, `type`) VALUES
(1, 'lkejrgfper'),
(2, 'client'),
(3, 'owner'),
(4, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `creationdate` date DEFAULT NULL,
  `lastmodificationdate` date DEFAULT NULL,
  `resetpasswordlink` varchar(100) DEFAULT NULL,
  `resetlinkvalidatedate` date DEFAULT NULL,
  `isremoved` tinyint(1) DEFAULT NULL,
  `idtype` int(11) DEFAULT NULL,
  `idaddress` int(11) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`id`, `firstname`, `lastname`, `email`, `password`, `phonenumber`, `active`, `creationdate`, `lastmodificationdate`, `resetpasswordlink`, `resetlinkvalidatedate`, `isremoved`, `idtype`, `idaddress`, `token`) VALUES
(1, 'bouche', 'LaMouche', 'zeubi.lamouche@gmail.com', 'hehehehe', '0123456789', 0, NULL, NULL, NULL, NULL, 0, NULL, 26, NULL),
(2, 'Tibbers', 'tintin', 'r.tibbers@truc.com', 'password', '7894561230', 0, NULL, NULL, NULL, NULL, 0, NULL, 31, NULL),
(13, 'damien', 'maestracci', 'damien.maestracci@gmail.com', 's3A2ZXy%xj^AF2DHk*qs7YqM', '676718162', 1, '2019-05-09', '2019-05-09', NULL, NULL, 0, 2, 3, NULL),
(14, 'damien', 'maestracci', 'damien.maestracci@gmail.com', 'rb$gJsFE*&Sr9Z8UKQn5R^2j', '676718162', 1, '2019-05-09', '2019-05-09', NULL, NULL, 0, 2, 4, NULL),
(15, 'damien', 'mae', 'damien.m@gmail.com', '12345678', '5678956', 1, '2019-05-10', '2019-05-10', NULL, NULL, 0, 2, 33, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `openinghours`
--
ALTER TABLE `openinghours`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `promotions`
--
ALTER TABLE `promotions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stores`
--
ALTER TABLE `stores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `typeuser`
--
ALTER TABLE `typeuser`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `openinghours`
--
ALTER TABLE `openinghours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `promotions`
--
ALTER TABLE `promotions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stores`
--
ALTER TABLE `stores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `typeuser`
--
ALTER TABLE `typeuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
