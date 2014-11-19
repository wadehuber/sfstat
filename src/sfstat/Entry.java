package sfstat;

public class Entry 
{
	private int entry;

	public Entry(int entry)
	{
		setEntry(entry);
	}
	public void setEntry(int entry)
	{
		this.entry = entry;
	}
	public int getEntry()
	{
		return entry;
	}
	public static int getEntry(int entry, Scores tempScore)
	{
		if (entry == 0)
		{
			return 1;
		}
		else if (tempScore.getJudge().charAt(0) != 'A')
		{
			return entry;
		}
		else
		{
			return entry + 1;
		}
	}
}
