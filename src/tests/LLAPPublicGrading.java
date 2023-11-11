package tests;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import code.LLAPSearch;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LLAPPublicGrading {

	String initialState0 = "17;" +
                "49,30,46;" +
                "7,57,6;" +
                "7,1;20,2;29,2;" +
                "350,10,9,8,28;" +
                "408,8,12,13,34;";
	String initialState1 = "50;" +
                "12,12,12;" +
                "50,60,70;" +
                "30,2;19,2;15,2;" +
                "300,5,7,3,20;" +
                "500,8,6,3,40;";
    String initialState2 = "30;" +
                "30,25,19;" +
                "90,120,150;" +
                "9,2;13,1;11,1;" +
                "3195,11,12,10,34;" +
                "691,7,8,6,15;";
    String initialState3 = "0;" +
                "19,35,40;" +
                "27,84,200;" +
                "15,2;37,1;19,2;" +
                "569,11,20,3,50;"+
                "115,5,8,21,38;" ;

    String initialState4 = "21;" +
                "15,19,13;" +
                "50,50,50;" +
                "12,2;16,2;9,2;" +
                "3076,15,26,28,40;" +
                "5015,25,15,15,38;";
    String initialState5 = "72;" +
                "36,13,35;" +
                "75,96,62;" +
                "20,2;5,2;33,2;" +
                "30013,7,6,3,36;" +
                "40050,5,10,14,44;";
    String initialState6 = "29;" +
                "14,9,26;" +
                "650,400,710;" +
                "20,2;29,2;38,1;" +
                "8255,8,7,9,36;" +
                "30670,12,12,11,36;";
	String initialState7= "1;" +
			"6,10,7;" +
			"2,1,66;" +
			"34,2;22,1;14,2;" +
			"1500,5,9,9,26;" +
			"168,13,13,14,46;";
	String initialState8 = "93;" +
			"46,42,46;" +
			"5,32,24;" +
			"13,2;24,1;20,1;" +
			"155,7,5,10,7;" +
			"5,5,5,4,4;";
	String initialState9 = "50;" +
			"20,16,11;" +
			"76,14,14;" +
			"7,1;7,1;7,1;" +
			"359,14,25,23,39;" +
			"524,18,17,17,38;";
	String initialState10= "32;" +
			"20,16,11;" +
			"76,14,14;" +
			"9,1;9,2;9,1;" +
			"358,14,25,23,39;" +
			"5024,20,17,17,38;";

	@Test(timeout = 120000)
	public void testa0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testa1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testa2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testa3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testa4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "BF", false);
	    solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testa5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testa6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testa7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testa8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testa9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testa10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "BF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}


	@Test(timeout = 120000)
	public void testb0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testb1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testb2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testb3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testb4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "DF", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testb5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testb6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testb7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testb8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testb9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testb10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "DF", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}
	@Test(timeout = 120000)
	public void testc0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testc1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testc2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testc3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testc4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testc5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testc6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testc7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testc8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testc9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testc10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "UC", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}


	@Test(timeout = 120000)
	public void testd0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testd1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testd2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testd3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testd4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "ID", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testd5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testd6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testd7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testd8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testd9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testd10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "ID", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}

	@Test(timeout = 120000)
	public void teste0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void teste1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void teste2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void teste3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void teste4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "GR1", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void teste5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void teste6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void teste7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void teste8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void teste9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void teste10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "GR1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}


	@Test(timeout = 120000)
	public void testf0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testf1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testf2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testf3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testf4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "GR2", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testf5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testf6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testf7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testf8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testf9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testf10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "GR2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}


	@Test(timeout = 120000)
	public void testg0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testg1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testg2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testg3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testg4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "AS1", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testg5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testg6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testg7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testg8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testg9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testg10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "AS1", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}


	@Test(timeout = 120000)
	public void testh0() throws Exception {
		String solution = LLAPSearch.solve(initialState0, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState0);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState0, solution));
	}
	@Test(timeout = 120000)
	public void testh1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}
	@Test(timeout = 120000)
	public void testh2() throws Exception {
		String solution = LLAPSearch.solve(initialState2, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState2);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState2, solution));
	}
	@Test(timeout = 120000)
	public void testh3() throws Exception {
		String solution = LLAPSearch.solve(initialState3, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState3);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState3, solution));
	}
	@Test(timeout = 120000)
	public void testh4() throws Exception {
		String solution = LLAPSearch.solve(initialState4, "AS2", false);
	    solution = solution.replace(" ", "");
	    LLAPPlanChecker pc = new LLAPPlanChecker(initialState4);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState4, solution));
	}
	@Test(timeout = 120000)
	public void testh5() throws Exception {
		String solution = LLAPSearch.solve(initialState5, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState5);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState5, solution));
	}
	@Test(timeout = 120000)
	public void testh6() throws Exception {
		String solution = LLAPSearch.solve(initialState6, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState6);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState6, solution));
	}
	@Test(timeout = 120000)
	public void testh7() throws Exception {
		String solution = LLAPSearch.solve(initialState7, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState7);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState7, solution));
	}
	@Test(timeout = 120000)
	public void testh8() throws Exception {
		String solution = LLAPSearch.solve(initialState8, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState8);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState8, solution));
	}
	@Test(timeout = 120000)
	public void testh9() throws Exception {
		String solution = LLAPSearch.solve(initialState9, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState9);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState9, solution));
	}
	@Test(timeout = 120000)
	public void testh10() throws Exception {
		String solution = LLAPSearch.solve(initialState10, "AS2", false);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState10);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState10, solution));
	}
}