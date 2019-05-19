-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 19 mai 2019 à 19:32
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `restodb`
--

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zipcode` varchar(10) NOT NULL,
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `address`
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
(33, 'f', 'f', 'f', '3867', 'france'),
(34, 'Ici', 'La bas', 'Far away', '23568', 'La fronce'),
(35, 'toto', 'TOURS', 'tours', '37200', 'France'),
(36, 'rue', 'ville', 'etat', 'codepostal', 'pays'),
(37, '10 ALLÃ?E AIMÃ?E DE LA ROCHEFOUCAULD', 'TOURS', 'tours', '37200', 'France'),
(38, '10 ALLÃ?E AIMÃ?E DE LA ROCHEFOUCAULD', 'TOURS', 'tours', '37200', 'France'),
(39, '10 ALLÃ?E AIMÃ?E DE LA ROCHEFOUCAULD', 'TOURS', 'tours', '37200', 'France'),
(40, 'rue', 'ville', 'etat', 'codepostal', 'pays'),
(41, 'rue', 'ville', 'etat', 'codepostal', 'pays'),
(42, 'rue', 'ville', 'etat', 'codepostal', 'pays'),
(43, 'la street', 'ville', 'etat', 'codepostal', 'pays'),
(44, '540 rue leonard de vinci', 'Montpellier', 'occitanie', '34000', 'France'),
(45, '10 ALLÃ?E AIMÃ?E DE LA ROCHEFOUCAULD', 'TOURS', 'tours', '37200', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `openinghours`
--

DROP TABLE IF EXISTS `openinghours`;
CREATE TABLE IF NOT EXISTS `openinghours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idstore` int(11) NOT NULL,
  `day` varchar(30) NOT NULL,
  `from` time NOT NULL,
  `to` time NOT NULL,
  `close` tinyint(1) NOT NULL,
  `24h` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
CREATE TABLE IF NOT EXISTS `promotions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mykey` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `shortdescription` text NOT NULL,
  `longdescription` text NOT NULL,
  `position` int(11) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `imageurl` varchar(100) DEFAULT NULL,
  `idowner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotions`
--

INSERT INTO `promotions` (`id`, `mykey`, `title`, `shortdescription`, `longdescription`, `position`, `disabled`, `startdate`, `enddate`, `imageurl`, `idowner`) VALUES
(2, 'promo', 'promo-1', 'promo ', 'promo promo', 0, 0, NULL, NULL, 'https://img.argentdubeurre.com/content/4857/mcdo-big-mac-2-euros-1.jpg', 1),
(3, '1462346', 'promo', 'pas cool', 'dezdze', 0, 0, NULL, NULL, 'http://lnferfo.oif', NULL),
(4, '154484', 'une promo', 'pas cool', '', 0, 0, NULL, NULL, 'http://lnferfo.oif', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `stores`
--

DROP TABLE IF EXISTS `stores`;
CREATE TABLE IF NOT EXISTS `stores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mykey` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lattitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `lastmodifieddate` date DEFAULT NULL,
  `lastmodifiedby` int(11) DEFAULT NULL,
  `idaddress` int(11) DEFAULT NULL,
  `idowner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `stores`
--

