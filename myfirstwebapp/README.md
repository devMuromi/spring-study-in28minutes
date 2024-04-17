## Section 7: Build Java Web Application
Spring Framework, Spring Boot, Hibernate를 이용하여 Java Web Application을 만들어보자.

### 7.81: @Controller, @ResponseBody
환경: SayHelloController 생성

@RequestMapping("/hello") 맵핑을 이용해 hello-world 생성. 이때 그냥 스트링을 리턴하면 뷰 이름으로 인식해 @ResponseBody를 해줘야 한다.

###