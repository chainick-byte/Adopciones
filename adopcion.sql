

-- secuencia para id de propietario equivalente a serial en mysql 
 Create sequence sec_adoptante
start with 1
increment by 1
minvalue 1
maxvalue 10000;
/
-- creo objeto propietario a partir del cual creare la tabla propietario
CREATE TYPE t_adoptante  AS OBJECT
(id_adoptante NUMBER,
nombre VARCHAR2(60),
apellido_1 VARCHAR2(60),
APELLIDO_2 VARCHAR2(60),
direccion VARCHAR2(256),
ciudad VARCHAR2(60),
comunidad_autonoma VARCHAR2(60),
codigo_postal NUMBER(11)
);
/
-- creo tabla propietario
CREATE TABLE adoptante OF t_adoptante;
/
-- creo secuencia para id del perro 
 Create sequence sec_perro
start with 1
increment by 1
minvalue 1
maxvalue 10000;
/

-- creo objeto de tipo perro con los atributos correspondientes
CREATE TYPE t_perro AS OBJECT 
(id_perro NUMBER,
nombre VARCHAR2(60),
raza VARCHAR2(60),
fecha_nacimiento NUMBER(4),
direccion_perrera VARCHAR2(256)
);
/
-- creo tabla perro
CREATE TABLE perro OF t_perro;
/
-- creo secuencia para id de adopcion
 Create sequence sec_adopcion
start with 1
increment by 1
minvalue 1
maxvalue 10000;

-- creo objeto de tipo adopcion que se relacionara con objetos anteriores 

CREATE TYPE t_adopcion AS OBJECT 
(id_adopcion NUMBER,
perro REF t_perro,
adoptante REF t_adoptante,
fecha DATE
);
/
CREATE TABLE adopcion OF t_adopcion;
/
-- inserto propietario
insert into adoptante values(sec_adoptante.nextval,'rocio esperanza','soriano','gomez', 'calle imaginaria 1 portal 3, 2ºb', 'madrid','Comunidad de madrid',28067);
-- inserto perro 
insert into perro values(sec_perro.nextval, 'perrito', 'chuchus primitivus vulgaris', 2015,'perrera municipal de mostoles');
--inserto adopcion para perro p conid 41 y adopnte a con id 41
insert into adopcion values (sec_adopcion.nextval, (SELECT REF(p)from perro p WHERE p.id_perro=41),(SELECT REF(a)FROM adoptante a WHERE a.id_adoptante=41),to_date('28-02-2020','DD-MM-YYYY'));

/
select a.id_adopcion, a.adoptante.nombre, a.adoptante.apellido_1,a.adoptante.apellido_2, a.perro.nombre from adopcion a;
/
select *from perro p;
/
select *from adoptante;
/
