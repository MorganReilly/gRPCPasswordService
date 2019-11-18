package ie.gmit.ds;

import ie.gmit.ds.health.UserHealthCheck;
import ie.gmit.ds.resources.UserApiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application is the entry point for Dropwizard application
 *
 * Bootstrap class
 */
public class UserAccountServiceApplication extends Application<UserAccountServiceConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceApplication.class);

    /**
     * When application starts => create new instance of resource class with params
     * from config file => hands off to Environment (registry of all things application)
     *
     * @param configuration
     * @param environment
     */
    @Override
    public void run(final UserAccountServiceConfiguration configuration,
                    final Environment environment) throws Exception {
        logger.info("Registering REST resource");
        environment.jersey().register(new UserApiResource(environment.getValidator()));

        final UserHealthCheck healthCheck = new UserHealthCheck();
        environment.healthChecks().register("User", healthCheck);
    }

    public static void main(final String[] args) throws Exception {
        new UserAccountServiceApplication().run(args);
    }

}
