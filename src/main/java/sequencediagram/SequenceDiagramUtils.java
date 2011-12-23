package sequencediagram;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SequenceDiagramUtils {
	/**
	 * Generate sequence Diagram
	 * 
	 * ClassA->ClassB:method
	 * 
	 * @param text
	 * @param outFile
	 * @param style
	 */
	public static void getSequenceDiagram(String text, String outFile, String style) {

		try {
			// Build parameter string
			String data = "style=" + style + "&message="
					+ URLEncoder.encode(text, "UTF-8");

			// Send the request
			URL url = new URL("http://www.websequencediagrams.com");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					conn.getOutputStream());

			// write parameters
			writer.write(data);
			writer.flush();

			// Get the response
			StringBuffer answer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				answer.append(line);
			}
			writer.close();
			reader.close();

			String json = answer.toString();
			int start = json.indexOf("?img=");
			int end = json.indexOf("\"", start);

			url = new URL("http://www.websequencediagrams.com/"
					+ json.substring(start, end));
			System.out.println("Writing file to " + outFile);
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					outFile));
			InputStream in = url.openConnection().getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}

			in.close();
			out.close();

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
