package com.example.FinalExam.Specification.Lego;

import com.example.FinalExam.Entity.Lego.Lego;
import com.example.FinalExam.Form.Lego.LegoFillerForm;
import com.mysql.cj.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class LegoSpecification {
    public static Specification<Lego> buildWhere(String search, LegoFillerForm form){
        Specification <Lego> where = null;

        if (!StringUtils.isEmptyOrWhitespaceOnly(search) ){
            search = search.trim();
            LegoCustomSpecification name =  new LegoCustomSpecification("search", search);
            where = Specification.where(name);
        }

        if (form != null && form.getType() != null){
            LegoCustomSpecification type = new LegoCustomSpecification("type", form.getType());
            if (where == null){
                where = Specification.where(type);
            }
            else where = where.and(type);
        }


        if (form != null && form.getMinPrice()!= null){
            LegoCustomSpecification minPrice = new LegoCustomSpecification("minPrice", form.getMinPrice() );
            if (where == null){
                where = Specification.where(minPrice);
            }
            else where = where.and(minPrice);
        }

        if (form != null && form.getMaxPrice() != null){
            LegoCustomSpecification maxPrice = new LegoCustomSpecification("maxPrice", form.getMaxPrice());
            if (where == null){
                where = Specification.where(maxPrice);
            }
            else where = where.and(maxPrice);
        }

        if (form != null && form.getMinPiece() != null){
            LegoCustomSpecification minPiece = new LegoCustomSpecification("minPiece", form.getMinPiece());
            if (where == null){
                where = Specification.where(minPiece);
            }
            else where = where.and(minPiece);
        }

        if (form != null && form.getMaxPiece() != null){
            LegoCustomSpecification maxPiece = new LegoCustomSpecification("maxPiece", form.getMaxPiece());
            if (where == null){
                where = Specification.where(maxPiece);
            }
            else where = where.and(maxPiece);
        }

        if (form != null && form.getCreateDate() != null){
            LegoCustomSpecification createDate = new LegoCustomSpecification("createDate", form.getCreateDate());
            if (where == null){
                where = Specification.where(createDate);
            }
            else where = where.and(createDate);
        }

        if (form != null && form.getMinDate() != null){
            LegoCustomSpecification minDate = new LegoCustomSpecification("minDate", form.getMinDate());
            if (where == null){
                where = Specification.where(minDate);
            }
            else where = where.and(minDate);
        }

        if (form != null && form.getMaxDate() != null){
            LegoCustomSpecification maxDate = new LegoCustomSpecification("maxDate", form.getMaxDate());
            if (where == null){
                where = Specification.where(maxDate );
            }
            else where = where.and(maxDate );
        }

        return where;
    }
}
