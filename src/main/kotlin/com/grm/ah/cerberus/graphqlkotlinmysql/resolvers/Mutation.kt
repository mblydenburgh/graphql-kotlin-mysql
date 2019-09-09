package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.ClaimRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PaymentRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.ClaimDto
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.PaymentDto
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class Mutation(
    private val claimRepositoryImpl: ClaimRepositoryImpl,
    private val paymentRepositoryImpl: PaymentRepositoryImpl
): GraphQLMutationResolver {
    fun addNewPayment(paymentNum: String, claimId: String, claimantFullName: String): Payment {
        val newPaymentDto = buildPaymentDto(
            paymentNum = paymentNum,
            claimId = claimId,
            claimantFullName = claimantFullName
        )
        return paymentRepositoryImpl.addNewPayment(newPaymentDto)
    }

    fun removePayment(paymentNum: String): Int {
        return paymentRepositoryImpl.removePayment(paymentNum = paymentNum)
    }

    fun newClaim(claimId: String, lossDate: String): Claim {
        val newClaimDto = buildClaimDto(claimId = claimId, lossDate = lossDate)
        return claimRepositoryImpl.addClaim(newClaimDto)
    }

    fun removeClaim(id: String): Int {
        return claimRepositoryImpl.removeClaim(claimId = id)
    }

    fun updateClaim(claimId: String, lossDate: String): Claim {
        return claimRepositoryImpl.updateClaim(claimId = claimId, lossDate = lossDate)
    }

    private fun buildPaymentDto(paymentNum: String, claimId: String, claimantFullName: String): PaymentDto {
        return PaymentDto(
            paymentNumber = paymentNum,
            claimId = claimId,
            claimantFullName = claimantFullName
        )
    }

    private fun buildClaimDto(claimId: String, lossDate: String): ClaimDto {
        return ClaimDto(
            claimId = claimId,
            lossDate = lossDate
        )
    }
}