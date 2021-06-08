package deviceRegistrySpec;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Device implements Serializable {

	private static final long serialVersionUID = -7806185844606477491L;
	private String name;
    private Map<String, String> addresses = new HashMap<>();
    private Map<String, Serializable> attributes = new HashMap<>();
    private Set<String> groups = new HashSet<>();



    public Device(String name) {
        //assume user is smart enough to not enter duplicate names
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, ? extends Serializable> getAttributes() {
        return this.attributes;
    }

    public Map<String, String> getAddresses() {
        return this.addresses;
    }

    public void addAddress(String type, String address) {
        this.addresses.put(type, address);
    }

    public void setAttribute(String att, Serializable value) {
        this.attributes.put(att, value);
    }

    public void setAddresses(Map<String, String> m) {
        this.addresses = m;
    }

    public void setAttributes(Map<String, Serializable> m) {
        this.attributes = m;
    }

    public void addGroup(String g) {
        this.groups.add(g);
    }

    public void setGroups(Set<String> groups) {
        this.groups = groups;
    }

    public Set<String> getGroups() {
        return this.groups;
    }

    public void deleteAttribute(String att) {
        this.attributes.remove(att);
    }

    public void deleteGroup(String g) {
        this.groups.remove(g);
    }


}
