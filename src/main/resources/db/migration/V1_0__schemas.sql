create table ams.public.roles
(
    role_id     serial,
    code        varchar(3) not null,
    name        varchar    not null,
    description varchar,
    is_active   bool      default true,
    updated_at  timestamp default current_timestamp,
    created_at  timestamp default current_timestamp,
    primary key (role_id)
);

create table ams.public.users
(
    user_id      serial,
    role_id      integer      not null,
    user_code    varchar(20)  not null,
    first_name   varchar(100) not null,
    last_name    varchar(100) not null,
    display_name varchar(200),
    phone_number varchar(50)  not null,
    email        varchar(200),
    address      text         not null,
    is_active    bool      default true,
    updated_at   timestamp default current_timestamp,
    created_at   timestamp default current_timestamp,
    primary key (user_id),
    foreign key (role_id) references roles (role_id)
);

