package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dto.ClaimDto
import com.grm.ah.cerberus.graphqlkotlinmysql.exception.QueryExceptionJava
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
        logger.info("Returning all claims")
        return repository.findAll()
    }

    fun getClaimById(id: String): Claim? {
        logger.info("Searching for claim with claimId: $id")
        return repository.findClaimByClaimId(claimId = id)
    }


    fun addClaim(claimDto: ClaimDto): Claim {
        val newClaim = mapDtoToClaim(claimDto = claimDto)
        logger.info("Saving new claim: $newClaim")
        return repository.save(newClaim)
    }

    fun removeClaim(claimId: String): Claim {
        logger.info("Removing claim by claimId: $claimId")
        return repository.deleteClaimByClaimId(claimId = claimId)
    }

    fun updateClaim(claimId: String, lossDate: String): Claim {
        logger.info("Updating claim by claimId")
        val oldClaimId = repository.findClaimByClaimId(claimId)?.id

        if(oldClaimId != null) {
            logger.info("Found claim")
            val claimToUpdate = repository.findById(oldClaimId)
            if(claimToUpdate.isPresent){
                claimToUpdate.get().lossDate = lossDate
                logger.info("Saving new claim: $claimToUpdate")
                repository.save(claimToUpdate.get())
                return claimToUpdate.get()
            } else throw QueryExceptionJava("Error finding claim with id: $oldClaimId")
        } else throw QueryExceptionJava("Error finding claim with claimId: $claimId")
    }

    fun mapDtoToClaim(claimDto: ClaimDto): Claim {
        logger.info("Building claim from dto: $claimDto")
        return Claim(
            claimId = claimDto.claimId,
            lossDate = LocalDateTime.now().toString()
        )
    }
}