package ufc.ia.eet;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Populacao {
	
	private ArrayList<Agendamento> agendamentos;

	public Populacao(int tamanho, Repositorio repositorio) {
		agendamentos = new ArrayList<Agendamento>(tamanho);
		IntStream.range(0, tamanho).forEach(
				x -> agendamentos.add(new Agendamento(repositorio).inicializa())
				);
	}
	
	public Populacao ordenarFitness(){
		agendamentos.sort((agenda1, agenda2) -> {
			int returnValue = 0;
			if(agenda1.getFitness() > agenda2.getFitness()){
				return -1;
			}
			else if(agenda1.getFitness() < agenda2.getFitness()){
				return 1;
			}
			else{
				return returnValue;
			}
		});
		
		return this;
	}
	
	public ArrayList<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	
}
