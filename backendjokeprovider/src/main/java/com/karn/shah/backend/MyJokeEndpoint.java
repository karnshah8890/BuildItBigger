/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.karn.shah.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myJokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.shah.karn.com",
    ownerName = "backend.shah.karn.com",
    packagePath=""
  )
)
public class MyJokeEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public MyJokeBean getJoke(MyJokeBean joke) {
        return joke;
    }

}
