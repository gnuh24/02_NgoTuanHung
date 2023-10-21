package Demo;

import entity.Account;
import entity.Group;
import java.util.List;

import Repository.AccountRepository;
import Repository.GroupRepository;

public class DemoGroup {

	public static void main(String[] args) {
//		GroupRepository test1 = new GroupRepository();
//		List <Group> listOfGroup = test1.getAllGroup();
//		for (Group group : listOfGroup) {
//			System.out.println(group);
//			System.out.println(group.getCreator().getUsername());
//			System.out.println("_________________________________");
//		}
		
		AccountRepository test2 = new AccountRepository();
		List <Account> listOfAccount = test2.getAllAccount();
		for (Account account : listOfAccount) {
			System.out.println(account.getUsername());
			for (Group group : account.getListOfGroup()) {
				System.out.println(group);
			}
			System.out.println("_________________________________");
		}

	}

}
