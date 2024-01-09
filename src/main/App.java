package main;

import view.View;

import controller.Controller;

public class App {

	public static void main(String[] args) {
		
		
		Controller.getInstance().setView(new View());

	}

}