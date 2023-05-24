package tpe3PrimerParte;

import Grafo.GrafoDirigido;
import Grafo.ServicioBreadthFirstSearch;
import Grafo.ServicioCaminos;
import Grafo.ServicioDepthFirstSearch;

public class main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> grafoDirigido = new GrafoDirigido<Integer>();
		
		grafoDirigido.agregarVertice(1);
		grafoDirigido.agregarVertice(2);
		grafoDirigido.agregarVertice(3);
		grafoDirigido.agregarVertice(4);
		
		grafoDirigido.agregarArco(1, 2, 12);
		grafoDirigido.agregarArco(1, 3, 13);
		grafoDirigido.agregarArco(1, 4, 13);

		grafoDirigido.agregarArco(4, 1, 41);
		grafoDirigido.agregarArco(3, 4, 34);
		grafoDirigido.agregarArco(3, 2, 32);
		
		ServicioBreadthFirstSearch servicioBFS =  new ServicioBreadthFirstSearch(grafoDirigido);
		
		System.out.println("Recorrido BFS Forest: "+servicioBFS.bfsForest().toString());
		
		ServicioDepthFirstSearch servicioDFS = new ServicioDepthFirstSearch(grafoDirigido);
		
		System.out.println("Recorrido DFS Forest: "+servicioDFS.dfsForest().toString());
		
		ServicioCaminos servCaminos =  new ServicioCaminos(grafoDirigido, 1, 2, 2);
		
		System.out.println("Servicio caminos " + servCaminos.caminos().toString());
	}

}
