use `exam10`;

create table user_role
(
    user_id integer not null,
    roles   varchar(255)
);
create table users
(
    id       integer not null auto_increment,
    active   bit     not null,
    email    varchar(255),
    full_name    varchar(255),
    password varchar(255),
    primary key (id)
);
alter table user_role add constraint FKj345gk1bovqvfame88rcx7yyx foreign key (user_id) references users (id);
