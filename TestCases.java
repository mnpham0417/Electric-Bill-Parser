import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCases {
	
    @Test
    public void true_electric_bill() {
    	Parser parser_BANKPLUS_1 = new Parser("Chi tiet hoa don thanh toan tien dien cua khach hang PC12AA0142754 la: Khong co thong tin.", "bankplus");
    	assertTrue(parser_BANKPLUS_1.isElectricText());
    }
    
    @Test
    public void false_electric_bill() {
    	Parser parser_BANKPLUS_1 = new Parser("Chi tiet hoa don thanh toan cua khach hang PC12AA0142754 la: Khong co thong tin.", "bankplus");
    	assertFalse(parser_BANKPLUS_1.isElectricText());
    }
	
	
    @Test
    public void test_BANKPLUS_1() {
    	Parser parser_BANKPLUS_1 = new Parser("Chi tiet hoa don thanh toan tien dien cua khach hang PC12AA0142754 la: Khong co thong tin.", "bankplus");
    	parser_BANKPLUS_1.clean_up();
    	parser_BANKPLUS_1.reduce_price_str();
    	assertEquals(parser_BANKPLUS_1.convert_int(),-1);
    }
    
    @Test
    public void test_BANKPLUS_2() {
    	Parser parser_BANKPLUS_2 = new Parser("Quy khach da tra tien thanh cong hoa don tien Dien 973.134 cho PK04000001555, Nguyen Ich Quoc. Phi tien ich 0. Ngay GD: 14/06/2018 13:40:48. Duong dan la", "bankplus");
    	parser_BANKPLUS_2.clean_up();
    	parser_BANKPLUS_2.reduce_price_str();
    	assertEquals(parser_BANKPLUS_2.convert_int(),973134);
    }
    
    @Test
    public void test_ECPAY_1() {
    	Parser parser_ECPAY_1 = new Parser("ECPay thong bao: Tien dien T6/2018 cua Ma KH PD03T103098, la 13.631VND. Truy cap www.ecpay.vn hoac lien he 1900561230 de biet them chi tiet.", "ecpay");
    	parser_ECPAY_1.clean_up();
    	parser_ECPAY_1.reduce_price_str();
    	assertEquals(parser_ECPAY_1.convert_int(),13631);
    }
    
    @Test
    public void test_ECPAY_2() {
    Parser parser_ECPAY_2 = new Parser("ECPay thong bao: Tien dien T6/2018 cua Ma KH PD0100T15946, la 2.069.470VND. Truy cap www.ecpay.vn hoac lien he 1900561230 de biet them chi tiet.", "ecpay");
    	parser_ECPAY_2.clean_up();
    	parser_ECPAY_2.reduce_price_str();
    	assertEquals(parser_ECPAY_2.convert_int(),2069470);
    }
    
    @Test
    public void test_TECHCOMBANK_1() {
    Parser parser_TECHCOMBANK_1 = new Parser("TK 19032158469014 So tien GD:+232,000 So du:10,686,180 E H.A va V.A gui tien dien nuoc.", "techcombank");
    	parser_TECHCOMBANK_1.clean_up();
    	parser_TECHCOMBANK_1.reduce_price_str();
    	assertEquals(parser_TECHCOMBANK_1.convert_int(),-1);
    }
    
    @Test
    public void test_TECHCOMBANK_2() {
    Parser parser_TECHCOMBANK_2 = new Parser("TK 19028741920029 So tien GD:-529,000 So du:6,061,339 Tien dien nuoc", "techcombank");
    	parser_TECHCOMBANK_2.clean_up();
    	parser_TECHCOMBANK_2.reduce_price_str();
    	assertEquals(parser_TECHCOMBANK_2.convert_int(),529000);
    }
    
    @Test
    public void test_VIETCOMBANK_1() {
    Parser parser_VIETCOMBANK_1 = new Parser("SD TK 0221000037210 +15,000,000VND luc 10-06-2018 21:02:43. SD 15,798,645VND. Ref 785181.100618.210323.Tien dien thang 6", "vietcombank");
    	parser_VIETCOMBANK_1.clean_up();
    	parser_VIETCOMBANK_1.reduce_price_str();
    	assertEquals(parser_VIETCOMBANK_1.convert_int(),-1);
    }
    
    @Test
    public void test_VIETCOMBANK_2() {
    Parser parser_VIETCOMBANK_2 = new Parser("SD TK 0081000199652 -41,959,390VND luc 13-06-2018 14:29:48. SD 5,584,787,627VND. Ref CT CP DT KT PVD TT TIEN DIEN KY1 T6.2018 MA KH PB 15010048640,150100576...", "vietcombank");
    	parser_VIETCOMBANK_2.clean_up();
    	parser_VIETCOMBANK_2.reduce_price_str();
    	assertEquals(parser_VIETCOMBANK_2.convert_int(),41959390);
    }
    
    @Test
    public void test_DLBINHXUYEN_1() {
    Parser parser_DLBINHXUYEN_1 = new Parser("Tien dien thang 06/2018 KH: BA050527 s.dung 184kWh chi so ck 10334 tong thanh toan 344874 Tra cuu HD tai https:sinvoice.viettel.vn/tra", "dlbinhxuyen");
    	parser_DLBINHXUYEN_1.clean_up();
    	parser_DLBINHXUYEN_1.reduce_price_str();
    	assertEquals(parser_DLBINHXUYEN_1.convert_int(),344874);
    }
    
    @Test
    public void test_DLBINHXUYEN_2() {
    Parser parser_DLBINHXUYEN_2 = new Parser("Tien dien thang 06/2018 KH: BA050429 s.dung 252kWh chi so ck 3558 tong thanh toan 511423 Tra cuu HD tai https:sinvoice.viettel.vn/trac", "dlbinhxuyen");
    	parser_DLBINHXUYEN_2.clean_up();
    	parser_DLBINHXUYEN_2.reduce_price_str();
    	assertEquals(parser_DLBINHXUYEN_2.convert_int(),511423);
    }
    
    @Test
    public void test_ACB_1() {
    Parser parser_ACB_2 = new Parser("ACB: TK 245115619(VND) + 3,000,000 luc 14:36 13/06/2018. So du 3,160,947.GD: DINH THI TRUC GIANG-TC:VNCN018071.TIEN TAM UNG CO2 VA THANH TOAN TIEN DIEN ", "ACB");
    	parser_ACB_2.clean_up();
    	parser_ACB_2.reduce_price_str();
    	assertEquals(parser_ACB_2.convert_int(),-1);
    }
    
    @Test
    public void test_ACB_2() {
    Parser parser_ACB_2 = new Parser("ACB: TK 193200579(VND) - 37,092,000 luc 14:58 04/06/2018. So du 23,446,625.GD: CK cho LE THI THAM, VCB HCM, IBTIEN HA 37,800 - 288 TIEN DIEN - 420 THUE = 37,092 ", "ACB");
    	parser_ACB_2.clean_up();
    	parser_ACB_2.reduce_price_str();
    	assertEquals(parser_ACB_2.convert_int(),37092000);
    }
    
    @Test
    public void test_EXIMBANK_1() {
    Parser parser_EXIMBANK_1 = new Parser("EIB PHAN XICH LONG TK 220614849144240 04/06/18 19:59 THANH TOAN TIEN DIEN - DIEN LUC HCM, MA KH  PE04000189422 544,885VND SD 15,043,195VND.", "EXIMBANK");
    	parser_EXIMBANK_1.clean_up();
    	parser_EXIMBANK_1.reduce_price_str();
    	assertEquals(parser_EXIMBANK_1.convert_int(),544885);
    }
    
    @Test
    public void test_EXIMBANK_2() {
    Parser parser_EXIMBANK_2 = new Parser("EIB QUAN 7 TK 140314949036609 08/06/18 12:38 THANH TOAN TIEN DIEN - DIEN LUC HCM, MA KH  PE05000104061 529,441VND SD 53,494,523VND", "EXIMBANK");
    	parser_EXIMBANK_2.clean_up();
    	parser_EXIMBANK_2.reduce_price_str();
    	assertEquals(parser_EXIMBANK_2.convert_int(),529441);
    }
    
    @Test
    public void test_PVCOMBANK_1() {
    Parser parser_PVCOMBANK_1 = new Parser("Quy khach da thanh toan thanh cong ma: PD16000000032, Dich vu: Tien dien (EVN), So tien: 998,774 VND. LH: 1900555592", "PVCOMBANK");
    	parser_PVCOMBANK_1.clean_up();
    	parser_PVCOMBANK_1.reduce_price_str();
    	assertEquals(parser_PVCOMBANK_1.convert_int(),998774);
    }
    
    @Test
    public void test_PVCOMBANK_2() {
    Parser parser_PVCOMBANK_2 = new Parser("TK: 102000162476(VND).- 1,160,313. SD: -93,785,984. Luc: 09:51 12/06/2018. ND: MA KH PD12000007410 DONG TIEN DIEN T5/2018 tu 09/0.... LH: 1900555592", "PVCOMBANK");
    	parser_PVCOMBANK_2.clean_up();
    	parser_PVCOMBANK_2.reduce_price_str();
    	assertEquals(parser_PVCOMBANK_2.convert_int(),1160313);
    }
    
    @Test
    public void test_VNEDU_1() {
    Parser parser_VNEDU_1 = new Parser("Truong mam non Bach Long thong bao: Cac d/c GV luu y tiet kiem khi su dung thiet bi dien cua nhom lop minh vi hoa don tien dien cua nh", "VNEDU");
    	parser_VNEDU_1.clean_up();
    	parser_VNEDU_1.reduce_price_str();
    	assertEquals(parser_VNEDU_1.convert_int(),-1);
    }
    
    @Test
    public void test_VNEDU_2() {
    Parser parser_VNEDU_2 = new Parser("tien nop on hai mon la 1 thang 300.000d, hoc 1 thang ruoi nop 450.000. Tien dien 45.000. Tien nuoc 45.000. Tieng Anh on thu ba, thu n", "VNEDU");
    	parser_VNEDU_2.clean_up();
    	parser_VNEDU_2.reduce_price_str();
    	assertEquals(parser_VNEDU_2.convert_int(),45000);
    }
    
    @Test
    public void test_LAZADA_VN_1() {
    Parser parser_LAZADA_VN_1 = new Parser("Thu tuc hoan tien cho don hang # 203191273712037 da hoan tat. Ma tien dien tu se duoc hoan lai trong vong 1 ngay lam viec. Vui long ki", "LAZADA.VN");
    	parser_LAZADA_VN_1.clean_up();
    	parser_LAZADA_VN_1.reduce_price_str();
    	assertEquals(parser_LAZADA_VN_1.convert_int(),-1);
    }
    
    @Test
    public void test_LAZADA_VN_2() {
    Parser parser_LAZADA_VN_2 = new Parser("Thu tuc hoan tien cho don hang # 202610612494042 da hoan tat. Ma tien dien tu se duoc hoan lai trong vong 1 ngay lam viec. Vui long ki", "LAZADA.VN");
    	parser_LAZADA_VN_2.clean_up();
    	parser_LAZADA_VN_2.reduce_price_str();
    	assertEquals(parser_LAZADA_VN_2.convert_int(),-1);
    }
    
    @Test
    public void test_HALONG_IES_1() {
    Parser parser_HALONG_IES_1 = new Parser("(Thong bao Lan 2) De dam bao cung cap dien lien tuc, Cty Ha Long IES de nghi Quy Khach hang thanh toan tien dien su dung tu 17/5/2018", "HALONG.IES");
    	parser_HALONG_IES_1.clean_up();
    	parser_HALONG_IES_1.reduce_price_str();
    	assertEquals(parser_HALONG_IES_1.convert_int(),-1);
    }
    
    @Test
    public void test_HALONG_IES_2() {
    Parser parser_HALONG_IES_2 = new Parser("(Thong bao Lan 2) De dam bao cung cap dien lien tuc, Cty Ha Long IES de nghi Quy Khach hang thanh toan tien dien su dung tu 17/5/2018", "HALONG.IES");
    	parser_HALONG_IES_2.clean_up();
    	parser_HALONG_IES_2.reduce_price_str();
    	assertEquals(parser_HALONG_IES_2.convert_int(),-1);
    }
    
    @Test
    public void test_IVB_1() {
    Parser parser_IVB_1 = new Parser("TK 3319689-002 tai IVB giam(-) 1,000 VND luc 12/06/18 13:25. SDC: 128,037,855 VND. ND: CT:CN CTY TNHH MTV DIEN LUC HP-DL AN DUONG:TIEN DIEN (KY 1 THANG", "IVB");
    	parser_IVB_1.clean_up();
    	parser_IVB_1.reduce_price_str();
    	assertEquals(parser_IVB_1.convert_int(),1000);
    }
    
    @Test
    public void test_IVB_2() {
    Parser parser_IVB_2 = new Parser("TK 3319689-002 tai IVB giam(-) 63,003,600 VND luc 12/06/18 13:25. SDC: 128,048,855 VND. ND: CT:CN CTY TNHH MTV DIEN LUC HP-DL AN DUONG:TIEN DIEN (KY 1", "IVB");
    	parser_IVB_2.clean_up();
    	parser_IVB_2.reduce_price_str();
    	assertEquals(parser_IVB_2.convert_int(),63003600);
    }
    
    @Test
    public void test_DL_KESACH_1() {
    Parser parser_DL_KESACH_1 = new Parser("cac diem thu tien dien (Buu dien, Ngan hang) gan nhat. Dien thoai lien he 19001006.", "DL.KESACH");
    	parser_DL_KESACH_1.clean_up();
    	parser_DL_KESACH_1.reduce_price_str();
    	assertEquals(parser_DL_KESACH_1.convert_int(),-1);
    }
    
    @Test
    public void test_DL_KESACH_2() {
    Parser parser_DL_KESACH_2 = new Parser("018 tai cac diem thu tien dien (Buu dien, Ngan hang) gan nhat. Dien thoai lien he 19001006.", "DL.KESACH");
    	parser_DL_KESACH_2.clean_up();
    	parser_DL_KESACH_2.reduce_price_str();
    	assertEquals(parser_DL_KESACH_2.convert_int(),-1);
    }
    
    @Test
    public void test_VRB_1() {
    Parser parser_VRB_1 = new Parser("TK 100210000007007-CT TNHH JINYANG MTS VINA -78,854,952 VND -ND: (IB)(CT 24203001-CN Bac Giang) JINYANG MTS VINA TIEN DIEN KY 2 THANG", "DL.KESACH");
    	parser_VRB_1.clean_up();
    	parser_VRB_1.reduce_price_str();
    	assertEquals(parser_VRB_1.convert_int(),78854952);
    }
    
    @Test
    public void test_VRB_2() {
    Parser parser_VRB_2 = new Parser("TK 250210000018827-NGUYEN VAN CHUC +1,100,000 VND -ND: (IB) CK cho Bao con lan 1 thang 6, co cho them 100k tien dien nop truoc cho truong-So du:3,063,873 VND", "DL.KESACH");
    	parser_VRB_2.clean_up();
    	parser_VRB_2.reduce_price_str();
    	assertEquals(parser_VRB_2.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_B_DUONG_1() {
    Parser parser_EVN_B_DUONG_1 = new Parser("TB tien dien ky *KY# ; thang 6/2018, ma KH:PB04060051703 DNTT:772.0kWh, tong tien:1 335 551.0D. Quy KH vui long thanh toan trong 5 ngay (LH: 19001006)", "EVN.B-DUONG");
    	parser_EVN_B_DUONG_1.clean_up();
    	parser_EVN_B_DUONG_1.reduce_price_str();
    	assertEquals(parser_EVN_B_DUONG_1.convert_int(),1335551);
    }
    
    @Test
    public void test_EVN_B_DUONG_2() {
    Parser parser_EVN_B_DUONG_2 = new Parser("TB tien dien ky *KY# ; thang 6/2018, ma KH:PB04060033913 DNTT:418.0kWh, tong tien:976 105.0D. Quy KH vui long thanh toan trong 5 ngay (LH: 19001006)", "EVN.B-DUONG");
    	parser_EVN_B_DUONG_2.clean_up();
    	parser_EVN_B_DUONG_2.reduce_price_str();
    	assertEquals(parser_EVN_B_DUONG_2.convert_int(),976105);
    }
    
    @Test
    public void test_EPC_LANGSON_1() {
    Parser parser_EPC_LANGSON_1 = new Parser("TB:Tien dien thang 6/2018;ma KH PA11CL0026025,ngay ghi cong to 17, su dung:111 kwh,tien dien:195677 VND; Lien he 19006769 Tran trong!", "PC_LANGSON");
    	parser_EPC_LANGSON_1.clean_up();
    	parser_EPC_LANGSON_1.reduce_price_str();
    	assertEquals(parser_EPC_LANGSON_1.convert_int(),195677);
    }
    
    @Test
    public void test_EPC_LANGSON_2() {
    Parser parser_EPC_LANGSON_2 = new Parser("Tinh den 24h ngay 20/06/2018,Quy KH co ma PA11CG0021082 chua thanh toan tien dien 183414d.De nghi thanh toan truoc ngay 23/06/2018. LH 19006769. Tran trong!", "PC_LANGSON");
    	parser_EPC_LANGSON_2.clean_up();
    	parser_EPC_LANGSON_2.reduce_price_str();
    	assertEquals(parser_EPC_LANGSON_2.convert_int(),183414);
    }
    
    @Test
    public void test_BIDV_1() {
    Parser parser_BIDV_1 = new Parser("TK62110000742405 tai BIDV -1,513,874VND vao 09:45 06/06/2018. So du:12,361,286VND. ND: PE13000170872_TT tien dien T618 NGUYEN THI MAN-PE13000170872-HD:387831567", "BIDV");
    	parser_BIDV_1.clean_up();
    	parser_BIDV_1.reduce_price_str();
    	assertEquals(parser_BIDV_1.convert_int(),1513874);
    }
    
    @Test
    public void test_BIDV_2() {
    Parser parser_BIDV_2 = new Parser("TK12410002328700 tai BIDV +25,000,000VND vao 09:42 11/06/2018. So du:25,101,507VND. ND: CK32310000164334 TAM UNG TIEN DIEN XUONG HD3 T5.18......................", "BIDV");
    	parser_BIDV_2.clean_up();
    	parser_BIDV_2.reduce_price_str();
    	assertEquals(parser_BIDV_2.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_TP_CTHO_1() {
    Parser parser_EVN_TP_CTHO_1 = new Parser("DL Ninh Kieu thong bao tien dien thang 6/2018- Nguyen Thi Hai,So 77, Thua 781 (cot) duong 2, TDC Thoi Nhut 2, An Khanh, Dien tieu thu:", "EVN.TP-CTHO");
    	parser_EVN_TP_CTHO_1.clean_up();
    	parser_EVN_TP_CTHO_1.reduce_price_str();
    	assertEquals(parser_EVN_TP_CTHO_1.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_TP_CTHO_2() {
    Parser parser_EVN_TP_CTHO_2 = new Parser("DL Ninh Kieu thong bao tien dien thang 6/2018- Dang Van Nam,27B2 TTTM Cai Khe, P. Cai Khe, Dien tieu thu: 638 kWh, Tong tien: 1 629 747, MKH: PB11010029295", "EVN.TP-CTHO");
    	parser_EVN_TP_CTHO_2.clean_up();
    	parser_EVN_TP_CTHO_2.reduce_price_str();
    	assertEquals(parser_EVN_TP_CTHO_2.convert_int(),1629747);
    }
    
    @Test
    public void test_EVN_TP_CTHO_3() {
    Parser parser_EVN_TP_CTHO_3 = new Parser("Tien Dien 6/2018 cua KH Tran Van Bao la 171 kWh, so tien: 318 305vnd. (MaKH: PB11050030806).  Dien luc Binh Thuy xin Thong bao.", "EVN.TP-CTHO");
    	parser_EVN_TP_CTHO_3.clean_up();
    	parser_EVN_TP_CTHO_3.reduce_price_str();
    	assertEquals(parser_EVN_TP_CTHO_3.convert_int(),318305);
    }
    
    @Test
    public void test_EVN_DONGNAI_1() {
    Parser parser_EVN_DONGNAI_1 = new Parser("KH PK02000125707 vui long thanh toan tien dien T6: 1,407,713d truoc 21/06/2018. Sau thoi gian tren, DL tam ngung cap dien. KH da thanh", "EVN.DONGNAI");
    	parser_EVN_DONGNAI_1.clean_up();
    	parser_EVN_DONGNAI_1.reduce_price_str();
    	assertEquals(parser_EVN_DONGNAI_1.convert_int(),1407713);
    }
    
    @Test
    public void test_EVN_DONGNAI_2() {
    Parser parser_EVN_DONGNAI_2 = new Parser("KH PK11000018261 vui long thanh toan tien dien T6: 265,166d truoc 27/06/2018. Sau thoi gian tren, DL tam ngung cap dien. KH da thanh t", "EVN.DONGNAI");
    	parser_EVN_DONGNAI_2.clean_up();
    	parser_EVN_DONGNAI_2.reduce_price_str();
    	assertEquals(parser_EVN_DONGNAI_2.convert_int(),265166);
    }
    
    @Test
    public void test_PC_CAOBANG_1() {
    Parser parser_PC_CAOBANG_1 = new Parser("Tinh den 24h ngay 18/06/2018,Quy KH co ma PA14BM0002369 chua thanh toan so tien dien 175239d.Xin vui long thanh toan truoc ngay 21/06/2018. LH:19006769.", "PC_CAOBANG");
    	parser_PC_CAOBANG_1.clean_up();
    	parser_PC_CAOBANG_1.reduce_price_str();
    	assertEquals(parser_PC_CAOBANG_1.convert_int(),175239);
    }
    
    @Test
    public void test_PC_CAOBANG_2() {
    Parser parser_PC_CAOBANG_2 = new Parser("Tinh den 24h ngay 22/06/2018,Quy KH co ma PA14TK0016783 chua thanh toan so tien dien 39190d.Xin vui long thanh toan truoc ngay 26/06/2018. LH:19006769.", "PC_CAOBANG");
    	parser_PC_CAOBANG_2.clean_up();
    	parser_PC_CAOBANG_2.reduce_price_str();
    	assertEquals(parser_PC_CAOBANG_2.convert_int(),39190);
    }
    
    @Test
    public void test_CTYCPDIENGL_1() {
    Parser parser_CTYCPDIENGL_1 = new Parser("CtyCPDienGL kinh thong bao: khach hang CP91/00007 thang 06/2018 su dung 0 kWh, tien dien 0 d. Thanh toan truoc 15/07.", "CTYCPDIENGL");
    	parser_CTYCPDIENGL_1.clean_up();
    	parser_CTYCPDIENGL_1.reduce_price_str();
    	assertEquals(parser_CTYCPDIENGL_1.convert_int(),-1);
    }
    
    @Test
    public void test_CTYCPDIENGL_2() {
    Parser parser_CTYCPDIENGL_2 = new Parser("CtyCPDienGL kinh thong bao: khach hang CP15/00403 thang 06/2018 su dung 383 kWh, tien dien 873.725 d. Thanh toan truoc 15/07.", "CTYCPDIENGL");
    	parser_CTYCPDIENGL_2.clean_up();
    	parser_CTYCPDIENGL_2.reduce_price_str();
    	assertEquals(parser_CTYCPDIENGL_2.convert_int(),873725);
    }
    
    @Test
    public void test_PC_Q_NINH_1() {
    Parser parser_PC_Q_NINH_1 = new Parser("DLTP Ha Long TB: Quy KH ma PA03HL0026261 co so tien dien 844960d, de nghi thanh toan truoc ngay 27/06/2018. Neu KH da thanh toan, vui long bo qua tin nay.", "PC_Q.NINH");
    	parser_PC_Q_NINH_1.clean_up();
    	parser_PC_Q_NINH_1.reduce_price_str();
    	assertEquals(parser_PC_Q_NINH_1.convert_int(),844960);
    }
    
    @Test
    public void test_PC_Q_NINH_2() {
    Parser parser_PC_Q_NINH_2 = new Parser("DL TP H Long thong bao tien dien thang 6 nam 2018 cua Quy KH PA03HL0026261 su dung 373 kWh, tong tien 844960 dong, chi so cuoi ky 2390.", "PC_Q.NINH");
    	parser_PC_Q_NINH_2.clean_up();
    	parser_PC_Q_NINH_2.reduce_price_str();
    	assertEquals(parser_PC_Q_NINH_2.convert_int(),844960);
    }
    
    @Test
    public void test_EVNCPC_1() {
    Parser parser_EVNCPC_1 = new Parser("DIEN LUC thong bao den KH:Vo Thi Lai-PC06SS0523156.STKHE9,tien dien T6/2018:Chiso_cuoi:BT: 18897; CD: 7259; TD: 10345,Dien tieu thu:2737kWh, Tong tien:4849207d", "EVNCPC");
    	parser_EVNCPC_1.clean_up();
    	parser_EVNCPC_1.reduce_price_str();
    	assertEquals(parser_EVNCPC_1.convert_int(),4849207);
    }
    
    @Test
    public void test_EVNCPC_2() {
    Parser parser_EVNCPC_1 = new Parser("PCDAKLAK thong bao KH PC12PP0805863 tien dien 6/2018: Chi so chot = 264, SL dien= 14kWh, so tien = 23855dong. So dt lien he 19001909. Tran trong!", "EVNCPC");
    	parser_EVNCPC_1.clean_up();
    	parser_EVNCPC_1.reduce_price_str();
    	assertEquals(parser_EVNCPC_1.convert_int(),23855);
    }
    
    @Test
    public void test_HTXHOANGXA_1() {
    Parser parser_HTXHOANGXA_1 = new Parser("HTXDVDN Hoang Xa thong bao:Tien dien tu 21/5/2018-21/6/2018 cua MKH 40310 het: 393 kwh, CSCT: 679,Ttien: 902489 vnd.Thoi han thanh toan tu 25-26/06/2018!TB", "HTXHOANGXA");
    	parser_HTXHOANGXA_1.clean_up();
    	parser_HTXHOANGXA_1.reduce_price_str();
    	assertEquals(parser_HTXHOANGXA_1.convert_int(),902489);
    }
    
    @Test
    public void test_HTXHOANGXA_2() {
    Parser parser_HTXHOANGXA_2 = new Parser("HTXDVDN Hoang Xa thong bao:Tien dien tu 21/5/2018-21/6/2018 cua MKH 40558 het: 115 kwh, CSCT: 12890,Ttien: 203852 vnd.Thoi han thanh toan tu 25-26/06/2018!TB", "HTXHOANGXA");
    	parser_HTXHOANGXA_2.clean_up();
    	parser_HTXHOANGXA_2.reduce_price_str();
    	assertEquals(parser_HTXHOANGXA_2.convert_int(),203852);
    }
    
    @Test
    public void test_VPBANK_1() {
    Parser parser_VPBANK_1 = new Parser("TK 73903173 tai VPB giam 1,116,781VND do Can 1906 101 dong tien dien thang 5 nam 2018. So du TK sau GD la 16,860,648VND", "VPBANK");
    	parser_VPBANK_1.clean_up();
    	parser_VPBANK_1.reduce_price_str();
    	assertEquals(parser_VPBANK_1.convert_int(),1116781);
    }
    
    @Test
    public void test_VPBANK_2() {
    Parser parser_VPBANK_2 = new Parser("TK 53825238 tai VPB tang 47,000,000VND do Tien dien thang 4 + 5 ( tung ). So du TK sau GD la 47,582,517VND", "VPBANK");
    	parser_VPBANK_2.clean_up();
    	parser_VPBANK_2.reduce_price_str();
    	assertEquals(parser_VPBANK_2.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_B_THUAN_1() {
    Parser parser_EVN_B_THUAN_1 = new Parser("TK 53825238 tai VPB tang 47,000,000VND do Tien dien thang 4 + 5 ( tung ). So du TK sau GD la 47,582,517VND", "EVN.B-THUAN");
    	parser_EVN_B_THUAN_1.clean_up();
    	parser_EVN_B_THUAN_1.reduce_price_str();
    	assertEquals(parser_EVN_B_THUAN_1.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_B_THUAN_2() {
    Parser parser_EVN_B_THUAN_2 = new Parser("Kinh de nghi Quy KH thanh toan tien dien thang 6/2018; DNTT : 7062 - 6623 =  439 Kwh; So tien : 1 038 498d ", "EVN.B-THUAN");
    	parser_EVN_B_THUAN_2.clean_up();
    	parser_EVN_B_THUAN_2.reduce_price_str();
    	assertEquals(parser_EVN_B_THUAN_2.convert_int(),1038498);
    }
    
    @Test
    public void test_PC_HAIPHONG_1() {
    Parser parser_EVN_B_THUAN_1 = new Parser("DLHB thong bao: Ke tu ky hoa don tien dien thang 6/2018, Quy KH thanh toan tien dien tai so 9 Tran Hung Dao (Ngan hang An Binh). Lien he SDT: 02252210318", "PC_HAIPHONG");
    	parser_EVN_B_THUAN_1.clean_up();
    	parser_EVN_B_THUAN_1.reduce_price_str();
    	assertEquals(parser_EVN_B_THUAN_1.convert_int(),-1);
    }
    
    @Test
    public void test_PC_HAIPHONG_2() {
    Parser parser_EVN_B_THUAN_2 = new Parser("DL Bach Long Vy kinh bao:Thang 6/2018 sl dien Quy KH (PH15000000226) su dung la 412 kWh.Tien dien la 958278 dong (gom VAT).Ngay GCS: 10", "PC_HAIPHONG");
    	parser_EVN_B_THUAN_2.clean_up();
    	parser_EVN_B_THUAN_2.reduce_price_str();
    	assertEquals(parser_EVN_B_THUAN_2.convert_int(),958278);
    }
    
    @Test
    public void test_HTXTHANHSON_1() {
    Parser parser_HTXTHANHSON_1 = new Parser("HTX DV Dien Thanh Son thong bao tien dien thang 6 cua Khach hang la 242,684 VND, nop tien vao sang ngay ", "HTXTHANHSON");
    	parser_HTXTHANHSON_1.clean_up();
    	parser_HTXTHANHSON_1.reduce_price_str();
    	assertEquals(parser_HTXTHANHSON_1.convert_int(),242684);
    }
    
    @Test
    public void test_SACOMBANK_1() {
    Parser parser_SACOMBANK_1 = new Parser("Sacombank 13/06/18 den ky t.toan tu dong 139,755d UTTT TIEN DIEN MAI THIEU cho HD Dien PC03DD0400354 Vui long k.tra TK040050094660 dam bao du so du", "SACOMBANK");
    	parser_SACOMBANK_1.clean_up();
    	parser_SACOMBANK_1.reduce_price_str();
    	assertEquals(parser_SACOMBANK_1.convert_int(),139755);
    }
    
    @Test
    public void test_DLTRUNGKIEN_1() {
    Parser parser_DLTRUNGKIEN_1 = new Parser("HTXDV dien Trung Kien thong bao tien dien thang 06/2018 cua quy khach la 405,889 de nghi nop vao ngay 21-22/06/2018.", "SACOMBANK");
    	parser_DLTRUNGKIEN_1.clean_up();
    	parser_DLTRUNGKIEN_1.reduce_price_str();
    	assertEquals(parser_DLTRUNGKIEN_1.convert_int(),405889);
    }
    
    @Test
    public void test_CTCPD_MODUC_1() {
    Parser parser_CTCPD_MODUC_1 = new Parser("Tien dien T5: 160T065L1-175_AU TUAN LIEN, CSM: 2611, SLD: 105, so tien: 183414, tai NVHCD PHU AN vao ", "CTCPD-MODUC");
    	parser_CTCPD_MODUC_1.clean_up();
    	parser_CTCPD_MODUC_1.reduce_price_str();
    	assertEquals(parser_CTCPD_MODUC_1.convert_int(),183414);
    }
    
    @Test
    public void test_HTXDIENVUDI_1() {
    Parser parser_CTCPD_MODUC_1 = new Parser("Tien dien thang 6/2018 KH: T04-L01-00043 su dung 86kWh chi so cuoi 11678 tong thanh toan 148.555 khach hang thanh toan truoc ngay 28/6 tai diem thu", "HTXDIENVUDI");
    	parser_CTCPD_MODUC_1.clean_up();
    	parser_CTCPD_MODUC_1.reduce_price_str();
    	assertEquals(parser_CTCPD_MODUC_1.convert_int(),148555);
    }
    
    @Test
    public void test_EVN_N_THUAN_1() {
    Parser parser_EVN_N_THUAN_1 = new Parser("Thong bao tien dien ky 1 thang 6/2018 cua quy khach:Tran Van Ba-PB18020019461, dien tieu thu 153kWh, So tien 281 516VND (co VAT)", "EVN.N-THUAN");
    	parser_EVN_N_THUAN_1.clean_up();
    	parser_EVN_N_THUAN_1.reduce_price_str();
    	assertEquals(parser_EVN_N_THUAN_1.convert_int(),281516);
    }
    
    @Test
    public void test_EVN_N_THUAN_2() {
    Parser parser_EVN_N_THUAN_2 = new Parser("Thong bao tien dien ky 1 - 6/2018 cua quy khach:Nguyen Tuan Kiet-PB18030015492, dien TT 165kWh, So tien 284 790VND (co VAT).", "EVN.N-THUAN");
    	parser_EVN_N_THUAN_2.clean_up();
    	parser_EVN_N_THUAN_2.reduce_price_str();
    	assertEquals(parser_EVN_N_THUAN_2.convert_int(),284790);
    }
    
    @Test
    public void test_DONGABANK_1() {
    Parser parser_DONGABANK_1 = new Parser("11/06/18 14:38 DongA Bank thong bao: TK 0107749887 da thay doi: +194,500 VND. Bao co chuyen tien dien tu: GHTK.,JSC. So du hien tai la: 196,338 VND.", "DONGA BANK");
    	parser_DONGABANK_1.clean_up();
    	parser_DONGABANK_1.reduce_price_str();
    	assertEquals(parser_DONGABANK_1.convert_int(),194500);
    }
    
    @Test
    public void test_EVN_BR_VTAU_1() {
    Parser parser_EVN_BR_VTAU_1 = new Parser("Dien Luc TB den kh Nguyen Thanh Hai, MKH: PB15050016490 tien dien T6/2018 la 332611 VND. De nghi kh thanh toan  truoc ngay 28/06/2018. Tran trong!", "EVN.BR-VTAU");
    	parser_EVN_BR_VTAU_1.clean_up();
    	parser_EVN_BR_VTAU_1.reduce_price_str();
    	assertEquals(parser_EVN_BR_VTAU_1.convert_int(),332611);
    }
    
    @Test
    public void test_EVN_K_GIANG_1() {
    Parser parser_EVN_K_GIANG_1 = new Parser("Dien Luc TB den kh Nguyen Thanh Hai, MKH: PB15050016490 tien dien T6/2018 la 332611 VND. De nghi kh thanh toan  truoc ngay 28/06/2018. Tran trong!", "EVN.K-GIANG");
    	parser_EVN_K_GIANG_1.clean_up();
    	parser_EVN_K_GIANG_1.reduce_price_str();
    	assertEquals(parser_EVN_K_GIANG_1.convert_int(),332611);
    }
    
    @Test
    public void test_PC_T_QUANG_1() {
    Parser parser_EVN_K_GIANG_1 = new Parser("DLYS xin TB dien tieu thu KH:PA12YS0072964. Thang 6/2018 la: 98 kWh.So tien:169675 VND. Ngay thu tien dien khong thay doi. LH 19006769", "PC_T.Quang");
    	parser_EVN_K_GIANG_1.clean_up();
    	parser_EVN_K_GIANG_1.reduce_price_str();
    	assertEquals(parser_EVN_K_GIANG_1.convert_int(),169675);
    }
    
    @Test
    public void test_PCKHANHHOA_1() {
    Parser parser_PCKHANHHOA_1 = new Parser("Dien luc t/bao: QK co ma PQ03000306616 con no tien dien 318305d. Dien luc se tam ngung cung cap dien sau ngay 30/06/2018 neu k/hang chua thanh toan.", "PCKHANHHOA");
    	parser_PCKHANHHOA_1.clean_up();
    	parser_PCKHANHHOA_1.reduce_price_str();
    	assertEquals(parser_PCKHANHHOA_1.convert_int(),318305);
    }
    
    @Test
    public void test_PCKHANHHOA_2() {
    Parser parser_PCKHANHHOA_2 = new Parser("Quy k/hang co ma PQ11000294645 chua thanh toan tien dien 193633d. Dien luc se tam ngung cung cap dien sau 24h ke tu thoi diem nay. Chi tiet lien he 19001909.", "PCKHANHHOA");
    	parser_PCKHANHHOA_2.clean_up();
    	parser_PCKHANHHOA_2.reduce_price_str();
    	assertEquals(parser_PCKHANHHOA_2.convert_int(),193633);
    }
    
    @Test
    public void test_PCDANANG_1() {
    Parser parser_PCDANANG_1 = new Parser("PC Da Nang: Khach hang co ma PP09000817284 con no tien dien thang 6/2018-1 la 1004828 d. Xin vui long thanh toan truoc ngay 21/06/2018!", "PCDANANG");
    	parser_PCDANANG_1.clean_up();
    	parser_PCDANANG_1.reduce_price_str();
    	assertEquals(parser_PCDANANG_1.convert_int(),1004828);
    }
    
    @Test
    public void test_EVN_TAYNINH_1() {
    Parser parser_EVN_TAYNINH_1 = new Parser("DL Ben Cau thong bao tien dien cua Kh Nguyen Van Khoi; hoa don ky 1 ; thang 6/2018 ; ma KH PB05090029297 ;dien tieu thu 15KWH ;so tien 25 559VND", "EVN.TAYNINH");
    	parser_EVN_TAYNINH_1.clean_up();
    	parser_EVN_TAYNINH_1.reduce_price_str();
    	assertEquals(parser_EVN_TAYNINH_1.convert_int(),25559);
    }
    
    @Test
    public void test_DIENNTEAPHE_1() {
    Parser parser_DIENNTEAPHE_1 = new Parser("HTX DIEN EAPHE thong bao KH190302 tien dien tu 01/05/18 den 31/05/18 c.ky1165 - d.ky1119 + tr.thu0 = 46kwh = 78379d KH thanh toan truoc ngay 25/06/18", "DIENNTEAPHE");
    	parser_DIENNTEAPHE_1.clean_up();
    	parser_DIENNTEAPHE_1.reduce_price_str();
    	assertEquals(parser_DIENNTEAPHE_1.convert_int(),78379);
    }
    
    @Test
    public void test_MBBANK_1() {
    Parser parser_MBBANK_1 = new Parser("TK 8020xxxx2004|GD: -846,593VND 14/06/18 03:35|SD:4,271,781VND|ND: PQ09000806944- DINH THI THANH THAO TT TIEN DIEN CHO HOA DON SO 3924401 5", "MBBANK");
    	parser_MBBANK_1.clean_up();
    	parser_MBBANK_1.reduce_price_str();
    	assertEquals(parser_MBBANK_1.convert_int(),846593);
    }
    
    @Test
    public void test_MBBANK_2() {
    Parser parser_MBBANK_2 = new Parser("TK 3540xxxx1008|GD: +1,625,000VND 14/06/18 15:31|SD:10,947,132VND|ND: E nop tien dien Tu: NGUYEN THI THU HANG", "MBBANK");
    	parser_MBBANK_2.clean_up();
    	parser_MBBANK_2.reduce_price_str();
    	assertEquals(parser_MBBANK_2.convert_int(),-1);
    }
    
    @Test
    public void test_VIB_1() {
    Parser parser_VIB_1 = new Parser("16:54;11/06/2018 TK:041704060058013VND PS:-155,595 ND:PD1300T281181 Pham Hoang An thanh toan tien dien thang: 6/2018 SODU:+1,524,080", "VIB");
    	parser_VIB_1.clean_up();
    	parser_VIB_1.reduce_price_str();
    	assertEquals(parser_VIB_1.convert_int(),155595);
    }
    
    @Test
    public void test_VIB_2() {
    Parser parser_VIB_2 = new Parser("15:11;12/06/2018 TK:036704062228888VND PS:+331,537,000 ND:LA THI KIM TUYEN NOP TIEN DIEN THANG 6/2018 SODU:+427,542,378", "VIB");
    	parser_VIB_2.clean_up();
    	parser_VIB_2.reduce_price_str();
    	assertEquals(parser_VIB_2.convert_int(),-1);
    }
    
    @Test
    public void test_DLVINHTHINH_1() {
    Parser parser_DLVINHTHINH_1 = new Parser("HTXDV dien Vinh Thinh thong bao tien dien Thang 06 cua quy khach la 257651 dong = 149KW. De nghi quy khach nop vao Ngay 23-25/06/2018", "DLVINHTHINH");
    	parser_DLVINHTHINH_1.clean_up();
    	parser_DLVINHTHINH_1.reduce_price_str();
    	assertEquals(parser_DLVINHTHINH_1.convert_int(),257651);
    }
    
    @Test
    public void test_HTX_DIEN_HL_1() {
    Parser parser_HTX_DIEN_HL_1 = new Parser("HTXDV dien Vinh Thinh thong bao tien dien Thang 06 cua quy khach la 257651 dong = 149KW. De nghi quy khach nop vao Ngay 23-25/06/2018", "HTX.DIEN.HL");
    	parser_HTX_DIEN_HL_1.clean_up();
    	parser_HTX_DIEN_HL_1.reduce_price_str();
    	assertEquals(parser_HTX_DIEN_HL_1.convert_int(),257651);
    }
    
    @Test
    public void test_HTX_YEN_SO_1() {
    Parser parser_HTX_YEN_SO_1 = new Parser("HTX TB: Tu 21/4 den 20/5/2018 K.H TR01137 su dung 260kWh, chi so cuoi ky 6.888, so tien thanh toan 532.015 d. Thang 5 thu tien dien bang giay bien nhan", "HTX YEN SO");
    	parser_HTX_YEN_SO_1.clean_up();
    	parser_HTX_YEN_SO_1.reduce_price_str();
    	assertEquals(parser_HTX_YEN_SO_1.convert_int(),532015);
    }
    
    @Test
    public void test_PC_HAGIANG_1() {
    Parser parser_HTX_YEN_SO_1 = new Parser("Tinh den ngay 26/06/2018, KH co ma PA20QI0009123 chua thanh toan so tien dien 44301d. De nghi thanh toan truoc ngay 30/6/2018. Bo qua neu da thanh toan!", "PC_HaGiang");
    	parser_HTX_YEN_SO_1.clean_up();
    	parser_HTX_YEN_SO_1.reduce_price_str();
    	assertEquals(parser_HTX_YEN_SO_1.convert_int(),44301);
    }
    
    @Test
    public void test_VIETINBANK_1() {
    Parser parser_VIETINBANK_1 = new Parser("VietinBank:11/06/2018 00:59|TK:103867259242|GD:-1,200,000VND|SDC:5,334,409VND|ND:So GD: 940A1860FAZW28LK dong tien dien nuoc; tai iPay", "VietinBank");
    	parser_VIETINBANK_1.clean_up();
    	parser_VIETINBANK_1.reduce_price_str();
    	assertEquals(parser_VIETINBANK_1.convert_int(),1200000);
    }
    
    @Test
    public void test_VIETINBANK_2() {
    Parser parser_HTX_YEN_SO_1 = new Parser("VietinBank:05/06/2018 09:27|TK:106003271453|GD:+314,000VND|SDC:451,764VND|ND:So GD goc: 10002973 THANH TOAN TIEN DIEN BDH VIETLOTT THANG 05/2018 TAI 29C B~", "VietinBank");
    	parser_HTX_YEN_SO_1.clean_up();
    	parser_HTX_YEN_SO_1.reduce_price_str();
    	assertEquals(parser_HTX_YEN_SO_1.convert_int(),-1);
    }
    
    @Test
    public void test_AGRIBANK_1() {
    Parser parser_AGRIBANK_1 = new Parser("Agribank: 11h28p 11/06 TK 5003205178742: -93,995VND (BPMENT: FT Trace[210294]-[5003CPRNGHIEP PHAM QUYET TAMTo dan pho 5TT tien dien T5/18(...). SD: 203,719VND.", "AGRIBANK");
    	parser_AGRIBANK_1.clean_up();
    	parser_AGRIBANK_1.reduce_price_str();
    	assertEquals(parser_AGRIBANK_1.convert_int(),93995);
    }
    
    @Test
    public void test_HTX_DV_DNQT_1() {
    Parser parser_AGRIBANK_1 = new Parser("HTX.DV dien nang Quyet Thang thong bao tien dien thang 6/2018 cua ma KH TT-54 la 218 KW/h tong tien la 423907 VND (ngay nop tien 24,25). Tran trong.", "HTX.DV.DNQT");
    	parser_AGRIBANK_1.clean_up();
    	parser_AGRIBANK_1.reduce_price_str();
    	assertEquals(parser_AGRIBANK_1.convert_int(),423907);
    }
    
    @Test
    public void test_OCB_1() {
    Parser parser_OCB_1 = new Parser("OCB 11/06 09:03 TK 0068100000815007 (+) 1,200,000 VND N/dung: DANG NHAT TRINHdong tien dien nuoc So du: 1,264,907 VND", "OCB");
    	parser_OCB_1.clean_up();
    	parser_OCB_1.reduce_price_str();
    	assertEquals(parser_OCB_1.convert_int(),-1);
    }
    
    @Test
    public void test_HTXDIENTK_1() {
    Parser parser_HTXDIENTK_1 = new Parser("Tien dien SH thang 06 cua khach hang 522 Noi -TBA so 2 la: 289.691", "HTXDIENTK");
    	parser_HTXDIENTK_1.clean_up();
    	parser_HTXDIENTK_1.reduce_price_str();
    	assertEquals(parser_HTXDIENTK_1.convert_int(),289691);
    }
    
    @Test
    public void test_VIETBANK_1() {
    Parser parser_VIETBANK_1 = new Parser("TK VND 83637 -100,000 LUC 14:35 04/06/2018. SO DU: 1,060,315. ND: \\CAO TIEN DIEN NAP 0901798897: MP0017959185", "VIETBANK");
    	parser_VIETBANK_1.clean_up();
    	parser_VIETBANK_1.reduce_price_str();
    	assertEquals(parser_VIETBANK_1.convert_int(),100000);
    }
    
    @Test
    public void test_MSB_1() {
    Parser parser_MSB_1 = new Parser("13/06 13:59 TK 040xx4593 VND (-) 1.911.000 (GD:1.900.000,Thue/Phi: 11.000) ND: -801192-CK 24/7 cho 0491000075970. Tien dien thang 6, 7 SD: 132.827", "MSB");
    	parser_MSB_1.clean_up();
    	parser_MSB_1.reduce_price_str();
    	assertEquals(parser_MSB_1.convert_int(),1911000);
    }
    
    @Test
    public void test_DIENTUTRUNG_1() {
    Parser parser_DIENTUTRUNG_1 = new Parser("Hop Tac Xa Dich Vu Dien Tu Trung thong bao tien dien thang thang 06 cua quy khach la 56229 dong = 33 KW. De nghi nop vao ngay 23 den 2", "DIENTUTRUNG");
    	parser_DIENTUTRUNG_1.clean_up();
    	parser_DIENTUTRUNG_1.reduce_price_str();
    	assertEquals(parser_DIENTUTRUNG_1.convert_int(),56229);
    }
    
    @Test
    public void test_HTX_PHUXUAN_1() {
    Parser parser_HTX_PHUXUAN_1 = new Parser("HTien dien thang 6/2018 KH: DC_137 s.dung 84kWh chi so ck 179 tong thanh toan 145.035 Tra cuu HD tai hddt.dienlucbinhxuyen.com thanh toan truoc ngay 25/6", "HTX_PHUXUAN");
    	parser_HTX_PHUXUAN_1.clean_up();
    	parser_HTX_PHUXUAN_1.reduce_price_str();
    	assertEquals(parser_HTX_PHUXUAN_1.convert_int(),145035);
    }
    
    @Test
    public void test_HTX_T_KHUC_1() {
    Parser parser_HTX_T_KHUC_1 = new Parser("HTX Trieu Khuc TB: Tien dien T5/2018 KH ma D0870, SD 461 kWh, so chot 2006, so tien 912.164 d. Thoi han thanh toan truoc ngay 24/06/18. Xin cam on!", "HTX-T.KHUC");
    	parser_HTX_T_KHUC_1.clean_up();
    	parser_HTX_T_KHUC_1.reduce_price_str();
    	assertEquals(parser_HTX_T_KHUC_1.convert_int(),912164);
    }
    
    @Test
    public void test_PUBLICBANK_1() {
    Parser parser_PUBLICBANK_1 = new Parser("TK0603000001349 duoc ghi no -29 300 150 So du hien thoi: 1 014 058 947 (GD:060000084 12/06/2018 PB04030033840 thanh toan tien dien ky 1 T06/2018: 06/05 ...", "PublicBank");
    	parser_PUBLICBANK_1.clean_up();
    	parser_PUBLICBANK_1.reduce_price_str();
    	assertEquals(parser_PUBLICBANK_1.convert_int(),29300150);
    }
    
    @Test
    public void test_DL_TANPHONG_1() {
    Parser parser_DL_TANPHONG_1 = new Parser("TB: Tien dien T6 cua quy khach la:203.852d;CSM:2818;CSC:2703;su dung:115kWh.Nop tu ngay 24/6 den 25/6 tai NVH", "DL_TANPHONG");
    	parser_DL_TANPHONG_1.clean_up();
    	parser_DL_TANPHONG_1.reduce_price_str();
    	assertEquals(parser_DL_TANPHONG_1.convert_int(),203852);
    }
    
    @Test
    public void test_DIENTUANTHU_1() {
    Parser parser_DIENTUANTHU_1 = new Parser("THONG BAO: Tien dien cua khach hang Nguyen Van Thang. thang 06/2018 la 285604VND tuong ung la 155kw, de nghi thanh toan truoc 25/06/2018", "DienTuanThu");
    	parser_DIENTUANTHU_1.clean_up();
    	parser_DIENTUANTHU_1.reduce_price_str();
    	assertEquals(parser_DIENTUANTHU_1.convert_int(),285604);
    }
    
    @Test
    public void test_PC_HAIDUONG_1() {
    Parser parser_PC_HAIDUONG_1 = new Parser("Phieu:2552679. KH:Nguyen Xuan Cuong. DC: 297 Le Thanh Nghi - Hai Duong, SDT:0908010272. Kien nghi kiem tra Hoa don tien dien may thang", "PC_HaiDuong");
    	parser_PC_HAIDUONG_1.clean_up();
    	parser_PC_HAIDUONG_1.reduce_price_str();
    	assertEquals(parser_PC_HAIDUONG_1.convert_int(),-1);
    }
    
    @Test
    public void test_PC_HAIDUONG_2() {
    Parser parser_PC_HAIDUONG_2 = new Parser("Tinh den het ngay 21/06/2018, Quy KH co ma PM13000366462 chua thanh toan so tien dien 2319042 d. Xin vui long thanh toan truoc ngay 26/06/2018.LH 19006769", "PC_HaiDuong");
    	parser_PC_HAIDUONG_2.clean_up();
    	parser_PC_HAIDUONG_2.reduce_price_str();
    	assertEquals(parser_PC_HAIDUONG_2.convert_int(),2319042);
    }
    
    @Test
    public void test_SCB_1() {
    Parser parser_SCB_1 = new Parser("TK 2020107745830001 NGAY 04/06/18 11:10 SD DAU 4,156,080 TANG 3,068,000 SD CUOI 7,224,080 VND (LE NHU QUYNH CT,E QUYNH CK TIEN NHA T6 TIEN DIEN NCTHANG 5)", "SCB");
    	parser_SCB_1.clean_up();
    	parser_SCB_1.reduce_price_str();
    	assertEquals(parser_SCB_1.convert_int(),-1);
    }
    
    @Test
    public void test_SCB_2() {
    Parser parser_SCB_2 = new Parser("TK 0920104386500006 NGAY 10/06/18 20:48 SD DAU 2,437,663 GIAM 1,269,802 SD CUOI 1,167,861 VND (PH 01000016649 NOP TIEN DIEN THANG 6/2018)", "SCB");
    	parser_SCB_2.clean_up();
    	parser_SCB_2.reduce_price_str();
    	assertEquals(parser_SCB_2.convert_int(),1269802);
    }
    
    @Test
    public void test_VIETTELPAY_1() {
    Parser parser_VIETTELPAY_1 = new Parser("Chi tiet hoa don thanh toan tien dien cua khach hang PD28007308091 la: 6/2018: 1118786002 267.210VND", "VIETTELPAY");
    	parser_VIETTELPAY_1.clean_up();
    	parser_VIETTELPAY_1.reduce_price_str();
    	assertEquals(parser_VIETTELPAY_1.convert_int(),267210);
    }
    
    @Test
    public void test_VIETTELPAY_2() {
    Parser parser_VIETTELPAY_2 = new Parser("Quy khach da thanh toan thanh cong hoa don tien Dien 51.117 cho khach hang Ca Van Thien, ma khach hang PA15TC0010162. Phi GD 0. Ngay GD: 11/06/2018 14:46:57.", "VIETTELPAY");
    	parser_VIETTELPAY_2.clean_up();
    	parser_VIETTELPAY_2.reduce_price_str();
    	assertEquals(parser_VIETTELPAY_2.convert_int(),51117);
    }
    
    @Test
    public void test_ABBANK_1() {
    Parser parser_ABBANK_1 = new Parser("Tien dien ky 06 thang 06/18 la 153,835 VND.TK 1351007105096 khong du so du de thanh toan. QK vui long nop them tien de duoc thanh toan dung han.", "ABBANK");
    	parser_ABBANK_1.clean_up();
    	parser_ABBANK_1.reduce_price_str();
    	assertEquals(parser_ABBANK_1.convert_int(),153835);
    }
    
    @Test
    public void test_ABBANK_2() {
    Parser parser_ABBANK_2 = new Parser("TK 0741004011007 thay doi: -348,962 VND so GD: FT18164003000069-thanh toan tien dien PC10NN0517488 (thang )  kwh. So du tinh den 20:11", "ABBANK");
    	parser_ABBANK_2.clean_up();
    	parser_ABBANK_2.reduce_price_str();
    	assertEquals(parser_ABBANK_2.convert_int(),348962);
    }
    
    @Test
    public void test_EVN_CAMAU_1() {
    Parser parser_EVN_CAMAU_1 = new Parser("DLTp Ca Mau TB den quy KH Tran Thi Cam,Ma KH PB14010054453,tien dien thang 5/2018 la: 856 466 d. De nghi KH t/ toan tai cac ng/hang ga", "EVN.CAMAU");
    	parser_EVN_CAMAU_1.clean_up();
    	parser_EVN_CAMAU_1.reduce_price_str();
    	assertEquals(parser_EVN_CAMAU_1.convert_int(),856466);
    }
    
    @Test
    public void test_PC_LAOCAI_1() {
    Parser parser_PC_LAOCAI_1 = new Parser("Tinh den ngay 25/06/2018,KH PA18SI0000556 con no tien dien 6/2018:1050382 d.Vui long TT truoc ngay 28/06/2018.Bo qua tin nhan neu KH da TT", "PC_LaoCai");
    	parser_PC_LAOCAI_1.clean_up();
    	parser_PC_LAOCAI_1.reduce_price_str();
    	assertEquals(parser_PC_LAOCAI_1.convert_int(),1050382);
    }
    
    @Test
    public void test_HTXVANBINH_1() {
    Parser parser_HTXVANBINH_1 = new Parser("BQLD Van Binh thong bao tien dien sinh hoat T6/2018 cua khach hang VB3185: Chi so moi: 27415. San luong: 404kWh. So tien phai thanh toan: 935000VND.", "HTXVANBINH");
    	parser_HTXVANBINH_1.clean_up();
    	parser_HTXVANBINH_1.reduce_price_str();
    	assertEquals(parser_HTXVANBINH_1.convert_int(),935000);
    }
    
    @Test
    public void test_NH_QUOC_DAN_1() {
    Parser parser_NH_QUOC_DAN_1 = new Parser("NCB : 13/06/2018 16:34 TK 100003077688. Phat sinh: +3,352,988VND. So du: +6,289,849,118VND. ND: CT TNHH PHAM VAN H.D | TC:DNTD045538.Thanh toan tien dien thang.", "NH QUOC DAN");
    	parser_NH_QUOC_DAN_1.clean_up();
    	parser_NH_QUOC_DAN_1.reduce_price_str();
    	assertEquals(parser_NH_QUOC_DAN_1.convert_int(),-1);
    }
    
    @Test
    public void test_NH_QUOC_DAN_2() {
    Parser parser_NH_QUOC_DAN_2 = new Parser("NCB : 01/06/2018 12:10 TK 100001168918. Phat sinh: -25,000,000VND. So du: +65,003,911VND. ND: tien dien va tien da -TRAN ANH TOAN-100001176654.", "NH QUOC DAN");
    	parser_NH_QUOC_DAN_2.clean_up();
    	parser_NH_QUOC_DAN_2.reduce_price_str();
    	assertEquals(parser_NH_QUOC_DAN_2.convert_int(),25000000);
    }
    
    @Test
    public void test_HTXDIEN_DT_1() {
    Parser parser_NH_QUOC_DAN_1 = new Parser("Tien dien T5 cua KH Ngo Van Quang so dien 18233so tien343000 nop ngay 10/6 tai nha ong Canh Luc so nha 198 duong Pham V.an Dong TDP Dong Tam", "HTXDien_DT");
    	parser_NH_QUOC_DAN_1.clean_up();
    	parser_NH_QUOC_DAN_1.reduce_price_str();
    	assertEquals(parser_NH_QUOC_DAN_1.convert_int(),343000);
    }
    
    @Test
    public void test_VOFFICE_1() {
    Parser parser_VOFFICE_1 = new Parser("D/c Phan Thi Nga VUA CHUYEN cho dong chi van ban: 2634/BC-VPC- TC_PTC: Trinh ky Bao cao Thanh toan tien dien tram BTS thang 5/2018", "VOFFICE");
    	parser_VOFFICE_1.clean_up();
    	parser_VOFFICE_1.reduce_price_str();
    	assertEquals(parser_VOFFICE_1.convert_int(),-1);
    }
    
    @Test
    public void test_HTXHOPTHINH_1() {
    Parser parser_HTXHOPTHINH_1 = new Parser("D/c Phan Thi Nga VUA CHUYEN cho dong chi van ban: 2634/BC-VPC- TC_PTC: Trinh ky Bao cao Thanh toan tien dien tram BTS thang 5/2018", "HTXHOPTHINH");
    	parser_HTXHOPTHINH_1.clean_up();
    	parser_HTXHOPTHINH_1.reduce_price_str();
    	assertEquals(parser_HTXHOPTHINH_1.convert_int(),-1);
    }
    
    @Test
    public void test_HTX_TRUNGMY_1() {
    Parser parser_HTX_TRUNGMY_1 = new Parser("HTX dien trung my thong bao tien dien thang 6/2018 cua quy khach la 452.221 Moi quy khach den dia diem quy dinh de thanh toan vao ngay 23. Tran trong", "HTX_TRUNGMY");
    	parser_HTX_TRUNGMY_1.clean_up();
    	parser_HTX_TRUNGMY_1.reduce_price_str();
    	assertEquals(parser_HTX_TRUNGMY_1.convert_int(),452221);
    }
    
    @Test
    public void test_CTY_DIEN_LC_1() {
    Parser parser_CTY_DIEN_LC_1 = new Parser("Tien dien thang 6/2018 kh:LC-LC-00157 su dung 397kwh chi so cuoi4320 Tong thanh toan 913.996 Quy khach thanh toan truoc ngay 27/6", "CTY DIEN LC");
    	parser_CTY_DIEN_LC_1.clean_up();
    	parser_CTY_DIEN_LC_1.reduce_price_str();
    	assertEquals(parser_CTY_DIEN_LC_1.convert_int(),913996);
    }
    
    @Test
    public void test_DN_VINHNINH_1() {
    Parser parser_DN_VINHNINH_1 = new Parser("Tien dien T06.2018, KH: T02-L01-00036 su dung: 118 kWh, chi so cuoi 4160, tong thanh toan: 209983, KH thanh toan trong ngay 26/06 tai diem thu", "DN_VINHNINH");
    	parser_DN_VINHNINH_1.clean_up();
    	parser_DN_VINHNINH_1.reduce_price_str();
    	assertEquals(parser_DN_VINHNINH_1.convert_int(),209983);
    }
    
    @Test
    public void test_CTY_DNLM_HP_1() {
    Parser parser_CTY_DNLM_HP_1 = new Parser("TThong bao: Tien dien thang 6/2018 cua khach hang DNC07424866 la:  263122vnd/144kw. Tran trong!", "Cty_DNLM_HP");
    	parser_CTY_DNLM_HP_1.clean_up();
    	parser_CTY_DNLM_HP_1.reduce_price_str();
    	assertEquals(parser_CTY_DNLM_HP_1.convert_int(),263122);
    }
    
    @Test
    public void test_CTY_DNLM_HP_2() {
    Parser parser_CTY_DNLM_HP_2 = new Parser("DNC TB: Tien dien 6/2018 cua KH DNC03160886 tai SHP Plaza - 12 Lach Tray la: 1288070vnd/523kw. Thu tien tu 21/6-27/6 tai Ban QL (Tang 8). LH: 0906126222.", "Cty_DNLM_HP");
    	parser_CTY_DNLM_HP_2.clean_up();
    	parser_CTY_DNLM_HP_2.reduce_price_str();
    	assertEquals(parser_CTY_DNLM_HP_2.convert_int(),1288070);
    }
    
    @Test
    public void test_CTY_DNLM_HP_3() {
    Parser parser_CTY_DNLM_HP_3 = new Parser("TB: Tien dien thang 5/2018 cua khach hang DNC03160883 tai SHP Plaza - 12 Lach Tray la: 42598vnd/25kw. De nghi KH nop tien tai Ban QL (Tang 8)", "Cty_DNLM_HP");
    	parser_CTY_DNLM_HP_3.clean_up();
    	parser_CTY_DNLM_HP_3.reduce_price_str();
    	assertEquals(parser_CTY_DNLM_HP_3.convert_int(),42598);
    }
    
    @Test
    public void test_EVN_BENTRE_1() {
    Parser parser_EVN_BENTRE_1 = new Parser("DL BinhDai thong bao: Tien dien thang 6/2018 cua KH Khu Nuoi Tom 7 ha Binh Thang, Ma KH:PB09040000632, dien tieu thu 5 541KWH, tong ti", "EVN.BENTRE");
    	parser_EVN_BENTRE_1.clean_up();
    	parser_EVN_BENTRE_1.reduce_price_str();
    	assertEquals(parser_EVN_BENTRE_1.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_BENTRE_2() {
    Parser parser_EVN_BENTRE_2 = new Parser("DL BinhDai thong bao: Tien dien thang 6/2018 cua KH NTCN Le Vu Minh, Ma KH:PB09040038564, dien tieu thu 144KWH, tong tien 270 787VND.Tran trong!", "EVN.BENTRE");
    	parser_EVN_BENTRE_2.clean_up();
    	parser_EVN_BENTRE_2.reduce_price_str();
    	assertEquals(parser_EVN_BENTRE_2.convert_int(),270787);
    }
    
    @Test
    public void test_SEABANK_1() {
    Parser parser_SEABANK_1 = new Parser("SeABank: Date 05/06/2018 Account: 43000014365460 Change: -23,855 VND. Balance: 24,344,258 VND. Payee: PP07000724320-700197 Detail: tien dien thang 5 . .", "SeABank");
    	parser_SEABANK_1.clean_up();
    	parser_SEABANK_1.reduce_price_str();
    	assertEquals(parser_SEABANK_1.convert_int(),23855);
    }
    
    @Test
    public void test_SEABANK_2() {
    Parser parser_SEABANK_2 = new Parser("SeABank: Ngay 04/06/2018 TK: 10200014417193 Phat sinh: +3,200,000 VND. So du: 1,330,825 VND. Nguoi chuyen: BUI NGUYEN THUY PHUO. Noi dung: TIEN DIEN PGD Q10", "SeABank");
    	parser_SEABANK_2.clean_up();
    	parser_SEABANK_2.reduce_price_str();
    	assertEquals(parser_SEABANK_2.convert_int(),-1);
    }
    
    @Test
    public void test_EVN_BACLIEU_1() {
    Parser parser_EVN_BACLIEU_1 = new Parser("Thong bao tien dien khach hang Ho Thanh Quan: ky 1: Ma KH PB19040031769: thang 6/2018: dien tieu thu 6 KW; tong tien 10 223 dong", "EVN.BACLIEU");
    	parser_EVN_BACLIEU_1.clean_up();
    	parser_EVN_BACLIEU_1.reduce_price_str();
    	assertEquals(parser_EVN_BACLIEU_1.convert_int(),10223);
    }
    
    @Test
    public void test_EVN_BACLIEU_2() {
    Parser parser_EVN_BACLIEU_2 = new Parser("Tu 01/7/2018 - 28/9/2018, Quy KH chuyen sang tra tien dien qua NGAN HANG/THANH TOAN DIEN TU se co co hoi trung thuong 500.000 VND. Chi tiet xin goi 19009000", "EVN.BACLIEU");
    	parser_EVN_BACLIEU_2.clean_up();
    	parser_EVN_BACLIEU_2.reduce_price_str();
    	assertEquals(parser_EVN_BACLIEU_2.convert_int(),-1);
    }
    
    @Test
    public void test_GPBANK_1() {
    Parser parser_GPBANK_1 = new Parser("TK so 108...8949 co GD luc 15:20,4 6 2018.So tien: +6.340.000VND.Ly do: TIEN NHA T6.7. TIEN DIEN T5 B O: NGUYEN THIEN THAI.So du: +7.192.275VND", "GPBANK");
    	parser_GPBANK_1.clean_up();
    	parser_GPBANK_1.reduce_price_str();
    	assertEquals(parser_GPBANK_1.convert_int(),-1);
    }
    
    @Test
    public void test_GPBANK_2() {
    Parser parser_GPBANK_2 = new Parser("TK so 001...1452 co GD luc 20:55,6 6 2018.So tien: -290.473VND.Ly do: PD1200T450486 THANH TOAN TIEN DIEN T5.So du: +3.547.051VND", "GPBANK");
    	parser_GPBANK_2.clean_up();
    	parser_GPBANK_2.reduce_price_str();
    	assertEquals(parser_GPBANK_2.convert_int(),290473);
    }
    
    @Test
    public void test_SHINHANBANK_1() {
    Parser parser_SHINHANBANK_1 = new Parser("TAcc no. **5106 debit VND 36,734,939. Available balance: VND 2,612,189,340. DIEN LUC VIET YEN. TIEN DIEN , CONG SUAT PHAN KHANG KY", "SHINHANBANK");
    	parser_SHINHANBANK_1.clean_up();
    	parser_SHINHANBANK_1.reduce_price_str();
    	assertEquals(parser_SHINHANBANK_1.convert_int(),36734939);
    }
    
    @Test
    public void test_SHINHANBANK_2() {
    Parser parser_SHINHANBANK_2 = new Parser("TK **3896 thay doi  - VND 1,299,567. So du kha dung: VND 619,875,546.  . DOOJIN CONSTRUCTION TT TIEN DIEN NUOC THANG05.2018 CT1-1510 VUONG XUAN AN", "SHINHANBANK");
    	parser_SHINHANBANK_2.clean_up();
    	parser_SHINHANBANK_2.reduce_price_str();
    	assertEquals(parser_SHINHANBANK_2.convert_int(),1299567);
    }
    
    @Test
    public void test_EVN_H_GIANG_1() {
    Parser parser_EVN_H_GIANG_1 = new Parser("TDL Nga Bay tran trong thong bao tien dien T6/2018,KH:Nguyen Van Tho,Ma KH: PB20030005748, So tien :382 723d, DNTT: 202 kWh,Chi so cuoi", "EVN.H-GIANG");
    	parser_EVN_H_GIANG_1.clean_up();
    	parser_EVN_H_GIANG_1.reduce_price_str();
    	assertEquals(parser_EVN_H_GIANG_1.convert_int(),382723);
    }
    
    @Test
    public void test_EVN_H_GIANG_2() {
    Parser parser_EVN_H_GIANG_2 = new Parser("Thong bao tien dien T6/2018, KH: LE THANH HOA, ma KH: PB20010044789, so tien la : 164 395d, DNTT: 95 kWh, chi so cuoi ky: 19. Chi tiet lien he 19001006.", "EVN.H-GIANG");
    	parser_EVN_H_GIANG_2.clean_up();
    	parser_EVN_H_GIANG_2.reduce_price_str();
    	assertEquals(parser_EVN_H_GIANG_2.convert_int(),164395);
    }
    
    @Test
    public void test_APEC_1() {
    Parser parser_APEC_1 = new Parser("BQL Royal BN: TB thu tien dien R0419 tu 2/7-7/7 (8h-11h30,13h-17h)-so dien 55kwh -so tien 85450 vnd.Luu y: BQL thu tien mat, quy khach thong cam.Xin cam on.i", "APEC");
    	parser_APEC_1.clean_up();
    	parser_APEC_1.reduce_price_str();
    	assertEquals(parser_APEC_1.convert_int(),85450);
    }
    
    @Test
    public void test_HOMEMEE_1() {
    Parser parser_HOMEMEE_1 = new Parser("SVN thong bao: Thang 05/2018,  Can ho T2.06.07. Tien dien: 359181 d DSD:191);  Tien dien uu tien: 26740 d. Tong cong :385921 d. Tran trong!", "HOMEMEE");
    	parser_HOMEMEE_1.clean_up();
    	parser_HOMEMEE_1.reduce_price_str();
    	assertEquals(parser_HOMEMEE_1.convert_int(),359181);
    }
    
    @Test
    public void test_HDBANK_1() {
    Parser parser_HDBANK_1 = new Parser("HDBank TT tien dien khong du so du tai khoan. So tien no: 1790597VND. Quy khach vui long kiem tra TK de thanh toan.", "HDBank");
    	parser_HDBANK_1.clean_up();
    	parser_HDBANK_1.reduce_price_str();
    	assertEquals(parser_HDBANK_1.convert_int(),1790597);
    }
    
    @Test
    public void test_HDBANK_2() {
    Parser parser_HDBANK_2 = new Parser("Chi tiet giao dich: Giao dich thanh toan tien dien online. So OTP: 906382. Het han: 12/06/2018 11:13:31 AM", "HDBank");
    	parser_HDBANK_2.clean_up();
    	parser_HDBANK_2.reduce_price_str();
    	assertEquals(parser_HDBANK_2.convert_int(),-1);
    }
    
    @Test
    public void test_HDBANK_3() {
    Parser parser_HDBANK_3 = new Parser("TK 005704070017847 ngay 01/06/2018 09:08:32 RUT RA: 2,152,480VND SO DU: 485,413,210VND ND: CONG TY TNHH MISAMO VN THANH TOAN TIEN DIEN VA TIEN GIU XE 5.2018", "HDBank");
    	parser_HDBANK_3.clean_up();
    	parser_HDBANK_3.reduce_price_str();
    	assertEquals(parser_HDBANK_3.convert_int(),2152480);
    }
    
    @Test
    public void test_DIEN_ANDONG_1() {
    Parser parser_DIEN_ANDONG_1 = new Parser("TB: Thang 6/2018 tien dien KH Dang Dinh Phai la : 439351 VND. tuong ung: 224 so. Han nop 17 den 19 thang 6/2018. Tran trong!", "DIEN_ANDONG");
    	parser_DIEN_ANDONG_1.clean_up();
    	parser_DIEN_ANDONG_1.reduce_price_str();
    	assertEquals(parser_DIEN_ANDONG_1.convert_int(),439351);
    }
    
    @Test
    public void test_VIETABBANK_1() {
    Parser parser_VIETABANK_1 = new Parser("TK 5030000003149000; 15:03 05/06/2018; +4,761,286 VND; So du: 4,860,171 VND; ND:  VAB HO TT TIEN DIEN T5/2018 CUA PGD TRUNG TAM TU 13/047/2018 DEN 12/05/2018 TH", "VietABank");
    	parser_VIETABANK_1.clean_up();
    	parser_VIETABANK_1.reduce_price_str();
    	assertEquals(parser_VIETABANK_1.convert_int(),-1);
    }
    
    @Test
    public void test_SMS_NHO_1() {
    Parser parser_SMS_NHO_1 = new Parser("thang 05/2018 su dung 50 kWh, tien dien 85.195 d. Thanh toan truoc", "SMS NHO");
    	parser_SMS_NHO_1.clean_up();
    	parser_SMS_NHO_1.reduce_price_str();
    	assertEquals(parser_SMS_NHO_1.convert_int(),85195);
    }
     
    @Test
    public void test_SMS_NHO_2() {
    Parser parser_SMS_NHO_2 = new Parser("i noi dung \\TB(lan 2): PC03AA0220765 con no so tien dien 285604d.Qu\"", "SMS NHO");
    	parser_SMS_NHO_2.clean_up();
    	parser_SMS_NHO_2.reduce_price_str();
    	assertEquals(parser_SMS_NHO_2.convert_int(),285604);
    }
    
    @Test
    public void test_SMS_NHO_3() {
    Parser parser_SMS_NHO_3 = new Parser("18 voi noi dung \\DNC thong bao: Tien dien thang 6/2018 cua khach ha\"", "SMS NHO");
    	parser_SMS_NHO_3.clean_up();
    	parser_SMS_NHO_3.reduce_price_str();
    	assertEquals(parser_SMS_NHO_3.convert_int(),-1);
    }
     
}