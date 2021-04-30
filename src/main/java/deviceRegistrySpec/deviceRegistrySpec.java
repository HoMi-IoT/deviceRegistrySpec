package deviceRegistrySpec;


import org.homi.plugin.specification.*;

@SpecificationID(id = "DeviceRegistry") 
public enum deviceRegistrySpec implements ISpecification {
	CREATEDEVICE(Boolean.class, Integer.class, String.class, String.class), // returns device ID, takes name and address
	GETDEVICES(String[].class),
	DELETEDEVICES(String.class, Integer[].class), // takes deviceID's
	WRITESTATE(Boolean.class, String.class, String.class, String.class), // takes deviceID, key, value
	UPDATESTATE(Boolean.class, String.class, String.class, String.class),
	DELETESTATE(Boolean.class, Integer.class, String.class), // takes deviceID, key
	GETSTATE(Object[].class, String.class),
	CREATEGROUP(Boolean.class, Integer.class, String.class),
	SETGROUP(Boolean.class, Integer.class, Integer.class), //takes groupID and an array of deviceID's
	DELETEGROUP(Boolean.class, Integer.class), // takes groupID
	DELETEFROMGROUP(Boolean.class, Integer.class, Integer.class); // takes deviceID's, and groupID
	
	
	
	Class<?> returnType;
	Class<?>[] parameters; 
 
	deviceRegistrySpec(Class<?> returnType, Class<?> ...params ) {
		this.returnType = returnType;
		this.parameters = params;
		
	}

	@Override
	public Class<?>[] getParameterTypes() {
		return this.parameters;
	}

	@Override
	public Class<?> getReturnType() {
	
		return this.returnType;
	}

}
