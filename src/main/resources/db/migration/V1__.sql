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


