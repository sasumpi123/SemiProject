create sequence shopseq;

CREATE TABLE shop (
       shop_seq number primary key,
       shop_owner varchar2(1000) not null,
       shop_name varchar2(1000) not null,
       shop_kind varchar2(100) not null,
       shop_price number not null,
       shop_quantity number not null,
       shop_content varchar2(1000) not null,
       shop_photo varchar2(1000)
);

drop table shop;
drop sequence shopseq;

insert into shop values(shopseq.nextval ,'ADMIN', 'test', 'test', 1000, 1000, 'test', '');

UPDATE SHOP SET SHOP_QUANTITY = SHOP_QUANTITY-1 WHERE SHOP_SEQ = 1;

select * from shop where shop_name like'%he%';

select * from shop;

UPDATE SHOP SET SHOP_QUANTITY = 100 WHERE SHOP_SEQ = 2;

select * from member;
