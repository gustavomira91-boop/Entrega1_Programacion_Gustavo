import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase para generar archivos de prueba del proyecto.
 * Entrega 1 - Semana 3.
 */
public class GenerateInfoFiles {

    public static void main(String[] args) {
        try {
            // Generar datos de prueba iniciales
            createProductsFile(5);
            createSalesManInfoFile(3);
            
            // Ejemplo de archivo de ventas para un vendedor
            createSalesMenFile(4, "Diego", 10102020L);
            
            System.out.println("Archivos creados con éxito.");
        } catch (Exception e) {
            System.out.println("Error en la generación: " + e.getMessage());
        }
    }

    public static void createProductsFile(int productsCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("productos.txt"))) {
            for (int i = 1; i <= productsCount; i++) {
                // ID;Nombre;Precio
                writer.println(i + ";Producto_" + i + ";" + (1000 * i));
            }
        } catch (Exception e) {
            System.out.println("Error al crear productos.");
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vendedores.txt"))) {
            String[] nombres = {"Juan", "Maria", "Pedro", "Ana"};
            String[] apellidos = {"Perez", "Gomez", "Rojas", "Daza"};

            for (int i = 0; i < salesmanCount; i++) {
                // Tipo;Cedula;Nombre;Apellido
                writer.println("CC;" + (12345 + i) + ";" + nombres[i % 4] + ";" + apellidos[i % 4]);
            }
        } catch (Exception e) {
            System.out.println("Error al crear info de vendedores.");
        }
    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(name + "_" + id + ".txt"))) {
            // Primera linea: ID del vendedor
            writer.println("CC;" + id);
            
            for (int i = 0; i < randomSalesCount; i++) {
                // IDProducto;Cantidad
                int idProd = (int) (Math.random() * 5) + 1;
                int cant = (int) (Math.random() * 10) + 1;
                writer.println(idProd + ";" + cant);
            }
        } catch (Exception e) {
            System.out.println("Error al crear ventas del vendedor.");
        }
    }
}