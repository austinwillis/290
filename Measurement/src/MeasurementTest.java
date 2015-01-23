import static org.junit.Assert.*;

import org.junit.Test;


public class MeasurementTest {

	@Test
	public void test() {
		Measurement x = new Measurement(12, "kg");
		Measurement y = new Measurement(1, "m");
		Measurement z = new Measurement(1, "s");
		x = x.mult(y);
		x = x.div(z);
		x = x.div(z);
		System.out.println(x.toString());
		Measurement r = new Measurement(3, "ft");
		Measurement p = new Measurement(4, "lb");
		System.out.println(r.mult(p).toString());
		Measurement q = new Measurement(9.8, "m");
		Measurement l = new Measurement(10, "s");
		q = q.div(z);
		q = q.div(z);
		q = q.mult(l);
		System.out.println(q.toString());
		q = new Measurement(4, "in");
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		System.out.println(q.toString());
		q = new Measurement(1, "in");
		x = new Measurement(1, "in");
		x = x.mult(x);
		x = x.mult(x);
		q = q.div(x);
		System.out.println(q);
	}
}
