package hobby.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Quiz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		Map quizMap;
		quizMap = quiz.buildQuiz();
		String answer, correctAnswer, question;
		int point=0;
		System.out.println("Start Your Quiz!!!");
		Scanner in = new Scanner(System.in);
		System.out.println("Rules-'+2 for correct answer -1 for wrong answer'");
		Set set = quizMap.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			question = (String) it.next();
			System.out.println(question);
			answer = in.nextLine();
			correctAnswer = (String) quizMap.get(question);
			point = Quiz.getResult(answer, correctAnswer, point);
		}
		System.out.println("Your final score::"+point);
		in.close();

	}
	Map buildQuiz(){
		Map quizMap = new HashMap();
		quizMap.put("Who is the Prime Minister of India?", "Narendra Modi");
		quizMap.put("Which is the tallest peak of India?", "Kanchenjunga");
		quizMap.put("What is the National Animal Of India?", "Tiger");
		quizMap.put("Which country has the world largest population?", "China");
		quizMap.put("Alaska belongs to which country?", "USA");
		quizMap.put("World largest ocean?", "Pacific Ocean");
		return quizMap;
	}
	
	static int getResult(String answer, String correctAnswer, int point){
		if(answer == ""){
			System.out.println("You chose not to answer");
		}
		if(answer.equalsIgnoreCase(correctAnswer)){
			System.out.println("Your answer is correct");
			point+=2;
		}
		else{
			System.out.println("Your answer is wrong");
			point-=1;
		}
		return point;
	}
}
