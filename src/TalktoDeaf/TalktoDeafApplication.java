package TalktoDeaf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;



public class TalktoDeafApplication extends Application {

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TalktoDeafWS.class);
//        classes.add(RestServiceUploadProvider.class);
//        classes.add(CdgDltMobileServiceWS.class);
//        classes.add(CdgDltMobileServiceWS.class);
//        classes.add(CdgDltMobileServiceWS.class);
        return classes;
    }
}
