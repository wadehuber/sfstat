package sfstat;

public class Entry 
{
	private String entry;

	public Entry(String line)
	{
		setEntry(line);
	}
	public void setEntry(String line)
	{
		int next = findFirstComma(line);
		this.entry = line.substring(0, next);
	}
	public String getEntry()
	{
		return entry;
	}
	public static int findFirstComma(String line)
	{
		int count = 0;
		while (line.charAt(count) != ',')
		{
			count++;
		}
		return count;
	} 
}
