package Inicio;

import java.util.Scanner;

public class Menu {

    LibroMenu libro = new LibroMenu();
    MenuAutor menuaut = new MenuAutor();
    MenuEditorial menuedi = new MenuEditorial();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void MenuPrincipal() {
        //menuaut.crearAutor();
        // menuedi.crearEditorial();
        //libro.crearLibro();
        System.out.println("Elije la opcion:");
        System.out.println("1.Cargar libro");
        System.out.println("2.Cargar Editorial");
        System.out.println("3.Cargar Autor");
        String var = leer.next();
        switch (var) {
            case "1":
                System.out.println("Elije la opcion:");
                System.out.println("1.Cargar libro");
                System.out.println("2.Eliminar libro");
                System.out.println("3.Modificar libro");
                System.out.println("4.Buscar libro por id");
                System.out.println("5.Buscar libro por titulo");
                System.out.println("6.Buscar libro por Editorial");
                System.out.println("7.Buscar libro por Autor");
                System.out.println("8.Mostrar todos los libros");
                String oplib = leer.next();
                switch (oplib) {
                    case "1":
                        libro.crearLibro();
                        break;
                    case "2":
                        libro.eliminarLibro();
                        break;
                    case "3":
                        libro.modificarLibro();
                        break;
                    case "4":
                        libro.buscarLibroID();
                        break;
                    case "5":
                        libro.buscarLibroTitulo();
                        break;
                    case "6":
                        libro.buscarLibroEditorial();
                        break;
                    case "7":
                        libro.buscarLibroAutor();
                        break;
                    case "8":
                        libro.mostrarTodos();
                        break;
                    default:
                        throw new AssertionError();
                }

                break;
            case "2":
                System.out.println("1.Cargar Editorial");
                System.out.println("2.Eliminar Editorial");
                System.out.println("3.Modificar Editorial");
                System.out.println("4.Mostrar todas");
                String opedi = leer.next();
                switch (opedi) {
                    case "1":
                        menuedi.crearEditorial();

                        break;
                    case "2":
                        menuedi.eliminarEditorial();
                        break;
                    case "3":
                        menuedi.modificarEditorial();
                        break;
                    case "4":
                        menuedi.mostrarTodas();
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            case "3":
                System.out.println("1.Cargar Autor");
                System.out.println("2.Eliminar Autor");
                System.out.println("3.Modificar Autor");
                System.out.println("4.Mostrar todos");
                System.out.println("5.Buscar por nombre");
                String opeaut = leer.next();
                switch (opeaut) {
                    case "1":
                        menuaut.crearAutor();

                        break;
                    case "2":
                        menuaut.eliminarAutor();
                        break;
                    case "3":
                        menuaut.modificarAutor();
                        break;
                    case "4":
                        menuaut.mostrarTodos();
                        break;
                    case "5":
                        menuaut.buscarAutorNombre();
                        break;
                    default:
                        throw new AssertionError();
                }
                break;

            default:
                throw new AssertionError();
        }

    }

}
