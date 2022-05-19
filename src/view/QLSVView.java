package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	public JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaSinhVien;
	public JTable table;
	public JTextField textField_Id;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_QueQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	private JComboBox comboBox_TimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 602);
		ActionListener action = new QLSVController(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 733, 31);
		contentPane.add(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuSave.addActionListener(action);
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuExit.addActionListener(action);
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.addActionListener(action);
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAboutMe.addActionListener(action);
		menuAbout.add(menuAboutMe);
		JLabel label_QueQuan = new JLabel("Qu\u00EA Qu\u00E1n");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan.setBounds(10, 47, 85, 23);
		contentPane.add(label_QueQuan);

		JLabel labelMaThiSinh = new JLabel("M\u00E3 Th\u00ED Sinh");
		labelMaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelMaThiSinh.setBounds(235, 47, 100, 23);
		contentPane.add(labelMaThiSinh);

		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_MaSinhVien.setColumns(10);
		textField_MaSinhVien.setBounds(345, 48, 92, 25);
		contentPane.add(textField_MaSinhVien);

		JButton btnTim = new JButton("T\u00ECm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setBounds(447, 40, 109, 40);
		btnTim.addActionListener(action);
		contentPane.add(btnTim);

		comboBox_TimKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_TimKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_TimKiem.addItem(tinh.getTenTinh());
		}
		comboBox_TimKiem.setBounds(105, 47, 100, 23);
		contentPane.add(comboBox_TimKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(5, 81, 733, 15);
		contentPane.add(separator_1);

		JLabel lblDssv = new JLabel("DSSV");
		lblDssv.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDssv.setBounds(10, 92, 85, 15);
		contentPane.add(lblDssv);

		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Th\u00ED Sinh", "H\u1ECD T\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 118, 723, 201);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(5, 330, 733, 15);
		contentPane.add(separator_1_1);

		JLabel label_QueQuan_1 = new JLabel("Thông tin");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_1.setBounds(5, 335, 85, 23);
		contentPane.add(label_QueQuan_1);

		JLabel labelID = new JLabel("Mã Thí Sinh");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelID.setBounds(5, 365, 118, 23);
		contentPane.add(labelID);

		textField_Id = new JTextField();
		textField_Id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Id.setColumns(10);
		textField_Id.setBounds(117, 365, 136, 25);
		contentPane.add(textField_Id);

		JLabel labelHoVaTen = new JLabel("Họ Và Tên");
		labelHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelHoVaTen.setBounds(5, 399, 118, 23);
		contentPane.add(labelHoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(117, 399, 136, 25);
		contentPane.add(textField_HoVaTen);

		JLabel lblQueQuan = new JLabel("Quê Quán");
		lblQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQueQuan.setBounds(5, 433, 118, 23);
		contentPane.add(lblQueQuan);

		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.setBounds(117, 437, 136, 22);
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		contentPane.add(comboBox_QueQuan);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNgaySinh.setBounds(5, 472, 118, 23);
		contentPane.add(lblNgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(117, 472, 136, 25);
		contentPane.add(textField_NgaySinh);

		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblGiiTnh.setBounds(324, 365, 118, 23);
		contentPane.add(lblGiiTnh);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBounds(416, 369, 63, 23);
		contentPane.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBounds(512, 369, 109, 23);
		contentPane.add(radioButton_nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		JLabel label_Mon1 = new JLabel("Môn 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon1.setBounds(324, 397, 118, 23);
		contentPane.add(label_Mon1);

		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(436, 397, 136, 25);
		contentPane.add(textField_Mon1);

		JLabel label_Mon2 = new JLabel("Môn 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon2.setBounds(324, 433, 118, 23);
		contentPane.add(label_Mon2);

		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(436, 434, 136, 25);
		contentPane.add(textField_Mon2);

		JLabel label_Mon3 = new JLabel("Môn 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon3.setBounds(324, 472, 118, 23);
		contentPane.add(label_Mon3);

		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(436, 472, 136, 25);
		contentPane.add(textField_Mon3);

		JButton btn_Them = new JButton("Thêm");
		btn_Them.addActionListener(action);
		btn_Them.setBounds(22, 521, 113, 31);
		contentPane.add(btn_Them);

		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.setBounds(160, 521, 113, 31);
		btn_Xoa.addActionListener(action);
		contentPane.add(btn_Xoa);

		JButton btn_CapNhat = new JButton("Cập nhật");
		btn_CapNhat.setBounds(315, 521, 113, 31);
		btn_CapNhat.addActionListener(action);
		contentPane.add(btn_CapNhat);

		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(470, 521, 113, 31);
		btn_Luu.addActionListener(action);
		contentPane.add(btn_Luu);

		JButton btn_Huy = new JButton("Hủy");
		btn_Huy.setBounds(607, 521, 113, 31);
		btn_Huy.addActionListener(action);
		contentPane.add(btn_Huy);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(5, 506, 728, 2);
		contentPane.add(separator_2);

		JButton btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyTim.setBounds(566, 40, 124, 40);
		contentPane.add(btnHuyTim);
		this.setVisible(true);
	}

//	xoaForm
	public void xoaForm() {
		textField_Id.setText("");
		textField_HoVaTen.setText("");
		textField_MaSinhVien.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();

	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
		model_Table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() == true ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + ""

		});
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
//		ADD SINH VIEN DO VAO 
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
//			dua du lieu vao table

			System.out.println("them");

			this.themThiSinhVaoTable(ts);

		} else {
			// CAP NHAT DU LIEU
			System.out.println("capnhat");
			this.model.update(ts);
			int soLuongDong = model_Table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_Table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_Table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_Table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_Table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_Table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900), i, 3);
					model_Table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					model_Table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_Table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_Table.setValueAt(ts.getDiemMon3() + "", i, 7);

				}

			}
		}

	}

	public void hienThiThongTinThiSinhDaChon() throws ParseException {
		// lay ra dong` table da chon

		int i_row = table.getSelectedRow();
		ThiSinh ts = this.getThiSinh();

//		set du lieu len form
		this.textField_Id.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh() + "");
		this.textField_NgaySinh.setText(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900) + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
