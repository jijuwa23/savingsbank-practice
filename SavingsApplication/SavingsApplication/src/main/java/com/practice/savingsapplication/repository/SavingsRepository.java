package com.practice.savingsapplication.repository;

import com.practice.savingsapplication.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<AccountEntity, Long> {
}
