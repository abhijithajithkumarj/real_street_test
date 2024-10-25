# Real Street Test Application

This is a Spring Boot application for uploading and managing multimedia files such as images, audio, and video files. The application provides RESTful APIs to upload, retrieve, and manage assets stored in a cloud storage service (e.g., Cloudinary).

## Features
- Upload image, audio, and video files using separate API endpoints.
- Retrieve a list of all uploaded assets with metadata, including creation date, last modified date, file size, and file type.
- Store and manage file metadata in a database.
- Integration with Cloudinary for cloud-based file storage.

## Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA (for database operations)
- Cloudinary (for cloud storage)
- JUnit and Mockito (for unit testing)
- Maven (build tool)
- MySQL (for database operations)

## Prerequisites
- Java 11 or above installed
- Maven installed
- A Cloudinary account (for cloud storage)

## Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/abhijithajithkumarj/real_street_test
   
   cd real-street-test
