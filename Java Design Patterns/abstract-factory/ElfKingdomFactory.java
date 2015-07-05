public class KingdomFactory extends KingdomFactory {
	public Castle createCastle() {
		return new Castle();
	}
	public King createKing() {
		return new King();
	}
	public Army createArmy() {
		return new Army();
	}
}