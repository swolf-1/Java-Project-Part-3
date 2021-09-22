import java.util.ArrayList;

public class Registry {
	
//Dinamikoi pinakes gia tin apothikefsi dedomenwn	
	private ArrayList<Suspect> SuspectsList = new ArrayList<Suspect>();
	private ArrayList<Communication> CommunicationList = new ArrayList<Communication>();
//Methodoi prosthikis dedomenon stis analoges listes tous
	public void addSuspect(Suspect aSuspect)
	{
		SuspectsList.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication)
	{
		CommunicationList.add(aCommunication);
		
		String n1 = aCommunication.getNumber_1();
		String n2 = aCommunication.getNumber_2();
		Suspect s1 = new Suspect(null, null, null, null);
		Suspect s2 = new Suspect(null, null, null, null);
		
//Prosthiki stin lista me tous pithanous sinergates stou kataxous ton 2 arithmwn		
		for(Suspect s:SuspectsList)
		{
			if(s.getPhoneNumbers().contains(n1))
				s1 = s;	
		}
		
		for(Suspect s:SuspectsList)
		{
			if(s.getPhoneNumbers().contains(n2))
				s2 = s;	
		}
		
		s1.addToPossibleCollaborator(s2);
	}
//Methodos get	
	public ArrayList<Communication> getCommunicationList() 
	{
		return CommunicationList;
	}
	
//Methodos gia thn epistrofi tou upoptou me tous pio polous sinergates
	public Suspect getSuspectWithMostPartners()
	{
		int max = -1;
		Suspect max_suspect = new Suspect(null, null, null, null);
		for(int i=0; i<SuspectsList.size();i++)
		{
			if(SuspectsList.get(i).getPossibleCollaborators().size() > max);
				max = SuspectsList.get(i).getPossibleCollaborators().size();
				max_suspect = SuspectsList.get(i);
		}
		
		return max_suspect;	
	}
	
//Methodos gia thn epistrofi ths klisis me thn megaliteri diarkia metaksi 2 arithmwn	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2)
	{
		int max=-1;
		PhoneCall max_phonecall = new PhoneCall(null, null, 0, 0, 0, 0);
		int counter=0;
		
		for(Communication c:CommunicationList)
		{
			if(c.getNumber_1().equals(number1) && c.getNumber_2().equals(number2) || c.getNumber_1().equals(number2) && c.getNumber_2().equals(number1))
				if(((PhoneCall)c).getCall_duration() > max)
				{
					max=((PhoneCall)c).getCall_duration();
					max_phonecall=((PhoneCall)c);
				}
		
			counter++;
			if(counter == 7)
				break;
		}
		
		return max_phonecall;
	}
	
//Methodos epistrofis minimatwn metaksi 2 arithmon pou periexoun kapoia sigekrimena minimata
	public ArrayList<SMS> getMessagesBetween(String number1, String number2)
	{
		ArrayList<SMS> mess_list = new ArrayList<SMS>();
		
		for (int i=7; i < 15; i++)
		{
			if(CommunicationList.get(i).getNumber_1().equals(number1) && CommunicationList.get(i).getNumber_2().equals(number2))
				if(((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("bomb") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("attack") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("explosives") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("gun"))
					mess_list.add((SMS)CommunicationList.get(i));

			if(CommunicationList.get(i).getNumber_1().equals(number2) && CommunicationList.get(i).getNumber_2().equals(number1))
				if(((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("bomb") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("attack") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("explosives") || ((SMS)CommunicationList.get(i)).getMessage().toLowerCase().contains("gun"))
					mess_list.add((SMS)CommunicationList.get(i));
		}
		
		return mess_list;
	}
	

//Methodos emfanisis upopton apo thn idia xwra
	public void getSuspectsFromCountry(String country)
	{
		for (Suspect s:SuspectsList)
			if(s.getRegion().equals(country))
				System.out.println(s.getName() + "(" + s.getCode_name() +  ")");

	}

	public ArrayList<Suspect> getSuspectsList() {
		return SuspectsList;
	}


}
