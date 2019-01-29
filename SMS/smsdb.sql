-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- SMS_mem Table Create SQL
CREATE TABLE SMS_mem
(
    mem_no         INT              NOT NULL, 
    mem_name       VARCHAR2(20)     NULL, 
    mem_id         VARCHAR2(20)     NULL, 
    nickname       VARCHAR2(255)    NULL, 
    email          VARCHAR2(255)    NULL, 
    passwd         VARCHAR2(100)     NULL, 
    mem_img        VARCHAR2(255)    NULL, 
    addr           VARCHAR2(255)    NULL, 
    tel            VARCHAR2(20)     NULL, 
    mny            INT              NULL, 
    mem_del        INT              NULL, 
    mem_account    VARCHAR2(255)    NULL, 
    CONSTRAINT SMS_MEM_PK PRIMARY KEY (mem_no)
)
/
drop 
COMMENT ON TABLE SMS_mem IS '회원정보 MEM'
/

COMMENT ON COLUMN SMS_mem.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_mem.mem_name IS '회원이름'
/

COMMENT ON COLUMN SMS_mem.mem_id IS '회원아이디'
/

COMMENT ON COLUMN SMS_mem.nickname IS '닉네임'
/

COMMENT ON COLUMN SMS_mem.email IS '이메일'
/

COMMENT ON COLUMN SMS_mem.passwd IS '비밀번호'
/

COMMENT ON COLUMN SMS_mem.mem_img IS '회원프로필이미지'
/

COMMENT ON COLUMN SMS_mem.addr IS '주소'
/

COMMENT ON COLUMN SMS_mem.tel IS '휴대전화'
/

COMMENT ON COLUMN SMS_mem.mny IS '포인트'
/

COMMENT ON COLUMN SMS_mem.mem_del IS '탈퇴'
/

COMMENT ON COLUMN SMS_mem.mem_account IS '계좌번호'
/


-- SMS_maincate Table Create SQL
CREATE TABLE SMS_maincate
(
    mcate_no      INT             NOT NULL, 
    mcate_name    VARCHAR2(20)    NULL, 
    CONSTRAINT SMS_MAINCATE_PK PRIMARY KEY (mcate_no)
)
/

--DROP TRIGGER SMS_maincate_AI_TRG;
/

--DROP SEQUENCE SMS_maincate_SEQ;
/

COMMENT ON TABLE SMS_maincate IS '메인카테고리 MCATE'
/

COMMENT ON COLUMN SMS_maincate.mcate_no IS '메인카테고리번호'
/

COMMENT ON COLUMN SMS_maincate.mcate_name IS '메인카테고리명'
/


-- SMS_sellboard Table Create SQL
CREATE TABLE SMS_sellboard
(
    sb_no       INT               NOT NULL, 
    sb_title    VARCHAR2(255)     NULL, 
    sb_desc     VARCHAR2(2000)    NULL, 
    sb_price    VARCHAR2(255)     NULL, 
    sb_img      VARCHAR2(255)     NULL, 
    mem_no      INT               NULL, 
    mcate_no    INT               NULL, 
    scate_no    INT               NULL, 
    sb_date     DATE              NULL, 
    CONSTRAINT SMS_SELLBOARD_PK PRIMARY KEY (sb_no)
)
/

--DROP TRIGGER SMS_sellboard_AI_TRG;
/

--DROP SEQUENCE SMS_sellboard_SEQ;
/

COMMENT ON TABLE SMS_sellboard IS '판매글 게시판 SB'
/

COMMENT ON COLUMN SMS_sellboard.sb_no IS '판매글번호'
/

COMMENT ON COLUMN SMS_sellboard.sb_title IS '글제목'
/

COMMENT ON COLUMN SMS_sellboard.sb_desc IS '서비스설명'
/

COMMENT ON COLUMN SMS_sellboard.sb_price IS '가격정보'
/

COMMENT ON COLUMN SMS_sellboard.sb_img IS '메인이미지'
/

COMMENT ON COLUMN SMS_sellboard.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_sellboard.mcate_no IS '메인카테고리번호'
/

COMMENT ON COLUMN SMS_sellboard.scate_no IS '서브카테고리번호'
/

COMMENT ON COLUMN SMS_sellboard.sb_date IS '게시일'
/

ALTER TABLE SMS_sellboard
    ADD CONSTRAINT FK_SMS_sellboard_mem_no_SMS_me FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/

ALTER TABLE SMS_sellboard
    ADD CONSTRAINT FK_SMS_sellboard_mcate_no_SMS_ FOREIGN KEY (mcate_no)
        REFERENCES SMS_maincate (mcate_no)
/


