package Inicio;

import EntidadesLogica.Autor;
import ServicioPersistencia.ServicioAutor;
import java.util.ArrayList;
import java.util.Scanner;


class MenuAutor {
      Scanner leer = new Scanner(System.in).useDelimiter("\n");
ServicioAutor serv = new ServicioAutor();

   public Autor crearAutor() {
     System.out.println(" Ingrese nombre del autor");
      String nombree= leer.next();
      System.out.println("Ingrese si tiene alta o no");
        String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
        System.out.println("ingrese una id");
        long ide = leer.nextLong();
        Autor autor = new Autor(ide,nombree,alta2);
        serv.crearAutor(autor);
        System.out.println("Se creo el autor "+ autor.getNombre()+" con exito!!");
        return autor;          
  
     
    }
   public void eliminarAutor(){
       ArrayList<Autor> lista = new ArrayList(serv.traerAutores());
       System.out.println("Elije el autor que desea eliminar: ");
       for (Autor autor : lista) {
           System.out.println("Nombre: "+ autor.getNombre());
           System.out.println("----------------");    
       }
       String elim= leer.next();
       Autor autor2 = new Autor();
       for (Autor autor : lista) {
           if (elim.equals(autor.getNombre())){
               autor2=autor;
           }
           
       }
       serv.eliminar(autor2.getId());
       System.out.println("Autor eliminado con exito! ");
   }
   public void buscarAutorNombre(){
        ArrayList<Autor> lista = new ArrayList(serv.traerAutores());   
    System.out.println("Ingrese el titulo del libro que busca: ");          
       String elim= leer.next();
       Autor autor2 = new Autor();
       for (Autor autores : lista) {
           if (elim.equals(autores.getNombre())){
              autor2=autores;
           }           
       }
    System.out.println(autor2.toString());
   }

  public  void modificarAutor() {
        ArrayList<Autor> lista = new ArrayList(serv.traerAutores());
    System.out.println("Elije el autor que desea modificar: ");
       for (Autor autores : lista) {
           System.out.println("Nombre: "+ autores.getNombre());
           System.out.println("----------------");    
       }
       String mod= leer.next();
      Autor autor2 = new Autor();
       for (Autor autores : lista) {
           if (mod.equals(autores.getNombre())){
               autor2=autores;
           }
           
       }
       System.out.println("Ingrese el nombre nuevo "+autor2.getNombre());
       autor2.setNombre(leer.next());
       System.out.println("Ingrese si esta de alta o no: "+autor2.isAlta());
        String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
        autor2.setAlta(alta2);
        serv.modificar(autor2);
    }

   public void mostrarTodos() {
       ArrayList<Autor> lista = new ArrayList(serv.traerAutores());
    for (Autor autores : lista) {
        System.out.println(autores.toString());
        System.out.println("---------------");
        
    }
       
    }
   
   
   
         }


