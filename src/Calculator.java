import java.util.Scanner;

public class Calculator {

	public void calc (String instruction){
		
	}
	
	public static void main(String[] args) {
		help();
		Scanner console = new Scanner(System.in);
		String input = console.next();
		while (!(input.equals("exit"))){


		}


	}

	public String[] split(String input){
		if(input.length()==0) {
			//if there ar'nt any command return null
			return null;
		}
		while ((input.charAt(0))){

		}


	}

	public static void help(){
		String help =
				"size <set>" + "\n" +
				"contains <set> <set>" + "\n" +
				"member <set> <element>" + "\n" +
				"deepexistance <set> <element>" + "\n" +
				"equals <element> <element>" + "\n" +
				"insert <set> <element>" + "\n" +
				"remove <set> <element>" + "\n" +
				"union <set> <set>" + "\n" +
				"intersect <set> <set>" + "\n" +
				"difference <set> <set>" + "\n" +
				"power <set>" + "\n" +
				"transformAdd <element> <numeric>" + "\n" +
				"transformMul <element> <numeric>" + "\n" +
				"help" + "\n"+
				"bonus" + "\n" +
				"exit" + "\n";
		System.out.print(help);

	}

}
