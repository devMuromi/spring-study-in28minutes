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

### 6.71: Spring JDBC로 데이터 조회하기
.queryForObject()를 쿼리로 결과가 하나만 나오는 경우 사용 가능.

이때 두번째 파라메터에는 RowMapper를 넣어주어야 한다. RowMapper는 쿼리 결과를 Bean으로 매핑해주는 역할을 한다.

### 6.72: JPA, EntityManager
환경: CourseJpaRepository 추가

JDBC를 사용해보니 쿼리를 직접 작성해야해서 점점더 복잡해진다. 

이제 JPA를 활용해서 Course Bean을 데이터베이스의 테이블로 바로 맵핑해보겠다.
이떄 @Entity 로 엔티티임을 보이고, @Id, @Column등을 이용해 값들도 맵핑한다. 이때 사실 이름이 같다면 굳이 @Column(name="")을 사용하지 않아도 된다.

CourseJpaRepository를 생성하고 EntityManager를 불러와, merge(), find(), remove() 등을 사용해 구현했다.

### 6.74: Spring Data JPA
환경: CourseSpringDataJpaRespository 생성

Spring Data JPA를 쓰면 EntityManager 마저 없이 JPA를 더 쉽게 사용 가능하다.

CourseSpringDataJpaRespository는 인터페이스로 JpaRepository<엔티티, id타입>을 상속받아 사용한다.

이때 러너에서 insert() -> save()로 함수만 바꿔주자.

### 6.75: Spring Data JPA 커스텀 메소드
커스텀 메서드도 정의할 수 있다. 명명규칙을 따라 메소드를 만들어주자.