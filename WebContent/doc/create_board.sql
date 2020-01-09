--alter system set deferred_segment_creation = false;

ALTER TABLE board_list
	DROP
		CONSTRAINT blist_btcode_fk
		CASCADE;

ALTER TABLE board_list
	DROP
		CONSTRAINT blist_ccode_fk
		CASCADE;

ALTER TABLE board
	DROP
		CONSTRAINT board_bcode_fk
		CASCADE;

ALTER TABLE reboard
	DROP
		CONSTRAINT reboard_seq_fk
		CASCADE;

ALTER TABLE album
	DROP
		CONSTRAINT album_seq_fk
		CASCADE;

ALTER TABLE bbs
	DROP
		CONSTRAINT bbs_seq_fk
		CASCADE;

ALTER TABLE memo
	DROP
		CONSTRAINT memo_seq_fk
		CASCADE;

ALTER TABLE board_type
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE category
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE board_list
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE board
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE reboard
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE album
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE bbs
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

ALTER TABLE memo
	DROP
		PRIMARY KEY
		CASCADE
		KEEP INDEX;

DROP INDEX btype_btcode_pk;

DROP INDEX category_ccode_pk;

DROP INDEX blist_bcode_pk;

DROP INDEX board_seq_pk;

DROP INDEX reboard_rseq_pk;

DROP INDEX album_aseq_pk;

DROP INDEX bbs_bseq_pk;

DROP INDEX memo_mseq_pk;

/* 게시판형식 */
DROP TABLE board_type 
	CASCADE CONSTRAINTS;

/* 카테고리 */
DROP TABLE category 
	CASCADE CONSTRAINTS;

/* 게시판목록 */
DROP TABLE board_list 
	CASCADE CONSTRAINTS;

/* 게시판 */
DROP TABLE board 
	CASCADE CONSTRAINTS;

/* 답변게시판 */
DROP TABLE reboard 
	CASCADE CONSTRAINTS;

/* 앨범게시판 */
DROP TABLE album 
	CASCADE CONSTRAINTS;

/* 자료실 */
DROP TABLE bbs 
	CASCADE CONSTRAINTS;

/* 댓글 */
DROP TABLE memo 
	CASCADE CONSTRAINTS;

drop sequence board_seq;

drop sequence bcode_seq;	

drop sequence btcode_seq;

drop sequence reboard_seq;

drop sequence memo_seq;

drop sequence album_seq;

drop sequence bbs_seq;

drop sequence ccode_seq;
		
create sequence btcode_seq
start with 1 increment by 1;			
	
/* 게시판형식 */
CREATE TABLE board_type (
	btcode NUMBER(2) NOT NULL, /* 게시판형식번호 */
	btname VARCHAR2(20) /* 게시판형식이름 */
);

COMMENT ON TABLE board_type IS '게시판형식';

COMMENT ON COLUMN board_type.btcode IS '게시판형식번호';

COMMENT ON COLUMN board_type.btname IS '게시판형식이름';

CREATE UNIQUE INDEX btype_btcode_pk
	ON board_type (
		btcode ASC
	);

ALTER TABLE board_type
	ADD
		CONSTRAINT btype_btcode_pk
		PRIMARY KEY (
			btcode
		);
		
insert into board_type (btcode, btname)
values (btcode_seq.nextval, '공지사항');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '방명록');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '한줄게시판');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '일반게시판');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '답변게시판');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '앨범게시판');

insert into board_type (btcode, btname)
values (btcode_seq.nextval, '자료실');

create sequence ccode_seq
start with 1 increment by 1;			

/* 카테고리 */
CREATE TABLE category (
	ccode NUMBER(2) NOT NULL, /* 카테고리번호 */
	cname VARCHAR2(30) /* 카테고리이름 */
);

COMMENT ON TABLE category IS '카테고리';

COMMENT ON COLUMN category.ccode IS '카테고리번호';

COMMENT ON COLUMN category.cname IS '카테고리이름';

CREATE UNIQUE INDEX category_ccode_pk
	ON category (
		ccode ASC
	);

ALTER TABLE category
	ADD
		CONSTRAINT category_ccode_pk
		PRIMARY KEY (
			ccode
		);	
		
insert into category (ccode, cname)
values (ccode_seq.nextval, '갤럭시S7');

insert into category (ccode, cname)
values (ccode_seq.nextval, '갤럭시노트7');

insert into category (ccode, cname)
values (ccode_seq.nextval, '아이폰7S');
		
create sequence bcode_seq
start with 1 increment by 1;		
		
