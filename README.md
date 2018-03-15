# blockchain-data-tapper
blockchain-data-tapper

usage:
to build use 
`mvn clean package`

to run use
`java -jar target/demo-0.0.1-SNAPSHOT.jar`

this we application supports 2 APIs (find post man collection `BlockChain.postman_collection.json`)

unspentTransactionInfo :
`localhost:8080/rest/address/1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2`

sample output OK:
```json
{
    "status": "OK",
    "message": "SUCCESS",
    "output": [
        {
            "value": 3965,
            "tx_hash": "36310f510b72035c44ead857b1a30e0bddfefb0813ce9e07d68ff1c927ea696d",
            "output_idx": 128379237
        },
        {
            "value": 662190,
            "tx_hash": "26f84ba20b601698415d99168401b0a6173d65aa2a0373f2b73463d487fdd488",
            "output_idx": 314018814
        }
    ]
}
```
sample output BAD:
```json
{
    "status": "INTERNAL_SERVER_ERROR",
    "message": "Invalid Bitcoin Address",
    "output": []
}
```


unspentTransactionBatchInfo :
`localhost:8080/rest/batch/address/1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2,1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr,1A8JiWcwvpY7tAopUkSnGuEYHmzGYfZPiq,1231234234`

sample output:
```json
{
    "results": {
        "1231234234": {
            "status": "INTERNAL_SERVER_ERROR",
            "message": "Invalid Bitcoin Address",
            "output": []
        },
        "1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffE2": {
            "status": "INTERNAL_SERVER_ERROR",
            "message": "Invalid Bitcoin Address",
            "output": []
        },
        "1Pa6zyqnhL6LDJtrkCMi9XmEDNHJ23ffEr": {
            "status": "OK",
            "message": "SUCCESS",
            "output": [
                {
                    "value": 3965,
                    "tx_hash": "36310f510b72035c44ead857b1a30e0bddfefb0813ce9e07d68ff1c927ea696d",
                    "output_idx": 128379237
                },
                {
                    "value": 662190,
                    "tx_hash": "26f84ba20b601698415d99168401b0a6173d65aa2a0373f2b73463d487fdd488",
                    "output_idx": 314018814
                }
            ]
        },
        "1A8JiWcwvpY7tAopUkSnGuEYHmzGYfZPiq": {
            "status": "OK",
            "message": "SUCCESS",
            "output": [
                {
                    "value": 62993,
                    "tx_hash": "8ad3f10a70a341e5b4d061c29649d5db4037580cbdf105ddce613364196fc3d2",
                    "output_idx": 105012181
                },
                {
                    "value": 50937,
                    "tx_hash": "364d3d1a3901943190d06e94d85817230f2ce21812c17d0ae0a71ef849b0ab98",
                    "output_idx": 108176290
                },
                {
                    "value": 50989,
                    "tx_hash": "25d9563ecd6d6e1792cb48226e4ef01c53b5b55caa01b1b46787e881159a5403",
                    "output_idx": 108179255
                },
                {
                    "value": 23268,
                    "tx_hash": "cb37bd3ecd28d7c376c073d3f2ca03dc82858b854e24408dc1ff93239b7d8c72",
                    "output_idx": 122278988
                },
                {
                    "value": 307964,
                    "tx_hash": "7eac6c44308254108493f805a02c76b3e9c5ee9b943fb3a53e0c10b182bfd82f",
                    "output_idx": 156741897
                },
                {
                    "value": 163345,
                    "tx_hash": "e1e357a087c0ee95e8d00722d645cfac251beb9adbec6741196cd51f2bfa5a43",
                    "output_idx": 181342617
                },
                {
                    "value": 163345,
                    "tx_hash": "fa0b798a7e47d1cf8ae0184cc5233ce6b9a5dc0380aa270ae32b0b8a081aaf22",
                    "output_idx": 181342624
                }
            ]
        }
    }
}
```

also has a healthcheck ep :
`localhost:8080/rest/health`


this API mirrors blockchain.info APIs internally.
