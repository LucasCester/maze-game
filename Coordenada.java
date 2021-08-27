public class Coordenada implements Cloneable
{
	private int linha;
	private int coluna;
	
	public Coordenada(int linha, int coluna)
	{
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public void atualizaAtual(int linha, int coluna)
	{
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinhaAtual()
	{
		return linha;
	}
	
	public int getColunaAtual()
	{
		return coluna;
	}
	
	@Override
	public String toString()
	{
	
		return("Coordenada: " + linha + ", " + coluna);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this==obj)    
        {
            return true;
        }

        if (obj==null)  
        {
            return false;
        }

        if (obj.getClass() != Coordenada.class) 
        {
            return false;
        }

        if (this.linha != ((Coordenada)obj).linha)
        {
            return false;
        }
        
        if (this.coluna != ((Coordenada)obj).coluna)
        {
            return false;
        }
        
        return true;
	}
	
	@Override
	public int hashCode ()
    {      
        int ret = 10;

        ret = 7 * ret + new Integer (this.linha).hashCode();
        ret = 7 * ret + new Integer (this.coluna).hashCode();
        
        if (ret < 0) ret = -ret;
        
        return ret;
    }
    
    public int compareTo (Coordenada coordenada)
	{
		if (this.linha < coordenada.linha) return -10; 
		if (this.linha > coordenada.linha) return 10;

		if (this.coluna < coordenada.coluna) return -10;
		if (this.coluna < coordenada.coluna) return 10;

		return 0;
	}  
	
	public Object clone ()
    {
        Coordenada ret = null;

        try
        {
            ret = new Coordenada (this);
        }
        catch (Exception erro)
        {} 

        return ret;
    }
    
    public Coordenada (Coordenada c) throws Exception
    {
        if(c == null)
            throw new Exception("Erro 404 Coordenada");
        
        this.linha = c.linha;
        this.coluna = c.coluna;
    }
}
