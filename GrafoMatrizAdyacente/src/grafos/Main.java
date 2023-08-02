package grafos;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static int contadorVertices = 0;

    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz();
        // Agregar v�rtices
        Scanner tc = new Scanner(System.in);
        List<String> arista = new ArrayList<String>();

        

            while (true) {
            	System.out.println("---------------------------------");
            	System.out.println("   SIMPLE MENU-JORDAN GUEVARA");
                System.out.println("---------------------------------");
                System.out.println("1. Insertar v�rtices");
                System.out.println("2. Conectar v�rtices");
                System.out.println("3. Verificar si dos v�rtices son adyacentes");
                System.out.println("4. Mostrar nodos conectados a un v�rtice");
                System.out.println("5. Salir");
                System.out.println("---------------------------------");
                System.out.print("Seleccione una opci�n: ");
                int opc = tc.nextInt();
                tc.nextLine(); // Consumir el salto de l�nea pendiente

                switch (opc) {
                	case 1:
                		System.out.print("Ingrese cantidad de V�RTICES (m�nimo 2): ");
                        int nVertices = tc.nextInt();
                        tc.nextLine(); // Consumir el salto de l�nea pendiente

                        if (nVertices >= 2 && nVertices <= 20) {
                            for (int i = 0; i < nVertices; i++) {
                                System.out.print("Ingrese el v�rtice " + (i + 1) + ": ");
                                String vertice = tc.nextLine();
                                grafo.nuevoVertice(vertice);
                                arista.add(vertice);
                            }
                        }else {
                            System.out.println("La cantidad de v�rtices debe ser entre 2 y 20.");
                        }

                            contadorVertices = nVertices; // Actualizar el contador de v�rtices
                		break;
                    case 2:
                        System.out.print("Ingrese el primer v�rtice a conectar: ");
                        String vertice1 = tc.nextLine();
                        System.out.print("Ingrese el segundo v�rtice a conectar: ");
                        String vertice2 = tc.nextLine();
                        try {
                            grafo.nuevoArco(vertice1, vertice2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el primer v�rtice: ");
                        vertice1 = tc.nextLine();
                        System.out.print("Ingrese el segundo v�rtice: ");
                        vertice2 = tc.nextLine();
                        try {
                            System.out.println(grafo.adyacente(vertice1, vertice2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el v�rtice del que desea conocer los nodos conectados: ");
                        String vertice = tc.nextLine();
                        try {
                            List<Vertice> nodosConectados = grafo.nodosConectados(vertice);
                            System.out.println("Nodos conectados a " + vertice + ":");
                            for (Vertice v : nodosConectados) {
                                System.out.println(v.nomVertice());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 5:
                        System.out.println("Gracias");
                        return;

                    default:
                        System.out.println("Opci�n inv�lida. Intente nuevamente.");
                        break;
                }
            }
         
    }
}
