package otrosMetodos;

import controlador.ControladorAlerta;

public class ValidarDNI {

// Validar dni
private static boolean error=false;
    /**
     * Valida un DNI
     * Comprueba si tiene entre 8 y 9 caracteres
     * Comprueba si la parte numerica es correcta
     * Comprueba si la letra es correcta
     * Comprueba si el numero y la letra es corrrecta
     * @param DNI
     * @throws DNIException 
     */
    public static void validarDNI(String DNI){

        //Comprobamos la longitud del dni
        if (!(DNI.length() >= 8 && DNI.length() <= 9)) {
			vista.Alerta ventanaAlerta = new vista.Alerta(2);
			ventanaAlerta.setVisible(true);
			ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
        }

        //saco la parte numerica
        String parte_numerica = DNI.substring(0, DNI.length() - 1);

        //Aqui guardare el dni
        int numeroDNI = 0;

        try {
            //Lo transformo en un numero
            //Puede saltar la excepcion
            numeroDNI = Integer.parseInt(parte_numerica);
        } catch (NumberFormatException e) {
			vista.Alerta ventanaAlerta = new vista.Alerta(3);
			ventanaAlerta.setVisible(true);
			ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
			error=true;
        }

        // Valida que la letra conincida con el resto del numero
        char letra = DNI.substring(DNI.length() - 1, DNI.length()).toUpperCase().charAt(0);

      

        //Ya hemos validado el formato
        final int DIVISOR = 23;

        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numeroDNI % DIVISOR;

        String nuevoDNI = numeroDNI + "" + letrasNIF[resto];

        if(DNI.startsWith("0")){
            nuevoDNI = "0"+nuevoDNI;
        }
        if (!(letra >= 'A' && letra <= 'Z')||error==true) {
			vista.Alerta ventanaAlerta = new vista.Alerta(4);
			ventanaAlerta.setVisible(true);
			ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
        }
        else if (!(nuevoDNI.equals(DNI))) {
        	vista.Alerta ventanaAlerta = new vista.Alerta(5);
			ventanaAlerta.setVisible(true);
			ControladorAlerta controladorAlerta = new ControladorAlerta(ventanaAlerta);
        }

    }

}
