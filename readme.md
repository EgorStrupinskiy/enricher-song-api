# Song API Microservice

The Song API microservice is an integral part of the Microservices Music Metadata Enrichment System, a scalable and resilient application designed to enrich music metadata for uploaded song files. This microservice is responsible for managing song metadata, providing CRUD (Create, Read, Update, Delete) operations, and interacting with the underlying database.

## Overview

The Song API microservice plays a crucial role in the overall architecture by handling the enriched metadata received from the Enricher Service. It provides endpoints to access and manage the metadata for individual tracks, which includes information fetched from the Spotify API and the associated file ID stored in the File Service.

## Functionality

- **Create**: Allows the addition of new song metadata to the system's database. Enriched metadata is received from the Enricher Service, and the song's associated file ID is linked to the record.

- **Read**: Provides various endpoints to retrieve song metadata based on different criteria, such as song name, artist, or Spotify track ID.

- **Update**: Enables the modification of existing song metadata, allowing administrators to correct and update any inaccuracies.

- **Delete**: Supports the removal of song metadata from the database when required.

## Database

The Song API microservice stores song metadata in a MySQL database, as per the system's configuration. The database schema contains fields to store details about the song, such as the song name, artist, duration, alternative track name, and Spotify track ID.

## Dependencies

- **Spring Boot**: The microservice is built using the Spring Boot framework, enabling rapid development and deployment.

- **Spring Data JPA**: For simplified data access and management using JPA (Java Persistence API).

- **Apache Camel**: Used for messaging and integration with other microservices via message queues.

- **Resilience4j**: Provides resilience patterns, such as circuit breakers, to handle failures and improve system robustness.

## How to Use

Developers can interact with the Song API microservice using HTTP requests, either directly or through the Spring Cloud Gateway. They can perform CRUD operations on song metadata based on their user role and permissions.

## Contribution

Contributions to the Song API microservice or the entire Microservices Music Metadata Enrichment System are welcomed. Developers can contribute by opening issues, submitting pull requests, or improving the documentation.
