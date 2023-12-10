package Test;

public class TestMetodosComprobarRango {

	public boolean comprobar() {
		String n = "5";
		String s = "c";
		String s1 = "C";
		return true == esNumero(n) && false == esletra(n) && true == esletra(s1) && true == esletra(s)
				&& true == letraRango(s1) && true == letraRango(s.toUpperCase());

	}

	public static boolean esletra(String letra) {
		try {
			int numero = Integer.parseInt(letra);
			return false;

		} catch (NumberFormatException e) {
			return true;
		}
	}

	public static boolean letraRango(String letra) {

		if (letra.equals("A") || letra.equals("B") || letra.equals("C") || letra.equals("D") || letra.equals("E")
				|| letra.equals("F") || letra.equals("G") || letra.equals("H") || letra.equals("I")
				|| letra.equals("J")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean esNumero(String num) {
		try {
			int numero = Integer.parseInt(num);
			if (numero >= 1 && numero <= 10) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
