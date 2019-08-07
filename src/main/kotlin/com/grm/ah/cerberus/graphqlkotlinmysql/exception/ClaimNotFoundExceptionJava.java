package com.grm.ah.cerberus.graphqlkotlinmysql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ClaimNotFoundExceptionJava extends RuntimeException implements GraphQLError {
    private String claimId;

    public ClaimNotFoundExceptionJava(String claimId) {
        this.claimId = claimId;
    }

    @Override
    public String getMessage() {
        return "Could not find claim with id: [" + claimId + "]";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("claimId", claimId);
    }
}
