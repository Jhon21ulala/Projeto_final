package classes.adapter;

import classes.ExportData;
import classes.ImportDataMEC;
import org.json.JSONObject;
import org.json.XML;

public class DataAdapter {
    private ExportData exportData;
    private ImportDataMEC importDataMEC;

    public DataAdapter(ExportData exportData, ImportDataMEC importDataMEC) {
        this.exportData = exportData;
        this.importDataMEC = importDataMEC;
    }

    public void exportAndImportData(ArrayList<String[]> data, int numFields, String rootElement) {
        String xmlData = exportData.ArrayToXMLFormat(data, numFields, rootElement);
        String jsonData = convertXmlToJson(xmlData);
        importDataMEC.importData(jsonData);
    }

    private String convertXmlToJson(String xmlData) {
        JSONObject jsonObject = XML.toJSONObject(xmlData);
        return jsonObject.toString(4);
    }
}