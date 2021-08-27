public class IndentificadorDeCaminho implements Cloneable
{
    Fila<Coordenada> fila;
    
	private char[][] labirinto;
	
	private int linhaAtual;
	private int colunaAtual;
	
	private int linhaDireita;
	private int colunaDireita;
	Coordenada direita;
	
	private int linhaEsquerda;
	private int colunaEsquerda;
	Coordenada esquerda;
	
	private int linhaAcima;
	private int colunaAcima;
	Coordenada acima;
	
	private int linhaAbaixo;
	private int colunaAbaixo;
	Coordenada abaixo;    
	
	public IndentificadorDeCaminho(int linha, int coluna, char[][] labirinto)
	{
		linhaAtual = linha;		
		colunaAtual = coluna;
		this.labirinto = labirinto;
		calculasDirecoes();
	}
	
	private void calculasDirecoes()
	{		
		linhaDireita = linhaAtual;
		colunaDireita = colunaAtual + 1;		
		direita = new Coordenada(linhaDireita, colunaDireita);
		
		linhaEsquerda = linhaAtual;
		colunaEsquerda = colunaAtual - 1;
		esquerda = new Coordenada(linhaEsquerda, colunaEsquerda);
		
		linhaAcima = linhaAtual - 1;
		colunaAcima = colunaAtual;
		acima = new Coordenada(linhaAcima, colunaAcima);
		
		linhaAbaixo = linhaAtual + 1;
		colunaAbaixo = colunaAtual;
		abaixo = new Coordenada(linhaAbaixo, colunaAbaixo);
	}
	
	private Boolean analisaCaminhoExiste(int linha, int coluna)
	{
		if(linha < 0 || coluna < 0)
			return false;
			
		return true;
	}	
	
	private Boolean analiseCaminhoLivre(int linha, int coluna)
	{
		if(analisaCaminhoExiste(linha, coluna) == false)
		{
			return false;
		}
		
		if(labirinto[linha][coluna] == '#')
		{
			return false;
		}
		
		if(labirinto[linha][coluna] == 'E')
		{
			return false;
		}
		
		if(labirinto[linha][coluna] == '*')
		{
			return false;
		}
		
		if(labirinto[linha][coluna] == ' ' || labirinto[linha][coluna] == 'S')
		{
			return true;
		}
		
		return false;
	}
	
	public Fila getCaminhoLivre()
	{
		fila = new Fila<Coordenada>();
		
		if(analiseCaminhoLivre(linhaDireita, colunaDireita))
		{
			try
			{
				fila.guardeUmItem(direita);				
			}
			catch(Exception erro)
			{
				System.out.println(erro);
			}
		}		
		
		if(analiseCaminhoLivre(linhaEsquerda, colunaEsquerda))
		{
			try
			{
				fila.guardeUmItem(esquerda);				
			}
			catch(Exception erro)
			{
				System.out.println(erro);
			}			
		}
				
		if(analiseCaminhoLivre(linhaAcima, colunaAcima))
		{
			try
			{
				fila.guardeUmItem(acima);				
			}
			catch(Exception erro)
			{
				System.out.println(erro);
			}
			
		}	
		
		if(analiseCaminhoLivre(linhaAbaixo, colunaAbaixo))
		{
			try
			{
				fila.guardeUmItem(abaixo);				
			}
			catch(Exception erro)
			{
				System.out.println(erro);
			}			
		}
		
		return fila;
	}
		
	@Override
	public String toString()
	{
	 return ("Coordenadas direita: " + direita.toString() + ", " +
	 "Coordenada esquerda: " + esquerda.toString() +  ", " +
	 "Coordenada acima: " + acima.toString() + ", " +
	 "Coordenada abaixo: " + abaixo.toString());	
	}
	
	@Override
	public boolean equals (Object obj)
    {		
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(this.getClass() != IndentificadorDeCaminho.class)
            return false;

		if(this.labirinto != ((IndentificadorDeCaminho)obj).labirinto)
			return false;
			
		if(this.linhaAtual != ((IndentificadorDeCaminho)obj).linhaAtual)
			return false;
			
		if(this.colunaAtual != ((IndentificadorDeCaminho)obj).colunaAtual)
			return false;
			
		if(this.linhaDireita != ((IndentificadorDeCaminho)obj).linhaDireita)
			return false;
			
		if(this.colunaDireita != ((IndentificadorDeCaminho)obj).colunaDireita)
			return false;
			
		if(this.linhaEsquerda != ((IndentificadorDeCaminho)obj).linhaEsquerda)
			return false;
			
		if(this.colunaEsquerda != ((IndentificadorDeCaminho)obj).colunaEsquerda)
			return false;
			
		if(this.linhaAcima != ((IndentificadorDeCaminho)obj).linhaAcima)
			return false;
			
		if(this.colunaAcima != ((IndentificadorDeCaminho)obj).colunaAcima)
			return false;
			
		if(this.linhaAbaixo != ((IndentificadorDeCaminho)obj).linhaAbaixo)
			return false;
			
		if(this.colunaAbaixo != ((IndentificadorDeCaminho)obj).colunaAbaixo)
			return false;

        return true;
    }
	
	@Override
    public int hashCode ()
    {      
        int ret = 10;

        ret = 7 * ret + ((labirinto == null) ? 0 : labirinto.hashCode());
        ret = 7 * ret + new Integer (this.linhaAtual).hashCode();
        ret = 7 * ret + new Integer (this.colunaAtual).hashCode();
        ret = 7 * ret + new Integer (this.linhaDireita).hashCode();
        ret = 7 * ret + new Integer (this.colunaDireita).hashCode();
        ret = 7 * ret + new Integer (this.linhaEsquerda).hashCode();
        ret = 7 * ret + new Integer (this.colunaEsquerda).hashCode();
        ret = 7 * ret + new Integer (this.linhaAcima).hashCode();
        ret = 7 * ret + new Integer (this.colunaAcima).hashCode();
        ret = 7 * ret + new Integer (this.linhaAbaixo).hashCode();
        ret = 7 * ret + new Integer (this.colunaAbaixo).hashCode();
        
        if (ret < 0) ret = -ret;
        
        return ret;
    }
    
    public int compareTo (IndentificadorDeCaminho indentificadorDeCaminho)
	{
		if (this.linhaAtual < indentificadorDeCaminho.linhaAtual) return -10; 
		if (this.linhaAtual > indentificadorDeCaminho.linhaAtual) return 10;

		if (this.colunaAtual < indentificadorDeCaminho.colunaAtual) return -10;
		if (this.colunaAtual < indentificadorDeCaminho.colunaAtual) return 10;
		
		if (this.linhaDireita < indentificadorDeCaminho.linhaDireita) return -10;
		if (this.linhaDireita < indentificadorDeCaminho.linhaDireita) return 10;
		
		if (this.colunaDireita < indentificadorDeCaminho.colunaDireita) return -10;
		if (this.colunaDireita < indentificadorDeCaminho.colunaDireita) return 10;
		
		if (this.linhaEsquerda < indentificadorDeCaminho.linhaEsquerda) return -10;
		if (this.linhaEsquerda < indentificadorDeCaminho.linhaEsquerda) return 10;
		
		if (this.colunaEsquerda < indentificadorDeCaminho.colunaEsquerda) return -10;
		if (this.colunaEsquerda < indentificadorDeCaminho.colunaEsquerda) return 10;
		
		if (this.linhaAcima < indentificadorDeCaminho.linhaAcima) return -10;
		if (this.linhaAcima < indentificadorDeCaminho.linhaAcima) return 10;
		
		if (this.colunaAcima < indentificadorDeCaminho.colunaAcima) return -10;
		if (this.colunaAcima < indentificadorDeCaminho.colunaAcima) return 10;
		
		if (this.linhaAbaixo < indentificadorDeCaminho.linhaAbaixo) return -10;
		if (this.linhaAbaixo < indentificadorDeCaminho.linhaAbaixo) return 10;
		
		if (this.colunaAbaixo < indentificadorDeCaminho.colunaAbaixo) return -10;
		if (this.colunaAbaixo < indentificadorDeCaminho.colunaAbaixo) return 10;

		return 0;
	}  
    
    public Object clone ()
    {
        IndentificadorDeCaminho ret=null;

        try
        {
            ret = new IndentificadorDeCaminho (this);
        }
        catch (Exception erro)
        {} 

        return ret;
    }
    
    public IndentificadorDeCaminho (IndentificadorDeCaminho i) throws Exception
    {
        if(i == null)
            throw new Exception("Erro 404 IndentificadorDeCaminho");
        
        this.labirinto = i.labirinto;
        this.linhaAtual = i.linhaAtual;
        this.colunaAtual = i.colunaAtual;
        this.linhaDireita = i.linhaDireita;
        this.linhaEsquerda = i.linhaEsquerda;
        this.colunaEsquerda = i.colunaEsquerda;
        this.linhaAcima = i.linhaAcima;
        this.colunaAcima = i.colunaAcima;
        this.linhaAbaixo = i.linhaAbaixo;
        this.colunaAbaixo = i.colunaAbaixo;
        this.colunaAcima = i.colunaAcima;
    }
}
