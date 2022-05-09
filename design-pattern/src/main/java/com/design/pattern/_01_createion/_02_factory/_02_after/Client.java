package com.design.pattern._01_createion._02_factory._02_after;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactory(), "whiteship", "mini@mail.com");
        client.print(new BlackShipFactory(), "blackShip", "mini@gmail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }

}
