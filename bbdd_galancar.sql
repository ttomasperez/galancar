-- Creación base de datos
create database galancar;

use galancar; 

-- Creación de tablas
-- Tabla usuario
CREATE TABLE usuario (
    dni_usuario VARCHAR(30) PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    contrasena varchar(50) NOT NULL,
    fecha_nacimiento DATE,
    provincia VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL,
    movil INT(9) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE localidad (
    id_localidad INT PRIMARY KEY NOT NULL,
    nombre_localidad VARCHAR(20) NOT NULL
);

CREATE TABLE viajes (
    id_viaje INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni_conductor VARCHAR(30) NOT NULL,
    id_origen INT NOT NULL,
    id_destino INT NOT NULL,
    plazas_disponibles INT(1) NOT NULL,
    FOREIGN KEY (dni_conductor)
        REFERENCES usuario (dni_usuario)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_origen)
        REFERENCES localidad (id_localidad)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_destino)
        REFERENCES localidad (id_localidad)
        ON DELETE CASCADE ON UPDATE CASCADE
);

 CREATE TABLE pasajero_viaje (
    id_viaje INT(11) NOT NULL,
    dni_pasajero VARCHAR(30) NOT NULL,
    PRIMARY KEY(id_viaje, dni_pasajero),
    FOREIGN KEY (id_viaje)
        REFERENCES viajes (id_viaje)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (dni_pasajero)
        REFERENCES usuario (dni_usuario)
        ON DELETE CASCADE ON UPDATE CASCADE
); 

insert into localidad values (1, 'Ciudad Real');
insert into localidad values (2, 'Puertollano');
insert into localidad values (3, 'Tomelloso');
insert into localidad values (4, 'Alcázar De San Juan');
insert into localidad values (5, 'Valdepeñas');
insert into localidad values (6, 'La Solana');
insert into localidad values (7, 'Membrilla');
insert into localidad values (8, 'San Carlos Del Valle');
insert into localidad values (9, 'Daimiel');
insert into localidad values (10, 'Miguelturra');
insert into localidad values (11, 'Herencia');
insert into localidad values (12, 'Alhambra');
insert into localidad values (13, 'Almagro');
insert into localidad values (14, 'Sotuélamos');
insert into localidad values (15, 'Malagon');
insert into localidad values (16, 'Pedro Muñoz');
insert into localidad values (17, 'Campo de Criptana');
insert into localidad values (18, 'Almadén');
insert into localidad values (19, 'Pozo De La Serna');
insert into localidad values (20, 'Argamasilla De Alba');
-- Triggers
CREATE DEFINER=`root`@`localhost` TRIGGER `pasajero_viaje_AFTER_INSERT` AFTER INSERT ON `pasajero_viaje` FOR EACH ROW BEGIN
	update viajes set plazas_disponibles = plazas_disponibles - 1 where id_viaje=new.id_viaje;
END

CREATE DEFINER=`root`@`localhost` TRIGGER `pasajero_viaje_AFTER_DELETE` AFTER DELETE ON `pasajero_viaje` FOR EACH ROW BEGIN
	update viajes set plazas_disponibles = plazas_disponibles + 1 where id_viaje=old.id_viaje;
END
