package jdbc.our;

import java.io.Serializable;

import lombok.Data;

@Data
public class BeverageDTO implements Serializable{	
	
	private static final long serialVersionUID=1L;
	private Long id;
	private String name;
	
}
