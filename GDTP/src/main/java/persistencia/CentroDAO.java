package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.entities.Centro;

public class CentroDAO<E> extends AbstractEntityDAO<E> {
	public int crearNuevoCentro(Centro aCentro) throws SQLException {
		 
		return insert (aCentro);
	}

	public int seleccionarCentro(Centro aCentro) {
		// El iD centro es el centro que queremos seleccionar, el nombre de la clase "Centro" es la tabla que queremos
		// buscar y la cadena del final representa la clave que usamos para hacer la seleccion.
		
			if (aCentro != null){
				ResultSet aux = get(aCentro);
				try {
					while (aux.next()) {
						aCentro.set_nombre(aux.getString("Nombre"));
						aCentro.set_localizacion(aux.getString("Localizacion"));
						aCentro.set_Id(aux.getInt("id"));
					}
			
				} catch (SQLException e) {
					e.printStackTrace();
					Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Centro no encontrado");
		}
		}
			else {
				throw new NullPointerException("Centro no encontrado");
			}
		
			
		return 0;
		
	}

	public int editarCentro(Centro aCentro) {
		// El id Centro es el Centro que queremos editar, el nombre de la clase "Centro" es la tabla que queremos
		int resultado = 0;
		if (aCentro!=null) {
		try{
			seleccionarCentro(aCentro);
			//primero busca que el centro exista si no salta la excepcion lo modifica
			resultado = update (aCentro);
			return resultado;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		}
		else {
			throw new NullPointerException("Centro no editado");
		}
		
		return resultado;
	}

	public List<Centro> listarCentro() {
		List<Centro> Centros = new ArrayList<>();
		ResultSet aux = get("Centro");
		try {
			while (aux.next()) {
				Centro aCentro = new Centro();
				aCentro.set_nombre(aux.getString("Nombre"));
				aCentro.set_localizacion(aux.getString("Localizacion"));
				aCentro.set_Id(aux.getInt("id"));
			
			}
		} catch (SQLException e) {
				e.printStackTrace();
				Logger.getLogger("GDTP_Logger").log(Level.SEVERE, "Error al acceder a la tabla Centro");
				
			}

		return Centros; 
	}
}
