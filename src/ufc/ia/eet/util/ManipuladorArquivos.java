package ufc.ia.eet.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ManipuladorArquivos {

	public void escreverResultado(String tables){

		PrintWriter writer = null;

		try {
			writer = new PrintWriter("results/resultado.html", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println("<!DOCTYPE html> <html> <head> "
				+ "<style> table, th, td {border: 1px solid black; "
				+ "border-collapse: collapse;} </style>"
				+ "</head> <body> <table> <tr>"
				+ "<th>UNIDADE</th>"
				+ "<th>DEPART.</th>"
				+ "<th>C.AREA</th>"
				+ "<th>SALAO</th>"
				+ "<th>ENFERM</th>"
				+ "<th>TURNO</th>"
				+ "</tr>");

		writer.println(tables);

		writer.println("<table>");

		writer.close();
	}
}
