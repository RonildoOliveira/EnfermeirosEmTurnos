package ufc.ia.eet.entity;

public class Turno {

	private String id;
	private String turno;
	
	public Turno(String id, String time) {
		this.id = id;
		this.turno = id;
	}

	public String getId() {
		return id;
	}

	public String getTurno() {
		return turno;
	}
	
}
