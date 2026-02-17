# IoC, Maven Build, and Dynamic Proxy Basics

## Objectives

- Use Maven to manage Spring dependencies
- Understand factory and injection patterns
- Learn why AOP and dynamic proxy are useful

## Prerequisites

- Finished `04-spring-ioc-quickstart`
- Basic understanding of Java interfaces

## Lesson Outline

1. Maven project structure and dependency management
2. Basic IoC wiring patterns
3. Introduction to AOP concepts
4. Dynamic proxy motivation and simple example

## Hands-on Steps

1. Build each subproject with `mvn clean test`
2. Compare behavior before and after proxy wrapping
3. Add logging concern as a cross-cutting example

## Checkpoints

- You can describe the difference between business logic and cross-cutting concerns
- You can run Maven lifecycle commands in this module
- You can identify where proxy behavior is applied

## Exercise

Add a timing aspect to one service method and print execution duration.
