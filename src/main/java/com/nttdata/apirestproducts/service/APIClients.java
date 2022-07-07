package com.nttdata.apirestproducts.service;


import com.nttdata.apirestproducts.dto.*;
import reactor.core.publisher.Flux;

public interface APIClients {
    Flux<AccountDto> findByCreationDateBetweenAccount(FilterDto filter);

    Flux<CreditDto> findByCreationDateBetweenCredits(FilterDto filter);

    Flux<CreditCardDto> findByCreationDateBetweenCreditCards(FilterDto filter);

    Flux<DebitCardDto> findByCreationDateBetweenDebitCards(FilterDto filter);

}
