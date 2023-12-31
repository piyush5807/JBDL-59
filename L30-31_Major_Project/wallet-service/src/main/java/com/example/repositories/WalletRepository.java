package com.example.repositories;

import com.example.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet findByMobile(String mobile);


    @Modifying
    @Query("update Wallet w set w.balance = w.balance + :amount where w.mobile = :mobile")
    void updateWallet(String mobile, Double amount);
}
