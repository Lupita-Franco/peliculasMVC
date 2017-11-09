/*Base de datos: */
drop database if exists peliculas;
create database if not exists peliculas;
use peliculas;


create table if not exists clientes (
   id_clientes smallint(3) not null auto_increment primary key,
    nombre varchar(30) not null,
    telefono varchar(30) not null,
    email varchar(20) not null);
    direccion varchar(20) not null);

/*Registro de personas: */
insert into clientes (nombre, telefono, email, direccion) values
('Rubi', '7711046582', 'rubi@gmail.com' ,'los olmos'),
('Marisol', '4457540123', 'marisol@gmail.com','la estrella'); 




create table if not exists peliculas (
    id_peliculas int(8) not null auto_increment primary key,
    nombre varchar(30) not null,
    formato varchar(50) not null,
    duracion smallint(30) not null,
    descripcion varchar(30) not null);


insert into peliculas (nombre, formato, duracion, descripcion)values
( 'Tres Metros Sobre el Cielo', 'BLUE RAY', '2:20', 'romantica'),
( 'Annabelle', 'DVD', '1:30 ', 'terror');


