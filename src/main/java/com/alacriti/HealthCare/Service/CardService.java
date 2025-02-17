package com.alacriti.HealthCare.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.HealthCare.DTO.CardsDTO;
import com.alacriti.HealthCare.Entity.Cards;
import com.alacriti.HealthCare.Repository.CardRepository;

@Service
public class CardService {
	private static final Logger logger = LoggerFactory.getLogger(CardService.class);
	@Autowired
	public CardRepository repo;

	public Cards checkCardDetails(CardsDTO details) {
		try {
			logger.info("Checking card details");
			Cards card = repo.findByCardNumber(details.getCardNumber());
			
			if(card != null && 
					
					card.getCardName().equals(details.getCardName()) && 
					card.getCardNumber().equals(details.getCardNumber()) && 
					card.getCvv().equals(details.getCvv()) && 
					card.getExpiryDate().equals(details.getExpiryDate())) {
				
				System.out.println("Details: " + details.toString());
				System.out.println("Card: " + card.toString());
				return card;
			}
			return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public Cards deductMoney(int amount, CardsDTO card) {
		try {
			Cards res = checkCardDetails(card);
			System.out.println("CArd: " + res.getBalance());
			if(res != null && res.getBalance() >= amount) {
				res.setBalance(res.getBalance() - amount);
				return repo.save(res);
			}
			return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
