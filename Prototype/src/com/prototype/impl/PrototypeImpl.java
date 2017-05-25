package com.prototype.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PrototypeImpl {

	public static void actualLogic(String source, String destination) throws IOException {
		
		File file = new File(source);
		BufferedReader br = new BufferedReader(new FileReader(file));
		FileOutputStream fos = new FileOutputStream(destination);
		PrintWriter out = new PrintWriter(fos);
		out.print("(");
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
		
			line = line.trim();
			line = "(ITEM='"+line+"')";
//			line = "(ITEM_PARENT='"+line+"')";
			out.println(line);
			if (br.ready()) {
				out.print("OR ");
			} else {
				out.print(");");
			}
		}
		br.close();
		out.flush();
		out.close();
		System.out.println("DONE");
	}
}
