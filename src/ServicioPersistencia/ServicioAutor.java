package ServicioPersistencia;

import EntidadesLogica.Autor;
import Persistencia.AutorJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioAutor {
    AutorJpaController control = new AutorJpaController();
    public void crearAutor(Autor aut) {       
               
            control.create(aut);                
            }
     
    public void eliminar(long id){
        
    try {
        control.destroy(id);
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(ServicioEditorial.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }
public void modificar(Autor aut){
        try {
            control.edit(aut);
        } catch (Exception ex) {
            Logger.getLogger(ServicioLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Autor buscarAutor(long id){
    try {
        Autor aut = new Autor();
    aut=control.findAutor(id);
        return aut ;
    } catch (Exception e) {      
        return null;
    }
    
   
}

    public List<Autor> traerAutores() {
        List<Autor> lista = control.findAutorEntities();
        
        return lista;
    }

}
