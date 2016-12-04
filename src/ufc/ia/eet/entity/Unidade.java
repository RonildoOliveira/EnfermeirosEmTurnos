package ufc.ia.eet.entity;

public class Unidade {

	private int id;
	
	private Enfermagem enfermagem;
	private Area area;
	private Enfermeiro enfermeiro;
	private Turno turno;
	
	private Salao salao;
	
	public Unidade(int id, Enfermagem enfermagem, Area area) {
		this.id = id;
		this.enfermagem = enfermagem;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enfermagem getEnfermagem() {
		return enfermagem;
	}

	public void setEnfermagem(Enfermagem enfermagem) {
		this.enfermagem = enfermagem;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Enfermeiro getEnfermeiro() {
		return enfermeiro;
	}

	public void setInstructor(Enfermeiro instructor) {
		this.enfermeiro = instructor;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Salao getSalao() {
		return salao;
	}

	public void setRoom(Salao salao) {
		this.salao = salao;
	}
	
	@Override
	public String toString() {
		return enfermagem.getNome() + area.getNome() + salao.getId() +
				enfermeiro.getId() + turno.getId();
	}
}
