package tech.srinath.irtransmitter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.hardware.ConsumerIrManager;

public class MainActivity extends AppCompatActivity {

    ConsumerIrManager IR;
    Button transmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.transmit).setOnClickListener(TransmitListener);
        IR = (ConsumerIrManager)getSystemService(Context.CONSUMER_IR_SERVICE);
        transmit = (Button) findViewById(R.id.transmit);


    }

    View.OnClickListener TransmitListener = new View.OnClickListener() {
        public void onClick(View v) {

            int[] pattern = {4445, 4418, 552, 1657, 552, 1657, 552, 1657, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 1657, 552, 1657, 552, 1657, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 1657, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 552, 1657, 552, 1657, 552, 552, 552, 1657, 552, 1657, 552, 1657, 552, 1657, 552, 1657, 552, 47182, 4445, 4418, 552, 552, 552, 97152};
            int frequency = 38029;

            IR.transmit(frequency, pattern);
            transmit.setText("SENT");

        }
    };
}
