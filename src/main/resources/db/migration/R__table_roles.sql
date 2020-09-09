INSERT INTO ams.public.roles (name, description, updated_at, created_at)
VALUES ('owner', 'The owner of the apartment', null, now()),
       ('juristic person',
        'A legal person which subject to legal rights and duties',
        null, now()),
       ('tenant', 'a person who occupies land or property rented from a landlord', null,
        now())