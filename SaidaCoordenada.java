public class SaidaCoordenada implements Cloneable
{
	private int linhaSaida;
	private int colunaSaida;
	
	public SaidaCoordenada(int linha, int coluna) 
	{
		linhaSaida = linha;
		colunaSaida = coluna;
	}
	
	public int getLinhaSaida()
	{
		return linhaSaida;
	}
	
	public int getColunaSaida()
	{
		return colunaSaida;
	}
	
	@Override
	public String toString()
	{
		return ("Coordenada da Saida: " + linhaSaida + ", " + colunaSaida);
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

        if (obj.getClass() != SaidaCoordenada.class) 
        {
            return false;
        }

        if (this.linhaSaida != ((SaidaCoordenada)obj).linhaSaida)
        {
            return false;
        }
        
        if (this.colunaSaida != ((SaidaCoordenada)obj).colunaSaida)
        {
            return false;
        }
        
        return true;
	}	
	
	@Override
	public int hashCode ()
    {      
        int ret = 10;

        ret = 7 * ret + new Integer (this.linhaSaida).hashCode();
        ret = 7 * ret + new Integer (this.colunaSaida).hashCode();
        
        if (ret < 0) ret = -ret;
        
        return ret;
    }
    
    public int compareTo (SaidaCoordenada saidaCoordenada)
	{
		if (this.linhaSaida < saidaCoordenada.linhaSaida) return -10; 
		if (this.linhaSaida > saidaCoordenada.linhaSaida) return 10;

		if (this.colunaSaida < saidaCoordenada.colunaSaida) return -10;
		if (this.colunaSaida < saidaCoordenada.colunaSaida) return 10;

		return 0;
	}    
    
    public Object clone ()
    {
        SaidaCoordenada ret = null;

        try
        {
            ret = new SaidaCoordenada (this);
        }
        catch (Exception erro)
        {} 

        return ret;
    }
    
    public SaidaCoordenada (SaidaCoordenada s) throws Exception
    {
        if(s == null)
            throw new Exception("Erro 404 SaidaCoordenada");
        
        this.linhaSaida = s.linhaSaida;
        this.colunaSaida = s.colunaSaida;
    }
}
