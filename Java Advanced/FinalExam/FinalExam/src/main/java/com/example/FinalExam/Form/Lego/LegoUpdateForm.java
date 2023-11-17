package com.example.FinalExam.Form.Lego;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.FinalExam.Entity.Lego.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
@NoArgsConstructor
public class LegoUpdateForm {

    private Integer id;

    @NotBlank(message = "Bạn không được để trống tên của sản phẩm !!")
    private String name;

    @NotNull(message = "Bạn không được để trống số mảnh của sản phẩm !!")
    @PositiveOrZero(message = "Bạn không được để giá trị âm cho số mảnh!!")
    private Integer piece;

    @NotNull(message = "Bạn không được để trống giá của sản phẩm !!")
    @PositiveOrZero(message = "Bạn không được để giá trị âm cho giá!!")
    private Integer price;

    private Type type;


    @PastOrPresent(message = "Bạn không thể truyền một ngày trong tương lai vào đây !!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createDate;
}
