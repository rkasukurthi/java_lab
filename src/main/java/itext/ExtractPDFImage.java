package itext;

import java.io.IOException;
import java.io.InputStream;
import java.security.SignatureException;

import com.itextpdf.text.pdf.PdfReader;

public class ExtractPDFImage {

	
	public static void main(String[] args) throws IOException, SignatureException {
		InputStream is = ExtractPDFImage.class.getResourceAsStream("/docs/WrongSignatureShown.pdf");
		PdfReader reader = new PdfReader(is);
		System.out.println("Number of Pages: [" + reader.getNumberOfPages() +"]");
		System.out.println("Is encrypted? [" + reader.isEncrypted() +"]");
		System.out.println("File length: [" + reader.getFileLength() +"]");
		System.out.println("Page Stream:");
		System.out.println(new String(reader.getPageContent(1)));
		
/*	    int i =reader.getCryptoMode();
       
	    AcroFields af =reader.getAcroFields();
	    
	    ArrayList<String> names = af.getSignatureNames();
	    for (String name : names) {
	    out.println("Signature name: " + name);
	    out.println("Signature covers whole document: "
	    + af.signatureCoversWholeDocument(name));
	    out.println("Document revision: "
	    + af.getRevision(name) + " of " + af.getTotalRevisions());
	    PdfPKCS7 pk = af.verifySignature(name);
	    Calendar cal = pk.getSignDate();
	    Certificate[] pkc = pk.getCertificates();
	    out.println("Subject: "
	    + PdfPKCS7.getSubjectFields(pk.getSigningCertificate()));
	    out.println("Revision modified: " + !pk.verify());*/
/*	    Object fails[] = PdfPKCS7.verifyCertificates(pkc, ks, null, cal);
	    if (fails == null)
	    out.println("Certificates verified against the KeyStore");
	    else
	    out.println("Certificate failed: " + fails[1]);
	    }
	    */
	    
//	    }
	    
	    
	    
	    /*Map<String,Item> fields =acroFields.getFields();
	    for (String key: fields.keySet())
	    {
	    	Item item = fields.get(key);
	    	System.out.println("Acro Field Name: [" + key +"]");
	    }
	    System.out.println("CryptoMode: [" + i +"]");
	*/}
}
