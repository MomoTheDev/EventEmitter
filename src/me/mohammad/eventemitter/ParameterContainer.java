package me.mohammad.eventemitter;

import java.util.HashMap;
import java.util.Map;

public class ParameterContainer {

	private Map<String, Object> parameters;

	public ParameterContainer() {
		parameters = new HashMap<>();
	}

	public boolean validate(final String... keys) {
		for (final String key : keys) {
			if (!(contains(key)))
				return false;
		}
		return true;
	}

	public ParameterContainer add(final String key, final Object object) {
		parameters.put(key, object);
		return this;
	}

	public ParameterContainer remove(final String key) {
		parameters.remove(key);
		return this;
	}

	public boolean contains(final String key) {
		return parameters.containsKey(key);
	}

	public Object get(final String key) {
		return parameters.get(key);
	}

	public String getString(final String key) {
		return (String) get(key);
	}

	public Byte getByte(final String key) {
		return Byte.parseByte((String) get(key));
	}

	public Short getShort(final String key) {
		return Short.parseShort((String) get(key));
	}

	public Integer getInteger(final String key) {
		return Integer.parseInt((String) get(key));
	}

	public Long getLong(final String key) {
		return Long.parseLong((String) get(key));
	}

	public Float getFloat(final String key) {
		return Float.parseFloat((String) get(key));
	}

	public Double getDouble(final String key) {
		return Double.parseDouble((String) get(key));
	}

}
