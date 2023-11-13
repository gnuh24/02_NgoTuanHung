package com.vti.Specification;

import com.mysql.cj.util.StringUtils;
import com.vti.Entity.Account;
import com.vti.Filler.AccountFillerForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class AccountSpecification {
    public  static Specification<Account> buildWhere(String search, AccountFillerForm form) throws Exception{
        Specification<Account> where = null;

        if (!StringUtils.isNullOrEmpty(search)){
            if (isValidSearch(search)){
                search = search.trim();

                AccountCustomSpecification username = new AccountCustomSpecification("username", search);
                where =  Specification.where(username);
            }
            else {
                throw new Exception("Bạn không được search dài quá 50 ký tự và chứa ký tự đặc biệt");
            }

        }

        if (!StringUtils.isNullOrEmpty(search)){
            search = search.trim();

            AccountCustomSpecification username = new AccountCustomSpecification("username", search);
            AccountCustomSpecification departmentName = new AccountCustomSpecification("departmentName", search);

            where =  Specification.where(username).or(departmentName);
        }

        if (form != null && form.getDepartmentType() != null){
            AccountCustomSpecification departmentType = new AccountCustomSpecification("departmentType", form.getDepartmentType());

            where =  Specification.where(departmentType);
        }



        return  where;
    }
    private static boolean isValidSearch(String search) {
        // Validate the length and characters of the search string
        // For example, check if it's less than 50 characters and contains no special characters
        return search.length() <= 50 && search.matches("^[a-zA-Z0-9]+$");
    }
}

@RequiredArgsConstructor
class AccountCustomSpecification implements Specification<Account> {
    @NonNull
    private String field;

    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(
            Root<Account> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("username")){
            return criteriaBuilder.like(root.get("username"), "%" + value + "%");
        }

        if (field.equalsIgnoreCase("departmentName")){
            return criteriaBuilder.like(root.get("department").get("name"), "%" + value + "%");
        }

        if (field.equalsIgnoreCase("departmentType")){
            return criteriaBuilder.equal(root.get("department").get("type"), value);
        }

        return null;
    }


}
