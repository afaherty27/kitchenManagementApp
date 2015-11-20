Reviewer: Deb Hafenstein

Adam's Code Review

What is good?
* Project idea is relevant to the restaurant business
* JSP pages were up and looking good
* Well structured and clean

What could use some work?
* Incorporating the other project requirements 


See Evaluation column:

### Project Structure
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| Classes are single-purpose | none, some, most, all | based on how many different things a given class tries to do; can be measured with IntelliJ class complexity evaluation | Most |
| Proper file structure | Y/N | related classes are grouped, have logical folders (out, resources, src, tests, etc), don't unnecessarily nest things | Y |
| Proper implementation of industry-standard high-level structure (or, appropriate separation of concerns) | poor, fair, good, excellent | how well does the project adhere to the appropriate framework, etc (MVC, encapsulation of databases, authentication) | Good |

### Code Structure and Style
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| No duplicate code | Y/N | analyze/locate duplicates in IntelliJ | Y |
| No dead/useless/lazy/unreachable code | Y/N | IntelliJ natively identifies unused variables and uncalled functions | Y (did see a duplicate servlet/github version that should be cleaned out of there) |
| Variables and methods have appropriate access modifiers | Y/N (possibly scale?) | are variables private with public getters/setters, are methods private unless called from outside the class, etc | Y |
| No hardcoded variables/magic numbers/strings | Y/N | all constants should be stored in a properties file | Y |
| Readability | poor, fair, good, excellent | is the code well-organized, logically structured | Y |
| Full, complete Javadoc for all classes and methods | none, some, most, all | descriptive Javadoc for all classes and methods; getters and setters should probably have cursory Javadoc comments | Most - saw a couple methods without Javadoc |
| Appropriate and descriptive variable and function names | poor, fair, good, excellent | descriptive names for variables and functions are used, no single-character or nonsense variable names | good |
| Consistent formatting | Y/N | line lengths and indentation is consistent throughout classes/project | Y |
| Methods are concise and single-purpose | none, some, most, all | code is well broken-out as per adv. java class expectations | most |
| Class constructors are present and appropriately implemented | none, some, most, all | constructors are declared and used in object initialization | Y |

### Testing
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| Code compiles with no errors or warnings | Y/N | can ignore (most) typos and "Java language level migration aids" (like <String, String> instead of <>) and other common-sense things | Y | 
| Appropriate use of logging | poor, fair, good, excellent | items being logged are relevant; logs are being output to correct, logical location | good, log4j is implemented |
| no System.out.println use | Y/N |Should not have any System.out.printlns used for testing purposes. | Y |
| Testing for positive results | Y/N | present and thorough | N |
| Testing for negative results | Y/N | present and thorough | N |
| Testing for errors and exceptions | Y/N | present and thorough | N |
| Code coverage with tests | none(<20%), some(20-44%), most(45-79%), all (80%+) | measured with IntelliJ; exclude getters/setters unless they do validation or other processing | none |




