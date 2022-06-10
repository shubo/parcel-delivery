create table order_pd
(
    id        SERIAL primary key,
    username  varchar(50),
    from_addr varchar(100),
    to_addr   varchar(100),
    weight    numeric,
    status    varchar(50)
)