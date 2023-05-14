package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Interfaces.Grafo;

public class ServicioCaminos {
	
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int limite;
	private HashMap<Integer, String> colores = new HashMap<Integer,String>();
	private List<List<Integer>> caminos =  new ArrayList<List<Integer>>();

	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.limite = lim;
	}
	

	public List<List<Integer>> caminos(){
		if(this.grafo.contieneVertice(this.origen)&& this.grafo.contieneVertice(this.destino)) {
			Iterator<Integer> vertices =  this.grafo.obtenerVertices();
			while(vertices.hasNext()) {
				int vertice = vertices.next();
				this.colores.put(vertice, "BLANCO");
			}
			
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.origen);
			adyacentes =  this.grafo.obtenerAdyacentes(this.origen);
		
			while (adyacentes.hasNext()) {
				int pasos = 0;
				int adyacente = adyacentes.next();
				caminos.add(this.buscarCaminos(this.origen, pasos));
				
			}			
		}
		return caminos; 		
	}
	
	private List<Integer> buscarCaminos(int adyacente,int  pasos){
		List<Integer> recorrido =  new ArrayList<Integer>();

		Iterator<Integer> adyacentesDeAdyacente = this.grafo.obtenerAdyacentes(adyacente);
		
		pasos++;		
		this.colores.replace(adyacente, "AMARILLO");
		
		while (adyacentesDeAdyacente.hasNext()) {
			int siguiente = adyacentesDeAdyacente.next();

			if(this.colores.get(siguiente).equals("BLANCO") && siguiente != destino && pasos<this.limite) {
				recorrido.add(adyacente);
				buscarCaminos(siguiente, pasos);
			}
			System.out.println("recorrido "+ recorrido );
		}
		this.colores.replace(adyacente, "NEGRO");
		
		return recorrido;
		
		
	}
	
	@Override
	public String toString() {
		Iterator<List<Integer>> caminos= this.caminos.iterator(); 
		while(caminos.hasNext()) {
			List<Integer> recorrido =  caminos.next();
			return recorrido.toString();
		}
		
		
		return "";
		
	}
	
	
}
