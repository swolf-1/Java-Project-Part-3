import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;




public class SuspectsNetworkFrame extends JFrame {
	
	
	/**
	 * Den kserw giati to evala kai thn xrisi tou alla den mporousa na vlepw to warning sinexeia
	 */
	private static final long serialVersionUID = 1L;
	
	//Dilosi metavlitwn 
	private VisualizationImageServer<String, String> vs;
	private Graph<String, String> g;
	private JPanel mainPanel;
	
	private String name;
	private Suspect ourSuspect;
	private JTextArea diameterArea;
	
	private ArrayList<Suspect> suspects;

	public SuspectsNetworkFrame(ArrayList<Suspect> someSuspects,String aName) {
		
		suspects = someSuspects;
		name = aName;
		
		for(Suspect s:suspects)
			if(s.getName().equals(name))
				ourSuspect = s;
		
		//Dimiouria enos grafou
		g = new SparseMultigraph<String, String>();
		
		//Dimiourgia enos panel
		mainPanel = new JPanel(new BorderLayout());
		
		//Dimiourgia komvou gia ton ypopto pou anazitisame
		g.addVertex(ourSuspect.getCode_name());
	    
		//Dimiourgia komvon gia tous zinergates tou
		for(Suspect ps:ourSuspect.getPossibleCollaborators())
		{
			g.addVertex(ps.getCode_name());
			
			//Dimiourgia grammwn metaksi komvon
			g.addEdge("Edge"+"From"+ourSuspect.getCode_name()+"to"+ps.getCode_name(), ourSuspect.getCode_name(), ps.getCode_name());
			for(Suspect cp:ourSuspect.getCommonPartners(ps))
			{
				if(!g.containsEdge("Edge between the partners" +ps.getCode_name() + "and" + cp.getCode_name()) && !g.containsEdge("Edge between the partners" + cp.getCode_name() + "and" + ps.getCode_name()))
				g.addEdge("Edge between the partners" +ps.getCode_name() + "and" + cp.getCode_name(),cp.getCode_name(),ps.getCode_name());
			}
		}
		
		//Dimiourgia komvon gia tous protinomenous sinergates tou
		for(Suspect sp:ourSuspect.getSuggestedPartners())
		{
			g.addVertex(sp.getCode_name());
			for(Suspect cp:ourSuspect.getCommonPartners(sp))
				g.addEdge("Edge for common between" + sp.getCode_name() + "and" + ourSuspect.getCode_name() ,cp.getCode_name(), sp.getCode_name());
		}
		
		//Dimiourgia enos textArea gia tin emfanisi tis diametrou tou grafou
	    String diameterOutput = "";
		diameterArea = new JTextArea();
		if(ourSuspect.getSuggestedPartners().isEmpty())
			diameterOutput = "Diameter = 1.00";
		else
			diameterOutput = "Diameter = 2.00";
		diameterArea.setText(diameterOutput);
		
		//Dimiourgia enos Visuaalization gia na mpei panw o grafos mas
		vs = new VisualizationImageServer<String, String>(new CircleLayout<String, String>(g), new Dimension(300, 300));
		//Emfanisi ton label dipla stous kamvous
		vs.getRenderContext().setVertexLabelTransformer(transformer);
		
		//Topothetisi tou grafou kai tou textArea panw sto panel mas
		mainPanel.add(vs,BorderLayout.CENTER);
		mainPanel.add(diameterArea,BorderLayout.PAGE_END);
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setSize(400,410);
		this.setTitle("Suspects Network");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//Dimoiourgia enos Transformer gia na epistrefi to onoma pou tha mpei dipla stous komvous mas
	Transformer<String,String> transformer = new Transformer<String,String>()
	{		
		public String transform(String arg0)
		{
            return arg0;
        }	
	};

}
