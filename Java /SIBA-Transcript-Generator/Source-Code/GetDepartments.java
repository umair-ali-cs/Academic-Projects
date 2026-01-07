public class GetDepartments {
    String subject[];
    int credit[];
    int total[];
    int prev_cr;

    public int getPrevCredits(String dept, int sem) {
        prev_cr = 0;
        for (int i = 1; i < sem; i++) {
            getDept(dept, i);
            for (int j = 0; j < credit.length; j++) {
                prev_cr += credit[j];
            }
        }
        return prev_cr;
    }

    public void getDept(String dept, int sem) {
        if ((dept.equals("Software Engineering") || dept.equals("Artificial Intelligence")) && sem <= 4) {
            dept = "Computer Science";
        }

        if (dept.equals("Computer Science")) {
            switch (sem) {
                case 1: {
                    subject = new String[7];
                    credit = new int[7];
                    total = new int[7];

                    subject[0] = "Programming Fundamentals Theory  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Discrete structure               ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Functional English               ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Application of ICT               ";
                    total[3] = 100;
                    credit[3] = 2;
                    subject[4] = "Islamiat/Ethics                  ";
                    total[4] = 50;
                    credit[4] = 2;
                    subject[5] = "Programming Fundamentals LAB     ";
                    total[5] = 50;
                    credit[5] = 1;
                    subject[6] = "Application of ICT LAB           ";
                    total[6] = 50;
                    credit[6] = 1;
                    break;
                }
                case 2: {
                    subject = new String[8];
                    credit = new int[8];
                    total = new int[8];

                    subject[0] = "Object Oriented Programming (T)  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Database Systems                 ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Applied Physics                  ";
                    total[2] = 100;
                    credit[2] = 2;
                    subject[3] = "Calculus and Analytic Geometry   ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Expository Writing               ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Object Oriented Programming (L)  ";
                    total[5] = 50;
                    credit[5] = 1;
                    subject[6] = "Database System (L)              ";
                    total[6] = 50;
                    credit[6] = 1;
                    subject[7] = "Applied Physics (L)              ";
                    total[7] = 50;
                    credit[7] = 1;
                    break;
                }
                case 3: {
                    subject = new String[9];
                    credit = new int[9];
                    total = new int[9];

                    subject[0] = "Data Structures                  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Software Engineering             ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Multivariate Calculus            ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Computer Networks                ";
                    total[3] = 100;
                    credit[3] = 2;
                    subject[4] = "Digital Logic Design             ";
                    total[4] = 100;
                    credit[4] = 2;
                    subject[5] = "Ideology and Constitution of Pak ";
                    total[5] = 50;
                    credit[5] = 2;
                    subject[6] = "Data Structure (L)               ";
                    total[6] = 50;
                    credit[6] = 1;
                    subject[7] = "Computer Networks (L)            ";
                    total[7] = 50;
                    credit[7] = 1;
                    subject[8] = "Digital Logic Design (L)         ";
                    total[8] = 50;
                    credit[8] = 1;
                    break;
                }
                case 4: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Computer Org. & Assembly lang.   ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Theory of Automata               ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Advanced DBMS                    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Artificial Intelligence          ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Information Security             ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Probability and Statistics       ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 5: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Operating Systems                ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Compiler Constructions           ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Computer Architecture            ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-I                       ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective-II                      ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Linear Algebra                   ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 6: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "HCI and Computer Graphics        ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Parallel & Distributed Computing ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-III                     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-IV                      ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Analysis of Algorithms           ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Technical & Business Writing     ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 7: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Final year Project -I            ";
                    total[0] = 50;
                    credit[0] = 2;
                    subject[1] = "Elective-V                       ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-VI                      ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-VII                     ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective Supporting Course       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Entrepreneurship                 ";
                    total[5] = 50;
                    credit[5] = 2;
                    break;
                }
                case 8: {
                    subject = new String[4];
                    credit = new int[4];
                    total = new int[4];

                    subject[0] = "Final Year Project-II            ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Social Science-I                 ";
                    total[1] = 100;
                    credit[1] = 2;
                    subject[2] = "Arts & Humanities                ";
                    total[2] = 100;
                    credit[2] = 2;
                    subject[3] = "Civics and Community Engagement  ";
                    total[3] = 100;
                    credit[3] = 2;
                    break;
                }

                default: {
                    System.out.println("Hello switch is not working");
                }
            }
        } else if (dept.equals("Software Engineering")) {
            switch (sem) {
                case 5: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Operating System                 ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Software Quality Engineering     ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Software Req. Engineering        ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Domain Elective-I                ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Domain Elective-II               ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Linear Algebra                   ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 6: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Software Project Management      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Parallel & Distributed Computing ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Domain Elective III              ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Domain Elective IV               ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Technical & Business Writing     ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Analysis of Algorithm            ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 7: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Final year Project-I             ";
                    total[0] = 100;
                    credit[0] = 2;
                    subject[1] = "Domain Elective-V                ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Domain Elective-VI               ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Domain Elective-VII              ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective Supporting Course       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Entrepreneurship                 ";
                    total[5] = 50;
                    credit[5] = 2;
                    break;
                }

                case 8: {
                    subject = new String[4];
                    credit = new int[4];
                    total = new int[4];

                    subject[0] = "Final Year Project-II            ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Social Science-I                 ";
                    total[1] = 100;
                    credit[1] = 2;
                    subject[2] = "Arts & Humanities                ";
                    total[2] = 100;
                    credit[2] = 2;
                    subject[3] = "Civics and Community Engagement  ";
                    total[3] = 100;
                    credit[3] = 2;
                    break;
                }
            }
        } else if (dept.equals("Artificial Intelligence")) {
            switch (sem) {
                case 5: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Operating Systems                 ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Domain Core 3 (Computer Vision)   ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Domain Core 4 (Machine Learning)  ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Domain Elective 1                 ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Domain Elective 2                 ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Linear Algebra                    ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 6: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Artificial Neural Networks & Deep Learning       ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Domain Core 6 (Parallel & Distributed Computing) ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Domain Elective 3                                ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Domain Elective 4                                ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Analysis of Algorithms                           ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Technical & Business Writing                     ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 7: {
                    subject = new String[6];
                    credit = new int[6];
                    total = new int[6];

                    subject[0] = "Final year Project -I            ";
                    total[0] = 100;
                    credit[0] = 2;
                    subject[1] = "Elective-V                       ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-VI                      ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-VII                     ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective Supporting Course       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Entrepreneurship                 ";
                    total[5] = 50;
                    credit[5] = 2;
                    break;
                }

                case 8: {
                    subject = new String[4];
                    credit = new int[4];
                    total = new int[4];

                    subject[0] = "Final Year Project-II            ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Social Science                   ";
                    total[1] = 100;
                    credit[1] = 2;
                    subject[2] = "Arts & Humanities                ";
                    total[2] = 100;
                    credit[2] = 2;
                    subject[3] = "Civics and Community Engagement  ";
                    total[3] = 100;
                    credit[3] = 2;
                    break;
                }
            }

        } else if (dept.equals("Accounting and Finance")) {
            switch (sem) {
                case 1: {
                    subject = new String[7];
                    total = new int[7];
                    credit = new int[7];

                    subject[0] = "Functional English               ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "College Algebra                  ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Human Behavior                   ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Principles of Microeconomics     ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Computer Application to Business ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Pakistan Studies                 ";
                    total[5] = 50;
                    credit[5] = 2;
                    subject[6] = "Islamic Studies/Ethics           ";
                    total[6] = 50;
                    credit[6] = 2;
                    break;
                }

                case 2: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Principles of Macroeconomics      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Creative Writing                  ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Optional 01: (Languages)          ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Social Psychology and Self-Dev.   ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Principles of Accounting          ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Business Statistics               ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 3: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Introduction to Business Finance  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Principles of Management          ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Social Sciences & Thinking        ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Principles of Marketing           ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Business Mathematics              ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Corporate Accounting              ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 4: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Organizational Behavior                ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Business Communication                 ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Optional 03: (Digital Technologies)    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Financial Institutions and Markets     ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Business Calculus                      ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Development Economics                  ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 5: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Business Law                    ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Islamic Economics and Finance   ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Marketing Management            ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Human Resources Management      ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Statistical Inferences          ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Entrepreneurship                ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 6: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Managerial Accounting                   ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Laws of Taxation                        ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Methods of Business Research            ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Production and Operations Management    ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Business Ethics and CSR (Merged)        ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Elective I                              ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 7: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "International Business    ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Agribusiness              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Basic Econometrics        ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Financial Management      ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective II               ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Elective III              ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }

                case 8: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Comparative Management             ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "G. Optional: 03 (Digital Tech.)    ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Business Strategy                  ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective IV                        ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective V                         ";
                    total[4] = 100;
                    credit[4] = 3;
                    break;
                }
            }

        } else if (dept.equals("Business Administration")) {
            switch (sem) {
                case 1: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Functional English                      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Pakistan Studies/Islamiat              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Principles of Microeconomics           ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Business Mathematics                   ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Introduction to Information Technology ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Fundamentals of Financial Accounting   ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 2: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Principles of Management     ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Principles of Macroeconomics ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "English Composition          ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Mercantile Laws              ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Business Statistics          ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 3: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Principles of Marketing                ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Intermediate Financial Accounting      ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Introduction to Management Accounting  ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Organization Behavior                  ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Introduction to Business Finance       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Statistical Inference                  ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 4: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Fundamentals of Auditing                   ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Principles of Taxation                     ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Company laws (255 Sections)                ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Financial Institution and Markets          ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Business Research Methods                  ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Business Communication & Report Writing    ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 5: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Corporate Financial Reporting              ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Business Ethics                            ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Management Accounting & Control System     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Intermediate Business Finance              ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Banking Operations                         ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Advanced Taxation                          ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 6: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Human Resource Management                         ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Marketing Management                              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Applied Corporate laws & secretarial practices    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Auditing & Assurance and related services         ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Corporate Risk Management                         ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Advanced Corporate Financial Reporting            ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 7: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Management Accounting-Decision Making ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Analysis of Financial Statements      ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Applied Financial Management          ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Financial Information System          ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Strategic Business Management         ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 8: {
                    subject = new String[1];
                    total = new int[1];
                    credit = new int[1];

                    subject[0] = "Practicum ";
                    total[0] = 100;
                    credit[0] = 6;

                    break;
                }
            }

        } else if (dept.equals("Education")) {
            switch (sem) {
                case 1: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English – I           ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "General Science       ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "General Mathematics   ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Methods of Teaching   ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Islamiat/Ethics       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Computer Literacy - I ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 2: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English-II            ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Bio–I OR Math-I       ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Chem-I OR Phy-I       ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "Classroom Management  ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Urdu/Sindhi           ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Pakistan Studies      ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 3: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English (Content)-III  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Bio–II OR Math–II      ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Chem-II OR Phy-II      ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "ICT in Education       ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Teaching of Pak std.   ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Teaching Practice      ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 4: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English (P)-I              ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Bio (P)-I OR Math (P)-I    ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Chem (P)-I OR Phy (P)-I    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Child Development          ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Classroom Assessment       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Teaching Practice          ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 5: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English (Content)-IV           ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Bio-III OR Math-III            ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Chem-III OR Phy-III            ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "School, Community and Teacher  ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Educational Psychology         ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Teaching Literacy              ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 6: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English (P)-II                ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Bio (P)-II OR Math (P)-II     ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Chem (P)-II OR Phy (P)-II     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Curriculum Development        ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Research Methods in Education ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Teaching Practice             ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 7: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Contemporary Issues and Trends in Edu. ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Foundations of Edu.                    ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Test Dev. & Evaluation                 ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Comparative Education                  ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Teaching Practice                      ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Guidance & Counseling                  ";
                    total[5] = 100;
                    credit[5] = 3;
                    break;
                }
                case 8: {
                    subject = new String[4];
                    total = new int[4];
                    credit = new int[4];

                    subject[0] = "Educational Leadership & Management    ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "School Improvement & Management        ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Edu. Research Project (Individual)     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Teaching Practice (Long Term)          ";
                    total[3] = 100;
                    credit[3] = 3;
                    break;
                }
            }
        } else if (dept.equals("Media and Communication")) {
            switch (sem) {
                case 1: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Functional English                   ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Islamic Studies                      ";
                    total[1] = 50;
                    credit[1] = 2;
                    subject[2] = "Pakistan Affairs                     ";
                    total[2] = 50;
                    credit[2] = 2;
                    subject[3] = "Introduction to Multimedia           ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Introduction to Mass Communication   ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Introduction to Int. Relations       ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 2: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Communication Skills             ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Introduction to Sociology        ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Mathematics for liberal Arts     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Storytelling in Digital Age      ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Personal Development             ";
                    total[4] = 50;
                    credit[4] = 3;
                    subject[5] = "Photography                      ";
                    total[5] = 50;
                    credit[5] = 3;

                    break;
                }
                case 3: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Tech. Report  and PPT Skills     ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Computer Skills                  ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Introduction to Psychology       ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Media Psychology                 ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Mass Media & Society             ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Introduction To Broadcast        ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 4: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "English for Jounalism            ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Digital Audio/Video              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Intr. to Adv. & Public Relations ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Contemporary World Media         ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Social Media Networks Culture    ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Introduction To film and Theatre ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 5: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Theories of Mass Communication I    ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Journalistic Urdu/Functional Urdu   ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Opinion Writing                     ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Introduction to Philosophy & Thought";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Media Laws and Ethics               ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "International Communication         ";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 6: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Theories of Mass Communication II      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Development Communication              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Intro. to Conflict Reporting           ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Intro. to Innovation & Entrepreneurship";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Sindhi Journalism                      ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 7: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Current Affairs   ";
                    total[0] = 50;
                    credit[0] = 2;
                    subject[1] = "Media Management  ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Online Journalism ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective I        ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective II       ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 8: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Research Project and Internship ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Academic Writing and P. Writing ";
                    total[1] = 100;
                    credit[1] = 2;
                    subject[2] = "Regional Mass Media             ";
                    total[2] = 100;
                    credit[2] = 2;
                    subject[3] = "Elective III                    ";
                    total[3] = 100;
                    credit[3] = 2;
                    subject[4] = "Elective IV                     ";
                    total[4] = 100;
                    credit[4] = 2;

                    break;
                }
            }
        } else if (dept.equals("Mathematics")) {
            switch (sem) {
                case 1: {
                    subject = new String[7];
                    total = new int[7];
                    credit = new int[7];

                    subject[0] = "Calculus - I                     ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Mathematical Thinking            ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Functional English               ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Introduction to ICT              ";
                    total[3] = 100;
                    credit[3] = 2;
                    subject[4] = "Introduction to statistics       ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Islamic Studies/Ethics           ";
                    total[5] = 50;
                    credit[5] = 2;
                    subject[6] = "Introduction to ICT (PR)         ";
                    total[6] = 50;
                    credit[6] = 1;

                    break;
                }
                case 2: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Calculus-II                      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Linear Algebra-I                 ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Applied Physics-I                ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Introduction to language(C++)    ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Pakistan Studies                 ";
                    total[4] = 50;
                    credit[4] = 2;

                    break;
                }
                case 3: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Calculus-III                     ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Linear Algebra-II                ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Theory of Probability            ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Computing tools for Mathematics  ";
                    total[3] = 100;
                    credit[3] = 1;
                    subject[4] = "Applied Physics-II               ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Communication & Presentation Skill";
                    total[5] = 100;
                    credit[5] = 3;

                    break;
                }
                case 4: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Real Analysis                    ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Introduction to Topology         ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Mathematics of Data Science      ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Introduction to Sociology        ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Technical Writing                ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 5: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Functional Analysis              ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Complex Analysis                 ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Ordinary Differential Equations  ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Group Theory                     ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Numerical Analysis-I             ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 6: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Partial Differential Equations   ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Classical Mechanics              ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Theory of Curves and Surfaces    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-I                       ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Elective-II                      ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 7: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Numerical Analysis-II            ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Elective-III                     ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-IV                      ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-V                       ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Final Year Project - I           ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 8: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Elective-VI                      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Elective-VII                     ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-VIII                    ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Elective-IX                      ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Final Year Project - II          ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
            }
        } else if (dept.equals("Electrical Engineering")) {
            switch (sem) {
                case 1: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Introduction to Computing         ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Workshop Practice                 ";
                    total[1] = 50;
                    credit[1] = 1;
                    subject[2] = "Functional English                ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Pakistan studies                  ";
                    total[3] = 50;
                    credit[3] = 2;
                    subject[4] = "Calculus and Analytical Geometry  ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Applied Physics                   ";
                    total[5] = 100;
                    credit[5] = 4;

                    break;
                }
                case 2: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Communication & Presentation skills      ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Linear Algebra & Differential Equations  ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Islamic Studies/Ethics                   ";
                    total[2] = 50;
                    credit[2] = 2;
                    subject[3] = "Linear Circuit Analysis                  ";
                    total[3] = 100;
                    credit[3] = 4;
                    subject[4] = "Programming for Engineers                ";
                    total[4] = 100;
                    credit[4] = 4;
                    subject[5] = "Computer Aided Design                    ";
                    total[5] = 50;
                    credit[5] = 1;

                    break;
                }
                case 3: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Multivariable Calculus          ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Applied Thermodynamics          ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Electrical Network Analysis     ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "Digital Logic Design            ";
                    total[3] = 100;
                    credit[3] = 4;
                    subject[4] = "Electronic Devices and Circuits ";
                    total[4] = 100;
                    credit[4] = 4;

                    break;
                }
                case 4: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Complex Variables & Transforms  ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Intro to Embedded Systems       ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Electromegnetics Field Theory   ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Electronic Circuit Design       ";
                    total[3] = 100;
                    credit[3] = 4;
                    subject[4] = "Object Oriented Programming     ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 5: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Probabilty and Statistics         ";
                    total[0] = 100;
                    credit[0] = 3;
                    subject[1] = "Electrical Machines               ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Instrumentataion and Meaurement   ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "Signals and Systems               ";
                    total[3] = 100;
                    credit[3] = 4;
                    subject[4] = "Organizational Behavior           ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 6: {
                    subject = new String[5];
                    total = new int[5];
                    credit = new int[5];

                    subject[0] = "Power Electronics                 ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Control Systems                   ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Communication Systems             ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "Health Safety & Enviroment        ";
                    total[3] = 100;
                    credit[3] = 3;
                    subject[4] = "Engineering Ecnomics & Management ";
                    total[4] = 100;
                    credit[4] = 3;

                    break;
                }
                case 7: {
                    subject = new String[6];
                    total = new int[6];
                    credit = new int[6];

                    subject[0] = "Technical Writing             ";
                    total[0] = 50;
                    credit[0] = 2;
                    subject[1] = "Elective-I                    ";
                    total[1] = 100;
                    credit[1] = 3;
                    subject[2] = "Elective-II                   ";
                    total[2] = 100;
                    credit[2] = 4;
                    subject[3] = "Elective-III                  ";
                    total[3] = 100;
                    credit[3] = 4;
                    subject[4] = "Engineering  Entrepreneurship ";
                    total[4] = 100;
                    credit[4] = 3;
                    subject[5] = "Final Year Project-I          ";
                    total[5] = 50;
                    credit[5] = 2;

                    break;
                }
                case 8: {
                    subject = new String[4];
                    total = new int[4];
                    credit = new int[4];

                    subject[0] = "Elective-IV             ";
                    total[0] = 100;
                    credit[0] = 4;
                    subject[1] = "Elective-V              ";
                    total[1] = 100;
                    credit[1] = 4;
                    subject[2] = "Project Management      ";
                    total[2] = 100;
                    credit[2] = 3;
                    subject[3] = "Final Year Project-II   ";
                    total[3] = 100;
                    credit[3] = 4;

                    break;
                }
            }
        }
    }
}
