package cl.infoclub.fsj.facade;

import java.sql.SQLException;
import java.util.List;

import cl.infoclub.fsj.dao.CursoDao;
import cl.infoclub.fsj.dao.FormaDePagoDAO;
import cl.infoclub.fsj.dao.InscripcionDAO;
import cl.infoclub.fsj.entity.CursoDTO;
import cl.infoclub.fsj.entity.FormaDePagoDTO;
import cl.infoclub.fsj.entity.InscripcionDTO;

public class Facade {
	
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		
		System.out.println("Ingreso al registro");
		
		InscripcionDAO dao = new InscripcionDAO();
		
		System.out.println("Instanciasión registro");
		
		return dao.insertarInscripcion(dto);
	}
	
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException{
		System.out.println("Ingreso obtener curso");
		CursoDao dao = new CursoDao();
		
		System.out.println("Instanciasión curso DAO");
		
		return dao.obtieneCursos();
	}
	
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException{
		FormaDePagoDAO dao = new FormaDePagoDAO();
		return dao.obtieneFormasDePago();
	}

}
