package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PackmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class test {

	public static void main(String[] args) {
		
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		
		// 1 : 객체 생성
		
		var game = new PackmanGame(); 
		
		// 2 : 객체 생성 + 의존성 주입
		//     GammingConsole은 GammingRunner의 의존성
		// 	   의존성이 낮을수록 유지보수에 용이함
		var gameRunner = new GameRunner(game); 
			
		gameRunner.run();
		

	}

}
