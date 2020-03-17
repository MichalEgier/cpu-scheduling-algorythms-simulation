import java.util.Collections;
import java.util.LinkedList;

public class Algorytm_ROT extends Algorytm{

	//private LinkedList<Proces> list = new LinkedList<Proces>();
	
	private double kwantCzasu=0;
	
	public Algorytm_ROT(ListaProcesow lista) {
		super(lista);
	}
	
	//public void posegregujListe() {
//		listaWszystkich.posortujCzasamiWykonania();
//	}
	
public void obsluzProcesy() {
		
	if(kwantCzasu==0) obliczKwantCzasu();
		//Proces procesObslugiwany;
	
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
		
		for(double i=0.0;stop;i+=kwantCzasu) {
		
			//Warunek sprawdzajacy czy jest sens wogole wykonywac petle while, czy moze wszystkie procesy sa juz w aktualnych i tylko musza sie wykonac
			if((j<lp.size()))	
				a=true;
				else a = false;
			//dodawanie procesow do listy aktualnych procesow,jesli nadszedl czas ich wejscia
		while(a) {
			if(lp.get(j).getCzasWejscia()<=i) {
		listaAktualna.add(lp.get(j));
				//	listaAktualna.addOnGoodPosition(lp.get(j));
		//	listaAktualna.posortujCzasamiWykonania();
		//	if(j<lp.size()-1)	
		j++;// else a=false;
		}
			else {a=false;
		}
		if(j==lp.size()) a=false;
		}
		
		if(listaAktualna.size()!=0) {
		
		listaAktualna.get(0).setCzas(listaAktualna.get(0).getCzas()-kwantCzasu);
		
		
		//Scenariusz jezeli proces zostanie ukonczony w tej "turze"
		
			if(listaAktualna.get(0).getCzas()<=0) {
				
				double pozostalosc = 0 - listaAktualna.get(0).getCzas();
				
				if(listaAktualna.get(0).getCzas()<0) i-=pozostalosc;
				
				System.out.println("WYKONANY PROCES:" + listaAktualna.get(0));
			listaAktualna.get(0).setCzasZakonczenia(i);
			listaWykonanych.add(listaAktualna.get(0));
			listaAktualna.remove(0);
			}
			
			//Przerzucenie procesu na koniec kolejki jezeli nie zostal ukonczony
			else {
			Proces pr=listaAktualna.get(0);
			listaAktualna.remove(0);
			listaAktualna.add(pr);}
		}
		
		if(listaWykonanych.size()==listaWszystkich.size()) stop=false;
		
		//System.out.println("ListaP = " +lp + " listaWszystkich="+listaWszystkich);
	}
}
	/*
	public void obsluzProcesy() {
		posegregujListe();
		obliczKwantCzasu();
		
		LinkedList<Proces> lista = new LinkedList<Proces>();
		for(int i=0;i<list.size();i++) {
			lista.add(new Proces(this.list.get(i).getNazwa(),this.list.get(i).getCzas()));
		}
		System.out.println("\n\n\n");
		if(lista.equals(list)) System.out.println("lista.equals(list)");
		if(lista==list) System.out.println("lista==list");
		
		int i=0;
		boolean zakonczyloProces=false;
		while(lista.size()!=0) {
			System.out.println("Obslugiwanie procesu " + lista.get(i) + ".");
			lista.get(i).setCzas(lista.get(i).getCzas()-kwantCzasu);
			if(lista.get(i).getCzas()<=0) {
			System.out.println("PROCES " + lista.get(i) +". ZAKONCZONY");
			lista.remove(i);
			zakonczyloProces=true;
			}
			else System.out.println("Proces oddany w stan gotowoœci - pozosta³y czas wykonania:" + lista.get(i).getCzas());
			
			if(!zakonczyloProces) i++;
			if((i==(lista.size()))) i=0;
			zakonczyloProces=false;
		}
	}
	*/
	public void obliczKwantCzasu() {
	  kwantCzasu = listaWszystkich.get((int)(listaWszystkich.size()*0.8)).getCzas();
	  System.out.println("Wyliczono kwant czasu! Wyliczona wartosc=" + kwantCzasu);
	}
	
	public void zadajKwantCzasu(double a) {
	this.kwantCzasu=a;
	}
	/*
	public double policzSredniCzasOczekiwania() {
		if(kwantCzasu==0) obliczKwantCzasu();
		LinkedList<Proces> lista = new LinkedList<Proces>();//(LinkedList<Proces>)list.clone();
		for(int i=0;i<list.size();i++) {
			lista.add(new Proces(this.list.get(i).getNazwa(),this.list.get(i).getCzas()));
		}
		
		int i=0;
		double czasOczekiwania=0;
		boolean zakonczyloProces=false;
		while(lista.size()!=0) {
			
			lista.get(i).setCzas(lista.get(i).getCzas()-kwantCzasu);
			
			
			
			if(lista.get(i).getCzas()<=0) {
				czasOczekiwania+=((lista.size()-1)*(kwantCzasu-((-1.0)*lista.get(i).getCzas())));
				lista.remove(i);
			zakonczyloProces=true;
			}
			else// System.out.println("Proces oddany w stan gotowoœci - pozosta³y czas wykonania:" + lista.get(i).getCzas());
			czasOczekiwania+=((lista.size()-1) * kwantCzasu);
			if(!zakonczyloProces) i++;
			if(i==(lista.size())) i=0;
			zakonczyloProces=false;
		}
		
		return czasOczekiwania/list.size();
	} */
}