/* 게시판목록 */
CREATE TABLE board_list (
	bcode NUMBER(3) NOT NULL, /* 게시판번호 */
	bname VARCHAR2(50), /* 게시판이름 */
	btcode NUMBER(2), /* 게시판형식번호 */
	ccode NUMBER(2) /* 카테고리번호 */
);

COMMENT ON TABLE board_list IS '게시판목록';

COMMENT ON COLUMN board_list.bcode IS '게시판번호';

COMMENT ON COLUMN board_list.bname IS '게시판이름';

COMMENT ON COLUMN board_list.btcode IS '게시판형식번호';

COMMENT ON COLUMN board_list.ccode IS '카테고리번호';

CREATE UNIQUE INDEX blist_bcode_pk
	ON board_list (
		bcode ASC
	);

ALTER TABLE board_list
	ADD
		CONSTRAINT blist_bcode_pk
		PRIMARY KEY (
			bcode
		);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[갤7] 공지사항', 1, 1);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[갤7] 출석체크', 3 , 1);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[갤7] 물어보세요', 5 , 1);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[갤7] 자랑하기', 6, 1);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[노트7] 자유게시판', 4, 2);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[노트7] 사는이야기', 4, 2);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[노트7] 어플공유', 7, 2);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[노트7] 질문답변', 5, 2);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[노트7] 인증샷', 6, 2);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[아7S] 강좌/팁', 4, 3);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[아7S] 질문/답변', 5, 3);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[아7S] 사용후기', 4, 3);

insert into board_list (bcode, bname, btcode, ccode)
values (bcode_seq.nextval, '[아7S] 로찍은사진', 6, 3);
		
create sequence board_seq
start with 1 increment by 1;
		
/* 게시판 */
CREATE TABLE board (
	seq NUMBER NOT NULL, /* 글번호 */
	id VARCHAR2(16), /* 작성자아이디 */
	name VARCHAR2(20), /* 작성자이름 */
	email VARCHAR2(50), /* 작성자이메일 */
	subject VARCHAR2(50) NOT NULL, /* 제목 */
	content CLOB NOT NULL, /* 내용 */
	hit NUMBER DEFAULT 0, /* 조회수 */
	logtime DATE DEFAULT sysdate, /* 작성시간 */
	bcode NUMBER(3) /* 게시판번호 */
);

COMMENT ON TABLE board IS '게시판';

COMMENT ON COLUMN board.seq IS '글번호';

COMMENT ON COLUMN board.id IS '작성자아이디';

COMMENT ON COLUMN board.name IS '작성자이름';

COMMENT ON COLUMN board.email IS '작성자이메일';

COMMENT ON COLUMN board.subject IS '제목';

COMMENT ON COLUMN board.content IS '내용';

COMMENT ON COLUMN board.hit IS '조회수';

COMMENT ON COLUMN board.logtime IS '작성시간';

COMMENT ON COLUMN board.bcode IS '게시판번호';

CREATE UNIQUE INDEX board_seq_pk
	ON board (
		seq ASC
	);

ALTER TABLE board
	ADD
		CONSTRAINT board_seq_pk
		PRIMARY KEY (
			seq
		);

create sequence reboard_seq
start with 1 increment by 1;		
		
/* 답변게시판 */
CREATE TABLE reboard (
	rseq NUMBER NOT NULL, /* 답변게시판일련번호 */
	seq NUMBER, /* 글번호 */
	ref NUMBER, /* 그룹번호 */
	lev NUMBER, /* 들여쓰기 */
	step NUMBER, /* 답변정렬 */
	pseq NUMBER, /* 원글번호 */
	reply NUMBER /* 답글갯수 */
);

COMMENT ON TABLE reboard IS '답변게시판';

COMMENT ON COLUMN reboard.rseq IS '답변게시판일련번호';

COMMENT ON COLUMN reboard.seq IS '글번호';

COMMENT ON COLUMN reboard.ref IS '그룹번호';

COMMENT ON COLUMN reboard.lev IS '들여쓰기';

COMMENT ON COLUMN reboard.step IS '답변정렬';

COMMENT ON COLUMN reboard.pseq IS '원글번호';

COMMENT ON COLUMN reboard.reply IS '답글갯수';

CREATE UNIQUE INDEX reboard_rseq_pk
	ON reboard (
		rseq ASC
	);

ALTER TABLE reboard
	ADD
		CONSTRAINT reboard_rseq_pk
		PRIMARY KEY (
			rseq
		);
		
create sequence album_seq
start with 1 increment by 1;	

/* 앨범게시판 */
CREATE TABLE album (
	aseq NUMBER NOT NULL, /* 앨범게시판일련번호 */
	seq NUMBER, /* 글번호 */
	orign_picture VARCHAR2(50), /* 원본사진이름 */
	save_picture VARCHAR2(50), /* 저장사진이름 */
	savefolder VARCHAR2(8), /* 저장폴더 */
	ptype NUMBER(1) /* 사진타입 */
);

