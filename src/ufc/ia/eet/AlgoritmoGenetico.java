package ufc.ia.eet;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class AlgoritmoGenetico {

	private Repositorio repositorio;
	
	public AlgoritmoGenetico(Repositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	public Populacao evoluirPopulacao (Populacao populacao){
		return mutacaoPopulacao(crossOverPopulacao(populacao));
	}
	
	private Populacao crossOverPopulacao(Populacao populacao){
		Populacao crossOverPopulacao = new Populacao(populacao.getAgendamentos().size(), repositorio);
		IntStream.range(0, Main.ELITISMO).forEach(x -> 
			crossOverPopulacao.getAgendamentos().set(x, populacao.getAgendamentos().get(x)));
		
		IntStream.range(Main.ELITISMO, populacao.getAgendamentos().size()).forEach(x -> {
			if(Main.TAXA_CROSSOVER > Math.random()){
				Agendamento agendamento1 = selectTournamentPopulation(populacao).ordenarFitness().getAgendamentos().get(0);
				Agendamento agendamento2 = selectTournamentPopulation(populacao).ordenarFitness().getAgendamentos().get(0);
				
				crossOverPopulacao.getAgendamentos().set(x, crossOverSchedule(agendamento1, agendamento2));
			}else{
				crossOverPopulacao.getAgendamentos().set(x, populacao.getAgendamentos().get(x));
			}
		});
		
		return crossOverPopulacao;
	}
	
	private Agendamento crossOverSchedule(Agendamento agendamento1, Agendamento agendamento2){
		Agendamento crossOverAgendamento = new Agendamento(repositorio).inicializa();
		
		IntStream.range(0, crossOverAgendamento.getUnidades().size()).forEach(x -> {
			if(Math.random() > 0.5){
				crossOverAgendamento.getUnidades().set(x, agendamento1.getUnidades().get(x));
			}else{
				crossOverAgendamento.getUnidades().set(x, agendamento2.getUnidades().get(x));
			}
		});
		
		return crossOverAgendamento;
	}
	
	private Populacao mutacaoPopulacao(Populacao populacao){
		Populacao mutacaoPopulacao = new Populacao(populacao.getAgendamentos().size(), repositorio);
		ArrayList<Agendamento> agendamentos = mutacaoPopulacao.getAgendamentos();
		
		IntStream.range(0, Main.ELITISMO).forEach(x -> 
			agendamentos.set(x, populacao.getAgendamentos().get(x)));
		
		return mutacaoPopulacao;
	}
	
	private Agendamento mutacaoAgendamento (Agendamento mutacaoAgendamento){
		
		Agendamento agendamento = new Agendamento(repositorio).inicializa();
		
		IntStream.range(0, mutacaoAgendamento.getUnidades().size()).forEach(x -> {
			if(Main.TAXA_MUTACAO > Math.random()){
				mutacaoAgendamento.getUnidades().set(x, agendamento.getUnidades().get(x));
			}
		});
		
		return mutacaoAgendamento;
	}
	
	private Populacao selectTournamentPopulation(Populacao population){
		Populacao tournamentPopulation = new Populacao(Main.ITERACOES, repositorio);
		
		IntStream.range(0, Main.ITERACOES).forEach(x -> {
			tournamentPopulation.getAgendamentos().set(x, 
					population.getAgendamentos().get((int)(Math.random() * population.getAgendamentos().size())));
		});
		return tournamentPopulation;
	}
}
