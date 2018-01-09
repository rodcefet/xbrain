package br.com.xbrain;

import br.com.xbrain.service.IMatrizService;
import br.com.xbrain.service.MatrizService;
import junit.framework.TestCase;

public class RoboTeste extends TestCase {
	
	public void testInicializaAplicacao() {
		
		try {
			
			StartEngine.execute();
			
		} catch (Exception e) {
			fail("Erro ao Executar método inical da aplicação");
		}
	}

	public void testValidaXY() {
		IMatrizService matrizService = new MatrizService();
		boolean resultado = matrizService.validaXY("0", "0");
		assertTrue("Valor Inválido",resultado);
	}

	public void testSetPosicaoAtualRobo() {
		ViewEngine testEngine = new ViewEngine();
		int retornoEsperadoX = 8;
		int retornoEseradoY = 9;	
		
		
		testEngine.setPosicaoAtualRobo(8,9);
		
		assertEquals(retornoEsperadoX, testEngine.getPosicaoRoboVertical());
		assertEquals(retornoEseradoY, testEngine.getPosicaoRoboHorizontal());
		
	}
	
	public void testSetPosicaoRoboVertical() {
		ViewEngine testEngine = new ViewEngine();
		int retornoEsperadoX = 9;
		
		testEngine.setPosicaoRoboVertical(9);		
		assertEquals(retornoEsperadoX, testEngine.getPosicaoRoboVertical());
		
	}	
	

	public void testSetPosicaoRoboHorizontal() {
		
		ViewEngine testEngine = new ViewEngine();
		int retornoEsperadoX = 8;
		
		testEngine.setPosicaoRoboHorizontal(8);		
		assertEquals(retornoEsperadoX, testEngine.getPosicaoRoboHorizontal());
		
	}

}
