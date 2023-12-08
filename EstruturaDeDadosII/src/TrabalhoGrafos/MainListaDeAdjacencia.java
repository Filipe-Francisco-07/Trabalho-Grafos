package TrabalhoGrafos;

import java.util.Map;

public class MainListaDeAdjacencia {

	public static void main(String[] args) {

		ListaDeAdjacencia grafo = new ListaDeAdjacencia(18,false);

		//0 = lisboa
		grafo.adicionarAresta(1, 0, 130 );
		grafo.adicionarAresta(12, 0, 70 );
		grafo.adicionarAresta(14, 0, 150 );
		grafo.adicionarAresta(15, 0, 50);
		//1 = leiria
		grafo.adicionarAresta(2, 1, 70 );
		grafo.adicionarAresta(0, 1, 130 );
		//2 = coimbra
		grafo.adicionarAresta(1, 2, 70 );
		grafo.adicionarAresta(3, 2, 80 );
		grafo.adicionarAresta(8, 2, 80 );
		grafo.adicionarAresta(10, 2, 160 );
		grafo.adicionarAresta(11, 2, 160 );
		//3 = aveiro
		grafo.adicionarAresta(4, 3, 70 );
		grafo.adicionarAresta(8, 3, 100 );
		grafo.adicionarAresta(2, 3, 80 );
		//4 = porto
		grafo.adicionarAresta(5, 4, 80 );
		grafo.adicionarAresta(6, 4, 50 );
		grafo.adicionarAresta(7, 4, 120 );
		grafo.adicionarAresta(3, 4, 70 );
		//5 = viana do castelo
		grafo.adicionarAresta(4, 5, 80 );
		grafo.adicionarAresta(6, 5, 50 );
		//6 = braga
		grafo.adicionarAresta(5, 6, 50 );
		grafo.adicionarAresta(7, 6, 100 );
		grafo.adicionarAresta(4, 6, 50 );
		//7 = vila real
		grafo.adicionarAresta(6, 7, 100 );
		grafo.adicionarAresta(9, 7, 140 );
		grafo.adicionarAresta(4, 7, 120 );
		grafo.adicionarAresta(8, 7, 110 );
		grafo.adicionarAresta(10, 7, 150 );
		//8 = viseu
		grafo.adicionarAresta(2, 8, 80 );
		grafo.adicionarAresta(3, 8, 100 );
		grafo.adicionarAresta(7, 8, 110 );
		grafo.adicionarAresta(10, 8, 80 );
		//9 = bragança
		grafo.adicionarAresta(7, 9, 140 );
		grafo.adicionarAresta(10, 9, 200 );
		//10 = guarda
		grafo.adicionarAresta(9, 10, 200 );
		grafo.adicionarAresta(7, 10, 150 );
		grafo.adicionarAresta(8, 10, 80 );
		grafo.adicionarAresta(2, 10, 160 );
		grafo.adicionarAresta(11, 10, 100 );
		//11 = castelo branco
		grafo.adicionarAresta(10, 11, 100 );
		grafo.adicionarAresta(2, 11, 160 );
		grafo.adicionarAresta(12, 11, 200 );
		grafo.adicionarAresta(13, 11, 80 );
		//12 = santarém
		grafo.adicionarAresta(11, 12, 200 );
		grafo.adicionarAresta(13, 12, 150 );
		grafo.adicionarAresta(14, 12, 120 );
		grafo.adicionarAresta(0, 12, 70 );
		//13 = portalegre
		grafo.adicionarAresta(11, 13, 80 );
		grafo.adicionarAresta(12, 13, 150 );
		grafo.adicionarAresta(14, 13, 100 );
		//14 = évora
		grafo.adicionarAresta(13, 14, 100 );
		grafo.adicionarAresta(12, 14, 120 );
		grafo.adicionarAresta(0, 14, 150 );
		grafo.adicionarAresta(16, 14, 80 );
		//15 = setúbal
		grafo.adicionarAresta(0, 15, 50 );
		grafo.adicionarAresta(16, 15, 135 );
		grafo.adicionarAresta(17, 15, 260 );
		//16 = beja
		grafo.adicionarAresta(14, 16, 80 );
		grafo.adicionarAresta(15, 16, 135 );
		grafo.adicionarAresta(17, 16, 170 );
		//17 = faro
		grafo.adicionarAresta(15, 17, 260 );
		grafo.adicionarAresta(16, 17, 170 );
			
		Map<Integer, Integer> a = grafo.dijkstra(0);
		
		grafo.mostrarListaAdjacencia();
		System.out.println("\nDijkstra:");
		System.out.println(a.toString());

		// verificar se um vertice é adjacSeSnte ao outro
		// lista de um unico vertice
	}

}