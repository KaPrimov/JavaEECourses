package bg.jwd.bank.enums;

public enum Currency
{
	USD(1.669, 1.686), GBP(2.188, 2.210), EUR(1.950, 1.958);
	
	private double buyRate;
	private double sellRate;
	private Currency(double buyRate, double sellRate)
	
	{
		this.buyRate = buyRate;
		this.sellRate = sellRate;
	}
	public double getBuyRate()
	{
		return buyRate;
	}
	public double getSellRate()
	{
		return sellRate;
	}
}
