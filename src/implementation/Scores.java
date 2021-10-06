package implementation;

public class Scores {
	public static final int maxEntries = 10;
	protected int numEntries;
	protected GameEntry[] entries;

	public Scores() {
		entries = new GameEntry[maxEntries];
		numEntries = 0;
	}

	public String toString() {
		String s = "[";
		for (int i = 0; i < numEntries; i++) {
			if (i > 0) s += ", ";
			s += entries[i];
		}
		return s + "]";
	}
	
	public void add(GameEntry e) {
	int newScore = e.getScore();
	
	if (numEntries == maxEntries) { 
	if (newScore <= entries[numEntries - 1].getScore()) {
		
		return; 
	} else {
		
		numEntries--;
	}
	} 
	
	numEntries++;
	
	int i = numEntries - 1;
	for (; (i >= 1) && (newScore > entries[i - 1].getScore()); i--)
		entries[i] = entries[i - 1];
	entries[i] = e;
	}
}
