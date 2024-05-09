## Section 17: Spring AOP

### 17.305: AOP(관점 지향 프로그래밍)
앱은 보통 계층적으로 만들어진다
- Web layer
- Business layer
- Data layer

그러나 이런 레이어에 상관없이 공통되는 부문이 있다.
- Security
- Performance
- Logging

이런것들을 Cross Cutting Concerns(공통 관심사)라고 한다.
이들을 관리하기 위해 AOP 개념이 나온다.

- AOP에선 우선 공통 관심사항을 aspect로 만든다.
    - logging도 aspect, security도 aspect
- Aspect를 어디 적용할지 명시하는 로직을 정의한다.
    - Point cut

Spring에는 유명한 AOP용 라이브러리가 2개 존재한다.
- Spring AOP
    - Bean을 사용할때 메소드 호출을 intercept해서 로직을 실행
- AspectJ
    - 완벽한 ERP 솔루션인데 잘 안쓴다.
    - 유연성 높음.
    - 아무 Java class로의 method call을 intercept 가능