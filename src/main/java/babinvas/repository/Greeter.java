package babinvas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Greeter {
	@Id
	@GeneratedValue
	private Long id;
	private String greeting;
	private String target;

	public Greeter() {
	}

	public Greeter(Long id, String greeting, String target) {
		this.id = id;
		this.greeting = greeting;
		this.target = target;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
