package Demo;

import Repository.AccountRepository;
import Repository.CategoryQuestionRepository;
import Repository.ExamRepository;
import entity.Account;
import entity.Exam;
import entity.CategoryQuestion;

public class DemoExam {

	public static void main(String[] args) {
		ExamRepository test1 = new ExamRepository();
		for (Exam e : test1.getAllExam()) {
			System.out.println(e);
			System.out.println(e.getCategoryQuestion().getCategoryName());
			System.out.println(e.getCreator().getUsername());;
		}
		
		AccountRepository test2 = new AccountRepository();
		for (Account account : test2.getAllAccount()) {
			System.out.println(account.getUsername() );
			for (Exam e : account.getListOfExam()) {
				System.out.println(e);
			}
	    System.out.println("_______________________________________________");

		}
		
		CategoryQuestionRepository test3 = new CategoryQuestionRepository();
		for (CategoryQuestion categoryQuestion : test3.getAllCategoryQuestion()) {
		    System.out.println(categoryQuestion.getCategoryName());
		    for (Exam e : categoryQuestion.getListOfExam()) {
		        System.out.println(e);
		    }
		    System.out.println("_______________________________________________");
		}

		
		
		
	}

}
