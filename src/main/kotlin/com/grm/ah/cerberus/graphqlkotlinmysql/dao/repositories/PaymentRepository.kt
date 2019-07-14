package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository: JpaRepository<Payment,String> {
    fun getPaymentByPaymentNumber(paymentNum: String): List<Payment>
    fun getPaymentByClaimId(claimId: String): List<Payment>
}