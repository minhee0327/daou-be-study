package com.design.pattern._01_createion._02_factory._02_after;

public class WhiteShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }

}
