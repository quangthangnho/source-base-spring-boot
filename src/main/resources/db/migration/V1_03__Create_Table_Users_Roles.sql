CREATE TABLE tbl_users_roles
(
    col_user_id INT,
    col_role_id INT,
    PRIMARY KEY (col_user_id, col_role_id),
    CONSTRAINT fk_users
        FOREIGN KEY (col_user_id)
            REFERENCES tbl_users (col_user_id),
    CONSTRAINT fk_roles
        FOREIGN KEY (col_role_id)
            REFERENCES tbl_roles (col_role_id)
);