import java.util.ArrayList;
import java.util.Collections;


public class Measurement {

	private double value;
	private ArrayList<String> num;
	private ArrayList<String> denom;
	
	private ArrayList<String> getNum() {
		return this.num;
	}

	private void setNum(ArrayList<String> num) {
		this.num = num;
	}

	private ArrayList<String> getDenom() {
		return denom;
	}

	private void setDenom(ArrayList<String> denom) {
		this.denom = denom;
	}

	private double getValue() {
		return value;
	}

	private void setValue(double value) {
		this.value = value;
	}
	
	public Measurement() {
		this.value = 0.0;
		this.num = new ArrayList<String>();
		this.denom = new ArrayList<String>();
	}
	
	public Measurement(double value, String num) {
		this.setValue(value);
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(num);
		this.setNum(temp);
		this.denom = new ArrayList<String>();
	}
	
	private Measurement(double value, ArrayList<String> num, ArrayList<String> denom) {
		simplify(num, denom);
		this.setValue(value);
		this.setNum(num);
		this.setDenom(denom);
	}
	
	public Measurement add(Measurement x) {
		if ((x.getNum().equals(this.getNum())) && (x.getDenom().equals(this.getDenom()))) {
		return new Measurement(x.getValue() + this.getValue(), this.getNum(), this.getDenom());
		}
		else throw new ArithmeticException();
	}
	
	public Measurement sub(Measurement x) {
		if ((x.getNum().equals(this.getNum())) && (x.getDenom().equals(this.getDenom()))) {
		return new Measurement(this.getValue() - x.getValue(), this.getNum(), this.getDenom());
		}
		else throw new ArithmeticException();
	}
	
	public Measurement mult(Measurement x) {
		return new Measurement((this.getValue() * x.getValue()), concatlist(this.getNum(), x.getNum()), concatlist(this.getDenom(), x.getDenom()));
	}
	
	public Measurement div(Measurement x) {
		return new Measurement((this.getValue() / x.getValue()), concatlist(this.getNum(), x.getDenom()), concatlist(this.getDenom(), x.getNum()));
	}
	
	public String toString() {
		String s = new String();
		s += Double.toString(this.getValue());
		s += unitToString(this.getNum());
		if (this.getDenom().size() > 0) {
		s += "/"; 
		s += unitToString(this.getDenom());
		}
		return s;
	}

	private void simplify(ArrayList<String> num2, ArrayList<String> denom2) {
		String temp;
		for (int i = 0; i < num2.size(); i++) {
			temp = num2.get(i);
				if (denom2.remove(temp)) {
					num2.remove(temp);
			}
		}
	}

	private String unitToString(ArrayList<String> listofString) {
		String output = new String();
		String temp = new String();
		int count = 1;
		ArrayList<String> newlist = new ArrayList<String>();
		newlist.addAll(listofString);
		for (int i = 0; i < newlist.size(); ) {
			count = 1;
			for (int j = i + 1; j < newlist.size(); j++) {
				if (newlist.get(i).equals(newlist.get(j))) {
					count ++;
				}
			}
			output += newlist.get(i);
			temp = newlist.get(i);
			if (count > 1) {
				output += "^" + Integer.toString(count);
			}
			while(newlist.remove(temp)) { }
		}
		return output;
	}
	
	private ArrayList<String> concatlist(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> newlist = new ArrayList<String>();
		newlist.addAll(list1);
		newlist.addAll(list2);
		Collections.sort(newlist); 
		return newlist;
	}
}
