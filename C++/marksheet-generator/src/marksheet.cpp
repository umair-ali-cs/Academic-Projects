#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include <limits>
using namespace std;

// global variables and arrays
	int c_hours[7];
	int t_marks[7];
	string s_name[7];
	double marks[7];
	double  cgpa[7];

// structures
struct std_data{
	string name,cms_id,f_name;
};

// function declarations
void f_interface(char& choice);
//preconditions: The function will simply show an interface, and show a short menu
//postconditions: The values were inserted and output was shown according to choice
void collectinfo(std_data& std);
//preconditions: The function will simply show a short form to be filled
//postconditions: The values were inserted and stored in variables
void listofdept(int& dept, char& mainmenu);
//preconditions: The function will simply show a list of Degree programs
//that are being offered in SIBA University
//postconditions: The value were inserted and output was shown according to choice
void listofsem(int& sem, char& mainmenu);
//preconditions: The function will simply show a list of Semester numbers
//postconditions: The value were inserted and output was shown according to choice
void loadSubjects(int dept, int sem);
//preconditions: The function will simply take dept and sem
//postconditions: Arrays of subjects will be initialized according to sem and dept
void gettinginput(int num, int sem, double& l_gpa);
//preconditions: The function will simply show subject names and user will be prompted to insert marks
//postconditions: The marks are stored in the variables
void marksheet(int num, int sem, double l_gpa, const string& name, const string& cms, const string& filename);
//preconditions: The function will simply calculate results and then show it on screen
//postconditions: The marksheet is shown in output with every detail
void exit_restart(char& choice);
//preconditions: The function will show the last screen and show a short menu again to restart or exit
//postconditions: The function will be completed according to choice

//main function
int main() {
    int num = 0, d_choice = 0, s_choice = 0;
    double last_gpa = 0.0;
    char mainmenu = '\0', f_choice = '\0';
    std_data student1; // structure for student info

    // First Interface Screen
    while (true) {
    main_menu:
        f_interface(f_choice);
        system("CLS");

        if (f_choice == 'e') {
            cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t"
                 << "Thanks for using our program!"
                 << endl << "\t\t\t\t\t";
            system("PAUSE");
            return 0;
        } else if (f_choice == 'g') {
            break; // go to next step
        }
    }

    // Collecting student info
    collectinfo(student1);
    system("CLS");

    // Second Interface Screen - Degree Selection
    do {
        listofdept(d_choice, mainmenu);
        system("CLS");
        if (mainmenu == 'm') {
            mainmenu = '\0';
            goto main_menu;
        }
    } while (d_choice < 1 || d_choice > 9);

    // Third Interface Screen - Semester Selection
    do {
        listofsem(s_choice, mainmenu);
        system("CLS");
        if (mainmenu == 'm') {
            mainmenu = '\0';
            goto main_menu;
        }
    } while (s_choice < 1 || s_choice > 8);

    // Fourth Interface Screen - Load subjects
	loadSubjects(d_choice,s_choice);

    // Determine number of subjects based on degree & semester
	if(d_choice == 1 || d_choice == 2 || d_choice == 3) //BSCS, BSSE & BSAI
		switch(s_choice){
			case 1:
			case 2:
			case 3:	
			num = 7;
			break;
			case 4:
			case 5:
			case 6:
			case 7:
			num = 6;
			break;
			case 8:
			num = 4;
			break;
		}
		else if(d_choice == 4) //BBA
		switch(s_choice){
			case 1:
				num = 7;
				break;			
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				num = 6;
				break;
			case 8:
				num = 5;
				break;
		}
		else if(d_choice == 5) //BSAF
		switch(s_choice){
			case 1:
			case 3:
			case 4:
			case 5:
			case 6:
				num = 6;
			break;
			case 2:
			case 7:			
				num = 5;
			break;
			case 8:
				num = 1;
			break;
		}
		else if(d_choice == 6) //BEd
		switch(s_choice){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				num = 6;
			break;
			case 8:
				num = 4;
			break;
		}
		else if(d_choice == 7) //BSMC
		switch(s_choice){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				num = 6;
				break;
			case 6:
			case 7:
			case 8:
				num = 5;
				break;
		}
		else if(d_choice == 8) //BSMath
		switch(s_choice){
			case 1:
				num = 7;
				break;
			case 3:
				num = 6;
				break;
			case 2:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				num = 5;
				break;
		}
		else if(d_choice == 9) //BEE
		switch(s_choice){
			case 1:
			case 2:
			case 7:
				num = 6;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				num = 5;
				break;
			case 8:
				num = 4;
				break;
		}

    // Getting marks from user
    gettinginput(num, s_choice, last_gpa);
    system("CLS");

    // Validate marks (must be positive)
    int count = 0;
    for (int i = 0; i < num; i++) {
        if (marks[i] == 0) count++;
    }

    if (count != 0) {
        system("CLS");
        cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
             << "\t\t\t   You should at least know that marks must be positive numbers\n"
             << "\t   Exiting program because you are not considered a valid student.\n"
             << "\t\t\t\t\t\tGood Bye\n";
        return 0;
    }

    // Fifth Interface Screen - Generate marksheet
    marksheet(num, s_choice, last_gpa, student1.name, student1.cms_id, student1.f_name);
    system("PAUSE");

    // Last Interface - Exit or Restart
    while (true) {
        exit_restart(f_choice);
        system("CLS");
        if (f_choice == 'e') {
            cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t"
                 << "Thanks for using our program!"
                 << endl << "\t\t\t\t\t";
            system("PAUSE");
            return 0;
        } else if (f_choice == 'm') {
            goto main_menu;
        }
    }

    return 0;
}

