# 스프링 핵심 원리

* 객체지향 + 스프링
* 스프링의 핵심 가치: 객체 지향 프로그래밍
* 스프링이 왜 만들어졌는지, 스프링이 없을때 코드를 작성하고 -> 객체지향 원리를 적용해나가기
* 왜 스프링 컨테이너가 필요한지 알 수 있다.



## Toc

* [x] 객체 지향 설계와 스프링 (6개, 78분) 22.8.1
* [x] 스프링 핵심 원리 이해1 : 에제 만들기 (8강, 61분) 22.8.2
* [x] 스프링 핵심 원리 이해2: 객체지향 원리 적용 (9강, 98분) 22.8.4
* [x] 스프링 컨테이너와 스프링 빈 (8강, 79분) 22.8.5
* [x] 싱글톤 컨테이너 (6강, 75분) 22.8.5 ~저녁젼
* [x] 컴포넌트 스캔 (4강, 51분) 22.8.6 ~저녁 후
* [x] 의존관게 자동 주입 (9강, 113분) 22.8.8 저녁
* [x] 빈 생명주기 콜백 (4강, 35분) 22.8.9 저녁
* [x] 빈 스코프 (8강, 104) 22.8.9(2) -8.10 (6) 



## 1. 객체지향 설계와 스프링

### 1) 객체 지향 설계와 스프링

* 스프링 프레임워크
  * **핵심기술**: 스프링 DI 컨테이너, AOP, 이벤트, 기타
  * 웹기술: 스프링 MVC, 스프링 WebFlux
  * 데이터 접근 기술: 트랜잭션, JDBC, ORM, XML
  * 기술 통합: 캐시, 이메일, 원격 접근, 스케쥴링
  * 테스트: 스프링 기반 테스트 지원
  * 언어: 코틀린, 그루비

* 스프링 부트
  * 스프링을 편리하게 사용하도록 지원, 최근에는 기본으로 사용한다.
  * 단독으로 실행할 수 있는 스프링 앱을 쉽게 생성. Tomcat과 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 된다. 
  * 손쉬운 빌드 구성을 위한 starter 종속성 제공
    예전에는 스프링 프레임워크를 사용하려면 이전에 사용해야하는 라이브러리들이 많았는데 starter로 한번에 필요한것들을 땡겨쓸수있다.
  * 스프링과 3rd party(외부) 라이브러리 자동구성
  * 메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공
    운영환경에서 모니터링은 중요한데, 스프링이 기본적으로 제공을 해줍니다.
  * 관례에 의한 간결한 설정
* 스프링이라는 단어는 문맥에 따라 다르게 사용된다.
  * 스프링 DI 컨테이너 기술
  * 스프링 프레임워크
  * 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계



> 스프링 핵심 개념이 뭔데? 컨셉이란?
>
> - 스프링은 자바 언어 기반의 프레임워크
> - 자바 언어의 가장 큰 특징: 객체 지향 언어
> - 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
> - 스프링은 **좋은 객체 지향 애플리케이션** 개발을 할 수 있게 도와주는 프레임워크





### 좋은 객체 지향 설계의 5가지 원칙 SOLID 

#### SRP

* 한 클래스는 하나의 책임만 가져야한다.
* 하나의 책임이라는 것은 모호하다
  * 클수도, 작을수도, 문맥에 따라 상황에따라 다름
* **중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 SRP를 잘 따른것**



#### OCP

* 확장엔 열려있고 변경엔 닫혀있다. -> 무슨말이냐?

* **다형성**

* 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현 (기존코드를 변경하는게 아님)
  설계의 중요성을 강조하는것.

* 문제점: MemberService 클라이언트가 구현 클래스를 직접 선택

  ```
  MemberRepository m = new MemoryMemberRepository(); //기존 코드
  MemberRepository m = new JdbcMemberRepository(); //변경 코드
  ```

  * **구현 객체를 변경하려면 클라이언트 코드를 변경해야함.**
  * 다형성을 사용했지만 OCP 원칙을 지킬 수 없다. 어떻게 해결?
    * 객체 생성 및 연관관계를 맺어주는 별도의 조립, 설정자가 필요 (스프링 컨테이너, IoC, DI가 필요한거)

  

#### LSP

* 프로그램의 객체는 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야한다.
* 컴파일단에서만의 이야기가 아니다. 규약을 맞춰서 기능적인것을 보장해야한다.
* 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야한다는 것.
  다형성을 지원하기 위한 원칙. 
  인터페이스를 구현한 구현체는 믿고 사용하려면 이 원칙이 필요하다.



