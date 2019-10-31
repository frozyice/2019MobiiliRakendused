package com.nagel.englishregents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
/* number of new import statements, program should read and parse a XML document */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    //single instance variable -> List for regent objects -> the objects that the ListView component should display
    List<Regent> regents = new ArrayList<>();

    /*
    * Start by loading the resource. Refering to programs resources by using the getResources() and loading a raw file using the method
    * openRawResource(), the result is a regular InputStream. With this stream available a DocumentBuilder can read the document and parse
    * it as XML after which can create the current Regent objects and initialize the list. After the data is loaded and the list is initialized
    * an adapter is added to the ListView component. Additionally an event handler has been added so that the program shows a Toast if you click
    * on a name in the ListView component. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //opens regents.xml
            InputStream stream = getResources().openRawResource(R.raw.regents);
            //using this class, an application programmer can obtain a Document  from XML.
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //The Document interface represents the entire HTML or XML document. provides the primary access to the document's data.
            Document document = builder.parse(stream, null);
            //The NodeList interface provides the abstraction of an ordered collection of nodes, without defining or constraining how this collection is implemented.
            //nodes are defined by tag "regent"
            NodeList nodeList = document.getElementsByTagName("regent");

            for (int i = 0; i < nodeList.getLength(); ++i) {
                //The Element interface represents an element in an HTML or XML document.
                Element element = (Element)nodeList.item(i);
                //get element attribute "from" as string
                String attr = element.getAttribute("from");
                //if shorthand: variable = (condition) ? expressionTrue :  expressionFalse;
                //if(attr == null || attr.length() == 0) {int from=Integer.MIN_VALUE} else {int from=Integer.parseInt(attr)}
                int from = (attr == null || attr.length() == 0) ? Integer.MIN_VALUE : Integer.parseInt(attr);
                attr = element.getAttribute("to");
                int to = attr == null || attr.length() == 0 ? Integer.MAX_VALUE : Integer.parseInt(attr);
                //add Regent class object to regents List with attributes: name, from, to
                regents.add(new Regent(element.getAttribute("name"),from,to));
            }
            stream.close();
        } catch(Exception ex){}
            ListView view = findViewById(R.id.lstReg);
        view.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regents));
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Regent regent = regents.get(position);
                Toast.makeText(MainActivity.this, regent.getRegent(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
