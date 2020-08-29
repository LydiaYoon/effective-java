package item02;

import static item02.Pizza.Topping.*;
import static item02.NyPizza.Size.*;

public class MakingPizza {

	public static void main(String[] args) {
		NyPizza nyPizza = new NyPizza.Builder(SMALL)
				.addTopping(SAUSAGE)
				.addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder()
				.addTopping(HAM)
				.sauceInside().build();

		System.out.println(nyPizza);
		System.out.println(calzone);
	}

}
