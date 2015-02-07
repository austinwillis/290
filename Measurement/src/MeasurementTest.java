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
		assertEquals(x.toString(),"12.0kgm/s^2");
		Measurement r = new Measurement(3, "ft");
		Measurement p = new Measurement(4, "lb");
		assertEquals(r.mult(p).toString(), "12.0ftlb");
		Measurement q = new Measurement(9.8, "m");
		Measurement l = new Measurement(10, "s");
		q = q.div(z);
		q = q.div(z);
		q = q.mult(l);
		assertEquals(q.toString(), "98.0m/s");
		q = new Measurement(4, "in");
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		q = q.mult(q);
		assertEquals(q.toString(), "1.8446744073709552E19in^32");
		q = new Measurement(1, "in");
		x = new Measurement(1, "in");
		x = x.mult(x);
		x = x.mult(x);
		q = q.div(x);
		assertEquals(q.toString(), "1.0/in^3");
	}
}
