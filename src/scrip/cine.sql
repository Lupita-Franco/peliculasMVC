/*Base de datos: */
drop database if exists cine;
create database if not exists cine;
use cine;


create table  clientes (
   id_cliente int(3) not null auto_increment primary key,
    nombre varchar(30) not null,
    telefono varchar(30) not null,
    email varchar(20) not null,
    direccion varchar(30) not null);

/*Registro de clientes: */
insert into clientes (nombre, telefono, email, direccion) values
('Rubi', '7711046582', 'rubi@gmail.com' ,'olmos'),
('Marisol', '4457540123', 'marisol@gmail.com','estrella'); 




create table if not exists peliculas (
    id_pelicula int(8) not null auto_increment primary key,
    nombre varchar(30) not null,
    formato varchar(50) not null,
    duracion varchar(30) not null,
    descripcion varchar(30) not null);


insert into peliculas (nombre, formato, duracion, descripcion)values
( 'Tres Metros Sobre el Cielo', 'BLUE RAY', '2:20', 'romantica'),
( 'Annabelle', 'DVD', '1:30 ', 'terror');



create table if not exists rentas (
    id_renta int(8) not null auto_increment primary key,
    id_cliente int(3) not null,
    id_pelicula int(8) not null,
    formato varchar(30) not null,
    costo_dia varchar(50) not null,
    dias varchar(30) not null,
    renta_total varchar(30) not null),
    foreign key(id_cliente) REFERENCES clientes(id_cliente),
    foreign key(id_pelicula) REFERENCES peliculas(id_pelicula));





insert into rentas (id_clientes, id_peliculas, formato, costo_dia,dias,renta_total)values
('1','5', '2', 'BLUE RAY', '15', '2', '30'),
('2','10', '5', 'DVD', '10', '2', '20');


