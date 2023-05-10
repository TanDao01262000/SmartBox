package smartbox;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.*;


public class Component implements Serializable {

    private Set<Class<?>> requiredInterfaces;
    private Set<Class<?>> providedInterfaces;
    transient Map<Class<?>, Field> fields; // transient because Field not serializable
    protected Container container;
    protected String name;

    public Component() {
        fields = new HashMap<Class<?>, Field>();
        providedInterfaces = new HashSet<Class<?>>();
        requiredInterfaces = new HashSet<Class<?>>();
        computeRequiredInterfaces();
        computeProvidedInterfaces();
        container = null;
        name = this.getClass().getSimpleName();
    }


    public String toString() { return name; }

    void computeRequiredInterfaces() {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        for (Field field : fieldArray) {
            if (field.getType().isInterface()) {
                fields.put(field.getType(), field);
                requiredInterfaces.add(field.getType());
            }
        }
    }
    void computeProvidedInterfaces() {
        Class<?>[] interfs = this.getClass().getInterfaces();
        Collections.addAll(providedInterfaces, interfs);
    }

    public void setProvider(Class<?> intf, Component provider) throws Exception {
        Field field = fields.get(intf);
        field.set(this, provider); // field probably needs to be public for this.
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Set<Class<?>> getProvidedInterfaces() {
        return providedInterfaces;
    }

    public Set<Class<?>> getRequiredInterfaces() {
        return requiredInterfaces;
    }

    // needed by file/open
    public void initSupport() {
        fields = new HashMap<Class<?>, Field>();
        computeProvidedInterfaces();
        computeRequiredInterfaces();
    }

}