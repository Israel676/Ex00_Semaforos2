package view;

import java.util.concurrent.Semaphore;

import controller.Aeroporto;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 2;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int i = 0; i < 12; i++) {
			Aeroporto t = new Aeroporto(i, semaforo);
			t.start();
		}
	}

}
