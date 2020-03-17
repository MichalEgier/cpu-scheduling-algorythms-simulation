import java.util.Comparator;
import java.util.LinkedList;

 
public class ListaProcesow extends LinkedList<Proces> {
	//private LinkedList <Proces> lista = new LinkedList <Proces>();
	
	private Comparator_CzasWykonania wyk = new Comparator_CzasWykonania();
	private Comparator_CzasWejscia wej = new Comparator_CzasWejscia();
	
	public ListaProcesow() {
		super();
	}
	
	
	
	public void posortujCzasamiWejscia() {
		this.sort(wej);
	}
	
	public void posortujCzasamiWykonania() {
		this.sort(wyk);
	}
	
	public void posortujBezWywlaszczenia() {
		Proces a;
	  if(this.size()!=0) {  a =this.get(0);
	  
	  this.remove(0);
	  this.sort(wyk);
	  this.add(0,a);
	  
	  }
	  
	}
	
	public void addOnGoodPosition(Proces a) {
		if(this.size()==0) this.add(a);
		else if(this.get(this.size()-1).getCzas()<a.getCzas()) this.add(a);
		
		else {
		
			boolean ab=true;
			
		for(int i=0;ab&&(i<this.size());i++) {
			if(this.get(i).getCzas()>a.getCzas()) {this.add(i, a);ab=false;}
			
		}
		
		}
	}
	
	public void addOnGoodPositionButNotFirst(Proces a) {
		if(this.size()==0||this.size()==1) this.add(a);
		else if(this.get(this.size()-1).getCzas()<a.getCzas()) this.add(a);
		
		else {
		
			boolean ab=true;
			
		for(int i=1;ab&&(i<this.size());i++) {
			if(this.get(i).getCzas()>a.getCzas()) {this.add(i, a);ab=false;}
			
		}
		
		}
	}
}
