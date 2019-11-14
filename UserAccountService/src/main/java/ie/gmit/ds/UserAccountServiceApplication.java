package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserAccountServiceApplication extends Application<UserAccountServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new UserAccountServiceApplication().run(args);
    }

    @Override
    public void run(final UserAccountServiceConfiguration configuration,
                    final Environment environment) throws Exception{
        final UserApiResource resource = new UserApiResource();

        environment.jersey().register(resource);
    }

}
