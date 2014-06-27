package camDyn;


import java.util.ArrayList;
import java.util.Arrays;


// Cocke-Kasami-Young parsing algorithm:
// *******************************************
// 
// tabular-based parser that recognizes 
// and parses sentences, whenever we input
// grammars in Chomsky normal form
// where all rules are of the form
//
//          X --> a   and   X --> Y Z
//
// (recursive or not). See Jurafsky and
// Martin, Ch. 13 for the details.


public class CKY {

	
	// parsing chart
	private static ArrayList<String>[][] parsechart;
	
	
	// chart constructor
	public CKY(String input, Grammar g){
		// parses and sets chart
		parseGramm(input,g);
	}

	
	//parsing method
	public static void parseGramm(String input, Grammar g){
				
		// tokenize input string
		String[] tokens = myTokenize(input);
		
		// size n of input string
		int tok = tokens.length;
		
		// parser chart of dimension n x (n + 1)
		ArrayList<String>[][] chart = new ArrayList[tok][tok+1];
	
		// get terminal and non-terminal productions
		ArrayList<Production> term  	= g.getTerm();
		ArrayList<Production> rules 	= g.getRules();
		
		// we loop over the chart, from the diagonal
		// upwards (bottom up)	
		for (int j=1;j<=tok;j++){
			System.out.println("\nj="+j);			
			for (Production p: term){
				if (tokens[j-1].equals(p.getBody()[0])){
					chart[j-1][j] = new ArrayList<String>();
					chart[j-1][j].add(p.getHead());
					}
				}
			for (int i=(j-2);i>=0;i--){
				System.out.println("\n  i="+i);
				for (int k=i+1;k<=(j-1);k++){
					System.out.println("   k="+k);		
					System.out.println("      C["+i+","+j+"]");
					System.out.println("      C["+i+","+k+"]");
					System.out.println("      C["+k+","+j+"]");						
					if (chart[i][k]!=null && (chart[k][j]!=null)){
						for (String A: chart[i][k]){					
							for (String B: chart[k][j]){
								for (Production r: rules){
									if (A.equals(r.getBody()[0]) && B.equals(r.getBody()[1])){
										chart[i][j] = new ArrayList<String>();
										chart[i][j].add(r.getHead());
										System.out.println("      ---->"+r.getHead());
										}
									}
								}
							}
						}
					}
				}
			}				
		
		// If S is contained in the topmost cell of the
		// chart, parsing succeeded
		if (chart[0][tok]!=null){			
				for (String s: chart[0][tok]){
					if ("S".equals(s)){
						System.out.println("\n ==> parse exists");
						parsechart = chart;
					}else{
						System.out.println("\n ==> ungrammatical");
					}
				}
			}else{
				System.out.println("\n ==> ungrammatical");
			}
			
		}
		
	
		// chart getter
		public ArrayList<String>[][] getParseChart() {
			return parsechart;
		}	
	
		
		// tokenize input string
		public static String[] myTokenize(String s){
			String[] res = s.split(" ");
			return res;
		}
		
		
		// main method
		public static void main(String[] args){

			// CFG in Chomsky normal form
			// phrase structure
			Production p1 = new Production("S", new String[]{"NP","VP"});
			Production p2 = new Production("NP",new String[]{"Det","N"});
			Production p3 = new Production("VP",new String[]{"V","NP"});
			// lexicon
			Production p4 = new Production("V",new String[]{"respects"});
			Production p5 = new Production("N",new String[]{"runner"});
			Production p6 = new Production("Det",new String[]{"every"});
			Production p8 = new Production("Det",new String[]{"some"});
			
			// list of productions
			ArrayList<Production> prod = 
				new ArrayList<Production>(Arrays.<Production>asList(p1, p2,p3,p4,p5,p6,p8));
			
			// we build a grammar
			Grammar mygramm = new Grammar(prod);
			
			// we parse it
			CKY cky = new CKY("every runner respects some runner",mygramm);
			
		}

		
}


class Grammar {
	
	
	// classes are lists of rules
	private ArrayList<Production> term = new ArrayList<Production>();
	private ArrayList<Production> rules = new ArrayList<Production>();
	
	
	// constructor
	public Grammar(ArrayList<Production> prod){
		for (int i=0;i<prod.size();i++)
			if(prod.get(i).getBody().length == 1 && prod.get(i).getBody()[0].matches("[a-z]+")){
				this.getTerm().add(prod.get(i));
				}else{
					this.getRules().add(prod.get(i));
			}
	}

	
	// setter
	public void setTerm(ArrayList<Production> term) {
		this.term = term;
	}
	
	
	// getter
	public ArrayList<Production> getTerm() {
		return term;
	}
	
	
	// setter
	public void setRules(ArrayList<Production> rules) {
		this.rules = rules;
	}
	
	
	// getter
	public ArrayList<Production> getRules() {
		return rules;
	}
	
	
}


class Production {
	

	// rules are composed of a head
	// and a body of size < 3 
	private String head;
	private String[] body;
	
	
	// constructor
	public Production(String head, String[] body){
		this.setHead(head);
		if (body.length <= 2){
			this.setBody(body);
			}else{
				System.out.println("not in Chomsky normal form");
		}
	}

	
	// setter
	public void setBody(String[] body) {
		this.body = body;
	}
	
	
	// getter
	public String[] getBody() {
		return body;
	}
	
	
	// setter
	public void setHead(String head) {
		this.head = head;
	}
	
	
	// getter
	public String getHead() {
		return head;
	}
	
	
}

