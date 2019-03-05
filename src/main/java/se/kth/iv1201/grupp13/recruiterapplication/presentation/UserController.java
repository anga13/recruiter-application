package se.kth.iv1201.grupp13.recruiterapplication.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/")
	public String allUsers() {
		return "hi";
		
	}
}
