create table store (
    id bigint IDENTITY PRIMARY KEY,
    name varchar(100),
    description varchar(500),
    address varchar(300)
);

create table product_category (
    id bigint IDENTITY PRIMARY KEY,
    name varchar(100),
    description varchar(500),
    store_id bigint
);

alter table product_category add foreign key (store_id) references store(id);