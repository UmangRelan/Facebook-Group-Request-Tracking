package com.example.moon.pushstart;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    ArrayList<String> link = new ArrayList<String>();
    ArrayList<String> joinedFbOn = new ArrayList<String>();
    ArrayList<String> reqOn = new ArrayList<String>();
    ArrayList<String> livesIn = new ArrayList<String>();
    ArrayList<String> newlivesIn = new ArrayList<String>();
    ArrayList<String> studyAt = new ArrayList<String>();
    ArrayList<String> workedAt = new ArrayList<String>();
    ArrayList<String> emailID = new ArrayList<String>();
    ArrayList<String> referencefrom = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> newNames = new ArrayList<String>();
    ArrayList<String> newjoinedFbOn = new ArrayList<String>();
    ArrayList<String> newworkedAt = new ArrayList<String>();
    ArrayList<String> newreqON = new ArrayList<String>();






    int i,j;
    public void onName(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                newNames.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }

    public void onLink(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                link.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }

    public void onLivesIn(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                livesIn.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }

    public void onWorkAt(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                newworkedAt.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }
    public void onStudyAt(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                studyAt.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }
    public void onRefBy(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                referencefrom.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }
    public void onEmailId(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                emailID.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }
    public void onReqOn(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                newreqON.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }
    public void onFbDate(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(
                "text label", // What should I set for this "label"?
                newjoinedFbOn.toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(MainActivity.this, "Saved to clip board", Toast.LENGTH_SHORT).show();
    }










    public void onClick(View view) {
        String str = editText.getText().toString();

        String[] splitResult = str.split("<div class=\"_ohe");

        for (i = 1; i < splitResult.length; i++) {
            String detailBlock = splitResult[i];

            Pattern p = Pattern.compile(" lfloat\"><a uid=\"(.*?)\" class");
            Matcher m = p.matcher(detailBlock);
            while (m.find()) {
                link.add("https://www.facebook.com/"+m.group(1));
            }


            Pattern p_joinedfb = Pattern.compile("Joined Facebook on <span>(.*?)<");
            Matcher m_joinedfb = p_joinedfb.matcher(detailBlock);
            while (m_joinedfb.find()) {
                joinedFbOn.add(m_joinedfb.group(1));
            }


            Pattern p_reqOn = Pattern.compile("Requested <abbr class=\"livetimestamp\" (.*?)<");
            Matcher m_reqOn = p_reqOn.matcher(detailBlock);
            while (m_reqOn.find()) {
                reqOn.add(m_reqOn.group(1));
            }

            if (detailBlock.contains("6c82d7\" alt=\"\"></i><span>")) {
                Pattern p_livesIn = Pattern.compile("6c82d7\" alt=\"\"></i><span>(.*?)>");
                Matcher m_liveIn = p_livesIn.matcher(detailBlock);

                while (m_liveIn.find()) {

                    livesIn.add(m_liveIn.group(1));

                }
            } else {
                livesIn.add("NA");
            }

            if (detailBlock.contains("fj img sp_Q85tL9Ov8n0_2x sx_e69402\" alt=\"\"></i><span>")) {
                Pattern p_studyAt = Pattern.compile("fj img sp_Q85tL9Ov8n0_2x sx_e69402\" alt=\"\"></i><span>(.*?)>");
                Matcher m_studyAt = p_studyAt.matcher(detailBlock);

                while (m_studyAt.find()) {

                    studyAt.add(m_studyAt.group(1));

                }
            }


             else {
                studyAt.add("NA");
            }

            if (detailBlock.contains("_79debe\" alt=\"\"></i><span>")) {
                Pattern p_workedAt = Pattern.compile("_79debe\" alt=\"\"></i><span>(.*?)>");
                Matcher m_workedAt = p_workedAt.matcher(detailBlock);

                while (m_workedAt.find()) {
                    workedAt.add(m_workedAt.group(1));
                }


            } else {
                workedAt.add("NA");
            }


            if (detailBlock.contains("Your Email ID? (mandatory- So that we can keep you updated) :)</div><text truncate=\"200\" linelimit=\"1\">")) {


                Pattern p_emailID = Pattern.compile("\\(mandatory- So that we can keep you updated\\) :\\)</div><text truncate=\"200\" linelimit=\"1\">(.*?)<");
                Matcher m_emailID = p_emailID.matcher(detailBlock);

                while (m_emailID.find()) {

                    emailID.add(m_emailID.group(1));

                }
            } else {
                emailID.add("NA");
            }

            if (detailBlock.contains("Where did you come to know about Pushstart</div><text truncate=\"200\" linelimit=\"1\">")) {


                Pattern p_reference = Pattern.compile("Where did you come to know about Pushstart</div><text truncate=\"200\" linelimit=\"1\">(.*?)<");
                Matcher m_reference = p_reference.matcher(detailBlock);

                while (m_reference.find()) {

                   referencefrom.add(m_reference.group(1));


                }
            }
            else {
                referencefrom.add("NA");
            }
            if (detailBlock.contains("class=\"_66jq\">")) {


                Pattern p_name = Pattern.compile("class=\"_66jq\">(.*?)</a></div>");
                Matcher m_name = p_name.matcher(detailBlock);

                while (m_name.find()) {

                    names.add(m_name.group(1));


                }
            }
            else {
                names.add("NA");
            }

        }
        for(int k=0;k<link.size();k++){
            String name=names.get(k);
            for(int m=0;m<name.length();m++){
                if(name.charAt(m)=='>'){
                    newNames.add(name.substring(m+1));
                    break;

                }
            }

        }
        for(int k=0;k<livesIn.size();k++){
            String name=livesIn.get(k);
            String livesincity="";
            for(int m=0;m<name.length();m++){
                if(name.charAt(m)=='<'){
                    m=m+6;
                    continue;
                }
                livesincity=livesincity+name.charAt(m);

            }
            newlivesIn.add(livesincity);

        }

        for(int l=0;l<joinedFbOn.size();l++){
            String name=joinedFbOn.get(l);
            String livesincity="";
            for(int m=0;m<name.length();m++){
                if(name.charAt(m)=='>'){
                    m=m+6;
                    continue;
                }
                livesincity=livesincity+name.charAt(m);

            }
            newjoinedFbOn.add(livesincity);

        }
        for(int l=0;l<workedAt.size();l++){
            String name2=workedAt.get(l);
            String workat="";
            for(int m=0;m<name2.length();m++){
                if(name2.charAt(m)=='<'){
                    m=m+6;
                    continue;
                }
                workat=workat+name2.charAt(m);

            }
            newworkedAt.add(workat);

        }
        for(int l=0;l<reqOn.size();l++) {
            String name2 = reqOn.get(l);

            for (int m = 0; m < name2.length(); m++) {
                if (name2.charAt(m) == '>') {
                    newreqON.add(name2.substring(m + 1));
                    break;
                }


            }
        }

try {
    for (j = 0; j < link.size(); j++) {
        Log.i("link" + (j + 1), link.get(j));
        Log.i("joined fb date" + (j + 1), joinedFbOn.get(j));
        Log.i("req date" + (j + 1), reqOn.get(j));
        Log.i("Study At" + (j + 1), studyAt.get(j));
        Log.i("Worked At" + (j + 1), workedAt.get(j));
        Log.i("EMAIL ID" + (j + 1), emailID.get(j));
        Log.i("reference from" + (j + 1), referencefrom.get(j));
        Log.i("New Names" + (j + 1), newNames.get(j));
        Log.i("New city" + (j + 1), newlivesIn.get(j));
        Log.i("New workAt" + (j + 1), newworkedAt.get(j));

    }
}
catch(Exception e){}


    }


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            editText = (EditText) findViewById(R.id.editText);
            Button button = (Button) findViewById(R.id.button);



        }
    }

