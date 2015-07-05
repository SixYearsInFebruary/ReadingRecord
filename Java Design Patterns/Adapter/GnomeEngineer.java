public class GnomeEngineer implements Engineer {
	private GoblinGilder gilder;
	public GnomeEngineer() {
		gilder = new GoblinGilder();
	}
	@Override
	public void operateDevice() {
		gilder.attachGilder();
		gilder.gainSpeed();
		gilder.takeOff();
	}
}