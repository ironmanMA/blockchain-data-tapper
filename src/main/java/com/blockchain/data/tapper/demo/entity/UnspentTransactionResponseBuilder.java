package com.blockchain.data.tapper.demo.entity;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public final class UnspentTransactionResponseBuilder {
    private HttpStatus status;

    private String message;

    private List<UnspentTransaction> output;

    private UnspentTransactionResponseBuilder() {
        output = new ArrayList<>();
    }

    public static UnspentTransactionResponseBuilder anUnspentTransactionResponse() {
        return new UnspentTransactionResponseBuilder();
    }

    public UnspentTransactionResponseBuilder withOutput(List<UnspentTransaction> output) {
        this.output = output;
        return this;
    }

    public UnspentTransactionResponseBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public UnspentTransactionResponseBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public UnspentTransactionResponseBuilder addOutput(UnspentTransaction unitTx) {
        this.output.add(unitTx);
        return this;
    }

    public UnspentTransactionResponse build() {
        UnspentTransactionResponse unspentTransactionResponse = new UnspentTransactionResponse();
        unspentTransactionResponse.setOutput(output);
        unspentTransactionResponse.setStatus(status);
        unspentTransactionResponse.setMessage(message);
        return unspentTransactionResponse;
    }
}
