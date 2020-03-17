import java.util.LinkedList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		String a;
		double b, c;
		Random random = new Random();
		
		ListaProcesow lista = new ListaProcesow();
		ListaProcesow lista2 = new ListaProcesow();
		ListaProcesow lista3 = new ListaProcesow();
		
		for(int i=0;i<100;i++) {
			a="ProcesNr" + (i+1);
			b=random.nextDouble()*50;
			c=random.nextDouble()*450;
			lista.add(new Proces(a,b,c));
			lista2.add(new Proces(a,b,c));
			lista3.add(new Proces(a,b,c));
		}
		
		Algorytm_FCFS algFIFO = new Algorytm_FCFS(lista);
		Algorytm_SJF algSJF = new Algorytm_SJF(lista2);
		Algorytm_ROT algROT = new Algorytm_ROT (lista3);
		
		Algorytm [] tab = new  Algorytm [4];
		
		tab[0]=algFIFO;
		tab[1]=algSJF;
		tab[2]=algROT;
		
	//	((Algorytm_ROT)tab[2]).zadajKwantCzasu(3.3);
		
	/*	for(Algorytm al:tab) {
			al.obsluzProcesy();
			System.out.println("--------------------------------------------");
			System.out.println("SREDNI CZAS OCZ. ALGORYTMU=" +al.policzSredniCzasOczekiwania());
			System.out.println("--------------------------------------------");
		}*/System.out.println("\n\nALGORYTM SJF BEZ WYWLASZCZENIA\n\n");
		algSJF.obsluzProcesy();
		System.out.println("\n\n\nSredni czas oczekiwania SJF bez wywlaszczenia=" +algSJF.policzSredniCzasOczekiwania());
	//	System.out.println(algFIFO.listaWszystkich);
		System.out.println("\n\nALGORYTM FIFO\n\n");
		algFIFO.obsluzProcesy();
	//	System.out.println(algFIFO.listaWykonanych);
		System.out.println("Sredni czas oczekiwania FIFO=" + algFIFO.policzSredniCzasOczekiwania());
	//	System.out.println(algFIFO.listaWykonanych.get(49).getCzasZakonczenia());
		
		Algorytm_SJF_z_Wywlaszczeniem algWywl = new Algorytm_SJF_z_Wywlaszczeniem(lista3);
		System.out.println("\n\nALGORYTM SJF Z WYWLASZCZENIEM\n\n");
		algWywl.obsluzProcesy();
		System.out.println("Sredni czas oczekiwania SJF z wywlaszczeniem=" + algWywl.policzSredniCzasOczekiwania());	
	//	LinkedList <Integer> list = new LinkedList<Integer>();
	//	list.add(new Integer(3));
	//	list.add(0,new Integer (1));
	//	System.out.println(list);
		System.out.println("\n\n\nALGORYTM ROTACYJNY \n \n\n");
		algROT.zadajKwantCzasu(0.1);
		//algROT.zadajKwantCzasu(100);
		algROT.obsluzProcesy();
		System.out.println("Sredni czas oczekiwania ROT="+algROT.policzSredniCzasOczekiwania());
		
	//	System.out.println("SJF listaWszystkich"+algSJF.listaWszystkich+"\nROT listaWszystkich" + algROT.listaWszystkich);
	//	System.out.println("SJF listaWykonanych"+algSJF.listaWykonanych + "\nROT listaWykonanych" + algROT.listaWykonanych);
		tab[3]= algWywl;
		for(Algorytm al:tab) {
			System.out.println(al.getClass() + " " + al.policzSredniCzasOczekiwania());
		}
	}

}
