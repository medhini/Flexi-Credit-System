Flexi-Credit-System
===================
This project is a simple Time Table Chooser application implemented in all
Universities affiliated with the Flexi-Credit System. A Flexi-Credit system
enables students to register for and complete courses and electives of their
interest to hit the minimum credit number required of them. 

The minimum number of credits to be earned are mentioned so that students select subjects in such a way that the requirement is met. There are a fixed number of mandatory courses under each discipline of study. The student is given the choice to undertake additional courses and gain more number of credits. Once the desired courses are selected, a timetable is generated. A clash in the periods is avoided by segragating dissimilar courses together in slots. This bridges the gap between professional and liberal education hence providing students with an academically rich education system.

Students are queued in the decreasing order of their Cumulative Grade Point Average (CGPA ) from the previous semesters. Class limits were set for each course and students with higher CGPA were allowed to choose first. When the Time Table allotments begin, the student with the highest pointer has his activation signal go green. The signal remains green as long as he is choosing the subjects. Once he finalizes his time table the next student in line receives the signal and the first student's activation signal turns red. A student can view his chosen time table at any point of time. Provisions were made to run the source program on different systems, thus allowing students to choose their time table from their personal computers. This makes the system a real time one. 

This project was implemented as a part of Paradigms of Programming-1 Course, 3rd Semester (B.Tech), Department of Information Technology, National Institute of Technology Karnataka, Surathkal. It has been written in Java. Our project takes into consideration two departments, namely IT and ECE. This can be easily extended further to incorporate a larger database. 

Frontend :
The frontend was designed using GUI features offered by Java. Radio buttons, JTables, Dialog boxes and other basic facilities were incorporated.

Backend :
Files were used to handle the data. Objects were serialized and written into and read from files.

Exception handling and all major OOP concepts were implemented.

Installation guidelines :

The project can be run on any IDE that supports Java. A project named "basic" is to be created. Make sure the log.txt, validation.txt, ECE.txt, IT.txt are saved in the same project folder along with bin and src.

Compile and run the program from MainFrame class. 

The system works as follows :

1. Create a list of students in either department. All details are to be provided.
2. Start the time table allotment process by clicking on the Login option
3. Gray signal indicates that a student's turn has not yet arrived. Green signal indicates its his/her turn to choose. Red signal means the time table has already been chosen. 
4. If the signal is green, the radio buttons are activated and the student is permitted to choose the courses. 
5. The student can view the chosen time table anytime during the process. 

Project Contributers :
1. Medhini G N (medhini95@gmail.com)
2. Shreya Venkatesh (shre95@gmail.com)
3. Meghana Potta (meghana.potta@gmail.com)
