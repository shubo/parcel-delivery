create table user_pd(
    id SERIAL PRIMARY KEY,
    password varchar,
    email VARCHAR(100),
    role varchar(20)
);

insert into user_pd(password, email, role) values('$2a$10$D/dJ7cDXln4HoAybCTVD1.FXhbb7U1Wjx.WxkeJJLKiith5ZOiB0u', 'a@a.com', 'ADMIN');
commit;