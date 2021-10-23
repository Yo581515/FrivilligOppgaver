package Frivillig5Packe;

import static Frivillig5Packe.UrlMappings.LOGIN_URL;
import static Frivillig5Packe.UrlMappings.HEMELIGSIDE_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/"+LOGIN_URL)
public class logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Inn noe kode her i forbindelse med evt. feilmeldinger?
    	String feilmelding = "";
    	String feilkode = request.getParameter("feilkode");
    	if (feilkode != null && feilkode.equals("invalidusername")) {
    		feilmelding = "Ugyldig brukernavn!";
    	} 
        
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        // Inn noe kode her i forbindelse med evt. feilmeldinger?
        out.println("<p style=\"color:red;\">"+ feilmelding+ "</p>"); 

        out.println("<form action=\""+LOGIN_URL+"\"" + "method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Logg inn</legend>");
        out.println("    <p>Brukernavn: <input type=\"text\" name=\"username\" /></p>");
        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brukernavn = request.getParameter("username");
		
		// Sjekke at vi har gyldig brukernavn
    	if (!Validator.isGyldigUsername(brukernavn)) {
    		//Gaa tilbake til innloggingsskjema med feilmelding
    		
    		response.sendRedirect(LOGIN_URL + "?feilkode=invalidusername");
    		
    	} else {
            // Innlogging av bruker, evt. feilhåndtering
            // Oppretting av sesjonsdata for bruker
    		LoggInnUtil.loggInn(request, brukernavn);
            response.sendRedirect(HEMELIGSIDE_URL);
    	}
		
	}

}
