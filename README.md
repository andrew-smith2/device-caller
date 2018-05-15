# device-caller
Java backend application to invoke method on a device client
<br>
<ul>
<li>Sets up a calling application that registers with the Azure IoT hub and makes direct method call to a method on device client</li>
<li>Takes returned payload from device method which contains a random number representing a temperature value and displays to the console.</li>
</ul>

Instructions  (You can either work on your laptop and build the solution then deploy to you Raspberry PI or you can develop on the Rapberry PI. The PI will contain JDK and Maven)
1. Ensure you have JDK and Maven installed on your machine 
2. Ensure client application is installed and started that is located in the https://github.com/spock75/device-client.git repository
3. Download and unpack zipped file of application or clone respository using git clone
4. Open terminal window to the location where the project files are located
5. Edit the App.java file and update the connection string to the IoT Hub and Device ID with the provided connection string/DeviceID in Hackathon instructions
6. Type <code>mvn clean package</code> in the terminal
7. Fix any build errors
8. For Linux type <code>java -jar target/invoke-direct-method-1.0-SNAPSHOT.jar</code> to run application<br/>For Windows type <code>java -jar target\invoke-direct-method-1.0-SNAPSHOT.jar</code> to run application


