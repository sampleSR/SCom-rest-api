-- Users
INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (1, 'aihc', 'Huanca', 'Condori', 'Alvaro', 'alva0741@gmail.com', 'alvaro123', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO administrador (id_u, salario, especialidad) VALUES (1, 40000, 'Admin');

INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (2, 'cashier', '', '', 'Cashier', 'cashier@gmail.com', 'cashier', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO cajero (id_u, salario, titulo) VALUES (2, 20000, 'lic');

INSERT IGNORE INTO usuario (id_u, username, ap_paterno, ap_materno, nombre, email, contrasenia, direccion) VALUES (3, 'chef', '', '', 'chef', 'chef@gmail.com', 'chef', 'Zona: zona, Calle: calle');
INSERT IGNORE INTO chef (id_u, salario, especialidad, nacionalidad, cod_sanidad) VALUES (3, 20000, 'local', 'Boliviano', '15051ADC');

-- Images
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (1, 'plato1', 'ux2s9m4owbzgr00c4dji', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126677/ux2s9m4owbzgr00c4dji.jpg');
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (2, 'plato2', 'booc0v9rc6sgsksp3ayl', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126696/booc0v9rc6sgsksp3ayl.png');
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (3, 'plato3', 'n9yknkg9yv9jdx7vgz2v', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126729/n9yknkg9yv9jdx7vgz2v.jpg');
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (4, 'bebida1', 'ifpd3rupuoux0xkcmggs', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126757/ifpd3rupuoux0xkcmggs.jpg');
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (5, 'bebida2', 'zcqb7bbdvzvdt5w1quxm', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126786/zcqb7bbdvzvdt5w1quxm.jpg');
INSERT IGNORE INTO scom_rest.imagen (id_i, nombre, public_id, url) VALUES (6, 'bebida3', 'pxevf7g5q8zaw2fxbbb6', 'http://res.cloudinary.com/dedlan1fs/image/upload/v1664126797/pxevf7g5q8zaw2fxbbb6.jpg');

-- Foods
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (1, true, 25.0, 1);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (1, 'Silpancho', 'Llano');
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (2, true, 25.0, 2);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (2, 'Milanesa de pollo', 'Hondo');
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (3, true, 25.0, 3);
INSERT IGNORE INTO plato (id_p, nombre, tipo) VALUES (3, 'Aji de fideo', 'Llano');
-- Drinks
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (4, true, 15.0, 4);
INSERT IGNORE INTO bebida (id_p, grado_alcoholico, marca, volumen) VALUES (4, '0%', '7up', '2L');
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (5, true, 20.0, 5);
INSERT IGNORE INTO bebida (id_p, grado_alcoholico, marca, volumen) VALUES (5, '0%', 'Mendocina', '3L');
INSERT IGNORE INTO producto (id_p, disponible, precio, id_imagen) VALUES (6, true, 17.0, 6);
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
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (1, 4, '1');
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (2, 2, '2');
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (3, 4, '3');
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (4, 6, '4');
INSERT IGNORE INTO mesa(id_m, capacidad, numero) VALUES (5, 6, '5');

-- Orders
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (1, '2008-05-31 20:15:50', '2008-05-31 22:06:50', 1, 3, 1);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (2, '2008-05-17 20:06:50', '2008-05-17 21:06:50', 2, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (3, '2008-06-16 20:06:50', '2008-06-16 20:45:50', 3, 3, 3);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (4, '2015-02-22 20:06:50', '2015-02-22 20:36:50', 4, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (5, '2015-07-14 20:06:50', '2015-07-14 20:15:50', 5, 3, 2);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (6, '2020-07-18 20:06:50', '2020-07-18 20:18:50', 6, 3, 1);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (7, '2020-11-30 20:06:50', '2020-11-30 20:41:50', 7, 3, 3);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (8, '2020-01-05 20:06:50', '2020-01-05 20:18:50', 8, 3, 4);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (9, '2022-07-31 20:06:50', '2022-07-31 20:36:50', 8, 3, 5);
INSERT IGNORE INTO pedido (id_pe, fecha, fecha_factura, id_factura, id_chef, id_mesa) VALUES (10, '2022-08-02 20:06:50', '2022-08-02 20:45:50', 9, 3, 4);

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

-- Questions&Answers
INSERT IGNORE INTO preg_resp(id_pr, pregunta, respuesta, id_admin) VALUES (1,'¿Es posible pedir platos con un mes de anticipación?','Si es posible hacerlo mediante nuestra aplicación móvil.',1);
INSERT IGNORE INTO preg_resp(id_pr, pregunta, respuesta, id_admin) VALUES (2,'¿En que horario podemos comer o cenar en el restaurante?','Todos los días de 13:00 a 15:30h. Y por las noches, viernes y sábado de 20:00h a 22:30h.',1);
INSERT IGNORE INTO preg_resp(id_pr, pregunta, respuesta, id_admin) VALUES (3,'¿Cuáles son las medidas COVID-19 que debo conocer antes de acudir a las instalaciones?','El restaurante fue preparado como un lugar seguro en cumplimiento de todas las medidas de prevención, los máximos niveles de seguridad. Todo el centro se somete periódicamente a intervenciones de limpieza, higiene y desinfección. La colaboración de los usuarios es fundamental de cara a garantizar la efectividad de estas medidas.',1);

-- Mission&Vision
INSERT IGNORE INTO mis_vis(id_mv, fecha, mision, vision, id_admin) VALUES (1,'2022-02-02','Superar las expectativas de nuestros clientes de forma tal que nuestro nombre sea conocido como una experiencia memorable. Ser opción destacable y diferente.','Ser reconocidos entre los mejores restaurantes a nivel local y nacional por nuestra oferta gastronómica, ambiente y atención.',1);
