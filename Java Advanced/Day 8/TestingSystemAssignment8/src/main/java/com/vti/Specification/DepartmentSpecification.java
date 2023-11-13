package com.vti.Specification;

import com.mysql.cj.util.StringUtils;
import com.vti.Entity.Department;
import com.vti.Filler.DepartmentFillerForm;
import jakarta.persistence.criteria.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;


public class DepartmentSpecification {

    public  static Specification<Department> buildWhere(String search, DepartmentFillerForm form){
        Specification<Department> where = null;

        if (!StringUtils.isNullOrEmpty(search)){

            search = search.trim();
            DepartmentCustomSpecification username = new DepartmentCustomSpecification("username", search);

            DepartmentCustomSpecification name = new DepartmentCustomSpecification("name", search);
            where =  Specification.where(name).or(username);
        }



        if (form != null && form.getMaxId() != null){
            DepartmentCustomSpecification max = new DepartmentCustomSpecification("maxId", form.getMaxId());
            if (where == null){
                where = max;
            }
            else {
                where = where.and(max);
            }
        }

        if (form != null && form.getMinId() != null){
            DepartmentCustomSpecification min = new DepartmentCustomSpecification("minId", form.getMinId());
            if (where == null){
                where = min;
            }
            else {
                where = where.and(min);
            }
        }

        if (form != null && form.getMinTotalMember() != null){
            DepartmentCustomSpecification min = new DepartmentCustomSpecification("minTotalMember", form.getMinTotalMember());
            if (where == null){
                where = min;
            }
            else {
                where = where.and(min);
            }
        }

        if (form != null && form.getMaxTotalMember() != null){
            DepartmentCustomSpecification max = new DepartmentCustomSpecification("maxTotalMember", form.getMaxTotalMember());
            if (where == null){
                where = max;
            } else {
                where = where.and(max);
            }
        }
        if (form != null && form.getCreateDate() != null){
            DepartmentCustomSpecification date = new DepartmentCustomSpecification("createDate", form.getCreateDate());
            if (where == null){
                where = date;
            }
            else {
                where = where.and(date);
            }
        }

        if (form != null && form.getMinCreateDate() != null){
            DepartmentCustomSpecification min = new DepartmentCustomSpecification("minCreateDate", form.getMinCreateDate());
            if (where == null){
                where = min;
            }
            else {
                where = where.and(min);
            }
        }

        if (form != null && form.getMaxCreateDate() != null){
            DepartmentCustomSpecification max = new DepartmentCustomSpecification("maxCreateDate", form.getMaxCreateDate() );
            if (where == null){
                where = max;
            }
            else {
                where = where.and(max);
            }
        }

        if (form != null && form.getType() != null){
            DepartmentCustomSpecification type = new DepartmentCustomSpecification("type" , form.getType());
            if (where == null){
                where = type;
            }
            else {
                where = where.and(type);
            }
        }


        if (form != null && form.getMinYear() != null){
            DepartmentCustomSpecification minYear = new DepartmentCustomSpecification("minYear" , form.getMinYear());
            if (where == null){
                where = minYear;
            }
            else {
                where = where.and(minYear);
            }
        }

        if (form != null && form.getMaxYear() != null){
            DepartmentCustomSpecification maxYear = new DepartmentCustomSpecification("maxYear" , form.getMaxYear());
            if (where == null){
                where = maxYear;
            }
            else {
                where = where.and(maxYear);
            }
        }

        if (form != null && form.getMinAccounts() != null){
            DepartmentCustomSpecification minAccounts = new DepartmentCustomSpecification("minAccounts" , form.getMinAccounts());
            if (where == null){
                where = minAccounts;
            }
            else {
                where = where.and(minAccounts);
            }
        }


        return where;
    }


}        @SuppressWarnings("seiral")


@RequiredArgsConstructor
class DepartmentCustomSpecification implements Specification<Department> {
    @NonNull
    private String field;

    @NonNull
    private Object value;


    @Override
    public Predicate toPredicate(
            Root<Department> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {
        if (field.equalsIgnoreCase("name")){
            return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
        }
        if (field.equalsIgnoreCase("minId")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
        }

        if (field.equalsIgnoreCase("maxId")){
            return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
        }

        if (field.equalsIgnoreCase("minTotalMember")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
        }

        if (field.equalsIgnoreCase("maxTotalMember")){
            return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
        }

        if (field.equalsIgnoreCase("createDate")){
            return criteriaBuilder.equal(root.get("createDate").as(java.sql.Date.class), value);
        }

        if (field.equalsIgnoreCase("minCreateDate")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createDate").as(java.sql.Date.class), (Date) value);
        }

        if (field.equalsIgnoreCase("maxCreateDate")){
            return criteriaBuilder.lessThanOrEqualTo(root.get("createDate").as(java.sql.Date.class), (Date) value);
        }

        if (field.equalsIgnoreCase("minYear")){
            return criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.function("YEAR", Integer.class, root.get("createDate") ), (Integer) value );
        }

        if (field.equalsIgnoreCase("maxYear")){
            return criteriaBuilder.lessThanOrEqualTo( criteriaBuilder.function("YEAR", Integer.class, root.get("createDate") ) , (Integer) value);
        }

        if (field.equalsIgnoreCase("type")){
            return criteriaBuilder.equal(root.get("type"),  value );
        }

        if (field.equalsIgnoreCase("username")){
            Join join = root.join("listOfAccounts", JoinType.LEFT);
            return criteriaBuilder.like(join.get("username"), "%" + value + "%");
        }

        return null;
    }
}
