package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GammingConsole;
import com.in28minutes.learnspringframework.game.PackmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GammingConsole game() {
		var game = new PackmanGame(); 
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GammingConsole game) {
		var gameRunner = new GameRunner(game); 
		return gameRunner;
	}
			
}
