/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2017/7/6 11:44:28                            */
/*==============================================================*/


alter table alarm
   drop constraint FK_ALARM_RELATIONS_BAYONET;

alter table alarm
   drop constraint FK_ALARM_RELATIONS_ROAD;

alter table bayonet
   drop constraint FK_BAYONET_RELATIONS_POINT;

alter table control
   drop constraint FK_CONTROL_RELATIONS_BAYONET;

alter table dealalarm
   drop constraint FK_DEALALAR_RELATIONS_ALARM;

alter table pass_car
   drop constraint FK_PASS_CAR_RELATIONS_BAYONET;

alter table pass_car
   drop constraint FK_PASS_CAR_RELATIONS_ROAD;

alter table point
   drop constraint FK_POINT_RELATIONS_ROAD;

alter table users
   drop constraint FK_USERS_RELATIONS_DEPARTME;

drop index Relationship_8_FK;

drop index Relationship_7_FK;

drop table alarm cascade constraints;

drop index Relationship_1_FK;

drop table bayonet cascade constraints;

drop table black_list cascade constraints;

drop index Relationship_6_FK;

drop table control cascade constraints;

drop index Relationship_9_FK;

drop table dealalarm cascade constraints;

drop table department cascade constraints;

drop index Relationship_4_FK;

drop index Relationship_3_FK;

drop table pass_car cascade constraints;

drop index Relationship_2_FK;

drop table point cascade constraints;

drop table road cascade constraints;

drop table role cascade constraints;

drop index Relationship_5_FK;

drop table users cascade constraints;

/*==============================================================*/
/* Table: alarm                                                 */
/*==============================================================*/
create table alarm 
(
   alarm_id             INTEGER              not null,
   bayonet_id           INTEGER,
   road_id              INTEGER,
   car_id               VARCHAR2(32)         not null,
   collection_date      DATE                 not null,
   state                INTEGER              not null
      constraint CKC_STATE_ALARM check (state in (0,1)),
   speed                VARCHAR2(32)         not null,
   picpath              VARCHAR2(400)        not null,
   del                  INTEGER              not null
      constraint CKC_DEL_ALARM check (del in (0,1)),
   direction            VARCHAR2(1)          not null
      constraint CKC_DIRECTION_ALARM check (direction in ('N','S','E','W')),
   constraint PK_ALARM primary key (alarm_id)
);

/*==============================================================*/
/* Index: Relationship_7_FK                                     */
/*==============================================================*/
create index Relationship_7_FK on alarm (
   bayonet_id ASC
);

/*==============================================================*/
/* Index: Relationship_8_FK                                     */
/*==============================================================*/
create index Relationship_8_FK on alarm (
   road_id ASC
);

/*==============================================================*/
/* Table: bayonet                                               */
/*==============================================================*/
create table bayonet 
(
   bayonet_id           INTEGER              not null,
   point_id             INTEGER,
   buy_name             VARCHAR2(32)         not null,
   install_date         DATE                 not null,
   state                INTEGER              not null
      constraint CKC_STATE_BAYONET check (state in (0,1,2)),
   del                  INTEGER              not null
      constraint CKC_DEL_BAYONET check (del in (0,1)),
   constraint PK_BAYONET primary key (bayonet_id)
);

/*==============================================================*/
/* Index: Relationship_1_FK                                     */
/*==============================================================*/
create index Relationship_1_FK on bayonet (
   point_id ASC
);

/*==============================================================*/
/* Table: black_list                                            */
/*==============================================================*/
create table black_list 
(
   black_id             INTEGER              not null,
   car_type             VARCHAR2(32)         not null,
   car_id               VARCHAR2(32)         not null,
   reason               VARCHAR2(400)        not null,
   request_id           INTEGER              not null,
   examine_id           INTEGER,
   control_id           INTEGER,
   comments             VARCHAR2(400),
   state                INTEGER              not null
      constraint CKC_STATE_BLACK_LI check (state in (-1,0,1,2,3)),
   del                  INTEGER              not null
      constraint CKC_DEL_BLACK_LI check (del in (0,1)),
   constraint PK_BLACK_LIST primary key (black_id)
);

/*==============================================================*/
/* Table: control                                               */
/*==============================================================*/
create table control 
(
   control_id           INTEGER              not null,
   bayonet_id           INTEGER,
   car_id               VARCHAR2(32)         not null,
   car_type             VARCHAR2(32)         not null,
   control_date         DATE                 not null,
   del                  INTEGER              not null
      constraint CKC_DEL_CONTROL check (del in (0,1)),
   constraint PK_CONTROL primary key (control_id)
);

/*==============================================================*/
/* Index: Relationship_6_FK                                     */
/*==============================================================*/
create index Relationship_6_FK on control (
   bayonet_id ASC
);

/*==============================================================*/
/* Table: dealalarm                                             */
/*==============================================================*/
create table dealalarm 
(
   iden_state           INTEGER              not null,
   iden_police          VARCHAR2(32)         not null,
   tel                  VARCHAR2(32)         not null,
   iden_depart          VARCHAR2(32)         not null,
   iden_time            DATE                 not null,
   remark               VARCHAR2(400)        not null,
   deal_state           INTEGER              not null,
   unstop_reason        VARCHAR2(400)        not null,
   stop                 INTEGER              not null,
   del                  INTEGER              not null
      constraint CKC_DEL_DEALALAR check (del in (0,1)),
   deal_id              INTEGER              not null,
   alarm_id             INTEGER,
   constraint PK_DEALALARM primary key (deal_id)
);

