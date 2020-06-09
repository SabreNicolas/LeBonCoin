package leSuperCoin;

import leSuperCoin.controller.Controller;

public class App {
    public static void main(String[] args) {
        new App();
    }

    private Controller controller;

    public App() {
        this.controller = new Controller();
    }
}