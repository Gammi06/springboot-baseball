# baseball DB연결 세팅

### 의존성 주입
```
- Spring Boot DevTools
- Lombok
- Mybatis Framework
- MySQL Driver
- Mustache
- Spring Web
```

### 설정방법
- 추가예정


### MariaDB 사용자(bsa) 생성 및 권한 주기
```sql
CREATE USER 'bsa'@'%' IDENTIFIED BY 'bb1234';
CREATE DATABASE baseballdb;
GRANT ALL PRIVILEGES ON baseballdb.* TO 'bsa'@'%';
```


### 테이블 생성 (1) - 연습용
```sql
CREATE TABLE grounds(
	id INT PRIMARY KEY AUTO_INCREMENT,
	groundname VARCHAR(20) UNIQUE,
	createdAt TIMESTAMP
);

CREATE TABLE teams(
	id INT PRIMARY KEY AUTO_INCREMENT,
	groundname VARCHAR(20),
	teamname VARCHAR(20) UNIQUE,
	createdAt TIMESTAMP
);

CREATE TABLE players(
    id INT PRIMARY KEY AUTO_INCREMENT,
    teamname VARCHAR(20),
    position VARCHAR(20),
    playername VARCHAR(20),
    createdAt TIMESTAMP
);

CREATE TABLE outers(
	id INT PRIMARY KEY AUTO_INCREMENT,
	teamname VARCHAR(20),
   position VARCHAR(20),
   playername VARCHAR(20),
   reason VARCHAR(20),
   createdAt TIMESTAMP
);
```


### 테이블 생성 (2) + FOREIGN KEY
```sql
DROP TABLE grounds;

CREATE TABLE grounds(
	id INT PRIMARY KEY AUTO_INCREMENT,
	groundname VARCHAR(20) UNIQUE,
	createdAt TIMESTAMP
);

CREATE TABLE teams(
	id INT PRIMARY KEY AUTO_INCREMENT,
	groundname VARCHAR(20),
	teamname VARCHAR(20) UNIQUE,
	createdAt TIMESTAMP,
	FOREIGN KEY (groundname) REFERENCES grounds(groundname)
);

CREATE TABLE players(
    id INT PRIMARY KEY AUTO_INCREMENT,
    teamname VARCHAR(20),
    position VARCHAR(20),
    playername VARCHAR(20),
    createdAt TIMESTAMP,
    FOREIGN KEY (teamname) REFERENCES teams(teamname)
);

CREATE TABLE outers(
	id INT PRIMARY KEY AUTO_INCREMENT,
	teamname VARCHAR(20),
   position VARCHAR(20),
   playername VARCHAR(20),
   reason VARCHAR(20),
   createdAt TIMESTAMP
);
```


### 더미데이터 추가 - 연습용
```sql
INSERT INTO grounds(groundname, createdAt) VALUES('그린야구장', NOW());
INSERT INTO grounds(groundname, createdAt) VALUES('아카야구장', NOW());
INSERT INTO grounds(groundname, createdAt) VALUES('데미야구장', NOW());

INSERT INTO teams(groundname, teamname, createdAt) VALUES('그린야구장', '쿠크다스', NOW());
INSERT INTO teams(groundname, teamname, createdAt) VALUES('아카야구장', '몽셀', NOW());
INSERT INTO teams(groundname, teamname, createdAt) VALUES('데미야구장', '엄마손', NOW());

INSERT INTO players(teamname, position, playername, createdAt) VALUES('쿠크다스', '코치', '크라운', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('쿠크다스', '투수', '신지원', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('쿠크다스', '포수', '이현지', NOW());

INSERT INTO players(teamname, position, playername, createdAt) VALUES('몽셀', '코치', '롯데', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('몽셀', '투수', '홍연지', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('몽셀', '외야수', '심주영', NOW());

INSERT INTO players(teamname, position, playername, createdAt) VALUES('엄마손', '코치', '해태', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('엄마손', '내야수', '한성유', NOW());
INSERT INTO players(teamname, position, playername, createdAt) VALUES('엄마손', '외야수', '임수현', NOW());

INSERT INTO outers(teamname, position, playername, reason, createdAt) VALUES('엄마손', '투수', '정승현', '노쇠', NOW());

COMMIT;
```


### 쿼리
```sql

```