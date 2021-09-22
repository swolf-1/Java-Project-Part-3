//Ypokalsi PhoneCall
public class PhoneCall extends Communication{
	
	private int call_duration;
	
//Kataskevastis gia tin diourgia twn antikeimenwn phonecall
	public PhoneCall(String number_1, String number_2, int day, int month, int year,int call_duration) 
	{
		super(number_1, number_2, day, month, year);
		this.call_duration = call_duration;
	}
	
//Methodos gia epistrofi timwn	
	public int getCall_duration() 
	{
		return call_duration;
	}

//Methodos gia emfanisi pliroforiwn
	public void printInfo()
	{
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + call_duration);
	}


	
	

}