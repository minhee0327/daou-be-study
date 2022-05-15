package com.design.pattern._01_createion._03_abstract_factory._02_after;

import com.design.pattern._01_createion._02_factory._02_after.Ship;
import com.design.pattern._01_createion._03_abstract_factory._02_after.normal.WhiteShipPartsFactory;
import com.design.pattern._01_createion._03_abstract_factory._02_after.pro.WhitePartsProFactory;
import com.design.pattern._01_createion._03_abstract_factory._02_after.temp.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        //사용하는 client 족에서 pro 제품인지, 일반 제품인지 결정해줄 수가 있다.
        ShipFactory shipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
