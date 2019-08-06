package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.ClaimDto
import com.grm.ah.cerberus.graphqlkotlinmysql.exception.ClaimNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class ClaimRepositoryImpl {
    @Autowired
    lateinit var repository: ClaimRepository

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    fun getAllClaims(): List<Claim> {
        return repository.findAll()
    }

    fun getClaimById(id: String): Claim? {
        return repository.findClaimByClaimId(claimId = id) ?: throw ClaimNotFoundException(id)
    }


    fun addClaim(claimDto: ClaimDto): Claim {
        val newClaim = mapDtoToClaim(claimDto = claimDto)
        return repository.save(newClaim)
    }

    fun removeClaim(claimId: String): Claim {
        return repository.deleteClaimByClaimId(claimId = claimId)
    }

    fun mapDtoToClaim(claimDto: ClaimDto): Claim {
        return Claim(
            claimId = claimDto.claimId,
            lossDate = LocalDateTime.now().toString()
        )
    }
}