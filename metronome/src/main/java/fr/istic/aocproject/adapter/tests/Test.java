package fr.istic.aocproject.adapter.tests;

import org.junit.Assert;
import org.junit.Before;

import fr.istic.aocproject.controller.Controller;
import fr.istic.aocproject.metronomeEngine.MetronomeEngine;

/**
 * @author amhachi & chaabi
 * Class of Test
 */

public class Test {
	
	/**
	 * Controller ctl
	 * <pre> Control instance <pre>
	 */
	private Controller ctl;
	
	/**
	 * setUp method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		ctl = (Controller) Controller.getControllerInstance();
	}
	
	/**
	 * Test of the metronome shut down
	 * @throws Exception
	 */
	@org.junit.Test
	public void testEteintBase() {
	Assert.assertFalse(ctl.getMetronomieEngine().isRunning());
	}
	
	/**
	 * Test of the metronome run up
	 * @throws Exception
	 */
	@org.junit.Test
	public void testEnMarche() {
	ctl.start();
	Assert.assertTrue(ctl.getMetronomieEngine().isRunning());
	}
	

	/**
	 * Test of incrementation
	 * @throws Exception
	 */
	@org.junit.Test
	public void testInc() {
	int old = ctl.getMetronomieEngine().getNtm();
	ctl.inc();
	Assert.assertEquals(old + 1, ctl.getMetronomieEngine().getNtm().intValue());
	}
	

	/**
	 * Test of decrementation
	 * @throws Exception
	 */
	@org.junit.Test
	public void testDec() {
	int old = ctl.getMetronomieEngine().getNtm();
	ctl.dec();
	Assert.assertEquals(old - 1, ctl.getMetronomieEngine().getNtm().intValue());
	}


	/**
	 * Test of incrementation maximum
	 * @throws Exception
	 */
	@org.junit.Test
	public void testIncMax() {
	for (int i = 0; i < 10; i++)
	ctl.inc();
	Assert.assertEquals(MetronomeEngine.NTM_MAX_VALUE.intValue(), ctl.getMetronomieEngine().getNtm().intValue());
	}
	

	/**
	 * Test of decrementation minimum
	 * @throws Exception
	 */
	@org.junit.Test
	public void testDecMax() {
	for (int i = 0; i < 10; i++)
	ctl.dec();
	Assert.assertEquals(MetronomeEngine.NTM_MIN_VALUE.intValue(), ctl.getMetronomieEngine().getNtm().intValue());
	}
}