#### ISP

* 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나보다 낫다
  * 자동차 -> 운전/정비
  * 사용자 -> 운전자/정비사



#### DIP

* 추상화에 의존해야지 구체화에 의존하면 안된다.
  의존성 주입은 이 원칙을 따르는 방법중 하나다.
* 쉽게 이야기해서 구현 클래스에 의존하지 않고 역할(인터페이스)에 의존



> MemberService -> MemberRepository(I) 도 의존-> **구현 클래스에도 동시 의존**
>
> * MemberService 클라이언트가 구현 클래스를 직접 선택하는 것은 DIP를 위반한다.

> 정리)
>
> * 다형성 만으로는 쉽게 부품을 갈아끼우듯이 개발할 수 없다.
>
>   다형성만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.
>   다형성 만으로는 OCP, DIP를 지킬 수 없다. 앞으로 이걸 어떻게 해결하게 되는지 알아보자



### 객체 지향 설계와 스프링

스프링은 다음 기술로 다형성과 OCP + DIP 를 가능하게 지원한다.

* DI (Dependency Injection) : 의존관계, 의존성 주입
* DI 컨테이너 제공

클라이언트 코드의 변경 없이 기능 확장

쉽게 부품을 교체하듯 개발



모든 설계에 **역할**과 **구현**을 분리하자. 

* 자동차, 공연의 예를 떠올려보자.
* 애플리케이션 설계도 공연을 설계 하듯이 배역만 만들어두고, 배우는 언제든지 **유연**하게 **변경**할 수 있도록 만드는 것이 좋은 객체 지향 설계다. 이상적으로는 모든 설계에 인터페이스를 부여하자 



실무 고민

* 인터페이스를 도입하면 추상화라는 비용이 발생한다. (개발코드를 한번 더 열어봐야함)
  구현 클래스를 계속 들어가서 찾아야함.
* 기능을 확장할 가능성이 없다면, 구체클래스를 직접 사용하고
  향후 꼭 필요할 때 리팩터링 해서 인터페이스를 도입하는것도 방법이다.



## 2. 스프링 핵심원리 이해1: 예제 만들기

### Project

* Group: domain 주소
* Artifact: 빌드명
* Group, artifact -> package name 결정됨



### 비즈니스 요구사항과 설계

* 회원
  * 회원을 가입하고 조회할 수 있다.
  * 회원은 일반과 VIP 두 가지 등급이 있다.
  * 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)

* 주문과 할인 정책
  * 회원은 상품을 주문할 수 있다.
  * 회원 등급에 따라 할인 정책을 적용할 수 있다.
  * 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. 
    (나중에 변경 될 수 있다.)
  * 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을

미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)



요구사항을 보면 회원 데이터, 할인 정책 같은 부분은 지금 결정하기 어려운 부분이다. 
그렇다고 이런 정책이 결정될 때 까지 개발을 무기한 기다릴 수 도 없다. 
우리는 앞에서 배운 객체 지향 설계 방법이 있지 않은가!

인터페이스를 만들고 구현체를 언제든지 갈아끼울 수 있도록 설계하면 된다. 그럼 시작해보자.

> 참고: 프로젝트 환경설정을 편리하게 하려고 스프링 부트를 사용한 것이다. 지금은 스프링 없는 순수한 자바로만 개발을 진행한다는 점을 꼭 기억하자! 스프링 관련은 한참 뒤에 등장한다.



* 도메인 협력관계: 기획 - 개발자 협업할 때 좋은 표현방식
* 클래스 다이어그램: 실제 서버를 실행하지 않고, 클래스들만 분석 (정적)
* 객체 다이어그램: 서버가 떠서 실제 사용하는 관계 (new 한 인스턴스끼리의 참조) (동적)



## 3. 스프링 핵심 원리 이해2: 객체지향 원리 적용

### 1) 문제상황

```java
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
  
}
```

* 클래스 의존관계에서 추상(인터페이스) 뿐만 아니라 구체 **(구현) 클래스에도** 의존하고있다. -> **DIP 위배**
  * 추상(인터페이스) 의존: `DiscountPolicy`
  * 구체(구현) 클래스: `FixDiscountPolicy`, `RateDiscountPolicy`
* 기능을 확장해서 변경시, 클라이언트 코드에 영향을 준다 -> **OCP 위배**



