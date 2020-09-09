create table IF NOT EXISTS ams.public.roles
(
    role_id     serial primary key,
    name        varchar   not null,
    description varchar,
    updated_at  timestamp,
    created_at  timestamp not null
);