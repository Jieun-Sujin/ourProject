package jdbc.our;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuDTO implements Serializable{	
	
	private static final long serialVersionUID=1L;
	private Long id;
	private int price;
}
