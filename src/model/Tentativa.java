package model;

public class Tentativa {

	public String letra;

	public Tentativa(String letra) {
		this.letra = semAcento(letra);
		this.letra = this.letra.toLowerCase();
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String semAcento(String txt) {
		String s = "";
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			switch (c) {
			case 'Á':
			case 'À':
			case 'Ã':
			case 'Â':
			case 'Ä':
				c = 'a';
				break;
			case 'É':
			case 'Ê':
				c = 'e';
				break;
			case 'Í':
				c = 'i';
				break;
			case 'Ó':
			case 'Õ':
			case 'Ô':
				c = 'o';
				break;
			case 'Ú':
				c = 'u';
				break;
			case 'Ç':
				c = 'c';
			case 'á':
			case 'à':
			case 'ã':
			case 'â':
			case 'ä':
				c = 'a';
				break;
			case 'é':
			case 'ê':
				c = 'e';
				break;
			case 'í':
				c = 'i';
				break;
			case 'ó':
			case 'õ':
			case 'ô':
				c = 'o';
				break;
			case 'ú':
				c = 'u';
				break;
			case 'ç':
				c = 'c';
				break;
			}
			s += c;
		}
		return s;
	}
}
