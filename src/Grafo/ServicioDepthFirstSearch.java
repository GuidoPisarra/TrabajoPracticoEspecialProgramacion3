package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Interfaces.Grafo;

public class ServicioDepthFirstSearch {

	private int time;
	private HashMap<Integer, String> colores = new HashMap<Integer, String>();
	private Grafo<?> grafo;
	
	
	public ServicioDepthFirstSearch (Grafo<?> grafo ) {
		this.grafo = grafo;		
	}
	
	public void routeGrafo() {
		Iterator<Integer> vertices = this.grafo.obtenerVertices();

		while (vertices.hasNext()) {
			this.colores.put(vertices.next(), "BLANCO");
		}
		
		this.time = 0;
		vertices=this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			if(colores.get(vertices.next()).equals("BLANCO")) {
				this.visit_DFS(vertices.next());
			}
		}
	}
	
	private void visit_DFS (int verticeId) {
		colores.replace(verticeId,"AMARILLO");
		this.time ++;
		Iterator<Integer> verticesAdyacentes = this.grafo.obtenerAdyacentes(verticeId);
		
		while(verticesAdyacentes.hasNext()) {
			int adyacente = verticesAdyacentes.next();
			if(colores.get(adyacente).equals("BLANCO")) {
				visit_DFS(adyacente);
			}
		}
		colores.replace(verticeId, "NEGRO");
		
	}
	
	
	public List<Integer> dfsForest(){
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice =  vertices.next();
			this.colores.put(vertice, "BLANCO");
		}
		
		ArrayList<Integer> listado = new ArrayList<Integer>();
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			int vertice = vertices.next();
			if(colores.get(vertice).equals("BLANCO")) {
				listado.addAll(this.dfsForest(vertice));
			}
		}
		return listado;
	}
	
	private List<Integer> dfsForest(int verticeId){ 
		Iterator<Integer> adyacentes =  this.grafo.obtenerAdyacentes(verticeId);
		ArrayList<Integer> listado = new ArrayList<Integer>();
		this.colores.replace(verticeId,"AMARILLO");
		listado.add(verticeId);

		while (adyacentes.hasNext()) { 
			int adyacente = adyacentes.next();
			if(this.colores.get(adyacente).equals("BLANCO")) {
			    listado.addAll(dfsForest(adyacente));
			}			
		}
		
		this.colores.replace(verticeId, "NEGRO");
		return listado;
	}
	
	
}
