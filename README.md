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

![Alt text](https://g.gravizo.com/source/custom_image?https%3A%2F%2Fraw.githubusercontent.com%2Fjeevan1133%2FSpring-Cloud-Config%2Fmaster%2FREADME.md)
<details>
<summary>Micro Services Architecture</summary>
custom_image
  digraph architecture {    
    rankdir = TB;
    node[shape=component]
    Ribbon[shape=underline]    
    {rank=same; User, Nginx, ZuulServer}
    {rank=same; CurrencyExchangeService1, CurrencyExchangeService2, CurrencyExchangeService3};
    {rank=same; Ribbon, EurekaNamingServer };
    {rank=same; CurrencyCalculationService, CurrencyExchangeService, LimitsService};
    start -> Nginx
    Nginx -> ZuulServer
    Nginx -> CurrencyCalculationService    
    ZuulServer -> EurekaNamingServer
    Ribbon -> CurrencyExchangeService1
    Ribbon -> CurrencyExchangeService2
    Ribbon -> CurrencyExchangeService3
    CurrencyCalculationService -> Ribbon
    Ribbon -> EurekaNamingServer
    CurrencyExchangeService -> EurekaNamingServer;
    CurrencyCalculationService -> EurekaNamingServer;
    LimitsService -> EurekaNamingServer
    LimitsService -> SpringCloudConfigServer
    SpringCloudConfigServer -> Git
    SpringCloudConfigServer -> EurekaNamingServer
    CurrencyExchangeService -> DB
    CurrencyExchangeService -> LimitsService    
    start [shape=Mdiamond];
  }
  custom_image
  </details>
