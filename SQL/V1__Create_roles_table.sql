CREATE DATABASE IF NOT EXISTS ams;

CREATE TABLE IF NOT EXISTS aws.roles
(
    role_id     serial primary key,
    name        nvarchar(100) not null,
    description varchar(500),
    updated_at  datetime,
    created_at  datetime      not null
);