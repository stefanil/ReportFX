-- --------------------------------------------------------
-- Host:                         localhost
-- Server Version:               5.6.23-log - MySQL Community Server (GPL)
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Exportiere Datenbank Struktur für stadtwerke
CREATE DATABASE IF NOT EXISTS `stadtwerke` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stadtwerke`;


-- Exportiere Struktur von Tabelle stadtwerke.monatswerte
CREATE TABLE IF NOT EXISTS `monatswerte` (
  `id` bigint(20) NOT NULL,
  `zaehler_wechsel` bit(1) NOT NULL,
  `id_zs_monat` bigint(20) NOT NULL,
  `datum` datetime NOT NULL,
  `eingabe` double NOT NULL,
  PRIMARY KEY (`id`,`id_zs_monat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='monatlicher Messwert zu einem Zählerstand\r\n';

-- Exportiere Daten aus Tabelle stadtwerke.monatswerte: ~1 rows (ungefähr)
DELETE FROM `monatswerte`;
/*!40000 ALTER TABLE `monatswerte` DISABLE KEYS */;
INSERT INTO `monatswerte` (`id`, `zaehler_wechsel`, `id_zs_monat`, `datum`, `eingabe`) VALUES
	(1, b'1', 1, '2013-02-06 12:06:24', 1000),
	(2, b'0', 1, '2013-04-06 11:55:35', 1100),
	(3, b'0', 1, '2013-06-06 12:01:35', 1150),
	(4, b'0', 1, '2013-07-06 11:45:35', 1232),
	(5, b'0', 1, '2013-08-06 18:35:35', 1195),
	(6, b'1', 1, '2013-10-06 12:05:35', 1190),
	(7, b'0', 1, '2014-01-06 12:01:35', 1312),
	(8, b'0', 1, '2014-02-06 12:48:35', 1450),
	(9, b'0', 1, '2014-03-06 11:52:35', 1445),
	(10, b'0', 1, '2014-04-06 11:27:35', 1457),
	(11, b'0', 1, '2014-05-06 12:42:35', 1625),
	(12, b'0', 1, '2014-06-06 11:45:35', 1700),
	(13, b'0', 1, '2014-07-06 12:35:35', 1725),
	(14, b'0', 1, '2014-08-06 12:45:35', 1715),
	(15, b'0', 1, '2014-09-06 11:45:35', 1824.4),
	(16, b'0', 1, '2014-10-06 12:45:35', 1901.55),
	(17, b'0', 1, '2014-11-06 15:45:35', 1963.55),
	(18, b'1', 1, '2014-12-06 18:45:35', 2003.4),
	(19, b'0', 1, '2015-01-07 12:57:00', 2025.4),
	(20, b'0', 1, '2015-02-06 13:57:00', 1985.5),
	(21, b'0', 2, '2013-02-07 12:06:24', 609),
	(22, b'0', 2, '2013-04-07 11:55:35', 1254),
	(23, b'0', 2, '2013-06-07 12:01:35', 1254),
	(24, b'0', 2, '2013-07-12 11:45:35', 1254),
	(25, b'0', 2, '2013-08-15 18:35:35', 1254),
	(26, b'0', 2, '2013-10-07 12:05:35', 600),
	(27, b'1', 2, '2014-01-07 12:01:35', 610),
	(28, b'0', 2, '2014-02-07 12:48:35', 610),
	(29, b'0', 2, '2014-03-07 11:52:35', 615),
	(30, b'0', 2, '2014-04-08 11:27:35', 625),
	(31, b'0', 2, '2014-05-07 12:42:35', 625),
	(32, b'0', 2, '2014-06-07 11:45:35', 626),
	(33, b'0', 2, '2014-07-07 12:35:35', 635),
	(34, b'0', 2, '2014-08-07 12:45:35', 700),
	(35, b'0', 2, '2014-09-07 11:45:35', 700),
	(36, b'0', 2, '2014-10-07 12:45:35', 700),
	(37, b'1', 2, '2014-11-07 15:45:35', 700),
	(38, b'0', 2, '2014-12-07 18:45:35', 600),
	(39, b'0', 2, '2015-01-07 12:57:00', 600),
	(40, b'0', 2, '2015-02-07 13:57:00', 634),
	(41, b'1', 3, '2013-01-05 12:06:24', 1000),
	(42, b'0', 3, '2013-04-04 12:55:35', 1000),
	(43, b'0', 3, '2013-06-05 12:01:35', 1050),
	(44, b'0', 3, '2013-07-05 11:45:35', 1215),
	(45, b'0', 3, '2013-09-05 18:35:35', 1222),
	(46, b'1', 3, '2013-12-08 12:05:35', 1312),
	(47, b'0', 3, '2014-01-05 12:01:35', 1412),
	(48, b'0', 3, '2014-02-05 12:48:35', 1460),
	(49, b'0', 3, '2014-03-05 11:52:35', 1465),
	(50, b'0', 3, '2014-04-05 11:27:35', 1499),
	(51, b'0', 3, '2014-05-05 12:42:35', 1625),
	(52, b'0', 3, '2014-06-05 11:45:35', 1711),
	(53, b'0', 3, '2014-07-05 12:35:35', 1724),
	(54, b'0', 3, '2014-08-05 12:45:35', 1726),
	(55, b'0', 3, '2014-09-05 11:45:35', 1803.4),
	(56, b'0', 3, '2014-10-05 12:45:35', 1905.55),
	(57, b'0', 3, '2014-11-05 15:45:35', 1952.55),
	(58, b'0', 3, '2014-12-05 18:45:35', 3000.4),
	(59, b'1', 3, '2015-01-05 13:57:00', 3025.4),
	(60, b'0', 3, '2015-02-05 13:57:00', 3046.5);
/*!40000 ALTER TABLE `monatswerte` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle stadtwerke.zs_monatlich
CREATE TABLE IF NOT EXISTS `zs_monatlich` (
  `id` bigint(20) NOT NULL,
  `bezeichnung` varchar(50) DEFAULT NULL,
  `sichtbar` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Zählerstand, der monatlich gemessen wird';

-- Exportiere Daten aus Tabelle stadtwerke.zs_monatlich: ~0 rows (ungefähr)
DELETE FROM `zs_monatlich`;
/*!40000 ALTER TABLE `zs_monatlich` DISABLE KEYS */;
INSERT INTO `zs_monatlich` (`id`, `bezeichnung`, `sichtbar`) VALUES
	(1, 'Solaranlage', b'1'),
	(2, 'Aufladestation', b'1'),
	(3, 'Güllegrube', b'1');
/*!40000 ALTER TABLE `zs_monatlich` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
