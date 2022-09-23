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
    teamName VARCHAR(20) UNIQUE,
    createdAt TIMESTAMP
);

CREATE TABLE stadiums(
    id INT PRIMARY KEY AUTO_INCREMENT,
    stadiumName VARCHAR(20),
    teamsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE players(
    id INT PRIMARY KEY AUTO_INCREMENT,
    playerName VARCHAR(20),
    teamsId INT,
    positionsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE expulsions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    playerName VARCHAR(20),
    teamsId INT,
    positionId INT,
    reasonsId INT,
    createdAt TIMESTAMP
);

CREATE TABLE positions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    positions VARCHAR(20)
);

CREATE TABLE reasons(
    id INT PRIMARY KEY AUTO_INCREMENT,
    reason VARCHAR(20)
);
```


### 더미데이터 추가 - 연습용
```sql

insert into teams(teamName, createdAt) values('기아타이거즈', NOW());
insert into teams(teamName, createdAt) values('롯데자이언츠', NOW());
insert into teams(teamName, createdAt) values('엘지트윈스', NOW());

insert into positions(positions) VALUES('타자');
insert into positions(positions) VALUES('투수');
insert into positions(positions) VALUES('외야수');
insert into positions(positions) values('내야수');

insert into reasons(reason) values('자진사퇴');
insert into reasons(reason) values('성적부진');
insert into reasons(reason) values('태도불량');

insert into stadiums(stadiumName, teamsId, createdAt) VALUES('광주 기아 챔피언스 필드', 1, NOW());
insert into stadiums(stadiumName, teamsId, createdAt) VALUES('사직 야구장', 2, NOW());
insert into stadiums(stadiumName, teamsId, createdAt) VALUES('잠실 야구장', 3, NOW());

insert into players(playerName, teamsId, positionsId, createdAt) VALUES('김진욱', 2, 2, NOW());
insert into players(playerName, teamsId, positionsId, createdAt) VALUES('안치홍', 2, 4, NOW());
insert into players(playerName, teamsId, positionsId, createdAt) VALUES('전준우', 2, 3, NOW());
insert into players(playerName, teamsId, positionsId, createdAt) VALUES('심동섭', 1, 2, NOW());

insert into expulsions(playerName, teamsId, positionId, reasonsId, createdAt) VALUES('임창용', 1, 2, 3, NOW());

```


### 쿼리
```sql



```