> 어떻게 해결할 수 있을까?
>
> 인터페이스에만 의존하도록 의존관계를 변경하면 된다.



```java
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
}
```

그런데 구현체가 없는데 어떻게 코드를 실행할 수 있을까?, 실제 실행시 NPE 발생!

* 이 문제를 해결하려면 **누군가** 클라이언트인 `OrderServiceImpl` 에 `DiscountPolicy` 의 구현 객체를 **대신 생성하고 주입**해주어야한다.



### 2) 관심사의 분리

AppConfig의 등장: 애플리케이션의 전체 동작방식을 구성(config)하기 위해 **구현객체를 생성** 하고 **연결** 하는 책임을 가지는 별도의 설정 클래스를 만들자.

```java

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

```

* AppConfig는 애플리케이션의 실제 동작에 필요한 **구현 객체를 생성** 한다
* AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스) 를 **생성자를 통해 주입(연결)** 한다.
* MemberServiceImpl 등.. 의존관계에 대한 고민은 외부(AppConfig)에 맡기고 실행에만 집중한다.



![image-20220804194224439](/Users/minhee/Library/Application Support/typora-user-images/image-20220804194224439.png)

* 객체의 생성와 연결은 `AppConfig` 가 담당한다.
* DIP 완성: MemberServiceImpl은 MemberRepository인 추상에만 의존한다. 구체 클래스를 몰라도 된다.(MemmoryMemberRepository)
* 관심사의 분리: **객체를 생성하고 연결하는 역할**과 **실행하는 역할이 명확히 분리**되어있다.
* AppConfig 객체는 memoryMemberRepository 객체를 생성하고
  그 참조값을 memberServiceImpl 을 생성하면서 생성자로 전달한다.
* 클라이언트인 `memberServiceImpl` 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것과 같다고 해서 DI(Dependency Injection) 우리말로 의존관계 주입/ 의존성 주입이라고 한다.





### 3)  IoC, DI, 컨테이너

#### ① 제어의 역전 (IoC)

* 기존 프로그래밍은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 **생성, 연결, 실행했다.**
* AppConfig가 등장한 이후 구현 객체는 자신의 로직을 실행하는 역할만 담당한다.
  프로그램의 제어흐름은 AppConfig가 가져간다.
* 프로그램의 제어 흐름을 직접 제어하는게 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라 한다.

#### ② 의존 관계 주입 (DI)

* **정적인 클래스 의존관계**와 **실행시점에 결정되는 동적인 객체 (인스턴스) 의존관계** 둘을 분리해서 생각해야 한다.
  * 정적인 클래스 의존관계: diagram -> java -> show dependency로 확인할 수 있다.
  * 동적인 클래스 의존관계: 앱 실행 시점(런타임)에 외부 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것을 의존관계 주입이라 한다. 객체의 인스턴스를 생성하고 참조값을 전달해서 연결한다.

* 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

#### ③ IoC 컨테이너, DI 컨테이너

* AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는 것
* 어셈블러, 오브젝트 팩토리 등으로 불리기도 한다





### 4) 스프링으로 전환하기

```java
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
```

```java
public class MemberApp{
   public static void main(String[] args) {
     ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

     //1st arg: method 이름, 2nd ar: return class
     ac.getBean("memberService", MemberService.class); 
}
```

* `@Configuration`: Application의 설정정보
  * `@Bean` 을 Spring Container에 등록한다



### 5) 스프링 컨테이너

* `ApplicationContext` 를 스프링 컨테이너라고 한다.
* 기존에는 개발자가 `AppConfig` 를 사용해서 직접 객체를 생성하고 DI를 했지만,
  이제부터 스프링 컨테이너를 통해 사용한다.
* `@Configuration` 이 붙은 `AppConfig` 를 설정 (구성) 정보로 사용한다.
  여기서 **`@Bean` 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.**
  이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라한다.
  (`@Bean(name=)` 으로 이름을 직접 등록할 수도 있지만 관례상 메서드이름으로 많이 사용)
* 스프링 빈은 `@Bean` 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다 (`memerService`, `orderService`)
* 예전엔 개발자가 필요한 객체를 AppConfig를 사용해 직접 조회했는데,
  이제는 스프링 컨테이너를 통해 필요한 스프링 빈(객체)를 찾아야한다.
  스프링 빈은 `applicationContext.getBean()` 메서드를 사용해서 찾을 수 있다.
* 기존에는 개발자가 직접 자바코드로 모든것을 했다면 
  이제부터 스프링 컨테이너에 객체를 스프링빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아 사용하도록 변경됨.
