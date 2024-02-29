CREATE TABLE tbl_roles (
    id SERIAL PRIMARY KEY,
    col_role TEXT NOT NULL,
    col_description TEXT
);

INSERT INTO tbl_roles (col_role, col_description) VALUES ('ADMIN', 'admin');
INSERT INTO tbl_roles (col_role, col_description) VALUES (('USER', 'user'));