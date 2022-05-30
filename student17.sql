create database student17;
create user sample1 with password '111';
grant all on database student17 to sample1;
CREATE TABLE "juice" ("id" serial PRIMARY KEY, "title" varchar, "descr" varchar, "img" varchar);