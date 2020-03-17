
public abstract class Algorytm {
	
 ListaProcesow listaAktualna = new ListaProcesow();
 ListaProcesow listaWszystkich = new ListaProcesow();
 ListaProcesow listaWykonanych = new ListaProcesow();
	
	public Algorytm(ListaProcesow a) {
		this.listaWszystkich=a;
	}
	
	public double policzSredniCzasOczekiwania() {
//		double czasOczekiwaniaPojedynczegoProcesu=0;
//		czasOczekiwaniaPojedynczegoProcesu+= czasZakonczenia-czasWejscia-czasWykonania;
		
		double czasOczekiwaniaWszystkich=0.0;
		
		for(Proces p:listaWykonanych) {
		czasOczekiwaniaWszystkich+=	p.getCzasZakonczenia()- p.getCzasWejscia() - p.getCzasWymaganyNaPoczatku();
		}
		
		return czasOczekiwaniaWszystkich/listaWykonanych.size();
		
	}
	
	abstract public void obsluzProcesy();
	
	/*
	
	public void osbluzProcesy2() {
		
			Proces procesObslugiwany;
		
			//Niekonieczne utworzenie listy drugiej i przekopiowanie do niej obiektow dla bezpieczenstwa
			
			ListaProcesow lp = new ListaProcesow();
			
			for(int i=0;i<listaWszystkich.size();i++) {
				lp.add(new Proces(listaWszystkich.get(i).getNazwa(),listaWszystkich.get(i).getCzas(),listaWszystkich.get(i).getCzasWejscia()));
			}
			
			lp.sort(new Comparator_CzasWejscia()); //Posortowanie dla nastepnego algorytmu wrzucajacego procesy wszystkie do aktualnych
			
			boolean stop=true;
			//Warunek zatrzymania petli - petla symulujaca czas zatrzyma sie jak skoncza sie wykonywac wszystkie procesy
			//czyli innymi slowy lista wykonanych bedzie wielkosci wszystkich
			int j=0;  //Zmienna iterujaca po liscie WSZYSTKICH procesow
			boolean a;
			
			for(double i=0.0;stop&&j<lp.size();i+=0.1) {
			
				//Warunek sprawdzajacy czy jest sens wogole wykonywac petle while, czy moze wszystkie procesy sa juz w aktualnych i tylko musza sie wykonac
				if((j<lp.size()))	
					a=true;
					else a = false;
				
			while(a) {
				if(lp.get(j).getCzasWejscia()<i) {
				listaAktualna.add(lp.get(j));
			}
				else a=false;
			if(j<lp.size())	
			j++;
			
			}
			
			System.out.println("WYKONYWANY PROCES:" + listaAktualna.get(0));
			listaAktualna.get(0).setCzas(listaAktualna.get(0).getCzas()-0.1);
			if(listaAktualna.get(0).getCzas()<=0) {
				listaAktualna.get(0).setCzasZakonczenia(i);
				listaWykonanych.add(listaAktualna.get(0));
				listaAktualna.remove(0);
			}
			
			if(listaWykonanych.size()==listaWszystkich.size()) stop=false;
		}
	}
	
	*/
}
