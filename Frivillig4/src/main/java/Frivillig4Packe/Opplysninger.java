package Frivillig4Packe;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/Opplysninger")
public class Opplysninger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
        PrintWriter out = response.getWriter();
        
//        String forNavn = CookieUtil.getCookieFromRequest(request, "forNavn");
//        String etterNavn = CookieUtil.getCookieFromRequest(request, "etterNavn");
       
        String feilmelding = "";
    	String feilkode = request.getParameter("feilkode");
    	if (feilkode != null && feilkode.equals("invalidusername")) {
    		feilmelding = "Ugyldig brukernavn. Proov igjen.";
    	} 
    
		
 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>sider som husker deg</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p style=\"color:red;\">"+feilmelding+"</p>");
        out.println("<form action=\"Opplysninger\" " + "method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Personlige Opplysninger</legend>");
        out.println("    <p>Fornavn: <input type=\"text\" name=\"forNavn\" /></p>");
        out.println("    <p>Etternavn: <input type=\"text\" name=\"etterNavn\"/></p>");
        out.println("    <p><input type=\"submit\" value=\"Registrer\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forNavn = request.getParameter("forNavn");
		String etterNavn = request.getParameter("etterNavn");
		String fN = forNavn.replaceAll(" ", "");
		String eN = etterNavn.replaceAll(" ", "");
		System.out.println(fN);
		System.out.println(eN);
		
		
		
		
		if(Validator.erGyldig(fN, eN)) {
			System.out.println("Gyldig");
			CookieUtil.addCookieToResponse(response, "forNavn", fN);
			CookieUtil.addCookieToResponse(response, "etterNavn", eN);
		}else {
			System.out.println("ikke Gyldig");
			response.sendRedirect("Opplysninger" + "?feilkode=invalidusername");
		}
	}

}