/*==============================================================*/
/* Index: Relationship_9_FK                                     */
/*==============================================================*/
create index Relationship_9_FK on dealalarm (
   alarm_id ASC
);

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department 
(
   depart_id            INTEGER              not null,
   depart_type          INTEGER              not null,
   depart_name          VARCHAR2(32)         not null,
   depart_level         INTEGER              not null,
   depart_agent         VARCHAR2(32)         not null,
   depart_tel           VARCHAR2(32)         not null,
   depart_desc          VARCHAR2(400)        not null,
   depart_code          VARCHAR2(32)         not null,
   shortname            VARCHAR2(32)         not null,
   depart_parent        INTEGER              not null,
   del                  INTEGER             
      constraint CKC_DEL_DEPARTME check (del is null or (del in (0,1))),
   constraint PK_DEPARTMENT primary key (depart_id)
);

/*==============================================================*/
/* Table: pass_car                                              */
/*==============================================================*/
create table pass_car 
(
   pass_id              INTEGER              not null,
   road_id              INTEGER,
   bayonet_id           INTEGER,
   car_id               VARCHAR2(32)         not null,
   collection_date      DATE                 not null,
   speed                VARCHAR2(32)         not null
      constraint CKC_SPEED_PASS_CAR check (speed >= '0'),
   picpath              VARCHAR2(400)        not null,
   del                  INTEGER,
   direction            VARCHAR2(1)         
      constraint CKC_DIRECTION_PASS_CAR check (direction is null or (direction in ('N','S','W','E'))),
   constraint PK_PASS_CAR primary key (pass_id)
);

/*==============================================================*/
/* Index: Relationship_3_FK                                     */
/*==============================================================*/
create index Relationship_3_FK on pass_car (
   bayonet_id ASC
);

/*==============================================================*/
/* Index: Relationship_4_FK                                     */
/*==============================================================*/
create index Relationship_4_FK on pass_car (
   road_id ASC
);

/*==============================================================*/
/* Table: point                                                 */
/*==============================================================*/
create table point 
(
   point_id             INTEGER              not null,
   road_id              INTEGER,
   longitude            VARCHAR2(32)         not null,
   latitude             VARCHAR2(32)         not null,
   bayonet_num          INTEGER              not null,
   direction            CHAR(1)              not null
      constraint CKC_DIRECTION_POINT check (direction in ('N','S','W','E')),
   point_name           VARCHAR2(32)         not null,
   state                INTEGER              not null
      constraint CKC_STATE_POINT check (state in (0,1,2)),
   del                  INTEGER              not null
      constraint CKC_DEL_POINT check (del in (0,1)),
   constraint PK_POINT primary key (point_id)
);

/*==============================================================*/
/* Index: Relationship_2_FK                                     */
/*==============================================================*/
create index Relationship_2_FK on point (
   road_id ASC
);

/*==============================================================*/
/* Table: road                                                  */
/*==============================================================*/
create table road 
(
   road_id              INTEGER              not null,
   road_name            VARCHAR2(32)         not null,
   del                  INTEGER              default 0 not null
      constraint CKC_DEL_ROAD check (del in (0,1)),
   constraint PK_ROAD primary key (road_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role 
(
   role_id              INTEGER              not null,
   role_name            VARCHAR2(32)         not null,
   menu_name            VARCHAR2(100)        not null,
   menu_id              VARCHAR2(200)        not null,
   role_desc            VARCHAR2(400)        not null,
   constraint PK_ROLE primary key (role_id)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users 
(
   police_id            INTEGER              not null,
   depart_id            INTEGER,
   password             VARCHAR2(32)         not null,
   police_name          VARCHAR2(32)         not null,
   type                 VARCHAR2(32)         not null,
   sex                  VARCHAR2(2)          not null
      constraint CKC_SEX_USERS check (sex in ('F','M')),
   tel                  VARCHAR2(32)         not null,
   email                VARCHAR2(32)         not null,
   state                INTEGER              not null
      constraint CKC_STATE_USERS check (state in (0,1)),
   remark               VARCHAR2(400)        not null,
   del                  INTEGER              not null
      constraint CKC_DEL_USERS check (del in (0,1)),
   constraint PK_USERS primary key (police_id)
);

/*==============================================================*/
/* Index: Relationship_5_FK                                     */
/*==============================================================*/
create index Relationship_5_FK on users (
   depart_id ASC
);

alter table alarm
   add constraint FK_ALARM_RELATIONS_BAYONET foreign key (bayonet_id)
      references bayonet (bayonet_id);

alter table alarm
   add constraint FK_ALARM_RELATIONS_ROAD foreign key (road_id)
      references road (road_id);

alter table bayonet
   add constraint FK_BAYONET_RELATIONS_POINT foreign key (point_id)
      references point (point_id);

alter table control
   add constraint FK_CONTROL_RELATIONS_BAYONET foreign key (bayonet_id)
      references bayonet (bayonet_id);

alter table dealalarm
   add constraint FK_DEALALAR_RELATIONS_ALARM foreign key (alarm_id)
      references alarm (alarm_id);

alter table pass_car
   add constraint FK_PASS_CAR_RELATIONS_BAYONET foreign key (bayonet_id)
      references bayonet (bayonet_id);

alter table pass_car
   add constraint FK_PASS_CAR_RELATIONS_ROAD foreign key (road_id)
      references road (road_id);

alter table point
   add constraint FK_POINT_RELATIONS_ROAD foreign key (road_id)
      references road (road_id);

alter table users
   add constraint FK_USERS_RELATIONS_DEPARTME foreign key (depart_id)
      references department (depart_id);

create or replace trigger d_trigger
   after insert on bayonet for each row
   begin
  update point set bayonet_num = bayonet_num + 1 where point_id = :new.point_id;
   end;
/
create or replace trigger a_trigger
   after delete on bayonet for each row
   begin
  update point set bayonet_num = bayonet_num - 1 where point_id = :old.point_id;
   end;
/