# Race Series Management System

The Race Series Management System is built for ease of tracking race series and the included races in motorsport and sim racing alike. A simple UI connects to a database using Java, to store your race details, and allows you to add and delete races from each series, as well as adding and deleting series' themselves.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need some form of java code manipulation program with Spring Boot and Maven capabilities (I used Eclipse, available at https://www.eclipse.org/downloads/packages/), as well as a working and up-to-date version of Java on your system (https://java.com/en/download/). To run the tests, you will require an up-to-date version of Selenium IDE (https://www.selenium.dev/selenium-ide/) as well as some capability to run mySQL code, such as mySQL Workbench (https://www.mysql.com/products/workbench/). GIT Bash will also be helpful for development purposes, although not required. Branches are included within the repository to show the code at different stages of development.

### Installing

Exact instructions will depend on the IDE you are using, for Eclipse, go to File -> Import -> Existing Maven Project, select the HWA folder and follow the instructions on the Wizard from there.

Once the project is set up, select the main folder and run it as a Java application. This will boot up the Spring web server. You can now open a web browser of you choice, and go to http://localhost:8080, which contains the program.

## Running the tests

While the tests are contained within a JUnit file, this is not currently functional and the tests must instead be run manually through Selenium.

To correctly prepare the environment, first run sql-schema.sql, located in HWA/src/test/resources. This initialises the database and removes any data previously added that might interfere with the tests.

Next, use Selenium to run the tests contained in HWA.side (also in test/resources) in this order:

1. Add a series - Tests that series' can be added to the database correctly
2. Add a race - Tests that races can be added to the database correctly
3. Add a race wrong series - Tests that races cannot be added without a corresponding series
4. Delete a race - Tests that races can be removed from the database correctly
5. Delete series in use - Tests that series' cannot be removed without first removing corresponding races
6. Delete a series - Tests that series' without corresponding races can be removed from the database correctly

If all run correctly then the program is functioning as intended. Any leftover series' from testing can now be deleted via the UI.

## Kanban Board

Jira - User Stories (https://ns-qaacademy-project1.atlassian.net/jira/software/projects/HWA/boards/3/backlog)

## Built With

Maven - Dependency Management

## Versioning

We use GitHub for versioning (https://github.com/Gwoxenox/HWA)

## Authors

Gwendolen Old - Complete project - Gwoxenox

Acknowledgments
Thanks to my trainers for the past 3 weeks for teaching me everything used in this project.
Also Oliver Dillon you are an absolute G and I would still be getting endless 404 errors without you.