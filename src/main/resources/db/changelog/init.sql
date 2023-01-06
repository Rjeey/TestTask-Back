CREATE TABLE "usr" (
                         "id" BIGSERIAL primary key,
                         "created" timestamp,
                         "updated" timestamp,
                         "login" varchar(255),
                         "password" varchar(255)
);

CREATE TABLE "role" (
                         "id" BIGSERIAL primary key,
                         "name" varchar(255)
);

CREATE TABLE "usr_role" (
                               "user_id" BIGINT NOT NULL REFERENCES usr(id),
                               "role_id" BIGINT NOT NULL REFERENCES role(id),
                               primary key (user_id, role_id)
);

CREATE TABLE "token" (
                          "id" int8 not null primary key,
                          "expiry_date" timestamp not null,
                          "token" varchar(255) not null,
                          "user_id" int8
);



CREATE TABLE "exchange_rate" (
                        "id"  bigserial not null primary key,
                        "created_date" timestamp,
                        "updated_date" timestamp,
                        "currency" varchar(255),
                        "ecb_date" date,
                        "rate" float8
);

CREATE TABLE "conversion" (
                        "id"  bigserial not null primary key,
                        "created_date" timestamp,
                        "updated_date" timestamp,
                        "ecb_date" date,
                        "from_value" float8,
                        "to_value" float8,
                        "conversion_from_id" int8,
                        "conversion_to_id" int8,
                        "author_id" int8
);


