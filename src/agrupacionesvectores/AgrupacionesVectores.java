package agrupacionesvectores;

import java.util.Scanner;

/**
 *
 * @author jaime
 */
public class AgrupacionesVectores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        

        int numCasos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numCasos; i++) {
            int tamGrupo = sc.nextInt();
            int numAlumnos = sc.nextInt();
            sc.nextLine();

            String[] alumnos = sc.nextLine().split(" ");

            String[] grupos = agruparAlumnos(alumnos, tamGrupo);

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