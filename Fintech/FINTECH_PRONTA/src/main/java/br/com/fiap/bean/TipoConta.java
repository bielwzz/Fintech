package br.com.fiap.bean;

public class TipoConta {
	
	private int id_tipo_conta;
	private String ds_tipo_conta;
	private int id_conta;
	
	public TipoConta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoConta(int id_tipo_conta, String ds_tipo_conta, int id_conta) {
		super();
		this.id_tipo_conta = id_tipo_conta;
		this.ds_tipo_conta = ds_tipo_conta;
		this.id_conta = id_conta;
	}

	public int getId_tipo_conta() {
		return id_tipo_conta;
	}

	public void setId_tipo_conta(int id_tipo_conta) {
		this.id_tipo_conta = id_tipo_conta;
	}

	public String getDs_tipo_conta() {
		return ds_tipo_conta;
	}

	public void setDs_tipo_conta(String ds_tipo_conta) {
		this.ds_tipo_conta = ds_tipo_conta;
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

}
