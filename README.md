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

Now, when we have all configured let's record the given steps. We're going to use [automationpractice website](http://automationpractice.com/index.php) witch is a mockup online shop. 

First select 'Start!' button on recorder GUI and execute:

__The following scenario__

|Step|Description                          |Expected Result                                      |
|----|-------------------------------------|-----------------------------------------------------|
|1|Navigate to the browser and go to the website: http://automationpractice.com/index.php|Shop's home page visible|
|2|In ‘Search’ field type 'dress'|In the field the given word displayed|
|3|Then hit search button|A list with search results displayed|
|4|Select 'Printed Chiffon Dress'|Details of the selected dress displayed|
|5|Select 'Add to cart' button|Dress added to shopping cart|
|6|Select 'Proceed to checkout' button|Shopping cart summary displayed|
|7|Select 'Proceed to checkout' button|Authentication page displayed|
|8|Log in to account using email: d6403887@urhen.com and passowrd: test123 and then select 'Sign in'|Address page displayed|
|9|Select 'Proceed to checkout' button|Shipping page displayed|
|10|Check the Terms of service box and then select 'Proceed to checkout' button|Payment page displayed|
|11|Select 'Pay by bank wire' option|Order summary page displayed|
|12|Select 'I confirm my order' button|Order confirmation page displayed|

Then select 'Stop&Save' button on recorder GUI.

Congrats! You've just recorded your first simulation using gatling. In the next chapter we will take a look on the generated scenario and dive into the code a little bit.

## Script explanation

1. Go to the location:
   %GATLING_HOME%\user-files\simulations\tutorial and open file *RecordedSimulation.scala*.
   Use code editor of your choice.

2. You will see a code similar to the one added to the project on location:
   %GATLING_HOME%\user-files\simulations\tutorial\MyRecordedSimulation.scala

3. There is a lot of code in the file and it can be overwhelming at first. I cut it into blocks and explaine what we need and what can be refactored. You can see point commented and the explanation that follows them.

__package, imports, class, httpProtocol, headers, uri__


```scala
package tutorial // 1

import scala.concurrent.duration._ // 2

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class MyRecordedSimulation extends Simulation { // 3

	val httpProtocol = http // 4 
		.baseURL("http://automationpractice.com") // 5
		.disableFollowRedirect
		.disableAutoReferer
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:71.0) Gecko/20100101 Firefox/71.0")
	// 7
	val headers_0 = Map( 
		"Cache-Control" -> "max-age=0",
		"Referer" -> "http://automationpractice.com/index.php",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache")

	val headers_4 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Cache-Control" -> "max-age=0",
		"Referer" -> "http://automationpractice.com/index.php")

	val headers_5 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/")

	val headers_7 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Referer" -> "http://automationpractice.com/index.php",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_9 = Map(
		"Referer" -> "http://automationpractice.com/index.php",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_10 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_11 = Map(
		"Accept" -> "application/json, text/javascript, */*; q=0.01",
		"Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?id_product=7&controller=product",
		"X-Requested-With" -> "XMLHttpRequest",
		"cache-control" -> "no-cache")

	val headers_12 = Map(
		"Referer" -> "http://automationpractice.com/index.php?id_product=7&controller=product",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_13 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=order",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_18 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_19 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_20 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_21 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?controller=order",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_22 = Map(
		"Referer" -> "http://automationpractice.com/index.php?controller=order&multi-shipping=",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_23 = Map(
		"Origin" -> "http://automationpractice.com",
		"Referer" -> "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_24 = Map(
		"Referer" -> "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment",
		"Upgrade-Insecure-Requests" -> "1")
	// 8
    val uri1 = "https://connect.facebook.net:443/en_US/all.js"
    val uri2 = "https://www.facebook.com:443/x/oauth/status"
    val uri4 = "http://detectportal.firefox.com/success.txt"
    val uri5 = "fonts.googleapis.com"
```

1. package
   optional package - we daclared it in the recorder configuration.

2. import
   required imports

3. class
   the class declaration that extends `Simulation`

4. http
   configuration for all http requests

5. baseURL
   that is appended to all urls.
   Note: if your recorded script has different `baseURL` change it for `http://automationpractice.com"`

6. acceptHeader
   common headers that will be sent with requests

7. headers
   generated headers. As you can see I have 24 different headers! It's too much to follow, therefore in the next steps we will refactor them and create just one unique `header` 

8. uri
   generated uris
   