//		}
//		this.btn_gioiTinh.setSelected(null, ts.isGioiTinh());
			this.textField_Mon1.setText(ts.getDiemMon1() + "");
			this.textField_Mon2.setText(ts.getDiemMon2() + "");
			this.textField_Mon3.setText(ts.getDiemMon3() + "");
		}

	}

//	Xóa thí sinh
	public void thucHienXoa() throws ParseException {
		System.out.println("xoaaaaa");
		// lay ra dong` table da chon
		DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc xóa dòng đã chọn");
		if (luaChon == JOptionPane.YES_OPTION) {

			ThiSinh ts = this.getThiSinh();

			this.model.remove(ts);
			model_Table.removeRow(i_row);
		}

	}

	public ThiSinh getThiSinh() throws ParseException {

		DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int maThiSinh = Integer.valueOf(table.getValueAt(i_row, 0) + "");
		String tenThiSinh = table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_Table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_Table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(model_Table.getValueAt(i_row, 3) + "");

		String textGioiTinh = model_Table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_Table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_Table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_Table.getValueAt(i_row, 7) + "");
		return new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		// TODO Auto-generated method stub

	}

	public void thucHienThem() throws ParseException {
		System.out.println("get du lieu");
//	get Du Lieu
		int maThiSinh = Integer.valueOf(this.textField_Id.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(this.textField_NgaySinh.getText());

		String chonGioiTinh = this.btn_gioiTinh.getSelection() + "";
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;

		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;

		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		System.out.println("get du lieu");
		this.themHoacCapNhatThiSinh(ts);

	}

	public void thucHienTim() {
//		Goi ham huy tim kiem
		this.taiLaiDuLieu();
//		lay ra que quan 
		int queQuan = this.comboBox_TimKiem.getSelectedIndex() - 1;
		System.out.println(queQuan);
		String maTS = this.textField_MaSinhVien.getText();
		DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int soLuongDong = model_Table.getRowCount();
		Set<Integer> cacIDCuaThiSinhCanXoa = new TreeSet<Integer>();
//		sort theo que quan
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			System.out.println(tinhDaChon);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_Table.getValueAt(i, 2) + "";
				String id = model_Table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					cacIDCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}

		}
//		sort theo hoTen
		if (maTS.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_Table.getValueAt(i, 0) + "";
				if (!id.equals(maTS)) {
					cacIDCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}

			}
		}
		for (Integer idCanXoa : cacIDCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_Table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_Table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_Table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}

			}
		}

	}

	public void taiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_Table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_Table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				model_Table.removeRow(0);
			}

		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lí thí sinh");

	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc thoát khỏi chương trình", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void thucHienSave() throws FileNotFoundException, IOException {
		if (this.model.getTenFile().length()>0) {			
				saveFile(this.model.getTenFile());	
		} else {
			
			JFileChooser fc=new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
					saveFile(file.getAbsolutePath());
			
			}
		}
				
			


	}

	private void saveFile(String path) throws FileNotFoundException, IOException {
		this.model.setTenFile(path);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			oos.writeObject(ts);
		}
	
		oos.close();

	}

	public void thucHienOpen() throws FileNotFoundException, IOException, ClassNotFoundException {

		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			OpenFile(file);
			taiLaiDuLieu();
		}
	}

	private void OpenFile(File file) {
		ArrayList<ThiSinh> ds=new ArrayList<ThiSinh>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			this.model.setTenFile(file.getAbsolutePath());
			ThiSinh ts=null;
			while ((ts=(ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			
			ois.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.model.setDsThiSinh(ds);
		
		
	}
}
