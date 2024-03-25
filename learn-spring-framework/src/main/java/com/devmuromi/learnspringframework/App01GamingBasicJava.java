package com.devmuromi.learnspringframework;

import com.devmuromi.learnspringframework.game.GameRunner;
import com.devmuromi.learnspringframework.game.PackmanGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PackmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
