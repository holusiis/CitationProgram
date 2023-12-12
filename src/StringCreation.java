import java.time.LocalDate;
import java.time.ZoneId;

public class StringCreation {
    /**
     * Creates a string with current date for Prague in format "DD MM YYYY" from the function LocalDate.now()
     * @return The current date in format "DD MM YYYY"
     */
    private static String currentDate() {
        StringBuilder currentDate = new StringBuilder();
        ZoneId z = ZoneId.of("Europe/Prague");
        //YYYY-MM-DD
        LocalDate today = LocalDate.now (z);
        String stringToday = today.toString();
        int[] array = {8, 9, 5, 6, 0, 3};
        int j = 0, k = 1;
        for(int i = 0; i < 3; i++) {
            String temporaryString;
            temporaryString = stringToday.substring(array[j], array[k] + 1);
            if(temporaryString.startsWith("0")) {
                currentDate.append(temporaryString.substring(1));
            } else {
                currentDate.append(temporaryString);
            }
            if(i < 2) {
                currentDate.append(". ");
            }
            j += 2;
            k += 2;
        }
        return currentDate.toString();
    }

    /**
     * Creates a citation for books
     * @param surname Surname of the author
     * @param name Name of the author
     * @param year Year of publishing
     * @param nameOfBook Name of the book
     * @param publisher Name of the publisher
     * @param cityOfPublishing City in which it was published
     * @return The completed citation for the book
     */
    public static String createBook(String surname, String name, String year, String nameOfBook, String publisher, String cityOfPublishing) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfBook +
                ". " + publisher + ", " + cityOfPublishing + ".";
        return finalString;
    }

    /**
     * Creates a citation for articles in magazines
     * @param surname Surname of the author
     * @param name Name of the author
     * @param year Year of publishing
     * @param nameOfArticle Name of the Article
     * @param nameOfMagazine Name of the Magazine
     * @param volume Volume of the magazine
     * @param issue Issue of the magazine
     * @param pages Pages on which we can find the article in format "PPP-PPP"
     * @return The completed citation for the magazine
     */
    public static String createMagazine(String surname, String name, String year, String nameOfArticle, String nameOfMagazine, String volume, String issue, String pages) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfArticle +
                ". " + nameOfMagazine + ", " + volume + ", " + issue + ", " + pages + ".";
        return finalString;
    }

    /**
     * Creates a citation for chapters in books
     * @param surname Surname of the author
     * @param name Name of the author
     * @param year Year of publishing
     * @param nameOfChapter Name of chapter
     * @param editor Is the editor different from the author
     * @param surnameEditor Surname of the editor
     * @param nameEditor Name of the editor
     * @param nameBook Name of the book
     * @param publisher Publisher of the book
     * @param city City in which the book was published
     * @param pages Pages on which we can find the chapter in format "PPP-PPP"
     * @return The completed citation for the chapter
     */
    public static String createChapter(String surname, String name, String year, String nameOfChapter, boolean editor, String surnameEditor,
                                       String nameEditor, String nameBook, String publisher, String city, String pages) {
        String finalString = "";
        finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ". (" + year + "): " + nameOfChapter +
        ". In: ";
        if(editor) {
            finalString += surnameEditor + ", " + nameEditor.charAt(0) + "." + " (ed.)";
        } else {
            finalString += surname + ", " + name.charAt(0) + ".";
        }
        finalString += ": " + nameBook + ". " + publisher + ", " + city + ", " + pages + ".";
        return finalString;
    }

    /**
     * Creates a citation for websites
     * @param authorOrOrganisation Is the author a person or an organization
     * @param chcbNameOrganisation Does the organisation have a different name than shortcut
     * @param surname Surname of the author of the article on the page
     * @param name Name of the author of the article on the page
     * @param shortcutOrganisation Shortcut of the organisation which published the article
     * @param nameOrganization Name of the organisation which published the article
     * @param year Year in which the article was published
     * @param articleName Name of the article
     * @param link Full hypertext link for the website in format "https://nameOfWebsite.domain/..."
     * @return The completed citation for the website
     */
    public static String createWeb(boolean authorOrOrganisation, boolean chcbNameOrganisation, String surname, String name,
                                   String shortcutOrganisation, String nameOrganization, String year, String articleName,
                                   String link) {
        String finalString = "";
        if(authorOrOrganisation) {
            finalString += surname.toUpperCase() + ", " + name.toUpperCase().charAt(0) + ".";
        } else {
            finalString += shortcutOrganisation.toUpperCase();
        }
        finalString += " (" + year + "): " + articleName + ", ";
        if(chcbNameOrganisation) {
            finalString += nameOrganization + ", ";
        } else {
            finalString += shortcutOrganisation + ", ";
        }
        finalString += link + " (" + currentDate() + ")";
        return finalString;
    }
}
