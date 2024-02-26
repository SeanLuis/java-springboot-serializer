# Spring Boot Serializers and Grouping Example

## Project Objective

The primary objective of this mini project is to demonstrate how to effectively use serializers and validation groups in a Spring Boot application to handle request and response data. This example serves as a practical guide for implementing these concepts in a way that promotes clean code and maintainability.

## Importance of Serializers and Groups

Serializers and groups are essential for:

- **Data Binding**: Convert JSON to Java objects (DTOs) and vice versa in a way that's secure and avoids common pitfalls.
- **Validation**: Apply different validation rules to the same object depending on the context of the operation being performed.
- **Data Views**: Customize the JSON output by serializing only certain fields of an object based on the operation, which is crucial for API development.

## Key Components

- **DTOs (Data Transfer Objects)**: We use `FilterRequestDTO` and `FilterResponseDTO` to encapsulate incoming and outgoing data.
- **Validation Groups**: Interfaces such as `BasicInfo`, `AdvancedInfo`, and `FullInfo` are used to define groups for conditional validation.
- **View Groups**: Interfaces like `BasicView`, `AdvancedView`, and `FullView` are used with `@JsonView` to control which fields get serialized for the response.
- **Controller**: The `FilterController` class demonstrates the endpoints that process requests and generate responses using the defined groups.

## Core Concepts

- **Serializers**: Handle the conversion between objects and their serialized form (e.g., JSON) while considering aspects like format and field inclusion/exclusion.
- **Validation Groups**: Allow specifying subsets of constraints for different processing scenarios, helping to reuse model classes for various use cases.
- **View Groups**: Facilitate selective JSON serialization to tailor responses according to different API view requirements.

## Getting Started

1. Clone the repository.
2. Open the project in your IDE as a Maven project.
3. Ensure Java 17 or newer is installed.
4. Run `SerializerApplication.java` to start the application.
5. Use a tool like Postman to test the `/api/filters/basic`, `/api/filters/advanced`, and `/api/filters/full` endpoints.

This project is designed to be a learning resource for managing complex data structures in Spring Boot applications. It is especially useful for developers looking to understand and implement serialization and grouping strategies in their APIs.

## Testing

This project includes unit tests for its endpoints, ensuring that the serializers and groups are working as expected.

### Running the Tests

To run the tests, you can use the following command in the root directory of the project:

```bash
./mvnw test
