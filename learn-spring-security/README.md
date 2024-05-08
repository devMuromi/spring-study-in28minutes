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
