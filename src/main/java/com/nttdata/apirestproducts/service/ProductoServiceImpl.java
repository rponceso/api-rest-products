package com.nttdata.apirestproducts.service;

import com.nttdata.apirestproducts.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private APIClients apiClients;

    public Mono<Map<String, Object>> reporting(FilterDto filter) {

        Flux<AccountDto> fxAccounts = apiClients.findByCreationDateBetweenAccount(filter);
        Flux<CreditDto> fxCredits = apiClients.findByCreationDateBetweenCredits(filter);
        Flux<CreditCardDto> fxCreditCards = apiClients.findByCreationDateBetweenCreditCards(filter);
        Flux<DebitCardDto> fxDebitCards = apiClients.findByCreationDateBetweenDebitCards(filter);

        return fxAccounts.collectList()
                .flatMap(lstAccounts -> {
                    System.out.println("lstAccounts:" + lstAccounts);
                    return fxCredits.collectList();
                })
                        .flatMap(lstCredits -> fxCreditCards.collectList()
                                .flatMap(lstCreditCards -> fxDebitCards.collectList()
                                        .flatMap(lstDebitCards -> {
                                            Map<String, Object> resultado = new HashMap<>();
                                            resultado.put("Customer", filter);
                                            resultado.put("Accounts: ", "");
                                            resultado.put("Credits: ", lstCredits);
                                            resultado.put("Credit Cards: ", lstCreditCards);
                                            resultado.put("Debit Cards: ", lstDebitCards);
                                            return Mono.just(resultado);
                                        })));

    }
}
