DROP TABLE IF EXISTS tbl_users;
CREATE TYPE roleEnum AS ENUM ('USER', 'ADMIN');
CREATE TYPE statusEnum AS ENUM ('ACTIVE', 'DEACTIVATED');
CREATE TABLE tbl_users (
                                 id SERIAL PRIMARY KEY,
                                 createdAt TIMESTAMP(6) WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP(6) NOT NULL,
                                 createdBy TEXT,
                                 updatedAt TIMESTAMP(6) WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP(6) NOT NULL,
                                 updatedBy TEXT,
                                 deletedAt TIMESTAMP(6) WITH TIME ZONE,
                                 deletedBy TEXT,
                                 col_role roleEnum DEFAULT 'USER' NOT NULL,
                                 col_status statusEnum  DEFAULT 'ACTIVE' NOT NULL,
                                 col_email TEXT unique NOT NULL,
                                 col_fullName TEXT NOT NULL,
                                 col_phoneNumber TEXT unique ,
                                 col_password TEXT NOT NULL
);

CREATE INDEX email_index ON tbl_users (col_email);
CREATE INDEX phone_number_index ON tbl_users (col_phoneNumber);
