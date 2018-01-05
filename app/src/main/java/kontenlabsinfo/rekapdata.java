package kontenlabsinfo;

import com.example.uye.labsinfo.SessionManager;
import com.example.uye.labsinfo.koneksi;

import static com.example.uye.labsinfo.AppVar.URL;
import static com.example.uye.labsinfo.AppVar.URL_ADD;
import static com.example.uye.labsinfo.AppVar.URL_DELETE_REKAP;
import static com.example.uye.labsinfo.AppVar.URL_GET_ALL;
import static com.example.uye.labsinfo.AppVar.URL_GET_REKAP;
import static com.example.uye.labsinfo.AppVar.URL_LOGIN;
import static com.example.uye.labsinfo.AppVar.URL_UPDATE_REKAP;
import static com.example.uye.labsinfo.R.id.editTextUsern;

/**
 * Created by LENOVO IP300 on 29/07/2017.
 */

public class rekapdata extends koneksi {
    String url = "";
    String response = "";


    public String tampilRekap(String npm) {
        try {
            url = URL + "?operasi=view&npm="+ npm;
            System.out.println("URL Tampil Rekapr: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    public String tampilJadwal() {
        try {
            url = URL + "?operasi=jadwal";
            System.out.println("URL Tampil Jadwal: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    public String insertRekap(String npms, String klsadm, String tugas, String hari, String tgl, String bln, String thn, String shift, String kls, String kondisi, String pj) {
        try {
            url = URL + "?operasi=insert&npm=" + npms + "&klsadmin=" + klsadm + "&tugas=" + tugas + "&hari=" + hari + "&tgl=" + tgl + "&bln=" + bln + "&thn=" + thn + "&shift=" + shift +"&kls=" + kls + "&kondisi=" + kondisi + "&pj_rekap=" + pj;
            System.out.println("URL Insert Rekapr : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    public String getRekapById(int id) {
        try {
            url = URL + "?operasi=get_rekap_by_id&id=" + id;
            System.out.println("URL Insert Rekapr : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String updateRekap(String id, String no ,String klsadm, String tugas, String hari, String tgl, String bln, String thn, String shift, String kelas, String kondisi, String  pj) {
        try {
            url =  URL + "?operasijadwal=update&id=" + id + "&no=" + no + "&klsadm=" + klsadm + "&tugas=" +
                    tugas + "&hari=" + hari + "&tgl=" + tgl + "&bulan=" + bln
                    + "&tahun=" + thn + "&shift=" + shift + "&kelas="+ kelas +
                    "&kondisi=" + kondisi + "&pj=" + pj;
            System.out.println("URL Insert Rekapr : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    public String updateJadwal(String no, String nama, String gambar) {
        try {
            url =  URL + "?operasi=update&id=" + no + "&no=" + no + "&nama=" + nama + "&gambar=" + gambar;
            System.out.println("URL Insert Rekapr : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    public String deleteRekap(int id) {
        try {
            url = URL + "?operasi=delete&id=" + id;
            System.out.println("URL Insert Rekapr : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
}
