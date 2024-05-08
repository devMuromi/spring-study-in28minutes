## Section 12: Connect React Todo App with Spring Boot REST API

### 12.226: corsConfigurer() 추가

### 12.230: TodoController 추가

### 12.232: Get todo, Delete todo 추가

### 12.239: Put todo, Post todo 추가

### 12.242: Spring Security 설정

### 12.245: OPTIONS 요청 허용하게 설정 변경

### 12.252: JWT
org.springframework.boot:spring-boot-starter-oauth2-resource-server,
org.springframework.boot:spring-boot-configuration-processor 추가

## Section 13: Connect Todo REST API using JPA & Hibernate

### 13.256: JPA, Hibernate 의존성 추가
org.springframework.boot:spring-boot-starter-data-jpa 추가

### 13.257: @Entity, DB 설정 추가
Todo @Entity 추가

### 13.258: TodoRepository 추가
TodoRepository 추가

- public List<Todo> findByUsername(String username); 로 username 필드로 탐색 가능
- JPA의 findById(), deleteById() 이용해서 id탐색, 삭제는 편하게 구현 가능
- JPA에 update() 메소드는 따로 없는데, save() 메소드로 update() 가능
