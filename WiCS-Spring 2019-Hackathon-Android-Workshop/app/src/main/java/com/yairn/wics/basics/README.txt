Hello there,

Bellow are instructions as well as a few more details on how to make this app.

Hook'em,
Yair Nieto

Instructions
1. Go to Grade Scripts > build.gradle (Module: app) and add the following lines to dependencies:
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    implementation 'com.android.support:cardview-v7:28.0.0'
    implementation 'com.squareup.picasso:picasso:2.71828'


The first implementation will allow the recycler view tool to be included in the app
The second implementation will allow the card view tool to be included in the app
The third implementation will allow the Picasso api to be included in the app, so images can be
    loaded onto views in the background



2. Go to app > manifests > AndroidManifest.xml and add the following lines in manifest
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.CAMERA" />


The first uses-permission lets the app store and user know that the app intends on using the internet
the second uses-permission lets the app store and user know that the app intends on using the camera


3. Go to app > res > layout > activity_main.xml and with ConstraintLayout, add RecyclerView (Should be in the Pallet > Containers).
    Give the Recycler View an id!
4. Go to app > java > com.________ > MainActivity and like the UI to the code

Add a global RecyclerView variable called recyclerView (can be named something different)
        private RecyclerView recyclerView;

Add the following line in the onCreate method to link up the UI to code
        recyclerView = findViewById(R.id.recyclerView);

5. Next make item_card.xml in app > res > layout.
    Right click on the layout folder and select new > Layout resource file and call it item_card

6. Change android.support.constraint.ConstraintLayout > android.support.v7.widget.CardView

    (Optional for design)
        xmlns:app="http://schemas.android.com/apk/res-auto"
        app:cardElevation="16dp"
        app:cardCornerRadius="16dp"
        android:layout_margin="8dp"

set id of cardView to itemCard


7. Add Views to CardView > ConstraintLayout > ImageView, TextView, Button
    Give them ids

8. Next make CardHolder class in app > java > com.___.wics.basics > CardHolder

MediaStore.ACTION_IMAGE_CAPTURE
