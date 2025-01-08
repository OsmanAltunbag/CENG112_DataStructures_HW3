# CENG112_DataStructures_HW3
Coding homework 3 of CENG112 Course at Izmir Institute of Technology Spring 24'
# Product Inventory Management System

This project implements a product inventory management system using Java that sorts products by category and name.

## 🎯 Project Overview

This system manages an inventory that sorts products first by their categories and then by name within each category. The system processes commands through a CSV file and utilizes a Binary Search Tree data structure for data management.

## 🔑 Key Features

- Category-based product organization
- Name-based product sorting
- CSV file data reading
- Product search functionality
- Product listing capability
- Generic class implementation

## 🛠 Technologies Used

- Java
- Binary Search Tree
- Generics
- CSV File I/O

## 📋 Class Structure

### Product Class
- Contains product name, category, and price information
- Manages basic product properties

### Node Class (Generic)
- Generic `Node<T>` structure
- Represents nodes in the tree structure

### Tree Class (Generic)
- Generic `Tree<T>` structure
- Binary Search Tree implementation
- Methods for adding nodes, searching, and listing

### Inventory Class
- Uses `Tree<Product>` structure
- Manages product inventory

### FileIO Class
- Handles CSV file reading operations
- Processes commands and product data

### Main Class
- Program entry point
- Processes CSV commands
- Manages user interaction

## 📥 CSV File Format

The CSV file should contain commands in the following format:

```csv
[command],[category],[product],[price]
```

### Supported Commands:
- `add`: Add new product
- `search`: Search for a product
- `list`: List all products

### Example CSV Inputs:
```csv
add,Fruit,Apple,20
add,Vegetable,Carrot,25
list
add,Fruit,Orange,30
search,Apple
search,Soap
add,Dairy,Cheese,100
list
```

## 📝 Example Output

```
Adding: Product: Apple, Category: Fruit, Price: 20₺
Adding: Product: Carrot, Category: Vegetable, Price: 25₺
Listing:
Apple (Fruit): 20₺
Carrot (Vegetable): 25₺
Adding: Product: Orange, Category: Fruit, Price: 30₺
Searching: Found: Apple (Fruit): 20₺
Searching: Not Found: Soap
Adding: Product: Cheese, Category: Dairy, Price: 100₺
List:
Cheese (Dairy): 100₺
Apple (Fruit): 20₺
Orange (Fruit): 30₺
Carrot (Vegetable): 25₺
```

## 🚀 Installation and Running

1. Clone the project
```bash
git clone [repo-url]
```

2. Open the project in your Java IDE

3. Prepare your CSV file

4. Run the Main class

## 💡 Implementation Notes

- Products are sorted first by category, then by name within each category
- Binary Search Tree structure ensures efficient searching and sorting
- Strict CSV file format must be followed
- The system uses generic classes for flexibility and reusability

## 🔍 Technical Details

### Search Implementation
- Binary Search Tree enables efficient O(log n) search operations
- Category-based primary sorting
- Name-based secondary sorting within categories

### Data Structure
- Generic Binary Search Tree implementation
- Custom node structure for flexible data management
- Efficient sorting and searching capabilities

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'feat: Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the [MIT] License - see the LICENSE.md file for details.
