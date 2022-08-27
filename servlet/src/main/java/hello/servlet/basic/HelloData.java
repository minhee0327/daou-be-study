package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

//json Object 는 java property(getter, setter)로 접근함
@Getter @Setter
public class HelloData {
    private String username;
    private int age;
}
