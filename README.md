# Read Me First
* Either Chrome or Firefox should be installed in the system.
* Download Chromedriver or GekhoDriver.

[ChromeDriver](https://chromedriver.storage.googleapis.com/index.html?path=2.41/)

[Gekhodriver](https://github.com/mozilla/geckodriver/releases)
* Place them in a directory and configure the path in testconfiguration.properties
* Set locale in testconfiguration.properties to `de or en` as required.
* Make sure that maven is installed and added to path

[Maven](https://maven.apache.org/download.cgi)

* Navigate to project root and run the command `mvn clean test`
* After test completion, results will be available at `target\surefire-reports\index.html`. 
* Click on the link Reporter Output for details about the tests including screenshots of failure if exisits.
