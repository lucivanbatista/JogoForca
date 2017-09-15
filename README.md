# JogoForca
Jogo da Forca (PDS)

Descrição do Jogo - Requisitos
* Siga as regras estabelecidas aqui: http://pt.wikipedia.org/wiki/Jogo_da_forca Exceto por duas modificações:
* Não é necessário implementar a opção de acertar a palavra inteira (basta a opção de tentar uma letra de cada vez)
* O jogo é sempre contra o computador
* Escolha um tema específico para o conjunto de palavras do jogo (exemplo: Times de Futebol, Cidades, Glossário de Engenharia de Software, etc);
* O jogo deve conter pelo menos 30 palavras e usar seleção randômica;
* As palavras NÃO podem estar dentro do código fonte do jogo, devem estar em arquivo separado;
* A quantidade de erros permitidos e a representação visual/texto da “Forca” fica a critério do(a) programador(a)
* Devem ser sempre mostradas as tentativas anteriores do jogador
* Devem ser sempre mostradas as letras já acertadas do jogador dentro da palavra


1. Interação com o jogador (entrada e saída de dados)
2. Apresentação visual da forca e informações de status do jogo (máscara da palavra,
erros, tentativas, etc)
3. Base/repositório de palavras a serem usadas no jogo
4. Controle de tentativas, erros e acertos
5. Ciclo de vida da jogada (até morrer ou ganhar)


Novas Funções:
* Possibilidade do jogador reiniciar o jogo a qualquer momento com nova palavra
* Uso de termos com mais de uma palavra (ex.: “design de software”)
* Possibilidade do jogador escolher a quantidade de erros permitidas
* Aceitar tentativas em maiúsculas ou minúsculas
* Uso e mostrar palavras com acentuação, e aceitar tentativas de vogais sem acentuação como acerto (exemplo, tentativa 'a' é considerada acerto para 'a', 'à', 'à', 'ã', 'ä' ou 'â'.)
