package com.delligattiassociates.jct.test;

import java.io.FileInputStream;
import java.io.InputStream;

import com.delligattiassociates.jct.test.parser.JJTest2;
import com.delligattiassociates.jct.test.parser.ParseException;

public class Test
{
	public static void main(String args []) throws ParseException
	{
	    System.out.println("Working Directory = " + System.getProperty("user.dir"));
//		do_file("test/test-01-package.fooml");
//		do_file("test/test-02-package-with-visibility.fooml");
//		do_file("test/test-03-package-with-comments.fooml");
//		do_file("test/test-04-block.fooml");
//		do_file("test/test-05-gen-spec.fooml");
//		do_file("test/test-06-subsetting.fooml");
//		do_file("test/test-07-redefinition.fooml");
//		do_file("test/test-08-parts-1.fooml");
		do_file("-");
	}
	
	static void do_file(String filename)
	{
		InputStream in = null;
		
		try
		{
			if (filename.compareTo("-") == 0)
			{
				in = System.in;
				System.out.println("Reading from standard input...");
			}
			else
			{
				System.out.printf("Reading from <%s>...\n", filename);
				in = new FileInputStream(filename);
			}
		}
		catch (Exception e)
		{
			System.err.println("OOPS!");
			e.printStackTrace(System.err);
			return;
		}
		
		JJTest2 parser = new JJTest2(in);

		while (true)
		{
			//	      System.out.print("Enter an expression like \"1+(2+3)*4;\" :");

			try
			{
				parser.file();
				System.out.println("Goodbye.");
				return;

				//	        switch (JJTest.one_line())
				//	        {
				//	          case 0 : 
				//	          System.out.println("OK.");
				//	          break;
				//	          
				//	          case 1 : 
				//	          System.out.println("Goodbye.");
				//	          System.exit(0);
				//	          break;
				//	          
				//	          default : 
				//	          break;
				//	        }
			}

			catch (Exception e)
			{
				System.out.println("NOK.");
				System.out.println(e.getMessage());
				break;
				//JJTest.ReInit(System.in);
			}

			catch (Error e)
			{
				System.out.println("Oops.");
				System.out.println(e.getMessage());
				break;
			}
		}
	}
}
