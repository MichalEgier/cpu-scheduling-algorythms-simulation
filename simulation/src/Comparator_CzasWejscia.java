import java.util.Comparator;
public class Comparator_CzasWejscia implements Comparator<Proces>{

	@Override
	public int compare(Proces arg0, Proces arg1) {
		if(arg0.getCzasWejscia()>arg1.getCzasWejscia()) return 1;
		if(arg0.getCzasWejscia()<arg1.getCzasWejscia()) return -1;
		else return 0;
	}
	
}
