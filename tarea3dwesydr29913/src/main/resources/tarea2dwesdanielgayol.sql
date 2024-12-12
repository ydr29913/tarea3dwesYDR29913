-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-12-2024 a las 14:22:18
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tarea2dwesdanielgayol`
--
CREATE DATABASE IF NOT EXISTS `tarea2dwesdanielgayol` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tarea2dwesdanielgayol`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

DROP TABLE IF EXISTS `credenciales`;
CREATE TABLE `credenciales` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `password`, `usuario`, `perfil`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'jose', 'jose', ''),
(3, 'marcos', 'marcos', ''),
(4, 'personal', 'personal', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
CREATE TABLE `ejemplares` (
  `id` bigint(20) NOT NULL,
  `id_planta` bigint(20) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `id_planta`, `nombre`) VALUES
(1, 1, 'Rosa-1'),
(2, 1, 'Rosa-2'),
(3, 1, 'Rosa-3'),
(4, 1, 'Rosa-4'),
(5, 4, 'Girasol-1'),
(6, 4, 'Girasol-2'),
(7, 5, 'Hortensia-1'),
(8, 5, 'Hortensia-2'),
(9, 2, 'Margarita-1'),
(10, 2, 'Margarita-2'),
(11, 6, 'Tulipan-1'),
(12, 6, 'Tulipan-2'),
(13, 3, 'Violeta-1'),
(14, 3, 'Violeta-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
CREATE TABLE `mensajes` (
  `fecha_hora` time(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `id_ejemplar` bigint(20) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `mensaje` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensajes`
--

INSERT INTO `mensajes` (`fecha_hora`, `id`, `id_ejemplar`, `id_persona`, `mensaje`) VALUES
('13:07:55.000000', 1, 4, NULL, 'Añadido ejemplar Rosa-4'),
('13:45:06.000000', 2, 5, NULL, 'Añadido ejemplar Girasol-1'),
('13:45:33.000000', 3, 6, NULL, 'Añadido ejemplar Girasol-2'),
('13:45:50.000000', 4, 7, NULL, 'Añadida ejemplar Hortensia-1'),
('13:46:05.000000', 5, 8, NULL, 'Añadida ejemplar Hortensia-2'),
('13:46:20.000000', 6, 9, NULL, 'Añadida ejemplar Margarita-1'),
('13:46:41.000000', 7, 10, NULL, 'Añadida ejemplar Margarita-2'),
('13:46:55.000000', 8, 11, NULL, 'Añadido ejemplar Tulipan-1'),
('13:47:15.000000', 9, 12, NULL, 'Añadido ejemplar Tulipan-2'),
('13:47:30.000000', 10, 13, NULL, 'Añadida ejemplar Violeta-1'),
('13:47:47.000000', 11, 14, NULL, 'Añadida ejemplar Violeta-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `email`, `nombre`) VALUES
(1, 'dani@gmail.com', 'Dani'),
(2, 'jose@gmail.com', 'Jose'),
(3, 'marcos@gmail.com', 'Marcos'),
(4, 'personal@gmail.com', 'personal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

DROP TABLE IF EXISTS `plantas`;
CREATE TABLE `plantas` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre_cientifico` varchar(255) DEFAULT NULL,
  `nombre_comun` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plantas`
--

INSERT INTO `plantas` (`id`, `codigo`, `nombre_cientifico`, `nombre_comun`) VALUES
(1, '01', 'rosa-rosa', 'Rosa'),
(2, '02', 'margarita-margarita', 'Margarita'),
(3, '03', 'violeta-violeta', 'Violeta'),
(4, '04', 'girasol-girasol', 'Girasol'),
(5, '05', 'hortensia-hortensia', 'Hortensia'),
(6, '06', 'tulipan-tulipan', 'Tulipan');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK44fnp4rtcs2j6ppkmkoqbtton` (`id_planta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKidbx1mhngh3c3ry5bqisftxbv` (`id_ejemplar`),
  ADD KEY `FK2e6au5w562m7skcvx9jckiba6` (`id_persona`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKbqo6lbeads0ifdh6dohhfhryp` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `plantas`
--
ALTER TABLE `plantas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `FK44fnp4rtcs2j6ppkmkoqbtton` FOREIGN KEY (`id_planta`) REFERENCES `plantas` (`id`);

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `FK2e6au5w562m7skcvx9jckiba6` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`),
  ADD CONSTRAINT `FKidbx1mhngh3c3ry5bqisftxbv` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplares` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
