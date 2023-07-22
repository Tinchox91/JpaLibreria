package Inicio;

import EntidadesLogica.Autor;
import EntidadesLogica.Editorial;
import EntidadesLogica.Libro;
import ServicioPersistencia.ServicioAutor;
import ServicioPersistencia.ServicioEditorial;
import ServicioPersistencia.ServicioLibro;
import java.util.ArrayList;
import java.util.Scanner;


public class LibroMenu {
    //Scanner
    Scanner leer = new Scanner(System.in).useDelimiter("\n");    
    //Intanciar servicios:
    ServicioLibro servlibro = new ServicioLibro(); 
    ServicioAutor servautor = new ServicioAutor();
    ServicioEditorial servedi= new ServicioEditorial();
        MenuEditorial menuedi = new MenuEditorial();
    MenuAutor menuautor = new MenuAutor();   
      
    public void crearLibro(){
        System.out.println("Ingrese id");
        long id = leer.nextLong();
        System.out.println("Ingrese titulo");
        String titulo = leer.next();
        System.out.println("Ingrese anio");
        Integer anio = leer.nextInt();
        System.out.println("Ingrese cantidad de ejemplares");
        Integer ejemplares= leer.nextInt();
        System.out.println("Ingrese ejemplares prestados");
        Integer prestados= leer.nextInt();
        
        Integer restantes =ejemplares-prestados ;
        System.out.println("Ingrese si tiene alta o no");
        String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
    System.out.println("Los autores disponibles: ");
        ArrayList<Autor> lista = new ArrayList(servautor.traerAutores());
        for (Autor aut : lista) {
            System.out.println("Nombre: " + aut.getNombre());
            System.out.println("ID: " + aut.getId());
            System.out.println("-------------------------");
        }

        System.out.println("Elija el autor");
        String nombre2 = leer.next();
        Autor aut = new Autor();
        for (Autor au : lista) {
            if (nombre2.equals(au.getNombre())) {
                aut = au;
            }
        }

        System.out.println("Las editoriales disponibles: ");
        ArrayList<Editorial> lista2 = new ArrayList(servedi.traerEditorial());
        for (Editorial edi : lista2) {
            System.out.println("Nombre: " + edi.getNombre());
            System.out.println("ID: " + edi.getId());
            System.out.println("-------------------------");
        }

        System.out.println("Elija la editorial");
        String nombre3 = leer.next();
        Editorial editorial = new Editorial();
        for (Editorial edi : lista2) {
            if (nombre3.equals(edi.getNombre())) {
                editorial = edi;
            }
        }

        // editorial= menuedi.crearEditorial();
        // autor=menuautor.crearAutor();

        Libro libro = new Libro(id, titulo, anio, ejemplares, prestados, restantes, alta2, aut, editorial);
        System.out.println("Libro creado con éxito!");
        servlibro.crearLibro(libro);
    }
   
public void eliminarLibro(){
      ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());
       System.out.println("Elije el libro que desea eliminar: ");
       for (Libro libros : lista) {
           System.out.println("Nombre: "+ libros.getTitulo());
           System.out.println("----------------");    
       }
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
           if (elim.equals(libros.getTitulo())){
               libro2=libros;
           }
           
       }
       servlibro.eliminar(libro2.getId());
       System.out.println("Autor eliminado con exito! ");
   }
public void modificarLibro(){
     ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());
    System.out.println("Elije el libro que desea modificar: ");
       for (Libro libros : lista) {
           System.out.println("Nombre: "+ libros.getTitulo());
           System.out.println("----------------");    
       }
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
           if (elim.equals(libros.getTitulo())){
               libro2=libros;
           }
           
       }
     System.out.println("El nuevo titulo es: "+libro2.getTitulo());
     libro2.setTitulo(leer.next());
     System.out.println("El nuevo anio: "+libro2.getAnio());
     libro2.setAnio(leer.nextInt());
     System.out.println("cantidad de ejemplares: "+libro2.getEjemplares());
       libro2.setEjemplares(leer.nextInt());
       System.out.println("Cantidad de prestados "+libro2.getEjemplaresPrestados());
       libro2.setEjemplaresPrestados(leer.nextInt());
       System.out.println("Alta: "+libro2.isAlta());
       String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
        libro2.setAlta(alta2);
        int disponibles= (libro2.getEjemplares()-libro2.getEjemplaresPrestados());
        libro2.setEjemplaresRestantes(disponibles);
        servlibro.modificar(libro2);
       System.out.println("libro modificado con exito! ");
}
public void buscarLibroID(){
    System.out.println("Ingrese el ID del libro a buscar:");
    long id = leer.nextLong();
    Libro libro = new Libro();
   libro= servlibro.buscarLibro(id);
    System.out.println("-------------");
    System.out.println(libro.toString());
    
}
public void buscarLibroTitulo(){
     ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());   
    System.out.println("Ingrese el titulo del libro que busca: ");          
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
           if (elim.equals(libros.getTitulo())){
               libro2=libros;
           }           
       }
    System.out.println(libro2.toString());
}
public void buscarLibroEditorial(){
    ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());
       System.out.println("Indica el nombre de la editorial: ");      
      
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
           if (elim.equals(libros.getEditorial().getNombre())){
               libro2=libros;
           }           
       }
      
       System.out.println(libro2.toString());   
    
}
public void buscarLibroAutor(){
     ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());
       System.out.println("Indica el nombre del autor: ");
      
       String elim= leer.next();
       Libro libro2 = new Libro();
       for (Libro libros : lista) {
           if (elim.equals(libros.getAutor().getNombre())){
               libro2=libros;
           }           
       }
      
       System.out.println(libro2.toString());   
}
public void mostrarTodos(){
  ArrayList<Libro> lista = new ArrayList(servlibro.traerLibros());
    for (Libro libro : lista) {
        System.out.println(libro.toString());
        System.out.println("---------------");
        
    }
}
   
}
   
