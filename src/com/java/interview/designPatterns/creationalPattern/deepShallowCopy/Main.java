package com.java.interview.designPatterns.deepShallowCopy;

// Prototype Interface
interface Prototype<T> {
    T clone();
}

// Concrete Prototype
class EmployeeIDCard implements Prototype<EmployeeIDCard> {
    String companyName;
    String cardDesign;   // complex object in real-world
    String employeeName;
    String employeeId;

    public EmployeeIDCard(String companyName, String cardDesign) {
        this.companyName = companyName;
        this.cardDesign = cardDesign;
    }

    @Override
    public EmployeeIDCard clone() {
        EmployeeIDCard copy = new EmployeeIDCard(this.companyName, this.cardDesign);
        copy.employeeName = this.employeeName;
        copy.employeeId = this.employeeId;
        return copy;
    }

    @Override
    public String toString() {
        return "[Company: " + companyName + ", Design: " + cardDesign +
               ", Name: " + employeeName + ", ID: " + employeeId + "]";
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create prototype
        EmployeeIDCard prototype = new EmployeeIDCard("TechCorp", "Modern Blue Layout");

        // Clone and customize
        EmployeeIDCard card1 = prototype.clone();
        card1.employeeName = "Surya";
        card1.employeeId = "E101";

        EmployeeIDCard card2 = prototype.clone();
        card2.employeeName = "Ravi";
        card2.employeeId = "E102";

        System.out.println(card1);
        System.out.println(card2);
    }
}
