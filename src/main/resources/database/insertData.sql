insert into store(name, description, address) values ('Mike''s Pet Store', 'Pet store selling a variety of pets.', '12345 Main St');

insert into product_category(name, description, store_id) values ('Bird', 'Birds', (select top 1 id from store where name = 'Mike''s Pet Store'));
insert into product_category(name, description, store_id) values ('Mammal', 'Mammals',  (select top 1 id from store where name = 'Mike''s Pet Store'));
insert into product_category(name, description, store_id) values ('Reptile', 'Reptiles', (select top 1 id from store where name = 'Mike''s Pet Store'));
insert into product_category(name, description, store_id) values ('Amphibian', 'Amphibians', (select top 1 id from store where name = 'Mike''s Pet Store'));

insert into store(name, description, address) values ('Kelly''s Sports Store', 'Sports store selling a variety of sporting goods.', '12346 Main St');

insert into product_category(name, description, store_id) values ('Fishing', 'Fishing Supplies', (select top 1 id from store where name = 'Kelly''s Sports Store'));
insert into product_category(name, description, store_id) values ('Winter Sports', 'Winter Sporting Goods',  (select top 1 id from store where name = 'Kelly''s Sports Store'));
insert into product_category(name, description, store_id) values ('Summer Sports', 'Summer SportingGoods', (select top 1 id from store where name = 'Kelly''s Sports Store'));

