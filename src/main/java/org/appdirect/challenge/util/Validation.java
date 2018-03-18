package org.appdirect.challenge.util;


public interface Validation {
    void validateUniqueUuid(String uuid);

    void validateExistenceOfAccountId(String accountId);
}
