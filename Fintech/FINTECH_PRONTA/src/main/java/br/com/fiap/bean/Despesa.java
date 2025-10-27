package br.com.fiap.bean;

import java.util.Date;

public class Despesa {
	
	private int id_despesa;
	private Date dt_despesa;
	private int vl_despesa;
	private int id_conta;
	private int id_ganho;
	
	public Despesa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Despesa(int id_despesa, Date dt_despesa, int vl_despesa, int id_conta, int id_ganho) {
		super();
		this.id_despesa = id_despesa;
		this.dt_despesa = dt_despesa;
		this.vl_despesa = vl_despesa;
		this.id_conta = id_conta;
		this.id_ganho = id_ganho;
	}
	
	public int getId_despesa() {
		return id_despesa;
	}
	public void setId_despesa(int id_despesa) {
		this.id_despesa = id_despesa;
	}
	public Date getDt_despesa() {
		return dt_despesa;
	}
	public void setDt_despesa(Date dt_despesa) {
		this.dt_despesa = dt_despesa;
	}
	public int getVl_despesa() {
		return vl_despesa;
	}
	public void setVl_despesa(int vl_despesa) {
		this.vl_despesa = vl_despesa;
	}
	public int getId_conta() {
		return id_conta;
	}
	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	public int getId_ganho() {
		return id_ganho;
	}
	public void setId_ganho(int id_ganho) {
		this.id_ganho = id_ganho;
	}
	
	

}
