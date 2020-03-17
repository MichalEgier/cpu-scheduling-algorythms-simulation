//import java.util.Collections;
//import java.util.LinkedList;

public class Algorytm_SJF extends Algorytm {

	//private LinkedList <Proces> lista = new LinkedList <Proces>();
	//private ListaProcesow<Proces> = new ListaProcesow(lista);
	public Algorytm_SJF(ListaProcesow lista) {
		super(lista);
	}
	
public void obsluzProcesy() {
		
	//	Proces procesObslugiwany;
	
		//Niekonieczne utworzenie listy drugiej i przekopiowanie do niej obiektow dla bezpieczenstwa
		
		ListaProcesow lp = new ListaProcesow();
		
		for(int i=0;i<this.listaWszystkich.size();i++) {
			lp.add(new Proces(this.listaWszystkich.get(i).getNazwa(),this.listaWszystkich.get(i).getCzas(),this.listaWszystkich.get(i).getCzasWejscia()));
		}
		
		lp.sort(new Comparator_CzasWejscia()); //Posortowanie dla nastepnego algorytmu wrzucajacego procesy wszystkie do aktualnych
		
		boolean stop=true;
		//Warunek zatrzymania petli - petla symulujaca czas zatrzyma sie jak skoncza sie wykonywac wszystkie procesy
		//czyli innymi slowy lista wykonanych bedzie wielkosci wszystkich
		int j=0;  //Zmienna iterujaca po liscie WSZYSTKICH procesow
		boolean a;
		
		for(double i=0.0;stop;i+=0.1) {
		
			//Warunek sprawdzajacy czy jest sens wogole wykonywac petle while, czy moze wszystkie procesy sa juz w aktualnych i tylko musza sie wykonac
			if((j<lp.size()))	
				a=true;
				else a = false;
			
		while(a) {
			if(lp.get(j).getCzasWejscia()<=i) {
			listaAktualna.addOnGoodPositionButNotFirst(lp.get(j));
		//	listaAktualna.posortujBezWywlaszczenia();
	//		if(j<lp.size()-1)	
		j++;// else a=false;
		}
			else {a=false;
		}
		if(j==lp.size()) a=false;
		}
		
		if(listaAktualna.size()!=0) {
		
		listaAktualna.get(0).setCzas(listaAktualna.get(0).getCzas()-0.1);
		
			if(listaAktualna.get(0).getCzas()<=0) {
				if(listaAktualna.get(0).getCzas()<0) i-=(0-listaAktualna.get(0).getCzas());
				System.out.println("WYKONANY PROCES:" + listaAktualna.get(0));
			listaAktualna.get(0).setCzasZakonczenia(i);
			listaWykonanych.add(listaAktualna.get(0));
			listaAktualna.remove(0);
			}
		
		}
		
		if(listaWykonanych.size()==listaWszystkich.size()) stop=false;
		
		//System.out.println("ListaP = " +lp + " listaWszystkich="+listaWszystkich);
	}
}
	
/*	public void obsluzProcesy() {
		Collections.sort(lista);
		for(int i=0;i<lista.size();i++) {
			System.out.println("OBSLUGUJE PROCES:" + lista.get(i));
		}
	}
	
	public double policzSredniCzasOczekiwania() {
		obsluzProcesy();
		double czasOczekiwaniaProcesow=0;;double czasOczekiwaniaPojedynczy=0;
		for(int i=0;i<lista.size();i++) {
			 for(int j=(i+1);j<lista.size();j++) {
				 czasOczekiwaniaPojedynczy+=lista.get(i).getCzas();
			 }
			 
			 czasOczekiwaniaProcesow+=czasOczekiwaniaPojedynczy;
			 czasOczekiwaniaPojedynczy=0;
			 
		}
		return czasOczekiwaniaProcesow/lista.size();
	}
	*/
}
