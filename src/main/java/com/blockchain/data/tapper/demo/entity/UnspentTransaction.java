package com.blockchain.data.tapper.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnspentTransaction {

    @JsonAlias({"value", "value_other"})
    long value;

    @JsonAlias({"tx_hash", "tx_hash_other"})
    String tx_hash;

    @JsonAlias({"tx_index", "tx_index_other"})
    long output_idx;


    public UnspentTransaction() {
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public long getOutput_idx() {
        return output_idx;
    }

    public void setOutput_idx(long output_idx) {
        this.output_idx = output_idx;
    }

    @Override
    public String toString() {
        return "UnspentTransaction{" +
                "value=" + value +
                ", tx_hash='" + tx_hash + '\'' +
                ", output_idx=" + output_idx +
                '}';
    }
}