* 어떤 장점이 있을까?





## 4. 스프링 컨테이너와 스프링 빈

### 1) 스프링 컨테이너 생성

```java
ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)
```

* `ApplicationContext`
  * 스프링 컨테이너라고 한다.
  * 인터페이스이다. (-> 다형성이 적용되어있다.)
* 스프링 컨테이너는 `xml` 기반으로 만들 수 있고 어노테이션 기반의 자바 설정 클래스로 만들 수 있다.
* 자바 설정 클래스를 기반으로 스프링컨테이너 (`ApplicationContext`)를 만들어 보자
  * `new AnnotationConfigApplicationContext(AppConfig.class)`
  * 이 클래스는 `ApplicationContext` 의 인터페이스 구현체이다.
    

> 참고: 
> 스프링 컨테이너를 부를 때 `AplicationContext` , `BeanFactory` 로 구분해서 이야기한다.
> `BeanFactory` 를 직접 사용하는 경우는 거의 없으므로 일반적으로 `ApplicationContext` 를 스프링 컨테이너라고 한다.



#### ① 스프링 컨테이너의 생성과정

1. 스프링 컨테이너 생성 (스프링 빈 저장소가 내부에 생긴다.)
   1. new AnnotationConfigApplicationContext(AppConfig.class)
   2. 스프링 컨테이너를 생성할 때는 구성 정보를 지정해주어야 한다.
   3. 여기서는 AppConfig.class 를 구성 정보로 지정했다.
2. 스프링 빈 등록
   1. 스프링 컨테이너 내부에 스프링 빈 저장소는 (빈 이름: 빈객체 - key: value) 형태로 저장이된다.
   2. 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.
   3. 빈이름: 메서드이름이 기본 (직접 이름을 부여할 수도 있다. `@Bean(name = ~)`)

> 주의:
> 항상 **빈(Bean)의 이름은 다른 이름을 부여**하도록 한다. 같은 이름을 부여하면 다른 빈이 무시되거나 기존 빈을 덮어버리거나 설정에 따라 오류가 발생한다.

3. 스프링 빈 의존관계 설정 - 준비
4. 스프링 빈 의존관계 설정 - 완료
   설정정보를 참고해서 의존관계를 주입(DI), 단순 자바 코드를 호출하는 것 같지만 차이가 있다. (싱글톤 컨테이너에서 설명)





### 2) BeanFactory와 ApplicationContext

![image-20220806134536238](/Users/minhee/Library/Application Support/typora-user-images/image-20220806134536238.png)

##### [BeanFactory]

* 스프링 컨테이너의 최상위 인터페이스다.
* 스프링 빈을 관리하고 조회하는 역할을 담당한다.
* getBean() 을 제공한다.
* 지금까지 우리가 사용했던 대부분의 기능은 BeanFactory가 제공하는 기능이다.

##### [ApplicationContext]

* BeanFactory 기능을 모두 상속받아 제공
* 빈을 관리하고 검색하는 기능을 BeanFactory가 제공해주는데, 그 차이가 뭘까?
* 애플리케이션을 개발할 때 빈을 관리하고 조회하는 기능은 물론, 수많은 부가 기능이 필요하다.





![image-20220806134727111](/Users/minhee/Library/Application Support/typora-user-images/image-20220806134727111.png)



* **메세지 소스를 활용한 국제화기능:** 예를들어 한국에서 들어오면 한국어, 영어권에서 들어오면 영어로 출력
* **환경변수:** 로컬(현재 내 pc), 개발(테스트서버, 여러서버엮어서), 운영(실제 프로덕션), 스테이징(운영밀접) 등을 구분해서 처리
* **애플리케이션 이벤트:** 이벤트를 발행하고 구독하는 모델을 편리하게 지원
* **편리한 리소스 조회:** 파일, 클래스패스, 외부 등에서 리소스를 편하게 조회



[정리]

* ApplicationContext는 BeanFactory의 기능을 상속받는다.
* ApplicationContext는 빈 관리기능 + 편리한 부가 기능을 제공한다.
* BeanFactory를 직접 사용할 일은 거의 없다. 부가기능이 포함된 ApplicationContext를 사용한다.
* BeanFactory나 ApplicationContext를 스프링 컨테이너라 한다.



