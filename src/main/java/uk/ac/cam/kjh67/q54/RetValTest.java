package uk.ac.cam.kjh67.q54;


public class RetValTest {
    public static String sEmail = "";

    public static void extractCamEmail(String sentence) throws EmailExtractionException{
        if (sentence==null || sentence.length()==0) {
            throw new EmailExtractionException("Supplied string empty"); // Error for empty sentence
        }
        String[] tokens = sentence.split(" ");
        int i = 0;
        try {
            while (sEmail.equals("")) {
                if (tokens[i].endsWith("@cam.ac.uk")) {
                    sEmail = tokens[i];
                }
                i++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            // If there were multiple places where lack of @cam email could occur, might also want to
            // chain the original IndexOutOfBoundsException into the EmailExtractionException
            throw new EmailExtractionException("No @cam address in supplied string");
        }
    }

    public static void main(String[] args) {
        try {
            RetValTest.extractCamEmail("My email is rkh23@cam.ac.uk");
            System.out.println("Success: "+RetValTest.sEmail);
        }
        catch (EmailExtractionException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
