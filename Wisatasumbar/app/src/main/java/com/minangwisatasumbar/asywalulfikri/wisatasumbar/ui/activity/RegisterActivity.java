package com.minangwisatasumbar.asywalulfikri.wisatasumbar.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.minangwisatasumbar.asywalulfikri.wisatasumbar.R;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.ui.adapter.CustomArrayAdapter;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.util.Debug;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.util.StringUtil;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.util.Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by asywalulfikri on 9/21/16.
 */

public class RegisterActivity extends BaseActivity{

    // UI
    private EditText mUsernameView;
    private EditText mEmailView;
    private EditText mGenderView;
    private EditText mBirthDateView;
    private EditText mPasswordView;
    private Button   btnRegister;
    private ImageView mAvatarView;
    private ImageView mTakeImageView;

    //CAMERA
    private static final int PICK_FROM_CAMERA = 1;
    private static final int CROP_FROM_CAMERA = 2;
    private static final int PICK_FROM_FILE   = 3;
    private Uri mImageCaptureUri;
    private Uri mImageCropUri;
    Bitmap bitmap = null;
    private String mFilePath = "";
    Bitmap bitmappp = null;

    //Calender
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsernameView  = (EditText)findViewById(R.id.et_username);
        mEmailView     = (EditText)findViewById(R.id.et_email);
        mGenderView    = (EditText)findViewById(R.id.et_gender);
        mBirthDateView = (EditText)findViewById(R.id.et_birthDate);
        mPasswordView  = (EditText)findViewById(R.id.et_password);
        mAvatarView    = (ImageView)findViewById(R.id.iv_avatar);
        mTakeImageView = (ImageView)findViewById(R.id.iv_take_image);
        btnRegister    = (Button)findViewById(R.id.btn_register);

