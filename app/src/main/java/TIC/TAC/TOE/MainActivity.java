package TIC.TAC.TOE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int count=0;
    int i=0;

    ImageView imgv,imgv1,imgv2,imgv3,imgv4,imgv5,imgv6,imgv7,imgv8,imgv9;

    int[] gstate={2,2,2,2,2,2,2,2,2,2};
    int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropin(View view) {

 ImageView counter = (ImageView) view;

        int tap=Integer.parseInt(counter.getTag().toString());

        if(gstate[tap]==2) {
            counter.setTranslationY(-1000f);
            gstate[tap]=count;
            if (count == 0) {
                counter.setImageResource(R.drawable.cross);
                count = 1;
            } else {
                counter.setImageResource(R.drawable.circle);
                count = 0;
            }

            counter.animate().translationYBy(1000f).rotationXBy(3600).setDuration(500);

            for(int[] winpos:winpos)
            {
                if(gstate[winpos[0]] == gstate[winpos[1]] && gstate[winpos[1]] == gstate[winpos[2]]&&gstate[winpos[0]] != 2)
                {
                    imgv=(ImageView)findViewById(R.id.imgv10);
                    imgv.animate().translationYBy(1000f).rotationXBy(360).setDuration(500);

                    EditText edt=(EditText)findViewById(R.id.etxt);

                    if(gstate[winpos[0]]==0)
                    {
                        edt.setText("Blue has Won");
                    }
                    else
                    {
                        edt.setText("RED has Won");
                    }

                }
            }
        }
    }

    public void win(View view)
    {
        imgv=(ImageView)findViewById(R.id.imgv10);
        imgv.setTranslationY(-1000f);

     /*   imgv1=(ImageView)findViewById(R.id.imgv1);
        imgv2=(ImageView)findViewById(R.id.imgv2);
        imgv3=(ImageView)findViewById(R.id.imgv3);
        imgv4=(ImageView)findViewById(R.id.imgv4);
        imgv5=(ImageView)findViewById(R.id.imgv5);
        imgv6=(ImageView)findViewById(R.id.imgv6);
        imgv7=(ImageView)findViewById(R.id.imgv7);
        imgv8=(ImageView)findViewById(R.id.imgv8);
        imgv9=(ImageView)findViewById(R.id.imgv9); */



        for(i=0;i<10;i++)
        {
            gstate[i]=2;
        }
        i=0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        imgv=(ImageView)findViewById(R.id.imgv10);
        imgv.setTranslationY(-1000f);

    }
}
