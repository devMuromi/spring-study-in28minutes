## Section 16: Spring Security

### 16.279
- Spring MVC의 작동방식: request -> dispatcher servlet -> controller
- 여기서: request -> spring security -> dispatcher servlet -> controller

### 16.280: Spring Security 기본 설정
요청을 받았을때 Spring security가 처리하는 일련의 필터를 filter chain이라 한다.
filter chain의 기능들
- Authentication(인증)
- Authorization(권한 부여)
- Other features: CORS, CSRF, login/logout page, exception translate

이러한 필터들은 특정 순서대로 실행된다.
1. CORS, CSRF
2. Authentication
3. Authorization

### 16.281: Start Spring Security Project

### 16.282: Form Authentication
Spring security는 기본적으로 모든 리소스를 보호하고, 존재하지 않는 리소스도 보호해 리소스 존재 여부도 알 수 없게 한다.

기본적으로 Spring security는 폼 인증을 사용한다.
- 폼 인증: 유저:비번 로그인 -> 세션 쿠키 생성 -> 세션 쿠키로 인증

### 16.283: Basic Authentication
- Basic 인증
  - REST API에서 가장 기본적으로 사용하는 방식
  - 단점이 많아서 프로덕션용으로 비추 -> JWT 사용
  - base64로 인코딩된 username:password를 Authorization 헤더에 담아 보낸다
  - 권한 부여 정보는 안담겨 있음
  - 만료일 없음

### 16.284: CSRF(Cross Site Request Forgery)
저장되어 있는 쿠키를 악성 웹사이트가 엑세스해서 위조 요청을 보내는것을 막기 위한 방법
- 이를 해결하기 위한 방법들
  - Synchronizer Token Pattern: 요청마다 토큰을 생성하는 것. 즉 POST, PUT등을 할일이 있으면 이전 요청에서 생긴 토큰으로 처리(Spring Security 기본값)


### 16.285: CSRF in REST API
Spring security 기본 설정에서는 모든 POST, PUT 요청에 CSRF 토큰이 필요.

Thymeleaf를 사용할때는 Spring security가 폼에 CSRF 토큰을 자동으로 생성해준다.

SpringSecurityPlayResource에서 CSRF 토큰을 획득해, POST 요청의 X-CSRF-TOKEN 헤더에 담아 보내면 200 OK를 받을 수 있다.

이렇게 CSRF를 방지하기 위해 CSRF token을 사용하는 방법을 알아보았다.

다만 세션을 사용하지 않는다면 CSRF token은 필요 없다. 즉 상태를 저장하지 않는 REST API에서는 CSRF token을 사용하지 않아도 된다.

### 16.286: Disable CSRF
동기화 토큰 방식이 아닌 Samesite cookie를 이용해 CSRF를 방지할 수 있다.
- server.servlet.session.cookie.same-site=strict

csrf 해제하기
- filterChain
  - http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
  - http.sessionManagement 의 SessionCreationPolicy
    - ALWAYS: 항상 세션 생성
    - IF_REQUIRED: 필요할때만 세션 생성
    - NEVER: 세션 생성하지 않음. 다만 있으면 사용
    - STATELESS: 세션 생성하지 않음, 사용도 안함
  - http.csrf().disable(); CSRF 해제
  - http.formLogin(); 폼 로그인. 사용하지 않으면 더이상 /login /logout 페이지를 사용할 수 없다.

### 16.287: CORS
- CORS 허용하는 방법
  - 글로벌 설정. addCorsMappings callback method를 WebMvcConfigurer에 추가
  - 컨트롤러별 설정. @CrossOrigin 사용

### 16.288: In Memory Credential
이때까지는 application.properties에 credential(user, password)를 저장했다.
이제 메모리에 저장해보자

- Credential 저장 방식
  - In memory: production용으로는 비추천
  - Database: JDBC/JPA
  - LDAP(Lightweight Directory Access Protocol)

InMemoryUserDetailsManager 를 이용해 in memory credential을 사용할 수 있다.

### 16.289: Credential with JDBC
org.springframework.boot:spring-boot-starter-jdbc, com.h2database:h2 추가

DataSource를 설정하고 JdbcUserDetailsManager를 사용해 JDBC로 credential을 저장할 수 있다.

