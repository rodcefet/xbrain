package br.com.xbrain;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.com.xbrain.ViewEngine;


/** author: Rodrigo Batista
	 * 
	 */
public class StartEngine extends JFrame{

   
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
       
         execute();
       
    }
    
    public static void execute()  {
    	
    	try {
    		
		ViewEngine menu = new ViewEngine();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(200, 100, 500, 460);
		menu.setVisible(true);
		
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, e.getMessage(),"Erro",1);
		}
    }
}
