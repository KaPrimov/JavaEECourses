package bg.kalin.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class TollTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollTaskSinkApplication.class, args);
	}
}
