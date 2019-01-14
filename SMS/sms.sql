
select * from SMS_CHA;
select * from SMS_MEM;

insert into sms_mem values(1,'임김박','a1','린킨팤','lkn@co.mmm','1','','','','','','',sysdate);
select * from SMS_CHA;
select * from SMS_SELLBOARD;
>>>>>>> refs/heads/eresh25
insert into SMS_CHA values(1,1,'대진이형','너무똑똑',sysdate,'kim',1)
select * from SMS_mem;
delete from SMS_cha where cha_no=3;
delete from SMS_mem where mem_no=5;
alter table sms_mem modify (passwd varchar2(255));
