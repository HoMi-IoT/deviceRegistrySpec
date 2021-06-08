package deviceRegistrySpec;


import org.homi.plugin.api.observer.IObserver;
import org.homi.plugin.specification.*;
import org.homi.plugin.specification.types.TypeDef;
import static org.homi.plugin.specification.SpecificationHelper.*;
import static org.homi.plugin.specification.Constraints.*;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

class Types{
	static TypeDef<String> key = defineType(String.class, notNull());
	static TypeDef<Object> value = defineType(Object.class, notNull());
	static TypeDef<IObserver> observer = defineType(IObserver.class, notNull());
	static Predicate<Object> fromBase = (o)->{
		if (o.getClass().getModule().getName().equals("java.base") && o instanceof Serializable)
			return true;
		return false;
	};
}

@SpecificationID(id = "DeviceRegistry") 
public enum DeviceRegistrySpec implements ISpecification {
	CREATEDEVICE(Boolean.class, defineSerializableType(Device.class, notNull())), // returns device ID, takes name and address
	GETDEVICE(defineSerializableType(Device.class), String.class),
	GETDEVICES(defineSerializableType(Device[].class, notNull()), String.class),
	DELETEDEVICE(Boolean.class, String[].class), // takes deviceID's
	SETATTRIBUTE(Boolean.class, String.class, String.class, defineType(Object.class, notNull(), Types.fromBase)), // takes deviceID, key, value
	DELETEATTRIBUTE(Boolean.class, String.class, String.class), // takes devicename, attributekey
	//GETATTRIBUTE(Object.class, String.class), //keep or leave memories
	ADDTOGROUP(Boolean.class, String.class, String.class), //deviceID, groupID
	DELETEGROUP(Boolean.class, String.class), // takes groupID
	DELETEFROMGROUP(Boolean.class, String.class, String.class); // takes deviceID's, and groupID
	
	
	
	private TypeDef<?>  returnType;
	private List<TypeDef<?>> parameters;
 
	DeviceRegistrySpec(Object returnType, Object ...params ) {

		try {
			this.returnType = SpecificationHelper.processType(returnType);
			this.parameters = SpecificationHelper.processTypes(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TypeDef<?>> getParameterTypes() {
		return this.parameters;
	}

	@Override
	public TypeDef<?> getReturnType() {
	
		return this.returnType;
	}

}
