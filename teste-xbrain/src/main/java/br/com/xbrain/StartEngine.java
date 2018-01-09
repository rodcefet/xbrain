package br.com.xbrain;


import javax.swing.JFrame;


/** author: Rodrigo Batista
	 * 
	 */
public class StartEngine extends JFrame{

   
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        try {
            execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void execute() throws Exception{
		ViewEngine menu = new ViewEngine();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(200, 100, 500, 460);
		menu.setVisible(true);
    }
}
