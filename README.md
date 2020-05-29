## OWASPJuiceShopUITests

UI Tests for OWASP Juice Shop Application written using WebDriver 4

Create a user and update resources/application.properties

### Run Tests

```shell script
docker-compose build
docker-compose up -d
mvn clean -Dtest=JuiceShopJunitTest test
```