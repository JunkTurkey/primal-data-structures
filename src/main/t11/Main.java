package main.t11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Main {

	public static void main() {
		int x=2;

		Mngchlen mng = new Mngchlen();
		Mngchlen mng2 = new Mngchlen();
		Mngchlen res = new Mngchlen();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );

		String currentString = null;
		System.out.println("Input items mng:");
		while (currentString!=""){

			try {
				currentString = reader.readLine();
				if (currentString.isEmpty()) break;
				int[] input = Mngchlen.struct(currentString);
				mng.pushItem(input[0], input[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Input items mn2:");
		while (currentString!=""){
			try {
				currentString = reader.readLine();
				if (currentString.isEmpty()) break;
				int[] input = Mngchlen.struct(currentString);
				mng2.pushItem(input[0], input[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("equality " + mng + " & " + mng + " : " + Mngchlen.Equality(mng,mng));

		System.out.println("equality " + mng + " & " + mng2 + " : " + Mngchlen.Equality(mng,mng2));

		System.out.println("mnogochlen " + mng + " value: " + Mngchlen.Meaning(mng, x));

		System.out.println("mnogochlen summary:");
		Mngchlen.Add(mng, mng2, res);
//		for (Mngchlen.Item it = res.first; it!=null; it=it.next) {
//			System.out.println(it.value1 + "^" + it.value2);
//		}
		res.print();
	}

}
