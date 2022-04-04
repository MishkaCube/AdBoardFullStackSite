create sequence  IF NOT EXISTS ads_sequence START with 1 INCREMENT BY 1;

create sequence  IF NOT EXISTS users_sequence START with 1 INCREMENT BY 1;

create TABLE advertisments (
  id BIGINT NOT NULL,
   title VARCHAR(255),
   text VARCHAR(255),
   price INTEGER,
   category VARCHAR(255),
   src OID,
   CONSTRAINT pk_advertisments PRIMARY KEY (id)
);

create TABLE authorities (
  username VARCHAR(255) NOT NULL,
   authority VARCHAR(255),
   CONSTRAINT pk_authorities PRIMARY KEY (username)
);

create TABLE oauth_client_details (
  client_id VARCHAR(255) NOT NULL,
   resource_ids VARCHAR(255),
   client_secret VARCHAR(255),
   authorized_grant_types VARCHAR(255),
   web_server_redirect_uri VARCHAR(255),
   access_token_validity INTEGER,
   refresh_token_validity INTEGER,
   additional_information VARCHAR(255),
   scope VARCHAR(255),
   authorities VARCHAR(255),
   autoapprove BOOLEAN,
   CONSTRAINT pk_oauth_client_details PRIMARY KEY (client_id)
);

create TABLE users (
  id BIGINT NOT NULL,
   name VARCHAR(255),
   second_name VARCHAR(255),
   user_email VARCHAR(255),
   date_of_birth date,
   user_password VARCHAR(255),
   age INTEGER,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

