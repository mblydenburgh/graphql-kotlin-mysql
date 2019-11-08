//package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories
//
//import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.jpa.repository.Modifying
//import org.springframework.data.jpa.repository.Query
//import org.springframework.stereotype.Repository
//import org.springframework.transaction.annotation.Transactional
//
//@Repository
//interface ClaimRepository: JpaRepository<Claim,String> {
//    fun findClaimByClaimId(claimId: String): Claim?
//    @Modifying
//    @Transactional
//    @Query(value = "DELETE FROM Claim claim WHERE claim.claimId = ?1")
//    fun deleteClaimByClaimId(claimId: String): Int
//}