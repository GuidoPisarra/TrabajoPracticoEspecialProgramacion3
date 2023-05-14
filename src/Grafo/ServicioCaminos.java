package Grafo;

import java.util.Iterator;
import java.util.List;

import Interfaces.Grafo;

public class ServicioCaminos {
	
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int limite;
	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.limite = lim;
	}
	

	public List<List<Integer>> caminos(){
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		
		if(this.grafo.contieneVertice(origen)&& this.grafo.contieneVertice(destino)) {
			
			
		}
		
		
	}
	
	
	
	
}
