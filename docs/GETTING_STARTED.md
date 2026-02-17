# Getting Started

## Prerequisites

- JDK 8 or JDK 11
- Maven 3.8+
- Git
- IntelliJ IDEA (recommended) or VS Code with Java extensions

## Clone

```bash
git clone https://github.com/OiPunk/javaframework.git
cd javaframework
```

## Run a First Example

Pick any module with `pom.xml`, for example:

```bash
cd "springboot-quick-start/07-springboot-mvc-structure-dev-hot-reload/FirstSpringBoot"
mvn clean test
mvn spring-boot:run
```

Then open `http://localhost:8080`.

## Suggested Learning Order

1. `spring-quick-start/`
2. `spring/`
3. `springboot-quick-start/`
4. `springboot/`
5. `springcloud-quick-start/`
6. `springclooud/` (legacy notes)

Full map: [`CURRICULUM.md`](CURRICULUM.md).

## Troubleshooting

- `JAVA_HOME not set`: point to your JDK install.
- `mvn: command not found`: install Maven and add it to `PATH`.
- Dependency timeout: retry with a stable mirror/proxy.
- Port conflict: run with `-Dserver.port=8081`.
