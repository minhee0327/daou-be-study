package com.design.pattern._01_createion._02_factory._02_after;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
