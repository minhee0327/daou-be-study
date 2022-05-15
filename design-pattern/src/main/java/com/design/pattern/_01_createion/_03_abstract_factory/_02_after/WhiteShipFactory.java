package com.design.pattern._01_createion._03_abstract_factory._02_after;

import com.design.pattern._01_createion._02_factory._02_after.Ship;
import com.design.pattern._01_createion._02_factory._02_after.WhiteShip;
import com.design.pattern._01_createion._03_abstract_factory._02_after.facoty.ShipPartsFactory;
import com.design.pattern._01_createion._03_abstract_factory._02_after.temp.DefaultShipFactory;

public class WhiteShipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    //여기에서 어떤 팩토리를 사용하는가에 따라 제품이 나올 수 있다.
    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
