package jdbc.our;

import java.io.Serializable;

import lombok.Data;

@Data
public class SeatDTO implements Serializable{	
	
	private static final long serialVersionUID=1L;
	private Long id;
	private int remain_table;
	private int one_table;
	private int two_four_table;
	private int group_table;
	
}
