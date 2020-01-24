package principal;

import controlador.ControladorBienvenida;
 class Main {

	public static void main(String[] args) {
		try {
			
			
			//Creamos el objeto vista.
			vista.Bienvenida ventanaBienvenida = new vista.Bienvenida();
			ventanaBienvenida.setVisible(true);
			
			
			//Creamos en controlador con acceso al modelo y la vista
			ControladorBienvenida controladorBienvenida= new ControladorBienvenida(ventanaBienvenida);
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
