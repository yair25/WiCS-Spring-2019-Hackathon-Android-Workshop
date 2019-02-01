package com.yairn.wics.basics;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.renderscript.Element;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class CardHolder extends RecyclerView.ViewHolder {

    private final int CAMERA_PIC_REQUEST = 0;

    private ImageView imageView;
    private TextView textView;
    private Button button;

    private Type type;
    private String url = null;


    public CardHolder(View cardItemView) {
        super(cardItemView);

        imageView = itemView.findViewById(R.id.itemImageView);
        textView = itemView.findViewById(R.id.itemTextView);
        button = itemView.findViewById(R.id.itemButton);
    }

    public void setType(TypeData data) {
        this.type = data.type;
        url = data.url;
    }


    public void setImage() {
        Picasso.get().load(url).fit().into(imageView);
        this.url = url;
    }

    public void setImage(final int resource) {
        Picasso.get().load(resource).fit().into(imageView);
    }

    public void setText() {
        textView.setText(type.name());
    }

    public void setButtonOnClick() {
        switch (type) {
            case Maps:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickMaps(v);
                    }
                });
                break;

            case Image:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickBrowser(v);
                    }
                });
                break;

            case Browser:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickBrowser(v);
                    }
                });
                break;

            case Calc:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickCalc(v);
                    }
                });
                break;

            default:
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickAct(v);
                    }
                });
        }
    }

    /*
     * This is where the all the logic for clicking the button goes.
     *
     * In the method onClickMaps, an Intent is made to start the Maps app.
     * If the device does not have a Maps app, a message (Toast) will be displayed.
     */
    public void onClickMaps(View view) {
        Intent intent = new Intent();
        // Action is set to main, so that the app is the main focus
        intent.setAction(Intent.ACTION_MAIN);
        // Category is set to CATEGORY_APP_MAPS, so any app that is considered a map can be opened
        intent.addCategory(Intent.CATEGORY_APP_MAPS);
        // Flag is set to FLAG_ACTIVITY_NEW_TASK, because a whole new task (app) will start
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Will try to start the activity
        try {
            view.getContext().getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            // Will ensure that the app does not crash if there is no Maps app found
            Toast.makeText(view.getContext().getApplicationContext(), "No Maps App Found.", Toast.LENGTH_LONG).show();
        }
    }

    /*
    * This is where the all the logic for clicking the button goes.
    *
    * In the method onClickBrowser, an Intent is made to start the Browser app.
    * If the device does not have a Browser app, a message (Toast) will be displayed.
    */
    public void onClickBrowser(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            view.getContext().getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            // Will ensure that the app does not crash if there is no Maps app found
            Toast.makeText(view.getContext().getApplicationContext(), "No Browser App Found.", Toast.LENGTH_LONG).show();
        }
    }


    /*
     * This is where the all the logic for clicking the button goes.
     *
     * In the method onClickCalc, an Intent is made to start the Calculator app.
     * If the device does not have a Calculator app, a message (Toast) will be displayed.
     */
    public void onClickCalc(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            view.getContext().getApplicationContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(view.getContext().getApplicationContext(), "No Calculator App Found.", Toast.LENGTH_LONG).show();
        }
    }

    /*
     * This is where the all the logic for clicking the button goes.
     *
     * In the method onClickCalc, an Intent is made to start the Calculator app.
     * If the device does not have a Calculator app, a message (Toast) will be displayed.
     */
    public void onClickAct(View view) {
        Intent intent = new Intent(view.getContext().getApplicationContext(), Main2Activity.class);
        intent.putExtra("Message", "Hello, World!");

        try {
            view.getContext().startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(view.getContext().getApplicationContext(), "No Calculator App Found.", Toast.LENGTH_LONG).show();
        }
    }


}