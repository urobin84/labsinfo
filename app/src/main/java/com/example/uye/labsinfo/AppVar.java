package com.example.uye.labsinfo;

/**
 * Created by LENOVO IP300 on 08/08/2017.
 */

public class AppVar {

    //URL to our login.php file, url bisa diganti sesuai dengan alamat server kita
    public static final String URL = "http://192.168.43.86/labsinfo/asisten/server.php";
    public static final String LOGIN_URL = "http://192.168.43.86/labsinfo/asisten/login.php";

    //Keys for username and password as defined in our $_POST['key'] in login.php
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.43.86/labsinfo/asisten/server.php?operasi=insert";
    public static final String URL_GET_ALL = "http://192.168.43.86/labsinfo/asisten/tampilSemuaRekap.php";
    public static final String URL_GET_REKAP = "http://192.168.43.86/labsinfo/asisten/tampilRekap.php?id=";
    public static final String URL_UPDATE_REKAP = "http://192.168.43.86/labsinfo/asisten/server.php?operasi=updater";
    public static final String URL_DELETE_REKAP = "http://192.168.43.86/labsinfo/asisten/hapusRekap.php?id=";
    public static final String URL_GET_BIODATA = "http://192.168.43.86/labsinfo/asisten/server.php?operasi=biodata";
    public static final String URL_GET_FOTOBIODATA = "http://192.168.43.86/labsinfo/asisten/servers/image/";
    public static final String URL_GET_JADWAL = "http://192.168.43.86/labsinfo/asisten/server.php?operasi=jadwal";
    public static final String URL_GET_FOTOJADWAL = "http://192.168.43.86/labsinfo/asisten/servers/image/";
    public static final String URL_LOGIN = "http://192.168.43.86/labsinfo/asisten/loginphp.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_ID = "id";
    public static final String KEY_ASISTEN_KLSADM = "klsadm";
    public static final String KEY_ASISTEN_TUGAS = "tugas";
    public static final String KEY_ASISTEN_HARI = "hari";
    public static final String KEY_ASISTEN_TANGGAL = "tanggal";
    public static final String KEY_ASISTEN_BULAN = "bln";
    public static final String KEY_ASISTEN_TAHUN = "thn";
    public static final String KEY_ASISTEN_SHIFT = "shift";
    public static final String KEY_ASISTEN_KELAS = "kls";
    public static final String KEY_ASISTEN_KONDISI = "kondisi";
    public static final String KEY_ASISTEN_PJ = "pj_rekap";

    public static final String KEY_ASISTEN_NPM = "npm";
}