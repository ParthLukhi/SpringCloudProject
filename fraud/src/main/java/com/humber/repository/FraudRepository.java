package com.humber.repository;

import com.humber.model.FraudCHeckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCHeckHistory, Integer> {
}
