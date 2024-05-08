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