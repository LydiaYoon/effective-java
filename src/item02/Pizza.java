package item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 추상 클래스
// - 객체 생성 불가. 하위 클래스를 통해 객체 생성 가능
// - 추상메소드 중 일부만 override 가능
public abstract class Pizza {

	public enum Topping { // 열거형 클래스
		HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
	}

	/* member variable */
	// final:한 번만 초기화
	final Set<Topping> toppings; // Topping enum의 값을 요소로 갖는 Set (순서X, 중복X)

	/* member class (= nested, inner) */
	// static: 정적 클래스. 동일한 클래스의 모든 인스턴스끼리 공유함
	// 추상 빌더 클래스. 하위 클래스가 이를 상속받아 구체적인 빌더 클래스를 만들 것임
	abstract static class Builder<T extends Builder<T>> {

		/* member variable */
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		// EnumSet.noneOf: Topping 열거형을 요소로 갖는 빈 Set을 만든다.

		/* member method */
		// 하위 타입으로 리턴할 거라서 리턴 타입이 T 이다
		// 필요할 때에만 override 하도록 할거라 추상 메서드가 아니다.
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			// Objects.requireNonNull
			// : 매개변수가 null이면 NullPointerException, 
			// null이 아니면 매개변수 그대로 리턴
			// EnumSet.add: EnumSet에 요소를 추가한다
			// 메소드를 여러 번 호출하도록 하고 각 호출 때 넘겨진 매개변수들을
			// 하나의 필드인 toppings에 모아놓는다.
			return self();
		}

		// 추상 메소드
		// 자식 클래서에서 자식 클래스타입을 리턴하도록 override 한다.
		abstract Pizza build();

		// 메소드 연쇄를 지원하기 위한 self 메소드
		// 자식 클래스에서 "this"를 반환하도록 override 한다.
		// 추상 메소드로 선언했기 때문에 자식 메소드에서 자식메소드의 Builder를 리턴하게 만들면
		// 형변환 하지 않고도 메소드 체이닝 가능
		// 자바에는 self 타입이 없기 때문에 이러한 관용구를 사용
		protected abstract T self();
	}

	/* constructor using fields */
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone(); // 아이템 50 : 방어적 복사본
		// builder를 통해 topping 멤버 변수를 한 번만(final) 초기화
	}

	@Override
	public String toString() {
		return "toppings=" + toppings;
	}
	
}
