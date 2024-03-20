package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PackmanGame implements GammingConsole {
	
	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
	
}