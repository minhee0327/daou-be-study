package com.design.pattern._01_createion._03_abstract_factory._02_after.temp;

import com.design.pattern._01_createion._02_factory._02_after.Ship;

public abstract class DefaultShipFactory implements ShipFactory {

    @Override
    public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
