import static org.junit.Assert.*;

import org.junit.Test;

public class TestFecha {
	
	@Test
	public final void testFechaIntIntInt() {
		Fecha prueba1 = new Fecha(2000,12,1);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 1);
	}

	@Test
	public final void testEsBisiesto() {
		assertTrue("El año 2000 es bisiesto",Fecha.esBisiesto(2000));
		assertFalse("El año 2100 no es bisiesto", Fecha.esBisiesto(2100));
	}

	@Test
	public final void testEsFechaValida() {
		assertTrue("1/1/2000",Fecha.esFechaValida(2000,1,1));
		assertFalse("1/30/2000", Fecha.esFechaValida(2000, 30, 1));
	}

	@Test
	public final void testSetFecha() {
		Fecha prueba1 = new Fecha();
		try{
			prueba1.setFecha(2000, 12, 1);
		}
		catch(IllegalArgumentException e){
			fail("La fecha no vale "+e);
		}
		catch(IllegalStateException e){
			fail("El año no vale "+e);
		}
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 1);
	}

	@Test
	public final void testSetAnio() {
		Fecha prueba1 = new Fecha();
		prueba1.setAnio(3000);
		assertEquals("Anio correcto", prueba1.getAnio(), 3000);
	}

	@Test
	public final void testSetMes() {
		Fecha prueba1 = new Fecha();
		prueba1.setMes(11);
		assertEquals("Anio correcto", prueba1.getMes(), 11);
	}

	@Test
	public final void testSetDia() {
		Fecha prueba1 = new Fecha();
		prueba1.setDia(30);
		assertEquals("Anio correcto", prueba1.getDia(), 30);
	}

	@Test
	public final void testSiguienteDia() {
		Fecha prueba1 = new Fecha(2000,12,31);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 31);
		prueba1.siguienteDia();
		assertEquals("Anio correcto", prueba1.getAnio(), 2001);
		assertEquals("Mes correcto", prueba1.getMes(), 1);
		assertEquals("Dia correcto", prueba1.getDia(), 1);
	}

	@Test
	public final void testAnteriorDia() {
		Fecha prueba1 = new Fecha(2000,12,31);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 31);
		prueba1.anteriorDia();
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 30);
	}

	@Test
	public final void testSiguienteMes() {
		Fecha prueba1 = new Fecha(2001,1,30);
		assertEquals("Anio correcto", prueba1.getAnio(), 2001);
		assertEquals("Mes correcto", prueba1.getMes(), 1);
		assertEquals("Dia correcto", prueba1.getDia(), 30);
		prueba1.siguienteMes();
		assertEquals("Anio correcto", prueba1.getAnio(), 2001);
		assertEquals("Mes correcto", prueba1.getMes(), 2);
		assertEquals("Dia correcto", prueba1.getDia(), 28);
	}

	@Test
	public final void testAnteriorMes() {
		Fecha prueba1 = new Fecha(2000,1,12);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 1);
		assertEquals("Dia correcto", prueba1.getDia(), 12);
		prueba1.anteriorMes();
		assertEquals("Anio correcto", prueba1.getAnio(), 1999);
		assertEquals("Mes correcto", prueba1.getMes(), 12);
		assertEquals("Dia correcto", prueba1.getDia(), 12);
	}

	@Test
	public final void testSiguienteAnio() {
		Fecha prueba1 = new Fecha(2000,2,29);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 2);
		assertEquals("Dia correcto", prueba1.getDia(), 29);
		prueba1.siguienteAnio();
		assertEquals("Anio correcto", prueba1.getAnio(), 2001);
		assertEquals("Mes correcto", prueba1.getMes(), 2);
		assertEquals("Dia correcto", prueba1.getDia(), 28);
	}

	@Test
	public final void testAnteriorAnio() {
		Fecha prueba1 = new Fecha(2000,1,12);
		assertEquals("Anio correcto", prueba1.getAnio(), 2000);
		assertEquals("Mes correcto", prueba1.getMes(), 1);
		assertEquals("Dia correcto", prueba1.getDia(), 12);
		prueba1.anteriorAnio();
		assertEquals("Anio correcto", prueba1.getAnio(), 1999);
		assertEquals("Mes correcto", prueba1.getMes(), 1);
		assertEquals("Dia correcto", prueba1.getDia(), 12);
	}

}
