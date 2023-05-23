package tobyspring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.hello.service.HelloDecorator;
import tobyspring.hello.service.SimpleHelloService;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
