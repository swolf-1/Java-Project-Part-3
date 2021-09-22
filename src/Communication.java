
public class Communication {
	
	private String number_1;
	private String number_2;
	private int day;
	private int month;
	private int year;
	
//Kataskevastis gia tin diourgia twn antikeimenwn communication
	public Communication(String number_1, String number_2, int day, int month, int year) 
	{
		this.number_1 = number_1;
		this.number_2 = number_2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
//Methodos gia emfanisi pliroforiwn
	public void printInfo()
	{
		System.out.println("Between " + number_1 + " --- " + number_2);
		System.out.println("on " + year + "/" + month + "/" + day);
	}
	
//Methodoi gia epistrofi timwn
	public String getNumber_1() 
	{
		return number_1;
	}

	public String getNumber_2() 
	{
		return number_2;
	}
	

}
