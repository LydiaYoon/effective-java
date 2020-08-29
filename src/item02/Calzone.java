package item02;

public class Calzone extends Pizza {

	/* member variable */
	// final: 한 번만 초기화
	private final boolean sauceInside;

	/* member class */
	// 부모 클래스 Pizza의 추상 멤버 클래스인 Builder를 구체화한다.
	public static class Builder extends Pizza.Builder<Builder> {

		// 선택 매개변수 - 기본값으로 초기화
		private boolean sauceInside = false;

		public Builder sauceInside() {
			this.sauceInside = true;
			return this;
		}

		@Override
		// 공변 반환 타이핑 (convariant return typing)
		// 자식 클래스(Calzone)의 메서드가
		// 부모 클래스(Pizza)에서 정의한 반환 타입(Pizza)의 자식 클래스(Calzone) 타입을 반환함
		// Calzone가 Pizza의 자식 클래스이기 때문에 리턴타입을 Calzone로 할 수 있음
		public Calzone build() {
			return new Calzone(this);
			// 상위 클래스 Calzone의 인스턴스를 생성해서 리턴
		}

		@Override
		// self 메소드를 현재 클래스의 Builder를 리턴하도록 구체화하여 메소드 체이닝을 지원
		protected Builder self() {
			return this;
		}
	}

	/* constructor using fields */
	private Calzone(Builder builder) {
		super(builder);
		// 부모 클래스의 생성자 호출
		sauceInside = builder.sauceInside;
		// builder에서 받은 값들로 인스턴스를 생성한다.
	}

	@Override
	public String toString() {
		return "Calzone [sauceInside=" + sauceInside + ", " + super.toString() + "]";
	}
	
}
