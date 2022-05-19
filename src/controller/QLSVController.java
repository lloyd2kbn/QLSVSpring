package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	private QLSVView view;

//	constructor
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn đã chọn: " + cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThem();

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Loi");
			}

		} else if (cm.equals("Cập nhật")) {
			try {
				this.view.hienThiThongTinThiSinhDaChon();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (cm.equals("Xóa")) {
			try {
				this.view.thucHienXoa();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		} else if (cm.equals("Tìm")) {
			this.view.thucHienTim();
		} else if (cm.equals("Hủy Tìm")) {
			this.view.taiLaiDuLieu();

		}else if (cm.equals("About Me")) {
			this.view.hienThiAbout();
		}else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if (cm.equals("Save")) {
			try {
				this.view.thucHienSave();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (cm.equals("Open")) {
			try {
				this.view.thucHienOpen();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
