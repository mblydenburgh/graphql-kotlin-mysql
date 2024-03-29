package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.PaymentDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class PaymentRepositoryImpl {
    @Autowired
    lateinit var repository: PaymentRepository

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    fun getAllPayments(): List<Payment> {
        return repository.findAll()
    }

    fun getPaymentByNumber(num: String): List<Payment> {
        return repository.getPaymentByPaymentNumber(paymentNum = num)
    }

    fun getPaymentsByClaimId(claimId: String): List<Payment?> {
        return repository.findByClaimId(claimId)
    }

    fun addNewPayment(paymentDto: PaymentDto): Payment {
        val newPayment = mapDtoToPayment(paymentDto)
        return repository.save(newPayment)
    }

    fun removePayment(paymentNum: String): Int {
        return repository.deleteByPaymentNumber(paymentNum)
    }

    fun mapDtoToPayment(dto: PaymentDto): Payment {
        return Payment(
            paymentNumber = dto.paymentNumber,
            claimId = dto.claimId,
            claimantFullName = dto.claimantFullName
        )
    }
}