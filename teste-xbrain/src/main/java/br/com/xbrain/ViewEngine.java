package br.com.xbrain;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import br.com.xbrain.service.IMatrizService;
import br.com.xbrain.service.MatrizService;


public class ViewEngine extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IMatrizService matrizService = new MatrizService();
		
	private JButton btnEsquerda = new JButton("ESQUERDA");
	private JButton btnDireita = new JButton("DIREITA");
	
	private JButton btnBaixo = new JButton("BAIXO");
	private JButton btnCima = new JButton("CIMA");
	
	private JButton btnPosicionar = new JButton("POSICIONAR");
	
	private JLabel  labelPosicaoXY = new JLabel("Posição:");
	private JLabel  valorPosicaoXY = new JLabel("0,0");
	
	private JLabel  labelPosicaoX = new JLabel("X:");
	private JTextField  txtValorPosicaoX = new JTextField("");
	
	private JLabel  labelPosicaoY = new JLabel("Y:");
	private JTextField  txtValorPosicaoY = new JTextField("");
	
	private JPanel pnlA1 = new JPanel(new GridLayout(10, 10));	
	private JLabel[][] matriz;			
	
	private int posicaoRoboVertical;	
	private int posicaoRoboHorizontal;
	
	public ViewEngine(){
		super(".:  TESTE XBRAIN  :.");		
	    final Container c = getContentPane();
	    c.setLayout(null);	    
	 
	    matriz = new JLabel[10][10];		
		
		pnlA1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,"MATRIZ ", javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.DEFAULT_POSITION, null,null));
		pnlA1.setBackground(Color.WHITE);			
		pnlA1.setBounds(10, 10, 470, 300);		
		
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++) {				
				JLabel l = new JLabel("");
				l.setHorizontalAlignment(JLabel.CENTER);			
				
				if(i==0 && j==0) {
					
					JLabel lX = new JLabel(new ImageIcon("src//imagem//robo.jpg") );
					lX.setHorizontalAlignment(JLabel.CENTER);
					matriz[i][j] = lX;
					setPosicaoAtualRobo(i,j);
				} else { 
					matriz[i][j] = l;
				}
				
				pnlA1.add(matriz[i][j]);				
			}
		}
		
	  
		btnEsquerda.setBounds(30, 330, 100, 20);
		btnDireita.setBounds(140, 330,100,20);
		btnBaixo.setBounds(250, 330, 100, 20);
		btnCima.setBounds(360, 330, 100, 20);
		
		labelPosicaoXY.setBounds(30, 360, 100, 20);
		valorPosicaoXY.setBounds(90, 360, 100, 20);
		
		labelPosicaoX.setBounds(30, 390, 100, 20);
		txtValorPosicaoX.setBounds(45, 390, 15, 20);
		
		labelPosicaoY.setBounds(90, 390, 100, 20);
		txtValorPosicaoY.setBounds(105, 390, 15, 20);
		
		btnPosicionar.setBounds(140, 390, 110, 20);
		
	   	c.add(btnEsquerda);
	   	c.add(btnDireita);
	 	c.add(btnBaixo);
	 	c.add(btnCima);  
	 	
	 	c.add(labelPosicaoXY);
	 	c.add(valorPosicaoXY);
	 	
	 	c.add(labelPosicaoX);
	 	c.add(txtValorPosicaoX);
	 	
	 	c.add(labelPosicaoY);
	 	c.add(txtValorPosicaoY);
	 	
	 	c.add(btnPosicionar);
	 	
		c.add(pnlA1);			
		
		
		btnPosicionar.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String valorX =	txtValorPosicaoX.getText();
					String valorY =	txtValorPosicaoY.getText();					
					
					
					if(matrizService.validaXY(valorX,valorY)) {						
							setPosicaoAtualRobo(Integer.parseInt(valorY),Integer.parseInt(valorX));
							pnlA1.removeAll();
							posicionaRobo();										
							c.validate();							
					} 			
					
					
				} catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}			
		});		
				
			
		
		btnBaixo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try {			
									
					 setPosicaoAtualRobo(getPosicaoRoboVertical()+1, getPosicaoRoboHorizontal());
					 pnlA1.removeAll();				 
					
					 
					 if(getPosicaoRoboVertical() > 9){
							setPosicaoAtualRobo(0, getPosicaoRoboHorizontal());
					    }
					 
					 posicionaRobo();										
					 c.validate();
				        					
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}			
		});		
		
		
		
		
		btnCima.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try {			
										
					 setPosicaoAtualRobo(getPosicaoRoboVertical()-1, getPosicaoRoboHorizontal());
					 pnlA1.removeAll();
					 
					 if(getPosicaoRoboVertical() < 0){
						setPosicaoAtualRobo(9, getPosicaoRoboHorizontal());
					   }		 
					 
					 
										 
					 posicionaRobo();										
					 c.validate();
				        					
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}			
		});		
		

		btnDireita.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try {			
									
					 setPosicaoAtualRobo(getPosicaoRoboVertical(), getPosicaoRoboHorizontal()+1);
					 pnlA1.removeAll();
					 
					 
					if(getPosicaoRoboHorizontal() > 9){
						setPosicaoAtualRobo(getPosicaoRoboVertical(), 0);
				    }					 
									 
					 posicionaRobo();															
					 c.validate();
				        					
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}			
		});		
		
		btnEsquerda.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				try {												
					 setPosicaoAtualRobo(getPosicaoRoboVertical(), getPosicaoRoboHorizontal()-1);
					 pnlA1.removeAll();
					 
						if(getPosicaoRoboHorizontal() < 0){						
							setPosicaoAtualRobo(getPosicaoRoboVertical(), 9);
						}					 
										 
					 posicionaRobo();															
					 c.validate();
				        					
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}			
		});			
		
		
	}	
		
	
	public void posicionaRobo() {
		
		 for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {				
					JLabel l = new JLabel("");
					l.setHorizontalAlignment(JLabel.CENTER);							
					
					if( (i == getPosicaoRoboVertical()) && (j == getPosicaoRoboHorizontal()) ) {									
							JLabel lX = new JLabel(new ImageIcon("src//imagem//robo.jpg") );
							lX.setHorizontalAlignment(JLabel.CENTER);
							matriz[i][j] = lX;
					} else {									
							matriz[i][j] = l;							
															
					}	
													
					pnlA1.add(matriz[i][j]);					
				}
			}		 
		 
		 valorPosicaoXY.setText(getPosicaoRoboHorizontal() + "," + getPosicaoRoboVertical()  );		
		
	}
	
	public void setPosicaoAtualRobo(int x , int y) {		
		setPosicaoRoboVertical(x);
		setPosicaoRoboHorizontal(y);
	}

	public int getPosicaoRoboVertical() {
		return posicaoRoboVertical;
	}


	public void setPosicaoRoboVertical(int posicaoRoboVertical) {
		this.posicaoRoboVertical = posicaoRoboVertical;
	}



	public int getPosicaoRoboHorizontal() {
		return posicaoRoboHorizontal;
	}



	public void setPosicaoRoboHorizontal(int posicaoRoboHorizontal) {
		this.posicaoRoboHorizontal = posicaoRoboHorizontal;
	}



	public void close() {
		this.setVisible(false);
	}

}
