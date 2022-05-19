package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Tinh implements Serializable{
	private int maTinh;
	private String tenTinh;
//	constructor
	public Tinh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}
//	getter & setter
	public int getMaTinh() {
		return maTinh;
	}
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}
	public String getTenTinh() {
		return tenTinh;
	}
	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
//	toString
	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}
//	equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}
//	dsTinh
	public static ArrayList<Tinh> getDSTinh(){
		String[] arr_tinh = {"An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Thành phố Hồ Chí Minh",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"};
		int i=0;
		ArrayList<Tinh> listTinh=new ArrayList<Tinh>();
		for (String tenTinh : arr_tinh) {
			Tinh t=new Tinh(i, tenTinh);
			listTinh.add(t);
			i++;
		}
		return listTinh;
	}
	public static Tinh getTinhById(int queQuan) {
				
		return Tinh.getDSTinh().get(queQuan);
	}
	public static Tinh getTinhByTen(String tenTinh) {
		ArrayList<Tinh> tinh=Tinh.getDSTinh();
		for (Tinh tinh2 : tinh) {
			if (tinh2.getTenTinh().equals(tenTinh)) {
				return tinh2;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getTinhById(0));
	}
	

}
