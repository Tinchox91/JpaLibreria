package ServicioPersistencia;

import EntidadesLogica.Editorial;
import Persistencia.EditorialJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioEditorial {
EditorialJpaController control = new EditorialJpaController();
 public void crearEditorial(Editorial edi) {       
               
            control.create(edi);                
            }
     
    public void eliminar(long id){
        
    try {
        control.destroy(id);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(ServicioEditorial.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }
public void modificar(Editorial edi){
        try {
            control.edit(edi);
        } catch (Exception ex) {
            Logger.getLogger(ServicioLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Editorial buscarEditorial(long dni){
    try {
        Editorial edi = new Editorial();
    edi=control.findEditorial(dni);
        return edi ;
    } catch (Exception e) {      
        return null;
    }
    
   
}

    public List<Editorial> traerEditorial() {
        List<Editorial> lista = control.findEditorialEntities();
        
        return lista;
    }
}
