package item03;

public class Elvis {
	/* public static final 필드 방식의 싱글턴 */
//	// 유일한 인스턴스를 public으로 만들어 접근 가능하게 하기
//	public static final Elvis INSTANCE = new Elvis();
//
//	int count;
//	// 생성자를 private으로 감추기
//	private Elvis() {
//		if (count++ > 1) {
//			throw new IllegalStateException("this object shuod be singleton");
//		}
//	}

	/* 정적 팩터리 방식의 싱글턴 */
	// 유일한 인스턴스 private으로 만들기
	private static final Elvis INSTANCE = new Elvis();

	// 생성자를 private으로 감추기
	private Elvis() {
		super();
	}

	// 정적 팩터리 메소드로 인스턴스에 접근 가능하게 만들기
	public static Elvis getInstance() {
		return INSTANCE;
	}

}
