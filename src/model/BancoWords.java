package model;

import java.util.ArrayList;
import java.util.List;

public class BancoWords { // Base/repositório de palavras a serem usadas no jogo

	private List<String> temas;
	
	public BancoWords() {
		this.temas = new ArrayList<String>();
		temas.add("Objetos");
		temas.add("Animal");
		temas.add("Lugar");
		temas.add("Disciplina");
	}
	
	public String gerarWord(String tema){ //Método para gerar as palavras randômicas e retornar com base no tema e na palavra
		if(tema.equals("Objetos")){
			return "bola";
		}else if(tema.equals("Animal")){
			return "gato";
		}else if(tema.equals("Lugar")){
			return "fortaleza";
		}else if(tema.equals("Disciplina")){
			return "engenharia de software";
		}
		return null;
	}

	public List<String> getTemas() {
		return temas;
	}

	public void setTemas(List<String> temas) {
		this.temas = temas;
	}
	
	
}
