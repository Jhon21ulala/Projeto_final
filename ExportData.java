
import java.util.ArrayList;

public class ExportData {

    public String ArrayToXMLFormat(ArrayList<String[]> data, int rootElementCount, String rootElementName) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<").append(rootElementName).append(">\n");

        for (String[] entry : data) {
            xmlBuilder.append("  <item>\n");
            for (int i = 0; i < entry.length; i += 2) {
                xmlBuilder.append("    <").append(entry[i]).append(">")
                          .append(entry[i + 1]).append("</").append(entry[i]).append(">\n");
            }
            xmlBuilder.append("  </item>\n");
        }

        xmlBuilder.append("</").append(rootElementName).append(">");
        return xmlBuilder.toString();
    }
}