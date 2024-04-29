#PROJECT TITLE 
 
News Around Cognizant

--------------------------------------

# PROBLEM STATEMENT

The goal of this project is to extract and validate news details from the Around Cognizant News section on the Be.Cognizant website.

---------------------------------------

#DETAILED DESCRIPTION

The main steps of the project are as follows:

1. Navigate to the Be.Cognizant Website.
2. Capture the user information.
3. Validate that the Around Cognizant Newds section is displayed on the page.
4. Extract all the news header in the Around Cognizant News Section and verify whether the News header and Tool Tips of news are the same.
5. Click on "See All" and validate that all the news are displayed when the user clicks on "See All".
6. Click on each News Header and verify the News header and Tooltip for each News.
7. Print all the details of the News.
8. Repeat the steps 5 and 6 for the Top 5 News.

Note: Take all necessary screenshot for all the test cases and print all the data in console.

------------------------------------------

#KEY AUTOMATION SCOPE

The automation scope of this project includes:

1. Handling alerts and different browser windows.
2. Navigating back to the home page.
3. Extracting multiple options items and storing them in collections.
4. Capturing warning messages.
5. Implementing a data driven approach.
6. Performing cross browser testing.

--------------------------------------------

#REQUIREMENTS

1) Web browser
2) Eclipse IDE
3) Java JDK
4) Selenium Framework
5) TestNG Framework
6) Extent Report Framework
-----------------------------------------

#DEPENDENCIES USED
--------------------------------------------------------------------------------------
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.18.1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.9.0</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.16.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi</artifactId>
			<version>5.2.5</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.2.5</version>
		</dependency>

		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-to-slf4j</artifactId>
			<version>2.8.2</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.1.1</version>
		</dependency>
---------------------------------------------------------------------------------------------------
#TEAM MEMBERS
1) Shreya Gomasta (2327196)
2) Himadri Ray (2327221)
3) Ranjay Yadav (2327171)
4) Gundu Ramya Sree (2327200)
5) Sayak Bose (2327289)