package Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Interfaces.Grafo;

public class ServicioCaminos {
	
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	private List<Arco<?>> arcosVisitados = new ArrayList<Arco<?>>();
	private List<List<Integer>> caminosResultantes = new LinkedList<List<Integer>>();
	
	

	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}


	public List<List<Integer>> caminos() {
		if(this.grafo.contieneVertice(origen)&&this.grafo.contieneVertice(destino)) {			
			LinkedList<Integer> cam = new LinkedList<Integer>();
			this.arcosVisitados.clear();
			int pasos = 0;
			cam.add(this.origen);
			buscarCamino(cam, this.origen , pasos);				
		}	
		return this.caminosResultantes;
	}
	
	private void buscarCamino(List<Integer> caminoActual, int actual, int pasos){
		if(actual==this.destino) {
			ArrayList<Integer> camino = new ArrayList<Integer>(); 
			camino.addAll(caminoActual); 
			this.caminosResultantes.add(camino);
		}else {
			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(actual);	
			if(pasos<this.lim) { 
				while (adyacentes.hasNext()) {
					int adyacente = adyacentes.next(); 
					Arco<?> arco = this.grafo.obtenerArco(actual, adyacente); 
					if(!this.arcosVisitados.contains(arco)) { 
						caminoActual.add(adyacente); 
						buscarCamino(caminoActual, adyacente, pasos+1); 
						this.arcosVisitados.add(arco); 					
						caminoActual.remove(caminoActual.size()-1);
						this.arcosVisitados.remove(arcosVisitados.size()-1);
					}
				}				
			}			
		}		
	}
	
	
//	private void buscarCamino(List<Integer> caminoActual, int actual, int pasos){
//		if(actual==this.destino) {
//			ArrayList<Integer> camino = new ArrayList<Integer>(); 
//			camino.addAll(caminoActual); 
//			this.caminosResultantes.add(camino);
//		}else {
//			Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(actual);	
//			if(pasos<this.lim) { 
//				while (adyacentes.hasNext()) {
//					int adyacente = adyacentes.next(); 
//					Arco<?> arco = this.grafo.obtenerArco(actual, adyacente); 
//					System.out.println(this.arcosVisitados.contains(arco));
//					if(!this.arcosVisitados.contains(arco)) { 
//						caminoActual.add(adyacente); 
//						buscarCamino(caminoActual, adyacente, pasos+1); 
//						this.arcosVisitados.add(arco); 					
//						caminoActual.remove(caminoActual.size()-1);
//						this.arcosVisitados.remove(arcosVisitados.size()-1);
//					}
//				}				
//			}			
//		}		
//	}

	
}
