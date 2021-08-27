import java.io.*;

public class LeitorDeMapa implements Cloneable
{
	private Coordenada coordenada;
	private SaidaCoordenada saidaCoordenada;
	
	private String mapa;
	private char[][] labirinto;
	private int linhas = 0;
	private int colunas = 0;
	private String linhaString = "";
	private String labirintoDesenhado;
	private boolean temEntrada = false;
	private boolean temSaida = false;
	private BufferedReader file = null;
	private int entradaQtd = 0;
	private int saidaQtd = 0;
	
	public LeitorDeMapa(String mapa)
	{
		this.mapa = mapa;
		ConstrutorDeLabirinto();
	}
	
	private void ConstrutorDeLabirinto()
	{			
		try
		{
			file = new BufferedReader(new FileReader(this.mapa));			
		}
		catch(Exception erro)
		{
			System.err.println("Arquivo de labirinto nao encontrado");
			System.exit(0);
		}		
			
		try
		{
			linhas = Integer.parseInt(file.readLine());
			colunas = Integer.parseInt(file.readLine());
		}
		catch(Exception erro)
		{}
		
		labirinto = new char[linhas][colunas];        
       
		for(int linha = 0; linha < linhas; linha++)
		{
			try
			{
				linhaString = file.readLine();
			}
			catch(Exception erro)
			{}
			
			for(int coluna = 0; coluna < colunas; coluna++)
			{
				labirinto[linha][coluna] = linhaString.charAt(coluna);
				
				if(linhaString.charAt(coluna) == 'E')
				{
					temEntrada = true;
					coordenada = new Coordenada(linha, coluna);
					entradaQtd++;
				}					
				
				if(linhaString.charAt(coluna) == 'S')
				{
					temSaida = true;
					saidaCoordenada = new SaidaCoordenada(linha, coluna);
					saidaQtd++;
				}
				
				if(linha == 0 || linha == linhas - 1)
				{
					if(linhaString.charAt(coluna) == ' ')
					{
						System.out.println("Esse esta labirinto sem parede.");
						System.exit(0);
					}
				}
				
				if(coluna == 0 || coluna == colunas - 1)
				{					
					if(linhaString.charAt(coluna) == ' ')
					{
						System.out.println("Esse esta labirinto sem parede.");
						System.exit(0);
					}
				}
			}			
		}
		
		if(temEntrada == false)
		{
			System.out.println("Este labirinto nao tem entrada.");
			System.exit(0);
		}
		
		if(temSaida == false)
		{
			System.out.println("Este labirinto nao tem saida.");
			System.exit(0);
		}
		
		if(entradaQtd > 1 || saidaQtd > 1)
		{
			System.out.println("Este labirinto tem mais de uma entrada ou saida.");
			System.exit(0);
		}
		
		
	}
	
	public Coordenada getCoordenada()
	{
		return coordenada;
	}
	
	public SaidaCoordenada getSaida()
	{
		return saidaCoordenada;
	}
	
	public char[][] getLabirinto()
	{
		return labirinto;
	}
	
	public void darPasso(int linha, int coluna)
	{
		labirinto[linha][coluna] = '*';
	}
	
	public void tiraPasso(int linha, int coluna)
	{
		labirinto[linha][coluna] = ' ';
	}
	
	@Override
	public String toString()
	{
		labirintoDesenhado = "";
		
		for(int linha = 0; linha < linhas; linha++)
		{
			for(int coluna = 0; coluna < colunas; coluna++)
			{
				labirintoDesenhado += labirinto[linha][coluna];
			}			
				labirintoDesenhado += "\n";
		}
		
		return labirintoDesenhado;
	}   
	
	@Override
	public boolean equals (Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(this.getClass() != LeitorDeMapa.class)
            return false;

		if(this.mapa != ((LeitorDeMapa)obj).mapa)
			return false;
			
		if(this.labirinto != ((LeitorDeMapa)obj).labirinto)
			return false;
			
		if(this.linhas != ((LeitorDeMapa)obj).linhas)
			return false;
			
		if(this.colunas != ((LeitorDeMapa)obj).colunas)
			return false;
			
		if(this.linhaString != ((LeitorDeMapa)obj).linhaString)
			return false;
			
		if(this.labirintoDesenhado != ((LeitorDeMapa)obj).labirintoDesenhado)
			return false;
			
		if(this.temEntrada != ((LeitorDeMapa)obj).temEntrada)
			return false;
			
		if(this.temSaida != ((LeitorDeMapa)obj).temSaida)
			return false;
			
		if(this.file != ((LeitorDeMapa)obj).file)
			return false;
			
		if(this.entradaQtd != ((LeitorDeMapa)obj).entradaQtd)
			return false;
			
		if(this.saidaQtd != ((LeitorDeMapa)obj).saidaQtd)
			return false;

        return true;
        
    }	
	
	@Override
	public int hashCode ()
    {
        int ret = 10;

        ret = 7 * ret + new Integer (this.mapa).hashCode();
        ret = 7 * ret + ((labirinto == null) ? 0 : labirinto.hashCode());
        ret = 7 * ret + new Integer (this.linhas).hashCode();
        ret = 7 * ret + new Integer (this.colunas).hashCode();
        ret = 7 * ret + new Integer (this.linhaString).hashCode();
        ret = 7 * ret + new Integer (this.labirintoDesenhado).hashCode();
        ret = temEntrada ? 1231 : 1237;
        ret = temSaida ? 1231 : 1237;
        ret = 7 * ret + ((file == null) ? 0 : file.hashCode());
        ret = 7 * ret + new Integer (this.entradaQtd).hashCode();
        ret = 7 * ret + new Integer (this.saidaQtd).hashCode();
        
        if (ret < 0) ret = -ret;
        
        return ret;
    }
    
    public int compareTo (LeitorDeMapa leitorDeMapa)
	{		
		if (this.linhas < leitorDeMapa.linhas) return -10;
		if (this.linhas < leitorDeMapa.linhas) return 10;
		
		if (this.colunas < leitorDeMapa.colunas) return -10;
		if (this.colunas < leitorDeMapa.colunas) return 10;
		
		if (this.entradaQtd < leitorDeMapa.entradaQtd) return -10;
		if (this.entradaQtd < leitorDeMapa.entradaQtd) return 10;
		
		if (this.saidaQtd < leitorDeMapa.saidaQtd) return -10;
		if (this.saidaQtd < leitorDeMapa.saidaQtd) return 10;

		return 0;
	} 
    
    public Object clone()
    {
        LeitorDeMapa ret = null;

        try
        {
            ret = new LeitorDeMapa (this);
        }
        catch (Exception erro)
        {} 

        return ret;
    }
    
    public LeitorDeMapa(LeitorDeMapa l) throws Exception
    {	
        if(l == null)
            throw new Exception("modelo ausente");

        this.mapa = l.mapa;
        this.labirinto = l.labirinto;
        this.linhas = l.linhas;
        this.colunas = l.colunas;
        this.linhaString = l.linhaString;
        this.labirintoDesenhado = l.labirintoDesenhado;
        this.temEntrada = l.temEntrada;
        this.temSaida = l.temSaida;
        this.file = l.file;
        this.entradaQtd = l.entradaQtd;
        this.saidaQtd = l.saidaQtd;
    }   
}
