
/*
 * Projeto Coleção Pontos
	 * Autores:
	 * Thiago Souza
 */

package colecao;

import java.util.Scanner;

public class Main{

public static void imprimirPainel() {
	System.out.println("====================================================================");
	System.out.println("=============================== MENU ===============================");
	System.out.println("====================================================================");
	System.out.println("[0] - Sair do programa.");
	System.out.println("[1] - Adicionar um elemento a lista.");
	System.out.println("[2] - Adicionar um elemento em uma posição na lista.");
	System.out.println("[3] - Exibir a posição do primeiro ponto encontrado.");
	System.out.println("[4] - Remover um ponto por posição");
	System.out.println("[5] - Exibir a distancia entre os pontos mais distantes.");
	System.out.println("[6] - Exibir a coleção de pontos contidos em um determinado circulo.");
	System.out.println("[7] - Imprimir lista.");
	System.out.println("====================================================================");
	System.out.println("Por favor digite a operação: ");
}
 
public static void main(String[] args) {

	System.out.println("Seja bem vindo ao programa de criação de pontos.");
	System.out.println("Agradecimentos ao professor Fábio Aparecido Gamarra Lubacheski.");
	System.out.println("(PROJETO DE PARADIGMAS DE LINGUAGEM DE PROGRAMAÇÃO)");
	
	imprimirPainel();

	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	
	String op = in.nextLine();
	
	listaPonto lista = new listaPonto(5);
	
	while(op != "0") {
			
		switch(op) {
		case "1":
			
			System.out.println("Por favor, insira o valor de coordenada x do ponto: ");
			int x = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor, insira o valor de coordenada y do ponto: ");
			int y = Integer.parseInt(in.nextLine());
			
			if(lista.add(new Ponto(x,y)))
			{
				System.out.println("[Sucesso] - Ponto adicionado com sucesso.");
			}
			else 
			{
				System.out.println("[Erro] - Falha ao adicionar ponto.");
			}
			
			break;
		case "2":
			
			System.out.println("Por favor, insira o valor de coordenada x do ponto: ");
			int posX = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor, insira o valor de coordenada y do ponto: ");
			int posY = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor, insira a posição desejada: ");
			int pos = Integer.parseInt(in.nextLine());
			
			lista.addIndex(pos, new Ponto(posX,posY));
			
			break;
		case "3":
			
			System.out.println("Por favor, insira o valor de coordenada x do ponto que deseja encontrar: ");
			int buscaX = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor, insira o valor de coordenada y do ponto que deseja encontrar: ");
			int buscaY = Integer.parseInt(in.nextLine());
			
			int posicaoBusca = lista.busca_Elemento(new Ponto(buscaX,buscaY));
			
			if(posicaoBusca > -1) {
				System.out.println("[Sucesso] - Ponto encontrado na posição > " + posicaoBusca );
			}
			else
			{
				System.out.println("[Erro] - Ponto não encontrado.");
			}
			
			break;
		case "4":
			System.out.println("Por favor, insira a posição do ponto que deseja remover: ");
			int posRemover = Integer.parseInt(in.nextLine());
			
			Ponto pontoRemovido;
			pontoRemovido = lista.removeIndex(posRemover);
			
			if(pontoRemovido != null) {
				
				System.out.println("[Sucesso] - Ponto [x]: " + pontoRemovido.getx() + " [y]: " + pontoRemovido.gety() + "   removido com sucesso.");

			}
			else
			{
				System.out.println("[Erro] - Ponto não encontrado para remoção.");
			}
			
			break;
		case "5":
				double maiorDistancia = lista.maiorDistancia();
				if(lista.count() > 1)
				{
					System.out.println("[Sucesso] - A maior distância encontrado é de : " + maiorDistancia);
				}
				else
				if(lista.count() == 0)
				{
					System.out.println("[Erro] - Não foram encontrados pontos na lista.");
				}
				else
				if(lista.count() == 1)
				{
					System.out.println("[Erro] - Não foi possivel calcular a distância, lista contém apenas 1 ponto.");
				}
			break;
		case "6":
			
			System.out.println("Por favor insira a coordenada X do ponto central do circulo :");
			int posCirculoX = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor insira a coordenada Y do ponto central do circulo :");
			int posCirculoY = Integer.parseInt(in.nextLine());
			
			System.out.println("Por favor insira o raio do circulo :");
			double raioCirculo = Double.parseDouble(in.nextLine());
			
			Circulo c = new Circulo(new Ponto(posCirculoX,posCirculoY), raioCirculo);
			
			listaPonto pontosContidosNoCirculo;
			pontosContidosNoCirculo = lista.getContainsCircle(c);
			
			if(pontosContidosNoCirculo.count() > 0) {
				System.out.println("=================================================\nElementos contidos no circulo :");
				pontosContidosNoCirculo.imprimir();
			}
			else
			{
				System.out.println("[Falha] - Não foi encontrado nenhum elemento contido no circulo.");				
			}
			
			break;
		case "7":
			lista.imprimir();
			break;
		default:
			
			imprimirPainel();
			System.out.println("Operação inválida.");
		}
		
		System.out.println("Pressione ENTER para realizar mais uma operação.. ");
		
		in.nextLine();
		
		imprimirPainel();
		op = in.nextLine();
	}	

  }
}
