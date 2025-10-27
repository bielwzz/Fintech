package br.com.fiap.bean;

public class TipoGanho {
	
	private int id_tp_ganho;
	private String ds_tp_ganho;
	private int id_ganho;
	
	public TipoGanho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoGanho(int id_tp_ganho, String ds_tp_ganho, int id_ganho) {
		super();
		this.id_tp_ganho = id_tp_ganho;
		this.ds_tp_ganho = ds_tp_ganho;
		this.id_ganho = id_ganho;
	}

	public int getId_tp_ganho() {
		return id_tp_ganho;
	}

	public void setId_tp_ganho(int id_tp_ganho) {
		this.id_tp_ganho = id_tp_ganho;
	}

	public String getDs_tp_ganho() {
		return ds_tp_ganho;
	}

	public void setDs_tp_ganho(String ds_tp_ganho) {
		this.ds_tp_ganho = ds_tp_ganho;
	}

	public int getId_ganho() {
		return id_ganho;
	}

	public void setId_ganho(int id_ganho) {
		this.id_ganho = id_ganho;
	}

	
	
}
