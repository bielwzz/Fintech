package br.com.fiap.bean;

import java.util.Date;

public class Relatorio {
	
	private int id_relatorio;
	private Date dt_relatorio;
	private int despesa_relatorio;
	private int ganho_relatorio;
	private int id_user;
	
	public Relatorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relatorio(int id_relatorio, Date dt_relatorio, int despesa_relatorio, int ganho_relatorio, int id_user) {
		super();
		this.id_relatorio = id_relatorio;
		this.dt_relatorio = dt_relatorio;
		this.despesa_relatorio = despesa_relatorio;
		this.ganho_relatorio = ganho_relatorio;
		this.id_user = id_user;
	}

	public int getId_relatorio() {
		return id_relatorio;
	}

	public void setId_relatorio(int id_relatorio) {
		this.id_relatorio = id_relatorio;
	}

	public Date getDt_relatorio() {
		return dt_relatorio;
	}

	public void setDt_relatorio(Date dt_relatorio) {
		this.dt_relatorio = dt_relatorio;
	}

	public int getDespesa_relatorio() {
		return despesa_relatorio;
	}

	public void setDespesa_relatorio(int despesa_relatorio) {
		this.despesa_relatorio = despesa_relatorio;
	}

	public int getGanho_relatorio() {
		return ganho_relatorio;
	}

	public void setGanho_relatorio(int ganho_relatorio) {
		this.ganho_relatorio = ganho_relatorio;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	
	
}
