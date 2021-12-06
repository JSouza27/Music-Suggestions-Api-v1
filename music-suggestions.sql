CREATE TABLE "user" (
  "id" INT PRIMARY KEY,
  "fisrt_name" VARCHAR(200),
  "last_name" VARCHAR(200),
  "email" VARCHAR(200),
  "password" VARCHAR(64),
  "address_id" INT
);

CREATE TABLE "address" (
  "id" INT PRIMARY KEY,
  "street" VARCHAR(200),
  "city" VARCHAR(200),
  "state" VARCHAR(20),
  "zipCode" VARCHAR(20)
);

CREATE TABLE "reproduction_history" (
  "id" INT PRIMARY KEY,
  "play_list" VARCHAR(200),
  "user_id" INT
);

ALTER TABLE "address" ADD FOREIGN KEY ("id") REFERENCES "user" ("address_id");

ALTER TABLE "reproduction_history" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");
