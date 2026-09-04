/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlithucuong;

import Controller.ThucUongController;
import Repository.ThucUongRepository;
import Service.NhanVienService;
import Service.ThucUongService;
import View.ThucUongView;

/**
 *
 * @author DELL
 */
public class QuanLiThucUong {

    public static void main(String[] args) {
        ThucUongView view = new ThucUongView();
//        ThucUongRepository repository = new ThucUongRepository();
        ThucUongService service = new ThucUongService();
        NhanVienService NVservice = new NhanVienService();
        ThucUongController controller = new ThucUongController(view, service ,NVservice);
        view.setVisible(true);
    }
}
