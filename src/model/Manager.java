package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

	private String tema;
	private String palavra;
	private List<String> letrasAcertadas;
	private List<String> letrasChutadas;
	private int tentativasErros;
	private int tentativas;
	private List<String> temasAvaliable;
	private BancoWords banco;
	
	public Manager() {
		this.banco = new BancoWords();
		this.temasAvaliable = banco.getTemas();
		//this.palavra = banco.gerarWord();
		this.tentativas = 0;
		this.tentativasErros = 0;
		this.letrasAcertadas = new ArrayList<String>();
	}
	
	public void gerarInstrucoes(){
		//Gerando Instruções Iniciais
		Scanner sc = new Scanner(System.in);
		String inicio = "Bem-vindo, para começar, escolha um tema: ";
		String temas = "";
		for(int i = 0; i < temasAvaliable.size(); i++){
			temas = temas + temasAvaliable.get(i) + " ----- ";
		}
		//Mostrando temas disponíveis
		System.out.println(inicio + "\n" + temas);
		
		//Inserindo tema
		this.setTema(sc.nextLine());
		
		this.setPalavra(banco.gerarWord(this.getTema()));
		System.out.println("Palavra escolhida! Hora de Iniciar o jogo!!!");
		gerarForca();
	}
	
	public void gerarForca(){
		System.out.println("Tema: " + this.getTema() + "; Letras: " + this.getPalavra().length());
		
		System.out.println("Quantidade de Tentativas: " + this.getTentativas() + " \nQuantidade de Erros: " + this.getTentativasErros());
		gerarEspacamentoForcaInicial(this.getPalavra(), this.getLetrasAcertadas());
		
	}
	
	public void gerarEspacamentoForcaInicial(String palavra, List<String> letrasAcertadas){
		int sizeWord = palavra.length();
//		for(int i = 0; i < sizeWord; i++){
//			letrasAcertadas.add("_");
//		}
//		
//		String teste = "";
//		
//		
//		for(int i = 0; i < sizeWord; i++){
//			teste += letrasAcertadas.get(i);
//		}
//		
//		System.out.println(teste);

		String teste2 = "";
		char[] caracteres = palavra.toCharArray(); 
		
		String letra = "a";
		for(int i = 0; i < caracteres.length; i++){
			if(letra.charAt(0) == caracteres[i]){
				teste2 += caracteres[i] + "; ";
			}else{
				teste2 += "_; ";
			}
		}
		System.out.println(teste2);
	}
	
	public void analisarPalavra(Tentativa t){
		String letra = t.getLetra();
//		if(){
//			
//		}
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public List<String> getTemasAvaliable() {
		return temasAvaliable;
	}

	public void setTemasAvaliable(List<String> temasAvaliable) {
		this.temasAvaliable = temasAvaliable;
	}

	public int getTentativasErros() {
		return tentativasErros;
	}

	public void setTentativasErros(int tentativasErros) {
		this.tentativasErros = tentativasErros;
	}

	public List<String> getLetrasAcertadas() {
		return letrasAcertadas;
	}

	public void setLetrasAcertadas(List<String> letrasAcertadas) {
		this.letrasAcertadas = letrasAcertadas;
	}
	
	public List<String> getLetrasChutadas() {
		return letrasChutadas;
	}

	public void setLetrasChutadas(List<String> letrasChutadas) {
		this.letrasChutadas = letrasChutadas;
	}
	
}
