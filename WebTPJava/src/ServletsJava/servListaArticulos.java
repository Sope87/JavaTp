package ServletsJava;
import Clases.*;
import Controlador.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class servListaArticulos
 */
@WebServlet("/ListaArticulos")
public class servListaArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private Object string;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servListaArticulos() {
        super();
       
        
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
		
		
		
		ControladorElectrodomestico controlador=new ControladorElectrodomestico();
		String minValue= request.getParameter("minValue");
		String maxValue= request.getParameter("maxValue");
		Integer min=0,max=0;
		if(minValue.isEmpty())
			min=0;
		else
			min=Integer.parseInt(minValue);
		
		if(maxValue.isEmpty())
			max=0;
		else
			max=Integer.parseInt(maxValue);
		
		HttpSession session= request.getSession(true);
	
		
		try {
			ArrayList<Electrodomestico> listElectrodomesticos=controlador.getAllElectrodomestico(min, max);
			session.setAttribute("listElect", listElectrodomesticos);
			request.getRequestDispatcher("ListaArticulos.jsp").forward(request,response );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		
	}

}
