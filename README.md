# taller-programacion-2026

A simple banking system built in Java as the semester project for the 2026 programming workshop. The application simulates the core operations of a bank account and is organized using a layered architecture to separate business rules from technical implementation details.

## Purpose

The goal of this project is to demonstrate a clean separation of concerns in a small, understandable domain: bank accounts. Rather than mixing business logic with data storage, the code is structured so that each layer has a single, well-defined responsibility, following patterns commonly used in real-world production systems.

## Architecture

The source code is organized into the following layers:

- **domain** — Contains the `Account` entity and the core business rules, such as preventing a withdrawal that would leave the account with a negative balance. This layer has no dependency on frameworks or external libraries.
- **application** — Contains the use cases that orchestrate the domain logic: depositing funds, withdrawing funds, and transferring money between two accounts. This layer defines *what* the system does.
- **infrastructure** — Contains an in-memory repository that stores accounts using a simple data structure, simulating persistence without requiring a real database. This layer defines *how* things are done.

Tests live under `src/test/java`, mirroring the main package structure, and validate the core operations: successful deposits, successful withdrawals, transfers between accounts, and the rejection of withdrawals that exceed the available balance.

## Build

This project uses Gradle as its build tool. To compile and run tests locally:

```bash
./gradlew build
```

## Requirements

- Java 17 or higher
- Gradle (wrapper included)

## Status

This is an actively evolving educational repository, developed incrementally as part of the 2026 programming workshop.
