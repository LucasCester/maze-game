public class Index 
{	
    public static void main(String[] args) throws Exception 
    {
      SaidaCoordenada saidaCoordenada;
      Pilha<Coordenada> caminho = new Pilha<Coordenada>();
      Pilha<Fila<Coordenada>> possibilidades = new Pilha<Fila<Coordenada>>();
      Coordenada atual;
      LeitorDeMapa leitorDeMapa;        
      IndentificadorDeCaminho indentificadorDeCaminho;
      String mapa;
      String nome;
      Boolean naoAchouSaida = true;

			System.out.println();
			System.out.println("Qual seria seu nome, aventureiro ?");
			System.out.print("> ");			
      nome = Teclado.getUmString();
			
      System.out.println();
      System.out.println("Digite o nome do arquivo .txt para carregar o mapa:");
      System.out.print("> ");
      mapa = Teclado.getUmString();

      System.out.println();
      leitorDeMapa = new LeitorDeMapa(mapa);
      atual = leitorDeMapa.getCoordenada();
      saidaCoordenada = leitorDeMapa.getSaida();

      System.out.println("Esse e o mapa: ");
      System.out.println();
      System.out.print(leitorDeMapa.toString());
      System.out.println();
        
      while(naoAchouSaida)
      {			
				indentificadorDeCaminho = new IndentificadorDeCaminho(atual.getLinhaAtual(), atual.getColunaAtual(), leitorDeMapa.getLabirinto());
				Fila<Coordenada> fila = new Fila<Coordenada>();
				fila = indentificadorDeCaminho.getCaminhoLivre();
			
				if(fila.isVazia())
				{
					while(fila.isVazia())
					{
						try
						{
							atual.atualizaAtual(caminho.recupereUmItem().getLinhaAtual(), caminho.recupereUmItem().getColunaAtual());
						}
						catch(Exception erro)
						{
							System.out.println("Este labirinto nao tem caminho para a saida.");
							System.exit(0);
						}
										
						caminho.removaUmItem();
						leitorDeMapa.tiraPasso(atual.getLinhaAtual(), atual.getColunaAtual());
						System.out.println(leitorDeMapa.toString());
						fila = possibilidades.recupereUmItem();
						possibilidades.removaUmItem();
					}
				}
			
				atual = new Coordenada(fila.recupereUmItem().getLinhaAtual(), fila.recupereUmItem().getColunaAtual());
				caminho.guardeUmItem(atual);				
				fila.removaUmItem();		  
				leitorDeMapa.darPasso(atual.getLinhaAtual(), atual.getColunaAtual());
				possibilidades.guardeUmItem(fila);    
				System.out.print(leitorDeMapa.toString());
				System.out.println();			
			
				if(atual.getLinhaAtual() == saidaCoordenada.getLinhaSaida() && atual.getColunaAtual() == saidaCoordenada.getColunaSaida())
				{
					naoAchouSaida = false;
				}
			}
		
			System.out.println("Parabens " + nome + " voce saiu do labirinto!");
    }
}