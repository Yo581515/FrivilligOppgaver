package PPAPRegner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regner")
public class Regner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String temperatur = request.getParameter("temperatur");
		String temperaturMedFjernetMellomRom = temperatur.replaceAll(" ", "");
		
		String valg = request.getParameter("valg");
		
		
		
	
	}
	
	private static double round (double value, int precision) {
	    int scale = (int) Math.pow(10, precision);
	    return (double) Math.round(value * scale) / scale;
	}
	
	public static double CTF(double input) {
		return round(((input*9.0/5)+32),1);
	}
	
	public static double FTC(double input) {
		return round(((input-32.0)*5.0/9),1);
	}


}
