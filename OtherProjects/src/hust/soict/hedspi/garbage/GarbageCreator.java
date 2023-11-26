package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException{

        String filename = "C:\\Users\\Asus\\Documents\\2023.1\\OOLT.VN.20231-20210386.TranHuyHoang\\OtherProjects\\src\\hust\\soict\\hedspi\\garbage\\test.txt";
        byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
    }
}
