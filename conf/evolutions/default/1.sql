# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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
  id_ruta                   serial not null,
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
alter table linked_account add constraint fk_linked_account_user_1 foreign key (user_id) references users (id);
create index ix_linked_account_user_1 on linked_account (user_id);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_metri_2 foreign key (metrica_id_metrica) references metrica (id_metrica);
create index ix_metricas_x_recorridos_metri_2 on metricas_x_recorridos (metrica_id_metrica);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_usuar_3 foreign key (usuario_id) references users (id);
create index ix_metricas_x_recorridos_usuar_3 on metricas_x_recorridos (usuario_id);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_recor_4 foreign key (recorrido_id_recorrido) references recorrido (id_recorrido);
create index ix_metricas_x_recorridos_recor_4 on metricas_x_recorridos (recorrido_id_recorrido);
alter table ruta add constraint fk_ruta_recorrido_5 foreign key (recorrido_id_recorrido) references recorrido (id_recorrido);
create index ix_ruta_recorrido_5 on ruta (recorrido_id_recorrido);
alter table token_action add constraint fk_token_action_targetUser_6 foreign key (target_user_id) references users (id);
create index ix_token_action_targetUser_6 on token_action (target_user_id);



alter table users_security_role add constraint fk_users_security_role_users_01 foreign key (users_id) references users (id);

alter table users_security_role add constraint fk_users_security_role_securi_02 foreign key (security_role_id) references security_role (id);

alter table users_user_permission add constraint fk_users_user_permission_user_01 foreign key (users_id) references users (id);

alter table users_user_permission add constraint fk_users_user_permission_user_02 foreign key (user_permission_id) references user_permission (id);

# --- !Downs

drop table if exists linked_account cascade;

drop table if exists metrica cascade;

drop table if exists metricas_x_recorridos cascade;

drop table if exists recorrido cascade;

drop table if exists ruta cascade;

drop table if exists security_role cascade;

drop table if exists token_action cascade;

drop table if exists users cascade;

drop table if exists users_security_role cascade;

drop table if exists users_user_permission cascade;

drop table if exists user_permission cascade;

