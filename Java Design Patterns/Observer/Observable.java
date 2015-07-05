public abstract class Observable<S extends Observable<S, O, A>, O extends <Observer<S, O, A>, A> {
	protected List<O> observers;
	public Observable() {
		this.observers = new CopyOnWriteArrayList<>();
	}
	public void addObserver(O observer) {
		this.observer.add(observer);
	}
	@SuppressWarnings("unchecked")
	public void notifyObservers(A argument) {
		for (O observer : observers) {
			observer.update((S) this, argument);
		}
	}
}