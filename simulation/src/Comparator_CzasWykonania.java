import java.util.Comparator;

public class Comparator_CzasWykonania implements Comparator<Proces> {

	public int compare(Proces a,Proces b) {
		if(a.getCzas()>b.getCzas()) return 1;
		if(a.getCzas()<b.getCzas()) return -1;
		else return 0;
	}
	
}
