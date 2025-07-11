CREATE TABLE IF NOT EXISTS transactions(
    id UUID default gen_random_uuid() unique primary key,
    wallet_id UUID,
    transaction_type varchar(100),
    amount DECIMAL,
    currency varchar(50),
    external_reference varchar(100),
    transaction_reference varchar(100),
    created_by varchar(100),
    created_on TIMESTAMP,
    modified_by varchar(100),
    modified_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT wallet_fkey  FOREIGN KEY (wallet_id) REFERENCES wallet (wallet_id)
);