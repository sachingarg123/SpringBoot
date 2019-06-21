# Currency Conversion Microservice

1) Currency Conversion Microservice is used for Converting one currency to another
2) It calls Currency exchange service to get the latest exchange rate
3) TO call Currency exchange servic, Spring Cloud Feign Rest Client is used
4) Spring Netflix Ribbon is used to connect with Multiple Instances of Currency Exchange service
5) Netflix Ribbon act as Client Side Load Balancer.

# Important URL:

1) URL to access Currency Conversion microservice: http://localhost:8100/currency-converter-feign/from/{fromCurrency}/to/{toCurrency}/quantity/{qty}
