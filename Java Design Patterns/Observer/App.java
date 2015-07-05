/**
 * Applicability: Use the Observer pattern in any of the following situations
 * 1. when an abstraction has two aspects, one dependent on the other. Encapsulating these aspects in separate
 * objects lets you vary and reuse them independently.
 * 2. when a change to one object requires changing others, and you don't know how many objects need to be changed.
 * 3. when an object should be able to notify the other objects without making assumptions about who these objects are.
 * In other words, you don't want these objects tightly coupled.
 *
 * Intent: Define a one-to-many dependency between objects so that when one objects changes state,
 * all its dependents are notified and updated automatically.
 */
public class App {
	public static void main(String[] args) {
		Weather weather = new Weather();
		weather.addObserver(new Orcs());
		weather.addObserver(new Hobbits());

		weather.timePasses();
		weather.timePasses();
		weather.timePasses();
		weather.timePasses();

		System.out.println("\n--Running generic version--");
		GWeather gWeather = new GWeather();
		gWeather.addObserver(new GHobbits());
		gWeather.addObserver(new GOrcs());

		gWeather.timePasses();
		gWeather.timePasses();
		gWeather.timePasses();
		gWeather.timePasses();
	}
}