create table event (id integer not null auto_increment, event_date_time datetime(6), event_name varchar(255), user_id integer not null, primary key (id)) engine=InnoDB
create table user (id integer not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
alter table event add constraint FKi8bsvlthqr8lngsyshiqsodak foreign key (user_id) references user (id)
create table event (id integer not null auto_increment, event_date_time datetime(6), event_name varchar(255), user_id integer not null, primary key (id)) engine=InnoDB
create table user (id integer not null auto_increment, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB
alter table event add constraint FKi8bsvlthqr8lngsyshiqsodak foreign key (user_id) references user (id)
