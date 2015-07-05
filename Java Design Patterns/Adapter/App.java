/**
 * Applicability: Use the Adapter pattern when
 * 1. you want to use an existing class, and its interface does not match the one you need.
 * 2. you want to create a reusable class that cooperates with unrelated or unforceseen classes, that is,
 * classes that don't necessarily have compatible interfaces.
 * 3. you need to use several existing subclasses, but it's impractical to adapt their interface by subclassing every one.
 * An object adapter can adapt the interface of ite parent class.
 *
 * Intent: Convert the interface of a class into another interface the clients expect. Adapter lets classes work together
 * that couldn't otherwise because of incompatible interfaces.
 */
public class App {
	public static void main(String[] args) {
		Engineer engineer = new GnomeEngineeringManager();
		engineer.operateDevice();
	}
}