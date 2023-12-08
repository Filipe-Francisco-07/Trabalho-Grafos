package TrabalhoGrafos;

import java.util.*;

class Aresta{
	int origem, destino, peso;
	
	public Aresta(int origem, int destino, int peso){
		this.destino = destino;
		this.origem = origem;
		this.peso = peso;
	}
}

public class ListaDeAdjacencia {
	
	private int nVertices;
	private List<List<Aresta>> adjacencias;
	private boolean direcionado;
	
	public ListaDeAdjacencia(int nVertices, boolean direcionado) {
		this.nVertices = nVertices;
		this.direcionado = direcionado;
		this.adjacencias = new ArrayList<>(nVertices);
		for(int i = 0; i<nVertices;i++) {
			adjacencias.add(new ArrayList<Aresta>());
		}
	}
	
	public void adicionarAresta(int u, int v, int peso) {
		Aresta aresta = new Aresta(u,v,peso);
		adjacencias.get(u).add(aresta);
		if(!direcionado) {
			Aresta arestaInvertida = new Aresta(v,u,peso);
			adjacencias.get(v).add(arestaInvertida);
		}
		
	}
	
	public void adicionarAresta(int u, int v) {
		adicionarAresta(u,v,1);
	}
	
	public void mostrarListaAdjacencia() {
		for(int i = 1;i < nVertices;i++) {
			System.out.print("Vertice "+i+": ");
			for(Aresta aresta: adjacencias.get(i)) {
				System.out.print("["+aresta.destino+" Peso: "+aresta.peso+"]");
			}
			System.out.println();
		}
	}
	
	public void removerAresta(int u, int v) {
		List<Aresta> arestasU = adjacencias.get(u);
		for(Aresta aresta : arestasU) {
			if(aresta.destino == v) {
				arestasU.remove(aresta);
				break;
			}
		}
		if(!direcionado) {
			List<Aresta> arestasV = adjacencias.get(v);
			for(Aresta aresta: arestasV) {
				if(aresta.destino == u) {
					arestasV.remove(aresta);
					break;
				}
			}
		}
		
	}
	
	public boolean xAdjacenteY(int u,int v) {
		for(Aresta aresta: adjacencias.get(u)) {
			if(aresta.destino == v) {
				return true;
			}
		}
		return false;
	}
	
	public void mostrarUnicoVertice(int v) {
		System.out.print("Vertice: "+v);
			for(Aresta aresta: adjacencias.get(v)) {
				System.out.print("["+aresta.destino+" Peso: "+aresta.peso+"]");
			}
			System.out.println();
	}
	
	public void removerVertice(int vertice) {
	    for (List<Aresta> arestas : adjacencias) {
	        arestas.removeIf(aresta -> aresta.destino == vertice);
	    }
	    adjacencias.get(vertice).clear();
	}
	
	public boolean verificaConexo() {
	    boolean[] visitados = new boolean[nVertices];
	    dfs(0, visitados);

	    for (boolean visitado : visitados) {
	        if (!visitado) {
	            return false;
	        }
	    }

	    return true;
	}

	private void dfs(int vertice, boolean[] visitados) {
	    visitados[vertice] = true;
	    for (Aresta aresta : adjacencias.get(vertice)) {
	        if (!visitados[aresta.destino]) {
	            dfs(aresta.destino, visitados);
	        }
	    }
	}
	
	public boolean verificaCompleto() {
	    for (int i = 0; i < nVertices; i++) {
	        for (int j = 0; j < nVertices; j++) {
	            if (i != j && !xAdjacenteY(i, j)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	
	public Map<Integer, Integer> dijkstra(int origem) {
	    Map<Integer, Integer> distancias = new HashMap<>();
	    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

	    heap.add(new int[]{origem, 0});

	    while (!heap.isEmpty()) {
	        int[] top = heap.poll();
	        int vertice = top[0];
	        int distancia = top[1];

	        if (distancias.containsKey(vertice)) {
	            continue;
	        }

	        distancias.put(vertice, distancia);

	        for (Aresta aresta : adjacencias.get(vertice)) {
	            if (!distancias.containsKey(aresta.destino)) {
	                heap.add(new int[]{aresta.destino, distancia + aresta.peso});
	            }
	        }
	    }

	    return distancias;
	}
	
	public String verificarTipoEuleriano() {
	    int impar = 0;
	    for (int i = 0; i < nVertices; i++) {
	        if (adjacencias.get(i).size() % 2 != 0) {
	            impar++;
	        }
	    }

	    if (impar == 0) {
	        return "Euleriano";
	    } else if (impar == 2) {
	        return "Semi-Euleriano";
	    } else {
	        return "Não Euleriano";
	    }
	}
	
	public String verificarTipoHamiltoniano() {
	    int grauMin = Integer.MAX_VALUE;
	    int grauMax = 0;

	    for (int i = 0; i < nVertices; i++) {
	        int grau = adjacencias.get(i).size();
	        if (grau < grauMin) {
	            grauMin = grau;
	        }
	        if (grau > grauMax) {
	            grauMax = grau;
	        }
	    }

	    if (grauMin >= nVertices / 2) {
	        return "Hamiltoniano";
	    } else if (grauMax >= nVertices / 2) {
	        return "Semi-Hamiltoniano";
	    } else {
	        return "Não Hamiltoniano";
	    }
	}
}