# baseball DB연결 세팅


### MariaDB 사용자(bsa) 생성 및 권한 주기
```sql

CREATE USER 'bsa'@'%' IDENTIFIED BY 'bb1234';
CREATE DATABASE baseballdb;
GRANT ALL PRIVILEGES ON baseballdb.* TO 'bsa'@'%';

```


### 테이블 생성
```sql

CREATE TABLE teams(
    id INT PRIMARY KEY AUTO_INCREMENT,
    teamsName VARCHAR(20) UNIQUE,
    stadiumsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE stadiums(
    id INT PRIMARY KEY AUTO_INCREMENT,
    stadiumsName VARCHAR(20) UNIQUE,
    createdAt TIMESTAMP
);

CREATE TABLE players(
    id INT PRIMARY KEY AUTO_INCREMENT,
    playersName VARCHAR(20),
    teamsId INT,
    positionsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE expulsions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    playersName VARCHAR(20),
    teamsId INT,
    positionsId INT,
    reasonsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE positions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    positions VARCHAR(20) UNIQUE,
    createdAt TIMESTAMP
);

CREATE TABLE reasons(
    id INT PRIMARY KEY AUTO_INCREMENT,
    reasons VARCHAR(20) UNIQUE,
    createdAt TIMESTAMP
);

```


### 더미데이터 추가
```sql

INSERT INTO teams(teamsName, stadiumsId, createdAt) VALUES('기아타이거즈', 1, NOW());
INSERT INTO teams(teamsName, stadiumsId, createdAt) VALUES('롯데자이언츠', 2, NOW());
INSERT INTO teams(teamsName, stadiumsId, createdAt) VALUES('엘지트윈스', 3, NOW());

INSERT INTO positions(positions, createdAt) VALUES('타자', NOW());
INSERT INTO positions(positions, createdAt) VALUES('투수', NOW());
INSERT INTO positions(positions, createdAt) VALUES('외야수', NOW());
INSERT INTO positions(positions, createdAt) VALUES('내야수', NOW());

INSERT INTO reasons(reasons, createdAt) VALUES('자진사퇴', NOW());
INSERT INTO reasons(reasons, createdAt) VALUES('성적부진', NOW());
INSERT INTO reasons(reasons, createdAt) VALUES('태도불량', NOW());

INSERT INTO stadiums(stadiumsName, createdAt) VALUES('광주 기아 챔피언스 필드', NOW());
INSERT INTO stadiums(stadiumsName, createdAt) VALUES('사직 야구장', NOW());
INSERT INTO stadiums(stadiumsName, createdAt) VALUES('잠실 야구장', NOW());

INSERT INTO players(playersName, teamsId, positionsId, createdAt) VALUES('김진욱', 2, 2, NOW());
INSERT INTO players(playersName, teamsId, positionsId, createdAt) VALUES('안치홍', 2, 4, NOW());
INSERT INTO players(playersName, teamsId, positionsId, createdAt) VALUES('전준우', 2, 3, NOW());
INSERT INTO players(playersName, teamsId, positionsId, createdAt) VALUES('심동섭', 1, 2, NOW());

INSERT INTO expulsions(playersName, teamsId, positionsId, reasonsId, createdAt) VALUES('임창용', 2, 2, 3, NOW());

COMMIT;

```


### 쿼리
```sql

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId
ORDER BY t.createdAt DESC;

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId
ORDER BY po.createdAt DESC;

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId
ORDER BY createdAt DESC;	
	
UPDATE expulsions SET expulsions.reasonsId = 3
WHERE expulsions.id = 1;

SELECT e.id, e.playersName, t.teamsName, po.positions, r.reasons, e.createdAt
FROM expulsions e
LEFT OUTER JOIN teams t ON t.id = e.teamsId
LEFT OUTER JOIN positions po ON po.id = e.positionsId
LEFT OUTER JOIN reasons r ON r.id = e.reasonsId
ORDER BY t.createdAt DESC;

SELECT t.id, t.teamsName, s.stadiumsName, t.createdAt
FROM teams t
LEFT OUTER JOIN stadiums s ON s.id = t.stadiumsId
ORDER BY t.createdAt DESC;

```