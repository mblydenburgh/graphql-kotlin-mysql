package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClaimRepository: JpaRepository<Claim,String> {
    fun findClaimByClaimId(claimId: String): Claim
    fun deleteClaimByClaimId(claimId: String): Claim
}