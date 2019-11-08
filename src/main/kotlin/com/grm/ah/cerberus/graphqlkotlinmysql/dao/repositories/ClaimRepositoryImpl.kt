//package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories
//
//import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
//import com.grm.ah.cerberus.graphqlkotlinmysql.dto.ClaimDto
//import com.grm.ah.cerberus.graphqlkotlinmysql.exception.QueryExceptionJava
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Component
//import java.text.SimpleDateFormat
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
//
//@Component
//class ClaimRepositoryImpl {
//    @Autowired
//    lateinit var repository: ClaimRepository
//
//    companion object {
//        val logger: Logger = LoggerFactory.getLogger(this::class.java)
//    }
//
//    fun getAllClaims(): List<Claim> {
//        return repository.findAll()
//    }
//
//    fun getClaimById(id: String): Claim? {
//        return repository.findClaimByClaimId(claimId = id)
//    }
//
//    fun addClaim(claimDto: ClaimDto): Claim {
//        val newClaim = mapDtoToClaim(claimDto = claimDto)
//        return repository.save(newClaim)
//    }
//
//    fun removeClaim(claimId: String): Int {
//        return repository.deleteClaimByClaimId(claimId = claimId)
//    }
//
//    fun mapDtoToClaim(claimDto: ClaimDto): Claim {
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
//        return Claim(
//            claimId = claimDto.claimId,
//            lossDate = claimDto.lossDate
////            lossDate = dateFormat.format(LocalDateTime.now())
//        )
//    }
//
//}