package com.example.FinalExam.Form.Lego;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.FinalExam.Entity.Lego.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class LegoCreateForm {

    @NotBlank(message = "Bạn không được để trống tên của sản phẩm !!")
    private String name;

    @NotNull(message = "Bạn không được để trống số mảnh của sản phẩm !!")
    @PositiveOrZero(message = "Bạn không được để giá trị âm cho số mảnh!!")
    private Integer piece;

    @NotNull(message = "Bạn không được để trống giá của sản phẩm !!")
    @PositiveOrZero(message = "Bạn không được để giá trị âm cho giá!!")
    private Integer price;


    private Type type;
}
