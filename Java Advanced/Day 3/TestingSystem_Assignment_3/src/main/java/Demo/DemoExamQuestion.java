package Demo;

import Repository.ExamQuestionRepository;
import Repository.ExamRepository;
import Repository.QuestionRepository;
import entity.Exam;
import entity.Question;
import entity.ExamQuestion;
import java.util.List;
public class DemoExamQuestion {
	public static void main(String[] args) {
		ExamRepository test1 = new ExamRepository();
		for (Exam string : test1.getAllExam()) {
			System.out.println(string);
			System.out.println(string.getListOfExamQuestion());
			System.out.println("________________________________-");
		}
		
		QuestionRepository test2 = new QuestionRepository();
		for (Question string : test2.getAllQuestions()) {
			System.out.println(string);
			List <ExamQuestion> list1 = string.getListOfExamQuestion() ;
			for (ExamQuestion string2 : list1) {
				System.out.println(string2);
			}
			System.out.println("________________________________-");

		}
		
		ExamQuestionRepository test3 = new ExamQuestionRepository();
		for (ExamQuestion string : test3.getAllExamQuestions()) {
			System.out.println(string);
		}
		
	}
}
