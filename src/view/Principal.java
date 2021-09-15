package view;

import java.util.concurrent.Semaphore;

import controller.ThreadvIngresso;

public class Principal {

	public static void main(String[] args) {
		Semaphore Tempo = new Semaphore(1);
		
		for(int idSortudo = 1; idSortudo <=300; idSortudo++) {
			Thread ingresso = new ThreadvIngresso();
			ingresso.start();
		}
		

	}

}
