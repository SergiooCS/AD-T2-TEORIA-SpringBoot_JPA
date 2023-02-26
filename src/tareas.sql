drop database if exists tareas;
Create database tareas;
use tareas;

create table Usuario (
	NIF char(9) primary key,
    nombre varchar(30),
    apellidos varchar(50),
    pw varchar(200),
    Activo tinyint
);

insert into usuario values ('12345678A', 'Jorge', 'Santillán', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);
insert into usuario values ('98765432A', 'Mario', 'Luquero', '$2a$10$zORV2NUUb3lxZCMM9jzReuWjXNi0YibyiD7iCKVCZld4eu.rhM6Xe', 1);
insert into usuario values ('11111111A', 'Antonio', 'Heras', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);
insert into usuario values ('22222222A', 'Alberto', 'Martínez', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);
insert into usuario values ('33333333A', 'Laura', 'Gil', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);
insert into usuario values ('44444444A', 'Sergio', 'Bordado', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);
insert into usuario values ('55555555A', 'Victor', 'Soto', '$2a$10$nZNPddXNkhJUQhCQJ1iy8OdMibW7V8YNSwUDyPqc.oS9Woj89J0.a', 1);


CREATE TABLE ROLES (
	id int auto_increment primary key,
	NIF char(9),
	foreign key (nif) references usuario(nif),
	ROL varchar(50) NOT NULL
);

insert into roles (nif, rol) values ('98765432A', 'ADMINISTRADOR');
insert into roles (nif, rol) values ('12345678A', 'USUARIO');
insert into roles (nif, rol) values ('11111111A', 'USUARIO');
insert into roles (nif, rol) values ('22222222A', 'USUARIO');
insert into roles (nif, rol) values ('44444444A', 'USUARIO');
insert into roles (nif, rol) values ('55555555A', 'USUARIO');
insert into roles (nif, rol) values ('33333333A', 'USUARIO');


  create table tarea (
	id int primary key auto_increment,
    nombre varchar(200),
    descripcion varchar(1000),
    estado tinyint,
	NIF char(9),
    foreign key (nif) references usuario(nif)
  );


INSERT INTO `tareas`.`tarea` ( `nombre`, `descripcion`, `estado`, `NIF`) VALUES ('Comprar una camisa', 'Que la que tengo me queda pequeña', '1', '12345678A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Estudiar 3 carreras', 'Soy muy inteligente', '2', '98765432A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Hacer la compra', 'Faltan huevos y miel', '2', '11111111A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Hacer una tarta', 'Es el cumple de mi madre', '2', '22222222A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Ir al gimnasio', 'Hay que ponerse fuerte', '2', '33333333A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Comprar un movil', 'Me gusta el iPhone 58', '1', '44444444A');
INSERT INTO `tareas`.`tarea` (`id`, `nombre`, `descripcion`, `estado`, `NIF`) VALUES (null, 'Aprobar el hito', 'Por favor es muy importante', '1', '55555555A');