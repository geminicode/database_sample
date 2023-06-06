drop table if exists person cascade;

create table person (
    id uuid not null,
    first_name varchar(255),
    last_name varchar(255),
    created_on timestamp with time zone default CURRENT_TIMESTAMP not null,
    primary key (id)
);