package com.nttdata.apirestproducts.service;

import com.nttdata.apirestproducts.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class APIClientsImpl implements APIClients {

    @Autowired
    private WebClient webClient;

    @Value("${config.base.enpoint.accounts}")
    private String urlAccounts;

    @Value("${config.base.enpoint.credits}")
    private String urlCredits;

    @Value("${config.base.enpoint.creditcards}")
    private String urlCreditCards;

    @Value("${config.base.enpoint.debitcards}")
    private String urlDebitCards;


    @Override
    public Flux<AccountDto> findByCreationDateBetweenAccount(FilterDto filter) {
        return webClient.post()
                .uri(urlAccounts + "/reporting")
                .body(Mono.just(filter), FilterDto.class)
                .retrieve()
                .bodyToFlux(AccountDto.class);
    }

    @Override
    public Flux<CreditDto> findByCreationDateBetweenCredits(FilterDto filter) {
        return webClient.post()
                .uri(urlCredits + "/reporting")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(filter), FilterDto.class)
                .retrieve()
                .bodyToFlux(CreditDto.class);
    }

    @Override
    public Flux<CreditCardDto> findByCreationDateBetweenCreditCards(FilterDto filter) {
        return webClient.post()
                .uri(urlCreditCards + "/reporting")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(filter), FilterDto.class)
                .retrieve()
                .bodyToFlux(CreditCardDto.class);
    }

    @Override
    public Flux<DebitCardDto> findByCreationDateBetweenDebitCards(FilterDto filter) {
        return webClient.post()
                .uri(urlDebitCards + "/reporting")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(filter), FilterDto.class)
                .retrieve()
                .bodyToFlux(DebitCardDto.class);
    }
}
