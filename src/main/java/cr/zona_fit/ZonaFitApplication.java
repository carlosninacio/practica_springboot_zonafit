package cr.zona_fit;

import cr.zona_fit.servicio.IClienteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

    @Autowired
    private IClienteServicio clienteServicio;

    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	public static void main(String[] args) {
        logger.info("Iniciando la aplicación");
        // Levantar fabrica de Spring
		SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("Aplicación finalizada!");
	}

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** Aplicación Zona Fit Gym ***");
    }
}
