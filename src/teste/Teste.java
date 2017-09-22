package teste;

import java.util.Scanner;

import model.GerenciadorJogo;

public class Teste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		GerenciadorJogo jogo = new GerenciadorJogo();
		
		jogo.startGame();
		
	}

}
