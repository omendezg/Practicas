CREATE TABLE clientes (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido_paterno VARCHAR(255) NOT NULL,
  apellido_materno VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  genero VARCHAR(255) NOT NULL,
  edad Integer NOT NULL
);
