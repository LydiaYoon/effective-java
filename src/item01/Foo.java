package item01;

import java.util.EnumSet;

public class Foo {

//	String name;
//	String address;
//	public static final Foo INSTANCE = new Foo();
//
////	 생성자
//	public Foo() {
//		super();
//	}
//
//	public Foo(String name) {
//		this.name = name;
//	}
//
////	같은 타입을 매개변수로 받는 생성자를 여러 개 만들 수 없다.
////	public Foo (String address) {
////		this.address = address;
////	}
//
////	 정적 팩토리 메서드
//	public static Foo withName(String name) {
//		return new Foo(name);
//	}
//
////	 정적 팩토리 메서드는 같은 타입을 매개변수로 받는 메서드를 이름을 다르게 정의해서 여러 개 만들 수 있다.
//	public static Foo withAddress(String address) {
//		Foo foo = new Foo();
//		foo.address = address;
//		return foo;
//	}
//
//	public static Foo getInstance() {
//		return INSTANCE;
//	}
//
//	public static Foo getFoo(boolean flag) {
//		return flag ? new Foo() : new BarFoo();
//	}
//
//	static class BarFoo extends Foo {
//	}
//
//	public static void main(String[] args) {
////		 생성자
//		Foo foo1 = new Foo("lydia");
//
////		 정적 팩토리 메서드
//		Foo foo2 = Foo.withName("lydia");
//		Foo foo3 = Foo.withAddress("seoul");
//		Foo foo4 = Foo.getInstance();
//
//		Foo foo5 = Foo.getFoo(false);
//	}

	enum Color {
		RED, BLUE, WHITE
	}

	public static void main(String[] args) {
		EnumSet<Color> colors = EnumSet.allOf(Color.class);
		EnumSet<Color> blueAndWhite = EnumSet.of(Color.BLUE, Color.WHITE);
		System.out.println(colors); // [RED, BLUE, WHITE]
		System.out.println(blueAndWhite); // [BLUE, WHITE]
	}
	
	
	
	public static void doSomethingToday() {
		// TODO 치과에 간다
		dailyRoutine();
	}
	
	public static void doSomethingTomorrow() {
		// TODO 마트에 간다
		dailyRoutine();
	}
	
	private static void dailyRoutine() {
		// TODO 자바 공부를 한다 
		// TODO 맛있는걸 먹는다
	}

}