COMMENT ON TABLE album IS '앨범게시판';

COMMENT ON COLUMN album.aseq IS '앨범게시판일련번호';

COMMENT ON COLUMN album.seq IS '글번호';

COMMENT ON COLUMN album.orign_picture IS '원본사진이름';

COMMENT ON COLUMN album.save_picture IS '저장사진이름';

COMMENT ON COLUMN album.savefolder IS '저장폴더';

COMMENT ON COLUMN album.ptype IS '사진타입';

CREATE UNIQUE INDEX album_aseq_pk
	ON album (
		aseq ASC
	);

ALTER TABLE album
	ADD
		CONSTRAINT album_aseq_pk
		PRIMARY KEY (
			aseq
		);

create sequence bbs_seq
start with 1 increment by 1;			

/* 자료실 */
CREATE TABLE bbs (
	bseq NUMBER NOT NULL, /* 자료실일련번호 */
	seq NUMBER, /* 글번호 */
	orign_file VARCHAR2(100), /* 원본파일이름 */
	save_file VARCHAR2(100), /* 저장파일이름 */
	savefolder VARCHAR2(8), /* 저장폴더 */
	filesize NUMBER(3,2) /* 파일크기 */
);

COMMENT ON TABLE bbs IS '자료실';

COMMENT ON COLUMN bbs.bseq IS '자료실일련번호';

COMMENT ON COLUMN bbs.seq IS '글번호';

COMMENT ON COLUMN bbs.orign_file IS '원본파일이름';

COMMENT ON COLUMN bbs.save_file IS '저장파일이름';

COMMENT ON COLUMN bbs.savefolder IS '저장폴더';

COMMENT ON COLUMN bbs.filesize IS '파일크기';

CREATE UNIQUE INDEX bbs_bseq_pk
	ON bbs (
		bseq ASC
	);

ALTER TABLE bbs
	ADD
		CONSTRAINT bbs_bseq_pk
		PRIMARY KEY (
			bseq
		);
		
create sequence memo_seq
start with 1 increment by 1;	

/* 댓글 */
CREATE TABLE memo (
	mseq NUMBER NOT NULL, /* 댓글일련번호 */
	seq NUMBER, /* 글번호 */
	id VARCHAR2(16), /* 작성자아이디 */
	name VARCHAR2(20), /* 작성자이름 */
	mcontent VARCHAR2(100), /* 댓글내용 */
	mtime DATE DEFAULT sysdate /* 작성시간 */
);

COMMENT ON TABLE memo IS '댓글';

COMMENT ON COLUMN memo.mseq IS '댓글일련번호';

COMMENT ON COLUMN memo.seq IS '글번호';

COMMENT ON COLUMN memo.id IS '작성자아이디';

COMMENT ON COLUMN memo.name IS '작성자이름';

COMMENT ON COLUMN memo.mcontent IS '댓글내용';

COMMENT ON COLUMN memo.mtime IS '작성시간';

CREATE UNIQUE INDEX memo_mseq_pk
	ON memo (
		mseq ASC
	);

ALTER TABLE memo
	ADD
		CONSTRAINT memo_mseq_pk
		PRIMARY KEY (
			mseq
		);

ALTER TABLE board_list
	ADD
		CONSTRAINT blist_btcode_fk
		FOREIGN KEY (
			btcode
		)
		REFERENCES board_type (
			btcode
		);

ALTER TABLE board_list
	ADD
		CONSTRAINT blist_ccode_fk
		FOREIGN KEY (
			ccode
		)
		REFERENCES category (
			ccode
		);

ALTER TABLE board
	ADD
		CONSTRAINT board_bcode_fk
		FOREIGN KEY (
			bcode
		)
		REFERENCES board_list (
			bcode
		);

ALTER TABLE reboard
	ADD
		CONSTRAINT reboard_seq_fk
		FOREIGN KEY (
			seq
		)
		REFERENCES board (
			seq
		);

ALTER TABLE album
	ADD
		CONSTRAINT album_seq_fk
		FOREIGN KEY (
			seq
		)
		REFERENCES board (
			seq
		);

ALTER TABLE bbs
	ADD
		CONSTRAINT bbs_seq_fk
		FOREIGN KEY (
			seq
		)
		REFERENCES board (
			seq
		);

ALTER TABLE memo
	ADD
		CONSTRAINT memo_seq_fk
		FOREIGN KEY (
			seq
		)
		REFERENCES board (
			seq
		);
		
commit;