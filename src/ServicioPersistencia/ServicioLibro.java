package ServicioPersistencia;

import EntidadesLogica.Libro;
import Persistencia.LibroJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioLibro {
    LibroJpaController control = new LibroJpaController();
    
    
     public void crearLibro(Libro libro) {       
               
            control.create(libro);                
            }
     
    public void eliminar(long id){
        try {
            control.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServicioLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
public void modificar(Libro alumn){
        try {
            control.edit(alumn);
        } catch (Exception ex) {
            Logger.getLogger(ServicioLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Libro buscarLibro(long dni){
    try {
        Libro libro = new Libro();
    libro=control.findLibro(dni);
        return libro ;
    } catch (Exception e) {      
        return null;
    }
    
   
}

    public List<Libro> traerLibros() {
        List<Libro> lista = control.findLibroEntities();
        
        return lista;
    }

    

}
