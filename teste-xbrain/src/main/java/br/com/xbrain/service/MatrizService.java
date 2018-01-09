package br.com.xbrain.service;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class MatrizService implements Serializable, IMatrizService {	
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String VALIDACAO_ROBO = "Validação Posição Robô";

    public boolean validaXY(String valorX, String valorY) {
		
		boolean retorno = true;
		
		
		
		if( ( valorX!=null && valorY!=null) && (valorX.length()>0 && valorY.length()>0)  ) {
			
			if(!valorX.matches("[0-9]+")) {			
				JOptionPane.showMessageDialog(null, "Valor Inválido para X",VALIDACAO_ROBO,1);
				retorno = false;
			}
			
			if(!valorY.matches("[0-9]+")) {			
				JOptionPane.showMessageDialog(null, "Valor Inválido para Y",VALIDACAO_ROBO,1);
				retorno = false;
			}
			
			if(valorX.length()>1) {
				JOptionPane.showMessageDialog(null, "Valor maior que permitido para X",VALIDACAO_ROBO,1);
				retorno = false;				
			}
			
			if(valorY.length()>1) {
				JOptionPane.showMessageDialog(null, "Valor maior que permitido para Y",VALIDACAO_ROBO,1);
				retorno = false;				
			}
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Valor Inválido para X ou Y",VALIDACAO_ROBO,1);
			retorno = false;
		}
		
		
		return retorno;
		
	}
    
  
}
