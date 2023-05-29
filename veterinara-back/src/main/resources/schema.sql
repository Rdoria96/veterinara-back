create table if not exists propietario(
 nmid serial,
 tipo_documento varchar(30),
 ident_p varchar(20),
 nombre_p varchar(60),
 apellido_p varchar(60),
 nmid_ciudad_p int,
 telefono_p varchar(20),
 primary key(nmid)
);

create table if not exists ciudad(
 nmid serial,
 nombre_ciudad varchar(60),
 primary key(nmid)
);

create table if not exists paciente(
 nmid serial,
 nombre_paciente varchar(60),
 f_nacimiento date,
 nmid_especie int,
 raza varchar(80),
 f_registro date,
 nmid_propietario int,
 primary key(nmid)
);

create table if not exists especie(
 nmid serial,
 nombre_especie varchar(30),
 primary key(nmid)
);

---relacion paciente
alter table paciente add foreign key(nmid_propietario) references propietario(nmid);

---relacion paciente
alter table paciente add foreign key(nmid_especie) references especie(nmid);

--relacion propietario
alter table propietario add foreign key(nmid_ciudad_p) references ciudad(nmid);