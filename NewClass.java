package javaapplication23;
import java.util.ArrayList;
import java.util.Scanner;

public class NewClass {
    
static int tam, cont, opt;
    static String[] lista;

    public NewClass(int tam) {
        this.tam = tam;
        lista = new String[tam];
        cont = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el tamano de la lista:");
        int t = sc.nextInt();

        String p = "";
        NewClass so = new NewClass(t);

        do {
            System.out.println("\nMenu:");
            System.out.println("1- add");
            System.out.println("2- del");
            System.out.println("3- edit");
            System.out.println("4- show");
            System.out.println("5- exit");
            System.out.print("Opcion: ");

            if (!sc.hasNextInt()) {  // Evita error si ingresan letras
                System.out.println("Error: debes ingresar un numero.");
                sc.next(); // Limpia el valor incorrecto
                continue;
            }

            opt = sc.nextInt();

            switch (opt) {
                case 1: // agregar
                    if (cont < tam) {
                        System.out.println("Valor a agregar:");
                        p = sc.next();
                        agregar(p);
                    } else {
                        System.out.println("Error: la lista esta llena.");
                    }
                    break;

                case 2: // eliminar
                    if (cont > 0) {
                        eliminar();
                    } else {
                        System.out.println("Error: no hay elementos para eliminar.");
                    }
                    break;

                case 3: // editar
                    if (cont > 0) {
                        System.out.println("Posicion a editar (0 - " + (cont - 1) + "):");
                        int pos = sc.nextInt();
                        if (pos >= 0 && pos < cont) {
                            System.out.println("Nuevo valor:");
                            p = sc.next();
                            editar(pos, p);
                        } else {
                            System.out.println("Error: posicion invalida.");
                        }
                    } else {
                        System.out.println("Error: no hay elementos para editar.");
                    }
                    break;

                case 4: // mostrar
                    if (cont > 0) {
                        mostrar();
                    } else {
                        System.out.println("La lista está vacia.");
                    }
                    break;

                case 5: // salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Error: opcion invalida, intenta de nuevo.");
            }

        } while (opt != 5);

        sc.close();
    }

    public static void agregar(String p) {
        lista[cont] = p;
        System.out.println("Dato agregado: " + p + " en pos: " + cont);
        cont++;
    }

    public static void eliminar() {
        System.out.println("Dato eliminado: " + lista[0]);
        for (int i = 0; i < cont - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[cont - 1] = null; // limpia el último
        cont--;
    }

    public static void editar(int pos, String p) {
        System.out.println("Dato en posicion " + pos + " cambiado de " + lista[pos] + " a " + p);
        lista[pos] = p;
    }

    public static void mostrar() {
        System.out.println("Contenido de la lista:");
        for (int i = 0; i < cont; i++) {
            System.out.println("Pos " + i + ": " + lista[i]);
        }
    }
}
