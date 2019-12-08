# gatling-tutorial
This is my comprehensive tutorial how to start performance testing with gatling.io.

Let's assume that you are pretty new to performance testing but have some experience in testing over all. Great! This place is for you. I will try to show you how to set up an environment, the tool and explain some basics regarding recorded scenario.

# Needed installations:
	1. Firefox web browser
	2. Unzip the downloaded bundle to a folder of your choice (preferable C:\) gatling: https://gatling.io/open-source
	3. Install OpenJDK8
	4. Scala 2.12

# Setting up Certificates in gatling recorder
Read this chapter to understand how gatling is paired with the browser: https://gatling.io/docs/3.3/http/recorder/

	1. Go to gatling bundle: C:\gatling\bin\recorder.bat
	2. Set HTTPS Mode: Certificate Authority. 
	3. Generate CA.
	4. Save files.
	5. Under CA Certificate: Browse and set: gatlingCA.cert.pem
	6. Unser CA PK set: gatlingCA.key.pem

# Setting up Firefox Browser
	1. Navigate to Options > Certificates > View Certificates
	2. Go to Authorities tab.
	3. Import gatlingCA.cert.pem and gatlingCA.key.pem
	4. Navigate to Options > Network > Settings
	5. Set it for ‘Manual proxy configuration’

# Setting up System Environment Variables
%JAVA_HOME%