xml 기반으로 사용할때? == AppConfig.java와 비슷하다. 다만 스프링으로 하는 설정이 얼마나 유용한가를 알고자 잠깐 진행함

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="memberService" class="hello.core.member.MemberServiceImpl">
      <constructor-arg name="memberRepository" ref="memberRepository"></constructor-arg>
    </bean>
    
    <bean id="memberRepository" class="hello.core.member.MemoryMemberRepository"/>

    <bean id="orderService" class="hello.core.order.OrderServiceImpl">
      <constructor-arg name="memberRepository" ref="memberRepository"></constructor-arg>
      <constructor-arg name="discountPolicy" ref="discountPolicy"></constructor-arg>
    </bean>
    
    <bean id="discountPolicy" class="hello.core.discount.RateDiscountPolicy"></bean>
</beans>
```





### 3) 스프링 빈 설정 메타 정보: BeanDefinition

스프링은 어떻게 다양한 설정 형식을 지원할까? 그 중심에는 **`BeanDefinition` 이라는 추상화!**

쉽게 이야기해서 역할과 구현을 개념적으로 나눈것이다.

* xml을 읽어서 BeanDefinition을 만들면 된다.
* 자바코드를 읽어서 BeanDefinition 을 만들면 된다.
* 스프링 컨테이너는 자바코드인지, xml인지 몰라도 되며 오직 `BeanDefinition` 만 알면 된다.

`BeanDefinition` 을 빈 설정 메타 정보라 한다.

* `@Bean`, `<bean>` 당 각각 하나씩 메타 정보가 생성된다.

스프링 컨테이너는 이 메타 정보를 기반으로 스프링 빈을 생성한다.



![image-20220806143911731](/Users/minhee/Library/Application Support/typora-user-images/image-20220806143911731.png)

ApplicationContext => [AnnotationConfigApplicationContext, GenericXmlApplicationContext, xxxApplicationContext] => [xxxBeanDefinitionReader] => 설정정보(AppConfig.class, appConfig.xml...) 읽고 => BeanDefinition생성



[정리]

스프링은 BeanDefinition으로 스프링 설정메타정보를 추상화한다

스프링 빈을 만드는 방법 2가지 : 직접 스프링 빈을 등록/ 팩토리 빈으로 등록

일반적인 javaConfig 사용하는것은 팩토리 빈으로 등록하는것!





## 5. 싱글톤 컨테이너

* 싱글톤: 객체 인스턴스가 JVM안에 하나만 존재

### 1) 웹 애플리케이션과 싱글톤

* 스프링은 태생이 기업용 온라인 서비스 기술을 지원하기 위해 탄생했다.
* 대부분의 스프링 어플리케이션은 웹 어플리케이션이다. 물론 웹이 아닌 애플리케이션 개발을 얼마든지 개발할 수 있다.
* 웹앱은 보통 여러 고객이 동시에 요청한다.
* 스프링 없는 순수 DI 컨테이너인 AppConfig는 요청을 할 때마다 객체를 새로 생성한다.
  해결방안은 해당 객체가 딱 1개만 생성되고 공유하도록 설계하면 된다. => 싱글톤 패턴



### 2) 싱글톤 패턴

```java
package hello.core.singleton;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성
    private static final SingletonService instance = new SingletonService();

    //2. 생성자를 private 으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {}

    //3. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

