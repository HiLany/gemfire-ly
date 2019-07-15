# Gemfire-ly

This project is aim at 3 points:

1. learn how to design cluster.please refer to module whose name is gflocator and gfserver. include configuration file of locator and server. what's more. if you want to save the value which you want, you can design the pojo to achieve your goals.
2. learn how to write a gemfire client with [spring data for gemfire](https://docs.spring.io/spring-data/gemfire/docs/2.0.1.RELEASE/reference/html/). please refer to module whose module name is gemfire-ly-client.
3. learn how to improve the performence of search by function. please refer to  module whose module name is gemfire-ly-function.

## The module's list:

|-- gemfire-ly

|  |-- gemfire-ly-client -------------------------------- GemfireClient with SpringDataGemfire.

|  |-- gemfire-ly-domain -------------------------------- The pojo for Region's Value.

|  |-- gemfire-ly-function ------------------------------ The function which will  
revoked by GemfireClient.

|  |-- gemfire-ly-simple ------------------------------- The Simple GemfireClient with GemfireAPI.

|  |-- gflocator ------------------------- include start locator shell script and locator config. 
|  |-- gfserver  ------------------------- include start server shell script and
server config. 

