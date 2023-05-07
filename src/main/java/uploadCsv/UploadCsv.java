package uploadCsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UploadCsv {

	public static void main(String[] args) {
		SpringApplication.run(UploadCsv.class, args);
	}
}