```

* 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
* 그래서 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야한다.
  * `private` 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야한다.



### 3) 싱글톤 방식의 주의점

* 객체의 인스턴스 하나만 생성해서 공유하는 싱글톤방식(싱글톤 패턴, 싱글톤 컨테이너,..)은 
  여러 클라이언트가 하나의 같은 인스턴스를 공유하기 때문에, 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다.
* 무상태로 설계해야한다.
  * 특정 클라이언트에 의존적 필드가 있으면 안됨
  * 가급적 읽기만 가능하도록 만들기
  * 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
  * 필드 대신 자바에서 공유되지 않는 지역변수, 파라미터, Thread Local등을 사용해야한다.
* 스프링 빈의 필드에 공유값을 설정하면 정말 큰 장애가 발생할 수 있다.



### 4) `@Configuration` 과 바이트 코드의 조작 마법

스프링 컨테이너는 싱글톤 레지스트리다. 따라서 스프링 빈이 싱글톤이 되도록 보장해주어야한다.

그런데 스프링이 자바 코드까지 어떻게 하긴 어렵다. 스프링은 클래스의 바이트코드를 조작하는 라이브러리를 사용한다.
`@Configuration`을 적용한 `AppConfig` 에 비밀이 담겨있다.

```java
@Test
void configurationDeep() {
	ApplicationContext ac = new
	AnnotationConfigApplicationContext(AppConfig.class);
	//AppConfig도 스프링 빈으로 등록된다.
	AppConfig bean = ac.getBean(AppConfig.class);
	System.out.println("bean = " + bean.getClass());
	//출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70
}
```

내가 만든 클래스가 아니라 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig

클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것

![image-20220806224755437](/Users/minhee/Library/Application Support/typora-user-images/image-20220806224755437.png)

임의의 다른 클래스가 바로 싱글톤이 보장되도록 한다.



## 6. 컴포넌트 스캔

### 1) 컴포넌트 스캔과 의존관계 자동 주입 시작하기

* 스프링은 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라는 기능을 제공한다.

* 의존관계도 자동으로 주입하는 `@Autowired` 기능도 제공한다.

  ```java
  
  @Configuration
  @ComponentScan(
    excludeFilters = @ComponentScan.Filter
    (type = FilterType.ANNOTATION, classes = Configuration.class))
  public class AutoAppConfig {
  }
  ```

  * ComponentScan 시 필터링 (제외할것에 대한 옵션 지정 excludeFilters)
  * 기존의 AppConfig처럼 `@Bean` 을 사용하지 않음.
  * 컴포넌트 스캔을 사용하려면 `@ComponentScan` 을 하면됨
  * 컴포넌트 스캔은 `@Component` 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.



#### ①컴포넌트 스캔 위치

```java

//basePackages, basePackageClasses 를 지정하지 않으면 @ComponentScan 을 붙인 설정 정보 클래스의 패키지가 시작 위치가 된다.
//권장: 패키지 위치를 지정하지 ㅇ낳고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것.
@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

```

* 스프링 부트의 대표 시작 정보인 `@SpringBootApplication`를 프로젝트 시작 루트 위치에 두는게 관례.
  이 설정 내부에 `@ComponentScan`이 붙어있다.



#### ② 컴포넌트 스캔 기본대상

* `@Component` 뿐만 아니라 아래 내용도 컴포넌트 스캔의 대상에 포함된다.
  * `@Component`: 컴포넌트 스캔에서 사용
  * `@Controller`: 스프링 MVC 컨트롤러
  * `@Service`: 스프링 비즈니스 로직에서 사용
  * `@Repository`: 스프링 데이터 접근 계층에서 사용
  * `@Configuration`: 스프링 설정 정보에서 사용



### 2) 필터

* `includeFilters`: 컴포넌트 스캔 대상을 추가로 지정한다.
* `excludeFilters`: 컴포넌트 스캔 대상을 제외할 대상을 지정한다.

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
```



### 3) 중복 등록과 충돌

* 컴포넌트 스캔에 같은 빈 이름을 등록하면 어떻게 될까? (2가지 상황이있다.)

  * 자동빈등록 vs 자동빈등록: ConflictBeanDefinitionException 예외

  * 수동빈등록 vs 자동빈등록: 수동 등록 빈이 우선관을 가진다. (수동빈이 자동 빈을 오버라이딩 해버린다.)

    * 다만 현실적으로 개발자가 의도적으로 설정해서 이런 결과가 만들어지기보단,
      여러 설정들이 꼬이면서 이런결과가 나오는 경우가 대부분이다.
      이런건 정말 잡기가 어려운 버그가 된다. 잡기 어려운 버그는 이런 애매한 버그!!

    * 그래서 최근 스프링 부트에서는 수동빈등록과, 자동빈 등록이 충돌나는 경우 오류가 발생하도록 변경됨
      (override해서 사용하고 싶으면 properties(yaml)설정 변경하여 사용)

      ```
      spring.main.allow-bean-definition-overriding=true
      ```

* 약간 불명확한데 코드가 줄어들어 vs 코드를 복붙하더라도 명확해 어떤걸 선택?
  어찌됬던 명확한쪽으로 하는게 낮다.
  (나중에 버그 잡기가 훨씬 낫다)







## 7. 의존관계 자동 주입

### 1) 다양한 의존관계 주입 방법

의존관계 주입방법은 크게 4가지가 있다.

* 생성자 주입	
  * 생성자 호출 시점에 딱 1번만 호출되는것이 보장된다.
  * **불변, 필수** 의존관계에서 사용된다.
  * 생성자가 딱 하나만 있을때는 `@Autowired` 를 작성하지 않아도 알아서 `@Autowired`를 붙인 효과가 일어남
  * final 키워드 : 생성자에서만 값을 넣어줄수있고 나머지에서 값을 변경할 수 없다. -> 개발자가 실수로 누락하는 실수를 막을 수 있다.
