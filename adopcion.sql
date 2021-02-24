-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--


DROP DATABASE IF EXISTS adopcion;
CREATE DATABASE adopcion;
USE adopcion;
SET FOREIGN_KEY_CHECKS=0;


CREATE TABLE `adopcion` (
  `id_adopcion` bigint(20) UNSIGNED NOT NULL,
  `perro_id` bigint(20) UNSIGNED NOT NULL,
  `adoptante_id` bigint(20) UNSIGNED NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `adopcion`
--

INSERT INTO `adopcion` (`id_adopcion`, `perro_id`, `adoptante_id`, `fecha`) VALUES
(9, 5, 5, '2021-02-24 18:13:38'),
(10, 4, 5, '2021-02-24 18:32:48'),
(11, 2, 1, '2021-02-24 18:42:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adoptante`
--

CREATE TABLE `adoptante` (
  `id_adoptante` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_1` varchar(50) NOT NULL,
  `apellido_2` varchar(50) NOT NULL,
  `direccion` varchar(256) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `comunidad_autonoma` varchar(128) NOT NULL,
  `codigo_postal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `perro` (
  `id_perro` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `raza` varchar(256) NOT NULL,
  `anno_nacimiento` year(4) NOT NULL,
  `direccion_perrera` varchar(256) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `adopcion`
  ADD PRIMARY KEY (`id_adopcion`),
  ADD UNIQUE KEY `id_adopcion` (`id_adopcion`),
  ADD KEY `perro_id` (`perro_id`),
  ADD KEY `adoptante_id` (`adoptante_id`);

--
-- Indices de la tabla `adoptante`
--
ALTER TABLE `adoptante`
  ADD PRIMARY KEY (`id_adoptante`),
  ADD UNIQUE KEY `id_adoptante` (`id_adoptante`);

--
-- Indices de la tabla `perro`
--
ALTER TABLE `perro`
  ADD PRIMARY KEY (`id_perro`),
  ADD UNIQUE KEY `id_perro` (`id_perro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `adopcion`
--
ALTER TABLE `adopcion`
  MODIFY `id_adopcion` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `adoptante`
--
ALTER TABLE `adoptante`
  MODIFY `id_adoptante` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `perro`
--
ALTER TABLE `perro`
  MODIFY `id_perro` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `adopcion`
--
ALTER TABLE `adopcion`
  ADD CONSTRAINT `adopcion_ibfk_1` FOREIGN KEY (`perro_id`) REFERENCES `perro` (`id_perro`) ON UPDATE CASCADE,
  ADD CONSTRAINT `adopcion_ibfk_2` FOREIGN KEY (`adoptante_id`) REFERENCES `adoptante` (`id_adoptante`) ON UPDATE CASCADE;

INSERT INTO `perro` (`id_perro`, `nombre`, `raza`, `anno_nacimiento`, `direccion_perrera`, `estado`) VALUES
(1, 'tobby', 'perro de agua', 2015, 'Calle imaginaria 6', 0),
(2, 'kira', 'dogo aleman', 2019, 'calle de desengaño 13', 0),
(4, 'Oso', 'mestizo', 2020, 'Perrera municipal de mostoles', 0),
(5, 'gorda', 'boxer', 2015, 'perrera de alcorcon', 0),
(6, 'lolo', 'doberman', 2016, 'Perrera municipal de madrid', 0);

INSERT INTO `adoptante` (`id_adoptante`, `nombre`, `apellido_1`, `apellido_2`, `direccion`, `ciudad`, `comunidad_autonoma`, `codigo_postal`) VALUES
(1, 'Rocio Esperanza', 'Soriano', 'Gomez', 'Calle desconocida 35, portal 3, 2b IZQUIERDA', 'Madrid', 'Comunidad de Madrid', 28026),
(3, 'Juan Maria', 'Diego', 'Mayor', 'calle ac/dc ,34,1b, escalera derecha', 'Barcelona', 'Cataluña', 36089),
(4, 'Juan Jose', 'Garcia', 'Garcia', 'plaza de españa 1 34', 'Madrid', 'Comunidad de Madrid', 28056),
(5, 'Carmen', 'profesora ', 'UFV', 'pozuleo de alracon detras', 'Madrid', 'Comunidad de Madrid', 28056);



