package Tables;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuTableNotifyMachine implements Publisher{
	ArrayList<Observer> observers = new ArrayList<Observer>();
	MenuTableNotifyMachine machine = null;
	ArrayList<HashMap<String, String>> list;
	
	public MenuTableNotifyMachine() {
		this.machine = this;
		this.list = new ArrayList<HashMap<String, String>>();
	}
	@SuppressWarnings("unchecked")
	public void listAdd(Object obj) {
		list.add((HashMap<String, String>)obj);
		notifyObservers();
	}
	
	
	@Override
	public void add(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void delete(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer observer: observers)
			observer.update();
	}
	
	public MenuTableNotifyMachine getMachine() { return this.machine; }
	
	public void setList(ArrayList<HashMap<String, String>> list) { this.list = list; }
	public ArrayList<HashMap<String, String>> getList(){ return this.list; }
}
