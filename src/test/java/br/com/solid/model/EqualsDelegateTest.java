package br.com.solid.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.solid.models.EqualsDelegate;
import br.com.solid.models.ValueObject;

public class EqualsDelegateTest {
	
	private EqualsDelegate<FooSuperHero> builder;
	
	@BeforeEach
	public void setup() {
		builder = EqualsDelegate.of(FooSuperHero.class);
		
		builder.append("id", p -> p.id);
		builder.append("name", p -> p.name);
	}
	
	@Test
	public void toHashCode() {
		assertThat(builder.toHashCode(new FooSuperHero(1, "Goku")))
		.isEqualTo(builder.toHashCode(new FooSuperHero(1, "Goku")));
		
		assertThat(builder.toHashCode(new FooSuperHero(1, "Goku")))
		.isNotEqualTo(builder.toHashCode(new FooSuperHero(2, "Goku")));
		
		assertThat(builder.toHashCode(new FooSuperHero(1, "Goku")))
		.isNotEqualTo(builder.toHashCode(new FooSuperHero(1, "Kakaroto")));
	}
	
	@Test
	public void isEquals() {
		assertThat(builder.isEquals(new FooSuperHero(1, "Goku"), new FooSuperHero(1, "Goku"))).isTrue();
		assertThat(builder.isEquals(new FooSuperHero(1, "Goku"), new FooSuperHero(2, "Goku"))).isFalse();
		
		assertThat(builder.isEquals(new FooSuperHero(1, "Goku"), new Student())).isFalse();
		assertThat(builder.isEquals(new FooSuperHero(1, "Goku"), new FooSuperHero(1, "Kakaroto"))).isFalse();
	}
	
	@Test
	public void isEquals_deve_lancarException_quando_valueForDeUmTipoDiferenteDoEsperado() {
		assertThatThrownBy(() -> {
			builder.isEquals(new Student(), new FooSuperHero(1, "Goku"));
		})
		.isExactlyInstanceOf(IllegalArgumentException.class)
		.hasMessage("value não é do tipo %s", FooSuperHero.class.getCanonicalName());
	}
	
	@Test
	public void toStringForHumans() {
		assertThat(builder.toStringForHumans(new FooSuperHero(1, "Goku"))).endsWith("FooSuperHero[id=1,name=Goku]");
	}
	
	@Test
	public void toStringForHumans_deve_suprimirNomeDosCampos_quando_naoForemInformados() {
		builder = EqualsDelegate.of(FooSuperHero.class);
		builder.append(p -> p.id);
		builder.append(p -> p.name);
		
		assertThat(builder.toStringForHumans(new FooSuperHero(1, "Goku"))).endsWith("FooSuperHero[1,Goku]");
		assertThat(new FooSuperHero(1, "Goku").toString()).endsWith("FooSuperHero[1,Goku]");
	}
	
	private static class FooSuperHero extends ValueObject<FooSuperHero> {
		
		public int id;
		public String name;
		
		public FooSuperHero(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		protected EqualsDelegate<FooSuperHero> createHashAndEqualsDelegate() {
			return EqualsDelegate.of(FooSuperHero.class)
					.append(x -> x.id)
					.append(x -> x.name);
		}
	}
	
	private static class Student {
		
	}

}