// Functions
void f_interface(char& choice) {
    cout << "\n";
    cout << "\t\t\t\t=====================================================\n\n";
    cout << "\t\t\t\t **********   ***********   *********       ********  \n";
    cout << "\t\t\t\t|                  |        |        |     |        | \n";
    cout << "\t\t\t\t|                  |        |        |     |        | \n";
    cout << "\t\t\t\t|                  |        |       /      |        | \n";
    cout << "\t\t\t\t *********         |        ********       ********** \n";
    cout << "\t\t\t\t          |        |        |       \\      |        | \n";
    cout << "\t\t\t\t          |        |        |        |     |        | \n";
    cout << "\t\t\t\t          |        |        |        |     |        | \n";
    cout << "\t\t\t\t *********   ************   *********      *        * \n\n";
    cout << "\t\t\t\t=====================================================\n";
    cout << "\t\t\t\t            U  N  I  V  E  R  S  I  T  Y\n";
    cout << "\t\t\t\t=====================================================\n\n";
    cout << "\t\t\t\t*****************************************************\n";
    cout << "\t\t\t\t        M A R K S H E E T   G E N E R A T O R\n";
    cout << "\t\t\t\t*****************************************************\n";
    cout << "\t\t\t\t\t\tG. Generate Marksheet\n";
    cout << "\t\t\t\t\t\tE. Exit The Program\n\n";
    cout << "\t\t\t\t\t\tEnter your choice: ";

    string input;
    getline(cin, input);

    choice = '0'; // default invalid choice

    if (input.length() == 1) {
        char c = tolower(input[0]);
        if (c == 'g' || c == 'e') {
            choice = c;
        } else {
            system("CLS");
            cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
            system("PAUSE");
        }
    } else {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
    }
}

void collectinfo(std_data& student) {
    cout << "\n\n\n\n\n\n"
         << "\t\t\t   -----------------------------------------------------------\n";

    cout << "\n\t\t\t\t\tEnter Your Name     : ";
    getline(cin, student.name);

    cout << "\n\t\t\t\t\tEnter Your CMS-ID   : ";
    getline(cin, student.cms_id);

    cout << "\n\t\t\t\t\tEnter File Name     : ";
    getline(cin, student.f_name);

    cout << "\t\t\t   ___________________________________________________________\n";
    cout << "\n\n\t\t\t\t\t";
    system("PAUSE");
}

void listofdept(int& dept, char& mainmenu) {
    cout << "\n\n\t\t\t\t\tSELECT YOUR DEGREE PROGRAM\n\n\n\n";
    cout << "\t\t\t ==> 1. BS Computer Science\n"
         << "\t\t\t ==> 2. BS Software Engineering\n"
         << "\t\t\t ==> 3. BS Artificial Intelligence\n"
         << "\t\t\t ==> 4. BBA (Business Administration)\n"
         << "\t\t\t ==> 5. BS Accounting & Finance\n"
         << "\t\t\t ==> 6. BEd (Education)\n"
         << "\t\t\t ==> 7. BS Media & Communication\n"
         << "\t\t\t ==> 8. BS Mathematics\n"
         << "\t\t\t ==> 9. BEE (Electrical Engineering)\n"
         << "\t\t\t ==> M. Main Menu\n\n";
    cout << "\t\tPlease enter your Choice = ";

    string input;
    getline(cin, input);

    dept = 0;
    mainmenu = '\0';

    if (input.length() != 1) {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
        return;
    }

    char choice = tolower(input[0]);
    if (choice == 'm') {
        mainmenu = 'm';
    } else if (choice >= '1' && choice <= '9') {
        dept = choice - '0';
    } else {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
    }
}

