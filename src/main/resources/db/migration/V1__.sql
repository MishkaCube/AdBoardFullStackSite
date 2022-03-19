create sequence  IF NOT EXISTS users_sequence START with 1 INCREMENT BY 1;

create TABLE users (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   second_name VARCHAR(255),
   user_email VARCHAR(255),
   user_ads INTEGER,
   date_of_birth date,
   user_password VARCHAR(255),
   age INTEGER,
   CONSTRAINT pk_users PRIMARY KEY (id)
);