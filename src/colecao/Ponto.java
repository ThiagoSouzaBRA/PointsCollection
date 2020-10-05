
/*
 * Projeto Coleção Pontos
	 * Autores:
	 * Thiago Souza	
 */

package colecao;

public class Ponto {
    private int x;
    private int y;


    public Ponto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getx()
    {
    	return this.x;
    }
    
    public int gety()
    {
    	return this.y;
    }
    
    public int setx(int value) 
    {
    	return this.x = value;
    }
    
    public int sety(int value)
    {
    	return this.y = value;
    }    
    

    public boolean igual(Ponto p)
    {
        return this.x==p.x && this.y==p.y;
    }

    public double distancia(Ponto p) 
    {
        int c1 = this.x - p.x;
        int c2 = this.y - p.y;
        return Math.sqrt(c1*c1+c2*c2);
    }
    
    
}
