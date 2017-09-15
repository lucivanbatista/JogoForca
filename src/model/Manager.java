package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Manager { // Interação com o jogador (entrada e saída de dados)

	private String tema;
	private String palavra;
	private List<String> palavrauser; // Palavra sendo mostrada
	private Set<String> letrasAcertadas;
	private Set<String> letrasChutadas;
	private int tentativasErros;
	private int tentativas;
	private int maxTentativas;
	private Visual visual;
	private GerenciadorTentativas gt;
	
	public Manager() {
		this.tentativas = 0;
		this.tentativasErros = 0;
		this.maxTentativas = 0;
		this.letrasAcertadas = new HashSet<String>();
		this.letrasChutadas = new HashSet<String>();
		this.palavrauser = new ArrayList<String>();
		visual = new Visual();
		gt = new GerenciadorTentativas();
	}
	
	public void startGame(){
		visual.gerarInstrucoesIniciais(); // Gerando instruções iniciais
		this.setTema(chooseTema()); // Escolhendo tema
		
		visual.escolherTentativas(); //Escolhendo qtd tentativas max
		this.setMaxTentativas(chooseTentativas());
		
		String word = visual.escolherPalavra(tema); // Escolhendo palavra
		this.setPalavra(word); // Palavra escolhida
		
		visual.aboutWord(this.getTema(), this.getPalavra());
		visual.gerarEspacamentoInicial(this.getPalavra(), this.getPalavrauser());
		cicloGame();
	}
	
	public String chooseTema(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public int chooseTentativas(){
		Scanner sc = new Scanner(System.in);
		int max = 10;
		String n = sc.nextLine();
		if(n.equals("Sim") || n.equals("sim")){
			System.out.println("Digite a quantidade máxima de tentativas: ");
			max = Integer.parseInt(sc.nextLine());
		}
		return max;
	}
	
	public void cicloGame(){ // Ciclo de vida da jogada (até morrer ou ganhar)
		
		while(stopGame() == true){
			visual.aboutTries(this.getTentativas(), this.getTentativasErros());
			
			Scanner sc = new Scanner(System.in);
			System.out.println(">> Digite uma letra: ");
			Tentativa t = new Tentativa(sc.nextLine());
			
			optionsGame(t.getLetra());
			
			if(this.getLetrasAcertadas().contains(t.getLetra()) || this.getLetrasChutadas().contains(t.getLetra())){
				System.out.println("Essa letra já foi digitada!");
				visual.mostrarForca(this.getPalavrauser());
			}else{
				gt.analise(this.getPalavra(), this.getLetrasAcertadas(), this.getLetrasChutadas(), t, this.getPalavrauser());	
				this.setTentativas(gt.getTentativas());
				this.setTentativasErros(gt.getTentativasErros());
				
				visual.mostrarForca(this.getPalavrauser());
			}
		}
	}
	
	public boolean stopGame(){
		if(this.getTentativasErros() == this.getMaxTentativas()){
			visual.lose(this.getPalavra(),  this.getTentativas(), this.getTentativasErros());
			return false;
		}
		if(this.getLetrasAcertadas().size() == this.getPalavra().length()){
			visual.win(this.getPalavra(),  this.getTentativas(), this.getTentativasErros());
			return false;
		}
		return true;
	}

	public void optionsGame(String option){
		if(option.equals("help")){
			visual.help(this.getLetrasAcertadas(), this.getLetrasChutadas(), this.getTema(), this.getPalavra(), this.getTentativas(), this.getTentativasErros());
		}else if(option.equals("restart")){
			restart();
			startGame();
		}
	}
	
	public void restart(){
		this.tema = null;
		this.palavra = null;			
		this.tentativas = 0;
		this.tentativasErros = 0;
		this.letrasAcertadas = new HashSet<String>();
		this.letrasChutadas = new HashSet<String>();
		this.palavrauser = new ArrayList<String>();
		visual = new Visual();
		gt = new GerenciadorTentativas();
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

	public int getTentativasErros() {
		return tentativasErros;
	}

	public void setTentativasErros(int tentativasErros) {
		this.tentativasErros = tentativasErros;
	}

	public Set<String> getLetrasAcertadas() {
		return letrasAcertadas;
	}

	public void setLetrasAcertadas(Set<String> letrasAcertadas) {
		this.letrasAcertadas = letrasAcertadas;
	}

	public Set<String> getLetrasChutadas() {
		return letrasChutadas;
	}

	public void setLetrasChutadas(Set<String> letrasChutadas) {
		this.letrasChutadas = letrasChutadas;
	}

	public List<String> getPalavrauser() {
		return palavrauser;
	}

	public void setPalavrauser(List<String> palavrauser) {
		this.palavrauser = palavrauser;
	}

	public int getMaxTentativas() {
		return maxTentativas;
	}

	public void setMaxTentativas(int maxTentativas) {
		this.maxTentativas = maxTentativas;
	}
	
}