-- SMS_subcate Table Create SQL
CREATE TABLE SMS_subcate
(
    scate_no      INT             NOT NULL, 
    mcate_no      INT             NULL, 
    scate_name    VARCHAR2(20)    NULL, 
    CONSTRAINT SMS_SUBCATE_PK PRIMARY KEY (scate_no)
)
/


--DROP TRIGGER SMS_subcate_AI_TRG;
/

--DROP SEQUENCE SMS_subcate_SEQ;
/

COMMENT ON TABLE SMS_subcate IS '서브카테고리 SCATE'
/

COMMENT ON COLUMN SMS_subcate.scate_no IS '서브카테고리번호'
/

COMMENT ON COLUMN SMS_subcate.mcate_no IS '메인카테고리번호'
/

COMMENT ON COLUMN SMS_subcate.scate_name IS '서브카테고리명'
/

ALTER TABLE SMS_subcate
    ADD CONSTRAINT FK_SMS_subcate_mcate_no_SMS_ma FOREIGN KEY (mcate_no)
        REFERENCES SMS_maincate (mcate_no)
/

ALTER TABLE SMS_subcate
    ADD CONSTRAINT FK_SMS_subcate_scate_no_SMS_se FOREIGN KEY (scate_no)
        REFERENCES SMS_sellboard (scate_no)
/


-- SMS_admin Table Create SQL
CREATE TABLE SMS_admin
(
    admin_no    INT             NOT NULL, 
    admin_id    VARCHAR2(20)    NULL, 
    passwd      VARCHAR2(20)    NULL, 
    CONSTRAINT SMS_ADMIN_PK PRIMARY KEY (admin_no)
)
/

--DROP TRIGGER SMS_admin_AI_TRG;
/

--DROP SEQUENCE SMS_admin_SEQ;
/

COMMENT ON TABLE SMS_admin IS '관리자 ADMIN'
/

COMMENT ON COLUMN SMS_admin.admin_no IS '관리자번호'
/

COMMENT ON COLUMN SMS_admin.admin_id IS '관리자아이디'
/

COMMENT ON COLUMN SMS_admin.passwd IS '비밀번호'
/


-- SMS_charge Table Create SQL
CREATE TABLE SMS_charge
(
    mem_no      INT     NOT NULL, 
    chg_mny     INT     NULL, 
    chg_date    DATE    NULL, 
    CONSTRAINT SMS_CHARGE_PK PRIMARY KEY (mem_no)
)
/

COMMENT ON TABLE SMS_charge IS '충전내역 CHG'
/

COMMENT ON COLUMN SMS_charge.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_charge.chg_mny IS '충전포인트'
/

COMMENT ON COLUMN SMS_charge.chg_date IS '충전일자'
/

ALTER TABLE SMS_charge
    ADD CONSTRAINT FK_SMS_charge_mem_no_SMS_mem_m FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/


-- SMS_quest Table Create SQL
CREATE TABLE SMS_quest
(
    mem_no     INT     NOT NULL, 
    sb_no      INT     NULL, 
    qst_dar    DATE    NULL, 
    CONSTRAINT SMS_QUEST_PK PRIMARY KEY (mem_no)
)
/

COMMENT ON TABLE SMS_quest IS '의뢰내역 QST'
/

COMMENT ON COLUMN SMS_quest.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_quest.sb_no IS '판매글번호'
/

COMMENT ON COLUMN SMS_quest.qst_dar IS '구매일자'
/

ALTER TABLE SMS_quest
    ADD CONSTRAINT FK_SMS_quest_mem_no_SMS_mem_me FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/

ALTER TABLE SMS_quest
    ADD CONSTRAINT FK_SMS_quest_sb_no_SMS_sellboa FOREIGN KEY (sb_no)
        REFERENCES SMS_sellboard (sb_no)
/


-- SMS_review Table Create SQL
CREATE TABLE SMS_review
(
    re_no       INT               NULL, 
    sb_no       INT               NOT NULL, 
    re_cont     VARCHAR2(1000)    NULL, 
    re_score    INT               NULL, 
    mem_no      INT               NULL, 
    CONSTRAINT SMS_REVIEW_PK PRIMARY KEY (re_no)
)
/

--DROP TRIGGER SMS_review_AI_TRG;
/

--DROP SEQUENCE SMS_review_SEQ;
/

COMMENT ON TABLE SMS_review IS '구매자 평가'
/

COMMENT ON COLUMN SMS_review.re_no IS '평가글 번호'
/

COMMENT ON COLUMN SMS_review.sb_no IS '판매글번호'
/

COMMENT ON COLUMN SMS_review.re_cont IS '평가글 내용'
/

COMMENT ON COLUMN SMS_review.re_score IS '평가점수(별점)'
/

