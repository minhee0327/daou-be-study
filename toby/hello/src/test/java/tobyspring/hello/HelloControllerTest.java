package tobyspring.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tobyspring.hello.controller.HelloController;

public class HelloControllerTest {

    @Test
    void helloController(){
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        Assertions.assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController(){
        //테스트에서 (스프링 컨테이너에 등록x 주입) 사용하는 di, (익명함수 -> 람다), stub
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
