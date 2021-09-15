package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadvIngresso extends Thread{

		Random controle = new Random();
		private int idSortudo;
		private Semaphore Tempo;
		private static int nIngressos = 100;
		int CompraIn = controle.nextInt(4)+1;
		
		public void ThreadIngresso() {
			
		}
		public void ThreadIngresso(int idSortudo, Semaphore Tempo) {
			this.idSortudo = idSortudo;
			this.Tempo = Tempo;
			
		}
		
		public void run() {
		//login();
		    try {
			Tempo.acquire();
		    }catch(InterruptedException e) {
			    e.printStackTrace();
		     }finally {
			     Tempo.release();
		      }
		}
		private void login(){
//			Sistema comprador novo
			int tempo = (int) ((controle.nextInt(2000)+50));
			    if( tempo <1000) {
			    	sleep(tempo);
					try {
						CompraIn();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }else {
			    	System.out.println("Tempo-esgotado: Não foi possivel comcluir a compra dos ingressos");
			    }
		}
		
		private void sleep(int tempo2) {
			// TODO Auto-generated method stub
			
		}
		private void CompraIn() throws InterruptedException {
			System.out.println("# " +idSortudo+ "Comprando Ingresso");
			int tempo = (int) ((controle.nextInt(3000)+1000));
			    if(tempo <2500) {
			    	sleep(tempo);
					validacompra();
			    }else {
			    	System.out.println("Tempo-esgotado: Não foi possivel comcluir a compra dos ingressos");
			    }
		}
		
		private void validacompra() {
			if(nIngressos > 0 && CompraIn <= nIngressos) {
				nIngressos -= CompraIn;
				System.out.println("Parabens sua compra foi efetuada!!! de " + CompraIn + "ingressos");
				System.out.println("Número de ingressos disponiveis: "+ nIngressos);
			}
		}
	}
