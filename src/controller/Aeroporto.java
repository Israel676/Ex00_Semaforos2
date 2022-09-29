package controller;

import java.util.concurrent.Semaphore;

public class Aeroporto extends Thread {
	
	private int idAviao;
	private Semaphore semaforo;
	
	public Aeroporto(int idAviao, Semaphore semaforo) {
		this.idAviao = idAviao;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		Manobra();
		Taxiar();
		try {
			semaforo.acquire();
			Decolagem();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			Afastamento();
		}
	}

	private void Manobra() {
		int tempo = (int)((Math.random() * 8 ) + 3);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void Taxiar() {
		int tempo = (int)((Math.random() * 11) + 5);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void Decolagem() {
		int tempo = (int)((Math.random() * 5) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#"+ idAviao + " decolou");
	}

	private void Afastamento() {
		int tempo = (int)((Math.random() * 9) + 3);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("#"+ idAviao + " foi embora");
	}
}
