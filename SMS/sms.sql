select * from SMS_CHA;
select * from SMS_SELLBOARD;
select * from SMS_CHA;
select * from SMS_MEM;
insert into sms_mem values(1,'임김박','a1','린킨팤','lkn@co.mmm','1','','','','','','',sysdate);
insert into sms_mem values(2,'손오공','b1','여의도','n@cy.mmm','1','','','','','','',sysdate);
select * from SMS_CHA;
select * from SMS_SELLBOARD;
insert into SMS_CHA values(1,1,'대진이형','너무똑똑',sysdate,'kim',1)
select * from SMS_mem;
delete from SMS_cha where cha_no=3;
delete from SMS_mem where mem_no=5;
alter table sms_mem modify (passwd varchar2(255));
update tablename set col1=val1 from tablename where condition
update sms_mem set mem_img='', addr='팔공산', tel='010-9999-0000', mem_account='국민 000-00-00000' where mem_no=8;
select * from SMS_mem;
select * from sms_mem where mem_no=1;