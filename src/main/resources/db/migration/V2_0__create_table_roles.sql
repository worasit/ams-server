drop table if exists ams.public.roles;
create table ams.public.roles
(
    role_id     serial primary key,
    code        varchar(3) not null,
    name        varchar    not null,
    description varchar,
    is_active   bool      default true,
    updated_at  timestamp default current_timestamp,
    created_at  timestamp default current_timestamp
);