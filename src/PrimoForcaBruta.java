import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimoForcaBruta {
	private static Scanner scanner;
	private static List<Integer> primeList = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println("Digite até qual número deseja listar os primos: ");
		scanner = new Scanner(System.in);
		BigInteger typedNumber = scanner.nextBigInteger();
		
		List<Integer> list = findAllNumbersUpToGivenNumber(typedNumber);
		
		long start = System.currentTimeMillis();
		
		System.out.println("Processando...");
	
		primeList = findPrimes(typedNumber);
		
		
		long elapsed = System.currentTimeMillis() - start;
		
		printPrimes(primeList, elapsed);
	}
	
	private static List<Integer> findPrimes(BigInteger typedNumber){
		
		List<Integer> primeList = new ArrayList<Integer>();
		
		
		for (int i = 1; BigInteger.valueOf(i).compareTo(typedNumber) <= 0; i++){
			if (i == 2){
				primeList.add(i);
			}		
			if ((i % 2) != 0 && i != 1){
				for (int index = i; index>2; index--){
					if ((i % index ) == 0 && index != i){
						break;
					}	
					if(index == 3){
						primeList.add(i);
					}
				}
			}
		}
		return primeList;
	}
	
	private static List<Integer> findAllNumbersUpToGivenNumber(BigInteger limit) {
		List<Integer> allNumbers = new ArrayList<Integer>();
		
		Integer index = 2;
		
		while(BigInteger.valueOf(index).compareTo(limit) <= 0) {
			allNumbers.add(index);
			index++;
		}
		
		return allNumbers;
	}
	
	private static void printPrimes(List<Integer> listOfPrimes, long elapsed) {
		StringBuilder factors = new StringBuilder("Fatores primos encontrados:\n");
		
		int counter = 0;
		
		for(int index = 0; index < listOfPrimes.size(); index++) {
			if(index == listOfPrimes.size() - 1) {
				factors.append(listOfPrimes.get(index));
			}else{
				factors.append(listOfPrimes.get(index) + ", ");
			}
			
			if(counter == 20) {
				factors.append("\n");
				counter = 0;
			}
			
			counter++;
		}
		
		System.out.println(factors);
		System.out.println("\n\n***************** RESULTADO *****************");
		System.out.println("Tempo de processamento: ");
		System.out.println("Hora(s): ");
		System.out.println("Minuto(s): " + (elapsed / 6000));
		System.out.println("Segundo(s): " + (elapsed / 1000));
		System.out.println("Total de primos encontrados: " + listOfPrimes.size());
	}
}

//ALGORITMO EM C

//#include <stdio.h>
//#include <conio.h>
//int main(){	
//	int numeroDigitado, i, x;
//	printf("Digite algum numero: ");
//	scanf("%d", & numeroDigitado);
//	printf("*************** Numeros primos encontrados ***************** \n\n");
//	for (i = 1; i <= numeroDigitado; i++){
//		if (i == 2){
//			printf("%d\n", i);
//		}		
//		if ((i % 2) != 0 && i != 1){
//			for (x = i; x>2; x--){
//				if ((i % x ) == 0 && x != i){
//					break;
//				}	
//				if(x == 3){
//					printf("%d\n", i);
//				}
//			}
//		}
//	}
//	return 0;
//}
