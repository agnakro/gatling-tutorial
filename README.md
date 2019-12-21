# gatling-tutorial

This is a comprehensive tutorial how to start performance testing with gatling.io.

Let's assume that you are pretty new to performance testing but have some experience in testing over all. Great! This place is for you. The purpose of this tutorial is to know basics around the tool - gatling.io and its R&R functionality. I will try to show you how to set up an environment, the tool and explain essenssials regarding recorded scenario.

## Installations

To start working with gatling, some required installations are needed:

	1. Firefox web browser (or other, gatling supports other browsers too)
	2. Clone or download repository to a folder of your choice (preferable C:\)
	3. Install OpenJDK8
	4. Scala 2.12

__Setting up Certificates in gatling recorder__

While working with recorder is important to tell your browser that gatling is not a security threat. More on this [Here](https://gatling.io/docs/current/http/recorder/#https-mode). I use Certificate Authority:

	1. Go to gatling bundle: %GATLING_HOME%\bin\recorder.bat
	2. Set HTTPS Mode: Certificate Authority. 
	3. Generate CA.
	4. Save files.
	5. Under CA Certificate: Browse and set: gatlingCA.cert.pem
	6. Unser CA PK set: gatlingCA.key.pem

__Setting up Firefox Browser__

And now let's configure certificates and proxy in the browser. The following example regards Firefox but similar steps can be done in other browsers:

	1. Navigate to Options > Certificates > View Certificates
	2. Go to Authorities tab.
	3. Import gatlingCA.cert.pem and gatlingCA.key.pem
	4. Navigate to Options > Network > Settings
	5. Set it for ‘Manual proxy configuration’

__Setting up System Environment Variables__

To run gatling, setting up System Envirnoment Variables is required:

	1. Navigate to System Properties > Advanced > Environment Variables
	2. Under System Variables select New
	3. Add the following:
		Variable name: JAVA_HOME
		Variable value: {path to jdk}

## Recorder

Read this chapter to understand how gatling is paired with the browser and how it mimics your steps: 

[Link to gatling/recorder](https://gatling.io/docs/3.3/http/recorder)

Let's run recorder and proceed further with configuration around the subject.

Run %GATLING_HOME%\bin\recorder.bat

Then you will see the following window:

![Image of recorder](img/recorder.png)

Let's discuss marked points:

	1. Selected HTTPS mode: Certificate Authority. 
	That point was discussed in the previous section, but you can align with the example and check whether is the same.
	2. Package: tutorial.
	Name of the package must be added, it's a name of your choice but remember to be specific when naming things.
	3. Class Name: RecorderdSimulation. 
	Default name of the simulation, this one is good therefore I don't change it.
	4. Simulation folder. 
	Path of the folder where simulations will be stored.
	5. Filters section. 
	Let's set up strategy of our recorder for 'BlackList First' and then select 'No static resources' button at the bottom. 
	Blacklist column will be filled automatically.



## Recorded script

Now, when we have all configured let's record the given scenario. We're going to use [automationpractice website](http://automationpractice.com/index.php) witch is a mockup online shop. 

First select 'Start!' button on gatling GUI and execute the following steps:

|Step|Description|Expected Result|
|1|Navigate to the browser and go to the website: http://automationpractice.com/index.php|Shop's home page visible|
|2|In ‘Search’ field type 'dress'|In the field the given word displayed|
|3|Then hit search button|A list with search results displayed|
|4|Select 'Printed Chiffon Dress'|Details of the selected dress displayed|
|5|Select 'Add to cart' button|Dress added to shopping cart|
|6|Select 'Proceed to checkout' button|Shopping cart summary displayed|
|7|Select 'Proceed to checkout' button|Authentication page displayed|
|8|Log in to account using email: d6403887@urhen.com and passowrd: test123 and 'Sign in'|Address page displayed|
|9|Select 'Proceed to checkout' button|Shipping page displayed|
|10|Check the Terms of service box and then select 'Proceed to checkout' button|Payment page displayed|
|11|Select 'Pay by bank wire' option|Order summary page displayed|
|12|Select 'I confirm my order' button|Order confirmation page displayed|


## Your own script