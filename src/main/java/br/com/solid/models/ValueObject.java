package br.com.solid.models;

public abstract class ValueObject <T extends ValueObject<T>> {
	
	protected final EqualsDelegate<T> equalsDelegate = createHashAndEqualsDelegate();
	protected abstract EqualsDelegate<T> createHashAndEqualsDelegate();
	
	@SuppressWarnings("unchecked")
	@Override
	public int hashCode() {
		return equalsDelegate.toHashCode((T) this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return equalsDelegate.isEquals(this, obj);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		return equalsDelegate.toStringForHumans((T) this);
	}

}