void listofsem(int& sem, char& mainmenu) {
    cout << "\n\n\t\t\t\t\t\tSELECT YOUR SEMESTER\n\n\n\n";
    cout << "\t\t\t ==> 1. 1ST SEMESTER\n"
         << "\t\t\t ==> 2. 2ND SEMESTER\n"
         << "\t\t\t ==> 3. 3RD SEMESTER\n"
         << "\t\t\t ==> 4. 4TH SEMESTER\n"
         << "\t\t\t ==> 5. 5TH SEMESTER\n"
         << "\t\t\t ==> 6. 6TH SEMESTER\n"
         << "\t\t\t ==> 7. 7TH SEMESTER\n"
         << "\t\t\t ==> 8. 8TH SEMESTER\n"
         << "\t\t\t ==> M. Main Menu\n\n";
    cout << "\t\tPlease enter your Choice = ";

    string input;
    getline(cin, input);

    sem = 0;
    mainmenu = '\0';

    if (input.length() != 1) {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
        return;
    }

    char choice = tolower(input[0]);
    if (choice == 'm') {
        mainmenu = 'm';
    } else if (choice >= '1' && choice <= '8') {
        sem = choice - '0';
    } else {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
    }
}

void loadSubjects(int dept, int sem) {
    // Clear previous values
    for (int i = 0; i < 7; i++) {
        s_name[i] = "";
        t_marks[i] = 0;
        c_hours[i] = 0;
    }

    switch (dept) {
    	case 1: // BSCS
		    switch(sem) {
		        case 1:
		            s_name[0] = "Programming Fundamentals Theory  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Discrete structure               "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Functional English               "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Application of ICT               "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Islamiat/Ethics                  "; t_marks[4] = 50;  c_hours[4] = 2;
		            s_name[5] = "Programming Fundamentals LAB     "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Application of ICT LAB           "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 2:
		            s_name[0] = "Object Oriented Programming (T)  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Database Systems                 "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Applied Physics                  "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Calculus and Analytic Geometry   "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Expository Writing               "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Object Oriented Programming (L)  "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Database System (L)              "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 3:
		            s_name[0] = "Data Structures                  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Multivariate Calculus            "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Digital Logic Design             "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Computer Networks                "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Software Engineering             "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Ideology and Constituion of Pak  "; t_marks[5] = 50;  c_hours[5] = 2;
		            s_name[6] = "Data Structure (L)               "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 4:
		            s_name[0] = "Computer Org. & Assembly lang.   "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Theory of Automata               "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Advanced DBMS                    "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Artificial Intelligence          "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Information Security             "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Probability and Statistics       "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 5:
		            s_name[0] = "Operating Systems                "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Compiler Constructions           "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Computer Architecture            "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Elective-I                       "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Elective-II                      "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Linear Algebra                   "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 6:
		            s_name[0] = "HCI and Computer Graphics        "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Parallel & Distributed Computing "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Elective-III                     "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Elective-IV                      "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Analysis of Algorithms           "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Technical & Business Writing     "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 7:
		            s_name[0] = "Final year Project -I            "; t_marks[0] = 50;  c_hours[0] = 2;
		            s_name[1] = "Elective-V                       "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Elective-VI                      "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Elective-VII                     "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Elective Supporting Course       "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Entrepreneurship                 "; t_marks[5] = 50;  c_hours[5] = 2;
		            break;
		        case 8:
		            s_name[0] = "Final Year Project-II            "; t_marks[0] = 100; c_hours[0] = 4;
		            s_name[1] = "Social Science-I                 "; t_marks[1] = 100; c_hours[1] = 2;
		            s_name[2] = "Arts & Humanities                "; t_marks[2] = 100; c_hours[2] = 2;
		            s_name[3] = "Civics and Community Engagement  "; t_marks[3] = 100; c_hours[3] = 2;
		            break;
		    }
	    break;
	    case 2: // BSSE
		    switch(sem) {
		        case 1:
		            s_name[0] = "Programming Fundamentals Theory  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Dicrete structure                "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Functional English               "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Application of ICT               "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Islamiat/Ethics                  "; t_marks[4] = 50;  c_hours[4] = 2;
		            s_name[5] = "Programming Fundamentals LAB     "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Application of ICT LAB           "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 2:
		            s_name[0] = "Object Oriented Programming (T)  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Database Systems                 "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Applied Physics                  "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Calculus and Analytic Geometry   "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Expository Writing               "; t_marks[4] = 50;  c_hours[4] = 3;
		            s_name[5] = "Object Oriented Programming (L)  "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Database System (L)              "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 3:
		            s_name[0] = "Data Structures                  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Multivariate Calculus            "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Digital Logic Design             "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Computer Networks                "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Software Engineering             "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Ideology and Constituion of Pak  "; t_marks[5] = 50;  c_hours[5] = 2;
		            s_name[6] = "Data Structure (L)               "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 4:
		            s_name[0] = "Computer Org. & Assembly lang.   "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Software Quality Engineering     "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Software Requirment Engineering  "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Artificial Intelligence          "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Information Security             "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Probability and Statistics       "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 5:
		            s_name[0] = "Operating System                 "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Software Quality Engineering     "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Software Req. Engineering        "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Domain Elective-I                "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Domain Elective-II               "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Linear Algebra                   "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 6:
		            s_name[0] = "Software Project Management      "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Parallel & Distributed Computing "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Domain Elective III              "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Domain Elective IV               "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Technical & Business Writing     "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Analysis of Algorithm            "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 7:
		            s_name[0] = "Final year Project-I             "; t_marks[0] = 100; c_hours[0] = 2;
		            s_name[1] = "Domain Elective-V                "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Domain Elective-VI               "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Domain Elective-VII              "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Elective Supporting Course       "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Entrepreneurship                 "; t_marks[5] = 50;  c_hours[5] = 2;
		            break;
		        case 8:
		            s_name[0] = "Final Year Project-II            "; t_marks[0] = 100; c_hours[0] = 4;
		            s_name[1] = "Social Science-I                 "; t_marks[1] = 100; c_hours[1] = 2;
		            s_name[2] = "Arts & Humanities                "; t_marks[2] = 100; c_hours[2] = 2;
		            s_name[3] = "Civics and Community Engagement  "; t_marks[3] = 100; c_hours[3] = 2;
		            break;
		    }
	    break;
		case 3: // BSAI
		    switch(sem) {
		        case 1:
		            s_name[0] = "Programming Fundamentals Theory  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Discrete Structure               "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Functional English               "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Application of ICT               "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Islamiat/Ethics                  "; t_marks[4] = 50;  c_hours[4] = 2;
		            s_name[5] = "Programming Fundamentals LAB     "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Application of ICT LAB           "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 2:
		            s_name[0] = "Object Oriented Programming (T)  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Database Systems                 "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Applied Physics                  "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Calculus and Analytic Geometry   "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Expository Writing               "; t_marks[4] = 50;  c_hours[4] = 3;
		            s_name[5] = "Object Oriented Programming (L)  "; t_marks[5] = 50;  c_hours[5] = 1;
		            s_name[6] = "Database System (L)              "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 3:
		            s_name[0] = "Data Structures                  "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Multivariate Calculus            "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Digital Logic Design             "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Computer Networks                "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Software Engineering             "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Ideology and Constitution of Pakistan"; t_marks[5] = 50;  c_hours[5] = 2;
		            s_name[6] = "Data Structure (L)               "; t_marks[6] = 50;  c_hours[6] = 1;
		            break;
		        case 4:
		            s_name[0] = "Computer Org. & Assembly Language       "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Programming for AI                   "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Knowledge Representation & Reasoning "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Artificial Intelligence              "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Information Security                 "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Probability and Statistics           "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 5:
		            s_name[0] = "Operating Systems                 "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Domain Core 3 (Computer Vision)   "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Domain Core 4 (Machine Learning)  "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Domain Elective 1                 "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Domain Elective 2                 "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Linear Algebra                    "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 6:
		            s_name[0] = "Artificial Neural Networks & Deep Learning       "; t_marks[0] = 100; c_hours[0] = 3;
		            s_name[1] = "Domain Core 6 (Parallel & Distributed Computing) "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Domain Elective 3                                "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Domain Elective 4                                "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Analysis of Algorithms                           "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Technical & Business Writing                     "; t_marks[5] = 100; c_hours[5] = 3;
		            break;
		        case 7:
		            s_name[0] = "Final Year Project-I            "; t_marks[0] = 100; c_hours[0] = 2;
		            s_name[1] = "Elective-V                       "; t_marks[1] = 100; c_hours[1] = 3;
		            s_name[2] = "Elective-VI                      "; t_marks[2] = 100; c_hours[2] = 3;
		            s_name[3] = "Elective-VII                     "; t_marks[3] = 100; c_hours[3] = 3;
		            s_name[4] = "Elective Supporting Course       "; t_marks[4] = 100; c_hours[4] = 3;
		            s_name[5] = "Entrepreneurship                 "; t_marks[5] = 50;  c_hours[5] = 2;
		            break;
		        case 8:
		            s_name[0] = "Final Year Project-II            "; t_marks[0] = 100; c_hours[0] = 4;
		            s_name[1] = "Social Science                   "; t_marks[1] = 100; c_hours[1] = 2;
		            s_name[2] = "Arts & Humanities                "; t_marks[2] = 100; c_hours[2] = 2;
		            s_name[3] = "Civics and Community Engagement  "; t_marks[3] = 100; c_hours[3] = 2;
		            break;
		    }
	    break;
		case 4: // BBA
		    switch(sem) {
		        case 1:
		            s_name[0] = "Functional English               "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "College Algebra                  "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Human Behavior                   "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Principles of Microeconomics     "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Computer Application to Business "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Pakistan Studies                 "; t_marks[5]=50;  c_hours[5]=2;
		            s_name[6] = "Islamic Studies/Ethics           "; t_marks[6]=50;  c_hours[6]=2;
		            break;
		        case 2:
		            s_name[0] = "Principles of Macroeconomics      "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Creative Writing                  "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Optional 01: (Languages)          "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Social Psychology and Self-Dev.   "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Principles of Accounting          "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Business Statistics               "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 3:
		            s_name[0] = "Introduction to Business Finance  "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Principles of Management          "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Social Sciences & Thinking        "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Principles of Marketing           "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Business Mathematics              "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Corporate Accounting              "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 4:
		            s_name[0] = "Organizational Behavior                "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Business Communication                 "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Optional 03: (Digital Technologies)    "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Financial Institutions and Markets     "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Business Calculus                      "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Development Economics                  "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 5:
		            s_name[0] = "Business Law                    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Islamic Economics and Finance   "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Marketing Management            "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Human Resources Management      "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Statistical Inferences          "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Entrepreneurship                "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 6:
		            s_name[0] = "Managerial Accounting                   "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Laws of Taxation                        "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Methods of Business Research            "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Production and Operations Management    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Business Ethics and CSR (Merged)        "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Elective I                              "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 7:
		            s_name[0] = "International Business    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Agribusiness              "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Basic Econometrics        "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Financial Management      "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Elective II               "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Elective III              "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 8:
		            s_name[0] = "Comparative Management             "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "G. Optional: 03 (Digital Tech.)    "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Business Strategy                  "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Elective IV                        "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Elective V                         "; t_marks[4]=100; c_hours[4]=3;
		            break;
		    }
		break;
		case 5: // BSAF
		    switch(sem) {
		        case 1:
		            s_name[0] = "Functional English                      "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Pakistan Studies/Islamiat              "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Principles of Microeconomics            "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Business Mathematics                    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Introduction to Information Technology  "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Fundamentals of Financial Accounting    "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 2:
		            s_name[0] = "Principles of Management      "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Principles of Macroeconomics  "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "English Composition           "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Mercantile Laws               "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Business Statistics           "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 3:
		            s_name[0] = "Principles of Marketing               "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Intermediate Financial Accounting     "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Introduction to Management Accounting "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Organization Behavior                 "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Introduction to Business Finance      "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Statistical Inference                  "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 4:
		            s_name[0] = "Fundamentals of Auditing                  "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Principles of Taxation                    "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Company laws (255 Sections)               "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Financial Institution and Markets         "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Business Research Methods                 "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Business Communication & Report Writing   "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 5:
		            s_name[0] = "Corporate Financial Reporting             "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Business Ethics                           "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Management Accounting & Control System    "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Intermediate Business Finance             "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Banking Operations                        "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Advanced Taxation                         "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 6:
		            s_name[0] = "Human Resource Management                        "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Marketing Management                             "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Applied Corporate Laws & Secretarial Practices   "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Auditing & Assurance and Related Services        "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Corporate Risk Management                        "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Advanced Corporate Financial Reporting           "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 7:
		            s_name[0] = "Management Accounting-Decision Making  "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Analysis of Financial Statements       "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Applied Financial Management           "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Financial Information System           "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Strategic Business Management          "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 8:
		            s_name[0] = "Practicum  "; t_marks[0]=100; c_hours[0]=6;
		            break;
		    }
	    break;
	    case 6: // BEd
		    switch(sem) {
		        case 1:
		            s_name[0] = "English – I           "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "General Science       "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "General Mathematics   "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Methods of Teaching   "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Islamiat/Ethics       "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Computer Literacy – I "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 2:
		            s_name[0] = "English – II            "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Bio–I OR Math–I        "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Chem–I OR Phy–I        "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "Classroom Management    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Urdu/Sindhi             "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Pakistan Studies        "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 3:
		            s_name[0] = "English (Content) – III  "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Bio–II OR Math–II        "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Chem–II OR Phy–II        "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "ICT in Education         "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Teaching of Pak Std.     "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Teaching Practice        "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 4:
		            s_name[0] = "English (P) – I              "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Bio (P) – I OR Math (P) – I "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Chem (P) – I OR Phy (P) – I "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Child Development            "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Classroom Assessment         "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Teaching Practice            "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 5:
		            s_name[0] = "English (Content) – IV           "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Bio – III OR Math – III          "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Chem – III OR Phy – III          "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "School, Community and Teacher    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Educational Psychology           "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Teaching Literacy                "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 6:
		            s_name[0] = "English (P) – II                 "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Bio (P) – II OR Math (P) – II   "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Chem (P) – II OR Phy (P) – II   "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Curriculum Development           "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Research Methods in Education    "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Teaching Practice                "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 7:
		            s_name[0] = "Contemporary Issues and Trends in Edu. "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Foundations of Edu.                    "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Test Dev. & Evaluation                 "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Comparative Education                  "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Teaching Practice                      "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Guidance & Counseling                  "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 8:
		            s_name[0] = "Educational Leadership & Management    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "School Improvement & Management        "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Edu. Research Project (Individual)     "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Teaching Practice (Long Term)          "; t_marks[3]=100; c_hours[3]=3;
		            break;
		    }
	    break;
		case 7: // BSMC
		    switch(sem) {
		        case 1:
		            s_name[0] = "Functional English                 "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Islamic Studies                    "; t_marks[1]=50;  c_hours[1]=2;
		            s_name[2] = "Pakistan Affairs                   "; t_marks[2]=50;  c_hours[2]=2;
		            s_name[3] = "Introduction to Multimedia         "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Introduction to Mass Communication "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Introduction to Int. Relations     "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 2:
		            s_name[0] = "Communication Skills               "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Introduction to Sociology          "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Mathematics for Liberal Arts       "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Storytelling in Digital Age        "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Personal Development               "; t_marks[4]=50;  c_hours[4]=3;
		            s_name[5] = "Photography                        "; t_marks[5]=50;  c_hours[5]=3;
		            break;
		        case 3:
		            s_name[0] = "Tech. Report and PPT Skills        "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Computer Skills                     "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Introduction to Psychology          "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Media Psychology                    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Mass Media & Society                "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Introduction to Broadcast           "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 4:
		            s_name[0] = "English for Journalism             "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Digital Audio/Video                 "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Intro to Adv. & Public Relations    "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Contemporary World Media           "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Social Media Networks Culture      "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Introduction to Film and Theatre    "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 5:
		            s_name[0] = "Theories of Mass Communication I    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Journalistic Urdu/Functional Urdu   "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Opinion Writing                     "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Introduction to Philosophy & Thought"; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Media Laws and Ethics               "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "International Communication         "; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 6:
		            s_name[0] = "Theories of Mass Communication II     "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Development Communication             "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Intro to Conflict Reporting           "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Intro to Innovation & Entrepreneurship"; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Sindhi Journalism                     "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 7:
		            s_name[0] = "Current Affairs    "; t_marks[0]=50;  c_hours[0]=2;
		            s_name[1] = "Media Management   "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Online Journalism  "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Elective I         "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Elective II        "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 8:
		            s_name[0] = "Research Project and Internship "; t_marks[0]=100; c_hours[0]=4;
		            s_name[1] = "Academic Writing and P. Writing "; t_marks[1]=100; c_hours[1]=2;
		            s_name[2] = "Regional Mass Media             "; t_marks[2]=100; c_hours[2]=2;
		            s_name[3] = "Elective III                    "; t_marks[3]=100; c_hours[3]=2;
		            s_name[4] = "Elective IV                     "; t_marks[4]=100; c_hours[4]=2;
		            break;
		    }
	    break;
		case 8: // BSMath
		    switch(sem) {
		        case 1:
		            s_name[0] = "Calculus – I                     "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Mathematical Thinking            "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Functional English               "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Introduction to ICT              "; t_marks[3]=100; c_hours[3]=2;
		            s_name[4] = "Introduction to Statistics       "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Islamic Studies/Ethics           "; t_marks[5]=50;  c_hours[5]=2;
		            s_name[6] = "Introduction to ICT (PR)         "; t_marks[6]=50;  c_hours[6]=1;
		            break;
		        case 2:
		            s_name[0] = "Calculus – II                     "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Linear Algebra – I                "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Applied Physics – I               "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Introduction to Language (C++)    "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Pakistan Studies                  "; t_marks[4]=50;  c_hours[4]=2;
		            break;
		        case 3:
		            s_name[0] = "Calculus – III                     "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Linear Algebra – II                "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Theory of Probability              "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Computing Tools for Mathematics    "; t_marks[3]=100; c_hours[3]=1;
		            s_name[4] = "Applied Physics – II               "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Communication & Presentation Skills"; t_marks[5]=100; c_hours[5]=3;
		            break;
		        case 4:
		            s_name[0] = "Real Analysis                     "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Introduction to Topology          "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Mathematics of Data Science       "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Introduction to Sociology         "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Technical Writing                 "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 5:
		            s_name[0] = "Functional Analysis               "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Complex Analysis                  "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Ordinary Differential Equations   "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Group Theory                       "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Numerical Analysis – I             "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 6:
		            s_name[0] = "Partial Differential Equations    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Classical Mechanics               "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Theory of Curves and Surfaces     "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Elective – I                       "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Elective – II                      "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 7:
		            s_name[0] = "Numerical Analysis – II           "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Elective – III                     "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Elective – IV                      "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Elective – V                       "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Final Year Project – I             "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 8:
		            s_name[0] = "Elective – VI                      "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Elective – VII                     "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Elective – VIII                    "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Elective – IX                      "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Final Year Project – II            "; t_marks[4]=100; c_hours[4]=3;
		            break;
		    }
	    break;
		case 9: // BEE
		    switch(sem) {
		        case 1:
		            s_name[0] = "Introduction to Computing         "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Workshop Practice                 "; t_marks[1]=50;  c_hours[1]=1;
		            s_name[2] = "Functional English                "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Pakistan Studies                  "; t_marks[3]=50;  c_hours[3]=2;
		            s_name[4] = "Calculus and Analytical Geometry  "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Applied Physics                   "; t_marks[5]=100; c_hours[5]=4;
		            break;
		        case 2:
		            s_name[0] = "Communication & Presentation Skills"; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Linear Algebra & Differential Equations"; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Islamic Studies/Ethics            "; t_marks[2]=50;  c_hours[2]=2;
		            s_name[3] = "Linear Circuit Analysis           "; t_marks[3]=100; c_hours[3]=4;
		            s_name[4] = "Programming for Engineers         "; t_marks[4]=100; c_hours[4]=4;
		            s_name[5] = "Computer Aided Design             "; t_marks[5]=50;  c_hours[5]=1;
		            break;
		        case 3:
		            s_name[0] = "Multivariable Calculus            "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Applied Thermodynamics            "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Electrical Network Analysis       "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "Digital Logic Design              "; t_marks[3]=100; c_hours[3]=4;
		            s_name[4] = "Electronic Devices and Circuits   "; t_marks[4]=100; c_hours[4]=4;
		            break;
		        case 4:
		            s_name[0] = "Complex Variables & Transforms    "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Introduction to Embedded Systems  "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Electromagnetics Field Theory     "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Electronic Circuit Design         "; t_marks[3]=100; c_hours[3]=4;
		            s_name[4] = "Object Oriented Programming       "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 5:
		            s_name[0] = "Probability and Statistics        "; t_marks[0]=100; c_hours[0]=3;
		            s_name[1] = "Electrical Machines               "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Instrumentation and Measurement   "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "Signals and Systems               "; t_marks[3]=100; c_hours[3]=4;
		            s_name[4] = "Organizational Behavior           "; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 6:
		            s_name[0] = "Power Electronics                 "; t_marks[0]=100; c_hours[0]=4;
		            s_name[1] = "Control Systems                   "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Communication Systems             "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "Health, Safety & Environment      "; t_marks[3]=100; c_hours[3]=3;
		            s_name[4] = "Engineering Economics & Management"; t_marks[4]=100; c_hours[4]=3;
		            break;
		        case 7:
		            s_name[0] = "Technical Writing                 "; t_marks[0]=50;  c_hours[0]=2;
		            s_name[1] = "Elective – I                       "; t_marks[1]=100; c_hours[1]=3;
		            s_name[2] = "Elective – II                      "; t_marks[2]=100; c_hours[2]=4;
		            s_name[3] = "Elective – III                     "; t_marks[3]=100; c_hours[3]=4;
		            s_name[4] = "Engineering Entrepreneurship       "; t_marks[4]=100; c_hours[4]=3;
		            s_name[5] = "Final Year Project – I             "; t_marks[5]=50;  c_hours[5]=2;
		            break;
		        case 8:
		            s_name[0] = "Elective – IV                      "; t_marks[0]=100; c_hours[0]=4;
		            s_name[1] = "Elective – V                       "; t_marks[1]=100; c_hours[1]=4;
		            s_name[2] = "Project Management                 "; t_marks[2]=100; c_hours[2]=3;
		            s_name[3] = "Final Year Project – II            "; t_marks[3]=100; c_hours[3]=4;
		            break;
		    }
	    break;
    }
}

