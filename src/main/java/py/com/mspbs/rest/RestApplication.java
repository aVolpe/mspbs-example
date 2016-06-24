package py.com.mspbs.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * 
 * @author Arturo Volpe
 *
 */
@ApplicationPath("/rest/")
public class RestApplication extends Application {

	HashSet<Object> singletons = new HashSet<>();

	public RestApplication() {
		BeanConfig beanConfig = new BeanConfig();

		beanConfig.setTitle("MSPBS");
		beanConfig.setDescription("My API");
		beanConfig.setVersion("1.0");
		beanConfig.setContact("");

		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setBasePath("/mspbs/rest");
		beanConfig.setResourcePackage("py.com");
		beanConfig.setScan(true);

	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<>();

		set.add(PersonaResource.class);

		set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		return set;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
