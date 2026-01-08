package cr.zona_fit;

import cr.zona_fit.modelo.Cliente;
import cr.zona_fit.servicio.IClienteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

    @Autowired
    private IClienteServicio clienteServicio;

    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

    String nl = System.lineSeparator(); // Caracter de salto de linea generico

	public static void main(String[] args) {
        logger.info("Iniciando la aplicación");
        // Levantar fabrica de Spring
		SpringApplication.run(ZonaFitApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        zonaFitApp();
    }

    private void zonaFitApp() {
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir) {
            var opcion = mostrarMenu(consola);
            salir = ejecutarOpciones(consola, opcion);
            logger.info(nl);
        }
    }

    private int mostrarMenu(Scanner consola) {
        logger.info("""
        \n*** Aplicación Zona Fit Gym ***
        \t1. Listar Clientes
        \t2. Buscar Cliente
        \t3. Agregar Cliente
        \t4. Modificar Cliente
        \t5. Eliminar Cliente
        \t6. Salir
        * Elige una opción:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private boolean ejecutarOpciones(Scanner consola, int opcion) {
        var salir = false;
        switch (opcion) {
            case 1 -> {
                logger.info(nl + "--- Listado de Clientes ---" + nl);
                List<Cliente> clientes = clienteServicio.listarClientes();
                clientes.forEach(cliente -> logger.info(cliente.toString()));
            }
            case 2 -> {
                logger.info(nl + "--- Buscar Cliente por ID ---");
                logger.info("Id cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
                if (cliente != null) {
                    logger.info("Cliente encontrado: " + cliente);
                } else {
                    logger.info("Cliente NO encontrado: " + idCliente);
                }
            }
        }
        return salir;
    }
}
