DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `categorias` VALUES (1,'Teclado'),(2,'Switch'),(3,'Keycaps'),(4,'Cables'),(5,'Herramientas'),(6,'Piezas');

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `cantidad` int NOT NULL,
  `imagen` varchar(300) NOT NULL,
  `idCategoria` int NOT NULL,
  `destacado` tinyint(1) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`id`)
);
INSERT INTO `productos` VALUES 
  (1,'Black & Gold 5075S ISO','Teclado 75%',1.00,0,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/5075-_-RGB.png?v=1680235384&width=800',1,1,1),
  (2,'Horizon 5087B Plus ISO','Teclado TKL',1.00,14,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/5087-__RGB_b3e7a2ba-a7d3-4e54-ac7c-83cb629420db.png?v=1680235362&width=800',1,1,1),
  (3,'Dragon Ball 5075B Plus','Teclado 75%',1.00,14,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/5075-JDA-__RGB.png?v=1680235127&width=800',1,1,1),
  (4,'Blue/White Keycap Set','Keycaps',1.00,10,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/ASA.png?v=1667814568&width=800',3,0,1),
  (5,'V3 Cream Yellow Pro','Switch',11.00,15,'https://cdn.shopify.com/s/files/1/0609/5428/0135/files/V3CreamYellowProSwitch_2.png?v=1682579503&width=800',2,0,1),
  (6,'Coiled Cable','Cable ',11.00,15,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/a62ca99f015b7ae3467fec87641bc361.png?v=1667815395&width=800',4,0,1),
  (7,'Naruto 5075B Plus','Teclado',130.00,10,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/5075-__RGB_212d70e6-7bab-46a5-aedc-78e51aa0f802.png?v=1680235274&width=800',1,1,1),
  (8,'Carbon Retro Keycap Set','Keycaps ',60.00,15,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/0_fdcaff0c-5779-4fdb-bee8-4ab62de1563a.png?v=1682598709&width=800',3,1,1),
  (10,'MOD 006 DIY Kit','Kit montaje teclado',160.00,10,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/MOD-006_2a25b20c-cf6c-4602-a247-3ccb34694723.png?v=1667813725&width=800',6,0,1),
  (11,'Screw-in Estabilizadores','Kit montaje teclado',15.00,10,'https://cdn.shopify.com/s/files/1/0609/5428/0135/products/2_d557d3c8-a813-4b1f-9afc-497b9a9c8d48.png?v=1667813539&width=800',6,0,1);

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `estado` tinyint NOT NULL,
  `precioTotal` decimal(7,2) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`)
);
INSERT INTO `pedidos` VALUES (1,1,0,31.00,1),(5,5,1,61.00,1),(6,12,1,34.00,1),(11,1,0,0.00,1),(12,1,0,2.00,1),(13,1,0,5.00,1),(14,1,0,4.00,1),(15,1,1,1.00,1),(16,13,1,NULL,1);

DROP TABLE IF EXISTS `detallespedido`;
CREATE TABLE `detallespedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idPedido` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidadProducto` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idPedido` (`idPedido`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `detallespedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `detallespedido_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`)
);
INSERT INTO `detallespedido` VALUES (62,5,1,1),(63,5,2,2),(64,1,1,1),(65,6,1,4),(66,6,2,1),(68,1,2,1),(83,12,1,1),(84,12,2,1),(85,13,1,5),(87,14,4,4),(88,15,1,1);

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL,
  `fechaNacimiento` varchar(10) NOT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `usuarios` VALUES 
(1,'a','a','a','a@a','a','a','2023-05-23',1),
(2,'admin','admin','admin','admin@admin','$2a$10$P23r9EHXCb90poQ78mwPHe9FpHklktOduRJ1KtSxRQPvhIStlvp0C','1','1999-05-14',1),
(5,'pepe','pepe','pepe','p@a','pepe','','1999-05-14',1),
(12,'a','a','kike','enriquevilas9@gmail.com','1','','1999-01-10',1),
(13,'p','p','p','p@p','1','','1999-10-10',1);

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `rol` VALUES (1,'USUARIO'),(2,'ADMINISTRADOR');

DROP TABLE IF EXISTS `usuariosxrol`;
CREATE TABLE `usuariosxrol` (
  `idUsuario` int NOT NULL,
  `idRol` int NOT NULL,
  KEY `idUsuario` (`idUsuario`),
  KEY `idRol` (`idRol`),
  CONSTRAINT `usuariosxrol_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `usuariosxrol_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `rol` (`id`)
);
INSERT INTO `usuariosxrol` VALUES (2,2),(13,1);
