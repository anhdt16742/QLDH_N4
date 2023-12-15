/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.model_DT;

/**
 *
 * @author Admin
 */
public class TemplateBaoHanh {

    private String idMauBH, tenSP;
    private int thoiHan;

    public TemplateBaoHanh() {
    }

    public TemplateBaoHanh(String idMauBH, String tenSP, int thoiHan) {
        this.idMauBH = idMauBH;
        this.tenSP = tenSP;
        this.thoiHan = thoiHan;
    }

    public TemplateBaoHanh(String tenSP, int thoiHan) {
        this.tenSP = tenSP;
        this.thoiHan = thoiHan;
    }

    public String getIdMauBH() {
        return idMauBH;
    }

    public void setIdMauBH(String idMauBH) {
        this.idMauBH = idMauBH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return "TemplateBaoHanh{" + "idMauBH=" + idMauBH + ", tenSP=" + tenSP + ", thoiHan=" + thoiHan + '}';
    }

    public Object[] toDataRow3() {
        return new Object[]{this.idMauBH, this.tenSP, thoiHan + " Tháng"};
    }
}
