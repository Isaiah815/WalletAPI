CREATE TABLE  IF NOT EXISTS wallet(
    wallet_id UUID  unique primary key default gen_random_uuid(),
    user_id UUID,
    wallet_name varchar(100),
    created_by varchar(100),
    created_on TIMESTAMP,
    modified_by varchar(100),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT user_id_key FOREIGN KEY (user_id) REFERENCES users (id)

);