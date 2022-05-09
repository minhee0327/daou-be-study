package com.design.pattern._01_createion._02_factory._02_after;

public interface ShipFactory {

    default Ship orderShip(String name, String email){
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    // java 8 이상은 private method 를 쓸 수 있지만, 이하는 인터페이스를 구현하는 방식(abstract class)을 사용한다.
    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }

    private void validate(String name, String email){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    }

    private static void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

}
