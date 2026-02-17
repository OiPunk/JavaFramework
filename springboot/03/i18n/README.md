# Spring Boot i18n Demo

This module demonstrates internationalization (i18n) in Spring Boot with Thymeleaf.

## Supported Locales

- `en_US` (English)
- `zh_CN` (Chinese)
- `es_ES` (Spanish)

## How It Works

- `SessionLocaleResolver` keeps the selected locale in session.
- `LocaleChangeInterceptor` switches locale using query param `lang`.
- Message bundles are loaded from `src/main/resources/i18n/login*.properties`.

## Run

```bash
mvn spring-boot:run
```

Open:

- `http://localhost:8080/login.html`

Switch language:

- `http://localhost:8080/login.html?lang=en_US`
- `http://localhost:8080/login.html?lang=zh_CN`
- `http://localhost:8080/login.html?lang=es_ES`
