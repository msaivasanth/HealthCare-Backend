package com.alacriti.HealthCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alacriti.HealthCare.Entity.Cards;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {
	public Cards findByCardNumber(String cardNumber);
}
