package colruyt.trsweb;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("System")
public class SystemApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(MyResource.class);

        return resources;
    }

}