# OldMutual

Background 

The project was developed to verify the installment amount for personal loan.
This project was developed using IntelliJ IDEA and Java as a programming language. It can run both on Chrome and Firefox browser.

Steps to clone the project

Open cmd or git bash on your pc

run the command : git clone 

Steps to execute the tests

Open terminal and run maven command mvn clean test -PE2E

The above command will thetests under E2E profile that is mapped to testNg.xml file that will start the test under package Tests > Test_Runner

Once the test complete executing the Screenshot folder will be created with the scrreenshots of all the pages that the test covers , also Execution report folder with a .html report will be generated

The report can be opened using any browser of choice

Note : To run different browser (Chrome / Firefox) you will need to pass in the browsername i.e. Chrome or Firefox on the line below that sits on Test_Runner.java class

  private WebDriver driver= Setup_Class.startBrowserOfChoice("https://www.oldmutual.co.za/personal/solutions/bank-and-borrow/","Chrome");
