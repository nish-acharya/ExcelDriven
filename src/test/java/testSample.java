import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("Login");
		System.out.println(data.get(1));
		

	}

}
