package br.com.alura.jpa.modelo;

public class MediaComData {
	
	private Double valor;
	private Integer day;
	private Integer month;
	
	
	public MediaComData(Double valor, Integer day, Integer month) {
		this.valor = valor;
		this.day = day;
		this.month = month;
	}
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
}
