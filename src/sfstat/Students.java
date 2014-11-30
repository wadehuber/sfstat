package sfstat;

import java.util.HashMap;

public class Students {
	private HashMap<String, Entry> map;

	public Students() {
		super();
		map = new HashMap<String, Entry>();
	}
	
	public void add(String name, int grade, Scores s) {
		if (map.containsKey(name))
		{
			Entry existing = map.get(name);
			existing.addScores(s);
		}
		else
		{
			Entry newEntry = new Entry(name, grade);
			newEntry.addScores(s);
			map.put(name, newEntry);
		}
	}

}
