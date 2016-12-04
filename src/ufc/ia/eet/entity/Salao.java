package ufc.ia.eet.entity;

public class Salao {

	private String id;
	private int capacidade;
	
	public Salao(String id, int capacidade) {
		this.id = id;
		this.capacidade = capacidade;
	}

	public String getId() {
		return id;
	}

	public int getRoomCapacity() {
		return capacidade;
	}
	
	@Override
	public String toString() {
		return "Salao: " + id;
	}
}
