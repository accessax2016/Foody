using System;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace FoodyServer.Controllers
{
    public class AnGiController : ApiController
    {
        public class MonAnCustom
        {
            public int id;
            public String TenMonAn;
            public Binary HinhAnh;
            public String TenQuan;
            public String DiaChi;
            public String TenDuong;
            public String TenQuanHuyen;
            public String TenThanhPho;
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGi()
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from monan in db.MonAns
                 join quanan in db.QuanAns on monan.MaQuanAn equals quanan.id
                 join duongquan in db.DuongPhos on quanan.MaDuong equals duongquan.MaDuong
                 join quanhuyen in db.QuanHuyens on duongquan.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 select new MonAnCustom
                 {
                     id = monan.MaMonAn,
                     TenMonAn = monan.TenMonAn,
                     HinhAnh = monan.HinhAnh,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     TenDuong = duongquan.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho                    
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGiTheoDanhMuc(string TenDanhMuc)
        {
            if (TenDanhMuc == "Danh mục")
                return GetAnGi();
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from monan in db.MonAns
                 join quanan in db.QuanAns on monan.MaQuanAn equals quanan.id
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where danhmuc.TenDanhMuc == TenDanhMuc
                 select new MonAnCustom
                 {
                     id = monan.MaMonAn,
                     TenMonAn = monan.TenMonAn,
                     HinhAnh = monan.HinhAnh,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGiTheoDuongPho(string TenDuong)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from monan in db.MonAns
                 join quanan in db.QuanAns on monan.MaQuanAn equals quanan.id
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where duongpho.TenDuong == TenDuong
                 select new MonAnCustom
                 {
                     id = monan.MaMonAn,
                     TenMonAn = monan.TenMonAn,
                     HinhAnh = monan.HinhAnh,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGiTheoQuanHuyen(string TenQuanHuyen)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from monan in db.MonAns
                 join quanan in db.QuanAns on monan.MaQuanAn equals quanan.id
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where quanhuyen.TenQuanHuyen == TenQuanHuyen
                 select new MonAnCustom
                 {
                     id = monan.MaMonAn,
                     TenMonAn = monan.TenMonAn,
                     HinhAnh = monan.HinhAnh,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGiTheoThanhPho(string TenThanhPho)
        {
            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from monan in db.MonAns
                 join quanan in db.QuanAns on monan.MaQuanAn equals quanan.id
                 join duongpho in db.DuongPhos on quanan.MaDuong equals duongpho.MaDuong
                 join quanhuyen in db.QuanHuyens on duongpho.MaQuan equals quanhuyen.id
                 join thanhpho in db.ThanhPhos on quanhuyen.MaTP equals thanhpho.id
                 join danhmuc in db.DanhMucs on quanan.MaDanhMuc equals danhmuc.MaDanhMuc
                 where thanhpho.TenThanhPho == TenThanhPho
                 select new MonAnCustom
                 {
                     id = monan.MaMonAn,
                     TenMonAn = monan.TenMonAn,
                     HinhAnh = monan.HinhAnh,
                     TenQuan = quanan.TenQuan,
                     DiaChi = quanan.DiaChi,
                     TenDuong = duongpho.TenDuong,
                     TenQuanHuyen = quanhuyen.TenQuanHuyen,
                     TenThanhPho = thanhpho.TenThanhPho
                 });
            return result.ToList();
        }
        [HttpGet]
        public List<MonAnCustom> GetAnGiList(string TenDanhMuc, string KieuDiaDiem, string TenDiaDiem)
        {
            List<MonAnCustom> monantheodanhmuc = new List<MonAnCustom>();
            if (TenDanhMuc == "Danh mục")
                monantheodanhmuc = GetAnGi();
            else
                monantheodanhmuc = GetAnGiTheoDanhMuc(TenDanhMuc);

            List<MonAnCustom> monantheodiadiem = new List<MonAnCustom>();
            switch (KieuDiaDiem)
            {
                case "ThanhPho":
                    monantheodiadiem = GetAnGiTheoThanhPho(TenDiaDiem);
                    break;
                case "QuanHuyen":
                    monantheodiadiem = GetAnGiTheoQuanHuyen(TenDiaDiem);
                    break;
                case "DuongPho":
                    monantheodiadiem = GetAnGiTheoDuongPho(TenDiaDiem);
                    break;
            }

            DBFoodyDataContext db = new DBFoodyDataContext();
            var result = (
                 from x in monantheodanhmuc
                 join y in monantheodiadiem on x.id equals y.id
                 select new MonAnCustom
                 {
                     id = x.id,
                     TenMonAn = x.TenMonAn,
                     HinhAnh = x.HinhAnh,
                     TenQuan = x.TenQuan,
                     DiaChi = x.DiaChi,
                     TenDuong = x.TenDuong,
                     TenQuanHuyen = x.TenQuanHuyen,
                     TenThanhPho = x.TenThanhPho
                 });
            return result.ToList();



        }
    }
}
