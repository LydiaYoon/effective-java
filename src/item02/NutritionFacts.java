package item02;

public class NutritionFacts {

	/*
	 * // 점층적 생성자 패턴(telescoping constructor pattern) private final int servingSize;
	 * // (ml, 1회 제공량) 필수 private final int servings; // (회, 총 n회 제공량) 필수 private
	 * final int calories; // (1회 제공량당) 선택 private final int fat; // (g/1회 제공량) 선택
	 * private final int sodium; // (mg/1회 제공량) 선택 private final int carbohydrate;
	 * // (g/1회 제공량) 선택
	 * 
	 * public NutritionFacts(int servingSize, int servings) { this(servingSize,
	 * servings, 0); }
	 * 
	 * public NutritionFacts(int servingSize, int servings, int calories) {
	 * this(servingSize, servings, calories, 0); }
	 * 
	 * public NutritionFacts(int servingSize, int servings, int calories, int fat) {
	 * this(servingSize, servings, calories, fat, 0); }
	 * 
	 * public NutritionFacts(int servingSize, int servings, int calories, int fat,
	 * int sodium) { this(servingSize, servings, calories, fat, sodium, 0); }
	 * 
	 * public NutritionFacts(int servingSize, int servings, int calories, int fat,
	 * int sodium, int carbohydrate) { this.servingSize = servingSize; this.servings
	 * = servings; this.calories = calories; this.fat = fat; this.sodium = sodium;
	 * this.carbohydrate = carbohydrate; }
	 * 
	 * public static void main(String[] args) { NutritionFacts cocaCola = new
	 * NutritionFacts(240, 8, 100, 0, 35, 27); }
	 */

	/*
	 * // 자바빈즈 패턴(JavaBeans pattern) // 매개변수들은 기본값이 있다면 기본값으로 초기화된다. private int
	 * servingSize = -1; // 필수, 기본값 없음 private int servings = -1; // 필수, 기본값 없음
	 * private int calories = 0; private int fat = 0; private int sodium = 0;
	 * private int carbohydrate = 0;
	 * 
	 * // 생성자 public NutritionFacts() { }
	 * 
	 * // setter public void setServingSize(int servingSize) { this.servingSize =
	 * servingSize; }
	 * 
	 * public void setServings(int servings) { this.servings = servings; }
	 * 
	 * public void setCalories(int calories) { this.calories = calories; }
	 * 
	 * public void setFat(int fat) { this.fat = fat; }
	 * 
	 * public void setSodium(int sodium) { this.sodium = sodium; }
	 * 
	 * public void setCarbohydrate(int carbohydrate) { this.carbohydrate =
	 * carbohydrate; }
	 * 
	 * public static void main(String[] args) { NutritionFacts cocaCola = new
	 * NutritionFacts(); cocaCola.setServingSize(240); cocaCola.setServings(8);
	 * cocaCola.setCalories(100); cocaCola.setSodium(35);;
	 * cocaCola.setCarbohydrate(27); }
	 */

	// 빌더 패턴(Builder pattern)
	/* member variable */
	// final: 한 번만 초기화. (immutable)
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	/* member class */
	public static class Builder {
		// 필수 매개변수
		private final int servingSize;
		private final int servings;

		// 선택 매개변수 - 기본값으로 초기화
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;

		// 필수 매개변수를 받는 Builder 생성자
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		// 선택 매개변수를 받는 각각의 메소드들
		// this를 리턴하여 메소드 체이닝 지원
		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		// Builder를 통해 받은 내용을
		// 상위 클래스인 NutritionFacts의 생성자로 보낸다.
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	/* constructor using fields */
	private NutritionFacts(Builder builder) {
		// builderdㅔ서 받은 값들로 인스턴스를 생성한다.
		// 필요한 매개변수를 builder에서 모두 받아놓고
		// 인스턴스 생성 시 한 번에 설정하기 때문에 불변성을 유지한다.
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100).sodium(35).carbohydrate(27).build();
		// 메소드 체이닝을 지원하기 때문에 인스턴스를 이렇게 생성할 수 있
	}

}
