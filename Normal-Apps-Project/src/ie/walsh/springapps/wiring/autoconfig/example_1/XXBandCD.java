package ie.walsh.springapps.wiring.autoconfig.example_1;

import org.springframework.stereotype.Component;

@Component
public class XXBandCD implements CompactDisc {

	private String title = "Awesome title";  
	private String artist = "MCx2";
	  
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
