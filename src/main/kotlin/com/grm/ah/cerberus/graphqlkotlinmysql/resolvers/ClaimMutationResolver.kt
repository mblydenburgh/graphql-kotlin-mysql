package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.ClaimRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.ClaimDto
import org.springframework.stereotype.Component

@Component
class ClaimMutationResolver(private val claimRepositoryImpl: ClaimRepositoryImpl) {

    fun newClaim(claimId: String, lossDate: String): Claim {
        val newClaimDto = buildClaimDto(claimId = claimId, lossDate = lossDate)
        return claimRepositoryImpl.addClaim(newClaimDto)
    }

    fun removeClaim(id: String): Claim {
        return claimRepositoryImpl.removeClaim(claimId = id)
    }

    private fun buildClaimDto(claimId: String, lossDate: String): ClaimDto {
        return ClaimDto(
            claimId = claimId,
            lossDate = lossDate
        )
    }
}