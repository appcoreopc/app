package com.appCore.Scripting;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

public class GroovyScriptProvider implements ScriptProvider {

	// how do i use spring injection here to
	// instantiate my class

	GroovyScriptEngine scriptEngine;
	Binding binding = new Binding();
	GroovyClassLoader groovyLoader = new GroovyClassLoader(this.getClass().getClassLoader());
	String codeExecutionPath = "";
	
	public GroovyScriptProvider(String path) throws IOException {

		codeExecutionPath = path;
		scriptEngine = new GroovyScriptEngine(path);
	}

	public void setScriptPath(String codePath) throws IOException {
		scriptEngine = new GroovyScriptEngine(codePath);
	}
	
	
	public void executeScript(String groovyScriptName)
			throws ResourceException, ScriptException {
		scriptEngine.run(groovyScriptName, binding);
	}

	public <T> T getVariable(String variableName) {

		return (T) binding.getVariable(variableName);
	}

	public Map getVariables() {

		return binding.getVariables();
	}

	public void setVariable(String variableName, Object value) {

		binding.setVariable(variableName, value);
	}
	
	public Object invokeMethodOnClass(String scriptName,  String invokeMethodName, Object[] arguments) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException
	{
		Class groovyClass = groovyLoader.parseClass(new File(codeExecutionPath + scriptName));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		Object result = groovyObject.invokeMethod(invokeMethodName, arguments);
		return result;
	}
	
}
