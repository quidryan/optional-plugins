package test;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class PluginC implements Plugin<Project> {

    @Override
    public void apply(final Project project) {
        System.err.println("I am Plugin C");
        project.getPlugins().withId("test.plugin.a", new Action<Plugin>() {
            @Override
            public void execute(Plugin plugin) {
                PluginA otherPlugin = project.getPlugins().getPlugin(PluginA.class);
                otherPlugin.sayHi();
            }
        });
    }
}
