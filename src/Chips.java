
public class Chips 
{
	private int chips_total;
	
	public Chips()
	{
		chips_total = 0;
	}
	
	public void recievesSkunk()
	{
		chips_total += 1;
	}
	
	public void recieves2Skunk()
	{
		chips_total += 4;
	}
	
	public void recieves1Skunkand1Deuce()
	{
		chips_total += 2;
	}
	
	public void addChip(int num)
	{
		chips_total += num;
	}
	
	public int getTotalChips()
	{
		return chips_total;
	}
}
