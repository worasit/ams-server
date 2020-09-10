drop table if exists ams.public.roles;
create table ams.public.roles
(
    role_id     serial primary key,
    code        varchar(3) not null,
    name        varchar    not null,
    description varchar,
    updated_at  timestamp,
    created_at  timestamp  not null
);