COMMENT ON COLUMN SMS_review.mem_no IS '회원번호'
/

ALTER TABLE SMS_review
    ADD CONSTRAINT FK_SMS_review_sb_no_SMS_sellbo FOREIGN KEY (sb_no)
        REFERENCES SMS_sellboard (sb_no)
/

ALTER TABLE SMS_review
    ADD CONSTRAINT FK_SMS_review_mem_no_SMS_mem_m FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/


-- SMS_qna Table Create SQL
CREATE TABLE SMS_qna
(
    sb_no       INT               NOT NULL, 
    mem_no      INT               NOT NULL, 
    qna_cont    VARCHAR2(2000)    NULL, 
    qna_date    DATE              NULL, 
    CONSTRAINT SMS_QNA_PK PRIMARY KEY (mem_no)
)
/

COMMENT ON TABLE SMS_qna IS '거래문의'
/

COMMENT ON COLUMN SMS_qna.sb_no IS '회원번호(판매자)'
/

COMMENT ON COLUMN SMS_qna.mem_no IS '회원번호(작성자)'
/

COMMENT ON COLUMN SMS_qna.qna_cont IS '문의내용'
/

COMMENT ON COLUMN SMS_qna.qna_date IS '문의날짜'
/

ALTER TABLE SMS_qna
    ADD CONSTRAINT FK_SMS_qna_mem_no_SMS_mem_mem_ FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/

ALTER TABLE SMS_qna
    ADD CONSTRAINT FK_SMS_qna_sb_no_SMS_sellboard FOREIGN KEY (sb_no)
        REFERENCES SMS_sellboard (mem_no)
/


-- SMS_request Table Create SQL
CREATE TABLE SMS_request
(
    mem_no      INT               NOT NULL, 
    rq_no       INT               NULL, 
    mcate_no    INT               NULL, 
    scate_no    INT               NULL, 
    rq_title    VARCHAR2(255)     NULL, 
    rq_cont     VARCHAR2(2000)    NULL, 
    rq_date     DATE              NULL, 
    rq_price    INT               NULL, 
    rq_cond     INT               NULL, 
    CONSTRAINT SMS_REQUEST_PK PRIMARY KEY (rq_no)
)
/

--DROP TRIGGER SMS_request_AI_TRG;
/

--DROP SEQUENCE SMS_request_SEQ;
/

COMMENT ON TABLE SMS_request IS '의뢰 게시판'
/

COMMENT ON COLUMN SMS_request.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_request.rq_no IS '의뢰글번호'
/

COMMENT ON COLUMN SMS_request.mcate_no IS '메인카테고리번호'
/

COMMENT ON COLUMN SMS_request.scate_no IS '서브카테고리번호'
/

COMMENT ON COLUMN SMS_request.rq_title IS '게시글제목'
/

COMMENT ON COLUMN SMS_request.rq_cont IS '게시글내용'
/

COMMENT ON COLUMN SMS_request.rq_date IS '게시글날짜'
/

COMMENT ON COLUMN SMS_request.rq_price IS '희망가격'
/

COMMENT ON COLUMN SMS_request.rq_cond IS '의뢰현황(완료여부)'
/

ALTER TABLE SMS_request
    ADD CONSTRAINT FK_SMS_request_mcate_no_SMS_su FOREIGN KEY (mcate_no)
        REFERENCES SMS_subcate (mcate_no)
/

ALTER TABLE SMS_request
    ADD CONSTRAINT FK_SMS_request_scate_no_SMS_su FOREIGN KEY (scate_no)
        REFERENCES SMS_subcate (scate_no)
/

ALTER TABLE SMS_request
    ADD CONSTRAINT FK_SMS_request_mem_no_SMS_mem_ FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/


-- SMS_cha Table Create SQL
CREATE TABLE SMS_cha
(
    cha_no       INT               NOT NULL, 
    mem_no       INT               NULL, 
    cha_title    VARCHAR2(20)      NULL, 
    cha_cont     VARCHAR2(2000)    NULL, 
    cha_date     DATE              NULL, 
    cha_id       VARCHAR2(20)      NULL, 
    CONSTRAINT SMS_CHA_PK PRIMARY KEY (cha_no)
)
/

--DROP TRIGGER SMS_cha_AI_TRG;
/

--DROP SEQUENCE SMS_cha_SEQ;
/

COMMENT ON TABLE SMS_cha IS '신고게시판'
/

COMMENT ON COLUMN SMS_cha.cha_no IS '신고게시글번호'
/

COMMENT ON COLUMN SMS_cha.mem_no IS '회원번호'
/

COMMENT ON COLUMN SMS_cha.cha_title IS '신고글제목'
/

COMMENT ON COLUMN SMS_cha.cha_cont IS '신고글내용'
/

