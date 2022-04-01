package com.pichincha.fcpp.gestiondecuentes.dto;



import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;
import com.pichincha.fcpp.gestiondecuentes.entity.MovementsEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
	
	private Integer _accountId;

	private String _accountNumber;

	private String _accountType;

	private String _accountBank;
	
	private List<MovementsEntity> _allMovementsWhereSource;

	private List<MovementsEntity> _allMovementsWhereDestination;
	
}
