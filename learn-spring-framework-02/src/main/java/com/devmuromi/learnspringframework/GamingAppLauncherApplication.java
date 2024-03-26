package com.devmuromi.learnspringframework;

import com.devmuromi.learnspringframework.game.GameRunner;
import com.devmuromi.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.devmuromi.learnspringframework.game")
public class GamingAppLauncherApplication {

//    @Bean
//    public PackmanGame packmanGame() {
//        return new PackmanGame();
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game) {
//        System.out.println(game);
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args) {
        try (
                var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)
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
