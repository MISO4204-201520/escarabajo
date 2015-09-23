-- Database: escarabajo

-- DROP DATABASE escarabajo;

CREATE DATABASE escarabajo
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Colombia.1252'
       LC_CTYPE = 'Spanish_Colombia.1252'
       CONNECTION LIMIT = -1;



//------------------------tabla recorrido-----------------------------//
-- Table: recorrido

-- DROP TABLE recorrido;

CREATE TABLE recorrido
(
  id_recorrido integer NOT NULL,
  tipo integer NOT NULL,
  nombre character(250),
  CONSTRAINT recorrido_pkey PRIMARY KEY (id_recorrido)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE recorrido
  OWNER TO postgres;
COMMENT ON TABLE recorrido
  IS 'Tabla para almacenar los recorridos programados por los usuarios';
//------------------------------------------------------------------//