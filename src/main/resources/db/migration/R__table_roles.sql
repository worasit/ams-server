delete
from ams.public.roles;

INSERT INTO ams.public.roles (name, code, description, updated_at, created_at)
VALUES ('owner', 'OWN', 'The owner of the apartment', null, now()),
       ('juristic person', 'JTP',
        'A legal person which subject to legal rights and duties',
        null, now()),
       ('tenant', 'TEN', 'a person who occupies land or property rented from a landlord', null,
        now()),
       ('technician', 'TCH', 'a person who maintain electricity or water system of the property.',
        null,
        now()),
       ('guest', 'GST', '',
        null,
        now())