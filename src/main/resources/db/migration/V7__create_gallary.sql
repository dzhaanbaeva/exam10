use `exam10`;

create table gallery
(
    id       integer not null auto_increment,
    name   varchar(255),
    image    varchar(255),
    place_id int,
    primary key (id),
    foreign key (place_id) references places (id)
);
