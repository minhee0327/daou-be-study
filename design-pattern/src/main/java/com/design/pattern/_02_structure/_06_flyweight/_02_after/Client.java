package com.design.pattern._02_structure._06_flyweight._02_after;

public class Client {
    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));  //공유하는 데이터이므로 메모리를 덜쓰게 됨
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }
}
