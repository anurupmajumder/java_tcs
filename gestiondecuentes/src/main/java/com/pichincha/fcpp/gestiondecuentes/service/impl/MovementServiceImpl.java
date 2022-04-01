package com.pichincha.fcpp.gestiondecuentes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.fcpp.gestiondecuentes.entity.AccountEntity;
import com.pichincha.fcpp.gestiondecuentes.entity.MovementsEntity;
import com.pichincha.fcpp.gestiondecuentes.repository.AccountRepository;
import com.pichincha.fcpp.gestiondecuentes.repository.MovementRepository;
import com.pichincha.fcpp.gestiondecuentes.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public MovementsEntity createMovement(MovementsEntity movementsEntity) throws Exception {

		AccountEntity source = accountRepository.findById(movementsEntity.getSourceAccountId()).orElse(null);

		AccountEntity dest = accountRepository.findById(movementsEntity.getDestinationAccountId()).orElse(null);

		
		movementsEntity.setSourceAccountDetalles(source);
		
		movementsEntity.setDestinationAccountDetalles(dest);
		
		if(source == null || dest == null) {
			throw new Exception("Source or Destination Account Not Found");
		}
		
		MovementsEntity movementsEntityAfter = movementRepository.save(movementsEntity);

		return movementsEntityAfter;
	}

	@Override
	public String deleteMovement(Integer movementId) throws Exception {

		MovementsEntity movementsEntityDb = movementRepository.findById(movementId).orElse(null);

		if (movementsEntityDb == null) {
			throw new Exception("Movement Not Found");
		}

		movementRepository.delete(movementsEntityDb);

		return "Deleteion Done";
	}

}
