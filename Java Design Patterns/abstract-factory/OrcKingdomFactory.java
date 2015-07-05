public class OrcKingdomFactory extends KingdomFactory {
	public Castle createCastle() {
		return Castle();
	}
	public King createKing() {
		return King();
	}
	public Army createArmy() {
		return Army();
	}
}