package model;

import java.util.List;
import java.util.Set;

public class GerenciadorPartida { // Controle de tentativas, erros e acertos

	private int tentativas;
	private int tentativasErros;
	
	public GerenciadorPartida() {
		this.tentativas = 0;
		this.tentativasErros = 0;
	}
	
	public int analise(String palavra, Set<String> letrasAcertadas, Set<String> letrasChutadas, GerenciadorLetra t, List<String> palavrauser, int sizeLetrasAcertadas){
		String letra = t.getLetra();
		boolean identificador = false;
		char[] caracteres = palavra.toCharArray(); 
		
		for(int i = 0; i < palavrauser.size(); i++){ // Analisar letra
			if(palavrauser.get(i).equals("_")){
				if(letra.charAt(0) == caracteres[i]){
					palavrauser.remove(i);
					palavrauser.add(i, letra.charAt(0) + "");
					identificador = true;
					letrasAcertadas.add(letra.charAt(0) + ""); // Adicionar ao conjunto de letras já acertadas
					sizeLetrasAcertadas++;
				}
			}
		}
		
		letrasChutadas.add(letra.charAt(0) + ""); // Adicionar ao conjunto de letras já usadas
		gerenciarQtdTentativa(identificador);
		identificador = false;
		return sizeLetrasAcertadas;
	}
	
	public void gerenciarQtdTentativa(boolean identificador){
		if(identificador == true){
			System.out.println("Parabéns, a palavra possui essa letra!!!");
			identificador = false;
		}else{
			this.tentativasErros++;
		}
		this.tentativas++;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getTentativasErros() {
		return tentativasErros;
	}

	public void setTentativasErros(int tentativasErros) {
		this.tentativasErros = tentativasErros;
	}
}
