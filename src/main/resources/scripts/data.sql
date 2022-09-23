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

-- Customers
INSERT IGNORE INTO usuario (id_u, direccion, email, ap_paterno, ap_materno, nombre, contrasenia, username) VALUES (10, 'Zona: zona, Calle: calle', 'jorge@gmail.com', 'quispe', 'mamani', 'jorge', '1234', 'cliente');
INSERT IGNORE INTO cliente (id_u, nit) VALUES (10, 20000);

INSERT IGNORE INTO usuario (id_u, direccion, email, ap_paterno, ap_materno, nombre, contrasenia, username) VALUES (11, 'Zona: zona, Calle: calle', 'cege@gmail.com', 'lopez', 'mamani', 'cesar', '123', 'cliente');
INSERT IGNORE INTO cliente (id_u, nit) VALUES (11, 20001);

INSERT IGNORE INTO usuario (id_u, direccion, email, ap_paterno, ap_materno, nombre, contrasenia, username) VALUES (12, 'Zona: zona, Calle: calle', 'valge@gmail.com', 'quispe', 'mamani', 'valdez', '12', 'cliente');
INSERT IGNORE INTO cliente (id_u, nit) VALUES (12, 20002);

INSERT IGNORE INTO usuario (id_u, direccion, email, ap_paterno, ap_materno, nombre, contrasenia, username) VALUES (13, 'Zona: zona, Calle: calle', 'vicge@gmail.com', 'quispe', 'mamani', 'victor', '1111', 'cliente');
INSERT IGNORE INTO cliente (id_u, nit) VALUES (13, 20003);

INSERT IGNORE INTO usuario (id_u, direccion, email, ap_paterno, ap_materno, nombre, contrasenia, username) VALUES (14, 'Zona: zona, Calle: calle', 'marce@gmail.com', 'quispe', 'mamani', 'marco', '12345', 'cliente');
INSERT IGNORE INTO cliente (id_u, nit) VALUES (14, 20004);

-- Bills
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (1, 2, 10);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (2, 2, 10);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (3, 2, 11);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (4, 2, 11);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (5, 2, 12);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (6, 2, 13);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (7, 2, 13);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (8, 2, 13);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (9, 2, 14);
INSERT IGNORE INTO factura (id_f, id_cajero, id_cliente) VALUES (10, 2, 14);

-- Restaurant Tables
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (1, 4, "1");
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (2, 2, "2");
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (3, 4, "3");
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (4, 6, "4");
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (5, 6, "5");

-- Orders
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (1, "2008-05-31 20:15:50", "2008-05-31 22:06:50", 1, 3, 1);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (2, "2008-05-17 20:06:50", "2008-05-17 21:06:50", 2, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (3, "2008-06-16 20:06:50", "2008-06-16 20:45:50", 3, 3, 3);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (4, "2015-02-22 20:06:50", "2015-02-22 20:36:50", 4, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (5, "2015-07-14 20:06:50", "2015-07-14 20:15:50", 5, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (6, "2020-07-18 20:06:50", "2020-07-18 20:18:50", 6, 3, 1);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (7, "2020-11-31 20:06:50", "2020-11-31 20:41:50", 7, 3, 3);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (8, "2020-01-05 20:06:50", "2020-01-05 20:18:50", 8, 3, 4);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (9, "2022-07-31 20:06:50", "2022-07-31 20:36:50", 8, 3, 5);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (10, "2022-08-02 20:06:50", "2022-08-02 20:45:50", 9, 3, 4);

-- Order >-< Product Relationship
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (1, 1, 2);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (1, 2, 4);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (2, 2, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (2, 3, 1);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (3, 1, 2);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (4, 4, 2);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (4, 5, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (5, 1, 4);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (6, 2, 1);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (7, 5, 2);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (8, 2, 3);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (8, 3, 4);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (9, 4, 5);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (9, 2, 2);
INSERT IGNORE INTO tiene (id_pedido, id_producto, cantidad) VALUES (10, 1, 3);
