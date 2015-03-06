package ServletsJava;
import Controlador.*;
import Clases.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarArticulo
 */
@WebServlet("/AgregarArticulo")
public class AgregarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarArticulo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tipo=request.getParameter("tipo").toString();
		String descripcion=request.getParameter("descripcion");
		String color=request.getParameter("color");
		String consumo=request.getParameter("consumo");
		String precio=request.getParameter("precio");
		String carga=request.getParameter("carga");
		String pulgada=request.getParameter("pulgadas");
		String peso=request.getParameter("peso");
		
		try{
		Controlador.ControladorElectrodomestico controladorEle= new ControladorElectrodomestico();
		
		controladorEle.AltaModificacion(tipo.toString(), descripcion, peso, consumo, carga, color, pulgada, precio, true, false, 0);
		request.getRequestDispatcher("NuevoArticulo.jsp").forward(request,response );
		}
		catch(Exception ex)
		{}
		
		
		
	}

}
