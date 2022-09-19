-- Users
INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (1, 'aihc', 'Huanca', 'Condori', 'Alvaro', 'alva0741@gmail.com', 'alvaro123', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO administrador (id_u, salario, especialidad) VALUES (1, 40000, 'Admin');

INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (2, 'cashier', '', '', 'Cashier', 'cashier@gmail.com', 'cashier', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO cajero (id_u, salario, titulo) VALUES (2, 20000, 'lic');

INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (3, 'chef', '', '', 'chef', 'chef@gmail.com', 'chef', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO chef (id_u, salario, especialidad, nacionalidad, cod_sanidad) VALUES (3, 20000, 'local', 'Boliviano', '15051ADC');

-- Foods
INSERT IGNORE INTO producto (id_p, precio) VALUES (1, 25.0);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (1, 'Silpancho', 'Llano');
INSERT IGNORE INTO producto (id_p, precio) VALUES (2, 25.0);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (2, 'Milanesa de pollo', 'Hondo');
INSERT IGNORE INTO producto (id_p, precio) VALUES (3, 25.0);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (3, 'Aji de fideo', 'Llano');
-- Drinks
INSERT IGNORE INTO producto (id_p, precio) VALUES (4, 15.0);
INSERT IGNORE INTO bebida (id_p, grado_alcoholico, marca, volumen) VALUES (4, '0%', '7up', '2L');
INSERT IGNORE INTO producto (id_p, precio) VALUES (5, 20.0);
INSERT IGNORE INTO bebida (id_p, grado_alcoholico, marca, volumen) VALUES (5, '0%', 'Mendocina', '3L');
INSERT IGNORE INTO producto (id_p, precio) VALUES (6, 17.0);
INSERT IGNORE INTO bebida (id_p, grado_alcoholico, marca, volumen) VALUES (6, '0%', 'Coca-Cola', '1L');

----------------------------------------
INSERT IGNORE INTO pedido (id_pe, fecha) VALUES (1, '2022-1-17');
INSERT IGNORE INTO pedido (id_pe, fecha) VALUES (2, '2022-1-18');
INSERT IGNORE INTO pedido (id_pe, fecha) VALUES (3, '2022-1-19');
INSERT IGNORE INTO pedido (id_pe, fecha) VALUES (4, '2022-1-20');

INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (1, 1, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (1, 6, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (2, 4, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (3, 2, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (3, 3, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (3, 4, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (4, 5, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (4, 1, 3);

