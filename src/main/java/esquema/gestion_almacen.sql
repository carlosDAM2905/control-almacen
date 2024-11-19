DROP DATABASE IF EXISTS gestion_almacen;
CREATE DATABASE IF NOT EXISTS gestion_almacen;

USE gestion_almacen;


CREATE TABLE almacenes (
                           id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                           responsable VARCHAR(50) NOT NULL,
                           ubicacion VARCHAR(50) NOT NULL,
                           capacidad DOUBLE NOT NULL
);


CREATE TABLE empleados (
                           id INT UNSIGNED PRIMARY KEY,
                           categoria VARCHAR(50) NOT NULL,
                           puesto VARCHAR(50) NOT NULL,
                           id_almacen INT UNSIGNED,
                           FOREIGN KEY (id_almacen) REFERENCES almacenes(id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE productos (
                           id INT UNSIGNED PRIMARY KEY,
                           fabricante VARCHAR(50) NOT NULL,
                           cantidad INT UNSIGNED NOT NULL,
                           id_empleado INT UNSIGNED,
                           FOREIGN KEY (id_empleado) REFERENCES empleados(id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE ubicaciones (
                             id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
                             id_producto INT UNSIGNED NOT NULL ,
                             id_almacen INT UNSIGNED NOT NULL ,
                             fecha DATE NOT NULL,
                             FOREIGN KEY (id_producto) REFERENCES productos(id) ON DELETE CASCADE ON UPDATE CASCADE,
                             FOREIGN KEY (id_almacen) REFERENCES almacenes(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- datos de los almacenes
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (1, 'Pedro García', 'PLAST', 50);
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (2, 'Juan Alonso', 'TORN', 120);
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (3, 'Laura Córdoba', 'ELECT', 30);
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (4, 'Rosa Martínez', 'LIQUID', 15);
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (5, 'Miguel Ramos', 'DISC', 50);
INSERT INTO almacenes (id, responsable, ubicacion, capacidad) VALUES (6, 'Andrea Ruiz', 'FRAGIL', 50);


-- Empleados de el Almacén PLAST

INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (1001001, 'capataz', 'retractil', 1);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (1001002, 'mozo', 'carretilla frontal', 1);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (1001003, 'oficial 3', 'apiladora', 1);

-- Empleados del almacén TORN
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (2001001, 'oficial 2', 'carretilla frontal', 2);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (2001002, 'mozo', 'retractil', 2);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (2001003, 'oficial 1', 'trilateral', 2);

-- Empleados de el almacén ELECT
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (3001001, 'oficial 3', 'carretilla frontal', 3);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (3001002, 'mozo', 'apiladora', 3);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (3001003, 'capataz', 'trilateral', 3);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (3001004, 'oficial 2', 'retractil', 3);

-- Empleados del almacén LIQUID
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (4001001, 'oficial 3', 'carretilla frontal', 4);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (4001002, 'mozo', 'retractil', 4);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (4001003, 'oficial 1', 'trilateral', 4);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (4001004, 'oficial 2', 'apiladora', 4);

-- Empleados del almacén DISC
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (5001001, 'mozo', 'carretilla frontal', 5);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (5001002, 'oficial 2', 'retractil', 5);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (5001003, 'capataz', 'trilateral', 5);

-- Empleados del almacen FRAGIL
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (6001001, 'mozo', 'retractil', 6);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (6001002, 'capataz', 'carretilla frontal', 6);
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (6001003, 'oficial 3', 'apiladora', 6);


-- productos para almacen de discos y pastillas
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (5001, 'Brembo', 100, 5001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (5002, 'Ferodo', 150, 5001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (5003, 'TVR', 200, 5001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (5004, 'MAPCO', 250, 5001001);

-- productos para almacen de plasticos
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1001, 'Autofren Seinsa', 120, 1001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1002, 'Metalcaucho', 130, 1001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1003, 'Fare', 140, 1001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1004, 'Frenkit', 110, 1001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1005, 'Doga', 160, 1001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (1006, 'Cautex', 170, 1001003);

-- productos para liquido
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4001, 'Castrol', 90, 4001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4002, 'Mobil', 80, 4001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4003, 'Valvoline', 85, 4001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4004, 'MOTUL', 95, 4001004);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4005, 'SELENIA', 100, 4001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (4006, 'TOTAL', 110, 4001002);

-- productos para electrico
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (3001, 'BOSCH', 60, 3001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (3002, 'Continental', 70, 3001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (3003, 'Ridex', 65, 3001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (3004, 'Hella', 75, 3001004);

-- productos para tornilleróia
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (2001, 'Helicoil', 50, 2001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (2002, 'Tucker', 55, 2001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (2003, 'Lenox', 60, 2001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (2004, '3M', 70, 2001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (2005, 'Stanley', 80, 2001002);


-- productos para fragil
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (6001, 'Philips', 40, 6001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (6002, 'VARTA', 45, 6001002);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (6003, 'Tudor', 50, 6001003);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (6004, 'Kat', 55, 6001001);
INSERT INTO productos (id, fabricante, cantidad, id_empleado) VALUES (6005, 'Fonos', 60, 6001002);

-- datos de la tabla ubicaciones

INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (5001, 5, '2024-03-01');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (5002, 5, '2024-03-01');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (5003, 5, '2024-03-02');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (5004, 5, '2024-03-05');


INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1001, 1, '2024-03-07');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1002, 1, '2024-03-07');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1003, 1, '2024-03-10');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1004, 1, '2024-03-12');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1005, 1, '2024-03-15');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (1006, 1, '2024-03-17');


INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4001, 4, '2024-04-01');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4002, 4, '2024-04-03');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4003, 4, '2024-04-05');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4004, 4, '2024-04-07');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4005, 4, '2024-04-07');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (4006, 4, '2024-04-10');


INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (3001, 3, '2024-04-12');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (3002, 3, '2024-04-12');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (3003, 3, '2024-04-15');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (3004, 3, '2024-04-17');


INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (2001, 2, '2024-04-20');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (2002, 2, '2024-04-22');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (2003, 2, '2024-04-25');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (2004, 2, '2024-04-27');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (2005, 2, '2024-04-30');


INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (6001, 6, '2024-05-02');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (6002, 6, '2024-05-03');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (6003, 6, '2024-05-05');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (6004, 6, '2024-05-05');
INSERT INTO ubicaciones (id_producto, id_almacen, fecha) VALUES (6005, 6, '2024-05-07');

use gestion_almacen;

# dar de alta un nuevo empleado:

DELIMITER $$
DROP PROCEDURE IF EXISTS alta_empleado;
CREATE PROCEDURE alta_empleado(IN id INT, IN categoria VARCHAR(50), IN puesto VARCHAR(50), IN id_almacen INT UNSIGNED)
BEGIN
INSERT INTO empleados (id, categoria, puesto, id_almacen) VALUES (id, categoria, puesto, id_almacen);
end $$;

DELIMITER ;
CALL alta_empleado(1001004, 'mozo', 'apiladora', 1);

-- ======================================================================================================================

# dar de baja a un empleado:

DELIMITER $$
DROP PROCEDURE IF EXISTS baja_empleado;
CREATE PROCEDURE baja_empleado(IN emp_id INT)
BEGIN
DELETE FROM empleados WHERE id = emp_id;
END $$;

DELIMITER ;
CALL baja_empleado(1001004);

-- ======================================================================================================================

# ACTUALIZAR DATOS DEL EMPLEADO:

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_empleado;
CREATE PROCEDURE actualizar_empleado(IN emp_id INT, IN nueva_categoria VARCHAR(50), IN nuevo_puesto VARCHAR(50), IN nuevo_id_almacen INT UNSIGNED
)
BEGIN
UPDATE empleados
SET categoria = nueva_categoria, puesto = nuevo_puesto, id_almacen = nuevo_id_almacen
WHERE id = emp_id;
END $$;

DELIMITER ;

DELIMITER ;

SELECT * from empleados where id = 1001003;
CALL actualizar_empleado(1001003, 'oficial 2', 'retractil', 2);


-- ======================================================================================================================

# CONSULTAR EMPLEADOS POR CATEGORÍA:

DELIMITER $$
DROP PROCEDURE IF EXISTS consultar_por_puesto;
CREATE PROCEDURE consultar_por_puesto(puesto_empleado VARCHAR(50))
BEGIN
SELECT * FROM empleados
WHERE puesto = puesto_empleado;
end $$

DELIMITER ;
CALL consultar_por_puesto('retráctil');

-- ======================================================================================================================

# CONSULTAR EMPLEADOS POR ALMACEN

DROP PROCEDURE IF EXISTS empleados_por_almacen;
CREATE PROCEDURE empleados_por_almacen(IN id_almacen INT UNSIGNED)
BEGIN
SELECT empleados.id, empleados.categoria, empleados.puesto
FROM empleados
WHERE empleados.id_almacen = id_almacen;
end;

DELIMITER ;
CALL empleados_por_almacen(1);

-- ======================================================================================================================

# VER EL RESPONSABLE QUE TIENE ASIGNADO UN EMPLEADO

DELIMITER $$
DROP PROCEDURE IF EXISTS ver_responsable_empleado;
CREATE PROCEDURE ver_responsable_empleado(IN emp_id INT)
BEGIN
SELECT empleados.id AS id_empleado, categoria, puesto, almacenes.responsable AS jefe
FROM empleados
         JOIN almacenes ON empleados.id_almacen = almacenes.id
WHERE empleados.id = emp_id;
END $$
DELIMITER ;

CALL ver_responsable_empleado(6001001);



-- ======================================================================================================================


# ver el responsable de un almacén en concreto:

DELIMITER &&
DROP PROCEDURE IF EXISTS ver_responsable_almacen;
CREATE PROCEDURE ver_responsable_almacen(IN id_almacen INT UNSIGNED)
BEGIN
SELECT responsable
FROM almacenes
WHERE id = id_almacen;
end &&

DELIMITER ;
CALL ver_responsable_almacen(1);

-- ======================================================================================================================

# ver la capacidad actual de un almacén:

DELIMITER &&

DROP PROCEDURE IF EXISTS huecos_ocupados_almacen;
CREATE PROCEDURE huecos_ocupados_almacen(IN p_id_almacen INT,
                                         OUT ubicaciones_ocupadas INT)
BEGIN
SELECT COUNT(*)
INTO ubicaciones_ocupadas
FROM ubicaciones
WHERE id_almacen = p_id_almacen;
END &&

DELIMITER ;


CALL huecos_ocupados_almacen(1, @ubicaciones_ocupadas);
SELECT @ubicaciones_ocupadas;

-- ======================================================================================================================

#Añadir producto a la tabla productos:

DELIMITER $$

CREATE PROCEDURE agregar_producto(IN producto_id INT,IN fabricante VARCHAR(50), IN cantidad INT, IN empleado_id INT)
BEGIN
INSERT INTO productos (id, fabricante, cantidad, id_empleado)
VALUES (producto_id, fabricante, cantidad, empleado_id);
END$$

DELIMITER ;

CALL agregar_producto(6006, 'prueba', 50, 1001001);
CALL agregar_producto(6007, 'prueba2', 10, 2001001);

-- ======================================================================================================================

# insertar un producto en la tabla de ubicaciones:

DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_producto_en_ubicacion;
CREATE PROCEDURE insertar_producto_en_ubicacion(IN producto_id INT, IN almacen_id INT, IN fecha DATE)
BEGIN
INSERT INTO ubicaciones (id_producto, id_almacen, fecha)
VALUES (producto_id, almacen_id, fecha);
END$$

DELIMITER ;

-- al insertar productos aún no salta el trigger que he creado más adelante que automaticamente ubica correctamente en el almacén correspondiente dependiendo del número de inicio del id del producto

CALL insertar_producto_en_ubicacion(6006,5,'2024-05-21');


-- ======================================================================================================================


-- buscar la ubicacion de un producto por el id del producto:

DELIMITER $$
CREATE PROCEDURE ubicacion_por_producto(IN producto_id INT)
BEGIN
SELECT * FROM ubicaciones WHERE id_producto = producto_id;
END$$
DELIMITER ;

CALL ubicacion_por_producto(2001);

-- ======================================================================================================================

# ELIMINAR UN PRODUCTO A PARTIR DEL ID

DELIMITER $$
DROP PROCEDURE IF EXISTS eliminar_producto;
CREATE PROCEDURE eliminar_producto(IN producto_id INT)
BEGIN
DELETE FROM ubicaciones WHERE id_producto = producto_id;
DELETE FROM productos WHERE id = producto_id;
END$$
DELIMITER ;

# PARA PROBAR EL PROCEDIMIENTO A PARTIR DE UN EJEMPLO PRIMERO HACEMOS LA CONSULTAS EN LA TABLA PRODUCTOS Y UBCICACIONES Y DESPUÉS LLAMAMOS AL PROCEDIMIENTO Y VOLVEMOS A EJECUTAR LAS CONSULTAS PARA COMPROBAR QUE SE HAN ELIMINADO LOS PRODUCTOS:

SELECT * FROM productos WHERE id = 6006;
SELECT * FROM ubicaciones WHERE id_producto = 6006;

CALL eliminar_producto(6006);

-- ======================================================================================================================

# ACTUALIZAR LA CANTIDAD DE UN PRODUCTO POR SU ID

DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_cantidad_producto;
CREATE PROCEDURE actualizar_cantidad_producto(IN id_producto INT, IN nueva_cantidad INT)
BEGIN
UPDATE productos
SET cantidad = nueva_cantidad
WHERE id = id_producto;
END$$
DELIMITER ;

select cantidad
FROM productos
WHERE id = 1003;

CALL actualizar_cantidad_producto(1003, 220);

-- ======================================================================================================================

-- TRIGGERS

#trigger para que ubique el producto en el almacén correspondiente dependiendo de como empiece el codigo del producto por si se equivoca el empleado al ubicar el producto como pasaba antes de crear este trigger

DELIMITER $$
DROP TRIGGER IF EXISTS asignar_ubicacion_producto;
CREATE TRIGGER asignar_ubicacion_producto
    BEFORE INSERT ON ubicaciones
    FOR EACH ROW
BEGIN
    DECLARE almacen_id INT;

    SET almacen_id = SUBSTRING(NEW.id_producto, 1, 1);

    IF almacen_id != NEW.id_almacen THEN
        SET NEW.id_almacen = almacen_id;
END IF;
END $$;


DELIMITER ;
-- primero comprobamos que el producto no existe haciendo consultas en las tablas productos y ubicaciones
SELECT *
FROM productos
WHERE id = 6006;

SELECT *
FROM ubicaciones
WHERE id_producto = 6006;

-- ahora agregamos el producto usando el procedimiento apropiado:
CALL agregar_producto(6006, 'prueba', 50, 6001002);
-- por último insertamos el producto en un almacen erroneo (5) cuando debería ubicarse en el (6) y depues podemos comprobar usando las consultas anteriores como automaticamente lo ha agregado al almacén que corresponde (6):
CALL insertar_producto_en_ubicacion(6006, 1 , NOW());


-- ======================================================================================================================

#TRIGGER PARA QU LA FECHA EN QUE SE UBICA EL MATERIAL SIEMPRE SEA LA ACTUAL Y NO PUEDA SER MODIFICADA AL INGRESAR UN PRODUCTO

DELIMITER $$
CREATE TRIGGER fecha_ubicacion
    BEFORE INSERT ON ubicaciones
    FOR EACH ROW
BEGIN
    SET NEW.fecha = NOW();
END$$;

DELIMITER ;

-- agregamos un producto nuevo y lo insertamos en una ubicación con una fecha anterior a la actual, si ejecutamos la consulta siguiente para comprobar la ubicación del producto, la fecha cambia a la actual:

    CALL agregar_producto(6009, 'prueba2', 25, 6001002);
    CALL insertar_producto_en_ubicacion(6009, 6, '2020-05-10');

    SELECT *
    FROM ubicaciones
    WHERE id_producto = 6009;


    -- ======================================================================================================================


-- VISTAS INTERESANTES:



-- vista para saber el número de productos que tiene cada almacen

    CREATE VIEW numero_productos_por_almacen AS
    SELECT almacenes.id AS id_almacen, almacenes.ubicacion, SUM(productos.cantidad) AS total_productos
    FROM almacenes
             JOIN empleados
                  ON almacenes.id = empleados.id_almacen
             JOIN productos
                  ON empleados.id = productos.id_empleado
    GROUP BY almacenes.id, almacenes.ubicacion
    ORDER BY total_productos DESC;

-- vista productos ordenados por fecha de antiguedad

    CREATE VIEW productos_por_antiguedad AS
    SELECT productos.fabricante, productos.cantidad, ubicaciones.fecha
    FROM almacenes
             JOIN empleados ON almacenes.id = empleados.id_almacen
             JOIN productos ON empleados.id = productos.id_empleado
             JOIN ubicaciones ON productos.id = ubicaciones.id_producto
    GROUP BY productos.fabricante, productos.cantidad, ubicaciones.fecha
    ORDER BY ubicaciones.fecha;

-- vista empleados que más productos han movido:

    CREATE VIEW empleados_mas_movimientos AS
    SELECT empleados.id, empleados.categoria, empleados.puesto, SUM(productos.cantidad) AS total_productos
    FROM empleados
             JOIN productos ON empleados.id = productos.id_empleado
    GROUP BY empleados.id
    ORDER BY total_productos DESC;

-- inventario por fabricante

    CREATE VIEW inventario_por_fabricante AS
    SELECT fabricante, SUM(cantidad) AS total_cantidad
    FROM productos
    GROUP BY fabricante
    ORDER BY total_cantidad DESC;



-- prodcutos que tienen menos de 100 unidades:

    CREATE VIEW menos_100_unidades AS
    SELECT id, fabricante, cantidad
    FROM productos
    WHERE cantidad < 100
    ORDER BY cantidad ASC;