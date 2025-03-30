package model.dataclass;

public class ClientModel {
	public int id;
	public String nume;
	public String nrTel;
	
	public ClientModel(int id, String nume, String nrTel) {
		this.id = id;
		this.nume = nume;
		this.nrTel = nrTel;
	}
}