COMMENT ON COLUMN SMS_cha.cha_date IS '신고글날짜'
/

COMMENT ON COLUMN SMS_cha.cha_id IS '신고대상아이디'
/

ALTER TABLE SMS_cha
    ADD CONSTRAINT FK_SMS_cha_mem_no_SMS_mem_mem_ FOREIGN KEY (mem_no)
        REFERENCES SMS_mem (mem_no)
/

--db sms_mem 등록일 컬럼 추가
ALTER TABLE Sms_mem ADD mem_reg Date;
--db table수정- 신고게시판 조회수
ALTER TABLE SMS_cha ADD cha_count int;
--db table수정- 의뢰게시판 조회수
ALTER TABLE SMS_request ADD rq_count int;
alter table sms_cha MODIFY (cha_title varchar2(1000));
--신고게시판 댓글
create table SMS_cha_reply (
	rep_no int primary key,
	cha_no int,
	cha_re_cont varchar2(255),
	mem_no int,
	regdate date, --올린날짜
	updatedate date, --수정날짜 
	del char(1)	--삭제여부
);
--의뢰게시판 댓글
CREATE TABLE Sms_request_reply
(
    rq_no         INT, 
    rq_re_no      INT,
    rq_re_cont    VARCHAR2(255),
    mem_no        INT,
    regdate       DATE,
    updatedate    DATE,
    del           CHAR(1)
)
ALTER TABLE SMS_request ADD rq_count int;
select * from sms_request;

INSERT into sms_maincate values(1,'디자인');
INSERT into sms_maincate values(2,'IT');
INSERT into sms_maincate values(3,'콘텐츠제작');
INSERT into sms_maincate values(4,'마케팅');
INSERT into sms_maincate values(5,'번역');
INSERT into sms_maincate values(6,'문서');
INSERT into sms_maincate values(7,'레슨');

INSERT into sms_subcate values(1,1,'로고디자인');
INSERT into sms_subcate values(2,1,'명함/인쇄물');
INSERT into sms_subcate values(3,1,'3D모델링/도면');
INSERT into sms_subcate values(4,1,'캘라그라피');
INSERT into sms_subcate values(5,1,'일러스트');
INSERT into sms_subcate values(6,1,'포토샵');

INSERT into sms_subcate values(7,2,'웹사이트개발');
INSERT into sms_subcate values(8,2,'모바일앱/웹');
INSERT into sms_subcate values(9,2,'프로그램개발');
INSERT into sms_subcate values(10,2,'데이터베이스');
INSERT into sms_subcate values(11,2,'QA/테스트');
INSERT into sms_subcate values(12,2,'서버/기술지원');

INSERT into sms_subcate values(13,3,'영상');
INSERT into sms_subcate values(14,3,'사진');
INSERT into sms_subcate values(15,3,'더빙');
INSERT into sms_subcate values(16,3,'음악');

INSERT into sms_subcate values(17,4,'카페/블로그');
INSERT into sms_subcate values(18,4,'기획/컨설팅');
INSERT into sms_subcate values(19,4,'검색/키워드');
INSERT into sms_subcate values(20,4,'광고대행');
INSERT into sms_subcate values(21,4,'오프라인광고');

INSERT into sms_subcate values(22,5,'번역');
INSERT into sms_subcate values(23,5,'통역');

INSERT into sms_subcate values(24,6,'글작성');
INSERT into sms_subcate values(25,6,'자소서');
INSERT into sms_subcate values(26,6,'타이핑');
INSERT into sms_subcate values(27,6,'교정/편집');
INSERT into sms_subcate values(28,6,'대본');
INSERT into sms_subcate values(29,6,'카피라이팅');
	
INSERT into sms_subcate values(30,7,'컴퓨터');
INSERT into sms_subcate values(31,7,'외국어');
INSERT into sms_subcate values(32,7,'마케팅');
INSERT into sms_subcate values(33,7,'영상/사진');
INSERT into sms_subcate values(34,7,'음악/악기');


drop table sms_qna;
drop table sms_quest;
drop table sms_charge;
select * from sms_qna;
select * from sms_quest;
select * from sms_charge;

CREATE TABLE SMS_qna
(
    sb_no       INT               NOT NULL, 
    mem_no      INT               NOT NULL, 
    qna_cont    VARCHAR2(2000)    NULL, 
    qna_date    DATE              NULL
);
CREATE TABLE SMS_quest
(
    mem_no     INT     NOT NULL, 
    sb_no      INT     NULL, 
    qst_dar    DATE    NULL
);
CREATE TABLE SMS_charge
(
    mem_no      INT     NOT NULL, 
    chg_mny     INT     NULL, 
    chg_date    DATE    NULL
);