void gettinginput(int num, int sem, double& l_gpa) {
    cout << "\n\t\t\t\t\t\tEnter Marks Below\n\n";

    for (int i = 0; i < num; i++) {
        while (true) {
            cout << "\t\t\t ==> " << i + 1 << ". " << s_name[i] << ":    ";
            cin >> marks[i];

            if (cin.fail()) { // Handle non-numeric input
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "\t\t\t\tInvalid input! Please enter a numeric value.\n";
                continue;
            }

            if (marks[i] < 0 || marks[i] > t_marks[i]) {
                cout << "\t\t\t\tMarks Out of Range! Maximum marks: " << t_marks[i] << "\n";
                continue;
            }

            break; // valid input, exit loop
        }
    }

    // For semesters beyond 1, ask for last GPA
    if (sem > 1) {
        while (true) {
            cout << "\t\t\t\t ==> Enter your last Semester GPA: ";
            cin >> l_gpa;

            if (cin.fail()) {
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "\t\t\t\tInvalid input! Enter a numeric GPA between 0 and 4.\n";
                continue;
            }

            if (l_gpa < 0.0 || l_gpa > 4.0) {
                cout << "\t\t\t\tInvalid GPA! Enter a value between 0 and 4.\n";
                continue;
            }

            break; // valid GPA
        }
    }
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

void marksheet(int num, int sem, double l_gpa, const string& name, const string& cms, const string& filename) {
    double per[7], scgpa;
    double t_hours = 0.0, t_grade = 0.0;

    cout << "\n    ****************************************************"
         << "*******************************************************\n";
    cout << "\t\t\t\t\t\t    MARKSHEET\n";
    cout << "    ****************************************************"
         << "*******************************************************\n\n";
    cout << "\t Name   : " << name << "\n\n";
    cout << "\t CMS-ID : " << cms << "\n\n";

    cout << "    ****************************************************"
         << "*******************************************************\n";
    cout << left << "      " << setw(8) << "S.NO" 
         << setw(54) << "SUBJECT NAMES"
         << setw(12) << "T. Marks" 
         << setw(14) << "O. Marks" 
         << setw(10) << "CGPA" 
         << setw(10) << "Per%" << "\n\n";

    for (int i = 0; i < num; i++) {
        per[i] = (marks[i] / t_marks[i]) * 100;

        // Calculate subject CGPA based on percentage
        if (per[i] < 60) scgpa = 0.00;
        else if (per[i] < 64) scgpa = 1.67;
        else if (per[i] < 68) scgpa = 2.00;
        else if (per[i] < 72) scgpa = 2.30;
        else if (per[i] < 77) scgpa = 2.67;
        else if (per[i] < 82) scgpa = 3.00;
        else if (per[i] < 87) scgpa = 3.33;
        else if (per[i] < 93) scgpa = 3.67;
        else scgpa = 4.0;

        cgpa[i] = scgpa;

        cout << left << "      " << setw(8) << i + 1
             << setw(54) << s_name[i]
             << setw(12) << t_marks[i]
             << setw(14) << fixed << setprecision(2) << marks[i]
             << setw(10) << fixed << setprecision(2) << scgpa
             << fixed << setprecision(1) << per[i] << "%\n\n";

        t_grade += cgpa[i] * c_hours[i];
        t_hours += c_hours[i];
    }

    t_grade = t_grade / t_hours;

    if (sem > 1) {
        t_grade = (t_grade + l_gpa) / 2.0;
    }

    cout << "    ****************************************************"
         << "*******************************************************\n";
    cout << "\n     ==> Total CGPA	  : " << fixed << setprecision(3) << t_grade << "\n";

    // Writing to file
	string outputFile = filename + ".txt";
	ofstream out(outputFile.c_str());
	if (!out) {
	    cerr << "\nError creating file!\n";
	    return;
	}

    out << "    ***********************************************************************************************************\n"
        << "\t\t\t\t\t\t    MARKSHEET\n"
        << "    ***********************************************************************************************************\n\n"
        << "\t Name   : " << name << "\n\n"
        << "\t CMS-ID : " << cms << "\n\n"
        << "    ***********************************************************************************************************\n"
        << left << "      " << setw(8) << "S.NO"
        << setw(54) << "SUBJECT NAMES"
        << setw(12) << "T. Marks"
        << setw(14) << "O. Marks"
        << setw(10) << "CGPA"
        << setw(10) << "Per%" << "\n\n";

    for (int i = 0; i < num; i++) {
        out << left << "      " << setw(8) << i + 1
            << setw(54) << s_name[i]
            << setw(12) << t_marks[i]
            << setw(14) << fixed << setprecision(2) << marks[i]
            << setw(10) << fixed << setprecision(2) << cgpa[i]
            << fixed << setprecision(1) << per[i] << "%\n\n";
    }

    out << "    ***********************************************************************************************************\n";
    out << "\n     ==> Total CGPA	  : " << fixed << setprecision(3) << t_grade << "\n";
}

void exit_restart(char& choice) {
    cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Clear input buffer
    system("CLS");

    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
         << "\t\t\tYour Marksheet has been generated in a text file with the file name you provided.\n\n";
    cout << "\t\t\t\t\t\tM. Main Menu\n";
    cout << "\t\t\t\t\t\tE. Exit The Program\n";
    cout << "\n\t\t\t\t\t\tEnter your choice: ";

    string input;
    getline(cin, input);

    choice = '\0';

    if (input.length() != 1) {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
        return;
    }

    char ch = tolower(input[0]);
    if (ch == 'm') {
        choice = 'm';
    } else if (ch == 'e') {
        choice = 'e';
    } else {
        system("CLS");
        cout << "\n\t\t\t\tInvalid Choice! Press Enter to choose again\n";
        system("PAUSE");
    }
}
