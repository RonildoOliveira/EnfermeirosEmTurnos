package ufc.ia.eet;

import java.util.ArrayList;
import java.util.Arrays;

import ufc.ia.eet.entity.Area;
import ufc.ia.eet.entity.Enfermagem;
import ufc.ia.eet.entity.Enfermeiro;
import ufc.ia.eet.entity.Turno;
import ufc.ia.eet.entity.Salao;

public class Repositorio {
	private ArrayList<Salao> saloes;
	private ArrayList<Enfermeiro> enfermeiros;
	private ArrayList<Area> areas;
	private ArrayList<Enfermagem> departamentos;
	
	private ArrayList<Turno> turnos;
	
	private int numberOfClasses = 0;
	
	int quantTurnos;
	int tempoTurno;
	
	public Repositorio() {
		inicialize();
	}
	
	public Repositorio inicialize(){
		
		Salao salao1 = new Salao("SL1 ", 25);
		Salao salao2 = new Salao("SL2 ", 45);
		Salao salao3 = new Salao("SL3 ", 35);
		saloes = new ArrayList<Salao>(Arrays.asList(salao1, salao2, salao3));
		
		
		Turno turno1  = new Turno("T01 ", "08-16h-Dom");
		Turno turno2  = new Turno("T02 ", "16-24h-Dom");
		Turno turno3  = new Turno("T03 ", "24-08h-Dom");
		
		Turno turno4  = new Turno("T04 ", "08-16h-Seg");
		Turno turno5  = new Turno("T05 ", "16-24h-Seg");
		Turno turno6  = new Turno("T06 ", "24-08h-Seg");
		
		Turno turno7  = new Turno("T07 ", "08-16h-Ter");
		Turno turno8  = new Turno("T08 ", "16-24h-Ter");
		Turno turno9  = new Turno("T09 ", "24-08h-Ter");
		
		Turno turno10 = new Turno("T10 ", "08-16h-Qua");
		Turno turno11 = new Turno("T11 ", "16-24h-Qua");
		Turno turno12 = new Turno("T12 ", "24-08h-Qua");
		
		Turno turno13 = new Turno("T13 ", "08-16h-Qui");
		Turno turno14 = new Turno("T14 ", "16-24h-Qui");
		Turno turno15 = new Turno("T15 ", "24-08h-Qui");
		
		Turno turno16 = new Turno("T16 ", "08-16h-Sex");
		Turno turno17 = new Turno("T17 ", "16-24h-Sex");
		Turno turno18 = new Turno("T18 ", "24-08h-Sex");
		
		Turno turno19 = new Turno("T19 ", "08-16h-Sab");
		Turno turno20 = new Turno("T20 ", "16-24h-Sab");
		Turno turno21 = new Turno("T21 ", "24-08h-Sab");
		
		
		turnos = new ArrayList<Turno>(Arrays.asList(
				turno1,turno2,turno3,turno4,turno5,
				turno6,turno7,turno8,turno9,turno10,
				turno11,turno12,turno13,turno14,turno15,
				turno16,turno17,turno18,turno19,turno20,turno21));
		
		enfermeiros = new ArrayList<Enfermeiro>();
		
		for (int i = 0; i < 100; i++) {
			enfermeiros.add(new Enfermeiro(""+i, "ENF"+i));
		}
		
		
		Area pediatria = new Area("PED ", 35, new ArrayList<Enfermeiro>(enfermeiros));
		Area cardiologia = new Area("CAR ", 30, new ArrayList<Enfermeiro>(enfermeiros));
		Area ginecologia = new Area("GIN ", 40, new ArrayList<Enfermeiro>(enfermeiros));
		Area olftamologia = new Area("OLF ", 20, new ArrayList<Enfermeiro>(enfermeiros));
		Area urologia = new Area("URO ", 15, new ArrayList<Enfermeiro>(enfermeiros));
		Area neurologia = new Area("NEU ", 25, new ArrayList<Enfermeiro>(enfermeiros));
		
		areas = new ArrayList<Area>(Arrays.asList(pediatria,cardiologia,ginecologia,olftamologia,
				urologia,neurologia));
		
		Enfermagem enfermagem1 = new Enfermagem("DEP1 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem2 = new Enfermagem("DEP2 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem3 = new Enfermagem("DEP3 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem4 = new Enfermagem("DEP4 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem5 = new Enfermagem("DEP5 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem6 = new Enfermagem("DEP6 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem7 = new Enfermagem("DEP7 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem8 = new Enfermagem("DEP8 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem9 = new Enfermagem("DEP9 ", new ArrayList<Area>(areas));
		Enfermagem enfermagem0 = new Enfermagem("DEP0 ", new ArrayList<Area>(areas));
		
		departamentos = new ArrayList<Enfermagem>(Arrays.asList(
				enfermagem1,enfermagem2,enfermagem3,enfermagem4,
				enfermagem5,enfermagem6,enfermagem7,enfermagem8,
				enfermagem0, enfermagem9
				));
		
		departamentos.forEach(x -> numberOfClasses += x.getCourses().size());
		return this;
		
		
	}

	public ArrayList<Salao> getSaloes() {
		return saloes;
	}

	public ArrayList<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public ArrayList<Enfermagem> getDepartmentos() {
		return departamentos;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public int getNumeroUnidades() {
		return numberOfClasses;
	}
	
	
}
