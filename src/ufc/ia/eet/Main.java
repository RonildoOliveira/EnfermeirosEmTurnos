package ufc.ia.eet;

import java.util.ArrayList;

import ufc.ia.eet.entity.Unidade;
import ufc.ia.eet.util.ManipuladorArquivos;

public class Main {

	public static final int TAMANHO_POPULACAO = 1000;
	public static final double TAXA_MUTACAO = 0.1;
	public static final double TAXA_CROSSOVER = 0.9;
	public static final int ITERACOES = 1000;
	public static final int ELITISMO = 100;
	
	int numeroAgendamentos = 0;
	int numeroUnidades = 1;
	
	public static String htmlTable = "";
	
	
	private Repositorio data;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.data = new Repositorio();
		
		int numeroGeracoes = 0;
		
		AlgoritmoGenetico geneticAlgorithm = new AlgoritmoGenetico(main.data);
		Populacao population = new Populacao(Main.TAMANHO_POPULACAO, main.data).ordenarFitness();

		System.out.println("Processando...");
		
		while(population.getAgendamentos().get(0).getFitness() != 1.0){
			
			++numeroGeracoes;
			
			population = geneticAlgorithm.evoluirPopulacao(population).ordenarFitness();
			main.numeroAgendamentos = 0;
			
			population.getAgendamentos().forEach(schedule -> main.numeroAgendamentos++ );

			main.numeroUnidades = 1;
		}
		
		main.printScheduleAsTable(population.getAgendamentos().get(0), numeroGeracoes);
		
		System.out.println("Concluído!");
	}
	
	private void printScheduleAsTable(Agendamento schedule, int generetion){
		ArrayList<Unidade> classes = schedule.getUnidades();
				
		//cabecalho html
		
		
		classes.forEach(x -> {
			int indiceDept = data.getDepartmentos().indexOf(x.getEnfermagem());
			int indiceArea = data.getAreas().indexOf(x.getArea());
			int indiceSalao = data.getSaloes().indexOf(x.getSalao());
			int indiceEnferm = data.getEnfermeiros().indexOf(x.getEnfermeiro());
			int indiceTurno = data.getTurnos().indexOf(x.getTurno());
			
			
			htmlTable += "<tr>";
			
			htmlTable += "<td>"+numeroUnidades+"</td>";
			htmlTable += "<td>"+data.getDepartmentos().get(indiceDept).getNome()+"</td>";
			
			htmlTable += "<td>"+data.getAreas().get(indiceArea).getNome()+ "</td>";
			
			htmlTable += "<td>"+data.getSaloes().get(indiceSalao).getId() + 
					"(" + x.getSalao().getRoomCapacity()+")</td>";
			
			htmlTable += "<td>"+data.getEnfermeiros().get(indiceEnferm).getNome() + 
					"(" + x.getEnfermeiro().getId() + ")</td>";
			
			htmlTable += "<td>"+data.getTurnos().get(indiceTurno).getTurno()+
					 "("+data.getTurnos().get(indiceTurno).getId() + ")</td>";
			htmlTable += "</tr>";
			
			numeroUnidades ++;
		});
		
		if(schedule.getFitness() == 1){
			htmlTable += "<b>Numero Geracoes: </b>" + (generetion + 1) + "</br>";
			
		}
		
		htmlTable += "<b>Numero de Enfermeiros: </b>" + data.getEnfermeiros().size() + "</br>";
		htmlTable += "<b>Numero de Departamentos: </b>" + data.getDepartmentos().size() + "</br>";
		htmlTable += "<b>Numero de Turnos: </b>" + data.getTurnos().size() + "</br>";
		htmlTable += "<b>Tamanho Populacao: </b>" + TAMANHO_POPULACAO + "</br>";
		htmlTable += "<b>Numero de Iteracoes: </b>" + ITERACOES + "</br>";
		htmlTable += "<b>Taxa de Mutacao: </b>" + TAXA_MUTACAO + "</br>";
		htmlTable += "<b>Taxa de Elitismo: </b>" + ELITISMO / (double) 1000+ "</br>";
		
		htmlTable += "</body> </html>";
		
		
		
		ManipuladorArquivos mArquivos = new ManipuladorArquivos();
		mArquivos.escreverResultado(htmlTable);
	}
	
}
