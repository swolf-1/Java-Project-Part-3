//Ypokalsi sms
public class SMS extends Communication{
	
	private String message;

//Kataskevastis gia tin diourgia twn antikeimenwn sms
	public SMS(String number_1, String number_2, int day, int month, int year,String message) 
	{
		super(number_1, number_2, day, month, year);
		this.message = message;
	}
	
//Methodos gia epistrofi timwn		
	public String getMessage() 
	{
		return message;
	}

//Methodos gia emfanisi pliroforiwn
	public void printInfo()
	{
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + message );
	}
	

}
