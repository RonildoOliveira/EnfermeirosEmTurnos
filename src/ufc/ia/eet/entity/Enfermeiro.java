package ufc.ia.eet.entity;

public class Enfermeiro {

	private String id;
	private String nome;
	
	public Enfermeiro(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
