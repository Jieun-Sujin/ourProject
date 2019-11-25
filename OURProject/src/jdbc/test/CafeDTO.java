package jdbc.test;

import java.io.Serializable;

public class CafeDTO implements Serializable{	
	
	private static final long serialVersionUID=1L;
	private Long id;
	private String name;
	private String addr;
	private String area;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "CafeDTO [id=" + id + ", name=" + name + ", addr=" + addr + ", area=" + area + "]";
	}
	
	

}
