package tpe3;

import Grafo.GrafoDirigido;
import Grafo.ServicioBreadthFirstSearch;
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
		grafoDirigido.agregarArco(4, 1, 41);
		grafoDirigido.agregarArco(3, 4, 34);
		grafoDirigido.agregarArco(3, 2, 32);
		
		ServicioBreadthFirstSearch servicioBFS =  new ServicioBreadthFirstSearch(grafoDirigido);
		
		System.out.println("bfsForest: "+servicioBFS.bfsForest().toString());
		
		ServicioDepthFirstSearch servicioDFS = new ServicioDepthFirstSearch(grafoDirigido);
		
		System.out.println("dfsForest: "+servicioDFS.dfsForest().toString());
	}

}