        //----------------- ISI KALENDER TANGGAL LAHIR----------------------//
        mBirthDateView.setFocusableInTouchMode(false);
        mBirthDateView.setFocusable(false);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                showCalender();
            }
        };
        mBirthDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegisterActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                hideKeyboard();
            }
        });

        // ---------------------PILIH JENIS KELAMIN-------------------------//
        mGenderView.setFocusableInTouchMode(false);
        mGenderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                showGenderOptions();
            }
        });

        //----------TAKE IMAGE KLIK---------------//
        mTakeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChooserDialog();
            }
        });


        //--------BUTTON SIMPAN KLIK-----------//
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username   = mUsernameView.getText().toString().trim();
                String email      = mEmailView.getText().toString().trim();
                String gender     = mGenderView.getText().toString().trim();
                String password   = mPasswordView.getText().toString().trim();
                String birthDate  = mBirthDateView.getText().toString().trim();

                if (username.equals("") || email.equals("") || gender.equals("") || password.equals("")|| birthDate.equals("")) {
                    Toast.makeText(RegisterActivity.this, getString(R.string.text_register_null), Toast.LENGTH_SHORT).show();
                    return;
                } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                    Toast.makeText(RegisterActivity.this, getString(R.string.text_email_not_valid), Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.length() < 6) {
                    Toast.makeText(RegisterActivity.this,getString(R.string.text_password_low),Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(0, 0);
    }

    private void showCalender() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mBirthDateView.setText(sdf.format(myCalendar.getTime()));
    }
    private void showGenderOptions() {
        final String[] genders = {getString(R.string.text_male), getString(R.string.text_female)};

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.text_title_dialog_gender))
                .setItems(genders, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mGenderView.setText(genders[which]);
                        Toast.makeText(RegisterActivity.this, mGenderView.getText(), Toast.LENGTH_SHORT).show();
                    }
                });

        builder.create().show();
    }
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = getCurrentFocus();
        if (v != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Debug.i("On Result");

        if (requestCode == PICK_FROM_FILE  && resultCode == Activity.RESULT_OK) {
            mImageCaptureUri = data.getData();
            doCrop();
        } else if (requestCode == CROP_FROM_CAMERA  && resultCode == Activity.RESULT_OK) {
            mFilePath   = mImageCropUri.getPath();
            File file   = new File(mFilePath);

            if (!file.exists()) {
                Toast.makeText(RegisterActivity.this,getString(R.string.text_crop_failed),Toast.LENGTH_SHORT).show();
            } else {
                bitmappp = getBitmap(mFilePath);
                mAvatarView.setImageBitmap(bitmappp);

            }
        } else if (requestCode == PICK_FROM_CAMERA   && resultCode == Activity.RESULT_OK) {
            doCrop();
        }
    }

    private void doCrop() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");

        List<ResolveInfo> list = getActivity().getPackageManager().queryIntentActivities( intent, 0 );

        int size = list.size();

        if (size == 0) {
            Toast.makeText(RegisterActivity.this,getString(R.string.text_image_null),Toast.LENGTH_SHORT).show();

            return;
        } else {
            intent.setData(mImageCaptureUri);

            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);

            String fileName = StringUtil.getFileName(mImageCaptureUri.getPath());
            String cropFile = Util.getAppDir() + "/crop_" + fileName + ".jpg";

            Debug.i(cropFile);
            Debug.i("File " + mImageCaptureUri.getPath());

            mImageCropUri   = Uri.fromFile(new File(cropFile));

            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCropUri);

            if (size == 1) {
                Intent i        = new Intent(intent);
                ResolveInfo res = list.get(0);

                i.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));

                startActivityForResult(i, CROP_FROM_CAMERA);
            } else {
                Intent i        = new Intent(intent);
                ResolveInfo res = list.get(0);

                i.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));

                startActivityForResult(i, CROP_FROM_CAMERA);
            }
        }
    }
    //--------------- SHOW IMAGE TAKE USE---------------//
    private void showChooserDialog() {
        String[] options = {getString(R.string.text_camera), getString(R.string.text_gallery)};

        CustomArrayAdapter adapter  = new CustomArrayAdapter(this, R.layout.list_item_adapter, options);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.text_Image_use));
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int position) {
                if (position == 0) {
                    if (isIntentAvailable(getActivity(), MediaStore.ACTION_IMAGE_CAPTURE)) {
                        Intent intent    = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                                "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));

                        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

                        try {
                            intent.putExtra("return-data", true);
                            startActivityForResult(intent, PICK_FROM_CAMERA);
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this,getString(R.string.text_camera_not_available),Toast.LENGTH_SHORT).show();
                    }
                } else if (position == 1) { //gallery
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
                }
            }
        });

        builder.create().show();
    }

    private boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent     = new Intent(action);
        List<ResolveInfo> list  = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return list.size() > 0;
    }


    //---------------SCALE IMAGE/ RESIZE------------------------//
    private Bitmap getBitmap(String path) {

        Uri uri = Uri.fromFile(new File(path));
        InputStream in = null;
        try {
            final int IMAGE_MAX_SIZE = 1200000; // 1.2MP
            in = getContentResolver().openInputStream(uri);

            // Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, o);
            in.close();


            int scale = 1;
            while ((o.outWidth * o.outHeight) * (1 / Math.pow(scale, 2)) >
                    IMAGE_MAX_SIZE) {
                scale++;
            }
            Log.d("", "scale = " + scale + ", orig-width: " + o.outWidth + ", orig-height: " + o.outHeight);

            Bitmap b = null;
            in = getContentResolver().openInputStream(uri);
            if (scale > 1) {
                scale--;
                // scale to max possible inSampleSize that still yields an image
                // larger than target
                o = new BitmapFactory.Options();
                o.inSampleSize = scale;
                b = BitmapFactory.decodeStream(in, null, o);

                // resize to desired dimensions
                int height = b.getHeight();
                int width = b.getWidth();
                Log.d("", "1th scale operation dimenions - width: " + width + ", height: " + height);

                double y = Math.sqrt(IMAGE_MAX_SIZE
                        / (((double) width) / height));
                double x = (y / height) * width;

                Bitmap scaledBitmap = Bitmap.createScaledBitmap(b,450,
                        450, true);
                b.recycle();
                b = scaledBitmap;

                System.gc();


            } else {
                b = BitmapFactory.decodeStream(in);
            }
            in.close();

            Log.d("", "bitmap size - width: " + b.getWidth() + ", height: " +
                    b.getHeight());
            return b;
        } catch (IOException e) {
            Log.e("", e.getMessage(), e);
            return null;
        }
    }


}