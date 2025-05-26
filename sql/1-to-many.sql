CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderDate DATE NOT NULL,
    TotalAmount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


-- Insert dummy data into Customers table
INSERT INTO Customers (CustomerID, Name, Email)
VALUES 
    (1, 'John Doe', 'john.doe@example.com'),
    (2, 'Jane Smith', 'jane.smith@example.com'),
    (3, 'Alice Brown', 'alice.brown@example.com'),
    (4, 'Bob Johnson', 'bob.johnson@example.com');

-- Insert dummy data into Orders table
INSERT INTO Orders (OrderID, CustomerID, OrderDate, TotalAmount)
VALUES 
    (101, 1, '2025-05-20', 150.75),
    (102, 1, '2025-05-22', 200.50),
    (103, 2, '2025-05-21', 99.99),
    (104, 3, '2025-05-23', 75.25),
    (105, 3, '2025-05-24', 120.00),
    (106, 4, '2025-05-25', 180.90);


    Select O.OrderID, C.Name, O.OrderDate 
from Orders O join Customers C on O.CustomerID = C.CustomerID