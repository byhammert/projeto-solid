package br.com.solid.util;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class MoedaUtil {
	
	private static final String MOEDA = "BRL";
	
	public static CurrencyUnit getMoeda() {
		return CurrencyUnit.of(MOEDA);
	}
	
	public static Money zero() {
		return Money.zero(getMoeda());
	}
	
	public static Money of(final String valor) {
		return Money.parse(String.format("%s %s", MOEDA, valor));
	}

}
