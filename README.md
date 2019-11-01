# Index

- [My Comments & Revisement.](#1)
- [REAL ESTATE INQUIRY INFORMATION SYSTEM (REIIS)](#2)
- [List of things to learn](#3)
- [Screenshots](#4)


## <a id="1"></a>My Comments & Revisement.

A Real Estate Inquiry Information System (REIIS) must be created and include inheritance and class hierarchies (a super class and subclasses). The program(s) must include inheritance concepts and applications for credit to be given for the assignment. The REIIS will allow the input of the real estate data, process of the real estate data, and output of the real estate information.



## <a id="2"></a>REAL ESTATE INQUIRY INFORMATION SYSTEM (REIIS)

A Real Estate Inquiry Information System (REIIS) must be created and include inheritance and class hierarchies (a super class and subclasses). The program(s) must include inheritance concepts and applications for credit to be given for the assignment. The REIIS will allow the input of the real estate data, process of the real estate data, and output of the real estate information.



#### Real Estate Companies – Super Class

The super class should include the real estate:  
-    company number
-    real estate company name
-    address
-    city
-    state
-    zip code
-    company e-mail address
-    company phone number




#### Real Estate Agents - Sub Class
  A sub class should include the real estate: 
  - company number
  - real estate listing agent number
  - the real estate agent name
  - real estate agent e-mail address 
  - real estate phone number


  #### Multilist Properties - Sub Class (public abstract class)
A sub class should include the real estate: 
   - company number
   - real estate listing agent number
   - property multi list number
   - the property parcel number
   - property parcel identification
   - property type (C for commercial or R for residential)
   - property address: city, state, and zip code
   - asking price of the property 
   - land and building assessed property values.
   - abstract methods (signature header only) for the total assessed property value (land and building)
       - local
       - county
       - real estate (school) property taxes
       - total property taxes


#### Commercial Property Sub Class
   The commercial property taxes should define the abstract methods (with overriding) to calculate the: 
   - total assessed property value (land + building)
   - local tax
   - county tax
   - real estate (school) taxes
   - total of all of the taxes for a given property  
  
Use the assessed property value to calculate the property taxes.  
To calculate the taxes use:  
   - 4.35 for the local tax
   - 7.251 for the county tax
   - 27.90 for the real estate (school tax)
   
   
  Be sure to define the tax rates as final constants in the commercial class.

#### Residential Property Sub Class
The residential property taxes should define the abstract methods (with overriding) to calculate the:
   - total assessed property value (land + building)
   - local tax
   - county tax
   - real estate (school) taxes
   - total of all of the taxes for a given property  

Use the assessed property value to calculate the property taxes.  
To calculate the taxes use: 
   - 2.53 for the local tax
   - 4.73 for the county tax
   - 22.8763 for the real estate (school tax)
   

> 
Be sure to define the tax rates as final constants in the residential class.  
I could have included other real estate data fields, but I wanted to simplify the information system.Additionally, I included fields (primary and foreign keys) to allow for future database application interfacing but this will not be a requirement for this assignment.

#### THE REAL ESTATE CLASS CONSIDERATIONS
Your classes representing the real estate/property must include 
- inheritance
- the data fields
- final constants
- constructor(s)
- accessor and mutator methods
- the methods (in the appropriate classes) to handle all of the tax calculations.

The appropriate classes should also include 
- abstract
- overloading (to handle the data coming into the real estate classes as either a String and/or int/float)
- overriding methods.

The real estate classes should not contain any programming code relating to inputting of the data or outputting or displaying of the information for this should be handled by the GUI (Graphical User Interface).  No GUI programming code should be contained in any of the Real Estate class (.java) files.

#### GRAPHICAL USER INTERFACE PROGRAM(S)
Students are to create GUI (Graphical User Interfaces) programming techniques via a separate class (.java file). You can design more than one .java file but only is required to interface with the real estate .java classes. All of the Java statements must be written by the student. In other words, students are NOT allowed to use an interface in an IDE (Interactive Development Environment) that generates the Java code automatically.

Also, students are NOT allowed to use the API (Application Programming Interface) classes Scanner or JOptionPane for input. Students are permitted to use the JOptionPane class to display all of the sales information. Students can use labels, button(s), radio button(s), check box(es), menus, sliders, etc., to create the GUI. Keep in mind that the GUI class must be a separate .java file from the real estate .java classes. Assume there will be multiple property inquiries.



#### INPUT DATA via GUI
For the real estate classes, you GUI must be able to accept the data from the user’s screen and interface with the real estate classes. The input data to the REIIS classes should include the real estate class data, the real estate listing agent data, as well as the multi list property data. You could incorporate data validation programming techniques (try and catch, for example) but this is not required for this assignment.Make up test data when inputting the data for each object.

#### OUTPUT DETAILED INFORMATION (for each object) 
For each real estate information system inquiry, your program should output the following detailed information:
 - real estate company number
 - real estate company name
 - real estate listing agent number 
 - real estate agent name 
 - real estate listing agent phone number
 - property multi list number
 - property parcel number 
 - property parcel identification
 - property type (C for Commercial or R for Residential) 
 - property address
 - city
 - state 
 - zip code
 - asking price of the property 
 - assessed value of the building
 - assessed value of the land 
 - total assessed value of the property (building + land)
 - local, municipal, real estate taxes
 - total taxes for the property

Be sure to verify your program results prior to submitting your work.
Students can use the JOptionPane class to display each real estate property information.
Your REIIS should allow the user to continue to generate individual property information for each real estate inquiry until the user decides to stop the program (the user clicks the EXIT button in the GUI, for example).


## <a id="3"></a> Things To Learn

The followings are required to be mastered:
- GUI componenets
- inheritance
 - Super Class: Parent class
 - Sub Class: Child class
 - Reusabilty: Functionality of inheritance
- abstract class/methods
- overriding
- acessor & mutator methods


## <a id="4"/>Screenshots
![1](https://raw.githubusercontent.com/omonkulov/REIIS/master/Preview/1.png)
![2](https://raw.githubusercontent.com/omonkulov/REIIS/master/Preview/2.png)
![3](https://raw.githubusercontent.com/omonkulov/REIIS/master/Preview/3.png)
