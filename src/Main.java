import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
private static ArrayList<Integer> torre1;
private static ArrayList<Integer> torre2;
private static ArrayList<Integer> torre3;
private static BufferedReader br;

public Main() {
	torre1 = new ArrayList<Integer>();
	torre2 = new ArrayList<Integer>();
	torre3 = new ArrayList<Integer>();
	br = new BufferedReader(new InputStreamReader(System.in));
}

public static void main(String[] args) throws NumberFormatException, IOException {
	Main m = new Main();
	int disco=0;
	int n = Integer.parseInt(br.readLine());
	while(n>0) {
		disco=Integer.parseInt(br.readLine());
		addToTorre1(disco);
		Collections.reverse(torre1);
		Hanoi(disco,torre1,torre3,torre2);
		System.out.println();
		n--;
	}
	
	}

public static void Hanoi(int n, ArrayList<Integer> origen,  ArrayList<Integer> destino, ArrayList<Integer> auxiliar){
	if(n<1) {
		System.out.println(origen.size()+" "+destino.size()+" "+auxiliar.size());
	}
	if(n==1) {
		System.out.println(origen.size()+" "+destino.size()+" "+auxiliar.size());
		moverDisco(origen,destino);
		System.out.println(origen.size()+" "+destino.size()+" "+auxiliar.size());
	}else{
	     Hanoi(n-1, origen, auxiliar, destino);
	     moverDisco(origen,destino);
	     Hanoi(n-1, auxiliar, destino, origen);
	  
	   	  }
	 }


public static void moverDisco(ArrayList<Integer> origen, ArrayList<Integer> destino) {
	destino.add(origen.get(origen.size()-1));
	origen.remove(origen.size()-1);
}

public static void addToTorre1(int size) {
	for(int i=0;i<size;i++) {
		torre1.add(i);
	}
}

}