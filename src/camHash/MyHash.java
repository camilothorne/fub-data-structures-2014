package camHash;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;


// We use generic lists and nodes, instantiated to
// lists and nodes of strings
import wernerLists.ListB;
import wernerLists.NodeB;


// Implementation of a hash table using (a) chaining and
// (b) the division method


// Hash table
public class MyHash {
	
	
	// Fields
	int bound;
	ListB<String>[] hash; // each table cell is a chain (linked list)
	HashFunction r; // hash function
	
	
	// Constructor
	public MyHash(int bnd, String path){
		
		// initialize hash table
		this.bound = bnd;
		ListB<String>[] hashtable = new ListB[this.bound];
		this.hash = hashtable;
		
		// apply the hash function
		r = new HashFunction(path, this.bound, this.hash);
		
		// display the desired counts
		System.out.println("# of types		=	"+r.corpusTypes());				
		System.out.println("# of tokens		=	"+r.corpusTokens());
		System.out.println("lex. richness		= 	"+truncateDecimal(r.corpusRich(),5));
		
		//N.B. richness can be very low if we don't disregard stop words
		// (e.g., determiners, connectors, prepositions) that (i) occur very frequently
		// and (ii) occur very way more frequently than nouns, but (iii) are few in 
		// number (power law distribution).
	
	}
	
	
	// truncate decimal number
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return 
	        	new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, 
	        			BigDecimal.ROUND_FLOOR);
	    } else {
	        return 
	        	new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, 
	        			BigDecimal.ROUND_CEILING);
	    }
	}
	
	
	// Main method
	public static void main(String[] args){
		
		MyHash hash = 
					new MyHash((int)Math.pow(2,14), "/home/camilo/Desktop/genesis.txt");

		/*
		System.out.println("freq of 'the' 		=	" + hash.r.wordFreq("the", hash.bound,hash.hash));		
		System.out.println("rel freq of 'the' 	=	" + 
					truncateDecimal(hash.r.wordRelFreq("the", hash.bound,hash.hash),5));		
		System.out.println("freq of 'god' 		=	" + hash.r.wordFreq("god", hash.bound,hash.hash));		
		System.out.println("rel freq of 'god'	=	" + 
					truncateDecimal(hash.r.wordRelFreq("god", hash.bound,hash.hash),5));
		*/	
	}
	
}


// Auxiliary class implementing the
// hash function(s) and the file I/O
// methods:


// Hash function
class HashFunction {
	
	
	// Fields:
	
	// Auxiliary
	String mydata = "";
	
	// File
	String path;
	FileInputStream file;	
	InputStream is;
	
	// Corpus counts
	int tokens;
	int types;
	double rich;
	
	
	// Constructor
	public HashFunction(String path, int bound, ListB<String>[] hashtable){
		this.path=path;	
		try{
			this.read(bound, hashtable);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	// Reads file
	public void read(int bound, ListB<String>[] hashtable) throws Exception{
	
		file = new FileInputStream(path);
		
		// this is the main hashing function:
		run(file, mydata, bound, hashtable);
		file.close();
	
	}
	
	
	// Returns simple string hash code
	public int hashCodeA(String s){
		return s.hashCode();
	}
	
	
	// Returns substring-based hashcode
	// (considers only 1st 1/2 of string)
	public int hashCodeB(String s){
		return s.substring(0,(int)Math.floor(s.length()/2)).hashCode();
	}	
	
	
	// Returns character-based hash code
	public int hashCodeC(String s, int bound){
		int h = 0;
		for (int i=0;i<s.length();i++){
			h = (23*h) + (int)s.charAt(i);
			System.out.println("key="+h);			
		}
		// normalize by table size;
		// we return the absolute value of the result
		// to deal with overflowing (> 32 bit) integers 
		return Math.abs(h % bound);
	}	
		

	// Hash function for integer keys (multiplication method)
	public int hash(int key, int bound){
		// calculating the index (multiplication method)
		
		// 1/2 < A < 1; value suggested by Knuth:
		double a 	= (Math.sqrt(5)-1)/2;
		
		// multiplication method
		int pos 		= (int) Math.floor(bound * ((key * a) % 1));
		
		return pos;
	}	
	
	
	// Loads the file as a big string (to print)
	public String fileSt(){
		return mydata;
	}
	
	
	// Word indexing method:
	//
	//   Loads the (file) input stream into a buffer and then a string;
	//   afterwards it (i) removes special characters, (ii) tokenizes the input,
	//   (iii) computes the hash value of each word, (iv) applies the hash function
	//   to index the word, and, finally, (v) updates the token and type count
	//   of the corpus.
	//
	public void run(InputStream is, String mydata, int bound, ListB<String>[] hashtb){
		String data;
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while((data = reader.readLine()) != null){
				String norm = data.replaceAll("[^\\p{L}\\p{Z}]","");
				String[] sen = norm.split(" ");
				for (String ss : sen){
					String s = ss.toLowerCase();
					this.tokens = this.tokens + 1;					
					// the hash function computes the
					// hash code, indexes the word and 
					// (see below) updates the type count
					hashFunction(s,hashtb);
				}
			}
		}
		catch(IOException ex){
			 ex.printStackTrace();
		}
		
	}
	
		
	// indexing via hash code
	public void hashFunction(String word, ListB<String>[] hashtb){
		
		// calculating hash value
		int pos = hash(hashCodeC(word,hashtb.length), hashtb.length);
					
		System.out.println(word);
		System.out.println(pos);
		
		// chain of collisions
		NodeB<String> w = new NodeB<String>(word);
		
		if (hashtb[pos]==null){
			
			// if the table cell is empty, we populate/initialize
			// it to a linked list of strings
			ListB<String> l = new ListB<String>(w);
			hashtb[pos] = l;
			
			// the number of types is updated each time
			// a cell in the table is initialiazed to some
			// chain (list of strings)
			this.types = this.types + 1;
		
		}else{
			
			// otherwise, we just insert
			hashtb[pos].insertLast(w);
			
		}
		
	}
	
	
	// Frequency of word w in corpus C
	public int wordFreq(String word, ListB<String>[] hashtb){
		
		String s = word.toLowerCase();
		int pos = hashCodeA(s);
		
		// calculating the index (multiplication method)
		//double a 	= (Math.sqrt(5)-1)/2;
		//int pos 		= (int) Math.abs((bound * ((hs * a) % 1))); 
		return hashtb[pos].length();
	}
	
	
	// Relative frequency of word w in corpus C
	public double wordRelFreq(String word, ListB<String>[] hashtb){
		
		String s = word.toLowerCase();
		int pos = hashCodeA(s);
		
		// calculating the index (multiplication method)
		//double a 	= (Math.sqrt(5)-1)/2;
		//int pos 		= (int) Math.abs((bound * ((hs * a) % 1))); 
		
		// calculating rel frequency
		double frq = hashtb[pos].length();	
		double relfreq = frq/this.tokens;
		
		return relfreq;
	}	
	
	
	// # of tokens in corpus C
	public int corpusTokens(){
		return this.tokens;
	}


	// # of types in corpus C
	public int corpusTypes(){
		return this.types;
	}	
	
	
	// lexical richness of corpus C
	public double corpusRich(){
		double typ = this.types;
		double tok = this.tokens;
		this.rich = typ/tok;
		return this.rich;
	}		
	
	
}