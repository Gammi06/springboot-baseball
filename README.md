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
    stadiumsName VARCHAR(20),
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
    positions VARCHAR(20)
);

CREATE TABLE reasons(
    id INT PRIMARY KEY AUTO_INCREMENT,
    reasons VARCHAR(20)
);

```


### 더미데이터 추가
```sql

insert into teams(teamsName, stadiumsId, createdAt) VALUES('기아타이거즈', 1, NOW());
insert into teams(teamsName, stadiumsId, createdAt) VALUES('롯데자이언츠', 2, NOW());
insert into teams(teamsName, stadiumsId, createdAt) VALUES('엘지트윈스', 3, NOW());

insert into positions(positions) VALUES('타자');
insert into positions(positions) VALUES('투수');
insert into positions(positions) VALUES('외야수');
insert into positions(positions) values('내야수');

insert into reasons(reasons) values('자진사퇴');
insert into reasons(reasons) values('성적부진');
insert into reasons(reasons) values('태도불량');

insert into stadiums(stadiumsName, createdAt) VALUES('광주 기아 챔피언스 필드', NOW());
insert into stadiums(stadiumsName, createdAt) VALUES('사직 야구장', NOW());
insert into stadiums(stadiumsName, createdAt) VALUES('잠실 야구장', NOW());

insert into players(playersName, teamsId, positionsId, createdAt) VALUES('김진욱', 2, 2, NOW());
insert into players(playersName, teamsId, positionsId, createdAt) VALUES('안치홍', 2, 4, NOW());
insert into players(playersName, teamsId, positionsId, createdAt) VALUES('전준우', 2, 3, NOW());
insert into players(playersName, teamsId, positionsId, createdAt) VALUES('심동섭', 1, 2, NOW());

insert into expulsions(playersName, teamsId, positionsId, reasonsId, createdAt) VALUES('임창용', 1, 2, 3, NOW());

COMMIT;

```


### 쿼리
```sql

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId;

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId
WHERE p.positionsId = 2
ORDER BY createdAt DESC;

SELECT p.id, p.playersName, t.teamsName, po.positions, p.createdAt
FROM players p
LEFT OUTER JOIN teams t ON t.id = p.teamsId
LEFT OUTER JOIN positions po ON po.id = p.positionsId
WHERE p.id = 2;

SELECT e.id, e.playersName, t.teamsName, po.positions, r.reasons, e.createdAt
FROM expulsions e
LEFT OUTER JOIN teams t ON t.id = e.teamsId
LEFT OUTER JOIN positions po ON po.id = e.positionsId
LEFT OUTER JOIN reasons r ON r.id = e.reasonsId;

SELECT s.id, s.stadiumsName, s.createdAt
FROM stadiums s;

SELECT t.id, t.teamsName, s.stadiumsName, t.createdAt
FROM teams t
LEFT OUTER JOIN stadiums s ON s.id = t.id;

```