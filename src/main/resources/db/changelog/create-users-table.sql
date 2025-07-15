CREATE  TABLE users(
    id UUID unique primary key,
    username varchar(200)  NOT null,
    first_name varchar(100),
    last_name varchar(100),
    role_id UUID,
    email varchar(100) unique
    CONSTRAINTS role_id_key FOREIGN key(role_id) REFERENCES roles (role_id)

);