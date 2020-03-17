import java.util.Comparator;

public class Proces implements Comparable{

	private String nazwa;
	private double dlugoscWykonania;
	private double czasWejscia;
	private double czasZakonczenia=0;
	
	private double czas_wymagany_na_poczatku;
	public Proces(String a,double b,double c) {
		this.nazwa=a;
		this.dlugoscWykonania=b;
		this.czasWejscia=c;
		czas_wymagany_na_poczatku=b;
	}
	
	public String toString() {
		
		return nazwa + " Czas wykonania:" + String.format("%.1f", czas_wymagany_na_poczatku) + " CZAS WEJSCIA=" + String.format("%.1f", czasWejscia);
	}
	
	public double getCzas() {
		return this.dlugoscWykonania;
	}
	
	public void setCzas(double a) {
		this.dlugoscWykonania = a;
	}
	
	public double getCzasWejscia() {
		return this.czasWejscia;
	}
	
	public void czasMinus() {
		this.dlugoscWykonania--;
	}
	
	public int compareTo(Object a) {
		if(this.getCzas()>((Proces)a).getCzas()) return 1;
		if(this.getCzas()<((Proces)a).getCzas()) return -1;
		else return 0;
	}
	
	public String getNazwa() {
		return this.nazwa;
	}
	public double getCzasZakonczenia() {
		return czasZakonczenia;
	}
	
	public void setCzasZakonczenia(double a) {
		this.czasZakonczenia=a;
	}
	
	public double getCzasWymaganyNaPoczatku() {
		return czas_wymagany_na_poczatku;
	}
	
}
