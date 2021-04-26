package treca_grupa;

public class Tacka 
{
	private double x;
	private double y;
	
	public Tacka()
	{
		x = y = 0.0;
	}
	
	public Tacka(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Tacka(final Tacka t)
	{
		this();
		postaviX(t.vratiX());
		postaviY(t.vratiY());
	}
	
	public double vratiX()
	{
		return x;
	}
	
	public double vratiY()
	{
		return y;
	}
	
	public void postaviX(double x)
	{
		this.x = x;
	}
	
	public void postaviY(double y)
	{
		this.y = y;
	}
	
	public double rastojanje(Tacka t)
	{
		return Math.sqrt(Math.pow(t.x - x, 2) + Math.pow(t.y - y, 2));
	}
	
	public void pomeri(double dx, double dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}
	
}
