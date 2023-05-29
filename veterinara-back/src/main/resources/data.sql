INSERT INTO especie(nombre_especie)
SELECT 'Perro' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Perro');
INSERT INTO especie(nombre_especie)
SELECT 'Gato' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Gato');
INSERT INTO especie(nombre_especie)
SELECT 'Ave' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Ave');
INSERT INTO especie(nombre_especie)
SELECT 'Loro' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Loro');
INSERT INTO especie(nombre_especie)
SELECT 'Tortuga' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Tortuga');
INSERT INTO especie(nombre_especie)
SELECT 'Iguana' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Iguana');
INSERT INTO especie(nombre_especie)
SELECT 'Conejo' WHERE NOT EXISTS (SELECT 1 FROM especie WHERE nombre_especie = 'Conejo');


INSERT INTO ciudad(nombre_ciudad)
SELECT 'Medellin' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Medellin');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Monteria' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Monteria');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Cali' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Cali');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Barranquilla' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Barranquilla');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Cartagena' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Cartagena');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Bucaramanga' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Bucaramanga');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Pereira' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Pereira');
INSERT INTO ciudad(nombre_ciudad)
SELECT 'Manizales' WHERE NOT EXISTS (SELECT 1 FROM ciudad WHERE nombre_ciudad = 'Manizales');


INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '123456789', 'Juan', 'Perez', 1, '1234567' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '123456789');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Tarjeta de Identidad', '987654321', 'Maria', 'Gonzalez', 2, '2345678' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '987654321');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadaniaa', '456789123', 'Pedro', 'Martinez', 3, '3456789' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '456789123');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Pasaporte', '11111111', 'Luisa', 'Hernandez', 7, '3014552147' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '11111111');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '22222222', 'Ana', 'Ramirez', 4, '56789018' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '22222222');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '33333333', 'Carlos', 'Gomez', 5, '678901' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '33333333');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '44444444', 'Laura', 'Doria', 6, '7890123' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '44444444');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '55555555', 'Jorge', 'Rojas', 1, '8901234' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '55555555');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '66666666', 'Camila', 'Alvarez', 7, '9012345' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '66666666');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '77777777', 'Santiago', 'Mendoza', 2, '0123456' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '77777777');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Tarjeta de Identidad', '88888888', 'Paula', 'Castro', 3, '6543210' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '88888888');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '99999999', 'Andres', 'Vargas', 4, '7654321' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '99999999');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '1067945746', 'Richard', 'Montalvo', 1, '3005801454' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '1067945746');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '1067945746', 'David', 'Doria', 1, '7890535' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '1067945746');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'cc', '2334534', 'sdffsdfd', 'sfdsf', 2, '3535' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '2334534');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '1067945746', 'Richard', 'Doria', 2, '3188229304' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '1067945746');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '50928135', 'Nadia', 'Montalvo', 2, '3126721772' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '50928135');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '1067945746', 'David', 'Montalvo', 2, '3014462295' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '1067945746');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'prueba', '10679345', 'Prueba', 'Prueba', 2, '3014462295' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '10679345');
INSERT INTO propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
SELECT 'Cedula ciudadania', '1067945746', 'Richard', 'Montalvo', 1, '3005801454' WHERE NOT EXISTS (SELECT 1 FROM propietario WHERE ident_p = '1067945746');



INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Guardian', '2018-05-19', 1, 'Labrador', '2023-05-05', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Guardian');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Simón', '2020-02-01', 2, 'Siames', '2021-05-06', 2 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Simón');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Firulais', '2019-12-15', 1, 'Chihuahua', '2021-04-18', 3 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Firulais');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Pelusa', '2017-06-25', 2, 'Persa', '2021-01-30', 4 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Pelusa');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Rocky', '2016-09-10', 1, 'Pitbull', '2021-02-15', 5 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Rocky');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Michi', '2019-03-03', 2, 'Angora', '2021-05-01', 6 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Michi');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Boby', '2018-10-22', 1, 'Beagle', '2021-03-23', 7 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Boby');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Toby', '2020-08-08', 1, 'Golden Retriever', '2021-04-10', 8 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Toby');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Max', '2017-01-12', 1, 'Bulldog', '2021-02-28', 9 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Max');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Tom', '2018-11-18', 2, 'Bengalí', '2021-03-15', 10 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Tom');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Nala', '2021-01-10', 1, 'Doberman', '2021-05-03', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Nala');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Peluchín', '2020-12-02', 2, 'Sphynx', '2021-04-20', 2 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Peluchín');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Guardian', '2018-05-18', 1, 'Labrador', '2023-05-04', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Guardian');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Gun', '2018-05-19', 1, 'Labrador', '2023-05-06', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Gun');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Susi', '2018-05-19', 1, 'Labrador', '2023-05-06', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Susi');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Suzi', '2018-05-19', 1, 'Labrador', '2023-05-06', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Suzi');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Pelusa', '2018-05-19', 1, 'Labrador', '2021-03-09', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Pelusa');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Nose', '2022-05-19', 1, 'Labrador', '2023-05-09', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Nose');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Monchi', '2018-02-12', 2, 'Bengali', '2018-02-12', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Monchi');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Cual', '2016-02-02', 1, 'Labrador', '2023-05-09', 1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Cual');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'yytgt', '2023-05-10', 1, 'yt', '2023-05-10', 23 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'yytgt');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Firulais', '2022-01-10', 1, 'Labrador', '2023-05-10', 23 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Firulais');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Prueba', '2023-05-10', 1, 'Pitbull', '2023-05-11', 23 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Prueba');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'Nose', '2017-06-11', 5, 'Labrador', '2023-05-16',24 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'Nose');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'as','2023-05-04', 1,'Labrador','2023-05-16',24 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'as');
INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
SELECT 'dfdsf','2023-05-23',2,'Pitbull','2023-05-23',1 WHERE NOT EXISTS (SELECT 1 FROM paciente WHERE nombre_paciente = 'dfdsf');
