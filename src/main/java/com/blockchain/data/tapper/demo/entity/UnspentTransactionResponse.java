package com.blockchain.data.tapper.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UnspentTransactionResponse {

    private HttpStatus status;

    private String message;

    @JsonAlias({"unspent_outputs"})
    private List<UnspentTransaction> output;

    public UnspentTransactionResponse() {
    }

    public List<UnspentTransaction> getOutput() {
        return output;
    }

    public void setOutput(List<UnspentTransaction> output) {
        this.output = output;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UnspentTransactionResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", output=" + output +
                '}';
    }
}
