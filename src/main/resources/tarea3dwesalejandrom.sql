-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 12-12-2024 a las 21:26:12
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
-- Base de datos: `tarea3dwesalejandrom`
--
CREATE DATABASE IF NOT EXISTS `tarea3dwesalejandrom` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tarea3dwesalejandrom`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `password`, `usuario`, `id_persona`) VALUES
(1, 'admin', 'admin', 0),
(4, 'Alejandro.', 'Alejandro', 5),
(5, 'luisdbb.', 'Luisdbb', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `idplanta` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `nombre`, `idplanta`) VALUES
(1, 'ROSA_1', 1),
(2, 'ROSA_2', 1),
(3, 'ROSA_3', 1),
(4, 'HIEDRA_4', 6),
(5, 'HELECHO_5', 10),
(6, 'LAVANDA_6', 9),
(7, 'ALOE_7', 3),
(8, 'PINO_8', 4),
(9, 'PINO_9', 4),
(10, 'LIRIO_10', 8),
(11, 'CINTA_11', 5),
(12, 'MARGARITA_12', 2),
(13, 'MARGARITA_13', 2),
(14, 'MARGARITA_14', 2),
(15, 'HELECHO_15', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `id` bigint(20) NOT NULL,
  `fecha_hora` datetime(6) NOT NULL,
  `mensaje` varchar(500) NOT NULL,
  `id_ejemplar` bigint(20) NOT NULL,
  `id_persona` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensajes`
--

INSERT INTO `mensajes` (`id`, `fecha_hora`, `mensaje`, `id_ejemplar`, `id_persona`) VALUES
(1, '2024-12-10 12:32:05.000000', 'Añadido el ejemplar ROSA_2', 2, 0),
(2, '2024-12-10 12:32:54.000000', 'Trabajos de mantenimiento del ejemplar', 2, 0),
(3, '2024-12-10 13:44:38.000000', 'Añadido el ejemplar ROSA_3', 3, 0),
(4, '2024-12-10 13:44:43.000000', 'Añadido el ejemplar HIEDRA_4', 4, 0),
(5, '2024-12-10 13:44:54.000000', 'Añadido el ejemplar HELECHO_5', 5, 0),
(6, '2024-12-10 13:44:59.000000', 'Añadido el ejemplar LAVANDA_6', 6, 0),
(7, '2024-12-10 13:45:13.000000', 'Añadido el ejemplar ALOE_7', 7, 0),
(8, '2024-12-10 13:45:16.000000', 'Añadido el ejemplar PINO_8', 8, 0),
(9, '2024-12-10 13:45:19.000000', 'Añadido el ejemplar PINO_9', 9, 0),
(10, '2024-12-10 13:45:35.000000', 'Añadido el ejemplar LIRIO_10', 10, 0),
(11, '2024-12-10 13:45:37.000000', 'Añadido el ejemplar CINTA_11', 11, 0),
(12, '2024-12-10 13:45:41.000000', 'Añadido el ejemplar MARGARITA_12', 12, 0),
(13, '2024-12-10 13:45:44.000000', 'Añadido el ejemplar MARGARITA_13', 13, 0),
(14, '2024-12-10 13:45:47.000000', 'Añadido el ejemplar MARGARITA_14', 14, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `email`, `nombre`) VALUES
(0, 'admin@admin.es', 'admin'),
(5, 'Alejandromg73@educastur.es', 'Alejandro'),
(6, 'luisdbb@educastur.es', 'Luisdbb');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

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
(1, 'ROSA', 'Rosa Rosae', 'Rosa'),
(2, 'MARGARITA', 'Bellis perennis', 'Margarita'),
(3, 'ALOE', 'Aloe barbadensis', 'Aloe Vera'),
(4, 'PINO', 'Pinus', 'Pino'),
(5, 'CINTA', 'Chlorophytum comosum', 'Cinta'),
(6, 'HIEDRA', 'Hedera', 'Hiedra'),
(8, 'LIRIO', 'Lirium', 'Lirio'),
(9, 'LAVANDA', 'Lavandula', 'Lavanda'),
(10, 'HELECHO', 'Pteridium aquilinum', 'Helecho');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKgl50fmouks2ue8s9yclvv059j` (`usuario`),
  ADD UNIQUE KEY `UKkj0bakygq84a8uwy2avcihxqi` (`id_persona`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKclleiwyydddhkx72v38u6uw0l` (`idplanta`);

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKlrw7flsg11d8nhgyvueqtnp8e` (`email`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `plantas`
--
ALTER TABLE `plantas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD CONSTRAINT `FKgntr1s6h8ryu511tqjln50yp2` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id`);

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `FKclleiwyydddhkx72v38u6uw0l` FOREIGN KEY (`idplanta`) REFERENCES `plantas` (`id`);

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
