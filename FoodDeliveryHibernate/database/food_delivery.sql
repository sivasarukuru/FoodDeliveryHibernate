CREATE DATABASE IF NOT EXISTS food_delivery;
USE food_delivery;

-- Hibernate will create/update the tables because hibernate.hbm2ddl.auto=update.
-- This file only inserts sample data after the tables have been created by Hibernate.

-- Register one user through the application first.
-- Passwords in this demo are plain text only for learning.
-- For a real application, use BCrypt/Argon2 password hashing.

-- Sample restaurants
INSERT INTO restaurants (name, location, rating, deliveryTime, imageUrl)
SELECT 'Paradise', 'Hyderabad', 4.6, 30,
'https://images.unsplash.com/photo-1515003197210-e0cd71810b5f?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM restaurants WHERE name='Paradise');

INSERT INTO restaurants (name, location, rating, deliveryTime, imageUrl)
SELECT 'Bawarchi', 'Hyderabad', 4.5, 35,
'https://images.unsplash.com/photo-1552566626-52f8b828add9?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM restaurants WHERE name='Bawarchi');

INSERT INTO restaurants (name, location, rating, deliveryTime, imageUrl)
SELECT 'Dominos', 'Tirupati', 4.3, 25,
'https://images.unsplash.com/photo-1574071318508-1cdbab80d002?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM restaurants WHERE name='Dominos');

INSERT INTO restaurants (name, location, rating, deliveryTime, imageUrl)
SELECT 'KFC', 'Bangalore', 4.2, 30,
'https://images.unsplash.com/photo-1513639776629-7b61b0ac49cb?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM restaurants WHERE name='KFC');

INSERT INTO restaurants (name, location, rating, deliveryTime, imageUrl)
SELECT 'Pizza Hut', 'Chennai', 4.1, 32,
'https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?auto=format&fit=crop&w=900&q=80'
WHERE NOT EXISTS (SELECT 1 FROM restaurants WHERE name='Pizza Hut');

-- Sample menu items. Run after the restaurant rows exist.
INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Chicken Biryani','Aromatic basmati rice with tender chicken',250,
'https://images.unsplash.com/photo-1589302168068-964664d93dc0?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='Paradise'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Chicken Biryani' AND m.restaurant_id=r.id);

INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Mutton Biryani','Rich and flavorful mutton biryani',320,
'https://images.unsplash.com/photo-1563379091339-03246963d51a?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='Paradise'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Mutton Biryani' AND m.restaurant_id=r.id);

INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Chicken 65','Crispy spicy chicken starter',190,
'https://images.unsplash.com/photo-1601050690597-df0568f70950?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='Bawarchi'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Chicken 65' AND m.restaurant_id=r.id);

INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Veg Pizza','Fresh vegetables and mozzarella',249,
'https://images.unsplash.com/photo-1579751626657-72bc17010498?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='Dominos'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Veg Pizza' AND m.restaurant_id=r.id);

INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Chicken Burger','Crispy chicken burger with fresh toppings',199,
'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='KFC'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Chicken Burger' AND m.restaurant_id=r.id);

INSERT INTO menu_items (name, description, price, imageUrl, restaurant_id)
SELECT 'Margherita Pizza','Classic tomato, basil and mozzarella',229,
'https://images.unsplash.com/photo-1574071318508-1cdbab80d002?auto=format&fit=crop&w=700&q=80',r.id
FROM restaurants r WHERE r.name='Pizza Hut'
AND NOT EXISTS (SELECT 1 FROM menu_items m WHERE m.name='Margherita Pizza' AND m.restaurant_id=r.id);
