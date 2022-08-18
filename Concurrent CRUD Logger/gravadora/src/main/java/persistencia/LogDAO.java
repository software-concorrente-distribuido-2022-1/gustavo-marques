package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogDAO {

	public static void gravarAcesso(String texto) {
		try {
			File diretorio = new File("Log");
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(diretorio + "/Acesso.txt", true));
			bw.write(texto);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
		}
	}

	public static void gravarOperacao(String texto) {
		try {
			File diretorio = new File("Log");
			if (!diretorio.exists()) {
				diretorio.mkdir();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(diretorio + "/Operacao.txt", true));
			bw.write(texto);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
		}
	}
}
