package PPAPRegner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static PPAPRegner.SvarMapping.FIEL_MELDING;

@WebServlet("/regner")
public class Regner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		String temperatur = request.getParameter("temperatur");
		String temperaturMedFjernetMellomRom = temperatur.replaceAll(" ", "");

		String valg = request.getParameter("valg");

//		C  &#8451;
//		F  &#8457;
		if (Validator.erGyldig(temperaturMedFjernetMellomRom, valg)) {
			double svar = 0.0;
			double temp = Double.parseDouble(temperaturMedFjernetMellomRom);

			if (valg.equals("CTF")) {

				if (temp >= -273.15) {
					svar = CTF(temp);
					String CTF = "<h1>Temperaturomregning resultat</h1>" + "<h1>" + temp + " &#8451;" + " = " + svar
							+ " &#8457;" + "</h1>";
					printUtSvar(response, CTF);

				} else {
					printUtSvar(response, FIEL_MELDING);
				}

			} else {
				if (temp >= -459.67) {
					svar = FTC(temp);
					String FTC = "<h1>Temperaturomregning resultat</h1>" + "<h1>" + temp + " &#8457;" + " = " + svar
							+ " &#8451;" + "</h1>";
					printUtSvar(response, FTC);
				} else {
					printUtSvar(response, FIEL_MELDING);
				}
			}

		} else {
			printUtSvar(response, FIEL_MELDING);
		}
	}

	public static void printUtSvar(HttpServletResponse response, String s) throws IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(s);
		out.println(
				"<a href=\"http://localhost:8080/Frivillig1/index.html\" style=\"color:blue;\" style=\"text-decoration: underline;\">En gang til</a>");
		out.println("</body>");
		out.println("</html>");
	}

	private static double round(double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

	public static double CTF(double input) {
		return round(((input * 9.0 / 5) + 32), 1);
	}

	public static double FTC(double input) {
		return round(((input - 32.0) * 5.0 / 9), 1);
	}

}
