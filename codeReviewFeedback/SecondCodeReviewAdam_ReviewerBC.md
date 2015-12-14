Reviewer: Brandon Ciancio

Adam's Code Review

What is good:
* Your code is broken out very nicely making it easy to navigate your project structure.
* Good documentation.

What could use some work:
* Will eventually need to add testing.

See Evaluation column:

### Project Structure
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| Classes are single-purpose | none, some, most, all | based on how many different things a given class tries to do; can be measured with IntelliJ class complexity evaluation |  I believe all |
| Proper file structure | Y/N | related classes are grouped, have logical folders (out, resources, src, tests, etc), don't unnecessarily nest things | Y |
| Proper implementation of industry-standard high-level structure (or, appropriate separation of concerns) | poor, fair, good, excellent | how well does the project adhere to the appropriate framework, etc (MVC, encapsulation of databases, authentication) | excellent |

### Code Structure and Style
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| No duplicate code | Y/N | analyze/locate duplicates in IntelliJ | Y |
| No dead/useless/lazy/unreachable code | Y/N | IntelliJ natively identifies unused variables and uncalled functions | Possibly the test.jsp file |
| Variables and methods have appropriate access modifiers | Y/N (possibly scale?) | are variables private with public getters/setters, are methods private unless called from outside the class, etc | Y |
| No hardcoded variables/magic numbers/strings | Y/N | all constants should be stored in a properties file | Y|
| Readability | poor, fair, good, excellent | is the code well-organized, logically structured | excellent |
| Full, complete Javadoc for all classes and methods | none, some, most, all | descriptive Javadoc for all classes and methods; getters and setters should probably have cursory Javadoc comments | all |
| Appropriate and descriptive variable and function names | poor, fair, good, excellent | descriptive names for variables and functions are used, no single-character or nonsense variable names | excellent |
| Consistent formatting | Y/N | line lengths and indentation is consistent throughout classes/project | Y |
| Methods are concise and single-purpose | none, some, most, all | code is well broken-out as per adv. java class expectations | all |
| Class constructors are present and appropriately implemented | none, some, most, all | constructors are declared and used in object initialization | Y |

### Testing
| Metric | Measurement | Criteria | Evaluation |
| :---------- | :----------: | :---------- | :---------- |
| Code compiles with no errors or warnings | Y/N | can ignore (most) typos and "Java language level migration aids" (like <String, String> instead of <>) and other common-sense things | Y | 
| Appropriate use of logging | poor, fair, good, excellent | items being logged are relevant; logs are being output to correct, logical location | excellent |
| no System.out.println use | Y/N |Should not have any System.out.printlns used for testing purposes. | Has no system.outs |
| Testing for positive results | Y/N | present and thorough | N |
| Testing for negative resuts | Y/N | present and thorough | N |
| Testing for errors and exceptions | Y/N | present and thorough | N |
| Code coverage with tests | none(<20%), some(20-44%), most(45-79%), all (80%+) | measured with IntelliJ; exclude getters/setters unless they do validation or other processing | none |


