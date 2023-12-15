/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.imp.ImpSV_TA;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.KhuyenMai;
import repositorys.IRepo_TA.IKhuyenmaiRepository;
import repositorys.imp.Imp_TA.KhuyenmaiReponsitory;
import services.ISV_TA.IKhuyenmaiService;
import viewmodel.KhuyenmaiViewmodel;

/**
 *
 * @author ADMIN
 */
public class KhuyenmaiService implements IKhuyenmaiService {

    private IKhuyenmaiRepository repository;
    private List<KhuyenmaiViewmodel> lstKM;

    public KhuyenmaiService() {
        repository = new KhuyenmaiReponsitory();
    }

    @Override
    public List<KhuyenmaiViewmodel> GetALL() {
        List<KhuyenMai> lst = repository.GetAll();
        lstKM = new ArrayList<>();
        for (KhuyenMai x : lst) {
            lstKM.add(new KhuyenmaiViewmodel(x.getTenKM(), x.getHinhThucKM(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaTriGiam(), x.getTrangthai()));
        }
        return lstKM;
    }

    @Override
    public void Add(KhuyenMai km) {
        if (repository.Add(km)) {
            System.out.println("Thêm thành công khuyến mãi");
        } else {
            System.out.println("Thêm thất bại khuyến mãi");
        }
    }

    @Override
    public void Update(KhuyenMai km, int id) {
        if (repository.Update(km, id)) {
            System.out.println("Sửa thành công khuyến mãi");
        } else {
            System.out.println("Sửa thất bại khuyến mãi");
        }
    }

    @Override
    public void Delete(int id) {
        if (repository.Delete(id)) {
            System.out.println("Xóa thành công khuyến mãi");
        } else {
            System.out.println("Xóa thất bại khuyến mãi");
        }
    }

    @Override
    public String checktrung(String ten) {
        return repository.checktrung(ten);
    }

    @Override
    public List<KhuyenmaiViewmodel> GetOnebyBD(String date) {
        List<KhuyenMai> lst = repository.GetOnebyBD(date);
        lstKM = new ArrayList<>();
        for (KhuyenMai x : lst) {
            lstKM.add(new KhuyenmaiViewmodel(x.getTenKM(), x.getHinhThucKM(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaTriGiam(), x.getTrangthai()));
        }
        return lstKM;
    }

    @Override
    public List<KhuyenmaiViewmodel> GetOnebyKT(String date) {
        List<KhuyenMai> lst = repository.GetOnebyKT(date);
        lstKM = new ArrayList<>();
        for (KhuyenMai x : lst) {
            lstKM.add(new KhuyenmaiViewmodel(x.getTenKM(), x.getHinhThucKM(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaTriGiam(), x.getTrangthai()));
        }
        return lstKM;
    }

    @Override
    public List<KhuyenmaiViewmodel> GetOnebyALL(String datedb, String datekt) {
        List<KhuyenMai> lst = repository.GetOnebyALL(datedb, datekt);
        lstKM = new ArrayList<>();
        for (KhuyenMai x : lst) {
            lstKM.add(new KhuyenmaiViewmodel(x.getTenKM(), x.getHinhThucKM(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaTriGiam(), x.getTrangthai()));
        }
        return lstKM;
    }

    @Override
    public List<KhuyenMai> GetOnebyten(String ten) {
        List<KhuyenMai> lst = repository.GetOnebyten(ten);
        lstKM = new ArrayList<>();
        for (KhuyenMai x : lst) {
            lstKM.add(new KhuyenmaiViewmodel(x.getTenKM(), x.getHinhThucKM(), x.getNgayBatDau(), x.getNgayKetThuc(), x.getGiaTriGiam(), x.getTrangthai()));
        }
        return lst;
    }

//    @Override
//    public boolean UpdateTT() {
//        boolean iscapnhat = repository.UpdateTT();
//        return iscapnhat;
//    }
//
//    @Override
//    public boolean UpdateTT2() {
//        boolean iscapnhat = repository.UpdateTT2();
//        return iscapnhat;
//    }
    @Override
    public List<KhuyenMai> getlist() {
        return repository.GetAll();
    }

    public boolean capNhatTrangThaiKhuyenMai() {
        return new KhuyenmaiReponsitory().updateStatusKMHetHan();
    }

}
