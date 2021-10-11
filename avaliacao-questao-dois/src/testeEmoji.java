import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class testeEmoji {

	public static void main(String[] args) {
		Scanner texto = new Scanner(System.in);
		String str;
		int happy = 0;
		int sad = 0;
		System.out.println("Digite a frase: ");
		str = texto.nextLine();
		texto.close();
		
		
		Pattern pattern = Pattern.compile(":-)", Pattern.LITERAL);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			happy++;
		}
		
		pattern = Pattern.compile(":-(", Pattern.LITERAL);
		matcher = pattern.matcher(str);
		while(matcher.find()) {
			sad++;
		}
		
		System.out.println(str);
		
		if(happy > sad) {
			System.out.println("Divertido");
		} else if(happy > sad){
			System.out.println("Chateado");
		}else {
			System.out.println("Neutro");
		}
	}
}
