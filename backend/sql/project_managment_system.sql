    drop database if exists netcracker;

create database netcracker;

use netcracker;

create table role(
    id int auto_increment not null,
    role varchar(15) not null,
    primary key (id)
)ENGINE = InnoDB;

create table project(
    id int auto_increment not null ,
    primary key (id),
    name varchar(50) not null unique,
    code char(4) not null unique ,
    summary text not null
)ENGINE = InnoDB;

create table priority(
    id int auto_increment not null ,
    primary key (id),
    priority varchar(15) not null unique
)ENGINE = InnoDB;

create table status(
    id int auto_increment not null ,
    primary key (id),
    status varchar(15) not null unique
)ENGINE = InnoDB;

create table user(
    id int auto_increment not null ,
    primary key (id),
    email varchar(50) not null unique ,
    first_name varchar(50) not null ,
    second_name varchar(50) not null ,
    password varchar(255) not null ,
    role_id int not null ,
    foreign key (role_id)
        references role(id)
)ENGINE = InnoDB;

create table task(
    id int auto_increment not null ,
    primary key (id),
    created_date date not null,
    description text not null,
    due_date date not null,
    resolved_date date,
    closed_date date,
    estimation int not null,
    name varchar(50) not null unique ,
    ticket_code varchar(10),
    update_date date not null,
    status_id int not null,
    assignee int not null,
    reporter int,
    priority_id int not null,
    project_id int not null,
    foreign key (project_id) references project(id),
    foreign key (status_id) references status(id),
    foreign key (assignee) references user(id),
    foreign key (reporter) references user(id),
    foreign key (priority_id) references priority(id)
)ENGINE = InnoDB;

create trigger insert_trigger
    before insert on task
    for each row
    set new.ticket_code = concat((select code from project where id = new.project_id),'-', new.id),
    new.created_date = date(now()), new.update_date = date(now());

create trigger update_date
    before update on task
    for each row
    set new.update_date = date(now());


create table comment(
  id int auto_increment not null ,
  comment_value text not null,
  update_date date not null,
  task_id int not null,
  user_id int not null,
  primary key (id),
  foreign key (task_id) references task(id),
  foreign key (user_id) references user(id)
)ENGINE = InnoDB;

insert into role (role) values ('admin');
insert into role (role) values ('project manager');
insert into role (role) values ('developer');
insert into role (role) values ('tester');

insert into status (status) values ('open');
insert into status (status) values ('in progress');
insert into status (status) values ('ready for test');
insert into status (status) values ('closed');

insert into priority (priority) values ('blocker');
insert into priority (priority) values ('critical');
insert into priority (priority) values ('major');
insert into priority (priority) values ('normal');
insert into priority (priority) values ('minor');