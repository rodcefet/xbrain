package br.com.xbrain.service;

import javax.swing.JOptionPane;

public class MatrizService implements IMatrizService {
	
	
   public boolean validaXY(String valorX, String valorY) {
		
		boolean retorno = true;
		
		
		
		if( ( valorX!=null && valorY!=null) && (valorX.length()>0 && valorY.length()>0)  ) {
			
			if(!valorX.matches("[0-9]+")) {			
				JOptionPane.showMessageDialog(null, "Valor Inválido para X","Validação Posição Robô",1);
				retorno = false;
			}
			
			if(!valorY.matches("[0-9]+")) {			
				JOptionPane.showMessageDialog(null, "Valor Inválido para Y","Validação Posição Robô",1);
				retorno = false;
			}
			
			if(valorX.length()>1) {
				JOptionPane.showMessageDialog(null, "Valor maior que permitido para X","Validação Posição Robô",1);
				retorno = false;				
			}
			
			if(valorY.length()>1) {
				JOptionPane.showMessageDialog(null, "Valor maior que permitido para Y","Validação Posição Robô",1);
				retorno = false;				
			}
		}
		else {
			
			JOptionPane.showMessageDialog(null, "Valor Inválido para X ou Y","Validação Posição Robô",1);
			retorno = false;
		}
		
		
		return retorno;
		
	}

}
