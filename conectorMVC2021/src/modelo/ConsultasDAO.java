package modelo;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface ConsultasDAO {
    public void insertar(PaisVO p);
    public void actualizar(PaisVO p);
    public void eliminar(PaisVO p);
    public ArrayList<PaisVO> consultarTabla();
    
    
}
