-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 24 avr. 2019 à 17:04
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

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

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(100) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zipcode` varchar(10) NOT NULL,
  `country` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `address`
--

INSERT INTO `address` (`id`, `street`, `city`, `state`, `zipcode`, `country`) VALUES
(1, '54545 erfoejgoiej', 'oizejfojeo', 'ertertert', '65e46', 'elgnoengoe');

-- --------------------------------------------------------

--
-- Structure de la table `openinghours`
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
-- Structure de la table `promotions`
--

CREATE TABLE `promotions` (
  `id` int(11) NOT NULL,
  `key` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `shortdescription` text NOT NULL,
  `longdescription` text NOT NULL,
  `position` int(11) NOT NULL,
  `disabled` tinyint(1) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `imageurl` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `stores`
--

CREATE TABLE `stores` (
  `id` int(11) NOT NULL,
  `key` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lattitude` float NOT NULL,
  `longitude` float NOT NULL,
  `lastmodifieddate` date NOT NULL,
  `lastmodifiedby` int(11) NOT NULL,
  `idaddress` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typeuser`
--

CREATE TABLE `typeuser` (
  `id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeuser`
--

INSERT INTO `typeuser` (`id`, `type`) VALUES
(1, 'lkejrgfper');

-- --------------------------------------------------------

--
-- Structure de la table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `creationdate` date NOT NULL,
  `lastmodificationdate` date NOT NULL,
  `resetpasswordlink` varchar(100) NOT NULL,
  `resetlinkvalidatedate` date NOT NULL,
  `isremoved` tinyint(1) NOT NULL,
  `idtype` int(11) NOT NULL,
  `idaddress` int(11) NOT NULL,
  `authkey` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `useraccounts`
--

INSERT INTO `useraccounts` (`id`, `firstname`, `lastname`, `email`, `password`, `phonenumber`, `active`, `creationdate`, `lastmodificationdate`, `resetpasswordlink`, `resetlinkvalidatedate`, `isremoved`, `idtype`, `idaddress`, `authkey`) VALUES
(1, 'Zeubi', 'LaMouche', 'zeubi.lamouche@gmail.com', 'hehehehe', '0123456789', 1, '2019-03-06', '2019-03-06', 'http://resetmonpasswordsvp.com', '2019-09-19', 0, 1, 1, ''),
(2, 'Tibbers', 'Robert', 'r.tibbers@truc.com', 'password', '7894561230', 1, '2019-04-01', '2019-04-01', 'kefkjhevjbeikb', '2019-04-30', 0, 1, 1, '');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `openinghours`
--
ALTER TABLE `openinghours`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `promotions`
--
ALTER TABLE `promotions`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stores`
--
ALTER TABLE `stores`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `typeuser`
--
ALTER TABLE `typeuser`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `openinghours`
--
ALTER TABLE `openinghours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `promotions`
--
ALTER TABLE `promotions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `stores`
--
ALTER TABLE `stores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeuser`
--
ALTER TABLE `typeuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