### 16.291: BCrypt Password Encoder
- 최근에는 SHA-256도 안전하지 않음
- 권장 사항은 one way hash function, 1초 이상의 work factor
- PasswordEncoder: 단방향 패스워드 변환하는 interface
  - BCryptPasswordEncoder

### 16.292: JWT Authentication
JWT에서 key를 이용해 암호화와 복호화를 할 수 있다. JWT에서는 비대칭 키를 쓰는것이 정석.
- JWT 생성: encoding -> user credentials, user data(payload), RSA key pair
- Request header에 포함해서 전송

### 16.293: JWT Auth with Spring Security 1
1. Create key pair
2. Create RSA key object usin key pair
3. Create JWKSource(JSON Web Key Source)
4. Use RSA public key for decoding
5. Use JWKSource for encoding

org.springframework.boot:spring-boot-starter-oauth2-resource-server 추가

- OAuth2 리소스 서버 설정 -> http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
- 리소스 서버가 jwt를 받으면 디코드하기 위해 디코더 필요

### 16.294: JWT Auth with Spring Security 2
openssl로 RSA public/private key pair 생성 가능.
그러나 우리는 코드로 만들거고, java.security.KeyPairGenerator를 사용해 key pair를 생성한다.
- KeyPairGenerator 를 이용해 키 페어 생성
- RSA 인코딩/디코딩을 위해 nimbus 라이브러리 사용
- 키 페어를 이용해 RSA 키 객체 생성
- JWKSource 만들기. JSON 키 여러개가 있는 JWKSet을 만들 수 있는데, 우리는 RSA key 하나만 넣고 만들것
- 이후 JWKSet으로 JWKSource 만들기

### 16.295: JWT Resource with Spring Security 1
이떄까지는 JWT 검증을 다루었다. 이제 JWT를 만들어보자.
JWT 생성을 위해 JWT 리소스를 만들것

우선 기본인증을 통해 유저:비밀번호를 보내 JWT를 받고, 이후 REST API 인증에서는 JWT를 Bearer 토큰으로 활용할 것이다

우선 basic 인증에서 Authentication을 받아서 리턴해본다

### 16.296: JWT Resource with Spring Security 2
JwtAuthenticationResource 참고

### 16.297: Spring Security Authentication
- AuthenticationManager: 인증을 담당하는 인터페이스. 요청에 대해 인증을 시도하고, Authentication 객체와 권한을 반환

Spring Security에서 인증이란
1. 자격 증명(credentials): username, password
2. 주체(principal): 사용자에 대한 세부정보
3. 권한(authorities): 사용자가 가지고 있는 권한

authenticate() 메소드 호출 전에는 Authentication에는 자격 증명만 포함되어 있다. 성공적으로 실행되면 주체와 권한도 포함하게 된다.

- AuthenticationManager는 인증을 하며 수많은 AuthenticationProvider들과 상호작용을 한다. 우리는 JwtAuthenticationProvider를 사용했다
- AuthenticationProvider들이 대화하는 인터페이스가 UserDetailsService이다. 
- 인증에 성공했을때 인증 결과는 SecurityContextHolder에 저장된다. 그 안에는 SecurityContext가 있다. SecurityContext안에 Authentication이 저장된다.

### 16.298: Exploring Spring Security Authentication
Spring Security 인증에는 두가지 접근법이 있다
- Global Security
  - authorizeHttpRequests에서 설정 가능
  - auth.requestMatchers("/users/").hasRole("USER") 등으로 설정가능
  - hasRole, hasAuthority, hasAnyAuthority, isAuthenticated 등의 매처 사용 가능
- Method Security
  - @EnableMethodSecurity 로 활성화 가능
  - @Pre, @Post 어노테이션 사용 가능
    - @PreAuthorize("hasRole('USER') and #username == authentication.name") 등으로 설정가능
    - @PostAuthorize("returnObject.username == 'muromi'") 등으로 리턴 객체 검증가능
  - JSR-250 annotations
    - @EnableMethodSecurity(jsr250Enabled = true) 로 활성화 
    - @RolesAllowed({"ADMIN", "USER"}) 등으로 설정가능
  - 과거의 @Secured annotation도 사용 가능
    - @EnableMethodSecurity(securedEnabled = true) 로 활성화
    - @Secured({"ADMIN", "USER"}) 등

추천하는건 @Pre, @Post. 유연성이 높아지고 요즘 자주 쓰는 방식.
표준을 준수해야한다면 JSR-250도 좋다.