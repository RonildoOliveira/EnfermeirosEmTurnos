package ufc.ia.eet.entity;

import java.util.ArrayList;

public class Area {

	private String nome;
	private ArrayList<Enfermeiro> enfermeiros;
	private int quantMaximaPacientes;
	
	public Area(String nome, int quantMaximaPacientes, ArrayList<Enfermeiro>enfermeiros) {
		this.nome = nome;
		this.quantMaximaPacientes = quantMaximaPacientes;
		this.enfermeiros = enfermeiros;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public int getQuantMaximaPacientes() {
		return quantMaximaPacientes;
	}
}
