package tests;

import java.util.ArrayList;
import java.util.HashMap;



public class LLAPPlanChecker {
    int v0;
    int v1;
    int v2;
    int v3;
    HashMap<String, Integer> v4;
    ArrayList<Integer> v5;
    ArrayList<Integer> v6;
    ArrayList<Integer> v7;
    ArrayList<Integer> v8;
    ArrayList<Integer> v9;
    ArrayList<Integer> v10;

    int v11 =100000;
    int v12 =0;

    int v13 =0;
    int v14 =50;

    int v15 = -1;
    public LLAPPlanChecker(String str){

        String[] splitState = str.split(";");

        this.v0 = Integer.parseInt(splitState[0]);

        this.v1 = Integer.parseInt(splitState[1].split(",")[0]);
        this.v2 = Integer.parseInt(splitState[1].split(",")[1]);
        this.v3 = Integer.parseInt(splitState[1].split(",")[2]);

        this.v4 = new HashMap<String, Integer>();
        v4.put("A", Integer.parseInt(splitState[2].split(",")[0]));
        v4.put("B", Integer.parseInt(splitState[2].split(",")[1]));
        v4.put("C", Integer.parseInt(splitState[2].split(",")[2]));


        this.v5 = new ArrayList<Integer>();
        v5.add(0);
        v5.add(1);
        v5.add(1);
        v5.add(1);
        v5.add(0);
        v5.add(Integer.parseInt(splitState[3].split(",")[0]));
        v5.add(Integer.parseInt(splitState[3].split(",")[1]));
        v5.set(0, v5.get(0)+ v5.get(1)* v4.get("A")+ v5.get(2)* v4.get("B")+ v5.get(3)* v4.get("C"));
        this.v6 = new ArrayList<Integer>();
        v6.add(0);
        v6.add(1);
        v6.add(1);
        v6.add(1);
        v6.add(0);
        v6.add(Integer.parseInt(splitState[4].split(",")[0]));
        v6.add(Integer.parseInt(splitState[4].split(",")[1]));
        v6.set(0, v6.get(0)+ v6.get(1)* v4.get("A")+ v6.get(2)* v4.get("B")+ v6.get(3)* v4.get("C"));
        this.v7 = new ArrayList<Integer>();
        v7.add(0);
        v7.add(1);
        v7.add(1);
        v7.add(1);
        v7.add(0);
        v7.add(Integer.parseInt(splitState[5].split(",")[0]));
        v7.add(Integer.parseInt(splitState[5].split(",")[1]));
        v7.set(0, v7.get(0)+ v7.get(1)* v4.get("A")+ v7.get(2)* v4.get("B")+ v7.get(3)* v4.get("C"));
        this.v8 = new ArrayList<Integer>();
        v8.add(0);
        v8.add(1);
        v8.add(1);
        v8.add(1);
        v8.add(0);
        v8.add(0);
        v8.add(0);
        v8.set(0, v8.get(0)+ v8.get(1)* v4.get("A")+ v8.get(2)* v4.get("B")+ v8.get(3)* v4.get("C"));

        this.v9 =  new ArrayList<Integer>();
        this.v10 =  new ArrayList<Integer>();
        for(int i=0;i<5;i++){
            String par1= splitState[6].split(",")[i];
            v9.add(Integer.parseInt(par1));
            String par2= splitState[7].split(",")[i];
            v10.add(Integer.parseInt(par2));
        }
        v9.set(0, v9.get(0)+ v9.get(1)* v4.get("A")+ v9.get(2)* v4.get("B")+ v9.get(3)* v4.get("C"));
        v10.set(0, v10.get(0)+ v10.get(1)* v4.get("A")+ v10.get(2)* v4.get("B")+ v10.get(3)* v4.get("C"));

    }
    public boolean er(String y){
        ArrayList<Integer> x = new ArrayList<>();
        switch (y){
        case "A":
            x = v5;
            break;
        case "B":
            x = v6;
            break;
        case "C":
            x = v7;
            break;
        case "D":
            x = v8;
            break;
        case "E1":
            x = v9;
            break;
        case "E2":
            x = v10;
            break;
        default:
            x = new ArrayList<>();
            break;
        }
        return (this.v1 >= x.get(1) && this.v2 >= x.get(2) && this.v3 >= x.get(3) && this.v11 - this.v12 >= x.get(0));
    }


