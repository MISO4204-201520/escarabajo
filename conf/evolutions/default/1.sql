# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table estacion (
  id_estacion               bigserial not null,
  nombre                    varchar(255) not null,
  lugar                     varchar(255),
  latitud                   float,
  longitud                  float,
  tarifa_x_h                integer,
  hora_inicio_atencion      timestamp,
  hora_fin_atencion         timestamp,
  para_alquiler             boolean,
  para_entrega              boolean,
  indicativo_telefono_fijo  varchar(255),
  telefono_fijo             varchar(255),
  celular                   varchar(255),
  dia_frecuente             varchar(255),
  sitio_de_alquiler_id_sitio bigint,
  constraint pk_estacion primary key (id_estacion))
;

create table linked_account (
  id                        bigserial not null,
  user_id                   bigint,
  provider_user_id          varchar(255),
  provider_key              varchar(255),
  constraint pk_linked_account primary key (id))
;

create table metrica (
  id_metrica                bigserial not null,
  nombre_metrica            varchar(255) not null,
  unidad_medida             varchar(255) not null,
  constraint pk_metrica primary key (id_metrica))
;

create table metricas_x_recorridos (
  id_metrica_recorrido      bigserial not null,
  metrica_id_metrica        bigint,
  usuario_id                bigint,
  recorrido_id_recorrido    bigint,
  fecha                     date not null,
  valor_metrica             float not null,
  constraint pk_metricas_x_recorridos primary key (id_metrica_recorrido))
;

create table recorrido (
  id_recorrido              bigserial not null,
  tipo                      integer not null,
  nombre                    varchar(255) not null,
  descripcion               varchar(255),
  hora_frecuente            varchar(255),
  dia_frecuente             varchar(255),
  constraint pk_recorrido primary key (id_recorrido))
;

create table ruta (
  id_ruta                   bigserial not null,
  recorrido_id_recorrido    bigint,
  fecha_inicio_ruta         timestamp,
  fecha_fin_ruta            timestamp,
  latitud_inicio            float,
  longitud_incio            float,
  latitud_fin               float,
  longitud_fin              float,
  lugar_inicio              varchar(255),
  lugar_fin                 varchar(255),
  constraint pk_ruta primary key (id_ruta))
;

create table security_role (
  id                        bigserial not null,
  role_name                 varchar(255),
  constraint pk_security_role primary key (id))
;

create table sitio_de_alquiler (
  id_sitio                  bigserial not null,
  nombre                    varchar(255) not null,
  indicativo_telefono_fijo  varchar(255),
  telefono_fijo             varchar(255),
  email                     varchar(255),
  celular                   varchar(255),
  usuario_id                bigint,
  constraint uq_sitio_de_alquiler_nombre unique (nombre),
  constraint pk_sitio_de_alquiler primary key (id_sitio))
;

create table token_action (
  id                        bigserial not null,
  token                     varchar(255),
  target_user_id            bigint,
  type                      varchar(2),
  created                   timestamp,
  expires                   timestamp,
  constraint ck_token_action_type check (type in ('PR','EV')),
  constraint uq_token_action_token unique (token),
  constraint pk_token_action primary key (id))
;

create table users (
  id                        bigserial not null,
  email                     varchar(255),
  name                      varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  last_login                timestamp,
  active                    boolean,
  email_validated           boolean,
  constraint pk_users primary key (id))
;

create table user_permission (
  id                        bigserial not null,
  value                     varchar(255),
  constraint pk_user_permission primary key (id))
;

create table usuario_x_recorrido (
  id_usuario_recorrido      bigserial not null,
  usuario_id                bigint,
  recorrido_id_recorrido    bigint,
  ind_confirmado            boolean not null,
  ind_administrador         boolean not null,
  constraint pk_usuario_x_recorrido primary key (id_usuario_recorrido))
;


create table users_security_role (
  users_id                       bigint not null,
  security_role_id               bigint not null,
  constraint pk_users_security_role primary key (users_id, security_role_id))
;

create table users_user_permission (
  users_id                       bigint not null,
  user_permission_id             bigint not null,
  constraint pk_users_user_permission primary key (users_id, user_permission_id))
;
alter table estacion add constraint fk_estacion_sitioDeAlquiler_1 foreign key (sitio_de_alquiler_id_sitio) references sitio_de_alquiler (id_sitio);
create index ix_estacion_sitioDeAlquiler_1 on estacion (sitio_de_alquiler_id_sitio);
alter table linked_account add constraint fk_linked_account_user_2 foreign key (user_id) references users (id);
create index ix_linked_account_user_2 on linked_account (user_id);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_metri_3 foreign key (metrica_id_metrica) references metrica (id_metrica);
create index ix_metricas_x_recorridos_metri_3 on metricas_x_recorridos (metrica_id_metrica);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_usuar_4 foreign key (usuario_id) references users (id);
create index ix_metricas_x_recorridos_usuar_4 on metricas_x_recorridos (usuario_id);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_recor_5 foreign key (recorrido_id_recorrido) references recorrido (id_recorrido);
create index ix_metricas_x_recorridos_recor_5 on metricas_x_recorridos (recorrido_id_recorrido);
alter table ruta add constraint fk_ruta_recorrido_6 foreign key (recorrido_id_recorrido) references recorrido (id_recorrido);
create index ix_ruta_recorrido_6 on ruta (recorrido_id_recorrido);
alter table sitio_de_alquiler add constraint fk_sitio_de_alquiler_usuario_7 foreign key (usuario_id) references users (id);
create index ix_sitio_de_alquiler_usuario_7 on sitio_de_alquiler (usuario_id);
alter table token_action add constraint fk_token_action_targetUser_8 foreign key (target_user_id) references users (id);
create index ix_token_action_targetUser_8 on token_action (target_user_id);
alter table usuario_x_recorrido add constraint fk_usuario_x_recorrido_usuario_9 foreign key (usuario_id) references users (id);
create index ix_usuario_x_recorrido_usuario_9 on usuario_x_recorrido (usuario_id);
alter table usuario_x_recorrido add constraint fk_usuario_x_recorrido_recorr_10 foreign key (recorrido_id_recorrido) references recorrido (id_recorrido);
create index ix_usuario_x_recorrido_recorr_10 on usuario_x_recorrido (recorrido_id_recorrido);



alter table users_security_role add constraint fk_users_security_role_users_01 foreign key (users_id) references users (id);

alter table users_security_role add constraint fk_users_security_role_securi_02 foreign key (security_role_id) references security_role (id);

alter table users_user_permission add constraint fk_users_user_permission_user_01 foreign key (users_id) references users (id);

alter table users_user_permission add constraint fk_users_user_permission_user_02 foreign key (user_permission_id) references user_permission (id);

# --- !Downs

drop table if exists estacion cascade;

drop table if exists linked_account cascade;

drop table if exists metrica cascade;

drop table if exists metricas_x_recorridos cascade;

drop table if exists recorrido cascade;

drop table if exists ruta cascade;

drop table if exists security_role cascade;

drop table if exists sitio_de_alquiler cascade;

drop table if exists token_action cascade;

drop table if exists users cascade;

drop table if exists users_security_role cascade;

drop table if exists users_user_permission cascade;

drop table if exists user_permission cascade;

drop table if exists usuario_x_recorrido cascade;

