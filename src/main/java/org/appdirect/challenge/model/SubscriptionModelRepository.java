package org.appdirect.challenge.model;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface SubscriptionModelRepository extends PagingAndSortingRepository<SubscriptionModel, Long> {

    SubscriptionModel findByAccountIdentifier(String accountIdentifier);
}
