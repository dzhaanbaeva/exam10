use `exam10`;

create table places
(
    id       integer not null auto_increment,
    name   varchar(255),
    photo    varchar(255),
    description    varchar(255),
    primary key (id)
);
