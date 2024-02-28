CREATE TYPE user_roles AS ENUM ('USER', 'ADMIN');

CREATE TABLE tbl_roles (
    id SERIAL PRIMARY KEY,
    col_role user_roles DEFAULT 'USER' NOT NULL,
    description TEXT
)