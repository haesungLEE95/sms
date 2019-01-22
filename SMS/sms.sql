<<<<<<< HEAD
select * from SMS_CHA;
select * from SMS_SELLBOARD;


insert into sms_mem values(1,'임김박','a1','린킨팤','lkn@co.mmm','1','','','','','','',sysdate);
=======
select * from SMS_CHA;
select * from SMS_SELLBOARD;
insert into SMS_CHA values(1,1,'대진이형','너무똑똑',sysdate,'kim',1)
>>>>>>> refs/remotes/origin/haes
update tablename set col1=val1 from tablename where condition

update sms_mem set mem_img='', addr='팔공산', tel='010-9999-0000', mem_account='국민 000-00-00000' where mem_no=8;
select * from SMS_mem;

update tablename set col1=val1 from tablename where condition

delete sms_mem where mem_id = 'c1';

update sms_mem set mem_img=coalesce('adsf.jpg',''), addr=coalesce(null,''), tel=coalesce('010-9999-0000',''), mem_account=coalesce('국민','') where mem_id='a5';

CREATE TABLE temp AS SELECT mem_no, mem_name, mem_id, nickname, email, passwd, mem_img, addr, tel, mny, mem_del, mem_account, mem_reg FROM SMS_mem;
DROP TABLE SMS_mem cascade constraint;
ALTER TABLE temp RENAME SMS_mem;
drop table sms_admin cascade constraint;

select * from sms_mem where mem_id='kakak';

select passwd from sms_mem;

select * from sms_mem where mem_id='a12';

