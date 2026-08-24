# Step_semester_3
# STEP Semester 3 - Week 3

## Topic
Object Oriented Programming (OOP)

This week was mainly about understanding classes, objects, constructors, inheritance, static and instance members, object references and composition.

## Class Problems

The class problems covered five main exercises.

### F1 - Attendance System

Created an `SrmStudent` class with student details and attendance.

The class could update attendance, check whether a student was eligible based on the 75% requirement, and calculate the average attendance of the class.

I used an array of student objects and looped through them to display their status.

### F2 - Fee Account

Created a `FeeAccount` class to manage student fees.

It included paying fees, finding the remaining amount, paying through two installments and calculating the effective amount after a scholarship.

This was mainly practice with private variables, constructors and methods.

### F3 - Hostel Room

Worked with object references using a `HostelRoom` class.

I created two references to the same room and checked them using `==` to understand that both references can point to the same object.

The `allot()` method changed the occupied count of the actual room object.

### F4 - Static and Instance Members

Used `SrmStudent` to understand the difference between instance and static variables.

Student information such as name and registration number belongs to each object, while university name and admission count are shared.

A static method was also used to display the total number of admissions.

### F5 - Student System

This was a combination of the previous concepts.

An `SrmStudent` object contained a `FeeAccount` and a `HostelRoom`.

This helped me understand composition, where one object contains references to other objects.

## Assignment Problems

The assignment had another five OOP problems.

### F1 - Library Fine System

Created a `BookIssue` class to store book and borrower details and calculate overdue fines.

I also used a static method to calculate the total fine collected from an array of book issues.

### F2 - Employee Inheritance

Created an `Employee` parent class and two child classes, `ManagerEmployee` and `InternEmployee`.

The manager adds a team bonus to the salary, while the intern salary is limited by a stipend cap.

I used `instanceof` to identify the type of employee stored in an `Employee` reference.

### F3 - Parking Slot

Created a `ParkingSlot` class to manage parking capacity.

The program searches for an available slot and handles the case where no slot is available.

This was also practice with returning `null` and checking for it before using an object.

### F4 - Library Member

This problem focused on static versus instance variables.

The first version showed the problem with making member details static because all objects would share the same values.

I then used instance variables for member details and static variables for information shared by the whole library.

 F5 - HR and Parking System

This combined inheritance and composition.

Employee objects could be normal employees, managers or interns, and a parking slot could also be assigned to an employee record.

The program generated a complete profile showing the employee's pay and parking information.

## Problems I Faced

One problem I had while setting up the project was with the Java project configuration in VS Code.

VS Code was treating the folder structure incorrectly and was giving package errors even though the Java compiler itself was working.

I tested the programs directly using `javac` and `java` and confirmed that the code was compiling correctly.

I also had some generated `.class` files showing up in Git, so I added `bin/` and `*.class` to `.gitignore` so compiled files are not pushed to GitHub.

things that i practiced or revised :-

 Classes and objects
 Constructors
 Encapsulation
 Private variables
 Static and instance members
 Object references
 `==` with objects
 Arrays of objects
 Inheritance
 `instanceof`
 Composition
