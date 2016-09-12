package ie.walsh.springapps.wiring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
	
	@Bean
	public CompactDisc compactDisc() {
		return new XXBandCD();
	}
  
	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc) {
		return new CDPlayer(compactDisc);
	}
}
