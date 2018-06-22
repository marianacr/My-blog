package view;

import javax.swing.JFrame;

import javax.swing.WindowConstants;

import controller.ControladorTabuleiro;



public class Iniciar{

	private static TelaInicial frameIniciar;
	private static ControladorTabuleiro controlador;
	
	public static void main(String[] args) {
		
	 
		frameIniciar = new TelaInicial();
	}
	

	public static void Iniciar() {
		controlador = ControladorTabuleiro.getControladorTabuleiro();	
	 	controlador.addObserver(controlador.frame.painelTabuleiro);
		
	}
	
	public static void ReIniciar() {
		
		controlador.EncerraControladorTabuleiro();
		controlador = controlador.getControladorTabuleiro();	
		controlador.addObserver(controlador.frame.painelTabuleiro);
		
	}
	


	
		
	
}
