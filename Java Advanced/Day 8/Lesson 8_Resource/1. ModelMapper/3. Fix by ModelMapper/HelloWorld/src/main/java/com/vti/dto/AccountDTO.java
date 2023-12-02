package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor(force = true)
public class AccountDTO {

	@NonNull
	private String username;

	@NonNull
	private String departmentName;
}

