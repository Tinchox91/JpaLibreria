package Inicio;

import EntidadesLogica.Autor;
import EntidadesLogica.Editorial;
import ServicioPersistencia.ServicioEditorial;
import java.util.ArrayList;
import java.util.Scanner;


class MenuEditorial {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
ServicioEditorial serv = new ServicioEditorial();
  public Editorial crearEditorial() {
      System.out.println(" Ingrese nombre de Ediorial");
      String nombree= leer.next();
      System.out.println("Ingrese si tiene alta o no");
        String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
        System.out.println("ingrese una id");
        long ide = leer.nextLong();
        Editorial edi = new Editorial(ide,nombree,alta2);
        serv.crearEditorial(edi);
         System.out.println("Se creo la editorial "+ edi.getNombre()+" con exito!!");
        return edi;        
    }
    public void eliminarEditorial(){
          ArrayList<Editorial> lista = new ArrayList(serv.traerEditorial());
       System.out.println("Elije la editorial que desea eliminar: ");
       for (Editorial editorial : lista) {
           System.out.println("Nombre: "+ editorial.getNombre());
           System.out.println("----------------");    
       }
       String elim= leer.next();
       Editorial editorial2 = new Editorial();
       for (Editorial editorial : lista) {
           if (elim.equals(editorial.getNombre())){
               editorial2=editorial;
           }
           
       }
       serv.eliminar(editorial2.getId());
       System.out.println("Editorial eliminada con exito! ");
   }

   public void modificarEditorial() {
           ArrayList<Editorial> lista = new ArrayList(serv.traerEditorial());
    System.out.println("Elije el autor que desea modificar: ");
       for (Editorial edi : lista) {
           System.out.println("Nombre: "+ edi.getNombre());
           System.out.println("----------------");    
       }
       String mod= leer.next();
     Editorial editorial = new Editorial();
       for (Editorial edis : lista) {
           if (mod.equals(edis.getNombre())){
               editorial=edis;
           }
           
       }
       System.out.println("Ingrese el nombre nuevo "+editorial.getNombre());
       editorial.setNombre(leer.next());
       System.out.println("Ingrese si esta de alta o no: "+editorial.isAlta());
        String alta1= leer.next();
        boolean alta2;
        if (alta1.equals("si")){
             alta2 = true;
           
        } else alta2 = false;
        editorial.setAlta(alta2);
        serv.modificar(editorial);
    }

   public void mostrarTodas() {
       ArrayList<Editorial> lista = new ArrayList(serv.traerEditorial());
    for (Editorial edi : lista) {
        System.out.println(edi.toString());
        System.out.println("---------------");
        
    }
       
    }
   
    }


