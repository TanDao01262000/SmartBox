package smartbox;


import mvc.*;

import java.lang.reflect.Field;
import java.util.*;

public class Container extends Model {

    private Map<Class<?>, Component> providedInterfaces = new HashMap<Class<?>, Component>();
    private Map<Class<?>, Component> requiredInterfaces = new HashMap<Class<?>, Component>();
    private Map<String, Component> components = new HashMap<String, Component>();


    public Container(){

    }


    public void addComponent(String name) throws Exception {
        String qualName = "smartbox.components." +  name;
        //Object obj = a new instance of qualName;
        Class c = Class.forName(qualName);
        Object obj = c.newInstance();
        addComponent((Component)obj);
    }


    private void addComponent(Component component) throws Exception {
        component.setContainer(this);
        // add new guy to the components table:
        components.put(component.name, component);
        for(Class<?> intf: component.getProvidedInterfaces()) {
            providedInterfaces.put(intf,  component);
        }
        // update required interfaces table:
        for(Class<?> intf: component.getRequiredInterfaces()) {
            requiredInterfaces.put(intf,  component);
        }
        //find providers for the new component and hook him up:
        findProviders();
        // mvc stuff:
        changed();
    }

    public void remComponent(String name) throws Exception {
        Component component = components.get(name);
        components.remove(name);
        for(Class<?> intf: component.getProvidedInterfaces()) {
            for(Component client: components.values()) {
                if (client.getRequiredInterfaces().contains(intf)) {
                    client.setProvider(intf,  null);
                    requiredInterfaces.put(intf, client);
                }
            }
        }
        changed();
    }
    private void findProviders() throws Exception {
        Set<Class<?>> reqInterfaces = requiredInterfaces.keySet();
        for(Class<?> intf: reqInterfaces) {
            Component client = requiredInterfaces.get(intf);
            Component provider = providedInterfaces.get(intf);
            if (client != null && provider != null) {
                client.setProvider(intf,  provider);
                requiredInterfaces.put(intf,null);
            }
        }
    }

    public void launch(String name) throws Exception {
        try {
            Component com = components.get(name);
            if(com == null || !(com instanceof App)) {
                throw new Exception("Invalid Component: " + name);
            }
            ((App)com).main();
        }catch(Exception e) {
            Utilities.error(e.getMessage());
            e.printStackTrace();
        }

    }

    // needed by File/Open
    public void initSupport(){
        super.initSupport();
        for(Component c: components.values()){
            c.initSupport();
        }
        changed(); // needed?

    }

    public Collection<Component> getComponents() {
        return components.values();
    }
}
