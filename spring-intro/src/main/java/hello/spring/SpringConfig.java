package hello.spring;

import hello.spring.aop.TimeTraceApp;
import hello.spring.repository.JdbcTemplateMemberRepository;
import hello.spring.repository.JpaMemberRepository;
import hello.spring.repository.MemberRepository;
import hello.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
/*
    private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
*/

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    /*@Bean
    public TimeTraceApp timeTraceApp(){
        return new TimeTraceApp();
    }*/

    /*
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}