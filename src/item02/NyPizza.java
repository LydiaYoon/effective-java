package item02;

import java.util.Objects;

public class NyPizza extends Pizza {

	public enum Size { // 열거형 클래스
		SMALL, MEDIUM, LARGE
	}

	/* member variable */
	// final: 한 번만 초기화
	private final Size size; // Size enum의 값 중 하나를 갖는 변수

	/* member class */
	// 부모 클래스 Pizza의 추상 멤버 클래스인 Builder를 구체화한다.
	public static class Builder extends Pizza.Builder<Builder> {

		// 필수 매개변수
		private final Size size;

		/* constructor using fields */
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		// 공변 반환 타이핑 (convariant return typing)
		// 자식 클래스(NyPizza)의 메서드가
		// 부모 클래스(Pizza)에서 정의한 반환 타입(Pizza)의 자식 클래스(NyPizza) 타입을 반환함
		// NyPizza가 Pizza의 자식 클래스이기 때문에 리턴타입을 NyPizza로 할 수 있음
		public NyPizza build() {
			return new NyPizza(this);
			// 상위 클래스 NyPizza의 인스턴스를 생성해서 리턴
		}

		@Override
		// self 메소드를 현재 클래스의 Builder를 리턴하도록 구체화하여 메소드 체이닝을 지원
		protected Builder self() {
			return this;
		}
	}

	/* constructor using fields */
	private NyPizza(Builder builder) {
		super(builder);
		// 부모 클래스의 생성자 호출
		size = builder.size;
		// builder에서 받은 값들로 인스턴스를 생성한다.
	}

	@Override
	public String toString() {
		return "NyPizza [size=" + size + ", " + super.toString() + "]";
	}
}
