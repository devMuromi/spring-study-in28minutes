package com.devmuromi.learnspringframework;

import com.devmuromi.learnspringframework.game.GameRunner;
import com.devmuromi.learnspringframework.game.GamingConsole;
import com.devmuromi.learnspringframework.game.PackmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public PackmanGame packmanGame() {
        return new PackmanGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}

