/**
 * Applicability: Use the Abstract Factory pattern when
 * 1. a system should be independent of how its products are created, composed and represented
 * 2. a system should be configured with one of multiple families of products
 * 3. a family of related product objects is designed to be used together, and you need to enforce this constraint
 * 4. you want to provide a class library of products, and you want to reveal just their interfaces,
 * not their implementations.
 *
 * Intent: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
 */
public class App {
	public static void main(String[] args) {
		createKingdom(new ElfKingdomFactory());
		createKingdom(new OrcKingdomFactory());
	}
	public static void createKingdom(KingdomFactory factory) {
		King king = factory.createKing;
		Castle castle = factory.createCastle;
		Army army = factory.createArmy;
		System.out.println("The kingdom was created.");
		System.out.println(king);
		System.out.println(castle);
		System.out.println(army);
	}
}