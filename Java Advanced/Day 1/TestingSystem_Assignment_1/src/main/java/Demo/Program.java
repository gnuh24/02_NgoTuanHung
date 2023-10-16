package Demo;


import java.util.Date;

import Repository.AccountRepository;
import Repository.AnswerRepository;
import Repository.CategoryQuestionRepository;
import Repository.DepartmentRepository;
import Repository.GroupRepository;
import java.util.List;
import entity.*;

public class Program {
	public static void main(String[] argv) {

		 AnswerRepository answerRepository = new AnswerRepository();

	        // Test getAllAnswer
	        List<Answer> answers = answerRepository.getAllAnswer();
	        System.out.println("All Answers: " + answers);

	        // Test getAnswerByID
	        short answerIdToRetrieve = 1; // Chọn một ID tồn tại trong database để kiểm thử
	        Answer retrievedAnswer = answerRepository.getAnswerByID(answerIdToRetrieve);
	        System.out.println("Retrieved Answer by ID: " + retrievedAnswer);

	        // Test createAnswer
	        Answer newAnswer = new Answer();
	        newAnswer.setContent("This is a new answer.");
	        answerRepository.createAnswer(newAnswer);

	        // Test updateAnswer by ID
	        short answerIdToUpdate = 2; // Chọn một ID tồn tại trong database để kiểm thử
	        String updatedContent = "Updated content.";
	        answerRepository.updateAnswer(answerIdToUpdate, updatedContent);

	        // Test updateAnswer with Answer object
	        Answer answerToUpdate = new Answer();
	        answerToUpdate.setAnswers( (short) 3); // Chọn một ID tồn tại trong database để kiểm thử
	        answerToUpdate.setContent("Updated content with object.");
	        answerRepository.updateAnswer(answerToUpdate);

	        // Test deleteAnswer
	        short answerIdToDelete = 4; // Chọn một ID tồn tại trong database để kiểm thử
	        answerRepository.deleteAnswer(answerIdToDelete);

	        // Test isAnswerExistsByID
	        short nonExistentAnswerId = 100; // Chọn một ID không tồn tại trong database để kiểm thử
	        boolean isExist = answerRepository.isAnswerExistsByID(nonExistentAnswerId);
	        System.out.println("Answer with ID " + nonExistentAnswerId + " exists: " + isExist);
	}
}