INSERT INTO `stores` (`id`, `mykey`, `name`, `phonenumber`, `email`, `lattitude`, `longitude`, `lastmodifieddate`, `lastmodifiedby`, `idaddress`, `idowner`) VALUES
(1, 'store-2', 'second store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 28, 1),
(8, 'store-1', 'premier store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 19, 1),
(9, 'oui', 'damien maestracci', '676718162', 'damien.maestracci@gmail.com', 0, 0, '2019-05-09', NULL, 20, 1),
(10, 'store-1', 'second store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 21, 1),
(11, 'store-1', 'premier store', '05678986', 'test@test.test', 10, -23.8, NULL, NULL, 22, 2),
(12, '168465168', 'VINCENT BOYER', '666533497', 'vincent.boyer2311@gmail.com', 0, 0, '2019-05-19', NULL, NULL, NULL),
(13, 'dzezefefz', 'VINCENT BOYER', '666533497', 'vincent.boyer2311@gmail.com', 0, 0, '2019-05-19', NULL, 38, NULL),
(14, '54645', 'bo&co', '1234567891', 'machn@gmail.com', 0, 0, '2019-05-19', NULL, 45, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `typeuser`
--

DROP TABLE IF EXISTS `typeuser`;
CREATE TABLE IF NOT EXISTS `typeuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeuser`
--

INSERT INTO `typeuser` (`id`, `type`) VALUES
(1, 'lkejrgfper'),
(2, 'client'),
(3, 'owner'),
(4, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `useraccounts`
--

DROP TABLE IF EXISTS `useraccounts`;
CREATE TABLE IF NOT EXISTS `useraccounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `useraccounts`
--

INSERT INTO `useraccounts` (`id`, `firstname`, `lastname`, `email`, `password`, `phonenumber`, `active`, `creationdate`, `lastmodificationdate`, `resetpasswordlink`, `resetlinkvalidatedate`, `isremoved`, `idtype`, `idaddress`, `token`) VALUES
(1, 'bouche', 'LaMouche', 'zeubi.lamouche@gmail.com', 'hehehehe', '0123456789', 0, NULL, NULL, NULL, NULL, 0, 3, 26, '~\'adq`@}u\'?\'754<(50(4<%74?17?71\')\'pv`wLA\'?\'4\')\'ppla\'?\'ad`<<c7a(6gd1(1f24(g<gd(<gd0g50<77<6\'x'),
(2, 'Tibbers', 'tintin', 'r.tibbers@truc.com', 'password', '7894561230', 0, NULL, NULL, NULL, NULL, 0, 3, 31, NULL),
(13, 'damien', 'maestracci', 'damien.maestracci@gmail.com', 's3A2ZXy%xj^AF2DHk*qs7YqM', '676718162', 1, '2019-05-09', '2019-05-09', NULL, NULL, 0, 2, 3, NULL),
(14, 'damien', 'maestracci', 'damien.maestracci@gmail.com', 'rb$gJsFE*&Sr9Z8UKQn5R^2j', '676718162', 1, '2019-05-09', '2019-05-09', NULL, NULL, 0, 2, 4, NULL),
(15, 'damien', 'mae', 'damien.m@gmail.com', '12345678', '5678956', 1, '2019-05-10', '2019-05-10', NULL, NULL, 0, 2, 33, NULL),
(16, 'moi', 'encore moi', 'toujours.moi@moi.moi', '123456789', '123456789', 1, '2019-05-10', '2019-05-10', NULL, NULL, 0, 2, 34, NULL),
(17, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, 35, NULL),
(18, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, 37, NULL),
(19, 'test', 'gerge', 'yolo@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 36, NULL),
(20, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(21, 'test', 'gerge', 'pour@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 36, NULL),
(22, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(23, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(24, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(25, 'vcbcb', 'vcbvc', 'gvhgvjh@gmail.com', '123456789', '1234567891', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(26, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, 39, NULL),
(27, 'test', 'tro', 'best@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 36, NULL),
(28, 'VINCENT', 'BOYER', 'vincent.boyer2311@gmail.com', '123456789', '666533497', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, NULL, NULL),
(29, 'test', 'tro', 'okt@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 40, NULL),
(30, 'test', 'tro', 'carnaval@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 41, NULL),
(31, 'test', 'tro', 'carnavala@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 42, NULL),
(32, 'test', 'tro', 'hola@gmail.com', 'hehehehe', '1234567891', 1, '2019-05-19', '2019-05-19', '', '2019-05-20', 0, 2, 43, NULL),
(33, 'Pompei', 'Louise', 'lalala@gmail.com', '123456789', '784526755', 1, '2019-05-19', '2019-05-19', NULL, NULL, 0, 2, 44, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
