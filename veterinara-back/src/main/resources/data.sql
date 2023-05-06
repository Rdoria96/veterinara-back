insert into especie(nombre_especie)
values
  ('Perro'),
  ('Gato'),
  ('Ave'),
  ('Loro'),
  ('Tortuga'),
  ('Iguana'),
  ('Conejo');

insert into ciudad(nombre_ciudad)
values
  ('Medellin'),
  ('Monteria'),
  ('Cali'),
  ('Barranquilla'),
  ('Cartagena'),
  ('Bucaramanga'),
  ('Pereira'),
  ('Manizales');

insert into propietario(tipo_documento, ident_p, nombre_p, apellido_p, nmid_ciudad_p, telefono_p)
values
  ('Cedula ciudadania', '123456789', 'Juan', 'Perez', 1, '1234567'),
  ('Tarjeta de Identidad', '987654321', 'Maria', 'Gonzalez', 2, '2345678'),
  ('Cedula ciudadaniaa', '456789123', 'Pedro', 'Martinez', 3, '3456789'),
  ('Pasaporte', '11111111', 'Luisa', 'Hernandez', 1, '4567890'),
  ('Cedula ciudadania', '22222222', 'Ana', 'Ramirez', 4, '5678901'),
  ('Cedula ciudadania', '33333333', 'Carlos', 'Gomez', 5, '6789012'),
  ('Cedula ciudadania', '44444444', 'Laura', 'Sanchez', 6, '7890123'),
  ('Cedula ciudadania', '55555555', 'Jorge', 'Rojas', 1, '8901234'),
  ('Cedula ciudadania', '66666666', 'Camila', 'Alvarez', 7, '9012345'),
  ('Cedula ciudadania', '77777777', 'Santiago', 'Mendoza', 2, '0123456'),
  ('Tarjeta de Identidad', '88888888', 'Paula', 'Castro', 3, '6543210'),
  ('Cedula ciudadania', '99999999', 'Andres', 'Vargas', 4, '7654321');

INSERT INTO paciente(nombre_paciente, f_nacimiento, nmid_especie, raza, f_registro, nmid_propietario)
VALUES
  ('Luna', '2018-05-20', 1, 'Labrador', '2021-03-10', 1),
  ('Simón', '2020-02-01', 2, 'Siames', '2021-05-06', 2),
  ('Firulais', '2019-12-15', 1, 'Chihuahua', '2021-04-18', 3),
  ('Pelusa', '2017-06-25', 2, 'Persa', '2021-01-30', 4),
  ('Rocky', '2016-09-10', 1, 'Pitbull', '2021-02-15', 5),
  ('Michi', '2019-03-03', 2, 'Angora', '2021-05-01', 6),
  ('Boby', '2018-10-22', 1, 'Beagle', '2021-03-23', 7),
  ('Toby', '2020-08-08', 1, 'Golden Retriever', '2021-04-10', 8),
  ('Max', '2017-01-12', 1, 'Bulldog', '2021-02-28', 9),
  ('Tom', '2018-11-18', 2, 'Bengalí', '2021-03-15', 10),
  ('Nala', '2021-01-10', 1, 'Doberman', '2021-05-03', 1),
  ('Peluchín', '2020-12-02', 2, 'Sphynx', '2021-04-20', 2);
