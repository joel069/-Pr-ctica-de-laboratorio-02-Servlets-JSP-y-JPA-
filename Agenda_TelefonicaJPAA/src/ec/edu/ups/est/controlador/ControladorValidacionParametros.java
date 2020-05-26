package ec.edu.ups.est.controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorValidacionParametros {

	public ControladorValidacionParametros() {

	}

	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9,10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					}
					else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (cedula.equals("0000000000"))
			cedulaCorrecta = false;

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}


		return cedulaCorrecta;
	}

	public boolean validadorDeCorreo(String correo) {
		boolean correoCorrecto= true;

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(correo);

		if (mather.find() == false) {
			correoCorrecto = false;
		} 
		return correoCorrecto;
	}

	public boolean validarTexto(String texto) {
		boolean ban = true;
		for (int i = 0; i < texto.length(); i++) {
			char o = texto.charAt(i);
			if(o > 32 && (o<65 || o > 90) && (o<97 || o >122))
				ban = false;

		}	

		return ban;
	}

	public boolean validarNumero(String texto) {
		boolean ban = true;
		for (int i = 0; i < texto.length(); i++) {
			char o = texto.charAt(i);
			if(!(o >= 48 && o <= 57)) {
				ban = false;
			}


		}	

		return ban;
	}



}
