CREATE TABLE  IF NOT EXISTS roles(
    role_id UUID primary key default gen_random_uuid(),
    role_name varchar(200) unique,
    created_by varchar(200),
    created_on timestamp,
    modified_by varchar(200),
    modified_on timestamp default CURRENT_TIMESTAMP
);