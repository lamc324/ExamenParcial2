-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-02-2017 a las 22:40:38
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `progra3_exa2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author`
--

CREATE TABLE `author` (
  `id_author` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `author`
--

INSERT INTO `author` (`id_author`, `name`) VALUES
(3, 'JK Mike'),
(4, 'JK Mike'),
(7, 'JK Mike'),
(8, 'JK Mike'),
(9, 'JK Mike'),
(10, 'JK Mike'),
(11, 'JK Mike'),
(12, 'JK Mike'),
(13, 'JK Mike'),
(14, 'JK Mike');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `author_contact`
--

CREATE TABLE `author_contact` (
  `id_author_contact` int(11) NOT NULL,
  `id_author` int(11) NOT NULL,
  `contact` text NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `author_contact`
--

INSERT INTO `author_contact` (`id_author_contact`, `id_author`, `contact`, `type`) VALUES
(5, 9, '223234234', 'casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book`
--

CREATE TABLE `book` (
  `id_book` int(11) NOT NULL,
  `id_author` int(11) NOT NULL,
  `id_book_type` int(11) NOT NULL,
  `name` text NOT NULL,
  `date_release` datetime NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `book`
--

INSERT INTO `book` (`id_book`, `id_author`, `id_book_type`, `name`, `date_release`, `price`) VALUES
(5, 10, 10, 'Harry Potter', '2016-11-01 00:00:00', 1000),
(6, 11, 11, 'Harri Potter 2', '2016-12-01 00:00:00', 1200),
(7, 12, 12, 'Harri Potter 2', '2016-12-01 00:00:00', 1200),
(8, 13, 13, 'Harri Potter 2', '2016-12-01 00:00:00', 1200),
(9, 14, 14, 'Harry Potter', '2016-11-01 00:00:00', 1000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `book_type`
--

CREATE TABLE `book_type` (
  `id_type` int(11) NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `book_type`
--

INSERT INTO `book_type` (`id_type`, `type`) VALUES
(9, 'Drama'),
(10, 'Drama'),
(11, 'Drama'),
(12, 'Drama'),
(13, 'Drama'),
(14, 'Drama');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id_author`);

--
-- Indices de la tabla `author_contact`
--
ALTER TABLE `author_contact`
  ADD PRIMARY KEY (`id_author_contact`),
  ADD KEY `id_author` (`id_author`);

--
-- Indices de la tabla `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id_book`),
  ADD KEY `id_author` (`id_author`),
  ADD KEY `id_book_type` (`id_book_type`);

--
-- Indices de la tabla `book_type`
--
ALTER TABLE `book_type`
  ADD PRIMARY KEY (`id_type`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `author`
--
ALTER TABLE `author`
  MODIFY `id_author` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `author_contact`
--
ALTER TABLE `author_contact`
  MODIFY `id_author_contact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `book`
--
ALTER TABLE `book`
  MODIFY `id_book` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `book_type`
--
ALTER TABLE `book_type`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `author_contact`
--
ALTER TABLE `author_contact`
  ADD CONSTRAINT `id_author` FOREIGN KEY (`id_author`) REFERENCES `author` (`id_author`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `idAuthor` FOREIGN KEY (`id_author`) REFERENCES `author` (`id_author`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idType` FOREIGN KEY (`id_book_type`) REFERENCES `book_type` (`id_type`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
