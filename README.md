## This project is a tutorial on setting up a spring boot project with spring cloud server and client

---
# Spring Cloud Server

This repository contains example on configuring spring boot applications to use
spring cloud server, spring cloud client, ribbon for server side load balancing,
hytrix for circuit breaker and fallback, feign as rest client, eureka naming server
for client discovery, zuul as api gateway.

## Build the examples

Clone this repository and build the examples using:

```
docker-compose up
```

### Services Architecture

```
digraph architecture {
  rankdir=TB;
{rank=same; CurrencyCalculationService, CurrencyExchangeService, LimitsService};
Configuration[shape=cylinder]
Database[shape=cylinder]
LimitsService, CurrencyCalculationService, CurrencyExchangeService[shape=component]

  CurrencyCalculationService -> CurrencyExchangeService -> LimitsService;

  CurrencyExchangeService->Database;
  LimitsService->Configuration;

}

```                  
