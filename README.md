# Demo-Rest
Instllation:
java version 9
IDE:intellij IDEA
Mendix modeler 7.4.0
Running the tests:

REST API Client (Example : Postman for chrome) can be used to test the api services.
Rest API URLS:
(GET)return list of all recipe:http://localhost:8085/api/recipes/            
(GET)return category List:http://localhost:8085/api/categories/ 
(GET)return recipe by search id :http://localhost:8085/api/recipes/  -->id(example:RECIPE1)
(GET)return recipe list with category filter:http://localhost:8085/api/recipes/category/ ---->Category id(Example:Chilli)
(POST)Save new Recipe:http://localhost:8085/api/recipes/
json request body for post method:
{"description":"This is a tester Recipe","recipeHead":{"title":"butter chicken","yield":6,"categories":[{"name":"side Dish"},{"name":"Chilli"}]},"ingredients":[{"items":"chicken","ingAmount":{"quantity":1,"unit":"gram"}},{"items":"Butter","ingAmount":{"quantity":1,"unit":"lb"}},{"items":"Onion; large, chopped","ingAmount":{"quantity":1,"unit":"lb"}}]}

mendix UI :http://localhost:8081/
User: MxAdmin
Password: abc


