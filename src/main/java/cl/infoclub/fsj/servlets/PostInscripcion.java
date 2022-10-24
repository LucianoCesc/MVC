package cl.infoclub.fsj.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.infoclub.fsj.entity.InscripcionDTO;
import cl.infoclub.fsj.facade.Facade;

/**
 * Servlet implementation class PostInscripcion
 */
@WebServlet("/posInscripcion")
public class PostInscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PostInscripcion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// obtengo los datos del formulario
	      String nombre = request.getParameter("nombre");
	      String celular = request.getParameter("celular");
	      int idCurso = Integer.parseInt(request.getParameter("idCurso"));
	      int idFormaDePago = Integer.parseInt(request.getParameter("idFormaPago"));
	       // instancio el DTO y le asigno los datos
	      InscripcionDTO dto = new InscripcionDTO();
	      dto.setNombre(nombre);
	      dto.setCelular(celular);
	      dto.setIdCurso(idCurso);
	      dto.setIdFormaDePago(idFormaDePago);
	      // invoco al facade para procesar la inscripcion
	      Facade facade = new Facade();
	      int idInsc = 0;
			try {
					idInsc = facade.registrarInscripcion(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	       // el resultado lo adjunto como atributo en el request
	      request.setAttribute("idInsc", idInsc);
	      
	       // redirecciono el control hacia la siguiente vista,
	       // es decir: hacia su servlet de pre-confirmacion
	      request.getRequestDispatcher("/preConfirmacion").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
