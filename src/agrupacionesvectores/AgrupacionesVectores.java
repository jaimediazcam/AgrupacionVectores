package agrupacionesvectores;

import java.util.Scanner;

/**
 * Esta clase proporciona un programa para agrupar a los alumnos en grupos de un tamaño determinado.
 */
public class AgrupacionesVectores {

    /**
     * El método principal que se ejecuta al iniciar el programa.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos
        int numCasos = sc.nextInt();
        sc.nextLine();

        // Procesar cada caso
        for (int i = 0; i < numCasos; i++) {
            // Leer el tamaño del grupo y el número de alumnos
            int tamGrupo = sc.nextInt();
            int numAlumnos = sc.nextInt();
            sc.nextLine();

            // Leer los nombres de los alumnos
            String[] alumnos = sc.nextLine().split(" ");

            // Agrupar a los alumnos
            String[] grupos = agruparAlumnos(alumnos, tamGrupo);

            // Imprimir los grupos
            for (String grupo : grupos) {
                System.out.println(grupo);
            }

            // Rellenar con FALTA si el último grupo no tiene suficientes miembros
            int numGrupos = grupos.length;
            if (grupos[numGrupos - 1].split(" ").length < tamGrupo) {
                String ultimoGrupo = grupos[numGrupos - 1];
                String[] miembros = ultimoGrupo.split(" ");
                int numFaltantes = tamGrupo - miembros.length;
                for (int j = 0; j < numFaltantes; j++) {
                    ultimoGrupo += " FALTA";
                }
                System.out.println(ultimoGrupo);
            }

            // Separador entre casos
            System.out.println("----------");
        }
    }

    /**
     * Agrupa a los alumnos en grupos del tamaño especificado.
     *
     * @param alumnos   los nombres de los alumnos
     * @param tamGrupo  el tamaño del grupo
     * @return un arreglo de cadenas que representa los grupos de alumnos
     */
    public static String[] agruparAlumnos(String[] alumnos, int tamGrupo) {
        int numGrupos = (int) Math.ceil((double) alumnos.length / tamGrupo);
        String[] grupos = new String[numGrupos];

        int inicio = 0;
        int fin = tamGrupo - 1;
        for (int i = 0; i < numGrupos; i++) {
            if (fin >= alumnos.length) {
                fin = alumnos.length - 1;
            }
            String grupo = "";
            for (int j = inicio; j <= fin; j++) {
                grupo += alumnos[j] + " ";
            }
            grupos[i] = grupo.trim();

            inicio += tamGrupo;
            fin += tamGrupo;
        }

        return grupos;
    }
}