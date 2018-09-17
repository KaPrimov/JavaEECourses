package bg.kalin.microservices;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class TollSecureServiceApplication {
	
	@Autowired
	private ResourceServerProperties sso;
	
	public static void main(String[] args) {
		SpringApplication.run(TollSecureServiceApplication.class, args);
	}
	
	@RequestMapping("/tolldata")
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	public List<TollUsage> getTollData() {
		TollUsage instance1 = new TollUsage("100", "station120", "CA1241HA", "2016-09-30T04:12:12");
		TollUsage instance2 = new TollUsage("101", "station10", "CA13121HA", "2016-09-30T04:12:12");
		TollUsage instance3 = new TollUsage("102", "station64", "PB5411HA", "2016-09-30T04:12:12");

		List<TollUsage> tolls = Arrays.asList(instance1, instance2, instance3);
		
		return tolls;
	}
	
	@Bean
	public ResourceServerTokenServices resourceServerTokenServices() {
		return new CustomUserInfoTokenService(sso.getUserInfoUri(), sso.getClientId());
	}
	
	public class TollUsage {
		public String id;
		public String stationId;
		public String licensePlate;
		public String timestamp;
		
		public TollUsage() {}

		public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
			this.id = id;
			this.stationId = stationId;
			this.licensePlate = licensePlate;
			this.timestamp = timestamp;
		}
	}
}
