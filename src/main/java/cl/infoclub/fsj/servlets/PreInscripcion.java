package cl.infoclub.fsj.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.infoclub.fsj.entity.CursoDTO;
import cl.infoclub.fsj.entity.FormaDePagoDTO;
import cl.infoclub.fsj.facade.Facade;

/**
 * Servlet implementation class PreInscripcion
 */
@WebServlet("/preInscripcion")
public class PreInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PreInscripcion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtenemos el facade
				Facade facade = new Facade();
				try {
					//obtenemos las listas
					List<CursoDTO> listaCursos = null;
					try {
						listaCursos = facade.obtenerCursos();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					List<FormaDePagoDTO> listaFormasPago = null;
					try {
						listaFormasPago = facade.obtenerFormasDePago();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					
					//guardo las listas al request
					request.setAttribute("cursos", listaCursos);
					request.setAttribute("formasPago", listaFormasPago);
					
					//mandamos el request a la pagina jsp
					request.getRequestDispatcher("inscripcion.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}

}
