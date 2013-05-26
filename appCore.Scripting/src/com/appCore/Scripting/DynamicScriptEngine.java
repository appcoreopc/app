package com.appCore.Scripting;

import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.util.Map;

public class DynamicScriptEngine implements DynamicScripting {

	ScriptProvider scriptEngine;
	
	public DynamicScriptEngine(String codePath) throws IOException
	{
		 scriptEngine = new GroovyScriptProvider(codePath);
	}
	
	
	public void setScriptPath(String codePath) throws IOException {
	
		scriptEngine = new GroovyScriptProvider(codePath);
	}

	public void executeScript(String scriptName)
			throws ResourceException, ScriptException {
		scriptEngine.executeScript(scriptName);
		
	}

	public <T> T getVariable(String variableName) {
		return scriptEngine.getVariable(variableName);
	}

	public Map getVariables() {
		return scriptEngine.getVariables();
	}
	

	public void setVariable(String variableName, Object value) {
		scriptEngine.setVariable(variableName, value);
		
	}

	
	
}
