package com.example.FinalExam.Form.Lego;

import com.example.FinalExam.Entity.Lego.Type;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class LegoFillerForm {

    private Type type;

    private Integer minPiece;

    private Integer maxPiece;

    private Integer minPrice;

    private Integer maxPrice;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date minDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date maxDate;




}
