package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    //의존관계 주입이 끝나면 넣겠다. (싱글톤 빈, 스프링컨테이너 올라올때 의존관계 주입이 끝나고 넣어짐)
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    //빈이 종료될 때 호출된다.
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
      disconnect();
    }
}
