package com.alacriti.HealthCare.DTO;

public class FilterDoctorDTO {
	
	private String state;
	private String spec;
	private String city;
	
	


	public FilterDoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public FilterDoctorDTO(String state, String spec, String city) {
		super();
		this.state = state;
		this.spec = spec;
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getSpec() {
		return spec;
	}




	public void setSpec(String spec) {
		this.spec = spec;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	@Override
	public String toString() {
		return "FilterDoctorDTO [state=" + state + ", spec=" + spec + ", city=" + city + "]";
	}
	

	
	
	
}
