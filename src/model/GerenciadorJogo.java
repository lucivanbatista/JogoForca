package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GerenciadorJogo { // Interação com o jogador (entrada e saída de dados)

	private String tema;
	private String palavra;
	private List<String> palavrauser; // Palavra sendo mostrada
	private Set<String> letrasAcertadas;
	private Set<String> letrasChutadas;
	private int tentativasErros;
	private int tentativas;
	private int maxTentativas;
	private int sizePalavra;
	private int sizeLetrasAcertadas;
	private ViewForca visual;
	private GerenciadorPartida gt;
	private char[] caracteres;
	
	public GerenciadorJogo() {
		this.tentativas = 0;
		this.tentativasErros = 0;
		this.maxTentativas = 0;
		this.letrasAcertadas = new HashSet<String>();
		this.letrasChutadas = new HashSet<String>();
		this.palavrauser = new ArrayList<String>();
		this.sizeLetrasAcertadas = 0;
		visual = new ViewForca();
		gt = new GerenciadorPartida();
	}
	
	public void startGame(){
		visual.gerarInstrucoesIniciais(); // Gerando instruções iniciais
		this.setTema(chooseTema()); // Escolhendo tema
		
		visual.escolherTentativas(); //Escolhendo qtd tentativas max
		this.setMaxTentativas(chooseTentativas());
		
		String word = visual.escolherPalavra(tema); // Escolhendo palavra
		this.setPalavra(word); // Palavra escolhida
		this.caracteres = this.palavra.toCharArray();
		this.setSizePalavra(sizePalavra(this.getPalavra(), this.getCaracteres()));
		
		visual.aboutWord(this.getTema(), this.getSizePalavra());
		visual.gerarEspacamentoInicial(this.getPalavra(), this.getPalavrauser(), this.getCaracteres());
		cicloGame();
	}
	
	public int sizePalavra(String palavra, char[] caracteres){
		int size = 0;
		for(int i = 0; i < caracteres.length; i++){
			if(caracteres[i] != ' '){
				size++;
			}
		}
		return size;
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
			GerenciadorLetra t = new GerenciadorLetra(sc.nextLine());
			
			optionsGame(t.getLetra());
			
			if(this.getLetrasAcertadas().contains(t.getLetra()) || this.getLetrasChutadas().contains(t.getLetra())){
				System.out.println("Essa letra já foi digitada!");
				visual.mostrarForca(this.getPalavrauser(), this.getCaracteres());
			}else{
				this.setSizeLetrasAcertadas(gt.analise(this.getPalavra(), this.getLetrasAcertadas(), this.getLetrasChutadas(), t, this.getPalavrauser(), this.getSizeLetrasAcertadas()));	
				this.setTentativas(gt.getTentativas());
				this.setTentativasErros(gt.getTentativasErros());
				
				visual.mostrarForca(this.getPalavrauser(), this.getCaracteres());
			}
		}
	}
	
	public boolean stopGame(){
		if(this.getTentativasErros() == this.getMaxTentativas()){
			visual.lose(this.getPalavra(),  this.getTentativas(), this.getTentativasErros());
			return false;
		}
		if(this.getSizeLetrasAcertadas() == this.getSizePalavra()){
			visual.win(this.getPalavra(),  this.getTentativas(), this.getTentativasErros());
			return false;
		}
		return true;
	}

	public void optionsGame(String option){
		if(option.equals("help")){
			visual.help(this.getLetrasAcertadas(), this.getLetrasChutadas(), this.getTema(), this.getSizePalavra(), this.getTentativas(), this.getTentativasErros(), this.getSizeLetrasAcertadas());
			visual.mostrarForca(this.getPalavrauser(), this.getCaracteres());
			cicloGame();
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
		visual = new ViewForca();
		gt = new GerenciadorPartida();
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

	
	public char[] getCaracteres() {
		return caracteres;
	}

	
	public void setCaracteres(char[] caracteres) {
		this.caracteres = caracteres;
	}

	
	public int getSizePalavra() {
		return sizePalavra;
	}
	

	public void setSizePalavra(int sizePalavra) {
		this.sizePalavra = sizePalavra;
	}

	
	public int getSizeLetrasAcertadas() {
		return sizeLetrasAcertadas;
	}

	
	public void setSizeLetrasAcertadas(int sizeLetrasAcertadas) {
		this.sizeLetrasAcertadas = sizeLetrasAcertadas;
	}
	
}
