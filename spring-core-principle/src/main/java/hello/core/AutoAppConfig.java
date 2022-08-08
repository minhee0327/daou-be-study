package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

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
