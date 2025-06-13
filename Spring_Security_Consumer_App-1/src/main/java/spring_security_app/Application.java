package spring_security_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// ✅ Provider API URL
		String apiUrl = "http://localhost:8080/getMsg";

		// Basic Authentication (if enabled on provider)
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("ramkrishna", "1234");  // username, password (same as provider)
		HttpEntity<String> reqEntity = new HttpEntity<>(headers);

		//  Create RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		//  Call provider API
		try {
			ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, reqEntity, String.class);

			// ✅ Print response to console
			System.out.println("Provider Response:");
			System.out.println(response.getBody());
		} catch (Exception e) {
			System.out.println("Failed to call provider: " + e.getMessage());
		}
	}
}
