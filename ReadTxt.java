import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadTxt {
	public static void main(String[] args) {

		getFiles();

	}

	static void getFiles() {
		String dirPath = "C:/Users/mustafa/Desktop/dcelogs";
    //folder
		File dir = new File(dirPath);
    //Create file name array in folder
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
    //Writing file name
			for (String aFile : files) {
				System.out.println(aFile);
				try {
					FileInputStream fstream = new FileInputStream(dirPath + "/" + aFile);
					BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
					String strLine;
					/* read log line by line */
					while ((strLine = br.readLine()) != null) {
						/* parse strLine to obtain what you want */
						if (strLine.toLowerCase().contains("/customer/relation/types".toLowerCase())) {
							System.out.println(strLine);
						}
					}
					fstream.close();
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
			}
		}
	}
}