    public void ur(String y){


        ArrayList<Integer> x = new ArrayList<>();

        switch (y){
            case "A":
                x = v5;
                break;
                case "B":
                x = v6;
                break;
                case "C":
                x = v7;
                break;
            case "D":
                x = v8;
                break;
            case "E1":
                x = v9;
                break;
            case "E2":
                x = v10;
                break;
            default:
                x = new ArrayList<>();
                break;
        }

        this.v1 -= x.get(1);
        this.v2 -= x.get(2);
        this.v3 -= x.get(3);
        this.v12 += x.get(0);
        this.v0 += x.get(4);
    }

    void au(){
        if (v15 !=-1 && v13 >0){
            v13--;
        }
        if (this.v13 ==0 && this.v15 !=-1){

            if(this.v15 ==0){
                this.v1 +=this.v5.get(5);
            }
            if(this.v15 ==1){
                this.v2 +=this.v6.get(5);
            }
            if(this.v15 ==2){
                this.v3 +=this.v7.get(5);
            }
            this.v15 =-1;
            this.v13 =0;
        }
    }

    void mc(){
        if(v1 > v14){  v1 = v14;  }
        if(v2 > v14){  v2 = v14;  }
        if(v3 > v14){  v3 = v14;  }
    }
    boolean f1(String an){
        au();
        int i=-1;
       if(!er(an)){return false;}
       switch (an){
           case "A":
               if (this.v11 -this.v12 < this.v5.get(0)){return false;}i=0;
               v13 = v5.get(6) ;break;
           case "B":
               if (this.v11 -this.v12 < this.v6.get(0)){return false;}i=1;
               v13 = v6.get(6) ;break;
           case "C":
               if (this.v11 -this.v12 < this.v7.get(0)){return false;}i=2;
               v13 = v7.get(6) ;break;
           default: return false;
       }
        this.v15 =i;
        ur(an);
        mc();
    return true;
    }



    boolean f3(){
        au();
        if(!er("D")){return false;}
        ur("D");
        mc();
        return true;
    }

    boolean f2(int i){
        au();
        String an = "E"+i;
        if(!er(an)){return false;}
        ur(an);
        mc();
        return true;
    }





    public boolean tryPlan(String[] actions, LLAPPlanChecker s) {
		boolean linkin = false;
		for (int i = 0; i < actions.length; i++) {

			switch (actions[i]) {
                case "requestfood":
				linkin = s.f1("A");
				break;
			case "requestenergy":
				linkin = s.f1("C");
				break;
			case "requestmaterials":
				linkin = s.f1("B");
				break;
			case "build1":
				linkin = s.f2(1);
				break;
			case "build2":
				linkin = s.f2(2);
				break;
			case "wait":
				linkin = s.f3();
				break;
			default: linkin = false;
            break;

			}
			if(!linkin) {
				System.out.println("action that failed: "+actions[i] +", order: "+i);
				return false;
				}
	}
		return true;
	}

    boolean cool(){
       return this.v0 >= 100;
    }
public boolean applyPlan(String grid, String solution){
	boolean linkin = true;
	solution = solution.toLowerCase();
    if (solution.equals("nosolution")) {
        return false;
    }
//    System.out.println(solution);
	String[] solutionArray  = solution.split(";");
	String plan = solutionArray[0];
	int blue = Integer.parseInt(solutionArray[1]);
	plan.replace(" ", "");
	plan.replace("\n", "");
	plan.replace("\r", "");
	plan.replace("\n\r", "");
	plan.replace("\t", "");

	String[] actions = plan.split(",");

	LLAPPlanChecker s = new LLAPPlanChecker(grid);
	linkin = tryPlan(actions,s);
	if(!linkin) {
		return false;
		}

    return s.cool() && s.v12 ==blue;
}
}
