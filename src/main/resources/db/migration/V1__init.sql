create schema software_dev;

use software_dev;

create table user (
    id int primary key auto_increment,
    name nvarchar(32) not null,
    accounting_id int not null
);

create table category (
    id int primary key auto_increment,
    name nvarchar(32) not null
);

create table record (
    id int primary key auto_increment,
    user_id int not null,
    category_id int not null,
    created_at date not null,
    outgo int not null,
    constraint fk_record_user foreign key (user_id) references user (id),
    constraint fk_record_category foreign key (category_id) references category (id)
);

create table accounting (
    id int primary key auto_increment,
    balance int not null
);

alter table user add constraint fk_user_accounting foreign key (accounting_id) references accounting (id);
