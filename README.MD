If a dependency is added in the init script (e.g. done in an Enterprise environemnt's custom wrapper or company-wide init script), it can not "see"
other dependencies loaded into the project's buildscript. There are three plugins in this repo, and two projects. Plugin B has an optional dependency 
on A, while Plugin C has a runtime depenency on A. Both when loaded will look for Plugin A and have it say "hi." Project B and Project C use, respectively,
Plugin B and Plugin C. The instructions below show that when the plugin is directly referenced it works, but when the plugin is added in an init script
AND the dependency is optional, the build will fail.

    cd plugin-a
    ./gradlew install
    cd ../plugin-b
    ./gradlew install
    cd ../plugin-c
    ./gradlew install

    cd ../proj-b/
    
    # Works find and prints "Plugin A is saying hi"
    ./gradlew projects
    
    # Dependency added via init script can't see optional dependencies in project's buildscript
    ./gradlew -I init.gradle -b build.gradle projects
    
    cd ../proj-c/

    # Dependency added via init script with a non-optional dependency will work!
    ./gradlew -I init.gradle -b build.gradle projects

I contend that it's important for plugins to be able to see other, so that they can interact. It's a powerful technique need for plugins
to collaborate. E.g. We use information collected in the gradle-info-plugin as a manifest for JARs and DEB files. Another example would
be a "company" plugin that configures other general plugins to be specific to their infrastructure.
