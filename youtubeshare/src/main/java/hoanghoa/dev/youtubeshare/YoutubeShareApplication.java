package hoanghoa.dev.youtubeshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class YoutubeShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeShareApplication.class, args);
	}

}
