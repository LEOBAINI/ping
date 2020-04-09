package Clases;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainPing {

	public static void main(String[] args) {		
		
		String ip=null;
		int milisegundosTolerancia = 1000;		
		int contador=0;	
		int cantidadPruebas=4;
		int porcentajeSalud=0;
		System.out.println("Argumentos ingresados:"+args.length);
		switch(args.length) {
		case 0:System.out.println("Ingrese argumentos \n"
				+ "puede ser IP ó IP Milisegundos ó IP Milisegundos CantidadTest\n"
				+ "Ejemplo 1: java -jar Pinger.jar 8.8.8.8 Solo para la ip\n"
				+ "Ejemplo 2: java -jar Pinger.jar 8.8.8.8 2000  La ip con 2000 milisegundos de timeout\n"
				+ "Ejemplo 3: java -jar Pinger.jar 8.8.8.8 2000 4 La ip con 2000 milisegundos de timeout ejecutado 4 veces"); System.exit(0);break;
		case 1:ip=args[0];break;
		case 2:ip=args[0];milisegundosTolerancia=Integer.parseInt(args[1]);break;
		case 3:ip=args[0];milisegundosTolerancia=Integer.parseInt(args[1]);cantidadPruebas=Integer.parseInt(args[2]);break;
		}
		
		
		/*if(args.length<=1) {
			milisegundosTolerancia=1000;
		}else {
			milisegundosTolerancia=Integer.parseInt(args[1]);
		}*/
		
		try {
			for(int i=0;i<cantidadPruebas;i++) {
			if(InetAddress.getByName(ip).isReachable(milisegundosTolerancia)) {
				contador++;
			}
			}
			porcentajeSalud=(contador*100)/cantidadPruebas;
			System.out.println("IP testeada:-> "+ip+" con "+milisegundosTolerancia+" milisegundos de tolerancia y "+cantidadPruebas+" cantidad de pruebas");
			System.out.println("Porcentaje de éxito:-> "+porcentajeSalud);
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.exit(porcentajeSalud);
		
				
	}
	
}
