package model;

import java.util.List;
import java.util.Set;

public class Visual { //Apresentação visual da forca e informações de status do jogo (máscara da palavra, erros, tentativas, etc)

	private BancoWords banco;
	private List<String> temasAvaliable;
	
	public Visual() {
		this.banco = new BancoWords();
		this.temasAvaliable = banco.getTemas();
	}
	
	public void gerarInstrucoesIniciais(){
		//Gerando Instruções Iniciais
		
		String inicio = "Bem-vindo, para começar, escolha um tema: ";
		String temas = "";
		for(int i = 0; i < temasAvaliable.size(); i++){
			temas = temas + temasAvaliable.get(i) + " ----- ";
		}
		//Mostrando temas disponíveis
		System.out.println(inicio + "\n" + temas);
	}
	
	public String escolherPalavra(String tema){ // Através do tema, escolher a palavra
		System.out.println("Palavra escolhida! Hora de Iniciar o jogo!!!");
		return banco.gerarWord(tema);
	}
	
	public void escolherTentativas(){
		System.out.println("Deseja escolher uma quantidade de tentativa?\n Sim ou Nao?");
	}
	
	public void mostrarForca(List<String> palavrauser){
		String wordForca = "";
		for(String n : palavrauser){
			wordForca += n + "; ";
		}
		System.out.println(wordForca);
	}
	
	public void gerarEspacamentoInicial(String palavra, List<String> palavrauser){
		for(int i = 0; i < palavra.length(); i++){
			palavrauser.add("_");
		}
		mostrarForca(palavrauser);
	}
	
	public void aboutWord(String tema, String palavra){
		System.out.println("Tema: " + tema + "; Letras: " + palavra.length());
	}

	public void aboutTries(int tentativas, int tentativasErros){
		System.out.println("Quantidade de Tentativas Geral: " + tentativas + " \nQuantidade de Erros: " + tentativasErros);
	}
	
	public void help(Set<String> LetrasAcertadas, Set<String> LetrasChutadas, String Tema, String Palavra, int tentativas, int tentativasErros){
		System.out.println(" ---------- ***** / HELP / ***** ----------");
		aboutWord(Tema, Palavra);
		aboutTries(tentativas, tentativasErros);
		System.out.println("Letras Acertadas: " + LetrasAcertadas);
		System.out.println("Letras Chutadas: " + LetrasChutadas);
		System.out.println(" ---------- ***** / END HELP / ***** ----------");
	}

	public void win(String palavra, int tentativas, int tentativasErros){
		System.out.println(" ***** ----- ¨¨¨¨¨¨¨¨¨ PARABÉNS, VOCÊ VENCEU!!! ¨¨¨¨¨¨¨¨¨ ----- ***** ");
		System.out.println("Palavra: " + palavra);
		aboutTries(tentativas, tentativasErros);
	}
	
	public void lose(String palavra, int tentativas, int tentativasErros){
		caveira();
		System.out.println("Palavra: " + palavra);
		aboutTries(tentativas, tentativasErros);
	}
	
	public void caveira(){
		System.out.println("                 uuuuuuu");
		System.out.println("             uu$$$$$$$$$$$uu");
		System.out.println("          uu$$$$$$$$$$$$$$$$$uu");
		System.out.println("         u$$$$$$$$$$$$$$$$$$$$$u");
		System.out.println("        u$$$$$$$$$$$$$$$$$$$$$$$u");
		System.out.println("       u$$$$$$$$$$$$$$$$$$$$$$$$$u");
		System.out.println("       u$$$$$$$$$$$$$$$$$$$$$$$$$u");
		System.out.println("       u$$$$$$'   '$$$'   '$$$$$$u");
		System.out.println("       '$$$$'      u$u       $$$$'");
		System.out.println("        $$$u       u$u       u$$$");
		System.out.println("        $$$u      u$$$u      u$$$");
		System.out.println("         '$$$$uu$$$   $$$uu$$$$'");
		System.out.println("          '$$$$$$$'   '$$$$$$$'");
		System.out.println("            u$$$$$$$u$$$$$$$u");
		System.out.println("             u$'$'$'$'$'$'$u");
		System.out.println("  uuu        $$u$ $ $ $ $u$$       uuu");
		System.out.println(" u$$$$        $$$$$u$u$u$$$       u$$$$");
		System.out.println("  $$$$$uu      '$$$$$$$$$'     uu$$$$$$");
		System.out.println("u$$$$$$$$$$$uu    '''''    uuuu$$$$$$$$$$");
		System.out.println("$$$$'''$$$$$$$$$$uuu   uu$$$$$$$$$'''$$$'");
		System.out.println(" ''''      ''$$$$$$$$$$$uu ''$''''");
		System.out.println("           uuuu ''$$$$$$$$$$uuu");
		System.out.println("  u$$$uuu$$$$$$$$$uu ''$$$$$$$$$$$uuu$$$");
		System.out.println("  $$$$$$$$$$''''          ''''$$$$$$$$$$$'");
		System.out.println("   ''$$$$$''                      ''$$$$''");
		System.out.println("     '$$$'                         '$$$'");
	}
}
