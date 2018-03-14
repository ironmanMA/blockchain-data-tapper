# blockchain-data-tapper
blockchain-data-tapper

usage:
to build use 
`mvn clean package`

this we application supports 2 APIs

unspentTransactionInfo
`localhost:8080/rest/address/1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2`



unspentTransactionBatchInfo
`localhost:8080/rest/batch/address/1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2,1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr,1A8JiWcwvpY7tAopUkSnGuEYHmzGYfZPiq,1231234234`


also has a healthcheck ep
`localhost:8080/rest/health`
