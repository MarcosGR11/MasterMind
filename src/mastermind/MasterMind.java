/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;

/**
 *
 * @author marco
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        opcion = juego();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    MasterMind();
                    break;
                default:
            }
            Entrada.leerCadena("\nPresione INTRO para continuar con otra opcion");
            opcion = juego();
        }
        System.out.println("Ha seleccionado Salir");
    }

    public static int juego() {
        System.out.println("¿Desea jugar MasterMind?\n\nEn caso afirmativo, pulse 1");
        System.out.println("Si no desea proceder, pulse 0");
        System.out.println(" ");
        int op = Entrada.leerEntero("Indique como proceder");
        return op;
    }

    public static void MasterMind() {
        int[] vec1 = new int[4];
        int[] vec2 = new int[4];

        CreaCodigo(vec1);
        ver(vec1);
        System.out.println(" ");

        rellenaramano(vec2);
        ver(vec2);
        System.out.println(" ");

        if (iguales(vec1, vec2)) {
            System.out.println("Ha acertado todas las posiciones");
        } else {
            System.out.println("Ha acertado " + aciertos(vec1, vec2) + " posiciones");
            System.out.println("Hay " + semiaciertos(vec1, vec2) + " numeros en lugares incorrectos");
        }
    }

    public static void CreaCodigo(int[] v1) {
        for (int i = 0; i < v1.length; i++) {
            int dato;
            do {
                dato = (int) (Math.random() * 8 + 1);
            } while (Comprobar_Repetido(v1, dato, i));
            v1[i] = dato;
        }
    }

    public static boolean Comprobar_Repetido(int[] v1, int dato, int contador) {
        for (int i = 0; i < contador; i++) {
            if (v1[i] == dato) {
                return true;
            }
        }
        return false;
    }

    public static void rellenaramano(int[] v2) {
        for (int i = 0; i < v2.length; i++) {
            int aux = Entrada.leerEntero("Introduce la posicion " + (i + 1));
            for (int j = 0; j < v2.length; j++) {
                if (aux == v2[j]) {//Si el numero aleatorio existe, se cambia a 0
                    aux = 0;
                }
            }
            if (aux == 0) { //Si existe el numero, se vuelve a la casilla anterior del array
                System.out.println("Introduzca un numero valido");
                i--;
            } else {
                v2[i] = aux;
            }
        }

        int aux;
        for (int i = 0; i < v2.length; i++) {
            do {
                aux = Entrada.leerEntero("Introduce un numero en la posicion "+(i+1));
            } while (Comprobar_Repetido(v2, aux, i) || aux < 1 || aux > 8);
            v2[i]=aux;
        }
    }

    public static void ver(int[] v1) {
        for (int i = 0; i < v1.length; i++) {
            System.out.print(v1[i] + " ");
        }
    }

    public static boolean iguales(int v1[], int v2[]) {
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] != v2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String aciertos(int[] v1, int[] v2) {
        String aciertos = "";
        for (int i = 0; i < v1.length; i++) {
            if (v1[i] == v2[i]) {
                aciertos += "A ";
            }
        }
        return aciertos;
    }

    public static String semiaciertos(int[] v1, int[] v2) {
        String semiaciertos = "";
        for (int i = 0; i < v2.length; i++) {
            for (int j = 0; j < v1.length; j++) {
                if (v2[i] == v1[j] && v1[i] != v2[i]) {
                    semiaciertos += "S ";
                }
            }
        }
        return semiaciertos;
    }
}
