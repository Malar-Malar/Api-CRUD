
##
This is a backend API built with Spring Boot for handling **user signup/login** and storing **fitness metrics** like hydration, fatigue, and posture collected from wearable devices.

##  Features ##

- User Signup and Login
- Save user metrics from wearable devices
- View all metrics for a user
- Delete metrics with missing device information

##  Tech Stack ##

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (basic usage)
- MySQL database

## Authentication APIs ##
POST /api/auth/signup – Registers a new user so they can access the platform.

POST /api/auth/login – Authenticates an existing user to allow secure access.

 ## User Metrics APIs ##
 POST /api/metrics – Saves fitness metrics like hydration, fatigue, posture for a user from a wearable device (to track user health data).

GET /api/metrics/{userId} – Fetches all saved metrics for a specific user (to show their fitness history).

DELETE /api/metrics/delete-null-device – Deletes all metrics with missing device ID (to clean up invalid data).

## Swagger ScreenShot ##

<img width="1093" alt="image" src="https://github.com/user-attachments/assets/5f1a188b-3f8d-433d-97b6-6b5e2f60be40" />


