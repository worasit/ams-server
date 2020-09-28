delete
from ams.public.roles;

INSERT INTO ams.public.roles (name, code, description, is_active)
VALUES ('owner', 'OWN', 'The owner of the apartment', true),
       ('juristic person', 'JTP',
        'A legal person which subject to legal rights and duties',
        true),
       ('tenant', 'TEN', 'a person who occupies land or property rented from a landlord',
        true),
       ('technician', 'TCH', 'a person who maintain electricity or water system of the property.',
        true),
       ('guest', 'GST', '', true)