/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.ISV_TA;

import java.util.List;
import models.KhuyenMai;
import viewmodel.KhuyenmaiViewmodel;

/**
 *
 * @author ADMIN
 */
public interface IKhuyenmaiService {
    
    public boolean capNhatTrangThaiKhuyenMai();
    public List<KhuyenmaiViewmodel> GetALL();

    public void Add(KhuyenMai km);

    public void Update(KhuyenMai km, int id);

    public void Delete(int id);

    public String checktrung(String ten);

    public List<KhuyenmaiViewmodel> GetOnebyBD(String date);

    public List<KhuyenmaiViewmodel> GetOnebyKT(String date);

    public List<KhuyenmaiViewmodel> GetOnebyALL(String datedb, String datekt);

    public List<KhuyenMai> GetOnebyten(String ten);


    public List<KhuyenMai> getlist();
}
