

DROP TABLE IF EXISTS emp;

-- 테이블 레벨에서 사용할 CHARACTER SET, COLLATE 값을 지정하면
-- test 디비에서도 한글을 사용할 수 있다.
CREATE TABLE emp (
	empno INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	ename VARCHAR(100),
	job VARCHAR(100),
	sal DOUBLE
) ENGINE=InnoDB CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

--DROP TABLE IF EXISTS member;

--CREATE TABLE member SELECT * FROM emp WHERE 1=0;
