package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	private String ruta;

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public void lee_lineas() {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
