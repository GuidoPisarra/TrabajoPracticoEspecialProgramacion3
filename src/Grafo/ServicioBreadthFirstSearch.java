package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Interfaces.Grafo;

public class ServicioBreadthFirstSearch {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> verticesVisitados = new HashMap<Integer,Boolean>() ; 
	private LinkedList<Integer> fila = new LinkedList<Integer>();
	
	public ServicioBreadthFirstSearch(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public void routeGrafo() {
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			this.verticesVisitados.put(vertice, false);
		}
		
		this.fila.clear();	
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			if(verticesVisitados.get(vertice).equals(false)) {
				this.visit_BFS(vertice);
			}
		}
		
	}
	
	private void visit_BFS(int verticeId) {
		this.verticesVisitados.put(verticeId, true);
		this.fila.add(verticeId);
		while(!fila.isEmpty()) {
			fila.poll();
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
			while (adyacentes.hasNext()) {
				int adyacente = adyacentes.next();
				if(verticesVisitados.get(adyacente).equals(false)) {
					this.verticesVisitados.replace(verticeId, true);
					fila.add(adyacentes.next());
				}
			}
		}
	}
	
	public List<Integer> bfsForest(){
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		
		while(vertices.hasNext()) {
			int vertice =  vertices.next();
			this.verticesVisitados.put(vertice, false);			
		}
		ArrayList<Integer> listado = new ArrayList<Integer>();

		this.fila.clear();
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			if(verticesVisitados.get(vertice).equals(false)) {
				listado.addAll(bfsForest(vertice));
			}
		}		
		return listado;
	}
	
	private List<Integer> bfsForest(int verticeId){ //TODO PREGUNTAR!!!! No se si esta bien...
		ArrayList<Integer> listado = new ArrayList<Integer>();
		Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(verticeId);
		this.verticesVisitados.replace(verticeId, true);
		fila.add(verticeId);
		listado.add(verticeId);
		
		while(!fila.isEmpty()) {
			fila.remove(0);
			while (adyacentes.hasNext()) {
				int adyacente = adyacentes.next();
				
				//if(verticesVisitados.get(adyacente).equals(false)) { 
					fila.add(adyacente);
				//}
			}
		}
		return listado;
	}

	
}
