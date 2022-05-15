package com.design.pattern._01_createion._03_abstract_factory._02_after.normal;


import com.design.pattern._01_createion._03_abstract_factory._02_after.facoty.Anchor;
import com.design.pattern._01_createion._03_abstract_factory._02_after.facoty.ShipPartsFactory;
import com.design.pattern._01_createion._03_abstract_factory._02_after.facoty.Wheel;

public class WhiteShipPartsFactory implements ShipPartsFactory {

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
