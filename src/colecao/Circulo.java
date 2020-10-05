
/*
 *  Projeto Coleção Pontos
	 * Autores:
	 * Thiago Souza	
 */

package colecao;

public class Circulo {
    private Ponto centro;
    private double raio;

    public Circulo(Ponto centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    public boolean estaDentro(Ponto p){
        return this.centro.distancia(p) <= this.raio;
        
    }
    
    
}
