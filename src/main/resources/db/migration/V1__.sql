create TABLE advertisments (
  id BIGINT NOT NULL,
   title VARCHAR(255),
   owner VARCHAR(255),
   text VARCHAR(255),
   price INTEGER,
   category VARCHAR(255),
   src OID,
   CONSTRAINT pk_advertisments PRIMARY KEY (id)
);

