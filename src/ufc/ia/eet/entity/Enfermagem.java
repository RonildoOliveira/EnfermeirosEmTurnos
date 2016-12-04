package ufc.ia.eet.entity;

import java.util.ArrayList;

public class Enfermagem {
	
	private String nome;
	private ArrayList<Area> courses;

	public Enfermagem(String nome, ArrayList<Area> courses) {
		this.nome = nome;
		this.courses = courses;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Area> getCourses() {
		return courses;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
