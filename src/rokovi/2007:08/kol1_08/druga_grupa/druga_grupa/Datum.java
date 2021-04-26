package druga_grupa;

public class Datum 
{
	// Niz koji sadrzi broj dana po mesecima za racunanje sledeceg datuma
	private static int[] br_dana = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	//Dan, mesec i godina tekuceg datuma
	private int dan;
	private int mesec;
	private int godina;
	
	// Default konstruktor
	public Datum()
	{
		dan=mesec=1;
		godina=2100;
	}
	
	// Konstruktor za zadati dan, mesec i godinu
	public Datum(int dan, int mesec, int godina)
	{
		this.dan=dan;
		this.mesec=mesec;
		this.godina=godina;
	}
	
	// Kosntruktor kopije
	public Datum(final Datum d)
	{
		dan=d.dan();
		mesec=d.mesec();
		godina=d.godina();
	}
	
	// Pristupne metode
	public int dan()
	{
		return dan;
	}

	public int mesec()
	{
		return mesec;
	}
	
	public int godina()
	{
		return godina;
	}
	
	// Metode za izmenu
	public void postaviDan(int dan)
	{
		 this.dan=dan;
	}

	
	public void postaviMesec(int mesec)
	{
		 this.mesec=mesec;
	}
	
	public void postaviGodinu(int godina)
	{
		 this.godina=godina;
	}
	
	// Metod koji ispituje na jednakost
	public boolean isti(final Datum d)
	{
		return (dan()==d.dan() && mesec()==d.mesec() && godina()==d.godina());
	}
	
	// Metod koji vraca sledeci datum
	public void sledeci()
	{
		if (dan<br_dana[mesec-1])
			dan++;
		else if (mesec<12)
		{
			dan=1;
			mesec++;
		}
		else
		{
			dan=mesec=1;
			godina++;
		}
	}
	
	// Metod za ispis datuma
	public String toString() 
	{
		return this.dan()+". "+ this.mesec()+". "+ this.godina();
	}		
}
