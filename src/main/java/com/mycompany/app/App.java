package com.mycompany.app;

/**
 * Device Caller!
 *
 */
 
import com.microsoft.azure.sdk.iot.service.devicetwin.DeviceMethod;
import com.microsoft.azure.sdk.iot.service.devicetwin.MethodResult;
import com.microsoft.azure.sdk.iot.service.exceptions.IotHubException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
public class App 
{

	public static final String iotHubConnectionString = "HostName=utopiahub1.azure-devices.net;SharedAccessKeyName=iothubowner;SharedAccessKey=FNtx8vg1ZGwnVGGukV8rf66//C1eL9xIsml+Kon30bQ=";
	public static final String deviceId = "device4";

	public static final String methodName = "writeLine";
	public static final Long responseTimeout = TimeUnit.SECONDS.toSeconds(30);
	public static final Long connectTimeout = TimeUnit.SECONDS.toSeconds(5);
	public static final String payload = "a line to be written";

    public static void main( String[] args )
    {
        System.out.println("Starting sample...");
		DeviceMethod methodClient = DeviceMethod.createFromConnectionString(iotHubConnectionString);

		try
		{

			System.out.println("Invoke direct method");
			MethodResult result = methodClient.invoke(deviceId, methodName, responseTimeout, connectTimeout, payload);

			if(result == null)
			{
				throw new IOException("Direct method invoke returns null");
			}
			System.out.println("Status=" + result.getStatus());
			System.out.println("Payload=" + result.getPayload());
		}
		catch (IotHubException e)
		{
			System.out.println(e.getMessage());	
		}

		System.out.println("Shutting down sample...");
    }
}
