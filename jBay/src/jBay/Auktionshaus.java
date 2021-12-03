package jBay;

import java.util.LinkedList;
import java.util.List;

public class Auktionshaus {
	
	List<Auktion> auktionen = new LinkedList<>();
	List<BieterTerminal> terminals = new LinkedList<>();
	
	public void addAuktion(Auktion a) {
		auktionen.add(a);
	}
	
	public void removeAuktion(Auktion a) {
		auktionen.remove(a);
	}
	
	public List<Auktion> getAuktionen(){
		return auktionen;
	}

	void register(BieterTerminal bt) {
		terminals.add(bt);	
	}
	
	void unregister(BieterTerminal bt) {
		terminals.remove(bt);
	}
	
	public void updateTerminals() {
		int i = 0;
	
		while (i < terminals.size()) {
			 terminals.get(i).revalidate();;
	}
	
	}
}
