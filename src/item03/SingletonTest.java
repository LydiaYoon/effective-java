package item03;

public class SingletonTest {

	public static void main(String[] args) {

		// 생성자가 private으로 감춰져있기 때문에 이렇게 쓸 수 없다.
		// Elvis elvis = new Elvis();

		/* public static final 필드 방식의 싱글턴 */
		// 이미 생성된 유일한 인스턴스를 받아와서 사용해야한다.
//		Elvis elvis = Elvis.INSTANCE;

		// 리플렉션을 사용해 private 생성자를 호출할 수 있다.
		// 이러한 공격을 방어하려면 생성자를 수정하여 두번 째 객체가 생성되려할 때 예외를 던지게 만든다.
//		Constructor<Elvis> constructor = Elvis.class.getConstructor();
//		constructor.setAccessible(true);
//		Elvis elvis2 = constructor.newInstance();

		/* 정적 팩터리 방식의 싱글턴 */
		Elvis elvis = Elvis.getInstance();
	}

}
