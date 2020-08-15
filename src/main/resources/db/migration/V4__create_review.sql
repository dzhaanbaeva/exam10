use `exam10`;

create table reviews
(
    id       integer not null auto_increment,
    text   varchar(255),
    data    datetime,
    rating    double ,
    users_id int,
    places_id int,
    primary key (id),
     foreign key (users_id) references users (id),
    foreign key (places_id) references places(id)
);
