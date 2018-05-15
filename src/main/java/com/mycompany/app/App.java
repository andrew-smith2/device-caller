package com.mycompany.app;

/**
 * Device Caller
 */
 
import com.microsoft.azure.sdk.iot.service.devicetwin.DeviceMethod;
import com.microsoft.azure.sdk.iot.service.devicetwin.MethodResult;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

 
public class App 
{
	public static final String iotHubConnectionString = "{ IOT hub connection string }";
	public static final String deviceId = "team5device1";

	public static final String methodName = "writeLine";
	public static final Long responseTimeout = TimeUnit.SECONDS.toSeconds(30);
	public static final Long connectTimeout = TimeUnit.SECONDS.toSeconds(5);
	
	
	public static class Payload
	{	
		public int temp;
		public Payload() {};
		
		public int getTemp()
		{
			return this.temp;
		}
		
		public void setTemp(int temperature)
		{
			this.temp = temperature;
		}
	}
	
	
    public static void main( String[] args )
    {
        Payload payload = new Payload();
		Gson gson = new Gson();
		
		System.out.println("Starting sample...");
        
        try
		{
			DeviceMethod methodClient = DeviceMethod.createFromConnectionString(iotHubConnectionString);
			System.out.println("Invoke direct method");
				
			for (int i = 0; i < 10; i++)
			{
				
				MethodResult result = methodClient.invoke(deviceId, methodName, responseTimeout, connectTimeout, "Get the temp from device.");
				
				if(result == null)
				{
					throw new IOException("Direct method invoke returns null");
				}

				// gets the response payload and binds to Payload class
				String strResult = result.getPayload().toString();
			    payload = gson.fromJson(strResult, Payload.class);
	
				System.out.println("Status=" + result.getStatus());
				System.out.println("Payload=" + gson.toJson(payload));
			}
		}
		catch (IotHubException e)
		{
			System.out.println(e.getMessage());	
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Shutting down sample...");
    }
	
}
