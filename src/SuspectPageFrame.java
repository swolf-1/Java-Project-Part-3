import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class SuspectPageFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Dilosi metavlitwn kai omadopioisi analoga me ta panel pou anikoun
	private ArrayList<Suspect> suspects;
	private Registry registry;
	private String name;
	private Suspect ourSuspect;
	
	private JPanel mainPanel;
	private JButton returnButton;
	
	private JPanel firstPanel;
	private JTextField nameField,codeNameField;
	private JTextArea listOfNumbersArea;
	
	private JPanel secondPanel;
	private JTextField numberField;
	private JTextArea messageArea;
	private JButton findSMSButton;
	
	private JPanel thirdPanel;
	private JLabel partnersLabel;
	private JTextArea possibleCollaboratorsArea;
	
	private JPanel fourthPanel;
	private JLabel suggestedPartnersLabel;
	private JTextArea suggestedPartnersArea;
	
	private JPanel fifthPanel;
	private JTextArea suspectsWithSameRegionArea;
	
	
	public SuspectPageFrame(ArrayList<Suspect> someSuspects,String aName,Registry registry)
	{
		suspects = someSuspects;
		name = aName;
		this.registry = registry;

		for(Suspect s:suspects)
			if(s.getName().equals(name))
				ourSuspect = s;
		
		//Dimiourgia antikeimwnou Button Listener gia ta koumpia
		ButtonListener listner = new ButtonListener();		
		
		//Grammes 59-67 to kyrio panel mas
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);
		
		returnButton = new JButton("Return to Search Screen");
		returnButton.setBounds(255, 745, 231, 23);
		mainPanel.add(returnButton);
		returnButton.addActionListener(listner);
		
		//Grammes 70-94 to proto panel me ta stoixeia tou upoptou mas kai to pername sto kyrio panel mas(mainPanel)
		firstPanel = new JPanel();
		firstPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		firstPanel.setBounds(117, 36, 438, 93);
		mainPanel.add(firstPanel);
		firstPanel.setLayout(null);
		
		nameField = new JTextField(name);
		nameField.setBounds(10, 35, 133, 20);
		firstPanel.add(nameField);
		nameField.setColumns(10);
		

		codeNameField = new JTextField(ourSuspect.getCode_name());
		codeNameField.setColumns(10);
		codeNameField.setBounds(153, 35, 133, 20);
		firstPanel.add(codeNameField);
		
		String numbersOutput = "";
		listOfNumbersArea = new JTextArea();
		listOfNumbersArea.setColumns(10);
		listOfNumbersArea.setBounds(296, 17, 133, 56);
		firstPanel.add(listOfNumbersArea);
				for(String phoneNumber: ourSuspect.getPhoneNumbers())
					numbersOutput += phoneNumber.toString() + "\n";		
		listOfNumbersArea.setText(numbersOutput);
		
		
		
		//Grammes 99-119 to deftero panel me ta ypopta minimata pou exoun stalei metaksi tou ipoptou mas kai enos sigekrimenou arithmou,to pername sto kyrio panel mas(mainPanel)
		secondPanel = new JPanel();
		secondPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		secondPanel.setBounds(45, 136, 583, 241);
		mainPanel.add(secondPanel);
		secondPanel.setLayout(null);
		
		numberField = new JTextField();
		numberField.setBounds(10, 110, 158, 20);
		numberField.setColumns(10);
		secondPanel.add(numberField);
		
		
		messageArea = new JTextArea();
		messageArea.setColumns(10);
		messageArea.setBounds(178, 11, 288, 219);
		secondPanel.add(messageArea);
		
		findSMSButton = new JButton("Find SMS");
		findSMSButton.setBounds(476, 109, 89, 23);
		secondPanel.add(findSMSButton);
		findSMSButton.addActionListener(listner);
		
		
		
		//Grammes 124-140 to trito panel mas me tous pithanous sinergates tou ypoptou mas,to pername sto kyrio panel mas(mainPanel)
		thirdPanel = new JPanel();
		thirdPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		thirdPanel.setBounds(230, 383, 295, 163);
		mainPanel.add(thirdPanel);
		thirdPanel.setLayout(null);
		
	    partnersLabel = new JLabel("Partners");
		partnersLabel.setBounds(10, 76, 55, 14);
		thirdPanel.add(partnersLabel);
		
		String possibleCollaboratorsOutput = "";
		possibleCollaboratorsArea = new JTextArea();
		for(Suspect pc:ourSuspect.getPossibleCollaborators())
			possibleCollaboratorsOutput += pc.getName() + "," + pc.getCode_name() + "\n";
		possibleCollaboratorsArea.setText(possibleCollaboratorsOutput);
		possibleCollaboratorsArea.setBounds(65, 5, 220, 153);
		thirdPanel.add(possibleCollaboratorsArea);
		
		
		
		//Grammes 145-161 dimiourgia tou tetartou panel me tous protinomenous pithanous sinergates,to pername sto kyrio panel mas(mainPanel)
		fourthPanel = new JPanel();
		fourthPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		fourthPanel.setBounds(167, 550, 402, 98);
		mainPanel.add(fourthPanel);
		fourthPanel.setLayout(null);
		
		suggestedPartnersLabel = new JLabel("Suggested Partners----->");
		suggestedPartnersLabel.setBounds(10, 41, 164, 14);
		fourthPanel.add(suggestedPartnersLabel);
		
		String suggestedPartnersAreaOutPut = "";
		 suggestedPartnersArea = new JTextArea();
		for(Suspect SP:ourSuspect.getSuggestedPartners())
			suggestedPartnersAreaOutPut += SP.getName() + "\n";
		suggestedPartnersArea.setText(suggestedPartnersAreaOutPut);
		suggestedPartnersArea.setBounds(155, 8, 237, 79);
		fourthPanel.add(suggestedPartnersArea);
		
		
		
		//Grammes 166-180 dimiourgia tou pemptou panel me tous upotpous apo thn idia xwra,to pername sto kyrio panel mas(mainPanel)
		fifthPanel = new JPanel();
		fifthPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		fifthPanel.setBounds(189, 650, 359, 93);
		mainPanel.add(fifthPanel);
		fifthPanel.setLayout(null);
		
		String suspectsWithSameRegionOutput = "Suspects coming from " + ourSuspect.getRegion() + "\n" + ourSuspect.getName() + "\n";
		suspectsWithSameRegionArea = new JTextArea();
		for(Suspect s:suspects)
			if(s != ourSuspect)
				if(s.getRegion().equals(ourSuspect.getRegion()))
					suspectsWithSameRegionOutput += s.getName() + "\n";
		suspectsWithSameRegionArea.setText(suspectsWithSameRegionOutput);
		suspectsWithSameRegionArea.setBounds(8, 5, 345, 80);
		fifthPanel.add(suspectsWithSameRegionArea);
		
		
		
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(690,850);
		this.setTitle("Suspect Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String txtNumber = numberField.getText();
			String messageAreaOutput = "";
			//Energies analoga me to pio apo ta 2 koumpia patiete
			if(e.getSource() == returnButton)
			{
				new FindSuspectFrame(suspects,registry);
				dispose();
			}
			else
			{
				for(String phoneNumber: ourSuspect.getPhoneNumbers())
					for(SMS sms:registry.getMessagesBetween(txtNumber,phoneNumber))
						messageAreaOutput += sms.getMessage() + "\n";
	
				messageArea.setText(messageAreaOutput);
			}
		}
	}

}
