package sa.tabadul.pcs.warehouse;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sa.tabadul.pcs.warehouse.util.Utils;

@SpringBootApplication

public class WarehouseBackendApplication implements CommandLineRunner {

	@Autowired
	private Utils utils;

	public static void main(String[] args) {
		SpringApplication.run(WarehouseBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long generatedCRN = utils.generateCRN();
//		System.out.println("Generated CRN : " +  generatedCRN);
	}
}
