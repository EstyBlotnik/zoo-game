package graphics;

import plants.Cabbage;
import plants.Lettuce;
import utilities.MessageUtility;

import java.util.ArrayList;
import java.util.Stack;

public class Originator {
	private static Originator Originator_instance = null;
	private ZooPanel window;
	private History history;
	private Originator(ZooPanel window) {
		this.window = window;
		this.history=new History();
	}

	public static Originator getOriginator(ZooPanel pan){
		if (Originator_instance == null){
			synchronized (pan){
				if (Originator_instance == null){
					Originator_instance = new Originator(pan);
				}
			}
		}
		return Originator_instance;
	}
	public int getSize() {
		return history.m_undo.size();
	}
	private class History {
		private Stack<Memento> m_undo = new Stack<>();;
		public void save() {
			m_undo.push(window.save());
		}
		public void undo() {
			window.restore(m_undo.pop());
			}
		}
		
	public void hitSave() { history.save(); }
	public void hitUndo() { history.undo(); }
}
