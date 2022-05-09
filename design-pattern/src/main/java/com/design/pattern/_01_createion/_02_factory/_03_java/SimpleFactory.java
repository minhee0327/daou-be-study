package com.design.pattern._01_createion._02_factory._03_java;

import com.design.pattern._01_createion._02_factory._02_after.BlackShip;
import com.design.pattern._01_createion._02_factory._02_after.WhiteShip;

public class SimpleFactory {

    public Object createProduct(String name){
        if(name.equals("whiteship")){
            return new WhiteShip();
        }else if (name.equals("blackship")){
            return new BlackShip();
        }

        throw new IllegalArgumentException();
    }
}
