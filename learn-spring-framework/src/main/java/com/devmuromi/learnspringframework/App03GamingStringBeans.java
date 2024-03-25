package com.devmuromi.learnspringframework;

import com.devmuromi.learnspringframework.game.GameRunner;
import com.devmuromi.learnspringframework.game.GamingConsole;
import com.devmuromi.learnspringframework.game.PackmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingStringBeans {
    public static void main(String[] args) {
        try (
                var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)
        ) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

//        var game = new MarioGame();
//        var game = new SuperContraGame();
//        var game = new PackmanGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();
    }
}
