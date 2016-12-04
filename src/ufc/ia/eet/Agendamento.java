package ufc.ia.eet;

import java.util.ArrayList;

import ufc.ia.eet.entity.Unidade;
import ufc.ia.eet.entity.Enfermagem;


public class Agendamento {

	private ArrayList<Unidade> unidades;
	private Repositorio repositorio;
	
	private int quantUnidades = 0;
	
	private int quantColisoes = 0;	
	private boolean mudancaFitness = true;
	private double fitness = -1;
	
	public Agendamento(Repositorio data) {
		this.repositorio = data;
		unidades = new ArrayList<Unidade>(data.getNumeroUnidades());
	}
	
	public Agendamento inicializa(){
		new ArrayList<Enfermagem>(repositorio.getDepartmentos()).forEach(enferm -> {
			enferm.getCourses().forEach(area -> {
				Unidade unidade = new Unidade(quantUnidades++, enferm, area);
				unidade.setTurno(repositorio.getTurnos().get((int)(repositorio.getTurnos().size() * Math.random())));
				unidade.setRoom(repositorio.getSaloes().get((int) (repositorio.getSaloes().size() * Math.random())));
				unidade.setInstructor(area.getEnfermeiros().get((int) (area.getEnfermeiros().size() * Math.random())));
				unidades.add(unidade);
			});
		});
		
		return this;
	}
	
	public double calculaFitness(){
		quantColisoes = 0;
		
		unidades.forEach(x -> {
			if(x.getSalao().getRoomCapacity() < x.getArea().getQuantMaximaPacientes())
				quantColisoes ++;
			
			unidades.stream().filter(y -> unidades.indexOf(y) >= unidades.indexOf(x)).forEach(y -> {
				if(x.getTurno() == y.getTurno() && x.getId() != y.getId()){
					if(x.getSalao() == y.getSalao()){
						quantColisoes++;
					}
					if(x.getEnfermeiro() == y.getEnfermeiro()){
						quantColisoes ++;
					}
				}
			});
		});
		
		return 1 / (double) (quantColisoes + 1);
	}
	
	@Override
	public String toString() {
		String returnValue = new String();
		for (int i = 0; i < unidades.size()-1; i++) {
			returnValue += unidades.get(i) + " - ";
		}
		return returnValue;
	}
	
	public ArrayList<Unidade> getUnidades() {
		mudancaFitness = true;
		return unidades;
	}

	public double getFitness() {
		if(mudancaFitness){
			fitness = calculaFitness();
			mudancaFitness = false;
		}
		return fitness;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public int getQuantColisoes() {
		return quantColisoes;
	}
	
}
