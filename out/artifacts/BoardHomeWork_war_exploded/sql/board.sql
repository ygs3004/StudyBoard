DROP TABLE board;

DROP SEQUENCE board_seq;
CREATE TABLE board(
    num NUMBER(3) NOT NULL PRIMARY KEY,
    writer VARCHAR2(20),
    email VARCHAR2(50),
    subject VARCHAR2(50),
    password VARCHAR2(30),
    reg_date DATe,
    ref NUMBER(3),
    re_step NUMBER(3),
    re_level NUMBER(3),
    readcount NUMBER(3),
    content VARCHAR2(500)
);

INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);
INSERT INTO board VALUES(board_seq.nextval, 1, 1, 1, 1, SYSDATE, 1, 1, 1, 0, 1);

CREATE SEQUENCE board_seq;
COMMIT;
DELETE FROM board;
SELECT * FROM board;

SELECT * FROM(SELECT A.*,ROWNUM Rnum FROM (SELECT*FROM board ORDER BY ref DESC, re_level DESC) A);
"WHERE Rnum>=? and Rnum<=?;