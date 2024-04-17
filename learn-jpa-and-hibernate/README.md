## Section 6: JPA & Hibernate
### 6.67: H2
application.properties에 h2 설정후, localhost:8080/h2-console 로 접속하여 h2 console 사용 가능.

schema.sql도 구성해준다.

### 6.68: Spring JDBC
JDBC를 사용할때도 SQL 쿼리를 사용한다.
다만 JDBC와 다르게 Spring JDBC는 자바 코드를 훨씬 덜 쓰게 된다.

### 6.69: Spring JDBC로 하드코드된 데이터 삽입
환경: CourseJdbcRepository, CourseJdbcCommandLineRunner class 생성

JdbcTemplate을 이용해 사용 가능.

어플리케이션 실행시 CommandLineRunner 을 클래스가 implements하면 run 메소드를 실행한다.

### 6.70: Spring JDBC로 데이터 삽입/삭제 하기
springJdbcTemplate.update 시 쿼리문에 들어갈 자리를 '?' 로 해두고, 두번째 인자부터 값을 넣어주면 동적으로 변하는 쿼리를 만들 수 있다.