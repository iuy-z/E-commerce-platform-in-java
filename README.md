E-commerce Platform in Java 🛒
This project is an object-oriented E-commerce platform built in Java, utilizing file handling for data storage. The system allows customers to browse, add, and purchase products, while an admin can manage inventory and view order details.

📌 Features
👤 Customer Functionalities
✅ Login & Registration – Customers must log in or create an account.
✅ Shopping Cart – Customers can:

Add products to their cart
Remove products from the cart
View their cart
✅ Purchase Products – Customers can buy products and their details will be stored.
✅ Account Management – Customers can update their information:
Change username
Change password
Add membership
🛠️ Admin Functionalities
✅ Product Management – Admin can:

Add products to the shop
Remove products from the shop
View available products
✅ Order Management – Admin can:
View order details
View product details
🛠️ Object-Oriented Structure
The project follows OOP principles, implementing inheritance, encapsulation, and polymorphism.

📂 Main Classes & Structure
1️⃣ Person (Base Class)

Stores common details (e.g., name, address, phone, email)
Extended by: Customer and Admin
2️⃣ Customer (Extends Person)

Contains customer-specific data
Maintains a cart (ArrayList<Product>)
3️⃣ Admin (Extends Person)

Handles product & order management
4️⃣ Product Class

Stores product details (name, price, quantity, category, etc.)
5️⃣ Shop Class

Contains:
List of Customers (ArrayList<Customer>)
List of Products (ArrayList<Product>)
List of Orders (ArrayList<Person>)
📂 File Handling for Data Storage
✅ Data Persistence:

Customers & Admins – Stored in text files.
Products – Admin adds/removes products via file handling.
Orders – Stored when a customer makes a purchase.

🔹 Prerequisites
Install Java (JDK 8 or later)
