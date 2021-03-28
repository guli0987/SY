package com.hkd.sy;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.hkd.sy.Update.DownloadService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Activity_update extends AppCompatActivity implements View.OnClickListener {
    public static final int Update_TEXT=1;
    public static final int NotUpdate_TEXT=-1;
    public static final int EqualityUpdate_TEXT=0;
    public static final int Update_TEST=11;
    //更新信息
    private String updateData="";
    private DownloadService.DownloadBinder downloadBinder;
    private ServiceConnection connection=new ServiceConnection(){
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder=(DownloadService.DownloadBinder)service;
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update);
        //Log.d("Activity_update","------------oncreate");
        Button start=findViewById(R.id.start);
        Button pause=findViewById(R.id.pause);
        Button cancel=findViewById(R.id.cancel);
        Button checkU=findViewById(R.id.checkU);
        Button install=findViewById(R.id.install);
        Button updateNote=findViewById(R.id.updateNote);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        cancel.setOnClickListener(this);
        checkU.setOnClickListener(this);
        install.setOnClickListener(this);
        updateNote.setOnClickListener(this);
        Intent intent=new Intent(this,DownloadService.class);
        startService(intent);
        bindService(intent,connection,BIND_AUTO_CREATE);
        if(ContextCompat.checkSelfPermission(Activity_update.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Activity_update.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        //test
        /*if(downloadBinder.DownloadEnd()==1){
            installAPK(Activity_update.this);
        }*/
        //Log.d("Activity_update","---12312------"+downloadBinder.DownloadEnd());

    }
    //获取当前程序版本号,right
    private String getVersionName() {
        PackageManager packageManager=getPackageManager();
        PackageInfo packageInfo= null;
        try {
            packageInfo = packageManager.getPackageInfo(getPackageName(),0);
            //Log.d("MainActivity","本地版本号为："+packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo.versionName;

    }
    //获取线上程序版本号，对接parseXML(responseData),right1
    private void checkVersion(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //https://gdown.baidu.com/data/wisegame/fd84b7f6746f0b18/baiduyinyue_4802.apk
                //http://192.168.43.127:8080/TesServer/version.xml
                //http://192.168.0.100:8080/TesServer/version.xml
                //http://188.131.221.105:8080/TesServer/version.xml
                try {
                    OkHttpClient cilents = new OkHttpClient();
                    Request requests = new Request.Builder()
                            .url("http://www.wetes.cn/Apps/SY/version_sy.json")
                            .build();
                    Response response = cilents.newCall(requests).execute();
                    String responseData = response.body().string();
                    //Log.d("Activity_update","--------------"+responseData);
                    //parseXML(responseData);
                    parseJSON(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    //解析json
    public void parseJSON(String jsonData){
        try {
            String id=null;
            String name=null;
            String versionCode=null;
            JSONArray jsonArray=new JSONArray(jsonData);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("id");
                name = jsonObject.getString("name");
                versionCode = jsonObject.getString("version");
                updateData = jsonObject.getString("data");
                                                }
            String lineVersionName=versionCode;
            String localVersionName=getVersionName();
            //Log.d("MainActivity","线上版本号为："+lineVersionName+"/"+updateData+id+name);
            //比较线上线下版本号
            int bigVersion=compareVersion(lineVersionName, localVersionName);
            //Log.d("MainActivity","bigVersion__"+bigVersion);
            Message message=new Message();
            message.what=bigVersion;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //判断线上线下版本高低,right
    public static int compareVersion(String line, String local) {
        if (line.equals(local)) {
            return 0;
        }else{
            String lineS=line.replace(".","");
            String locaL=local.replace(".","");
            int minLength=Math.min(lineS.length(),locaL.length());
            int flag=996;
            if(lineS.length()>locaL.length()){
                flag=1;
            }else if(lineS.length()<locaL.length()){
                flag=-1;
            }else{
                flag=0;
            }
            int linES=Integer.parseInt(lineS.substring(0,minLength));
            int locAL=Integer.parseInt(locaL.substring(0,minLength));
            int data=886;
            if(linES==locAL){
                //等于，还要判断
                if(flag==1){
                    data=1;
                }else if(flag==0){
                    data=0;
                }else if(flag==-1){
                    data=-1;
                }

            }else if(linES<locAL){
                //线上版本小于线下版本，太令人吃惊了
                data=-1;
            }else{
                //线上版本大于线下版本，需要更新
                data=1;
            }
            /*String linES=lineS.substring(0,minLength);
            String locAL=locaL.substring(0,minLength);*/
            /*System.out.println("linES"+linES);
            System.out.println("locAL"+locAL);*/
            int result=data;
            //System.out.println("result"+result);
            return result;
        }
    }
    //接收哪个版本大，right
private Handler handler=new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message msg) {
        switch(msg.what) {
            case NotUpdate_TEXT:
                Toast.makeText(Activity_update.this,"当前版本高于线上版本",Toast.LENGTH_SHORT).show();
                break;
            case Update_TEXT:
                showUpdateDialog();
                break;
            case EqualityUpdate_TEXT:
                Toast.makeText(Activity_update.this,"当前版本为最新版本,无需更新",Toast.LENGTH_SHORT).show();
                break;
            case Update_TEST:
                Toast.makeText(Activity_update.this,"test11测试专用",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(Activity_update.this,"出现错误",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;//原本false
    }
});
    //提示更新
    public void showUpdateDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_update.this);
        dialog.setTitle("更新提示");
        dialog.setMessage("版本需要更新哦,本次更新信息如下：\n"+updateData);
        dialog.setPositiveButton("更新", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //http://192.168.43.127:8080/TesServer/EHTML.apk
                //http://192.168.0.100:8080/TesServer/EHTML.apk
                NowDownload();
                //installPermission();
                //如果下载成功再跳转安装界面,没搞懂
                //installAPK(Activity_update.this);
                //Log.d("Activity_update","---12312------"+downloadBinder.DownloadEnd());
                /*if(downloadBinder.DownloadEnd()==1){
                    installAPK(Activity_update.this);
                }*/
            }
        });
        dialog.setNegativeButton("稍后", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Activity_update.this,"您取消了更新，推送将稍后",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        //dialog.setCanceledOnTouchOutside(false);//可选，点击dialog其它地方dismiss无效
        //dialog.setCancelable(false);//可选,点击返回键无效

    }
//下载
    private  void NowDownload(){
        String url="http://www.wetes.cn/Apps/SY/SY.apk";
        downloadBinder.startDownload(url);
    }
//方法回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10086){
            //installAPK();
        }
    }
    //安装APK,right
    private void installAPK(Context context){
        //File file= new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), "/EHTML.apk");
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"Download");
        File newFile=new File(file,"SY.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if(Build.VERSION.SDK_INT>=24) {
        Uri apkUri = FileProvider.getUriForFile(context, "com.hkd.sy.fileProvider", newFile);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");}
        else{
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(newFile),"application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
            if(downloadBinder==null){
                //Log.d("Activity_update","------------null");
                return;
            }
            switch (v.getId()){
                case R.id.start:
                    //Log.d("Activity_update","------------start");
                    //Log.d("MainActivity","_____start");
                    //http://192.168.43.127:8080/TesServer/EHTML.apk
                    //http://192.168.0.100:8080/TesServer/EHTML.apk
                    //https://gdown.baidu.com/data/wisegame/fd84b7f6746f0b18/baiduyinyue_4802.apk
                    //http://188.131.221.105:8080/TesServer/EHTML.apk
                    NowDownload();
                    break;
                case R.id.pause:
                    //Log.d("Activity_update","------------pause");
                    downloadBinder.pausedDownload();
                    break;
                case R.id.cancel:
                    //Log.d("Activity_update","------------cancel");
                    downloadBinder.cancelDownload();
                    break;
                case R.id.checkU:
                    //Log.d("Activity_update","------------check");
                    //检测版本号
                    checkVersion();
                    break;
                case R.id.install:
                    //Log.d("Activity_update","------------install");
                    installAPK(Activity_update.this);
                    break;
                case R.id.updateNote:
                    //Log.d("Activity_update","------------note");
                    Intent intent1=new Intent(Activity_update.this, Activity_update_app.class);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "拒绝权限将无法正常使用该应用", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
