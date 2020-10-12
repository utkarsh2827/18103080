import java.util.*;
public class Question2{
	public static void main(String[] args) {
		int start = -1;
		byte b = (byte)start;
		char ch = (char)b;
		int end = (int)ch;

		System.out.println("Start Value: "+start);
		System.out.println("Byte Value: "+b);
		System.out.println("Character Value: "+ch);
		System.out.println("End Value: "+end);

	}
}

// int(32-bits)-->byte(8-bits)-->char(16-bits)-->int(32-bits)