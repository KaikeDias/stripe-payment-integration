
# Stripe Payment Microservice

<!-- Tags/badges -->
<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=java&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3-brightgreen?style=flat-square&logo=spring&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Stripe-API-646cff?style=flat-square&logo=stripe&logoColor=white" alt="Stripe"/>
  <img src="https://img.shields.io/badge/Maven-3.9.0-red?style=flat-square&logo=apache-maven&logoColor=white" alt="Maven"/>
</p>

Microserviço em **Java Spring Boot** para criar sessões de pagamento na **Stripe API**.  
Ele recebe informações de produtos e retorna uma URL de checkout para o frontend.

---

## 🚀 Funcionalidade

- Criação de **Checkout Session** na Stripe para processar pagamentos.
- Retorno da URL da sessão para o frontend redirecionar o usuário.

---

## 💻 Tecnologias

- Java 17+
- Spring Boot 3
- Lombok
- Stripe Java SDK
- Maven

---

## 📦 Estrutura do Projeto

```

src/main/java/com/dias/payment\_stripe
├─ controllers/
│  └─ ProductCheckoutController.java
├─ dtos/
│  ├─ ProductRequestDTO.java
│  └─ StripeResponseDTO.java
├─ services/
│  └─ StripeService.java
└─ StripePaymentApplication.java

````

- **controllers/**: endpoints REST para criar checkout.  
- **dtos/**: objetos de transferência de dados.  
- **services/**: lógica de integração com a Stripe.  
- **StripePaymentApplication**: classe principal do Spring Boot.

---

## ⚡ Endpoint

### POST `/products/checkout`

Cria uma sessão de pagamento na Stripe.

**Request Body (JSON):**
```json
{
  "name": "Camisa Personalizada",
  "amount": 5000,
  "quantity": 2,
  "currency": "BRL"
}
````

* `amount`: valor em centavos (ex: 5000 = R\$50,00)
* `currency`: moeda no formato ISO 4217 (`BRL`, `USD`, etc.)
* `quantity`: quantidade do produto
* `name`: nome do produto

**Response (JSON):**

```json
{
  "status": "SUCCESS",
  "message": "Payment session created",
  "sessionId": "cs_test_xxx",
  "sessionUrl": "https://checkout.stripe.com/pay/cs_test_xxx"
}
```

---

## 🔑 Configuração

### 1. Variável de ambiente

Defina sua **Stripe Secret Key**:

```bash
export SECRET_KEY=sk_test_XXXX
```

No Windows PowerShell:

```powershell
setx SECRET_KEY "sk_test_XXXX"
```

### 2. application.yml

```yaml
stripe:
  secret-key: ${SECRET_KEY}
```

### 3. Injeção no Service

```java
@Service
public class StripeService {

    @Value("${stripe.secret-key}")
    private String secretKey;

    // Lógica de criação de checkout...
}
```

---

## 🧪 Testando

* Use **Postman** ou **Insomnia** para enviar requisições para `localhost:8080/products/checkout`.
* Abra a URL retornada no navegador para simular o checkout.

---

## 🔗 Referências

* [Stripe API Docs](https://stripe.com/docs/api)
* [Stripe Checkout Guide](https://stripe.com/docs/payments/checkout)
* [Spring Boot Reference](https://spring.io/projects/spring-boot)
