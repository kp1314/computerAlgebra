import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Table {

	JTable jt1;
	JTable jt2;
	JTable jt3;
	String[][] data1;
	String[][] data2;
	String[][] data3;
	
	public Table(String[][] data1, String[][] data2, String[][] data3){		
		this.data1 = data1;
		String[] Columns1 = {"c", "e", "# iterations (#i)", "sqrt(e) * #i"};
		String[] Columns2 = {"c", "e", "# iterations (#i)", "(e) * #i"};
		String[] Columns3 = {"c", "e", "# iterations (#i)", "2 * (e) * #i"};
		
		jt1 = new JTable(data1, Columns1);
		jt1.setPreferredScrollableViewportSize(new Dimension(450,100));
		jt1.setFillsViewportHeight(true);
		
		jt2 = new JTable(data2, Columns2);
		jt2.setPreferredScrollableViewportSize(new Dimension(450,100));
		jt2.setFillsViewportHeight(true);
		
		jt3 = new JTable(data3, Columns3);
		jt3.setPreferredScrollableViewportSize(new Dimension(450,100));
		jt3.setFillsViewportHeight(true);
	}
	
	
	
	



	public void returnTable(){
		
		JFrame jf = new JFrame();
		jf.setTitle("Boll's results");
		jf.setSize(500,500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new JScrollPane(jt1), BorderLayout.CENTER);
		jf.add(new JScrollPane(jt2), BorderLayout.NORTH);
		jf.add(new JScrollPane(jt3), BorderLayout.SOUTH);
		
	}
	
	
}
