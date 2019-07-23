package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface PaymentRepository: JpaRepository<Payment,String> {
    fun getPaymentByPaymentNumber(paymentNum: String): List<Payment>
    fun findByClaimId(claimId: String): List<Payment?>
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Payment payment WHERE payment.paymentNumber = ?1")
    fun deleteByPaymentNumber(paymentNumber: String): Int
}