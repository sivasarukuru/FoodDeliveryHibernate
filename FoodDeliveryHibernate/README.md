# Food Delivery Application - Hibernate

## Stack
Java 17, Hibernate ORM 6.6, JSP, Servlets, HTML, CSS, MySQL, Maven, Tomcat 10.1+.

## Setup in Eclipse
1. Install JDK 17.
2. Install/configure Apache Tomcat 10.1+.
3. Install MySQL 8+.
4. Import this folder as an Existing Maven Project.
5. Open `src/main/resources/hibernate.cfg.xml`.
6. Change `hibernate.connection.username` and `hibernate.connection.password`.
7. Create the database by running `database/food_delivery.sql` only for the database creation and sample inserts.
8. First start the application once so Hibernate creates/updates tables.
9. Run the sample SQL insert section again if needed.
10. Add the project to Tomcat and run `index.jsp`.

## Important
The sample image URLs require internet access. You can replace them with local images under `src/main/webapp/images`.

## Main flow
JSP -> Servlet -> Service -> DAO -> Hibernate -> MySQL

## Features
- Registration
- Login/logout
- Restaurant listing
- Restaurant menu
- Add/decrease/remove cart items
- Place order
- Transactional order creation
- Order history

## Security note
This is an interview-learning project. Passwords are intentionally kept simple to make Hibernate learning easy. In a production application, hash passwords with BCrypt/Argon2 and add validation, CSRF protection, authorization, connection-pool configuration, and proper error handling.
