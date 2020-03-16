drop table alarm;
create table alarm 
(
	alarm_date date
);


insert into alarm values (SYSDATE);
SELECT * FROM alarm where trunc(TO_DATE(ALARM_DATE,'yyyymmdd')) - trunc(TO_DATE('20190228','yyyymmdd')) <=7

select * from alarm;
select * from member;




select * from VOLUNTEER;

SELECT VOLUNTEER_title,volunteer_date FROM VOLUNTEER where volunteer_seq in (SELECT volunteer_seq FROM apply WHERE MEMBER_ID = 'a');

select * from volunteer;
select * from apply;
insert into apply values(0,31,'ADMIN',123123,'ADMIN','ADMIN');

select * from member;

delete from apply where apply_seq = 2;