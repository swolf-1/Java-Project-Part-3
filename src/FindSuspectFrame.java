import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindSuspectFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Dilosi metavlitwn tou programmatos
	private JTextField nameField;
	private JButton findButton,visualizeButton;
	private JPanel panel;
	private ArrayList<Suspect> suspects;
	private Registry registry;

	public FindSuspectFrame(ArrayList<Suspect> someSuspects,Registry registry)
	{
		suspects = someSuspects;
		this.registry = registry;
		
		//Dimiourgia antikeimwnou Button Listener gia to koumpi findButton
		ButtonListener listener = new ButtonListener();
		
		//Dimiourgia twn antikeimenw pou dilosame
		panel = new JPanel();		
		
		nameField = new JTextField("Please enter suspect's name");
		
		findButton = new JButton("Find");
		findButton.addActionListener(listener);
		
		visualizeButton = new JButton("Visualize Network");
		visualizeButton.addActionListener(listener);
		
		//Prosthiki twn antikeimenwn sto panel mas
		panel.add(nameField);
		panel.add(findButton);
		panel.add(visualizeButton);
		
		//Oi stadar entoles mas gai thn dimiourgia tou parathirou
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(300,150);
		this.setTitle("Find Suspect");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Klasi gia to to ButtonLister
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Dilosi metavlitwn
			String suspectName = nameField.getText();
			boolean name_in_the_list = false;
			
			//Elegxos gia to an to onoma pou plikrologise o xristis yparxei sthn lista me tous ypoptous
			for(Suspect suspect:suspects)
				if(suspect.getName().toLowerCase().equals(suspectName.toLowerCase()))
					name_in_the_list=true;
				
				if(e.getSource() == findButton)
				{
					//Analoges energies gia to an yparxei h oxi o xristis kai dimiourgia analogwn parathirwn	
					if(name_in_the_list==true)
					{
						new SuspectPageFrame(suspects,suspectName,registry);
						dispose();
					}
					else
					{
						new MessageFrame(suspectName);
						dispose();
					}
				}
				else
				{
					if(name_in_the_list==true)
					{
						new SuspectsNetworkFrame(suspects,suspectName);
						dispose();
					}
					else
					{
						new MessageFrame(suspectName);
						dispose();
					}
				}			
		}
	}
}
