package com.design.pattern._01_createion._03_abstract_factory._03_java;

import com.design.pattern._01_createion._02_factory._02_after.Ship;
import com.design.pattern._01_createion._02_factory._02_after.WhiteShip;
import org.springframework.beans.factory.FactoryBean;

public class ShipFactory implements FactoryBean<Ship> {

    @Override
    public Ship getObject() throws Exception {
        Ship ship = new WhiteShip();
        ship.setName("whiteship");
        return ship;
    }

    @Override
    public Class<?> getObjectType() {
        return Ship.class;
    }
}
