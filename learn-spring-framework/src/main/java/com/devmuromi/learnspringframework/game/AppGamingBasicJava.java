package com.devmuromi.learnspringframework.game;

public class AppGamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PackmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
