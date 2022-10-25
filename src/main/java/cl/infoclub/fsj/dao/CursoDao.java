package cl.infoclub.fsj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.infoclub.fsj.entity.CursoDTO;


public class CursoDao {
	
	public List<CursoDTO> obtieneCursos() throws SQLException, ClassNotFoundException {
		System.out.println("Obtiene curso DAO");
		//creamos la lista de objetos que devolveran los resultados
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();
		System.out.println("Instancia lista de cursos");
		//creamos la consulta a la base de datos
		String consultaSql = " SELECT id_curso, descripcion, precio " 
				   		   + " FROM curso ";
		System.out.println("Preconexion");
		//conexion a la base de datos y ejecucion de la sentencia
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","conexion","usuario");
		System.out.println("Conexión a la base de datos ejecutada");
		try(PreparedStatement stmt = conexion.prepareStatement(consultaSql)){
			System.out.println("Consulta SQL realizada");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(resultado.getInt("id_curso"));
				cursoDto.setDescripcion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getDouble("precio"));
				listaDeCursos.add(cursoDto);
			}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaDeCursos;
	}
}
