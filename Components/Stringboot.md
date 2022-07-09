### What is the difference between the Plugin and Dependencies?

Both plugins and dependencies are Jar files.

But the difference between them is, most of the work in maven is done using plugins; whereas dependency is just a Jar file which will be added to the 
classpath while executing the tasks.For example, you use a compiler-plugin to compile the java files. You can't use compiler-plugin as a dependency since 
that will only add the plugin to the classpath, and will not trigger any compilation. The Jar files to be added to the classpath while compiling the file, 
will be specified as a dependency.

Same goes with your scenario. You have to use spring-plugin to execute some spring executables [ I'm not sure what spring-plugins are used for. I'm just taking a guess here ]. 
But you need dependencies to execute those executables. And Junit is tagged under dependency since it is used by surefire-plugin for executing unit-tests.

So, we can say, plugin is a Jar file which executes the task, and dependency is a Jar which provides the class files to execute the task.
