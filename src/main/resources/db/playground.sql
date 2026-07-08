-- 1) DB 생성
CREATE DATABASE IF NOT EXISTS playground
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE playground;

-- 2) 테이블 초기화
DROP TABLE IF EXISTS MEMO;

CREATE TABLE MEMO (
    ID          INT          NOT NULL PRIMARY KEY,
    TITLE       VARCHAR(200) NOT NULL,
    CONTENT     VARCHAR(500) NOT NULL,
    STATUS      VARCHAR(20)  NOT NULL DEFAULT 'READY',
    CREATED_AT  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT  DATETIME     NULL,
    DEL_YN      CHAR(1)      NOT NULL DEFAULT 'N'
);

-- 3) 테스트 데이터 (STATUS = Vue common.js 코드값)
INSERT INTO MEMO (ID, TITLE, CONTENT, STATUS) VALUES
(1, '첫 번째 메모',   'Vue + Spring 연습용 테스트 데이터입니다.', 'READY'),
(2, '진행 중인 작업', 'UI 컴포넌트 작업 중',                    'ING'),
(3, '완료된 항목',    '메모 CRUD API 연동 완료',                'DONE'),
(4, '보류 메모',      '나중에 다시 볼 내용',                    'HOLD');

-- 4) 확인 (앱 목록과 동일 조건)
SELECT ID, TITLE, CONTENT, STATUS, CREATED_AT, UPDATED_AT, DEL_YN
  FROM MEMO
 WHERE DEL_YN = 'N'
 ORDER BY ID;

-- DB 추가
INSERT INTO MEMO (ID, TITLE, CONTENT, STATUS) VALUES
(5,  '테스트 메모 5',  '페이지네이션 연습', 'READY'),
(6,  '테스트 메모 6',  '페이지네이션 연습', 'ING'),
(7,  '테스트 메모 7',  '페이지네이션 연습', 'DONE'),
(8,  '테스트 메모 8',  '페이지네이션 연습', 'HOLD'),
(9,  '테스트 메모 9',  '페이지네이션 연습', 'READY'),
(10, '테스트 메모 10', '페이지네이션 연습', 'ING'),
(11, '테스트 메모 11', '페이지네이션 연습', 'READY'),
(12, '테스트 메모 12', '페이지네이션 연습', 'ING'),
(13, '테스트 메모 13', '페이지네이션 연습', 'DONE'),
(14, '테스트 메모 14', '페이지네이션 연습', 'HOLD'),
(15, '테스트 메모 15', '페이지네이션 연습', 'READY'),
(16, '테스트 메모 16', '페이지네이션 연습', 'ING'),
(17, '테스트 메모 17', '페이지네이션 연습', 'DONE'),
(18, '테스트 메모 18', '페이지네이션 연습', 'HOLD'),
(19, '테스트 메모 19', '페이지네이션 연습', 'READY'),
(20, '테스트 메모 20', '페이지네이션 연습', 'ING'),
(21, '테스트 메모 21', '페이지네이션 연습', 'READY'),
(22, '테스트 메모 22', '페이지네이션 연습', 'DONE'),
(23, '테스트 메모 23', '페이지네이션 연습', 'HOLD'),
(24, '테스트 메모 24', '페이지네이션 연습', 'READY'),
(25, '테스트 메모 25', '페이지네이션 연습', 'ING');

 ----------------------------------
 --------- 동작확인용 쿼리 ----------
 ----------------------------------

 USE playground;

-- Read (목록)
SELECT ID, TITLE, CONTENT, STATUS
  FROM MEMO
 WHERE DEL_YN = 'N'
 ORDER BY ID;

-- Create (앱 insertMemo 와 비슷)
INSERT INTO MEMO (ID, TITLE, CONTENT, STATUS)
VALUES (
  (SELECT COALESCE(MAX(ID), 0) + 1 FROM MEMO),
  'DBeaver에서 추가', '수동 INSERT 테스트', 'READY'
);

-- Update
UPDATE MEMO
   SET TITLE = '수정된 제목'
     , CONTENT = '수정된 내용'
     , STATUS = 'ING'
     , UPDATED_AT = CURRENT_TIMESTAMP
 WHERE ID = 1;

-- Delete (앱은 soft delete)
UPDATE MEMO
   SET DEL_YN = 'Y'
     , UPDATED_AT = CURRENT_TIMESTAMP
 WHERE ID = 4;

-- 한페이지만 확인
SELECT ID, TITLE, CONTENT, STATUS
  FROM MEMO
 WHERE DEL_YN = 'N'
 ORDER BY ID
 LIMIT 5 OFFSET 0;

-- 다음페이지 확
SELECT ID, TITLE, CONTENT, STATUS
  FROM MEMO
 WHERE DEL_YN = 'N'
 ORDER BY ID
 LIMIT 5 OFFSET 5;