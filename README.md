This is a simple bank account system. where user can register themselves and can deposit, withdraw and see their bank account details. All the exception are handle here there is no authentication is applied.

1. Install jdk , IDE, MySql, MySql work bench , Postman
2. CLone this Project & import as maven
3. Override application.properties file to configure database
4. Run PatientApplication class.
## **BASIC FEATURES**
1. User can create there bank account.
2. After creation of account they can deposit, withdraw the money only if amount is less than present amount.
3. Also can edit their name and can able to delete themselves also as well as get all user details.
   Validations, exceptions are handled throughout the application.
## **CONTROLLER URLs**
* http://localhost:9080/getAll GET-- for getting the details of all user present in our database.
* http://localhost:9080/get/1?id=1 GET-- for getting information of particular user by passing their id in the url in place of 1.
* http://localhost:9080/save POST-- for creating the bank account. JSON
  {"id":1,"name":"chandni","age":23","amount":780.00}
* http://localhost:9080/edit/1/name?Name=anii PUT-- for updating the name of particular user by passing the id and new name in the url in place of 1 and anii respectively.
* http://localhost:9080/delete/1?id=1 DELETE-- for deleting the account of particular user by passing id in url.
* http://localhost:9080/deposit/1?id=1 PUT-- for depositing the money in particular user account. JSON
   {"amount": 3456.00}
* http://localhost:9080/withdraw/id?id=1 PUT-- for withdrawing the money from particular user account. JSON
   {"amount":765.00}

## **CONCLUSION**
This documentation provides a detailed guide for running the Bank Account System, interacting with its API endpoints. For further details, refer to the source code or contact Me.
