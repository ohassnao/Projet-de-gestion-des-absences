-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 30 avr. 2023 à 02:40
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `javabase`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

CREATE TABLE `absence` (
  `id_absence` int(11) NOT NULL,
  `date` date NOT NULL,
  `type_absence` varchar(50) NOT NULL,
  `id_etd` int(11) DEFAULT NULL,
  `id_module` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `nom_admin` varchar(50) NOT NULL,
  `prenom_admin` varchar(50) NOT NULL,
  `id_compte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_admin`, `nom_admin`, `prenom_admin`, `id_compte`) VALUES
(1, 'El Hajjami', 'Mohammed', 1),
(2, 'Saidi', 'Fatima', 2);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `login`, `pwd`) VALUES
(1, 'ahmed.elk', 'password123'),
(2, 'fatima.zahra', 'qwerty456'),
(3, 'mohammed.amine', '1234abcd'),
(4, 'khadija.moussaoui', 'passw0rd'),
(5, 'soukaina.boukhari', 'letmein'),
(6, 'mehdi.benmoussa', 'abcdefg'),
(7, 'fatima.ezzahra', 'p@ssw0rd'),
(8, 'abdelilah.elhamraoui', 'admin123'),
(9, 'naima.elkhattabi', 'qazwsxedc'),
(10, 'oussama.elhassani', 'ensakhouribga');

-- --------------------------------------------------------

--
-- Structure de la table `enseignants`
--

CREATE TABLE `	` (
  `id_enseignant` int(11) NOT NULL,
  `nom_ens` varchar(50) NOT NULL,
  `prenom_ens` varchar(50) NOT NULL,
  `date_Naissance` date NOT NULL,
  `mail_ens` varchar(50) NOT NULL,
  `fonction` varchar(50) NOT NULL,
  `etat` varchar(50) NOT NULL,
  `statut` varchar(50) NOT NULL,
  `grade` varchar(50) NOT NULL,
  `id_compte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `enseignants`
--

INSERT INTO `enseignants` (`id_enseignant`, `nom_ens`, `prenom_ens`, `date_Naissance`, `mail_ens`, `fonction`, `etat`, `statut`, `grade`, `id_compte`) VALUES
(1, 'Ait Bouhou', 'Ahmed', '1990-01-01', 'ahmed.aitbouhou@gmail.com', 'Professeur', 'active', 'Permanant', 'Maître de conférences', 7),
(2, 'Bennani', 'Fatima', '1985-05-25', 'fatima.bennani@gmail.com', 'Chargé de cours', 'inactive', 'Vacataire', 'Professeur assistant', 8),
(3, 'El Mounir', 'Youssef', '1982-11-07', 'youssef.elmounir@gmail.com', 'Professeur', 'active', 'Permanant', 'Professeur', 3),
(4, 'Zouhairi', 'Hassan', '1992-06-13', 'hassan.zouhairi@gmail.com', 'Chargé de cours', 'active', 'Vacataire', 'Maître assistant', 4),
(5, 'Bakka', 'Fatima', '1988-02-18', 'fatima.bakka@gmail.com', 'Professeur', 'active', 'Permanant', 'Professeur', 5),
(6, 'El Khou', 'Abdelouahed', '1994-09-03', 'abdelouahed.elkhou@gmail.com', 'Chargé de cours', 'inactive', 'Vacataire', 'Maître assistant', 6),
(7, 'Moussaoui', 'Fatima', '1985-06-20', 'fatima.moussaoui@gmail.com', 'Enseignant-Chercheur', 'Actif', 'Permanent', 'Maître de conférences', 9),
(8, 'Rahmani', 'Mohamed', '1980-03-15', 'mohamed.rahmani@gmail.com', 'Enseignant-Chercheur', 'Actif', 'Permanent', 'Professeur des universités', 10);

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `id_etd` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_Naissance` date NOT NULL,
  `mail` varchar(50) NOT NULL,
  `id_ins` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id_inscription` int(11) NOT NULL,
  `année_univ` varchar(50) NOT NULL,
  `niveau` varchar(50) NOT NULL,
  `classe` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `année_univ`, `niveau`, `classe`) VALUES
(1, '2022', '2', 'B'),
(2, '2023', '3', 'C'),
(3, '2022', '1', 'D'),
(4, '2021', '3', 'B'),
(5, '2021', '1', 'A'),
(6, '2023', '2', 'A'),
(7, '2022', '3', 'D'),
(8, '2021', '2', 'C'),
(9, '2023', '1', 'B'),
(10, '2022', '2', 'C'),
(11, '2023', '3', 'D'),
(12, '2021', '1', 'B'),
(13, '2022', '2', 'A'),
(14, '2023', '3', 'B'),
(15, '2022', '1', 'C'),
(16, '2021', '3', 'D'),
(17, '2023', '2', 'B'),
(18, '2022', '3', 'A'),
(19, '2021', '2', 'D'),
(20, '2023', '1', 'C');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id_module` int(11) NOT NULL,
  `intitulé` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `abreveation` varchar(20) NOT NULL,
  `id_ens` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `posseder`
--

CREATE TABLE `posseder` (
  `id_etd` int(11) NOT NULL,
  `id_module` int(11) NOT NULL,
  `note` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id_absence`),
  ADD KEY `id_etd` (`id_etd`),
  ADD KEY `id_module` (`id_module`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD KEY `id_compte` (`id_compte`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`);

--
-- Index pour la table `enseignants`
--
ALTER TABLE `enseignants`
  ADD PRIMARY KEY (`id_enseignant`),
  ADD KEY `id_compte` (`id_compte`);

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`id_etd`),
  ADD KEY `id_ins` (`id_ins`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id_inscription`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id_module`),
  ADD KEY `id_ens` (`id_ens`);

--
-- Index pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD KEY `id_etd` (`id_etd`),
  ADD KEY `id_module` (`id_module`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `absence_ibfk_1` FOREIGN KEY (`id_etd`) REFERENCES `etudiants` (`id_etd`),
  ADD CONSTRAINT `absence_ibfk_2` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`);

--
-- Contraintes pour la table `enseignants`
--
ALTER TABLE `enseignants`
  ADD CONSTRAINT `enseignants_ibfk_1` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`);

--
-- Contraintes pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD CONSTRAINT `etudiants_ibfk_1` FOREIGN KEY (`id_ins`) REFERENCES `inscription` (`id_inscription`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`id_ens`) REFERENCES `enseignants` (`id_enseignant`);

--
-- Contraintes pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD CONSTRAINT `posseder_ibfk_1` FOREIGN KEY (`id_etd`) REFERENCES `etudiants` (`id_etd`),
  ADD CONSTRAINT `posseder_ibfk_2` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
