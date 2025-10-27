package br.com.fiap.bean;

import java.util.Date;

public class Ganhos {
	
	private int id_ganho;
	private Date dt_ganho;
	private int vl_ganho;
	private int id_conta;
	
	public Ganhos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ganhos(int id_ganho, Date dt_ganho, int vl_ganho, int id_conta) {
		super();
		this.id_ganho = id_ganho;
		this.dt_ganho = dt_ganho;
		this.vl_ganho = vl_ganho;
		this.id_conta = id_conta;
	}

	public int getId_ganho() {
		return id_ganho;
	}

	public void setId_ganho(int id_ganho) {
		this.id_ganho = id_ganho;
	}

	public Date getDt_ganho() {
		return dt_ganho;
	}

	public void setDt_ganho(Date dt_ganho) {
		this.dt_ganho = dt_ganho;
	}

	public int getVl_ganho() {
		return vl_ganho;
	}

	public void setVl_ganho(int vl_ganho) {
		this.vl_ganho = vl_ganho;
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	
	

}