* setter주입(수정자 주입)
  * **선택, 변경** 가능성이 있는 의존관계에서 사용.
* 필드 주입
  * 필드에 `@Autowired`
  * 코드는 간결하지만 사용하면서 안티패턴임을 알게됨
    * 외부에서 변경이 불가능해서 테스트 하기 힘들다는 단점
    * DI프레임워크가 없으면 아무것도 할 수 없음.
  * 사용은 어디서?
    * 애플리케이션의 실제 코드와 관계 없는 테스트코드
    * 혹은, 스프링 설정을 목적으로 하는 `@Configuration` 같은 곳에서만 특별한 용도로 사용
* 일반 메서드 주입
  * 일반 메서드를 통해 주입 가능
  * 한번에 여러 필드를 주입받을 수 있다. 일반적으로 잘 사용x

> 당연한 이야기지만, 의존관계 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 동작한다.
> 스프링 빈이 아닌 클래스에 `@Autowired` 를 적용해도 아무 동작도 하지 않는다.



### 2) 옵션 처리

* 주입할 빈이 없어도 동작해야할 때가 있다.
  그런데 `@Autowired` 만 사용하면 `required` 옵션의  기본값이 `true` 로 되어있어서 자동 주입 대상이 없으면 오류가 발생한다. 자동 주입 대상을 처리하는방법은 아래 3가지
  * `@Autowired(required = false)`: 자동으로 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
  * `org.springframework.lang.@Nullable`: 자동으로 주입할 대상이 없으면 null이 입력됨
  * `Optional<>` 자동 주입할 대상이 없으면 `Optional.empty` 가 입력된다.



### 3) 생성자 주입을 선택하라

* 불변
* 생성자 주입 방식을 선택하는 이유는 여러가지가 있겠지만, 프레임워크에 의존하지 않고
  순수한 자바 언어의 특징을 잘 살리는 방법
* 기본으로 생성자 주입을 사용하고, 필수 값이 아닌경우 수정자 주입방식을 옵션으로 부여하면 된다.
  생성자 주입과 수정자 주입을 동시에 사용이 가능하다.
* 항상 생성자 주입을 선택하라!!!
  가끔 옵션이 필요하면 수정자 주입을 선택하도록 해라. 필드 주입은 사용하지 않는게 좋다.





### 3) 롬복과 최신 트랜드

* 대부분 다 불변, 다음과 같이 생성자에 final 키워드를 사용함.
* 생성자도 만들어야하고, 주입받은 값을 대입한 코드도 만들어야하고, .. 필드 주입처럼 편리하게 관리하는 방법은 없을까?

#### ① 롬복

* Build.gradle 추가 (dependency)
* Plugin -> lombok 추가

* preference -> annotation processor -> enable annotation processing

롬복이 자바의 annotation processor 기능을 이용해서 컴파일 시점에 생성자 코드를 자동으로 생성해준다.

최근에는 생성자를 1개만 두고, `@Autowired` 를 생략하는 방법을 주로 사용. 
Lombok의 `@RequiredConstructor` 를 함께 사용하면 기능은 다 제공하면서, 코드를 깔끔하게 사용할 수 있다.





### 4) 조회 빈이 2개 이상: 문제 해결방법

1. `@Autowired` 필드명 매칭: 처음에 타입 매칭을 시도한 뒤, 여러 빈이 있으면 필드이름, 파라미터 이름으로 빈 이름을 추가 매칭.
2. `@Qualifier` (:추가 구분자)-> `@Qulifier` 끼리 매칭 -> 빈 이름 매칭 -> `NoSuchBeanDefinitionException` 발생
3. `@Primary` 사용 (: 우선순위를 지정하는 방법)



[우선순위]

* 스프링은 자동 < 수동
* 넓은 범위 선택 보다 < 좁은 번위 선택이 우선순위가 높다.
  * 따라서 `@Primary(기본값처럼쓰임)` / `@Qualifier` (상세) 따라서 `@Qualifier`가 우선순위가 높다.



### 5) 어노테이션 직접 만들기

`@Qualifier("mainDiscountPolicy")` 이렇게 문자를 적으면 컴파일시 타입 체크가 안된다.

아래 어노테이션을 만들어서 문제를 해결할 수 있다.

```java
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}

```

사용시

```java
@MainDiscountPolicy
```

