package com.nttdata.apirestproducts.service;

import com.nttdata.apirestproducts.dto.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ProductoService {

/*    Flux<AccountDto> findByCreationDateBetweenAccount(FilterDto filter);

    Flux<CreditDto> findByCreationDateBetweenCredits(FilterDto filter);

    Flux<CreditCardDto> findByCreationDateBetweenCreditCards(FilterDto filter);

    Flux<DebitCardDto> findByCreationDateBetweenDebitCards(FilterDto filter);*/

    Mono<Map<String, Object>> reporting(FilterDto filter);
}
