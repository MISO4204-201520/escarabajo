# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table metrica (
  id_metrica                bigserial not null,
  nombre_metrica            varchar(255) not null,
  unidad_medida             varchar(255) not null,
  constraint pk_metrica primary key (id_metrica))
;

create table metricas_x_recorridos (
  id_metrica_recorrido      bigserial not null,
  metrica_id_metrica        bigint,
  id_usuario                bigint,
  username                  varchar(255),
  fecha                     date not null,
  valor_metrica             float not null,
  constraint pk_metricas_x_recorridos primary key (id_metrica_recorrido))
;

create table usuario (
  id_usuario                bigint,
  username                  varchar(255),
  nombre                    varchar(255) not null,
  email                     varchar(255) not null,
  constraint pk_usuario primary key (id_usuario, username))
;

alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_metri_1 foreign key (metrica_id_metrica) references metrica (id_metrica);
create index ix_metricas_x_recorridos_metri_1 on metricas_x_recorridos (metrica_id_metrica);
alter table metricas_x_recorridos add constraint fk_metricas_x_recorridos_usuar_2 foreign key (id_usuario,username) references usuario (id_usuario,username);
create index ix_metricas_x_recorridos_usuar_2 on metricas_x_recorridos (id_usuario,username);


# --- !Downs

drop table if exists metrica cascade;

drop table if exists metricas_x_recorridos cascade;

drop table if exists usuario cascade;

