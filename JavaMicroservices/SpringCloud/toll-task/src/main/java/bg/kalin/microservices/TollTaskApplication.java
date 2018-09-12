package bg.kalin.microservices;

import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TollTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(TollTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask generateTollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {
		@Override
		public void run(String... params) throws Exception {
			if(!Objects.isNull(params)) {
				final String stationId = params[1];
				final String licensePlate = params[2];
				final String timestamp = params[3];
				System.out.printf("Station ID: %s, license plate: %s, timestamp: %s", stationId, licensePlate, timestamp);
			}
		}
		
	}
}
