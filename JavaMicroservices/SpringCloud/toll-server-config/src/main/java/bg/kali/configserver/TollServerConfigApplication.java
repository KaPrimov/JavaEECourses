package bg.kali.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TollServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollServerConfigApplication.class, args);
	}
}