애노테이션에는 상속이라는 개념이 없다.

이렇게 여러 애노테이션을 모아서 사용하는 기능은 스프링이 지원해주는 기능이다.

 @Qulifier 뿐만 아니라 다른 애노테이션들도 함께 조합해서 사용할 수 있다.

단적으로 @Autowired도 재정의 할 수 있다. 

물론 스프링이 제공하는 기능을 뚜렷한 목적 없이 무분별하게 재정의 하는 것은 유지보수에 더 혼란만 가중할 수 있다.



### 6) 조회한 빈이 모두 필요할 때: List, Map

의도적으로 정말 해당 타입의 모든 스프링 빈이 필요한 경우도 있다.

클라이언트가 할인의 종류(rate, fix)를 선택할 수 있다고 가정.

전략패턴을 매우 간단히 구현할 수 있다.



### 7) 자동/수동의 올바른 실무 운영기준

* 편리한 자동기능을 기본으로 사용하자.

* 그럼 수동빈 등록은 언제?

  * 업무 로직 빈: 웹을 지원하는 컨트롤러, 핵심 비즈니스 로직이 있는 서비스, 데이터 계층로직을 처리하는 레포지토리

  * **기술 지원 빈**: 기술문제나 공통관심사(AOP)를 처리하는 경우. 
    DB 연결, 공통 로그 처리 등 업무 로직을 지원하기 위한 하부 기술이나 공통 기술

    ```
    기술 지원 로직은 업무 로직과 비교해서 그 수가 매우 적고, 보통 애플리케이션 전반에 걸쳐서 광범위하게
    영향을 미친다. 그리고 업무 로직은 문제가 발생했을 때 어디가 문제인지 명확하게 잘 드러나지만, 기술 지원
    로직은 적용이 잘 되고 있는지 아닌지 조차 파악하기 어려운 경우가 많다. 그래서 이런 기술 지원 로직들은
    가급적 수동 빈 등록을 사용해서 명확하게 드러내는 것이 좋다.
    ```

    **애플리케이션에 광범위하게 영향을 미치는 기술 지원 객체는 수동 빈으로 등록해서 딱! 설정 정보에 바로 나타나게 하는 것이 유지보수 하기 좋다.**

  * 다형성을 적극 이용할 때는 한눈에 빈의 이름을 파악할 수 있도록 패키지로라도 구분.





## 빈 생명 주기 콜백 시작

* 스프링 빈의 라이프 사이클
  * 객체 생성 후 의존관계 주입 (생성자 주입 예외)
* 스프링 빈은 객체를 생성하고 의존관계 주입이 끝난 다음에 필요한 데이터를 사용할 준비가 완료된다.
  따라서 초기화 작업은 의존관계 주입이 모두 완료되고 난 다음에 호출해야한다. 
  그런데, 개발자가 의존관계 주입이 끝난 시점(모두 완료된 시점)을 어떻게 알까?
  * 스프링은 의존관계 주입이 완료되면 스프링빈에게 콜백메서드로 초기화 시점을 알려주는 다양한 기능을 제공한다.
    또한 스프링은 스프링 컨테이너가 종료되기 직전에 소멸 콜백을 준다.
    따라서 안전하게 종료 작업을 진행할 수 있다.
* 스프링 빈의 이벤트 라이프 사이클
  * 컨테이너 생성 -> 스프링 빈생성(constructor생성) -> 의존관계 주입(setter, feild) -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
    * 초기화 콜백: 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
    * 소멸전 콜백: 빈이 소멸되기 직전에 호출









### TMI 

진짜 잘 설계한 앱은 컴파일 오류만으로도 에러가 잘 잡힐 수 있어야됨

좋은 개발습관: 한계점, 제한이 있어야한다. 

회사에서 장애가 나도 서로 비난하지 않는다. 문제 해결이 중요하기 때문에 포커스를 여기에 둔다. 따라서 상호간에 피드백이 중요하다.



## 단축키

* Cmd + shift + enter: 자동완성
* Cmd + option + v: 변수명
* Cmd + E: 과거에 검색했던 내역 찾기 
* Cmd + option + m: extract method
* F2: 오류난 위치로 찾아가기
* Cmd + F12 : 생성자, 메서드 등을 확인할 수 있다.



[자동완성]

iter + tab: 이터레이터 자동으로 완성시켜줌

Soutv + tab: 자동으로 변수명 찍기 완성 시켜줌

soutm + tab: 자동으로 메서드명 찍기 완성시켜줌