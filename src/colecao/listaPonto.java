
/*
 * Projeto Coleção Pontos
	 * Autores:
	 * Thiago Souza	
 */

package colecao;

public class listaPonto {
 

    
    Ponto pontos[];
    private int validos;
    private final int maximo;
    
    public listaPonto( int N ){
        this.pontos = new Ponto[N];
        this.validos = 0;
        this.maximo = N;
    }

    public boolean add(Ponto p) {
    	    	
    	if((this.validos + 1) > this.maximo)
    	{
    		System.out.println("A lista está muito cheia.");
    		return false;
    	}
    	else
    	{
    		this.pontos[this.validos++] = p;
    	
    	}
       return true;
    } 
    
    public double maiorDistancia() {
    	double maxDistancia = -1;
    	
    	for(int x = 0; x < this.validos; x++) {
    		for(int y = 0; y < this.validos; y++) {
        		if(maxDistancia < this.pontos[x].distancia(this.pontos[y]))
        		{
        			maxDistancia = this.pontos[x].distancia(this.pontos[y]);
        		}
        	}
    		
    	}
    	return maxDistancia;
    }
    
    public listaPonto getContainsCircle(Circulo c) {
    	
    	listaPonto nova_lista = new listaPonto(this.maximo);
    	
    	for(int x = 0; x < this.validos; x++) {
    		if(c.estaDentro(this.pontos[x])) { 
    			nova_lista.add(this.pontos[x]); 
    		}
    	}
    	
    	return nova_lista;
    	
    }
    

    public void addIndex(int index, Ponto p) {
     
		
		if(index > this.validos || index < 1)
    	{
    		System.out.println("Esta posição não existe.");
    	}
		else
		{
			
			
			for(int i = (this.validos+1); i >= index; i--) {
	    				
	    		this.pontos[i+1] = this.pontos[i];
	    		
	    	}
				Ponto aux;
				aux = this.pontos[index-1];
		    	this.pontos[index-1] = p;
		    	this.pontos[index] = aux;
	    		this.validos++;	    		
    	}
       
    } 
    

    public Ponto removeIndex(int index) {
    	if(index <= this.validos) {
	    	Ponto salvar = this.pontos[index-1];
	    	
	    	for(int i=(index-1); i < this.validos;i++)
	    	{
	    		this.pontos[i] = this.pontos[i+1];
	    	}
	    	
	    	this.pontos[this.validos] = null;
	    	this.validos--;
	    	return salvar;
    	}
    	return null;
    }
    

    public int count() {
    	return this.validos;
    }
    

    public int busca_Elemento(Ponto p) 
    {
    	if(this.validos >= 1)
    	{
	    	for(int i=0; i < this.validos; i++)
	    	{
	    		if(p.igual(this.pontos[i]) == true) return (i+1);  	
	    	}
    	}
    	else
    	{
    		System.out.println("Não há elementos na lista.");
    		return -1;
    	}
    	return -1;
    }
    
    

    public void imprimir() {
    	
    	if(this.validos >= 1)
    	{
	    	for(int i=0; i < this.validos; i++)
	    	{
	    		System.out.println(
	    				 "\nPosição [" + (i+1) + "]"
	    			    + "\nPosição X: " + this.pontos[i].getx() 
	    				+ "\nPosição Y: " + this.pontos[i].gety()
	    				);    		
	    	
	    	}
    	}
    	else
    	{
    		System.out.println("Não há elementos na lista.");
    		return;
    	}
    }
    
}

