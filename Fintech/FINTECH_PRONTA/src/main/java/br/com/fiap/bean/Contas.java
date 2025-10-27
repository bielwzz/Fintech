package br.com.fiap.bean;
    
  public class Contas {
  
    private int id_conta;
    private String nm_conta;
    private double saldo;    
    private int nr_conta;
    private int id_user;
    private int id_tipo_conta;
    
    
    
    public Contas(int id_conta, String nm_conta, 
    		double saldo, int nr_conta, int id_user, int id_tipo_conta) {
      super();
      this.id_conta = id_conta;
      this.nm_conta = nm_conta;
      this.saldo = saldo;
      this.nr_conta = nr_conta;
      this.id_user = id_user;
      this.id_tipo_conta = id_tipo_conta;
    }


	public Contas() {
		// TODO Auto-generated constructor stub
	}


	public int getId_conta() {
		return id_conta;
	}


	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}


	public String getNm_conta() {
		return nm_conta;
	}


	public void setNm_conta(String nm_conta) {
		this.nm_conta = nm_conta;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public int getNr_conta() {
		return nr_conta;
	}


	public void setNr_conta(int nr_conta) {
		this.nr_conta = nr_conta;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public int getId_tipo_conta() {
		return id_tipo_conta;
	}


	public void setId_tipo_conta(int id_tipo_conta) {
		this.id_tipo_conta = id_tipo_conta;
	}
    
	@Override
    public String toString() {
        return "ContaTeste{" +
                "id_conta=" + id_conta +
                ", nm_conta='" + nm_conta + '\'' +
                ", saldo=" + saldo +
                ", nr_conta=" + nr_conta +
                ", id_user=" + id_user +
                ", id_tipo_conta=" + id_tipo_conta +
                '}';

    
  }
  }
    
