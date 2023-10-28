-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2023 a las 02:50:49
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equipo45-turnonoche-provemax`
--
CREATE DATABASE IF NOT EXISTS `equipo45-turnonoche-provemax` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `equipo45-turnonoche-provemax`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `idProveedor`, `fecha`) VALUES
(1, 5, '2023-10-18'),
(2, 16, '2023-10-18'),
(3, 5, '2023-10-18'),
(5, 5, '2023-10-18'),
(6, 5, '2023-10-19'),
(7, 16, '2023-10-19'),
(8, 16, '2023-10-19'),
(9, 12, '2023-10-19'),
(10, 5, '2023-10-19'),
(12, 5, '2023-10-19'),
(13, 5, '2023-10-19'),
(14, 5, '2023-10-19'),
(16, 5, '2023-10-19'),
(18, 5, '2023-10-20'),
(19, 5, '2023-10-23'),
(20, 5, '2023-10-23'),
(22, 5, '2023-10-23'),
(23, 5, '2023-10-23'),
(24, 5, '2023-10-23'),
(25, 5, '2023-10-23'),
(26, 12, '2023-10-24'),
(27, 29, '2023-10-24'),
(29, 30, '2023-10-24'),
(31, 5, '2023-10-25'),
(35, 5, '2023-10-27'),
(36, 16, '2023-10-27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

CREATE TABLE `detallecompra` (
  `idDetalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioCosto` double NOT NULL,
  `subTotal` double NOT NULL,
  `idCompra` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`idDetalle`, `cantidad`, `precioCosto`, `subTotal`, `idCompra`, `idProducto`) VALUES
(1, 2, 20000, 40000, 1, 32),
(2, 8, 52000, 416000, 2, 37),
(5, 2, 19000, 38000, 5, 37),
(6, 2, 2500, 5000, 6, 32),
(7, 6, 58200, 349200, 7, 35),
(8, 5, 25000, 125000, 8, 35),
(10, 6, 20000, 120000, 10, 32),
(18, 2, 20000, 40000, 19, 32),
(19, 2, 50000, 100000, 20, 32),
(22, 2, 140000, 280000, 22, 54),
(27, 3, 150000, 450000, 26, 32),
(28, 10, 58000, 580000, 27, 54),
(30, 9, 55000, 495000, 29, 56),
(36, 9, 25000, 225000, 35, 59),
(37, 15, 45000, 675000, 36, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(30) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int(11) NOT NULL,
  `categoria` varchar(25) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `descripcion`, `precioActual`, `stock`, `categoria`, `estado`) VALUES
(32, 'NOTEBOOK ', 'WINDOWS 11 CORE I7 16G RAM', 180000, 34, 'TECNOLOGIA', 1),
(35, 'HELADERA CON FREEZER', 'NO FROST COLOR BLANCO', 54000, 15, 'ELECTROHOGAR', 1),
(37, 'LAVARROPA DELUXE', 'CARGA SUPERIOR 8K', 190000, 10, 'ELECTROHOGAR', 1),
(54, 'COCINA ', 'HORNO DIGITAL', 69600, 12, 'TV y AUDIO', 1),
(56, 'PLAYSTATION 4', 'NEGRO CON JOYSTICK', 66000, 9, 'TECNOLOGIA', 1),
(59, 'MICROONDAS', '20L COLOR NEGRO', 30000, 9, 'ELECTROHOGAR', 1),
(60, 'SMART TV 49 ', 'FHD SISTEMA OPERATIVO ANDROID', 0, 0, 'TV y AUDIO', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `razonSocial` varchar(30) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `razonSocial`, `domicilio`, `telefono`, `estado`) VALUES
(5, 'LG ELECTRONICS S.R.L', 'MORENO 252 CABA', '1146263000', 1),
(11, 'LENOVO', 'ALEM 56 CABA', '1120563056', 1),
(12, 'SAMSUNG', 'AV. BELGRANO 562 CABA', '1196320258', 1),
(16, 'DREAN SA', 'MORENO 332 CABA', '1163932000', 1),
(29, 'ESCORIAL', 'MISIONES 32 CABA', '26951010', 1),
(30, 'SONY', 'CATAMARCA 85 CABA', '96302580', 1),
(31, 'MOTOROLA', 'AV. CORDOBA 12 CABA', '52208520', 1),
(32, 'ASUS', 'AV. CORDOBA 45 CABA', '60209630', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `idCompra` (`idCompra`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
