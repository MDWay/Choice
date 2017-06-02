package de.romjaki.choice;

import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	
	public static interface Function<T,R> {
		String name();
		String code();
		Array<R> execute(Array<T> arr);
	}
	public static interface Array<T> {
		Array get(int index);
		boolean isValue();
		boolean isArray();
		T value();
	}
	public static class SingleValueArray<T> implements Array<T>{
		private T value;
		public SingleValueArray(){
			this(null);
		}
		public SingleValueArray(T value){
			this.value=value;
		}
		public boolean isValue(){
			return true;
		}
		public boolean isArray(){
			return false;
		}
		public Array get(int index){
			return this;
		}
		public T value() {
			return this.value;
		}
	}
	public static class ArrayOfArrays<T> implements Array<T>{
		private Array[] subArrays;
		public ArrayOfArrays(Array... subArrays){
			this.subArrays = subArrays;
		}
		public ArrayOfArrays(List<Array> subArrays){
			this(subArrays.toArray(new Array[subArrays.size()]));
		}
		public boolean isValue(){
			return false;
		}
		public boolean isArray(){
			return true;
		}
		public Array get(int index){
			return subArrays[index];
		}
		public T value() {
			return null;
		}
	}
	public static class FunctionImpl<T,R> implements Function<T,R> {
		//TODO
		//FIXME
		//XXX
	}
	
	private static Map<String,Function> functions = new HashMap<>();
	
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Usage: choice.jar <file>");
			return;
		}
		File f = new File(args[0]);
		try (Scanner s = new Scanner(f)){
			while(s.hasNextLine()){
				String name = nextName();
				functions.put(name, new FunctionImpl(name,s.nextLine()));
			}
		}catch(Exception e){
			System.err.println("Error during file parsing: "+e);
		}
	}
	private static int nextIndex = -1; 
	private static char nameStartInclusive = 'f';
	private static char nameStopExclusive = 'n';
	public static String nextName(){
		if(nextIndex==-1){
			nextIndex=0;
			return "main";
		}
		if(nextIndex<(nameStopExclusive-nameStartInclusive)){
			return String.valueOf((char)((nextIndex++)+nameStartInclusive));
		}
		return String.format("?<%d>", (++nextIndex)-(nameStopExclusive-nameStartInclusive));
	}
}
