package test;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PluginA implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.err.println("I am Plugin A");
    }

    public void sayHi() {
        System.err.println("Plugin A is saying hi");
    }
}
