TIL (7/25 - 7/31)

* 새롭게 알게된 것들 위주로 정리 (+ 자주 잊는것 위주)
* 강의 자료에 강의 내용이 다 기록이 되어있음



## 단축키

* 단축키: shift + F6: rename
* 단축키: Ctrl + T: refactor 단축키



## 템플릿 엔진 동작 환경 그림

![템플릿 엔진 동작 환경](https://github.com/minhee0327/daou-be-study/blob/main/spring-intro/src/main/resources/static/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-07-30%20%EC%98%A4%EC%A0%84%208.43.13.png)

* 컨트롤러에서 리턴값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아 처리
  * 스프링 부트 템플린 엔진의 기본 viewName 매핑
  * `resources:templates/` + [ViewName] + `.html`

* `@ResponseBody` 를 사용하면 뷰리졸버(view Resolver)를 사용하지 않는다.
  대신, HTTP의 Body에 문자 내용을 직접 반환한다.



![@ResponseBody 사용원리](https://github.com/minhee0327/daou-be-study/blob/main/spring-intro/src/main/resources/static/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-07-30%20%EC%98%A4%EC%A0%84%208.51.53.png)

> `spring-boot-devtools` 라이브러리 추가시 html 파일 컴파일만 해주면 서버 재시작없이 view 파일에 대한 변경이 가능하다



## 빌드 및 실행

콘솔에서

* `.gradlew build`
* `cd build/libs`
* `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
* 실행확인





## 정적 컨텐츠

![정적컨텐츠 이미지](https://github.com/minhee0327/daou-be-study/blob/main/spring-intro/src/main/resources/static/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-07-30%20%EC%98%A4%EC%A0%84%208.48.55.png)





## 스프링 빈과 의존관계

### 스프링 빈을 등록하는 2가지 방법

- 컴포넌트 스캔과 자동의존관계 설정 (`@Component`, `@Service`, `@Controller`...)+ `@Autowired`

  - `@Component` 와 관계있는 빈들을 먼저 스프링 컨테이너에 띄움
  - `@Autowired` 로 연관관계를 맺어줌

- 자바 코드로 직접 스프링 빈 등록하기

  ```java
  @Configuration
  public class SpringConfig {
      
      @Bean
      public MemberService memberService(){
          return new MemberService(memberRepository());
      }
      
      @Bean
      public MemberRepository memberRepository(){
          return new MemoryMemberRepository(); 
      }
  }
  
  ```

  

### DI 방법 3가지

* setter, 필드 주입, 생성자 주입
  * 필드 주입: 다른 인스턴스로 변경할 수 없어서 비추
  * Setter 주입: 중간에 public하게 노출되어 변경될 경우 문제가 생길 수 있다.
  * 생성자 주입:  App 로딩시점에 주입만 하면되니까 생성자 주입이 좋다. (의존관계가 실행중에 동적으로 변하는 경우가 거의 없어 생성자 주입을 권장한다.)



> 참고:: 실무에서 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
> 정형화 되지 않거나 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.

> 주의:: `@Autowired` 를 통한 DI는 `helloController`, `MemberService` 와 같이 
> 스프링이 관리하는 객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.





## 회원관리 예제 - 웹 MVC

> 컨트롤러가 정적 파일





## AOP

### AOP가 필요한 상황

* 모든 메소드의 호출 시간을 측정하고 싶다면?
* 공통 관심사항 (cross-cutting concern) vs 핵심 관심 사항(core concern)
* 회원 가입 시간, 회원 조회 시간을 측정하고 싶다면?



예시 -> 각 메서드별로 측정 시간 궁금해 라고 사장님이 말했다! (직접 모든 메서드에 시간측정 코드를 추가해보자)

* 시간을 측정하는것은 각 메서드의 핵심 관심 사항이 아니다.
* 시간을 측정하는 것은 공통의 관심사항이다.
* 핵심로직 + 시간을 측정하는 로직이 섞여 있어서 유지보수가 어려워진다.
* 시간을 측정하는 로직을 별도의 공동 로직으로 만들기가 어렵다
* 시간측정 로직을 변경할 때 모든 로직을 찾아가면서 변경해야한다.



이런경우 사용하는게 AOP!

### AOP 적용

* AOP: Aspect Oriented Programming
* 공통관심사항과 핵심관심사항 분리

![스크린샷 2022-07-30 오후 1.26.05](/Users/minhee/IdeaProjects/daou-be-study/spring-intro/src/main/resources/static/스크린샷 2022-07-30 오후 1.26.05.png)

---



## Next

- [ ] Tomcat 서버
- [ ] build.gradle (maven), dsl에 대해서
- [ ] cglib



