import java.util.ArrayList;

public class Suspect {
	
	private String name;
	private String code_name;
	private String region;
	private String action_city;
	
//Dinamikoi pinakes gia tin apothikefsi dedomenwn	
	private ArrayList<String> PhoneNumbers = new ArrayList<String>();
	private ArrayList<Suspect> PossibleCollaborators = new ArrayList<Suspect>();
	private ArrayList<Suspect> SuggestedPartners = new ArrayList<Suspect>();
	
	
//Kataskevastis gia tin diourgia twn antikeimenwn suspect	
	public Suspect(String name, String code_name, String region, String action_city) {
		
		this.name = name;
		this.code_name = code_name;
		this.region = region;
		this.action_city = action_city;
	}
//Methodoi get gia tin epistrofi ton stixeiwn pou xreiazomaste
	public String getName() 
	{
		return name;
	}
	
	public String getCode_name() 
	{
		return code_name;
	}
	
	public String getRegion() 
	{
		return region;
	}
	
public String getAction_city() {
		return action_city;
	}
	//Methodos gia tin prosthiki ton tilefonikwn arithmwn se mia lista pou krata tous arithmous tou kathe ipoptou
	public void addNumber(String number)
	{
		PhoneNumbers.add(number);
	}
	
//Methodos gia tin epistrofi twn tilefonikwn arithmwn tou ipoptou	
	public ArrayList<String> getPhoneNumbers() 
	{
		
		return PhoneNumbers;
	}
	
//Methodos gia tin prosthiki enos upoptou sthn lista pithanwn sinergatwn tou(+elegxos an yparxei idi sti lista)
	public void addToPossibleCollaborator(Suspect aSuspect) 
	{
		if(!PossibleCollaborators.contains(aSuspect))
		{
		PossibleCollaborators.add(aSuspect);
		aSuspect.PossibleCollaborators.add(this);
		}
	}
	
//Methodos epistrofis pithanwn sinergatwn
	public ArrayList<Suspect> getPossibleCollaborators() 
	{
		return PossibleCollaborators;
	}
	
//Methodos elegxou an duo ipopti einai pithanoi sinergates
	public boolean isConnectedTo(Suspect aSuspect)
	{
		if(PossibleCollaborators.contains(aSuspect))
			return true;
		else 
			return false;
	}
	
//Methodos gia tin epistrofi koinon pithanon sinergatwn
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		ArrayList<Suspect> common = new ArrayList<Suspect>(PossibleCollaborators);
		
		common.retainAll(aSuspect.PossibleCollaborators);
		return common;
	}
	
//Methodos epistrofis pithanon sinergaton
	public void CollaboratorInfo()
	{
		for(Suspect PC:PossibleCollaborators)
		{
			System.out.print(PC.name + PC.code_name);
			if (region.equals(PC.region))
				System.out.println("*");
		}
	}
	
//Methodos epistrofis protinomenwn pithanwn upoptwn-sunergatwn.
	public ArrayList<Suspect> getSuggestedPartners()
	{
		
		for(Suspect s:PossibleCollaborators)
		{
			SuggestedPartners.addAll(s.PossibleCollaborators);
		}
		
		SuggestedPartners.removeIf(sp -> sp.equals(this));
		
		for(Suspect s:PossibleCollaborators)
		{
			SuggestedPartners.removeIf(sp -> sp.equals(s));
		}

		
		

		return SuggestedPartners;	
	}



}