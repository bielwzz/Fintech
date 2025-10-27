package br.com.fiap.bean;

public class TipoDespesa {
	
	private int id_tp_despesa;
	private String ds_tp_despesa;
	private int id_despesa;

	public TipoDespesa() {
		// TODO Auto-generated constructor stub
	}

	public TipoDespesa(int id_tp_despesa, String ds_tp_despesa, int id_despesa) {
		super();
		this.id_tp_despesa = id_tp_despesa;
		this.ds_tp_despesa = ds_tp_despesa;
		this.id_despesa = id_despesa;
	}

	public int getId_tp_despesa() {
		return id_tp_despesa;
	}

	public void setId_tp_despesa(int id_tp_despesa) {
		this.id_tp_despesa = id_tp_despesa;
	}

	public String getDs_tp_despesa() {
		return ds_tp_despesa;
	}

	public void setDs_tp_despesa(String ds_tp_despesa) {
		this.ds_tp_despesa = ds_tp_despesa;
	}

	public int getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(int id_despesa) {
		this.id_despesa = id_despesa;
	}

	
	
}
