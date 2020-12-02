package br.com.solid.models;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.collect.Lists;

public class EqualsDelegate<T> {
	
	private static final ToStringStyle DEFAULT_STYLE = defaultStyle();
	private static final ToStringStyle STYLE_WITH_FIELD_NAME = withFildNameStyle();
	
	private final List<FieldExtractor<T>> getters = Lists.newArrayList();
	private Class<T> clazz;
	private ToStringStyle currentStyle = DEFAULT_STYLE;
	
	public EqualsDelegate(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	private static ToStringStyle withFildNameStyle() {
		StandardToStringStyle style = defaultStyle();
		style.setUseFieldNames(true);
		return style;
	}
	
	private static StandardToStringStyle defaultStyle() {
		StandardToStringStyle style = new StandardToStringStyle();
		style.setUseShortClassName(true);
		style.setUseFieldNames(false);
		style.setUseIdentityHashCode(false);
		return style;				
	}
	
	public static <T> EqualsDelegate<T> of(Class<T> clazz) {
		return new EqualsDelegate<T>(clazz);
	}
	
	public EqualsDelegate<T> append(String fieldName, FieldGetter<T> getter) {
		currentStyle = STYLE_WITH_FIELD_NAME;
		getters.add(new FieldExtractor<T>(fieldName, getter));
		return this;
	}
	
	public EqualsDelegate<T> append(FieldGetter<T> getter) {
		getters.add(new FieldExtractor<T>("", getter));
		return this;
	}
	
	public int toHashCode(T object) {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		getters.stream()
			.map(fe -> fe.fieldGetter)
			.forEach(getter -> hashCodeBuilder.append(getter.getFieldValue(object)));
		return hashCodeBuilder.toHashCode();
	}
	
	@SuppressWarnings("unchecked")
	public boolean isEquals(Object value, Object anotherValue) {
		if (!clazz.isInstance(value))
			throw new IllegalArgumentException(String.format("value não é do tipo %s", clazz.getCanonicalName()));
		if(!clazz.isInstance(anotherValue))
			return false;
		
		EqualsBuilder builder = new EqualsBuilder();
		getters.stream()
				.map(fe -> fe.fieldGetter)
				.forEach(getter -> builder.append(getter.getFieldValue((T) value), getter.getFieldValue((T) anotherValue)));
		
		return builder.build();
	}
	
	public String toStringForHumans(T valueObject) {
		ToStringBuilder builder = new ToStringBuilder(valueObject, currentStyle);
		getters.stream()
		.forEach(fextractor -> builder.append(fextractor.fieldName,
				fextractor.fieldGetter.getFieldValue((T) valueObject)));
		
		return builder.build();
	}
	
	private static class FieldExtractor<T> {
		private final String fieldName;
		private final FieldGetter<T> fieldGetter;
		
		public FieldExtractor(String fieldName, FieldGetter<T> fieldGetter) {
			super();
			this.fieldGetter = fieldGetter;
			this.fieldName = fieldName;
		}
	}
	
	public static interface FieldGetter<T> {
		Object getFieldValue(T source);
	}

}
