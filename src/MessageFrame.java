import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessageFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel message,iconLabel;
	private JButton okButton;
	private JPanel mainPanel,southPanel,centerPanle;
	private ImageIcon infoIcon;

	public MessageFrame(String aName)
	{	
		ButtonListener listener = new ButtonListener();
		
		//Dimiourgia kyriou panel me layout border
		BorderLayout border = new BorderLayout();
		mainPanel = new JPanel();
		mainPanel.setLayout(border);
		
		
		
		//Dimiourgia enos panel me to koumpi pou tha mpei sto "Noto" tou main panel
		southPanel = new JPanel();
		okButton = new JButton("OK");
		okButton.addActionListener(listener);
		southPanel.add(okButton);
		mainPanel.add(southPanel,BorderLayout.SOUTH);
		
		
		
		//Dimiourgia enos panel me mia eikona kai ena keimeno pou tha mpoun sto kento tou main panel
		centerPanle = new JPanel();
		message = new JLabel("Suspect " + aName +" Not Found");
		infoIcon = new ImageIcon("C:\\Eclipse\\Tsaousis_Angelos_3\\src\\info.png");
		iconLabel = new JLabel(infoIcon);
		mainPanel.add(centerPanle,BorderLayout.CENTER);


		
		
		centerPanle.add(iconLabel);
		centerPanle.add(message);
	

		
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(300,120);
		this.setTitle("Message");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//otan patisoume to ok kleinei to parathiro
			System.exit(0);
		}
	}
}
