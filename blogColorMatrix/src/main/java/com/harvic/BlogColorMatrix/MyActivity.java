package com.harvic.BlogColorMatrix;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.util.Log;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ColorMatrix colorMatrix1 = new ColorMatrix(new float[]{
                0.1f, 0.2f, 0.3f, 0.4f, 0.5f,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });


        ColorMatrix colorMatrix2 = new ColorMatrix(new float[]{
                0.11f, 0, 0, 0, 0,
                0, 0.22f, 0, 0, 0,
                0, 0, 0.33f, 0, 0,
                0, 0, 0, 0.44f, 0,
        });

        printSetConcat(colorMatrix1,colorMatrix2);
//        printPreConcat(colorMatrix1,colorMatrix2);
//        printPostConcat(colorMatrix1,colorMatrix2);

    }

    private void printPostConcat(ColorMatrix colorMatrix1,ColorMatrix colorMatrix2){
        Log.d("qijian",printArray(colorMatrix1.getArray()));
        Log.d("qijian",printArray(colorMatrix2.getArray()));
        colorMatrix2.postConcat(colorMatrix1);
        Log.d("qijian",printArray(colorMatrix2.getArray()));
    }

    private void printPreConcat(ColorMatrix colorMatrix1,ColorMatrix colorMatrix2){
        Log.d("qijian",printArray(colorMatrix1.getArray()));
        colorMatrix1.preConcat(colorMatrix2);
        Log.d("qijian",printArray(colorMatrix2.getArray()));
        Log.d("qijian",printArray(colorMatrix1.getArray()));
    }

    private void printSetConcat(ColorMatrix colorMatrix1,ColorMatrix colorMatrix2){
        ColorMatrix resultMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
        });
        resultMatrix.setConcat(colorMatrix1,colorMatrix2);

        Log.d("qijian",printArray(colorMatrix1.getArray()));
        Log.d("qijian",printArray(colorMatrix2.getArray()));
        Log.d("qijian",printArray(resultMatrix.getArray()));
    }


    private String printArray(float[] array){
        StringBuilder builder = new StringBuilder("array dump:\n");
        for (int i=0;i<array.length;i++){
            if (i%5==0){
                builder.append("\n");
            }
            builder.append(array[i]+" ");
        }
        return builder.toString();
    }

}
