package com.example.writedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String Data , FileName;
    EditText data , filename ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button write = findViewById(R.id.btn_write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    filename = findViewById(R.id.getFileName);
                    // converting to string
                    FileName =   filename.getText().toString();
                    data = findViewById(R.id.getData);
                    // converting to string
                    Data =   data.getText().toString();
                    writeData(FileName,Data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    /**
     * Writes a new file with Data as string
     *
     * @param file_name = file name with extension you want to create
     * @param data      = Enter Data in String
     * @return int = 1 (After Success)
     * @throws IOException = writing to file may cause runtime error
     */
    public int writeData(String file_name, String data) throws IOException {
        // reading from local json
        // read if exists
        FileOutputStream fOut = openFileOutput(file_name, Context.MODE_PRIVATE);
        fOut.write(data.getBytes());
        fOut.close();
        Toast toas = Toast.makeText(getApplicationContext(),
                "Wrote :" + data + "in :"+file_name,
                Toast.LENGTH_LONG);
        toas.show();
        // Toast.makeText(getBaseContext(),"file read" + file_content ,Toast.LENGTH_SHORT).show();
        return 1;
    }
}
